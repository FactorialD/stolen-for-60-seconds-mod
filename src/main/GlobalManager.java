package main;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.rms.RecordStore;

public final class GlobalManager extends BaseGameManager implements Runnable, CommandListener {
   public static boolean var_46;
   public static byte var_80;
   public static byte var_91;
   private static byte var_b9;
   public static byte var_115;
   public static byte var_165;
   public static int var_17e;
   public static boolean var_1cd;
   public static boolean var_22b;
   public static byte gameState = -2;
   private static byte var_2b9 = -1;
   public static byte var_2f7;
   public static boolean needRepaint;
   public static Command var_392;
   public static Command var_3bb;
   public static MM mainMidlet;
   private static Thread var_463;
   private static boolean var_4b9;
   public static boolean var_511;
   public static MusicManager musicManager;
   public static byte gameMode;
   public static boolean var_5e0 = true;
   public static boolean var_5ed = true;
   public static boolean var_62c;
   public static boolean var_649;
   public static boolean var_6ac;
   public static boolean var_6bc;
   private static int var_6c8;
   private static int var_6d8;
   private static int var_729;
   private static int var_762;
   private static int var_798;
   private static int var_7d3;
   private static int var_7f5;
   private static int var_810;
   private static int var_870;
   private static int var_8a4;
   public static Thief var_900;
   public static int keyCodePressed = 999999;
   public static int var_9af = 999999;
   private static int var_9fe;
   private static Vector var_a60 = new Vector();
   public static int var_ab2;
   private static int var_afa;
   public static boolean var_b17 = false;
   private static final byte[][] var_b4c = new byte[][]{{2, 7, 4, 0}, {8, 1, 1, 5}, {2, 0, 8, 2}, {2, 5, 8, 4}, {2, 6, 3, 0}, {3, 6, 1, 6}, {4, 6, 5, 7}, {0, 7, 6, 7}, {8, 1, 8, 2}};
   private static final byte[][] var_b5a = new byte[][]{{6, 3, 3, 3}, {7, 4, 4, 4}, {5, 4, 5, 5}, {6, 0, 6, 6}};
   public static int cursorXCurrent;
   public static int var_bca;
   public static int cursorXTarget;
   public static int var_c60;
   public static byte var_ca0;
   public static int var_ce9;
   public static int var_d24;
   public static final Thief[] allThievesArray;
   public static final Vector selectedThieves;
   public static final Vector possibleThieves;
   public static byte levelId;
   public static final short[][] toolStats; // Цена, Вес, ID спрайта, ID действия/анимации
   private static final int var_dff;
   private static final byte[][] var_e17;
   public static int currentMoney;
   public static int var_e86;
   public static short var_ea3;
   public static Object[] var_eff;
   private static byte var_f0d;
   private static int var_f69;
   private static int var_f83;
   private static int var_fa9;
   public static short[] var_ff4;
   private static int var_102d;
   private static int var_105e;
   private static int var_109d;
   public static byte var_10c8;
   public static int var_10ea;
   public static byte var_10ff;
   private static final byte[] var_1123;
   public static byte var_114a;
   public static int var_1180;
   public static int var_11cf;
   public static byte var_1217;
   private static boolean var_123b;
   public static final boolean[] saveData;
   public static boolean var_12fc;
   private static Image var_130f;
   private static boolean var_1369;
   private static GlobalManager var_13a7;
   private static int var_13cf;
   public long var_13db;
   public Image var_1403;
   public Image var_1453;
   public int var_1493;
   public boolean var_14e2;
   private static int var_150d;
   private static int var_1566;
   private static boolean var_157e;

   public final void runGameThread() {
      if (!var_4b9) {
         var_511 = true;
         var_13a7 = this;
         if (gameState == -1) {
            gameState = var_2b9;
         } else {
            gameState = 0;
         }

         var_463 = null;
         var_4b9 = true;
         var_463 = new Thread(this);
         var_463.start();
         HackManager.callGc();
      }
   }

   public static void pauseGameThread() {
      if (gameState != -1) {
         if (gameState == 1 && LevelManager.gameState == 1) {
            LevelManager.var_96a = LevelManager.selectedThiefIndex;
            LevelManager.selectedThiefIndex = -1;
            keyCodePressed = 999999;
         }

         var_2b9 = gameState;
         var_4b9 = false;
         gameState = -1;
         needRepaint = false;
         if (musicManager != null) {
            musicManager.clearCurrentMusicPlayer();
         }

         HackManager.callGc();
      }
   }

   public static void sub_9b() {
      var_2b9 = gameState;
      var_4b9 = false;
      gameState = -1;
      if (musicManager != null) {
         musicManager.closeAllMusicPlayers();
      }

      var_463 = null;
      musicManager = null;
      HackManager.callGc();
   }

   private void sub_bd() {
      var_ca0 = 0;
      sub_e28();
      MusicManager.someMusicIndexVar2 = saveData[0];
      MusicManager.someMusicIndexVar = saveData[1];

      byte var1;
      for(var1 = 1; var1 <= 2; ++var1) {
         var_1cd = var_1cd || ReadingDrawingClass.sub_7ad(var1);
      }

      if (var_46) {
         this.setCommandListener(this);
      }

      createMusicManager();
      DialogManager.var_790 = this;
      LevelManager.instance = this;

      for(var1 = 0; var1 < 5; ++var1) {
         allThievesArray[var1] = new Thief(var1);
      }

      sub_ba6();
   }

   private static void createMusicManager() {
      musicManager = new MusicManager(new String[]{"/dat/menu", "/dat/plan", "/dat/rob", "/dat/tik", "/dat/fail", "/dat/succ", "/dat/alarm", "/dat/prison"});
      musicManager.setPriorityLevel(BaseGameManager.musicManagerPriorityLevel);
   }

   public final void paintGame(Graphics g) {
      if (g != null) {
         if (gameState != -1) {
            if (!var_22b) {
               switch(gameState) {
               case 0:
                  this.paintSplash(g);
                  break;
               case 1:
                  LevelManager.paint(g);
                  sub_167(g);
                  break;
               case 2:
                  DialogManager.sub_2c9(LevelManager.graphics, g);
                  break;
               case 3:
                  paintMenu(g);
                  sub_167(g);
                  break;
               case 4:
                  paintShop(g);
                  break;
               case 5:
                  g.setColor(192, 192, 192);
                  g.fillRect(0, 0, this.getWidth(), this.getHeight());
                  if (var_130f != null) {
                     g.drawImage(var_130f, this.getWidth() >> 1, this.getHeight() >> 1, 3);
                  }
               }

               sub_ddc(g);
               sub_b8e(g);
            }
         }
      }
   }

   private static void sub_167(Graphics var0) {
      if (var_6bc && !var_6ac && cursorXCurrent == cursorXTarget && var_bca == var_c60 && var_115 > 12) {
         DialogManager.sub_388(var0, LevelManager.screenWidth - LevelObjectData.spriteTypesArr[38][2] - 2, var_11cf - LevelObjectData.spriteTypesArr[9][3] + DialogManager.var_ac, 2, 5);
      }

   }

   public final void run() {
      long var1 = HackManager.currentTimeMillis();

      while(var_4b9) {
         if (!needRepaint) {
            if (var_13cf != -1 && var_13cf != this.getWidth() && gameState != 5) {
               var_2b9 = gameState;
               if (gameState == 1 && LevelManager.gameState == 1) {
                  LevelManager.var_96a = LevelManager.selectedThiefIndex;
                  LevelManager.selectedThiefIndex = -1;
                  keyCodePressed = 999999;
               }

               gameState = 5;

               var_130f = ReadingDrawingClass.loadImagePng("nor");
            }

            this.sub_1aa(var1);
            var1 = HackManager.currentTimeMillis();
            this.forceRepaint();
            this.var_13db = 60L - (HackManager.currentTimeMillis() - var1);
            if (this.var_13db < 0L) {
               this.var_13db = 1L;
            }

            threadSleep(this.var_13db);
         }
      }

   }

   public static void threadSleep(long millis) {
      try {
         Thread.sleep(millis);
      } catch (InterruptedException e) {
      }
   }

   private void sub_1aa(long var1) {
      var_17e = (int)((long)var_17e + (HackManager.currentTimeMillis() - var1));
      if (var_17e > 500) {
         var_17e = 0;
      }

      var_80 = (byte)Math.min(12 * var_17e / 500, 11);
      if (var_b9 != var_80) {
         var_b9 = var_80;
         byte var10000;
         if (++var_91 >= 12) {
            var_91 = 0;
            var10000 = var_165;
            var_165 = (byte)(var10000 + 1);
            if (var10000 >= 12) {
               var_165 = 1;
            }
         }

         var10000 = var_115;
         var_115 = (byte)(var10000 + 1);
         if (var10000 >= 24) {
            var_115 = 1;
         }

         switch(gameState) {
         case 0:
            this.sub_47c();
            break;
         case 1:
            LevelManager.sub_85b();
            LevelManager.updateGameLogic();
         case 2:
         default:
            break;
         case 3:
            sub_a5a();
            break;
         case 4:
            sub_836();
         }

         sub_e10();
         sub_b6d();
      }

   }

   public final void keyPressed(int var1) {
      if (!var_157e) {
         keyCodePressed = var1;
         switch(gameState) {
         case 0:
            sub_4b4();
            return;
         case 1:
            LevelManager.sub_896();
            if (LevelManager.gameState == 0) {
               LevelManager.sub_3d2();
               return;
            }
            break;
         case 2:
            DialogManager.sub_3ee();
            return;
         case 3:
            sub_a64();
            return;
         case 4:
            sub_892();
         }

      }
   }

   public final void keyReleased(int var1) {
      keyCodePressed = 999999;
   }

   public static boolean sub_1b8(byte var0, byte var1, byte var2, boolean var3) {
      if ((saveData[var0] || gameMode > -1) && !var3) {
         return false;
      } else {
         saveData[var0] = true;
         if (gameState == 3) {
            musicManager.switchMusicPlayer(3, -1);
         }

         showDialog((byte)42, var1 == -1 ? null : new byte[]{var1, var2}, (short)(2 + var0 - 3), (Object[])null, new short[]{126}, (short)135);
         ReadingDrawingClass.sub_7c6();
         return true;
      }
   }

   private static void sub_21a() {
      short[] var0 = new short[]{190, 209, 199};
      sub_22b((byte)3, (byte[])null, var0, ReadingDrawingClass.readTextFromLng((short)128), (byte)2);
   }

   public static void sub_22b(byte var0, byte[] var1, short[] var2, short[] var3, byte var4) {
      sub_260(var0, var1, var2, (Object[][])null, var3, var4);
   }

   private static void sub_260(byte var0, byte[] var1, short[] var2, Object[][] var3, short[] var4, byte var5) {
      if (var0 == 22) {
         DialogManager.var_c24 = true;
      }

      DialogManager.var_7c6 = 1;
      DialogManager.sub_23();
      DialogManager.var_7ed = var0;
      DialogManager.var_850 = var1;
      DialogManager.var_8ca = var2;
      DialogManager.var_914 = var3;
      DialogManager.var_882 = var4;
      DialogManager.var_89d = new short[var5];
      DialogManager.var_89d[0] = 126;
      if (var5 == 2) {
         DialogManager.var_89d[1] = 127;
      }

      sub_360();
   }

