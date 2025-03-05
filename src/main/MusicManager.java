package main;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;

public final class MusicManager implements Runnable {
   private Thread musicThread;
   private boolean isMusicPlaying = false;
   public Player[] musicPlayers;
   private Player musicPlayer;
   private Player musicPlayer2;
   private int musicPlayerLoopCount = 1;
   private boolean someMusicVar;
   public static boolean someMusicIndexVar = false;
   public static boolean someMusicIndexVar2 = false;
   public int currentPlayerIndex;

   public MusicManager(String[] musicNames) {
      this.musicPlayers = new Player[musicNames.length];

      for(int i = 0; i < musicNames.length; ++i) {
         this.musicPlayers[i] = this.createMusicPlayer(musicNames[i]);
      }

      this.someMusicVar = true;
      this.musicThread = new Thread(this);
      this.musicThread.setPriority(1);
      this.musicThread.start();
   }

   public final void run() {
      while(this.someMusicVar) {
         if (this.isMusicPlaying && this.setNewMusicPlayer(this.musicPlayer2)) {
            this.isMusicPlaying = false;
            this.musicPlayer2 = null;
         }

         Thread.yield();

         try {
            Thread.sleep(10L);
         } catch (InterruptedException var1) {
         }
      }

   }

   private Player createMusicPlayer(String musicName) {
      Player newPlayer = null;
      
      String[] audioTypes = new String[]{"audio/midi", "audio/amr", "audio/x-wav", "audio/mmf"};
      String[] audioFormats = new String[]{".mid", ".amr", ".wav", ".mmf"};
      
      for(int i = 0; newPlayer == null && i < audioTypes.length; ++i) {
         try {
            (newPlayer = Manager.createPlayer(this.getClass().getResourceAsStream(musicName + audioFormats[i]), audioTypes[i])).realize();
            newPlayer.prefetch();
         } catch (Exception e) {
         }
      }

      return newPlayer;
   }

   public final void switchMusicPlayer(int playerIndex, int newLoopCount) {
      if ((someMusicIndexVar || playerIndex < 4) && (someMusicIndexVar2 || playerIndex >= 4) && this.musicPlayers[playerIndex] != null) {
         this.currentPlayerIndex = playerIndex;
         this.musicPlayerLoopCount = newLoopCount;
         this.musicPlayer2 = this.musicPlayers[playerIndex];
         this.isMusicPlaying = true;
      }
   }

   private boolean setNewMusicPlayer(Player player) {
      this.clearCurrentMusicPlayer();

      try {
         player.setLoopCount(this.musicPlayerLoopCount);
         player.start();
         this.musicPlayer = player;
         return true;
      } catch (Exception e) {
         this.musicPlayer = player;
         this.clearCurrentMusicPlayer();
         return false;
      }
   }

   public final void clearCurrentMusicPlayer() {
      if (this.musicPlayer != null) {
         if (this.musicPlayer.getState() == 400) {
            try {
               this.musicPlayer.stop();
            } catch (Exception e) {
            }
         }

         this.musicPlayer = null;
         this.isMusicPlaying = false;
      }

   }

   public final void closeAllMusicPlayers() {
      this.clearCurrentMusicPlayer();
      this.someMusicVar = false;
      this.musicPlayers = null;

      try {
         this.musicThread.join();
      } catch (Exception e) {
      }

      this.musicThread = null;
   }

   public final void setPriorityLevel(int priorityLevel) {
      byte newPriority;
      switch(priorityLevel) {
      case 0:
         newPriority = 1;
         break;
      case 1:
         newPriority = 5;
         break;
      case 2:
         newPriority = 10;
         break;
      default:
         newPriority = 1;
      }

      this.musicThread.setPriority(newPriority);
   }
}
