package main;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;

public final class Class_115 implements Runnable {
   private Thread var_b;
   private boolean var_4d = false;
   public Player[] var_7d;
   private Player var_c3;
   private Player var_105;
   private int var_117 = 1;
   private boolean var_128;
   public static boolean var_179 = false;
   public static boolean var_1ae = false;
   public int var_1ee;

   public Class_115(String[] var1) {
      this.var_7d = new Player[var1.length];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.var_7d[var2] = this.sub_48(var1[var2]);
      }

      this.var_128 = true;
      this.var_b = new Thread(this);
      this.var_b.setPriority(1);
      this.var_b.start();
   }

   public final void run() {
      while(this.var_128) {
         if (this.var_4d && this.sub_97(this.var_105)) {
            this.var_4d = false;
            this.var_105 = null;
         }

         Thread.yield();

         try {
            Thread.sleep(10L);
         } catch (InterruptedException var1) {
         }
      }

   }

   private Player sub_48(String var1) {
      Player var2 = null;
      int var3 = 0;
      String[] var4 = new String[]{"audio/midi", "audio/amr", "audio/x-wav", "audio/mmf"};

      for(String[] var5 = new String[]{".mid", ".amr", ".wav", ".mmf"}; var2 == null && var3 < var4.length; ++var3) {
         try {
            (var2 = Manager.createPlayer(this.getClass().getResourceAsStream(var1 + var5[var3]), var4[var3])).realize();
            var2.prefetch();
         } catch (Exception var6) {
         }
      }

      return var2;
   }

   public final void sub_8c(int var1, int var2) {
      if ((var_179 || var1 < 4) && (var_1ae || var1 >= 4) && this.var_7d[var1] != null) {
         this.var_1ee = var1;
         this.var_117 = var2;
         this.var_105 = this.var_7d[var1];
         this.var_4d = true;
      }
   }

   private boolean sub_97(Player var1) {
      this.sub_db();

      try {
         var1.setLoopCount(this.var_117);
         var1.start();
         this.var_c3 = var1;
         return true;
      } catch (Exception var2) {
         this.var_c3 = var1;
         this.sub_db();
         return false;
      }
   }

   public final void sub_db() {
      if (this.var_c3 != null) {
         if (this.var_c3.getState() == 400) {
            try {
               this.var_c3.stop();
            } catch (Exception var1) {
            }
         }

         this.var_c3 = null;
         this.var_4d = false;
      }

   }

   public final void sub_11b() {
      this.sub_db();
      this.var_128 = false;
      this.var_7d = null;

      try {
         this.var_b.join();
      } catch (Exception var1) {
      }

      this.var_b = null;
   }

   public final void sub_165(int var1) {
      byte var2;
      switch(var1) {
      case 0:
         var2 = 1;
         break;
      case 1:
         var2 = 5;
         break;
      case 2:
         var2 = 10;
         break;
      default:
         var2 = 1;
      }

      this.var_b.setPriority(var2);
   }
}