   private static void sub_29b(byte var0, byte[] var1, short[] var2, Object[][] var3, byte[][] var4, boolean[] var5, short var6, byte var7) {
      DialogManager.var_c2e = true;
      sub_2a5(var0, false, var1, var2, var3, var4, var5, var6, var7);
   }

   public static void sub_2a5(byte var0, boolean var1, byte[] var2, short[] var3, Object[][] var4, byte[][] var5, boolean[] var6, short var7, byte var8) {
      DialogManager.var_7c6 = 2;
      DialogManager.sub_23();
      DialogManager.var_7ed = var0;
      DialogManager.var_850 = var2;
      DialogManager.var_8ca = var3;
      DialogManager.var_914 = var4;
      DialogManager.sub_4bd(var7);
      DialogManager.var_abc = var5;
      DialogManager.var_a80 = var1;
      DialogManager.var_89d = new short[var8];
      DialogManager.var_89d[0] = 126;
      if (var8 == 2) {
         DialogManager.var_89d[1] = 127;
      }

      DialogManager.var_a44 = new boolean[var3.length];
      if (var6 != null) {
         HackManager.arrayCopy(var6, 0, DialogManager.var_a44, 0, var6.length);
      }

      sub_360();
   }

   public static void showDialog(byte var0, byte[] var1, short var2, Object[] var3, short[] var4, short var5) {
      DialogManager.var_7c6 = 0;
      DialogManager.sub_23();
      DialogManager.var_7ed = var0;
      DialogManager.var_89d = var4;
      DialogManager.sub_4bd(var5);
      DialogManager.sub_4ac(var2, var3);
      DialogManager.var_850 = var1;
      sub_360();
   }

   private static void sub_2db(byte var0, byte[] var1, short var2, Object[] var3, short[] var4, short var5, Object[] var6) {
      DialogManager.var_7c6 = 0;
      DialogManager.sub_23();
      DialogManager.var_7ed = var0;
      DialogManager.var_89d = var4;
      DialogManager.sub_4ea(var5, var6);
      DialogManager.sub_4ac(var2, var3);
      DialogManager.var_850 = var1;
      sub_360();
   }

   public static void sub_30c() {
      boolean var0 = false;
      byte var1 = gameState;
      DialogManager.var_c2e = false;
      DialogManager.var_c24 = false;
      if (var_2f7 == 1) {
         var0 = LevelManager.sub_9a0();
      } else if (var_2f7 == 0) {
         var0 = sub_4cc();
      } else if (var_2f7 == 3) {
         var0 = sub_bbb();
      }

      if (!var0 && gameState == var1) {
         gameState = var_2f7;
      }

      var_13a7.sub_3d3();
      keyCodePressed = 999999;
      HackManager.callGc();
   }

   private static void sub_360() {
      if (gameState != 2) {
         var_2f7 = gameState;
      }

      DialogManager.sub_6f();
      gameState = 2;
      var_ff4 = null;
   }

   private void sub_36d() {
      loadResourcesForState(2);
      this.sub_3d3();
      gameState = 3;
      var_5e0 = true;
      if (musicManager.currentPlayerIndex != 0 && var_ea3 != 9 && var_ea3 != 2) {
         musicManager.switchMusicPlayer(0, -1);
      }

   }

   public static void loadResourcesForState(int var0) {
      var_22b = true;
      switch(var0) {
      case 0:
         if (ReadingDrawingClass.mainImages[4] == null) {
            ReadingDrawingClass.mainImages[2] = null;
            ReadingDrawingClass.mainImages[3] = null;
            HackManager.callGc();
            threadSleep(100L);
            ReadingDrawingClass.loadMainImage(4);
            threadSleep(500L);
            ReadingDrawingClass.loadMainImage(5);
            threadSleep(500L);
            ReadingDrawingClass.loadMainImage(6);
            threadSleep(500L);
         }
         break;
      case 1:
         if (ReadingDrawingClass.mainImages[3] == null) {
            ReadingDrawingClass.mainImages[2] = null;
            ReadingDrawingClass.mainImages[4] = null;
            ReadingDrawingClass.mainImages[5] = null;
            ReadingDrawingClass.mainImages[6] = null;
            HackManager.callGc();
            threadSleep(50L);
            ReadingDrawingClass.loadMainImage(3);
            threadSleep(50L);
         }
         break;
      case 2:
         if (ReadingDrawingClass.mainImages[2] == null) {
            ReadingDrawingClass.mainImages[3] = null;
            ReadingDrawingClass.mainImages[4] = null;
            ReadingDrawingClass.mainImages[5] = null;
            ReadingDrawingClass.mainImages[6] = null;
            HackManager.callGc();
            threadSleep(50L);
            ReadingDrawingClass.loadMainImage(2);
            threadSleep(50L);
         }
      }

      HackManager.callGc();
      var_22b = false;
   }

   private void sub_3d3() {
      if (var_46) {
         this.removeCommand(var_3bb);
         this.removeCommand(var_392);
         if (gameState == 3) {
            var_3bb = new Command(ReadingDrawingClass.getTextById((short)258), 4, 1);
            var_392 = new Command(ReadingDrawingClass.getTextById((short)261), 1, 2);
            this.addCommand(var_3bb);
            this.addCommand(var_392);
            return;
         }

         if (gameState == 1) {
            var_392 = new Command(ReadingDrawingClass.getTextById((short)261), 1, 2);
            this.addCommand(var_392);
         }
      }

   }

   private static void sub_3f1() {
      var_511 = false;
      gameState = 0;
      var_114a = 25;
   }

   public final int sub_435(int var1) {
      var_9af = 999999;
      return this.mapInputToGameAction(var1);
   }

   public final void paintSplash(Graphics var1) {
      switch(var_114a) {
      case 0:
         var1.setColor(16777215);
         var1.fillRect(0, 0, 500, 500);
         var_1180 = LevelManager.screenWidth = this.getWidth();
         var_11cf = LevelManager.screenHeight = this.getHeight();
         ++var_114a;
         return;
      case 2:
         this.sub_531(var1);
         return;
      case 7:
      case 9:
      case 11:
      case 13:
      case 15:
      case 17:
      case 19:
      case 21:
      case 23:
         var1.setColor(16777215);
         ReadingDrawingClass.sub_20e(var1, 0, var_11cf - 4, (var_114a - 6 >> 1) * var_1180 / 9, 4, true, 11665470);
         ++var_114a;
         return;
      case 25:
         var1.setColor(0);
         var1.setClip(0, 0, var_1180, var_11cf);
         var1.fillRect(0, 0, var_1180, var_11cf);
         ReadingDrawingClass.drawSpriteNoOffset(var1, (byte)7, 0, var_ce9, var_d24);
         DialogManager.sub_29c(var1);
         ++var_114a;
      case 1:
      case 3:
      case 4:
      case 5:
      case 6:
      case 8:
      case 10:
      case 12:
      case 14:
      case 16:
      case 18:
      case 20:
      case 22:
      case 24:
      default:
      }
   }

   private void sub_47c() {
      switch(var_114a) {
      case 1:
         ++var_114a;
         //this.sub_57d("prov", (String)null, 16777215, 2000, true);
         //this.sub_57d("prov2", (String)null, 16777215, 2000, true);
         this.sub_57d("logo1", (String)null, 16777215, 2000, true);
         this.sub_57d("logo2", "title", 16777215, 2000, false);
         var_114a = 6;
         var_165 = 1;
         return;
      case 6:
      case 8:
         ReadingDrawingClass.loadMainImage(var_114a - 6 >> 1);
         ++var_114a;
         return;
      case 10:
         // MODDED: Load menu data before offsets are calculated
         ReadingDrawingClass.loadPlanningMenuData();
         // MODDED: Load Loot Configuration
         LevelManager.loadLootConfiguration();
         // MODDED: Load Thief Configuration
         LevelManager.loadThiefConfiguration();
    	  
         ReadingDrawingClass.loadMainImage(var_114a - 6 >> 1);
         // MODDED: Center the FULL image instead of the sprite using dynamic dimensions
         // Since ReadingDrawingClass updated spriteTypesArr[7] during loadMainImage,
         // we can now trust these dimensions.
         int bgWidth = LevelObjectData.spriteTypesArr[7][2];
         int bgHeight = LevelObjectData.spriteTypesArr[7][3];
         
         var_ce9 = (var_1180 - bgWidth) >> 1;
         var_d24 = (var_11cf - bgHeight) >> 1;

         LevelManager.var_cf = var_11cf - LevelObjectData.spriteTypesArr[9][3];
         
         if (var_11cf < 120) {
            var_d24 += 10;
         }

         int var1;
         for(var1 = 0; var1 < LevelObjectData.var_65.length; ++var1) {
            int[] var10000 = LevelObjectData.var_65[var1];
            var10000[0] += var_ce9;
            var10000 = LevelObjectData.var_65[var1];
            var10000[1] += var_d24;
         }

         for(var1 = 0; var1 < LevelObjectData.var_9d.length; ++var1) {
            short[] var3 = LevelObjectData.var_9d[var1];
            var3[0] = (short)(var3[0] + var_ce9);
            var3 = LevelObjectData.var_9d[var1];
            var3[1] = (short)(var3[1] + var_d24);
         }

         var_ca0 = 0;
         cursorXTarget = LevelObjectData.var_65[var_ca0][0];
         var_c60 = LevelObjectData.var_65[var_ca0][1];
         ++var_114a;
         return;
      case 12:
      case 14:
      case 16:
         ++var_114a;
         return;
      case 18:
         ReadingDrawingClass.readCharactersFromLng();

         try {
            var_13cf = Integer.parseInt(ReadingDrawingClass.getTextById((short)276));
         } catch (NumberFormatException var2) {
         }

         ++var_114a;
         return;
      case 20:
         LevelManager.var_25f = Image.createImage(LevelManager.screenWidth, LevelManager.screenHeight);
         LevelManager.graphics = LevelManager.var_25f.getGraphics();
         LevelManager.sub_1aa();
         ++var_114a;
         return;
      case 22:
         var_13a7.sub_bd();
         ++var_114a;
         return;
      case 24:
         ++var_114a;
         return;
      case 26:
         sub_611();
      case 2:
      case 3:
      case 4:
      case 5:
      case 7:
      case 9:
      case 11:
      case 13:
      case 15:
      case 17:
      case 19:
      case 21:
      case 23:
      case 25:
      default:
      }
   }

   private static void sub_4b4() {
      if (keyCodePressed != 999999) {
         keyCodePressed = 999999;
         switch(var_114a) {
         case 2:
         case 5:
            ++var_114a;
         default:
         }
      }
   }

   private static boolean sub_4cc() {
      switch(DialogManager.var_7ed) {
      case 4:
         sub_670();
         if (MusicManager.someMusicIndexVar2 != saveData[0]) {
            MusicManager.someMusicIndexVar2 = saveData[0];
            if (!MusicManager.someMusicIndexVar2) {
               musicManager.clearCurrentMusicPlayer();
            }
         }

         MusicManager.someMusicIndexVar = saveData[1];
         sub_6dd();
         return true;
      case 21:
         sub_6dd();
         return true;
      case 22:
         switch(((Short)DialogManager.var_838).shortValue()) {
         case 200:
            if (var_1cd) {
               sub_22b((byte)27, (byte[])null, new short[]{193, 194}, ReadingDrawingClass.readTextFromLng((short)130), (byte)2);
            } else {
               sub_22b((byte)37, (byte[])null, new short[]{201, 195, 196, 197}, ReadingDrawingClass.readTextFromLng((short)198), (byte)2);
            }

            return true;
         case 201:
         case 206:
         case 207:
         default:
            break;
         case 202:
            showDialog((byte)21, (byte[])null, (short)144, new Object[]{MM.gameVersion}, new short[]{126}, (short)202);
            return true;
         case 203:
            sub_707();
            return true;
         case 204:
            showDialog((byte)44, (byte[])null, (short)145, new Object[]{MM.gameVersion}, new short[]{126, 127}, (short)204);
            return true;
         case 205:
            showDialog((byte)43, (byte[])null, (short)145, new Object[]{MM.gameVersion}, new short[]{126, 127}, (short)205);
            return true;
         case 208:
            sub_682();
            return true;
         case 209:
            showDialog((byte)0, (byte[])null, (short)8, (Object[])null, new short[]{126}, (short)135);
            return true;
         case 210:
            sub_76b();
            return true;
         case 211:
            var_511 = false;
            mainMidlet.destroyApp(false);
            return true;
         }
      default:
         return false;
      case 27:
         if (DialogManager.var_838 == null) {
            sub_6dd();
            return true;
         } else {
            switch(((Short)DialogManager.var_838).shortValue()) {
            case 193:
               ReadingDrawingClass.sub_6da();
               ReadingDrawingClass.sub_8ce();
               var_1217 = 3;
            default:
               return true;
            case 194:
               sub_22b((byte)37, (byte[])null, new short[]{201, 195, 196, 197}, ReadingDrawingClass.readTextFromLng((short)198), (byte)2);
               return true;
            }
         }
      case 37:
         if (DialogManager.var_838 == null) {
            sub_6dd();
            return true;
         }

         switch(((Short)DialogManager.var_838).shortValue()) {
         case 195:
            gameMode = 0;
            break;
         case 196:
            gameMode = 1;
            break;
         case 197:
            gameMode = 2;
         case 198:
         case 199:
         case 200:
         default:
            break;
         case 201:
            gameMode = -1;
         }

         sub_4f8();
         return true;
      case 43:
         if (DialogManager.var_838.equals(String.valueOf(126))) {
            if (BaseGameManager.openMoreGames()) {
               var_511 = false;
               mainMidlet.destroyApp(false);
               return true;
            }

            sub_6dd();
         } else {
            sub_6dd();
         }

         return true;
      case 44:
         if (DialogManager.var_838.equals(String.valueOf(126))) {
            if (BaseGameManager.openHerocraftLink()) {
               var_511 = false;
               mainMidlet.destroyApp(false);
               return true;
            }

            sub_6dd();
         } else {
            sub_6dd();
         }

         return true;
      case 45:
         if (DialogManager.var_838 == null) {
            sub_6dd();
            return true;
         } else {
            switch(((Short)DialogManager.var_838).shortValue()) {
            case 214:
               var_ab2 = -1;
               initShop();
               return true;
            case 215:
               sub_5d0();
               var_ab2 = -1;
               initShop();
               return true;
            case 216:
               var_1217 = 4;
               return true;
            default:
               return true;
            }
         }
      }
   }

   private static void sub_4f8() {
      ReadingDrawingClass.sub_759();
      levelId = -1;
      var_10ff = 3;
      currentMoney = gameMode == -1 ? 50 : 4000;
      loadLevel((byte)(gameMode == -1 ? 1 : 7));
      ReadingDrawingClass.sub_6f5();
      ReadingDrawingClass.sub_837();
   }

   private void sub_531(Graphics var1) {
      if (this.var_1403 != null) {
         var1.setColor(this.var_1493);
         var1.fillRect(0, 0, var_1180, var_11cf);
         if (this.var_14e2) {
            var1.drawImage(this.var_1403, var_1180 - this.var_1403.getWidth() >> 1, var_11cf - this.var_1403.getHeight() >> 1, 0);
         } else {
            var1.drawImage(this.var_1403, var_1180 - this.var_1403.getWidth() >> 1, 0, 20);
         }

         if (this.var_1453 != null) {
            var1.drawImage(this.var_1453, var_1180, 0, 24);
            return;
         }
      } else {
         var1.setColor(192, 192, 192);
         var1.fillRect(0, 0, var_1180, var_11cf);
         if (this.var_1453 != null) {
            var1.drawImage(this.var_1453, var_1180 >> 1, var_11cf >> 1, 3);
         }
      }

   }

   private void sub_57d(String var1, String var2, int var3, int var4, boolean var5) {
      if (var1 != null) {
	    this.var_1403 = ReadingDrawingClass.loadImagePng(var1);
	 }

      if (var2 != null) {
	    this.var_1453 = ReadingDrawingClass.loadImagePng(var2);
	 }

      if (this.var_1403 != null || this.var_1453 != null) {
         this.var_14e2 = var5;
         if (!this.var_14e2 && this.var_1403 != null && this.var_1403.getHeight() > 500) {
            this.var_14e2 = true;
         }

         this.var_1493 = var3;
         this.forceRepaint();
         threadSleep((long)var4);
         this.var_1403 = null;
         this.var_1453 = null;
         HackManager.callGc();
      }
   }

   private static void sub_5d0() {
      ReadingDrawingClass.sub_7ec(new short[][]{ReadingDrawingClass.readTextFromLng((short)251), ReadingDrawingClass.readTextFromLng((short)252), ReadingDrawingClass.readTextFromLng((short)253), ReadingDrawingClass.readTextFromLng((short)254), ReadingDrawingClass.readTextFromLng((short)255)}, new int[]{100000, 50000, 30000, 20000, 10000});
   }

   private static void sub_611() {
      var_130f = null;
      if (var_1369) {
         sub_5d0();
         if (ReadingDrawingClass.useSystemFont) {
            sub_6dd();
         } else {
            sub_76b();
         }

         var_1369 = false;
      } else {
         sub_6dd();
      }

      HackManager.callGc();
   }

   private static void sub_670() {
      if (DialogManager.var_838 != null) {
         String var0 = (String)DialogManager.var_838;

         for(byte var1 = 1; var1 <= 2; ++var1) {
            saveData[var1 - 1] = "true".equals(ReadingDrawingClass.sub_1f4(var0, var1));
         }

         ReadingDrawingClass.sub_7c6();
      }

   }

   private static void sub_682() {
      short[] var0 = new short[]{213, 212};
      sub_2a5((byte)4, true, (byte[])null, var0, (Object[][])null, (byte[][])null, new boolean[]{saveData[0], saveData[1]}, (short)208, (byte)2);
   }

   private static void sub_6dd() {
      int var1 = 9;
      if (!BaseGameManager.allowOpenLinks) {
         var1 -= 2;
      }

      if (ReadingDrawingClass.useSystemFont) {
         --var1;
      }

      short[] var0;
      (var0 = new short[var1])[0] = 200;
      var0[1] = 208;
      var0[2] = 209;
      var1 = 3;
      if (!ReadingDrawingClass.useSystemFont) {
         ++var1;
         var0[3] = 210;
      }

      var0[var1++] = 203;
      var0[var1++] = 202;
      if (BaseGameManager.allowOpenLinks) {
         var0[var1++] = 204;
         var0[var1++] = 205;
      }

      var0[var1] = 211;
      var_114a = 25;
      sub_22b((byte)22, (byte[])null, var0, ReadingDrawingClass.readTextFromLng((short)129), (byte)1);
   }

   private static void sub_707() {
      short[] var0;
      if (var_b17) {
         var0 = new short[]{214, 215, 216};
      } else {
         var0 = new short[]{214, 215};
      }

      var_114a = 25;
      sub_22b((byte)45, (byte[])null, var0, ReadingDrawingClass.readTextFromLng((short)203), (byte)2);
   }

   private static void sub_76b() {
      var_114a = 25;
      showDialog((byte)21, new byte[]{5, 6}, (short)1, (Object[])null, new short[]{126}, (short)210);
   }

   public static void initShop() {
      loadResourcesForState(2);
      var_a60 = ReadingDrawingClass.sub_80d();
      var_150d = (LevelManager.var_cf >> 1) - (6 * (ReadingDrawingClass.var_a9 + 3) >> 1);
      var_1566 = var_150d + ReadingDrawingClass.var_a9 + 3;
      if (var_ab2 > -1) {
         var_ab2 = -1;

         for(int var0 = 0; var0 < 5; ++var0) {
            if (((int[])((int[])var_a60.elementAt(1)))[var0] < currentMoney) {
               var_ab2 = var0;

               for(int var1 = 3; var1 >= var_ab2; --var1) {
                  ((short[][])((short[][])var_a60.elementAt(0)))[var1 + 1] = ((short[][])((short[][])var_a60.elementAt(0)))[var1];
                  ((short[][])((short[][])var_a60.elementAt(1)))[var1 + 1] = ((short[][])((short[][])var_a60.elementAt(1)))[var1];
               }

               ((short[][])((short[][])var_a60.elementAt(0)))[var_ab2] = ReadingDrawingClass.readTextFromLng((short)207);
               ((int[])((int[])var_a60.elementAt(1)))[var0] = currentMoney;
               var_afa = 0;
               break;
            }
         }
      }

      gameState = 4;
      var_5ed = true;
   }

   private static void paintShop(Graphics g) {
      needRepaint = true;
      int var2 = 16 * ReadingDrawingClass.var_12;
      int var3 = (var_1180 >> 1) - (var2 >> 1);
      int var1;
      int var4;
      if (var_5ed) {
         short[][] var5 = (short[][])((short[][])var_a60.elementAt(0));
         int[] var6 = (int[])((int[])var_a60.elementAt(1));
         if (var_ce9 > 0 || var_d24 > LevelObjectData.spriteTypesArr[28][3]) {
            LevelManager.graphics.setColor(0);
            LevelManager.graphics.setClip(0, 0, var_1180, var_11cf);
            LevelManager.graphics.fillRect(0, 0, var_1180, var_11cf);
         }

         ReadingDrawingClass.drawSpriteNoOffset(LevelManager.graphics, (byte)7, 0, var_ce9, var_d24);
         DialogManager.sub_29c(LevelManager.graphics);
         ReadingDrawingClass.sub_47c(LevelManager.graphics, ReadingDrawingClass.readTextFromLng((short)203), (var_1180 >> 1) - (ReadingDrawingClass.readTextFromLng((short)203).length * ReadingDrawingClass.var_12 >> 1), var_150d);
         var1 = var_1566;

         for(int var7 = 0; var7 < 5; ++var7) {
            if (var_ab2 != var7) {
               ReadingDrawingClass.sub_47c(LevelManager.graphics, var5[var7], var3, var1);
            }

            var4 = var3 + var2 - String.valueOf(var6[var7]).length() * ReadingDrawingClass.var_12;
            ReadingDrawingClass.sub_46a(LevelManager.graphics, "$", var4 - ReadingDrawingClass.var_12, var1);
            ReadingDrawingClass.sub_46a(LevelManager.graphics, String.valueOf(var6[var7]), var4, var1);
            var1 += ReadingDrawingClass.var_a9 + 3;
         }

         DialogManager.var_89d = new short[]{126};
         DialogManager.sub_36c(LevelManager.graphics);
         var_5ed = false;
      }

      g.drawImage(LevelManager.var_25f, 0, 0, 0);
      var1 = var_1566;
      if (var_ab2 >= 0) {
         label42:
         for(var4 = 0; var4 < 5; ++var4) {
            if (var_ab2 == var4) {
               ReadingDrawingClass.sub_47c(g, ((short[][])((short[][])var_a60.elementAt(0)))[var4], var3, var1);
               int var8 = 0;

               while(true) {
                  if (var8 >= 5) {
                     break label42;
                  }

                  if (var8 == var_afa && var_115 > 12) {
                     ReadingDrawingClass.sub_47c(g, ReadingDrawingClass.readTextFromLng((short)256), var3 + var8 * ReadingDrawingClass.var_12, var1 + 2);
                  }

                  ++var8;
               }
            }

            var1 += ReadingDrawingClass.var_a9 + 3;
         }
      }

      needRepaint = false;
   }

   private static void sub_836() {
      if ((var_80 == 0 || var_80 == 6) && var_165 > 2) {
         sub_892();
         var_165 = 3;
      }

   }

   private static void sub_892() {
      var_165 = 1;
      int var0;
      if ((var0 = var_13a7.mapInputToGameAction(keyCodePressed)) == 12 || var0 == 0) {
         if (var_ab2 >= 0) {
            ReadingDrawingClass.sub_7ec((short[][])((short[][])var_a60.elementAt(0)), (int[])((int[])var_a60.elementAt(1)));
         }

         sub_3f1();
      }

      if (var_ab2 >= 0) {
         switch(var0) {
         case 2:
            --((short[][])((short[][])var_a60.elementAt(0)))[var_ab2][var_afa];
            break;
         case 3:
            ++((short[][])((short[][])var_a60.elementAt(0)))[var_ab2][var_afa];
            break;
         case 4:
            --var_afa;
            break;
         case 5:
            ++var_afa;
         }

         var_afa = Math.max(0, Math.min(var_afa, 4));
         if (((short[][])((short[][])var_a60.elementAt(0)))[var_ab2][var_afa] > 52) {
            ((short[][])((short[][])var_a60.elementAt(0)))[var_ab2][var_afa] = 0;
         }

         if (((short[][])((short[][])var_a60.elementAt(0)))[var_ab2][var_afa] < 0) {
            ((short[][])((short[][])var_a60.elementAt(0)))[var_ab2][var_afa] = 52;
         }

      }
   }

   private static void paintMenu(Graphics g) {
      needRepaint = true;
      if (var_5e0 && (var_ce9 > 0 || var_d24 > LevelObjectData.spriteTypesArr[28][3])) {
         LevelManager.graphics.setColor(0);
         LevelManager.graphics.setClip(0, 0, var_1180, var_11cf);
         LevelManager.graphics.fillRect(0, 0, var_1180, var_11cf);
      }

      sub_8f3(g);
      ReadingDrawingClass.drawSpriteNoOffset(g, (byte)40, 0, cursorXCurrent, var_bca);
      if (var_6bc && var_115 > 12) {
         ReadingDrawingClass.drawSpriteNoOffset(g, (byte)39, 2, cursorXCurrent + LevelObjectData.spriteTypesArr[40][2], var_bca);
      }

      sub_94f(g, cursorXCurrent, var_bca, true);
      needRepaint = false;
   }

   private static void sub_8f3(Graphics var0) {
      if (var_5e0) {
         boolean var1 = false;
         // MODDED: Draw sprite 7 directly. ReadingDrawingClass handles dynamic size and split image lookup.
         // No more hardcoded clipping or mainImages[2] usage.
         ReadingDrawingClass.drawSpriteNoOffset(LevelManager.graphics, (byte)7, 0, var_ce9, var_d24);

         // Loop 1 to 4 first
         for(int var2 = 1; var2 < 5; ++var2) {
            if (!selectedThieves.contains(allThievesArray[var2]) && LevelManager.levelAdditionalData_TimerEtc[levelId - 1][6 + var2] == 1) {
               ReadingDrawingClass.drawSpriteNoOffset(LevelManager.graphics, (byte)(34 + var2 - 1), 0, LevelObjectData.var_9d[var2][0], LevelObjectData.var_9d[var2][1]);
            }

            if (LevelManager.thievesList.contains(allThievesArray[var2])) {
               ReadingDrawingClass.drawSpriteNoOffset(LevelManager.graphics, (byte)39, 0, LevelObjectData.var_65[(short)(2 + var2)][0] - (LevelObjectData.spriteTypesArr[39][2] >> 1), LevelObjectData.var_65[(short)(2 + var2)][1]);
            }
         }
         
         // Draw Chief (Thief 0) separately
         boolean chiefAllowed = gameMode > -1 || LevelManager.allowChief;
         if (!selectedThieves.contains(allThievesArray[0]) && chiefAllowed) {
             ReadingDrawingClass.drawSpriteNoOffset(LevelManager.graphics, (byte)52, 0, LevelObjectData.var_9d[0][0], LevelObjectData.var_9d[0][1]);
         }
         if (LevelManager.thievesList.contains(allThievesArray[0])) {
             ReadingDrawingClass.drawSpriteNoOffset(LevelManager.graphics, (byte)39, 0, LevelObjectData.var_65[2][0] - (LevelObjectData.spriteTypesArr[39][2] >> 1), LevelObjectData.var_65[2][1]);
         }

         ReadingDrawingClass.drawSpriteNoOffset(LevelManager.graphics, (byte)29, 0, 0, 0);
         LevelObjectData.var_65[8][0] = LevelObjectData.spriteTypesArr[29][2] >> 1;
         LevelObjectData.var_65[8][1] = LevelObjectData.spriteTypesArr[29][3] >> 1;

         for(int var3 = 0 + LevelObjectData.spriteTypesArr[29][2]; var3 < var_1180 - LevelObjectData.spriteTypesArr[30][2]; var3 += LevelObjectData.spriteTypesArr[28][2]) {
            ReadingDrawingClass.drawSpriteNoOffset(LevelManager.graphics, (byte)28, 0, var3, 0);
         }

         ReadingDrawingClass.drawSpriteNoOffset(LevelManager.graphics, (byte)30, 0, var_1180 - LevelObjectData.spriteTypesArr[30][2], 0);
         LevelObjectData.var_65[1][0] = var_1180 - (LevelObjectData.spriteTypesArr[30][2] >> 1);
         LevelObjectData.var_65[1][1] = LevelObjectData.spriteTypesArr[30][3] >> 1;
         
         // MODDED: FIX for large backgrounds covering bottom GUI
         // Force draw the bottom panel background strip (Sprite 9) unconditionally on top of everything
         int bottomY = var_11cf - LevelObjectData.spriteTypesArr[9][3];
         for(int x = 0; x < var_1180; x += LevelObjectData.spriteTypesArr[9][2]) {
             ReadingDrawingClass.drawSpriteNoOffset(LevelManager.graphics, (byte)9, 0, x, bottomY);
         }
         
         sub_96d(LevelManager.graphics);
         sub_9cc(LevelManager.graphics);
         var_62c = true;
      }

      var_5e0 = false;
      if (var_649) {
         drawShopScreen(LevelManager.graphics);
      }

      var_649 = false;
      if (var_62c && (var_ca0 == 3 || var_ca0 == 4 || var_ca0 == 5 || var_ca0 == 6 || var_ca0 == 2)) {
         LevelManager.selectedThief = var_900;
         LevelManager.sub_2df(LevelManager.graphics, true);
         var_62c = false;
      }

      var0.drawImage(LevelManager.var_25f, 0, 0, 0);
   }

   public static void sub_94f(Graphics var0, int var1, int var2, boolean var3) {
      if (var_12fc) {
         if (!var3 || var1 == cursorXTarget && var2 == var_c60) {
            if (var_ff4 != null) {
               int var4 = var2 > 60 ? -14 : 14;
               int var5 = var2;
               int var6 = var1;

               int var7;
               for(var7 = 2; var7 > -1; --var7) {
                  var6 += (var_1180 >> 1) - var6 >> 1;
                  var5 += var4;
                  ReadingDrawingClass.drawSpriteNoOffset(var0, (byte)(15 + var7), 0, var6 - (LevelObjectData.spriteTypesArr[15 + var7][2] >> 1), var5 - (LevelObjectData.spriteTypesArr[15 + var7][3] >> 1));
               }

               var6 = (var_1180 >> 1) - (7 * LevelObjectData.spriteTypesArr[18][2] >> 1);
               var5 += var4 - (LevelObjectData.spriteTypesArr[3][3] >> 1);
               var_102d = var6;
               var_105e = var5 + (LevelObjectData.spriteTypesArr[3][3] - ReadingDrawingClass.var_a9 >> 1);
               var_109d = 7 * LevelObjectData.spriteTypesArr[18][2];
               if (var_10ea > var_102d + var_109d) {
                  var_10ea = var_102d + var_109d;
               }

               ReadingDrawingClass.drawSpriteNoOffset(var0, (byte)3, 0, var6 - (LevelObjectData.spriteTypesArr[3][2] >> 1), var5);
               ReadingDrawingClass.drawSpriteNoOffset(var0, (byte)3, 0, var6 + 7 * LevelObjectData.spriteTypesArr[18][2] - (LevelObjectData.spriteTypesArr[3][2] >> 1), var5);

               for(var7 = 0; var7 < 7; ++var7) {
                  ReadingDrawingClass.drawSpriteNoOffset(var0, (byte)18, 0, var6, var5);
                  var6 += LevelObjectData.spriteTypesArr[18][2];
               }

            }
         }
      }
   }

   private static void sub_96d(Graphics var0) {
      short[] var1;
      int var2 = (var1 = ReadingDrawingClass.sub_533(String.valueOf(currentMoney))).length * ReadingDrawingClass.var_12;
      int var3 = LevelObjectData.spriteTypesArr[29][2] + 2;
      int var4 = var_1180 - LevelObjectData.spriteTypesArr[30][2] - 2 - LevelObjectData.spriteTypesArr[31][2];
      int var5 = LevelObjectData.spriteTypesArr[28][3] - LevelObjectData.spriteTypesArr[32][3] - 1 >> 1;
      int var6 = var3 + LevelObjectData.spriteTypesArr[31][2] - 1;
      int var7 = var5 + (LevelObjectData.spriteTypesArr[32][3] - ReadingDrawingClass.var_a9 >> 1);
      ReadingDrawingClass.drawSpriteNoOffset(LevelManager.graphics, (byte)31, 0, var3, var5);
      if (var3 + 1 < var4) {
         boolean var8 = var4 - var3 > LevelObjectData.spriteTypesArr[31][2];
         ReadingDrawingClass.drawSpriteNoOffset(LevelManager.graphics, (byte)31, 0, var4, var5);
         ReadingDrawingClass.drawSpriteNoOffset(LevelManager.graphics, (byte)32, 0, var4, var5);
         var6 = var4 + LevelObjectData.spriteTypesArr[31][2] - 1;

         for(var3 = var4 - LevelObjectData.spriteTypesArr[32][2]; var3 > LevelObjectData.spriteTypesArr[29][2] + 2; var3 -= LevelObjectData.spriteTypesArr[32][2]) {
            ReadingDrawingClass.drawSpriteNoOffset(LevelManager.graphics, (byte)32, 0, var3, var5);
         }

         if (var8) {
            ReadingDrawingClass.drawSpriteNoOffset(LevelManager.graphics, (byte)33, 0, LevelObjectData.spriteTypesArr[29][2] + 4, var7);
         }
      }

      ReadingDrawingClass.sub_47c(var0, var1, var6 - var2, var7 + 1);
   }

   private static void sub_9cc(Graphics var0) {
      if (gameMode > 0) {
         int var1 = var_11cf - ReadingDrawingClass.var_a9 - 3;
         boolean var2 = false;
         ReadingDrawingClass.sub_47c(var0, ReadingDrawingClass.readTextFromLng((short)260), 3, var1);
         int var3 = 3 + ReadingDrawingClass.var_12;
         ReadingDrawingClass.sub_46a(var0, String.valueOf(var_10ff), var3, var1);
      }
   }

   private static void drawShopScreen(Graphics g) {
      int var2 = ReadingDrawingClass.var_a9 + 2;
      var_7d3 = var_11cf < 111 ? 0 : (var_11cf < 161 ? 1 : (var_11cf < 221 ? 2 : 3));
      var_798 = var_1180 < 121 ? -1 : (var_1180 < 133 ? 0 : (var_1180 < 180 ? 2 : 3));
      int var3 = 6 * (LevelObjectData.spriteTypesArr[26][2] + var_798) + 6 + 2 + var_798;
      int var4 = var2 + (var_7d3 << 1) + 6 + 2 + var_7d3 + LevelObjectData.spriteTypesArr[26][3] * toolStats.length / 6;
      boolean var5 = var_11cf - LevelObjectData.spriteTypesArr[9][3] - LevelObjectData.spriteTypesArr[28][3] > var4;
      var4 += var5 ? LevelObjectData.spriteTypesArr[38][3] + var_7d3 : 0;
      int var6 = (var_1180 >> 1) - (var3 >> 1);
      int var7 = (var_11cf + LevelObjectData.spriteTypesArr[28][3] - LevelObjectData.spriteTypesArr[24][3] >> 1) - (var4 >> 1);
      var_729 = var6 + var_798 + 3 + 1;
      var_762 = var7 + var_7d3 + 3 + 1 + var2;
      var_7f5 = var6 + 3 + 2;
      var_810 = var7 + 3 + 1;
      var_870 = var3 - 8;
      int var8 = 0;
      int var9 = 0;
      DialogManager.sub_25f(g, var6, var7, var3, var4, 3, var2, true);

      int var12;
      int var13;
      for(var12 = 0; var12 < var_dff; ++var12) {
         for(var13 = 0; var13 < 6; ++var13) {
            var_e17[var13][var12] = 116;
         }
      }

      for(byte var15 = 0; var15 < toolStats.length; ++var15) {
         byte var16 = (byte)LevelManager.sub_bc9(var15);
         var_e17[var8][var9] = var16;
         int var10 = var_729 + var8 * (LevelObjectData.spriteTypesArr[26][2] + var_798);
         int var11 = var_762 + var9 * (LevelObjectData.spriteTypesArr[26][3] + var_7d3);
         ReadingDrawingClass.drawSpriteNoOffset(g, (byte)26, 0, var10, var11);
         ReadingDrawingClass.drawSpriteNoOffset(g, (byte)8, (byte)toolStats[var15][2], var10 + 2, var11 + 2);
         if (var_900.inventoryTools[0] != var16 && var_900.inventoryTools[1] != var16 && var_900.inventoryTools[2] != var16) {
            if (toolStats[var15][0] > currentMoney || LevelManager.levelAdditionalData_TimerEtc[levelId - 1][13 + sub_e5c(var16)] == 0) {
               ReadingDrawingClass.drawSpriteNoOffset(g, (byte)41, 0, var10 + 2, var11 + 2);
            }
         } else {
            ReadingDrawingClass.drawSpriteNoOffset(g, (byte)39, 0, var10, var11);
         }

         if (var8 >= 5) {
            ++var9;
            var8 = 0;
         } else {
            ++var8;
         }
      }

      if (var5) {
         var12 = var_762 + var9 * (LevelObjectData.spriteTypesArr[26][3] + var_7d3);
         var13 = var6 + var3 - 3 - 1 - LevelObjectData.spriteTypesArr[38][2] - var_798;
         int var14 = var_729 + (var13 - var_729 >> 1);
         DialogManager.sub_388(g, var_729, var12, 1, 4);
         DialogManager.sub_388(g, var13, var12, 2, 5);
         ReadingDrawingClass.drawSpriteNoOffset(g, (byte)38, 0, var14, var12);
         LevelObjectData.spriteTypesArr[43][2] = 7;
         LevelObjectData.spriteTypesArr[43][3] = 9;
         ReadingDrawingClass.drawSpriteNoOffset(g, (byte)43, ReadingDrawingClass.readTextFromLng((short)241)[0], var14 + (LevelObjectData.spriteTypesArr[38][2] >> 1) - (LevelObjectData.spriteTypesArr[43][2] >> 1), var12 + (LevelObjectData.spriteTypesArr[38][3] >> 1) - (LevelObjectData.spriteTypesArr[43][3] >> 1));
         LevelObjectData.spriteTypesArr[43][2] = (short)ReadingDrawingClass.var_12;
         LevelObjectData.spriteTypesArr[43][3] = (short)ReadingDrawingClass.var_a9;
      }

      sub_96d(LevelManager.graphics);
      cursorXTarget = var_729 + var_6c8 * (LevelObjectData.spriteTypesArr[26][2] + var_798) + (LevelObjectData.spriteTypesArr[26][2] >> 1);
      var_c60 = var_762 + var_6d8 * (LevelObjectData.spriteTypesArr[26][3] + var_7d3) + (LevelObjectData.spriteTypesArr[26][3] >> 1);
      sub_b52();
   }

   private static void sub_a5a() {
      if (var_ea3 != -1) {
         switch(var_ea3) {
         case 2:
            sub_1b8((byte)3, (byte)-1, (byte)0, false);
            break;
         case 9:
            sub_ae7();
            break;
         case 150:
            musicManager.switchMusicPlayer(5, 1);
            showDialog((byte)11, (byte[])null, var_ea3, var_eff, new short[]{126}, (short)140);
            break;
         case 151:
            musicManager.switchMusicPlayer(4, 1);
            showDialog((byte)11, (byte[])null, var_ea3, var_eff, new short[]{126}, (short)140);
            break;
         case 152:
            musicManager.switchMusicPlayer(4, 1);
            showDialog((byte)31, (byte[])null, (short)152, var_eff, new short[]{126}, (short)140);
            break;
         case 153:
            musicManager.switchMusicPlayer(5, 1);
            showDialog((byte)38, (byte[])null, (short)153, (Object[])null, new short[]{126}, (short)141);
            break;
         case 164:
            musicManager.switchMusicPlayer(5, 1);
            showDialog((byte)15, (byte[])null, (short)164, (Object[])null, new short[]{126}, (short)131);
            break;
         case 165:
            musicManager.switchMusicPlayer(5, 1);
            showDialog((byte)40, (byte[])null, (short)165, (Object[])null, new short[]{126}, (short)132);
         }

         if (var_ea3 == 2) {
            var_ea3 = 9;
         } else {
            var_ea3 = -1;
         }
      } else {
         if (var_80 == 0) {
            ++var_8a4;
         }

         if (cursorXTarget != cursorXCurrent || var_c60 != var_bca) {
            cursorXCurrent += Math.abs(cursorXTarget - cursorXCurrent) == 1 ? cursorXTarget - cursorXCurrent : cursorXTarget - cursorXCurrent >> 1;
            var_bca += Math.abs(var_c60 - var_bca) == 1 ? var_c60 - var_bca : var_c60 - var_bca >> 1;
            if (cursorXTarget == cursorXCurrent && var_c60 == var_bca) {
               if (!var_6ac) {
                  var_5e0 = true;
               }

               var_62c = true;
            }
         }

      }
   }

   private static void sub_a64() {
      int var0;
      switch(var0 = var_13a7.mapInputToGameAction(keyCodePressed)) {
      case 2:
         moveCursorInMenu((byte)2);
         break;
      case 3:
         moveCursorInMenu((byte)3);
         break;
      case 4:
         moveCursorInMenu((byte)0);
         break;
      case 5:
         moveCursorInMenu((byte)1);
         break;
      case 6:
      case 7:
      case 8:
      case 9:
      default:
         if (var0 == 12) {
            if (var_6ac) {
               sub_ab6();
            } else {
               sub_21a();
            }
         } else if (var0 == 13) {
            if (var_6ac) {
               sub_c89(sub_e5c(var_e17[var_6c8][var_6d8]));
               keyCodePressed = 999999;
               return;
            }

            var_12fc = !var_12fc;
            if (!var_12fc) {
               var_ff4 = null;
            } else {
               sub_ba6();
            }
         }

         if (var0 == 0 && var_6ac) {
            sub_ab6();
         }
         break;
      case 10:
         int var2;
         if (var_6ac) {
            byte var1 = var_e17[var_6c8][var_6d8];
            Thief var10000;
            if (var_900.inventoryTools[0] != var1 && var_900.inventoryTools[1] != var1 && var_900.inventoryTools[2] != var1) {
               if (toolStats[sub_e5c(var1)][0] > currentMoney) {
                  showDialog((byte)0, (byte[])null, (short)181, new Object[]{new Integer(toolStats[sub_e5c(var1)][0]), new Integer(currentMoney)}, new short[]{126}, (short)136);
                  keyCodePressed = 999999;
                  var_649 = true;
                  var_62c = true;
                  return;
               }

               if (LevelManager.levelAdditionalData_TimerEtc[levelId - 1][13 + sub_e5c(var1)] == 0) {
                  showDialog((byte)0, (byte[])null, (short)182, (Object[])null, new short[]{126}, (short)136);
                  keyCodePressed = 999999;
                  var_649 = true;
                  var_62c = true;
                  return;
               }

               var2 = LevelManager.thiefStats[var_f0d][0] - var_900.currentLoad;
               if (toolStats[sub_e5c(var1)][1] > var2) {
                  showDialog((byte)0, (byte[])null, (short)(var2 == 0 ? 188 : 187), new Object[]{new Integer(toolStats[sub_e5c(var1)][1]), new Short((short)(41 + var_f0d)), new Integer(var2)}, new short[]{126}, (short)136);
                  keyCodePressed = 999999;
                  var_649 = true;
                  var_62c = true;
                  return;
               }

               for(int var3 = 0; var3 < 3; ++var3) {
                  if (var_900.inventoryTools[var3] == 116) {
                     var_900.inventoryTools[var3] = var1;
                     currentMoney -= toolStats[sub_e5c(var1)][0];
                     var10000 = var_900;
                     var10000.currentLoad = (byte)(var10000.currentLoad + toolStats[sub_e5c(var1)][1]);
                     break;
                  }
               }
            } else {
               for(var2 = 0; var2 < 3; ++var2) {
                  if (var_900.inventoryTools[var2] == var1) {
                     var_900.inventoryTools[var2] = 116;
                     currentMoney += toolStats[sub_e5c(var1)][0];
                     var10000 = var_900;
                     var10000.currentLoad = (byte)(var10000.currentLoad - toolStats[sub_e5c(var1)][1]);
                     break;
                  }
               }
            }

            var_649 = true;
            var_62c = true;
         } else {
            switch(var_ca0) {
            case 0:
               short[] var5 = new short[4];
               var2 = 0;
               if (!selectedThieves.isEmpty()) {
                  ++var2;
                  var5[0] = 220;
               }

               var5[var2++] = 217;
               if (LevelManager.var_7f3 > 0) {
                  var5[var2++] = 218;
               }

               if (levelId > 6 || levelId == 5) {
                  var5[var2++] = 219;
               }

               short[] var6 = new short[var2];
               HackManager.arrayCopy(var5, 0, var6, 0, var2);
               sub_22b((byte)6, new byte[]{13, 0}, var6, ReadingDrawingClass.readTextFromLng((short)136), (byte)2);
               break;
            case 1:
               var_13a7.sub_3d3();
               var_1217 = 1;
               break;
            case 2:
               var_f0d = 0;
               // FIX: Allow boss if allowChief flag is set (from map config)
               if (!LevelManager.allowChief) {
                  showDialog((byte)0, (byte[])null, (short)183, (Object[])null, new short[]{126}, (short)137);
               } else {
                  sub_22b((byte)2, new byte[]{5, var_f0d}, new short[]{125, 122}, ReadingDrawingClass.readTextFromLng((short)41), (byte)2);
               }
               break;
            case 3:
            case 4:
            case 5:
            case 6:
               var_f0d = var_900.thiefId;
               short[] var4;
               if (LevelManager.thievesList.contains(var_900)) {
                  var4 = new short[]{125, 122, 123};
               } else {
                  var4 = new short[]{124, 122};
               }

               sub_22b((byte)2, new byte[]{5, var_f0d}, var4, ReadingDrawingClass.readTextFromLng((short)(41 + var_f0d)), (byte)2);
               break;
            case 7:
               if (LevelManager.thievesList.size() == 0 && levelId == 1) {
                  showDialog((byte)33, (byte[])null, (short)149, (Object[])null, new short[]{126}, (short)136);
                  return;
               }

               var_1217 = 2;
               var_13a7.sub_3d3();
               break;
            case 8:
               keyCodePressed = 999999;
               sub_21a();
               return;
            }
         }
      }

      keyCodePressed = 999999;
   }

   private static void sub_ab6() {
      var_ff4 = null;
      var_6ac = false;
      var_5e0 = true;
      cursorXTarget = LevelObjectData.var_65[var_ca0][0];
      var_c60 = LevelObjectData.var_65[var_ca0][1];
      boolean var0 = false;

      for(int var1 = 0; var1 < var_1123.length; ++var1) {
         if (var_1123[var1] != 116 && var_1123[var1] != var_900.inventoryTools[var1]) {
            var0 = true;
            break;
         }
      }

      if (var0) {
         var_900.sub_19d();
      }

   }

   private static void sub_ae7() {
      musicManager.switchMusicPlayer(3, -1);
      int var0;
      int var1 = (var0 = LevelManager.levelAdditionalData_TimerEtc[levelId - 1][0] + 0) / 60;
      int var2 = (var0 - var1 * 60) / 10;
      int var3 = var0 - var1 * 60 - var2 * 10;
      if (levelId < 7) {
         showDialog((byte)41, new byte[]{5, 5}, LevelManager.levelAdditionalData_TimerEtc[levelId - 1][25], new Object[]{new Integer(var1), new Integer(var2), new Integer(var3)}, new short[]{126}, (short)133);
      } else {
         sub_2db((byte)41, new byte[]{5, 5}, LevelManager.levelAdditionalData_TimerEtc[levelId - 1][25], new Object[]{new Integer(var1), new Integer(var2), new Integer(var3)}, new short[]{126}, (short)134, new Object[]{new Integer(levelId - 6)});
      }
   }

   private static void moveCursorInMenu(byte direction) {
      if (var_6ac) {
         switch(direction) {
         case 0:
            --var_6c8;
            if (var_6c8 < 0) {
               var_6c8 = 5;
            }
            break;
         case 1:
            ++var_6c8;
            if (var_6c8 >= 6) {
               var_6c8 = 0;
            }
            break;
         case 2:
            --var_6d8;
            if (var_6d8 < 0) {
               var_6d8 = var_dff - 1;
            }
            break;
         case 3:
            ++var_6d8;
            if (var_6d8 >= var_dff) {
               var_6d8 = 0;
            }
         }

         cursorXTarget = var_729 + var_6c8 * (LevelObjectData.spriteTypesArr[26][2] + var_798) + (LevelObjectData.spriteTypesArr[26][2] >> 1);
         var_c60 = var_762 + var_6d8 * (LevelObjectData.spriteTypesArr[26][3] + var_7d3) + (LevelObjectData.spriteTypesArr[26][3] >> 1);
         sub_b52();
      } else {
         var_ca0 = var_b4c[var_ca0][direction];
         cursorXTarget = LevelObjectData.var_65[var_ca0][0];
         var_c60 = LevelObjectData.var_65[var_ca0][1];
         switch(var_ca0) {
         case 2:
            var_900 = allThievesArray[0];
            break;
         case 3:
            if (selectedThieves.contains(allThievesArray[1]) || LevelManager.levelAdditionalData_TimerEtc[levelId - 1][7] == 0) {
               var_ca0 = var_b5a[0][direction];
               moveCursorInMenu(direction);
               return;
            }

            var_900 = allThievesArray[1];
            break;
         case 4:
            if (selectedThieves.contains(allThievesArray[2]) || LevelManager.levelAdditionalData_TimerEtc[levelId - 1][8] == 0) {
               var_ca0 = var_b5a[1][direction];
               moveCursorInMenu(direction);
               return;
            }

            var_900 = allThievesArray[2];
            break;
         case 5:
            if (!selectedThieves.contains(allThievesArray[3]) && LevelManager.levelAdditionalData_TimerEtc[levelId - 1][9] != 0) {
               var_900 = allThievesArray[3];
               break;
            }

            var_ca0 = var_b5a[2][direction];
            moveCursorInMenu(direction);
            return;
         case 6:
            if (selectedThieves.contains(allThievesArray[4]) || LevelManager.levelAdditionalData_TimerEtc[levelId - 1][10] == 0) {
               var_ca0 = var_b5a[3][direction];
               moveCursorInMenu(direction);
               return;
            }

            var_900 = allThievesArray[4];
         }
      }

      if (!var_6ac) {
         var_12fc = false;
         var_ff4 = null;
         sub_ba6();
      }

   }

   private static void sub_b52() {
      if (var_e17[var_6c8][var_6d8] != 0) {
         short[] var0 = ReadingDrawingClass.sub_569((short)263, new Object[]{new Short((short)var_e17[var_6c8][var_6d8]), String.valueOf(toolStats[sub_e5c(var_e17[var_6c8][var_6d8])][0]), String.valueOf(toolStats[sub_e5c(var_e17[var_6c8][var_6d8])][1])});
         var_8a4 = 0;
         sub_daa(var0, var_7f5, var_810, var_870, -2);
         var_10ea = var_7f5;
      }

   }

   private static void sub_b6d() {
      if (var_123b) {
         var_123b = false;
         var_157e = true;

         switch(var_1217) {
         case 1:
            var_1217 = 0;
            //var10000 = new int[]{2, 4, 5, 3, 6};
            HackManager.callGc();
            threadSleep(10L);
            threadSleep(10L);
            LevelManager.initLevelInPlanningMode();
            break;
         case 2:
            var_1217 = 0;
            //var10000 = new int[]{1, 4, 5, 3};
            LevelManager.switchLevelToActionMode();
            break;
         case 3:
            var_1217 = 0;
            var_13a7.sub_36d();
            if (musicManager.currentPlayerIndex != 0) {
               //var10000 = new int[]{0, 4, 5, 3};
            }
            break;
         case 4:
            var_1217 = 0;
            sub_f0c();
            var_ab2 = -1;
            initShop();
         }

         var_157e = false;
      }
   }

   private static void sub_b8e(Graphics var0) {
      if (var_1217 != 0) {
         short[] var1;
         int var2 = (var1 = ReadingDrawingClass.readTextFromLng((short)130)).length * ReadingDrawingClass.var_12;
         byte var3 = ReadingDrawingClass.var_a9;
         int var4 = (var_1180 >> 1) - (var2 >> 1);
         int var5 = (var_11cf >> 1) - (var3 >> 1);
         ReadingDrawingClass.sub_20e(var0, var4 - 8, var5 - 4, var2 + 16, var3 + 8, true, 11665470);
         ReadingDrawingClass.sub_47c(var0, var1, var4, var5);
         var_123b = true;
      }
   }

   private static void sub_ba6() {
      var_6bc = false;
      short[] var0 = new short[]{0};
      if (!var_6ac) {
         var_f69 = 0;
         var_f83 = var_11cf - ReadingDrawingClass.var_a9 - 2;
         var_fa9 = var_1180;
         var0 = ReadingDrawingClass.readTextFromLng((short)LevelObjectData.var_65[var_ca0][2]);
         var_6bc = !saveData[7 + var_ca0] && gameMode == -1;
         if (var_12fc && var_6bc) {
            saveData[7 + var_ca0] = true;
            ReadingDrawingClass.sub_7c6();
            var_6bc = false;
         }
      }

      if (var0 != null) {
         sub_daa(var0, var_f69, var_f83, var_fa9, 1);
      }

   }

   private static boolean sub_bbb() {
      keyCodePressed = 999999;
      var_5e0 = true;
      if (var_6ac) {
         var_649 = true;
      }

      if (DialogManager.var_838 == null) {
         return false;
      } else {
         Object var0 = DialogManager.var_838;
         short var1 = 0;
         if (var0 instanceof Short) {
            var1 = ((Short)var0).shortValue();
         }

         int var3;
         switch(DialogManager.var_7ed) {
         case 2:
            Thief var12 = allThievesArray[var_f0d];
            switch(var1) {
            case 122:
               showDialog((byte)0, new byte[]{5, var12.thiefId}, (short)(var12.thiefId == 0 ? 147 : 148), new Object[]{new Integer(LevelManager.thiefStats[var12.thiefId][0]), new Integer(LevelManager.thiefStats[var12.thiefId][1]), new Short((short)(var12.thiefId + 99))}, new short[]{126}, (short)(41 + var12.thiefId));
               return true;
            case 123:
               var12.sub_19d();
               var12.clearThievesState(true);
               LevelManager.thievesList.removeElement(var12);
               return false;
            case 124:
               LevelManager.thievesList.addElement(allThievesArray[var_f0d]);
               allThievesArray[var_f0d].resetToSpawn();
               var_6ac = true;
               var_12fc = false;
               var_649 = true;
               var_6c8 = 0;
               var_6d8 = 0;
               cursorXTarget = 24;
               var_c60 = 44;
               HackManager.arrayCopy(var12.inventoryTools, 0, var_1123, 0, var_1123.length);
               return sub_1b8((byte)5, (byte)5, var12.thiefId, false);
            case 125:
               var_6ac = true;
               var_649 = true;
               var_12fc = false;
               var_6c8 = 0;
               var_6d8 = 0;
               HackManager.arrayCopy(var12.inventoryTools, 0, var_1123, 0, var_1123.length);
               return false;
            default:
               return false;
            }
         case 3:
            switch(var1) {
            case 190:
               sub_682();
               break;
            case 199:
               ReadingDrawingClass.sub_870();
               sub_3f1();
               break;
            case 209:
               showDialog((byte)0, (byte[])null, (short)8, (Object[])null, new short[]{126}, (short)135);
               return true;
            }

            return true;
         case 4:
            sub_670();
            if (MusicManager.someMusicIndexVar2 != saveData[0]) {
               MusicManager.someMusicIndexVar2 = saveData[0];
               if (MusicManager.someMusicIndexVar2) {
                  musicManager.switchMusicPlayer(0, -1);
               } else {
                  musicManager.clearCurrentMusicPlayer();
               }
            }

            MusicManager.someMusicIndexVar = saveData[1];
         case 5:
         case 7:
         case 8:
         case 9:
         case 10:
         case 12:
         case 16:
         case 17:
         case 18:
         case 21:
         case 22:
         case 23:
         case 24:
         case 27:
         case 36:
         case 37:
         case 39:
         default:
            break;
         case 6:
            switch(var1) {
            case 217:
               sub_ae7();
               return true;
            case 218:
               if (LevelManager.var_7f3 > 0) {
                  showDialog((byte)28, new byte[]{5, 5}, (short)177, new Object[]{new Integer(LevelManager.var_7f3)}, new short[]{126, 127}, (short)189);
                  return true;
               }

               return false;
            case 219:
               var3 = 0;
               boolean var11 = false;

               for(int var13 = 1; var13 < 6; ++var13) {
                  if (LevelManager.lootValues[var13] > 0) {
                     ++var3;
                  }

                  if (LevelManager.var_7a3[var13] > 0) {
                     var11 = true;
                  }
               }

               if (LevelManager.var_7a3[6] > 0) {
                  var11 = true;
               }

               Object[] var14;
               (var14 = new Object[2 + var3])[0] = new Integer(LevelManager.lootValues[0]);
               var14[1] = new Short((short)(var11 ? 175 : 176));
               var3 = 2;

               for(int var15 = 1; var15 < 6; ++var15) {
                  if (LevelManager.lootValues[var15] > 0) {
                     var14[var3] = new Short((short)(235 + var15));
                     ++var3;
                  }
               }

               showDialog((byte)25, (byte[])null, (short)174, var14, new short[]{126, 127}, (short)137);
               return true;
            case 220:
               return sub_c62();
            default:
               return false;
            }
         case 11:
         case 31:
        	 // FIX: Exclude Boss (index 0) from the "needs plan" check
             int requiredPlans = selectedThieves.size();
             if (selectedThieves.contains(allThievesArray[0])) {
                 requiredPlans--;
             }
             
             if (requiredPlans <= possibleThieves.size()) {
               sub_cec();
            } else {
               Short var10 = new Short((short)160);
               Short var5 = new Short((short)161);
               Object[] var6 = new Object[(selectedThieves.size() << 1) - 1];
               int var7 = 0;

               for(int var8 = 0; var8 < var6.length; var8 += 2) {
                  var6[var8] = new Short((short)(((Thief)selectedThieves.elementAt(var7++)).thiefId + 41));
                  if (var8 != var6.length - 1) {
                     var6[var8 + 1] = var10;
                  }

                  if (var8 == var6.length - 3) {
                     var6[var8 + 1] = var5;
                  }
               }

               musicManager.switchMusicPlayer(4, 1);
               showDialog((byte)13, new byte[]{48, 0}, (short)159, var6, new short[]{126}, (short)136);
            }

            return true;
         case 13:
            sub_cec();
            return true;
         case 14:
            if (var1 == 192) {
               sub_d10();
               return true;
            }

            if (var1 == 191) {
               if (gameMode > 0) {
                  showDialog((byte)35, (byte[])null, (short)158, new Object[]{new Integer(var_10ff)}, new short[]{126}, (short)191);
                  --var_10ff;
               } else {
                  sub_c15();
               }

               return true;
            }
            break;
         case 15:
            ReadingDrawingClass.sub_759();
            var_ab2 = 0;
            initShop();
            return true;
         case 19:
            if (var1 == 199) {
               sub_3f1();
            }

            return true;
         case 20:
            var_9fe = var1 - 228;
            showDialog((byte)26, new byte[]{5, 5}, (short)(var1 == 234 ? 180 : 179), new Object[]{new Short((short)(221 + var_9fe)), new Integer(LevelManager.var_7a3[var_9fe])}, new short[]{126, 127}, (short)189);
            return true;
         case 25:
            if (var0.equals(String.valueOf(126))) {
               return sub_c29();
            }
            break;
         case 26:
            if (var0.equals(String.valueOf(126))) {
               if (currentMoney >= LevelManager.var_7a3[var_9fe]) {
                  currentMoney -= LevelManager.var_7a3[var_9fe];
                  LevelManager.var_7a3[var_9fe] = 0;
                  if (221 + var_9fe == 227) {
                     showDialog((byte)34, new byte[]{5, 5}, LevelManager.levelAdditionalData_TimerEtc[levelId - 1][26], (Object[])null, new short[]{126}, (short)189);
                     return true;
                  }

                  return sub_c29();
               }

               showDialog((byte)0, (byte[])null, (short)181, new Object[]{new Integer(LevelManager.var_7a3[var_9fe]), new Integer(currentMoney)}, new short[]{126}, (short)136);
               return true;
            }
            break;
         case 28:
            if (var0.equals(String.valueOf(126))) {
               if (currentMoney < LevelManager.var_7f3) {
                  showDialog((byte)0, (byte[])null, (short)181, new Object[]{new Integer(LevelManager.var_7f3), new Integer(currentMoney)}, new short[]{126}, (short)136);
                  return true;
               }

               currentMoney -= LevelManager.var_7f3;
               LevelManager.var_7f3 = 0;
            }
            break;
         case 29:
            byte var9 = Byte.parseByte((String)var0);

            for(var3 = 0; var3 < selectedThieves.size(); ++var3) {
               Thief var4 = (Thief)selectedThieves.elementAt(var3);
               if (var9 == var3) {
                  var_900 = var4;
                  showDialog((byte)30, new byte[]{5, var4.thiefId}, (short)178, new Object[]{new Integer(var4.collectedLoot[0] * 1000)}, new short[]{126, 127}, (short)(41 + var4.thiefId));
                  return true;
               }
            }

            return false;
         case 30:
            if (var0.equals(String.valueOf(126))) {
               int var2 = var_900.collectedLoot[0] * 1000;
               if (currentMoney < var2) {
                  showDialog((byte)0, (byte[])null, (short)181, new Object[]{new Integer(var2), new Integer(currentMoney)}, new short[]{126}, (short)136);
                  return true;
               }

               selectedThieves.removeElement(var_900);
               var_900.sub_41a();
               var_900.clearThievesState(false);
               var_900.currentLoad = 0;
               currentMoney -= var2;
            }
            break;
         case 32:
            var_ab2 = 0;
            initShop();
            return true;
         case 33:
            var_1217 = 2;
            var_13a7.sub_3d3();
            return true;
         case 34:
            if (var0.equals(String.valueOf(126))) {
               return sub_c29();
            }
            break;
         case 35:
            sub_c15();
            break;
         case 38:
            sub_cec();
            return true;
         case 40:
            ReadingDrawingClass.sub_759();
            sub_3f1();
            return true;
         case 41:
            if (musicManager.currentPlayerIndex != 0) {
               musicManager.switchMusicPlayer(0, -1);
            }
            break;
         case 42:
            if (musicManager.currentPlayerIndex != 0 && var_ea3 != 9) {
               musicManager.switchMusicPlayer(0, -1);
            }
         }

         return false;
      }
   }

   public static void sub_c15() {
      currentMoney = var_e86;
      LevelManager.timeLimitSeconds = LevelManager.var_c9e;
      LevelManager.sub_140(LevelManager.var_8ff, LevelManager.alarmWithZonesMap);
      LevelManager.sub_f0(LevelManager.var_896, LevelManager.levelObjects);
      LevelManager.thievesList.removeAllElements();
      Enumeration var0 = LevelManager.var_9d3.elements();

      while(var0.hasMoreElements()) {
         Thief var1;
         (var1 = (Thief)var0.nextElement()).sub_41a();
         var1.sub_44c();
         LevelManager.thievesList.addElement(var1);
      }

      selectedThieves.removeAllElements();
      var0 = possibleThieves.elements();

      while(var0.hasMoreElements()) {
         selectedThieves.addElement(var0.nextElement());
      }

      for(int var2 = 0; var2 < 3; ++var2) {
         allThievesArray[0].inventoryTools[var2] = LevelManager.var_a1e[var2];
      }

      allThievesArray[0].sub_41a();
      allThievesArray[0].sub_2a1();
      loadLevel(levelId);
      ReadingDrawingClass.sub_71d();
   }

   private static boolean sub_c29() {
      int var0 = 0;

      for(int var1 = 1; var1 < LevelManager.var_7a3.length; ++var1) {
         if (LevelManager.var_7a3[var1] > 0) {
            ++var0;
         }
      }

      short[] var4 = new short[var0];
      Object[][] var2 = new Object[var0][1];
      var0 = 0;

      for(int var3 = 1; var3 < LevelManager.var_7a3.length; ++var3) {
         if (LevelManager.var_7a3[var3] > 0) {
            var2[var0][0] = new Integer(LevelManager.var_7a3[var3]);
            var4[var0++] = (short)(228 + var3);
         }
      }

      if (var0 > 0) {
         sub_260((byte)20, (byte[])null, var4, var2, ReadingDrawingClass.readTextFromLng((short)143), (byte)2);
         return true;
      } else {
         return false;
      }
   }

   private static boolean sub_c62() {
      if (selectedThieves.isEmpty()) {
         return false;
      } else {
         short[] var0 = new short[selectedThieves.size()];
         Object[][] var1 = new Object[selectedThieves.size()][1];
         byte[][] var2 = new byte[selectedThieves.size()][2];

         for(int var3 = 0; var3 < selectedThieves.size(); ++var3) {
            Thief var4 = (Thief)selectedThieves.elementAt(var3);
            var0[var3] = (short)(47 + var4.thiefId - 1);
            var1[var3][0] = new Integer(var4.collectedLoot[0] * 1000);
            var2[var3][0] = 42;
            var2[var3][1] = var4.thiefId;
         }

         sub_2a5((byte)29, false, (byte[])null, var0, var1, var2, (boolean[])null, (short)46, (byte)2);
         return true;
      }
   }

   private static void sub_c89(byte var0) {
      int var2 = 0;
      int var1;
      if (LevelManager.sub_bc9(var0) != 113 && LevelManager.sub_bc9(var0) != 114) {
         for(var1 = 0; var1 < Thief.toolUsingTimeStats.length; ++var1) {
            if (Thief.toolUsingTimeStats[var1][var0] > 0 && var1 != 11) {
               ++var2;
            }
         }
      } else {
         var2 = 0;
      }

      if (LevelManager.sub_bc9(var0) != 113 && LevelManager.sub_bc9(var0) != 114) {
         short[] var3 = new short[var2 + 1];
         Object[][] var4 = new Object[var2 + 1][2];
         byte[][] var5 = new byte[var2 + 1][2];
         var3[0] = 81;
         var4[0][0] = null;
         var4[0][1] = null;
         var5[0] = null;
         var2 = 1;

         for(var1 = 0; var1 < Thief.toolUsingTimeStats.length; ++var1) {
            if (Thief.toolUsingTimeStats[var1][var0] > 0 && var1 != 11) {
               var3[var2] = 82;
               var4[var2][0] = new Short((short)(51 + var1));
               var4[var2][1] = new Integer(Thief.toolUsingTimeStats[var1][var0]);
               var5[var2][0] = 4;
               var5[var2][1] = LevelObjectData.spriteIndexes[var1][4];
               ++var2;
            }
         }

         sub_29b((byte)0, new byte[]{8, var0}, var3, var4, var5, (boolean[])null, LevelManager.sub_bc9(var0), (byte)1);
      } else {
         showDialog((byte)0, new byte[]{8, var0}, (short)(LevelManager.sub_bc9(var0) == 113 ? 83 : 84), new Object[]{new Integer(Thief.toolUsingTimeStats[0][var0])}, new short[]{126}, LevelManager.sub_bc9(var0));
      }
   }

   private static void sub_cec() {
      short[] var0;
      if (var_10ff > 0 && gameMode != -1) {
         var0 = new short[]{192, 191};
      } else {
         var0 = new short[]{192};
      }

      sub_22b((byte)14, (byte[])null, var0, ReadingDrawingClass.readTextFromLng((short)130), (byte)1);
   }

   private static void sub_d10() {
      if (gameMode < 2) {
         var_10ff = 3;
      }

      if (LevelManager.thievesList.size() > 0) {
         Thief var1;
         for(Enumeration var0 = LevelManager.thievesList.elements(); var0.hasMoreElements(); var1.currentLoad = 0) {
            (var1 = (Thief)var0.nextElement()).clearThievesState(false);
            var1.sub_41a();
         }

         LevelManager.thievesList.removeAllElements();
      }

      allThievesArray[0].clearThievesState(false);
      allThievesArray[0].sub_41a();
      allThievesArray[0].currentLoad = 0;
      var_e86 = currentMoney;
      loadLevel((byte)(levelId + 1));
      ReadingDrawingClass.sub_6f5();
      ReadingDrawingClass.sub_837();
   }

   public static void loadLevel(byte levelid) {
      var_1217 = 3;
      if (gameMode == -1 && levelid > 6) {
         var_ea3 = 165;
      } else if (levelid > 26) {
         var_ea3 = 164;
      } else {
         if (levelId != levelid) {
            levelId = levelid;
            LevelManager.loadLevel(levelId);
            if (levelId == 1 || levelId == 7) {
               LevelManager.thievesList.removeAllElements();
               selectedThieves.removeAllElements();
            }

            for(int var1 = 0; var1 < allThievesArray.length; ++var1) {
               allThievesArray[var1].resetToSpawn();
               allThievesArray[var1].clearThievesState(false);
               allThievesArray[var1].sub_41a();
               allThievesArray[var1].currentLoad = 0;
            }

            if (levelId == 1) {
               var_ea3 = 2;

               for(byte var2 = 2; var2 < saveData.length; ++var2) {
                  saveData[var2] = false;
               }

               ReadingDrawingClass.sub_7c6();
            } else {
               var_ea3 = 9;
            }
         }

         LevelManager.winState = 0;
      }
   }

   private static void sub_daa(short[] var0, int var1, int var2, int var3, int var4) {
      var_ff4 = var0;
      var_102d = var1;
      var_105e = var2;
      var_109d = var3;
      var_10c8 = (byte)var4;
      var_10ea = var_102d + var_109d;
   }

   private static void sub_ddc(Graphics var0) {
      if (var_ff4 != null && (cursorXCurrent == cursorXTarget && var_bca == var_c60 || gameState == 1) && (var_12fc || var_6ac)) {
         ReadingDrawingClass.drawText(var0, var_ff4, var_10ea, var_105e, var_102d, var_102d + var_109d);
      }

   }

   private static void sub_e10() {
      if (var_ff4 != null && (var_12fc || var_6ac)) {
         if (var_10c8 == -2 && var_8a4 > 3) {
            var_10c8 = -1;
         }

         if (var_10c8 == -1 && var_10ea + var_ff4.length * ReadingDrawingClass.var_12 < var_102d + var_109d) {
            return;
         }

         if (var_10c8 > -2) {
            --var_10ea;
         }

         if (var_10ea + var_ff4.length * ReadingDrawingClass.var_12 < var_102d) {
            var_10ea = var_102d + var_109d;
            if (var_10c8 > -1) {
               --var_10c8;
               if (var_10c8 <= 0) {
                  var_ff4 = null;
                  var_12fc = false;
               }
            }
         }
      }

   }

   private static void sub_e28() {
      RecordStore var0 = null;

      try {
         if ((var0 = RecordStore.openRecordStore("option", true)).getNumRecords() > 0) {
            byte[] var12 = var0.getRecord(1);

            for(byte var2 = 0; var2 < saveData.length; ++var2) {
               saveData[var2] = var12[var2] == 1;
            }

            return;
         }

         var_1369 = true;
         var0.addRecord((byte[])null, 0, 0);

         for(int var1 = 0; var1 <= 1; ++var1) {
            var0.addRecord((byte[])null, 0, 0);
         }

         return;
      } catch (Exception var10) {
      } finally {
         try {
            if (var0 != null) {
               var0.closeRecordStore();
            }
         } catch (Exception var9) {
         }

      }

   }

   public static byte sub_e5c(byte var0) {
      return (byte)(var0 - 104);
   }

   private static String sub_eaa(DataInputStream var0) {
      StringBuffer var1 = new StringBuffer();

      byte var2;
      try {
		while((var2 = var0.readByte()) != 13) {
		     var1.append((char)var2);
		  }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

      try {
		var0.readByte();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      return var1.length() > 0 ? var1.toString() : null;
   }

   private static boolean sub_f0c() {
      String var1 = ReadingDrawingClass.getTextById((short)275);
      var_a60 = ReadingDrawingClass.sub_80d();
      short[][] var2 = (short[][])((short[][])var_a60.elementAt(0));
      int[] var3 = (int[])((int[])var_a60.elementAt(1));

      int var0;
      for(var0 = 0; var0 < 5; ++var0) {
         var1 = var1 + "&n" + var0 + "=" + ReadingDrawingClass.sub_5df(var2[var0]) + "&s" + var0 + "=" + var3[var0];
      }

      var1 = var1.replace(' ', '_');
      HttpConnection var4 = null;
      InputStream var5 = null;
      DataInputStream var6 = null;
      boolean var7 = false;

      try {
         Display.getDisplay(mainMidlet).setCurrent((Displayable)null);
         var4 = (HttpConnection)Connector.open(var1, 3, true);
         Display.getDisplay(mainMidlet).setCurrent(var_13a7);
         var4.setRequestMethod("POST");
         var4.setRequestProperty("Content-Type", "text/xml");
         var4.setRequestProperty("User-Agent", "Profile/MIDP-1.0 Configuration/CLDC-1.0");
         var4.setRequestProperty("Accept-Language", "en");
         var4.setRequestProperty("Accept-Charset", "utf-8; q=0.8");
         var4.setRequestProperty("Accept", "*/*");
         var4.setRequestProperty("Connection", "close");
         var5 = var4.openInputStream();
         if (var4.getResponseCode() == 200) {
            var7 = true;
            var6 = new DataInputStream(var5);
            String var8 = "-*-";
            var0 = 0;

            String var9;
            while((var9 = sub_eaa(var6)) != null) {
               int var10;
               if ((var10 = var9.indexOf(var8)) > -1) {
                  if (var0 > 5) {
                     break;
                  }

                  try {
                     try {
                        var3[var0] = Integer.parseInt(var9.substring(var10 + var8.length(), var9.length()), 10);
                     } catch (NumberFormatException var29) {
                        var3[var0] = 0;
                     }

                     String var11;
                     if ((var11 = var9.substring(0, var10)).length() > 5) {
                        var11 = var11.substring(0, 5);
                     }

                     var11 = var11.replace('_', ' ');
                     var2[var0] = ReadingDrawingClass.sub_533(var11);
                     ++var0;
                  } catch (Exception var30) {
                  }
               }
            }
         }
      } catch (Exception var31) {
      } finally {
         try {
            var6.close();
         } catch (Exception var28) {
         }

         try {
            var5.close();
         } catch (Exception var27) {
         }

         try {
            var4.close();
         } catch (Exception var26) {
         }

      }

      ReadingDrawingClass.sub_7ec(var2, var3);
      HackManager.callGc();
      return var7;
   }

   public final void hideNotify() {
      pauseGameThread();
   }

   public final void showNotify() {
      this.runGameThread();
   }

   public final void sizeChanged(int var1, int var2) {
      if (var_13cf != -1 && gameState == 5) {
         gameState = var_2b9;
         var_1180 = LevelManager.screenWidth = this.getWidth();
         var_11cf = LevelManager.screenHeight = this.getHeight();
         var_130f = null;
      }

   }

   static {
      cursorXTarget = cursorXCurrent;
      var_c60 = var_bca;
      allThievesArray = new Thief[5];
      selectedThieves = new Vector();
      possibleThieves = new Vector();
      levelId = -1;
      toolStats = new short[][]{{50, 10, 0, 4}, {120, 15, 1, 6}, {7000, 11, 2, 11}, {3000, 1, 3, 9}, {1500, 8, 4, 7}, {12000, 22, 5, 12}, {200, 2, 6, 8}, {4000, 5, 7, 10}, {30000, 9, 8, 10}, {2000, 10, 9, 5}, {9000, 20, 10, 5}, {500, 1, 11, 13}};
      var_dff = toolStats.length / 6;
      var_e17 = new byte[6][var_dff];
      currentMoney = 4000;
      var_e86 = 4000;
      var_10ff = 3;
      var_1123 = new byte[3];
      var_114a = 0;
      var_1217 = 0;
      saveData = new boolean[]{false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false};
      var_13cf = -1;
      var_157e = false;
   }
}
