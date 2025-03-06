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

public final class Class_178 extends Class_26a implements Runnable, CommandListener {
   public static boolean var_46;
   public static byte var_80;
   public static byte var_91;
   private static byte var_b9;
   public static byte var_115;
   public static byte var_165;
   public static int var_17e;
   public static boolean var_1cd;
   public static boolean var_22b;
   public static byte var_26f = -2;
   private static byte var_2b9 = -1;
   public static byte var_2f7;
   public static boolean var_338;
   public static Command var_392;
   public static Command var_3bb;
   public static MM var_3e2;
   private static Thread var_463;
   private static boolean var_4b9;
   public static boolean var_511;
   public static MusicManager musicManager;
   public static byte var_5bb;
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
   public static Class_205 var_900;
   public static int var_93a = 999999;
   public static int var_9af = 999999;
   private static int var_9fe;
   private static Vector var_a60 = new Vector();
   public static int var_ab2;
   private static int var_afa;
   public static boolean var_b17 = false;
   private static final byte[][] var_b4c = new byte[][]{{2, 7, 4, 0}, {8, 1, 1, 5}, {2, 0, 8, 2}, {2, 5, 8, 4}, {2, 6, 3, 0}, {3, 6, 1, 6}, {4, 6, 5, 7}, {0, 7, 6, 7}, {8, 1, 8, 2}};
   private static final byte[][] var_b5a = new byte[][]{{6, 3, 3, 3}, {7, 4, 4, 4}, {5, 4, 5, 5}, {6, 0, 6, 6}};
   public static int var_b74;
   public static int var_bca;
   public static int var_bfe;
   public static int var_c60;
   public static byte var_ca0;
   public static int var_ce9;
   public static int var_d24;
   public static final Class_205[] var_d34;
   public static final Vector var_d50;
   public static final Vector var_d82;
   public static byte var_dc6;
   public static final short[][] toolStats;
   private static final int var_dff;
   private static final byte[][] var_e17;
   public static int var_e38;
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
   public static final boolean[] var_129e;
   public static boolean var_12fc;
   private static Image var_130f;
   private static boolean var_1369;
   private static Class_178 var_13a7;
   private static int var_13cf;
   public long var_13db;
   public Image var_1403;
   public Image var_1453;
   public int var_1493;
   public boolean var_14e2;
   private static int var_150d;
   private static int var_1566;
   private static boolean var_157e;

   public final void sub_29() {
      if (!var_4b9) {
         var_511 = true;
         var_13a7 = this;
         if (var_26f == -1) {
            var_26f = var_2b9;
         } else {
            var_26f = 0;
         }

         var_463 = null;
         var_4b9 = true;
         var_463 = new Thread(this);
         var_463.start();
         Class_3d.callGc();
      }
   }

   public static void sub_4d() {
      if (var_26f != -1) {
         if (var_26f == 1 && LevelManager.var_a5a == 1) {
            LevelManager.var_96a = LevelManager.var_953;
            LevelManager.var_953 = -1;
            var_93a = 999999;
         }

         var_2b9 = var_26f;
         var_4b9 = false;
         var_26f = -1;
         var_338 = false;
         if (musicManager != null) {
            musicManager.clearCurrentMusicPlayer();
         }

         Class_3d.callGc();
      }
   }

   public static void sub_9b() {
      var_2b9 = var_26f;
      var_4b9 = false;
      var_26f = -1;
      if (musicManager != null) {
         musicManager.closeAllMusicPlayers();
      }

      var_463 = null;
      musicManager = null;
      Class_3d.callGc();
   }

   private void sub_bd() {
      var_ca0 = 0;
      sub_e28();
      MusicManager.someMusicIndexVar2 = var_129e[0];
      MusicManager.someMusicIndexVar = var_129e[1];

      byte var1;
      for(var1 = 1; var1 <= 2; ++var1) {
         var_1cd = var_1cd || Class_1b0.sub_7ad(var1);
      }

      if (var_46) {
         this.setCommandListener(this);
      }

      createMusicManager();
      Class_19e.var_790 = this;
      LevelManager.var_f0 = this;

      for(var1 = 0; var1 < 5; ++var1) {
         var_d34[var1] = new Class_205(var1);
      }

      sub_ba6();
   }

   private static void createMusicManager() {
      musicManager = new MusicManager(new String[]{"/dat/menu", "/dat/plan", "/dat/rob", "/dat/tik", "/dat/fail", "/dat/succ", "/dat/alarm", "/dat/prison"});
      musicManager.setPriorityLevel(Class_26a.musicManagerPriorityLevel);
   }

   public final void sub_12a(Graphics var1) {
      if (var1 != null) {
         if (var_26f != -1) {
            if (!var_22b) {
               switch(var_26f) {
               case 0:
                  this.sub_451(var1);
                  break;
               case 1:
                  LevelManager.sub_26f(var1);
                  sub_167(var1);
                  break;
               case 2:
                  Class_19e.sub_2c9(LevelManager.var_2a1, var1);
                  break;
               case 3:
                  sub_8d4(var1);
                  sub_167(var1);
                  break;
               case 4:
                  sub_7f0(var1);
                  break;
               case 5:
                  var1.setColor(192, 192, 192);
                  var1.fillRect(0, 0, this.getWidth(), this.getHeight());
                  if (var_130f != null) {
                     var1.drawImage(var_130f, this.getWidth() >> 1, this.getHeight() >> 1, 3);
                  }
               }

               sub_ddc(var1);
               sub_b8e(var1);
            }
         }
      }
   }

   private static void sub_167(Graphics var0) {
      if (var_6bc && !var_6ac && var_b74 == var_bfe && var_bca == var_c60 && var_115 > 12) {
         Class_19e.sub_388(var0, LevelManager.screenWidth - LevelObjectData.spriteTypesArr[38][2] - 2, var_11cf - LevelObjectData.spriteTypesArr[9][3] + Class_19e.var_ac, 2, 5);
      }

   }

   public final void run() {
      long var1 = Class_3d.sub_161();

      while(var_4b9) {
         if (!var_338) {
            if (var_13cf != -1 && var_13cf != this.getWidth() && var_26f != 5) {
               var_2b9 = var_26f;
               if (var_26f == 1 && LevelManager.var_a5a == 1) {
                  LevelManager.var_96a = LevelManager.var_953;
                  LevelManager.var_953 = -1;
                  var_93a = 999999;
               }

               var_26f = 5;

               var_130f = Class_1b0.loadImagePng("nor");
            }

            this.sub_1aa(var1);
            var1 = Class_3d.sub_161();
            this.sub_5b();
            this.var_13db = 60L - (Class_3d.sub_161() - var1);
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
      var_17e = (int)((long)var_17e + (Class_3d.sub_161() - var1));
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

         switch(var_26f) {
         case 0:
            this.sub_47c();
            break;
         case 1:
            LevelManager.sub_85b();
            LevelManager.sub_5fd();
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
         var_93a = var1;
         switch(var_26f) {
         case 0:
            sub_4b4();
            return;
         case 1:
            LevelManager.sub_896();
            if (LevelManager.var_a5a == 0) {
               LevelManager.sub_3d2();
               return;
            }
            break;
         case 2:
            Class_19e.sub_3ee();
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
      var_93a = 999999;
   }

   public static boolean sub_1b8(byte var0, byte var1, byte var2, boolean var3) {
      if ((var_129e[var0] || var_5bb > -1) && !var3) {
         return false;
      } else {
         var_129e[var0] = true;
         if (var_26f == 3) {
            musicManager.switchMusicPlayer(3, -1);
         }

         sub_2c8((byte)42, var1 == -1 ? null : new byte[]{var1, var2}, (short)(2 + var0 - 3), (Object[])null, new short[]{126}, (short)135);
         Class_1b0.sub_7c6();
         return true;
      }
   }

   private static void sub_21a() {
      short[] var0 = new short[]{190, 209, 199};
      sub_22b((byte)3, (byte[])null, var0, Class_1b0.readTextFromLng((short)128), (byte)2);
   }

   public static void sub_22b(byte var0, byte[] var1, short[] var2, short[] var3, byte var4) {
      sub_260(var0, var1, var2, (Object[][])null, var3, var4);
   }

   private static void sub_260(byte var0, byte[] var1, short[] var2, Object[][] var3, short[] var4, byte var5) {
      if (var0 == 22) {
         Class_19e.var_c24 = true;
      }

      Class_19e.var_7c6 = 1;
      Class_19e.sub_23();
      Class_19e.var_7ed = var0;
      Class_19e.var_850 = var1;
      Class_19e.var_8ca = var2;
      Class_19e.var_914 = var3;
      Class_19e.var_882 = var4;
      Class_19e.var_89d = new short[var5];
      Class_19e.var_89d[0] = 126;
      if (var5 == 2) {
         Class_19e.var_89d[1] = 127;
      }

      sub_360();
   }

   private static void sub_29b(byte var0, byte[] var1, short[] var2, Object[][] var3, byte[][] var4, boolean[] var5, short var6, byte var7) {
      Class_19e.var_c2e = true;
      sub_2a5(var0, false, var1, var2, var3, var4, var5, var6, var7);
   }

   public static void sub_2a5(byte var0, boolean var1, byte[] var2, short[] var3, Object[][] var4, byte[][] var5, boolean[] var6, short var7, byte var8) {
      Class_19e.var_7c6 = 2;
      Class_19e.sub_23();
      Class_19e.var_7ed = var0;
      Class_19e.var_850 = var2;
      Class_19e.var_8ca = var3;
      Class_19e.var_914 = var4;
      Class_19e.sub_4bd(var7);
      Class_19e.var_abc = var5;
      Class_19e.var_a80 = var1;
      Class_19e.var_89d = new short[var8];
      Class_19e.var_89d[0] = 126;
      if (var8 == 2) {
         Class_19e.var_89d[1] = 127;
      }

      Class_19e.var_a44 = new boolean[var3.length];
      if (var6 != null) {
         Class_3d.sub_1cf(var6, 0, Class_19e.var_a44, 0, var6.length);
      }

      sub_360();
   }

   public static void sub_2c8(byte var0, byte[] var1, short var2, Object[] var3, short[] var4, short var5) {
      Class_19e.var_7c6 = 0;
      Class_19e.sub_23();
      Class_19e.var_7ed = var0;
      Class_19e.var_89d = var4;
      Class_19e.sub_4bd(var5);
      Class_19e.sub_4ac(var2, var3);
      Class_19e.var_850 = var1;
      sub_360();
   }

   private static void sub_2db(byte var0, byte[] var1, short var2, Object[] var3, short[] var4, short var5, Object[] var6) {
      Class_19e.var_7c6 = 0;
      Class_19e.sub_23();
      Class_19e.var_7ed = var0;
      Class_19e.var_89d = var4;
      Class_19e.sub_4ea(var5, var6);
      Class_19e.sub_4ac(var2, var3);
      Class_19e.var_850 = var1;
      sub_360();
   }

   public static void sub_30c() {
      boolean var0 = false;
      byte var1 = var_26f;
      Class_19e.var_c2e = false;
      Class_19e.var_c24 = false;
      if (var_2f7 == 1) {
         var0 = LevelManager.sub_9a0();
      } else if (var_2f7 == 0) {
         var0 = sub_4cc();
      } else if (var_2f7 == 3) {
         var0 = sub_bbb();
      }

      if (!var0 && var_26f == var1) {
         var_26f = var_2f7;
      }

      var_13a7.sub_3d3();
      var_93a = 999999;
      Class_3d.callGc();
   }

   private static void sub_360() {
      if (var_26f != 2) {
         var_2f7 = var_26f;
      }

      Class_19e.sub_6f();
      var_26f = 2;
      var_ff4 = null;
   }

   private void sub_36d() {
      sub_3b5(2);
      this.sub_3d3();
      var_26f = 3;
      var_5e0 = true;
      if (musicManager.currentPlayerIndex != 0 && var_ea3 != 9 && var_ea3 != 2) {
         musicManager.switchMusicPlayer(0, -1);
      }

   }

   public static void sub_3b5(int var0) {
      var_22b = true;
      switch(var0) {
      case 0:
         if (Class_1b0.mainImages[4] == null) {
            Class_1b0.mainImages[2] = null;
            Class_1b0.mainImages[3] = null;
            Class_3d.callGc();
            threadSleep(100L);
            Class_1b0.loadMainImage(4);
            threadSleep(500L);
            Class_1b0.loadMainImage(5);
            threadSleep(500L);
            Class_1b0.loadMainImage(6);
            threadSleep(500L);
         }
         break;
      case 1:
         if (Class_1b0.mainImages[3] == null) {
            Class_1b0.mainImages[2] = null;
            Class_1b0.mainImages[4] = null;
            Class_1b0.mainImages[5] = null;
            Class_1b0.mainImages[6] = null;
            Class_3d.callGc();
            threadSleep(50L);
            Class_1b0.loadMainImage(3);
            threadSleep(50L);
         }
         break;
      case 2:
         if (Class_1b0.mainImages[2] == null) {
            Class_1b0.mainImages[3] = null;
            Class_1b0.mainImages[4] = null;
            Class_1b0.mainImages[5] = null;
            Class_1b0.mainImages[6] = null;
            Class_3d.callGc();
            threadSleep(50L);
            Class_1b0.loadMainImage(2);
            threadSleep(50L);
         }
      }

      Class_3d.callGc();
      var_22b = false;
   }

   private void sub_3d3() {
      if (var_46) {
         this.removeCommand(var_3bb);
         this.removeCommand(var_392);
         if (var_26f == 3) {
            var_3bb = new Command(Class_1b0.sub_5a0((short)258), 4, 1);
            var_392 = new Command(Class_1b0.sub_5a0((short)261), 1, 2);
            this.addCommand(var_3bb);
            this.addCommand(var_392);
            return;
         }

         if (var_26f == 1) {
            var_392 = new Command(Class_1b0.sub_5a0((short)261), 1, 2);
            this.addCommand(var_392);
         }
      }

   }

   private static void sub_3f1() {
      var_511 = false;
      var_26f = 0;
      var_114a = 25;
   }

   public final int sub_435(int var1) {
      var_9af = 999999;
      return this.sub_97(var1);
   }

   public final void sub_451(Graphics var1) {
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
         Class_1b0.sub_20e(var1, 0, var_11cf - 4, (var_114a - 6 >> 1) * var_1180 / 9, 4, true, 11665470);
         ++var_114a;
         return;
      case 25:
         var1.setColor(0);
         var1.setClip(0, 0, var_1180, var_11cf);
         var1.fillRect(0, 0, var_1180, var_11cf);
         Class_1b0.drawSprite2(var1, (byte)7, 0, var_ce9, var_d24);
         Class_19e.sub_29c(var1);
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
         Class_1b0.loadMainImage(var_114a - 6 >> 1);
         ++var_114a;
         return;
      case 10:
         Class_1b0.loadMainImage(var_114a - 6 >> 1);
         if (Class_1b0.mainImages[2] != null && var_1180 > 176) {
            LevelObjectData.spriteTypesArr[7][2] = (short)Class_1b0.mainImages[2].getWidth();
         }

         LevelManager.var_cf = var_11cf - LevelObjectData.spriteTypesArr[9][3];
         var_ce9 = var_1180 - LevelObjectData.spriteTypesArr[7][2] >> 1;
         var_d24 = LevelObjectData.spriteTypesArr[28][3] + (var_11cf - LevelObjectData.spriteTypesArr[28][3] - LevelObjectData.spriteTypesArr[7][3] >> 1);
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
         var_bfe = LevelObjectData.var_65[var_ca0][0];
         var_c60 = LevelObjectData.var_65[var_ca0][1];
         ++var_114a;
         return;
      case 12:
      case 14:
      case 16:
         ++var_114a;
         return;
      case 18:
         Class_1b0.readCharactersFromLng();

         try {
            var_13cf = Integer.parseInt(Class_1b0.sub_5a0((short)276));
         } catch (NumberFormatException var2) {
         }

         ++var_114a;
         return;
      case 20:
         LevelManager.var_25f = Image.createImage(LevelManager.screenWidth, LevelManager.screenHeight);
         LevelManager.var_2a1 = LevelManager.var_25f.getGraphics();
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
      if (var_93a != 999999) {
         var_93a = 999999;
         switch(var_114a) {
         case 2:
         case 5:
            ++var_114a;
         default:
         }
      }
   }

   private static boolean sub_4cc() {
      switch(Class_19e.var_7ed) {
      case 4:
         sub_670();
         if (MusicManager.someMusicIndexVar2 != var_129e[0]) {
            MusicManager.someMusicIndexVar2 = var_129e[0];
            if (!MusicManager.someMusicIndexVar2) {
               musicManager.clearCurrentMusicPlayer();
            }
         }

         MusicManager.someMusicIndexVar = var_129e[1];
         sub_6dd();
         return true;
      case 21:
         sub_6dd();
         return true;
      case 22:
         switch(((Short)Class_19e.var_838).shortValue()) {
         case 200:
            if (var_1cd) {
               sub_22b((byte)27, (byte[])null, new short[]{193, 194}, Class_1b0.readTextFromLng((short)130), (byte)2);
            } else {
               sub_22b((byte)37, (byte[])null, new short[]{201, 195, 196, 197}, Class_1b0.readTextFromLng((short)198), (byte)2);
            }

            return true;
         case 201:
         case 206:
         case 207:
         default:
            break;
         case 202:
            sub_2c8((byte)21, (byte[])null, (short)144, new Object[]{MM.var_a1}, new short[]{126}, (short)202);
            return true;
         case 203:
            sub_707();
            return true;
         case 204:
            sub_2c8((byte)44, (byte[])null, (short)145, new Object[]{MM.var_a1}, new short[]{126, 127}, (short)204);
            return true;
         case 205:
            sub_2c8((byte)43, (byte[])null, (short)145, new Object[]{MM.var_a1}, new short[]{126, 127}, (short)205);
            return true;
         case 208:
            sub_682();
            return true;
         case 209:
            sub_2c8((byte)0, (byte[])null, (short)8, (Object[])null, new short[]{126}, (short)135);
            return true;
         case 210:
            sub_76b();
            return true;
         case 211:
            var_511 = false;
            var_3e2.destroyApp(false);
            return true;
         }
      default:
         return false;
      case 27:
         if (Class_19e.var_838 == null) {
            sub_6dd();
            return true;
         } else {
            switch(((Short)Class_19e.var_838).shortValue()) {
            case 193:
               Class_1b0.sub_6da();
               Class_1b0.sub_8ce();
               var_1217 = 3;
            default:
               return true;
            case 194:
               sub_22b((byte)37, (byte[])null, new short[]{201, 195, 196, 197}, Class_1b0.readTextFromLng((short)198), (byte)2);
               return true;
            }
         }
      case 37:
         if (Class_19e.var_838 == null) {
            sub_6dd();
            return true;
         }

         switch(((Short)Class_19e.var_838).shortValue()) {
         case 195:
            var_5bb = 0;
            break;
         case 196:
            var_5bb = 1;
            break;
         case 197:
            var_5bb = 2;
         case 198:
         case 199:
         case 200:
         default:
            break;
         case 201:
            var_5bb = -1;
         }

         sub_4f8();
         return true;
      case 43:
         if (Class_19e.var_838.equals(String.valueOf(126))) {
            if (Class_26a.sub_180()) {
               var_511 = false;
               var_3e2.destroyApp(false);
               return true;
            }

            sub_6dd();
         } else {
            sub_6dd();
         }

         return true;
      case 44:
         if (Class_19e.var_838.equals(String.valueOf(126))) {
            if (Class_26a.sub_11d()) {
               var_511 = false;
               var_3e2.destroyApp(false);
               return true;
            }

            sub_6dd();
         } else {
            sub_6dd();
         }

         return true;
      case 45:
         if (Class_19e.var_838 == null) {
            sub_6dd();
            return true;
         } else {
            switch(((Short)Class_19e.var_838).shortValue()) {
            case 214:
               var_ab2 = -1;
               sub_7c1();
               return true;
            case 215:
               sub_5d0();
               var_ab2 = -1;
               sub_7c1();
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
      Class_1b0.sub_759();
      var_dc6 = -1;
      var_10ff = 3;
      var_e38 = var_5bb == -1 ? 50 : 4000;
      sub_d4e((byte)(var_5bb == -1 ? 1 : 7));
      Class_1b0.sub_6f5();
      Class_1b0.sub_837();
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
	    this.var_1403 = Class_1b0.loadImagePng(var1);
	 }

      if (var2 != null) {
	    this.var_1453 = Class_1b0.loadImagePng(var2);
	 }

      if (this.var_1403 != null || this.var_1453 != null) {
         this.var_14e2 = var5;
         if (!this.var_14e2 && this.var_1403 != null && this.var_1403.getHeight() > 500) {
            this.var_14e2 = true;
         }

         this.var_1493 = var3;
         this.sub_5b();
         threadSleep((long)var4);
         this.var_1403 = null;
         this.var_1453 = null;
         Class_3d.callGc();
      }
   }

   private static void sub_5d0() {
      Class_1b0.sub_7ec(new short[][]{Class_1b0.readTextFromLng((short)251), Class_1b0.readTextFromLng((short)252), Class_1b0.readTextFromLng((short)253), Class_1b0.readTextFromLng((short)254), Class_1b0.readTextFromLng((short)255)}, new int[]{100000, 50000, 30000, 20000, 10000});
   }

   private static void sub_611() {
      var_130f = null;
      if (var_1369) {
         sub_5d0();
         if (Class_1b0.var_19d) {
            sub_6dd();
         } else {
            sub_76b();
         }

         var_1369 = false;
      } else {
         sub_6dd();
      }

      Class_3d.callGc();
   }

   private static void sub_670() {
      if (Class_19e.var_838 != null) {
         String var0 = (String)Class_19e.var_838;

         for(byte var1 = 1; var1 <= 2; ++var1) {
            var_129e[var1 - 1] = "true".equals(Class_1b0.sub_1f4(var0, var1));
         }

         Class_1b0.sub_7c6();
      }

   }

   private static void sub_682() {
      short[] var0 = new short[]{213, 212};
      sub_2a5((byte)4, true, (byte[])null, var0, (Object[][])null, (byte[][])null, new boolean[]{var_129e[0], var_129e[1]}, (short)208, (byte)2);
   }

   private static void sub_6dd() {
      int var1 = 9;
      if (!Class_26a.var_2bb) {
         var1 -= 2;
      }

      if (Class_1b0.var_19d) {
         --var1;
      }

      short[] var0;
      (var0 = new short[var1])[0] = 200;
      var0[1] = 208;
      var0[2] = 209;
      var1 = 3;
      if (!Class_1b0.var_19d) {
         ++var1;
         var0[3] = 210;
      }

      var0[var1++] = 203;
      var0[var1++] = 202;
      if (Class_26a.var_2bb) {
         var0[var1++] = 204;
         var0[var1++] = 205;
      }

      var0[var1] = 211;
      var_114a = 25;
      sub_22b((byte)22, (byte[])null, var0, Class_1b0.readTextFromLng((short)129), (byte)1);
   }

   private static void sub_707() {
      short[] var0;
      if (var_b17) {
         var0 = new short[]{214, 215, 216};
      } else {
         var0 = new short[]{214, 215};
      }

      var_114a = 25;
      sub_22b((byte)45, (byte[])null, var0, Class_1b0.readTextFromLng((short)203), (byte)2);
   }

   private static void sub_76b() {
      var_114a = 25;
      sub_2c8((byte)21, new byte[]{5, 6}, (short)1, (Object[])null, new short[]{126}, (short)210);
   }

   public static void sub_7c1() {
      sub_3b5(2);
      var_a60 = Class_1b0.sub_80d();
      var_150d = (LevelManager.var_cf >> 1) - (6 * (Class_1b0.var_a9 + 3) >> 1);
      var_1566 = var_150d + Class_1b0.var_a9 + 3;
      if (var_ab2 > -1) {
         var_ab2 = -1;

         for(int var0 = 0; var0 < 5; ++var0) {
            if (((int[])((int[])var_a60.elementAt(1)))[var0] < var_e38) {
               var_ab2 = var0;

               for(int var1 = 3; var1 >= var_ab2; --var1) {
                  ((short[][])((short[][])var_a60.elementAt(0)))[var1 + 1] = ((short[][])((short[][])var_a60.elementAt(0)))[var1];
                  ((short[][])((short[][])var_a60.elementAt(1)))[var1 + 1] = ((short[][])((short[][])var_a60.elementAt(1)))[var1];
               }

               ((short[][])((short[][])var_a60.elementAt(0)))[var_ab2] = Class_1b0.readTextFromLng((short)207);
               ((int[])((int[])var_a60.elementAt(1)))[var0] = var_e38;
               var_afa = 0;
               break;
            }
         }
      }

      var_26f = 4;
      var_5ed = true;
   }

   private static void sub_7f0(Graphics var0) {
      var_338 = true;
      int var2 = 16 * Class_1b0.var_12;
      int var3 = (var_1180 >> 1) - (var2 >> 1);
      int var1;
      int var4;
      if (var_5ed) {
         short[][] var5 = (short[][])((short[][])var_a60.elementAt(0));
         int[] var6 = (int[])((int[])var_a60.elementAt(1));
         if (var_ce9 > 0 || var_d24 > LevelObjectData.spriteTypesArr[28][3]) {
            LevelManager.var_2a1.setColor(0);
            LevelManager.var_2a1.setClip(0, 0, var_1180, var_11cf);
            LevelManager.var_2a1.fillRect(0, 0, var_1180, var_11cf);
         }

         Class_1b0.drawSprite2(LevelManager.var_2a1, (byte)7, 0, var_ce9, var_d24);
         Class_19e.sub_29c(LevelManager.var_2a1);
         Class_1b0.sub_47c(LevelManager.var_2a1, Class_1b0.readTextFromLng((short)203), (var_1180 >> 1) - (Class_1b0.readTextFromLng((short)203).length * Class_1b0.var_12 >> 1), var_150d);
         var1 = var_1566;

         for(int var7 = 0; var7 < 5; ++var7) {
            if (var_ab2 != var7) {
               Class_1b0.sub_47c(LevelManager.var_2a1, var5[var7], var3, var1);
            }

            var4 = var3 + var2 - String.valueOf(var6[var7]).length() * Class_1b0.var_12;
            Class_1b0.sub_46a(LevelManager.var_2a1, "$", var4 - Class_1b0.var_12, var1);
            Class_1b0.sub_46a(LevelManager.var_2a1, String.valueOf(var6[var7]), var4, var1);
            var1 += Class_1b0.var_a9 + 3;
         }

         Class_19e.var_89d = new short[]{126};
         Class_19e.sub_36c(LevelManager.var_2a1);
         var_5ed = false;
      }

      var0.drawImage(LevelManager.var_25f, 0, 0, 0);
      var1 = var_1566;
      if (var_ab2 >= 0) {
         label42:
         for(var4 = 0; var4 < 5; ++var4) {
            if (var_ab2 == var4) {
               Class_1b0.sub_47c(var0, ((short[][])((short[][])var_a60.elementAt(0)))[var4], var3, var1);
               int var8 = 0;

               while(true) {
                  if (var8 >= 5) {
                     break label42;
                  }

                  if (var8 == var_afa && var_115 > 12) {
                     Class_1b0.sub_47c(var0, Class_1b0.readTextFromLng((short)256), var3 + var8 * Class_1b0.var_12, var1 + 2);
                  }

                  ++var8;
               }
            }

            var1 += Class_1b0.var_a9 + 3;
         }
      }

      var_338 = false;
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
      if ((var0 = var_13a7.sub_97(var_93a)) == 12 || var0 == 0) {
         if (var_ab2 >= 0) {
            Class_1b0.sub_7ec((short[][])((short[][])var_a60.elementAt(0)), (int[])((int[])var_a60.elementAt(1)));
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

   private static void sub_8d4(Graphics var0) {
      var_338 = true;
      if (var_5e0 && (var_ce9 > 0 || var_d24 > LevelObjectData.spriteTypesArr[28][3])) {
         LevelManager.var_2a1.setColor(0);
         LevelManager.var_2a1.setClip(0, 0, var_1180, var_11cf);
         LevelManager.var_2a1.fillRect(0, 0, var_1180, var_11cf);
      }

      sub_8f3(var0);
      Class_1b0.drawSprite2(var0, (byte)40, 0, var_b74, var_bca);
      if (var_6bc && var_115 > 12) {
         Class_1b0.drawSprite2(var0, (byte)39, 2, var_b74 + LevelObjectData.spriteTypesArr[40][2], var_bca);
      }

      sub_94f(var0, var_b74, var_bca, true);
      var_338 = false;
   }

   private static void sub_8f3(Graphics var0) {
      if (var_5e0) {
         boolean var1 = false;
         Class_1b0.drawSprite2(LevelManager.var_2a1, (byte)7, 0, var_ce9, var_d24);

         for(int var2 = 1; var2 < 5; ++var2) {
            if (!var_d50.contains(var_d34[var2]) && LevelManager.levelAdditionalData_TimerEtc[var_dc6 - 1][6 + var2] == 1) {
               Class_1b0.drawSprite2(LevelManager.var_2a1, (byte)(34 + var2 - 1), 0, LevelObjectData.var_9d[var2][0], LevelObjectData.var_9d[var2][1]);
            }

            if (LevelManager.var_99f.contains(var_d34[var2])) {
               Class_1b0.drawSprite2(LevelManager.var_2a1, (byte)39, 0, LevelObjectData.var_65[(short)(2 + var2)][0] - (LevelObjectData.spriteTypesArr[39][2] >> 1), LevelObjectData.var_65[(short)(2 + var2)][1]);
            }
         }

         Class_1b0.drawSprite2(LevelManager.var_2a1, (byte)29, 0, 0, 0);
         LevelObjectData.var_65[8][0] = LevelObjectData.spriteTypesArr[29][2] >> 1;
         LevelObjectData.var_65[8][1] = LevelObjectData.spriteTypesArr[29][3] >> 1;

         for(int var3 = 0 + LevelObjectData.spriteTypesArr[29][2]; var3 < var_1180 - LevelObjectData.spriteTypesArr[30][2]; var3 += LevelObjectData.spriteTypesArr[28][2]) {
            Class_1b0.drawSprite2(LevelManager.var_2a1, (byte)28, 0, var3, 0);
         }

         Class_1b0.drawSprite2(LevelManager.var_2a1, (byte)30, 0, var_1180 - LevelObjectData.spriteTypesArr[30][2], 0);
         LevelObjectData.var_65[1][0] = var_1180 - (LevelObjectData.spriteTypesArr[30][2] >> 1);
         LevelObjectData.var_65[1][1] = LevelObjectData.spriteTypesArr[30][3] >> 1;
         sub_96d(LevelManager.var_2a1);
         sub_9cc(LevelManager.var_2a1);
         var_62c = true;
      }

      var_5e0 = false;
      if (var_649) {
         sub_9f8(LevelManager.var_2a1);
      }

      var_649 = false;
      if (var_62c && (var_ca0 == 3 || var_ca0 == 4 || var_ca0 == 5 || var_ca0 == 6 || var_ca0 == 2)) {
         LevelManager.var_983 = var_900;
         LevelManager.sub_2df(LevelManager.var_2a1, true);
         var_62c = false;
      }

      var0.drawImage(LevelManager.var_25f, 0, 0, 0);
   }

   public static void sub_94f(Graphics var0, int var1, int var2, boolean var3) {
      if (var_12fc) {
         if (!var3 || var1 == var_bfe && var2 == var_c60) {
            if (var_ff4 != null) {
               int var4 = var2 > 60 ? -14 : 14;
               int var5 = var2;
               int var6 = var1;

               int var7;
               for(var7 = 2; var7 > -1; --var7) {
                  var6 += (var_1180 >> 1) - var6 >> 1;
                  var5 += var4;
                  Class_1b0.drawSprite2(var0, (byte)(15 + var7), 0, var6 - (LevelObjectData.spriteTypesArr[15 + var7][2] >> 1), var5 - (LevelObjectData.spriteTypesArr[15 + var7][3] >> 1));
               }

               var6 = (var_1180 >> 1) - (7 * LevelObjectData.spriteTypesArr[18][2] >> 1);
               var5 += var4 - (LevelObjectData.spriteTypesArr[3][3] >> 1);
               var_102d = var6;
               var_105e = var5 + (LevelObjectData.spriteTypesArr[3][3] - Class_1b0.var_a9 >> 1);
               var_109d = 7 * LevelObjectData.spriteTypesArr[18][2];
               if (var_10ea > var_102d + var_109d) {
                  var_10ea = var_102d + var_109d;
               }

               Class_1b0.drawSprite2(var0, (byte)3, 0, var6 - (LevelObjectData.spriteTypesArr[3][2] >> 1), var5);
               Class_1b0.drawSprite2(var0, (byte)3, 0, var6 + 7 * LevelObjectData.spriteTypesArr[18][2] - (LevelObjectData.spriteTypesArr[3][2] >> 1), var5);

               for(var7 = 0; var7 < 7; ++var7) {
                  Class_1b0.drawSprite2(var0, (byte)18, 0, var6, var5);
                  var6 += LevelObjectData.spriteTypesArr[18][2];
               }

            }
         }
      }
   }

   private static void sub_96d(Graphics var0) {
      short[] var1;
      int var2 = (var1 = Class_1b0.sub_533(String.valueOf(var_e38))).length * Class_1b0.var_12;
      int var3 = LevelObjectData.spriteTypesArr[29][2] + 2;
      int var4 = var_1180 - LevelObjectData.spriteTypesArr[30][2] - 2 - LevelObjectData.spriteTypesArr[31][2];
      int var5 = LevelObjectData.spriteTypesArr[28][3] - LevelObjectData.spriteTypesArr[32][3] - 1 >> 1;
      int var6 = var3 + LevelObjectData.spriteTypesArr[31][2] - 1;
      int var7 = var5 + (LevelObjectData.spriteTypesArr[32][3] - Class_1b0.var_a9 >> 1);
      Class_1b0.drawSprite2(LevelManager.var_2a1, (byte)31, 0, var3, var5);
      if (var3 + 1 < var4) {
         boolean var8 = var4 - var3 > LevelObjectData.spriteTypesArr[31][2];
         Class_1b0.drawSprite2(LevelManager.var_2a1, (byte)31, 0, var4, var5);
         Class_1b0.drawSprite2(LevelManager.var_2a1, (byte)32, 0, var4, var5);
         var6 = var4 + LevelObjectData.spriteTypesArr[31][2] - 1;

         for(var3 = var4 - LevelObjectData.spriteTypesArr[32][2]; var3 > LevelObjectData.spriteTypesArr[29][2] + 2; var3 -= LevelObjectData.spriteTypesArr[32][2]) {
            Class_1b0.drawSprite2(LevelManager.var_2a1, (byte)32, 0, var3, var5);
         }

         if (var8) {
            Class_1b0.drawSprite2(LevelManager.var_2a1, (byte)33, 0, LevelObjectData.spriteTypesArr[29][2] + 4, var7);
         }
      }

      Class_1b0.sub_47c(var0, var1, var6 - var2, var7 + 1);
   }

   private static void sub_9cc(Graphics var0) {
      if (var_5bb > 0) {
         int var1 = var_11cf - Class_1b0.var_a9 - 3;
         boolean var2 = false;
         Class_1b0.sub_47c(var0, Class_1b0.readTextFromLng((short)260), 3, var1);
         int var3 = 3 + Class_1b0.var_12;
         Class_1b0.sub_46a(var0, String.valueOf(var_10ff), var3, var1);
      }
   }

   private static void sub_9f8(Graphics var0) {
      int var2 = Class_1b0.var_a9 + 2;
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
      Class_19e.sub_25f(var0, var6, var7, var3, var4, 3, var2, true);

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
         Class_1b0.drawSprite2(var0, (byte)26, 0, var10, var11);
         Class_1b0.drawSprite2(var0, (byte)8, (byte)toolStats[var15][2], var10 + 2, var11 + 2);
         if (var_900.var_451[0] != var16 && var_900.var_451[1] != var16 && var_900.var_451[2] != var16) {
            if (toolStats[var15][0] > var_e38 || LevelManager.levelAdditionalData_TimerEtc[var_dc6 - 1][13 + sub_e5c(var16)] == 0) {
               Class_1b0.drawSprite2(var0, (byte)41, 0, var10 + 2, var11 + 2);
            }
         } else {
            Class_1b0.drawSprite2(var0, (byte)39, 0, var10, var11);
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
         Class_19e.sub_388(var0, var_729, var12, 1, 4);
         Class_19e.sub_388(var0, var13, var12, 2, 5);
         Class_1b0.drawSprite2(var0, (byte)38, 0, var14, var12);
         LevelObjectData.spriteTypesArr[43][2] = 7;
         LevelObjectData.spriteTypesArr[43][3] = 9;
         Class_1b0.drawSprite2(var0, (byte)43, Class_1b0.readTextFromLng((short)241)[0], var14 + (LevelObjectData.spriteTypesArr[38][2] >> 1) - (LevelObjectData.spriteTypesArr[43][2] >> 1), var12 + (LevelObjectData.spriteTypesArr[38][3] >> 1) - (LevelObjectData.spriteTypesArr[43][3] >> 1));
         LevelObjectData.spriteTypesArr[43][2] = (short)Class_1b0.var_12;
         LevelObjectData.spriteTypesArr[43][3] = (short)Class_1b0.var_a9;
      }

      sub_96d(LevelManager.var_2a1);
      var_bfe = var_729 + var_6c8 * (LevelObjectData.spriteTypesArr[26][2] + var_798) + (LevelObjectData.spriteTypesArr[26][2] >> 1);
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
            sub_2c8((byte)11, (byte[])null, var_ea3, var_eff, new short[]{126}, (short)140);
            break;
         case 151:
            musicManager.switchMusicPlayer(4, 1);
            sub_2c8((byte)11, (byte[])null, var_ea3, var_eff, new short[]{126}, (short)140);
            break;
         case 152:
            musicManager.switchMusicPlayer(4, 1);
            sub_2c8((byte)31, (byte[])null, (short)152, var_eff, new short[]{126}, (short)140);
            break;
         case 153:
            musicManager.switchMusicPlayer(5, 1);
            sub_2c8((byte)38, (byte[])null, (short)153, (Object[])null, new short[]{126}, (short)141);
            break;
         case 164:
            musicManager.switchMusicPlayer(5, 1);
            sub_2c8((byte)15, (byte[])null, (short)164, (Object[])null, new short[]{126}, (short)131);
            break;
         case 165:
            musicManager.switchMusicPlayer(5, 1);
            sub_2c8((byte)40, (byte[])null, (short)165, (Object[])null, new short[]{126}, (short)132);
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

         if (var_bfe != var_b74 || var_c60 != var_bca) {
            var_b74 += Math.abs(var_bfe - var_b74) == 1 ? var_bfe - var_b74 : var_bfe - var_b74 >> 1;
            var_bca += Math.abs(var_c60 - var_bca) == 1 ? var_c60 - var_bca : var_c60 - var_bca >> 1;
            if (var_bfe == var_b74 && var_c60 == var_bca) {
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
      switch(var0 = var_13a7.sub_97(var_93a)) {
      case 2:
         sub_b3f((byte)2);
         break;
      case 3:
         sub_b3f((byte)3);
         break;
      case 4:
         sub_b3f((byte)0);
         break;
      case 5:
         sub_b3f((byte)1);
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
               var_93a = 999999;
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
            Class_205 var10000;
            if (var_900.var_451[0] != var1 && var_900.var_451[1] != var1 && var_900.var_451[2] != var1) {
               if (toolStats[sub_e5c(var1)][0] > var_e38) {
                  sub_2c8((byte)0, (byte[])null, (short)181, new Object[]{new Integer(toolStats[sub_e5c(var1)][0]), new Integer(var_e38)}, new short[]{126}, (short)136);
                  var_93a = 999999;
                  var_649 = true;
                  var_62c = true;
                  return;
               }

               if (LevelManager.levelAdditionalData_TimerEtc[var_dc6 - 1][13 + sub_e5c(var1)] == 0) {
                  sub_2c8((byte)0, (byte[])null, (short)182, (Object[])null, new short[]{126}, (short)136);
                  var_93a = 999999;
                  var_649 = true;
                  var_62c = true;
                  return;
               }

               var2 = LevelManager.thiefStats[var_f0d][0] - var_900.var_29a;
               if (toolStats[sub_e5c(var1)][1] > var2) {
                  sub_2c8((byte)0, (byte[])null, (short)(var2 == 0 ? 188 : 187), new Object[]{new Integer(toolStats[sub_e5c(var1)][1]), new Short((short)(41 + var_f0d)), new Integer(var2)}, new short[]{126}, (short)136);
                  var_93a = 999999;
                  var_649 = true;
                  var_62c = true;
                  return;
               }

               for(int var3 = 0; var3 < 3; ++var3) {
                  if (var_900.var_451[var3] == 116) {
                     var_900.var_451[var3] = var1;
                     var_e38 -= toolStats[sub_e5c(var1)][0];
                     var10000 = var_900;
                     var10000.var_29a = (byte)(var10000.var_29a + toolStats[sub_e5c(var1)][1]);
                     break;
                  }
               }
            } else {
               for(var2 = 0; var2 < 3; ++var2) {
                  if (var_900.var_451[var2] == var1) {
                     var_900.var_451[var2] = 116;
                     var_e38 += toolStats[sub_e5c(var1)][0];
                     var10000 = var_900;
                     var10000.var_29a = (byte)(var10000.var_29a - toolStats[sub_e5c(var1)][1]);
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
               if (!var_d50.isEmpty()) {
                  ++var2;
                  var5[0] = 220;
               }

               var5[var2++] = 217;
               if (LevelManager.var_7f3 > 0) {
                  var5[var2++] = 218;
               }

               if (var_dc6 > 6 || var_dc6 == 5) {
                  var5[var2++] = 219;
               }

               short[] var6 = new short[var2];
               Class_3d.sub_1cf(var5, 0, var6, 0, var2);
               sub_22b((byte)6, new byte[]{13, 0}, var6, Class_1b0.readTextFromLng((short)136), (byte)2);
               break;
            case 1:
               var_13a7.sub_3d3();
               var_1217 = 1;
               break;
            case 2:
               var_f0d = 0;
               if (var_dc6 < 6) {
                  sub_2c8((byte)0, (byte[])null, (short)183, (Object[])null, new short[]{126}, (short)137);
               } else {
                  sub_22b((byte)2, new byte[]{5, var_f0d}, new short[]{125, 122}, Class_1b0.readTextFromLng((short)41), (byte)2);
               }
               break;
            case 3:
            case 4:
            case 5:
            case 6:
               var_f0d = var_900.var_3a;
               short[] var4;
               if (LevelManager.var_99f.contains(var_900)) {
                  var4 = new short[]{125, 122, 123};
               } else {
                  var4 = new short[]{124, 122};
               }

               sub_22b((byte)2, new byte[]{5, var_f0d}, var4, Class_1b0.readTextFromLng((short)(41 + var_f0d)), (byte)2);
               break;
            case 7:
               if (LevelManager.var_99f.size() == 0 && var_dc6 == 1) {
                  sub_2c8((byte)33, (byte[])null, (short)149, (Object[])null, new short[]{126}, (short)136);
                  return;
               }

               var_1217 = 2;
               var_13a7.sub_3d3();
               break;
            case 8:
               var_93a = 999999;
               sub_21a();
               return;
            }
         }
      }

      var_93a = 999999;
   }

   private static void sub_ab6() {
      var_ff4 = null;
      var_6ac = false;
      var_5e0 = true;
      var_bfe = LevelObjectData.var_65[var_ca0][0];
      var_c60 = LevelObjectData.var_65[var_ca0][1];
      boolean var0 = false;

      for(int var1 = 0; var1 < var_1123.length; ++var1) {
         if (var_1123[var1] != 116 && var_1123[var1] != var_900.var_451[var1]) {
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
      int var1 = (var0 = LevelManager.levelAdditionalData_TimerEtc[var_dc6 - 1][0] + 0) / 60;
      int var2 = (var0 - var1 * 60) / 10;
      int var3 = var0 - var1 * 60 - var2 * 10;
      if (var_dc6 < 7) {
         sub_2c8((byte)41, new byte[]{5, 5}, LevelManager.levelAdditionalData_TimerEtc[var_dc6 - 1][25], new Object[]{new Integer(var1), new Integer(var2), new Integer(var3)}, new short[]{126}, (short)133);
      } else {
         sub_2db((byte)41, new byte[]{5, 5}, LevelManager.levelAdditionalData_TimerEtc[var_dc6 - 1][25], new Object[]{new Integer(var1), new Integer(var2), new Integer(var3)}, new short[]{126}, (short)134, new Object[]{new Integer(var_dc6 - 6)});
      }
   }

   private static void sub_b3f(byte var0) {
      if (var_6ac) {
         switch(var0) {
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

         var_bfe = var_729 + var_6c8 * (LevelObjectData.spriteTypesArr[26][2] + var_798) + (LevelObjectData.spriteTypesArr[26][2] >> 1);
         var_c60 = var_762 + var_6d8 * (LevelObjectData.spriteTypesArr[26][3] + var_7d3) + (LevelObjectData.spriteTypesArr[26][3] >> 1);
         sub_b52();
      } else {
         var_ca0 = var_b4c[var_ca0][var0];
         var_bfe = LevelObjectData.var_65[var_ca0][0];
         var_c60 = LevelObjectData.var_65[var_ca0][1];
         switch(var_ca0) {
         case 2:
            var_900 = var_d34[0];
            break;
         case 3:
            if (var_d50.contains(var_d34[1]) || LevelManager.levelAdditionalData_TimerEtc[var_dc6 - 1][7] == 0) {
               var_ca0 = var_b5a[0][var0];
               sub_b3f(var0);
               return;
            }

            var_900 = var_d34[1];
            break;
         case 4:
            if (var_d50.contains(var_d34[2]) || LevelManager.levelAdditionalData_TimerEtc[var_dc6 - 1][8] == 0) {
               var_ca0 = var_b5a[1][var0];
               sub_b3f(var0);
               return;
            }

            var_900 = var_d34[2];
            break;
         case 5:
            if (!var_d50.contains(var_d34[3]) && LevelManager.levelAdditionalData_TimerEtc[var_dc6 - 1][9] != 0) {
               var_900 = var_d34[3];
               break;
            }

            var_ca0 = var_b5a[2][var0];
            sub_b3f(var0);
            return;
         case 6:
            if (var_d50.contains(var_d34[4]) || LevelManager.levelAdditionalData_TimerEtc[var_dc6 - 1][10] == 0) {
               var_ca0 = var_b5a[3][var0];
               sub_b3f(var0);
               return;
            }

            var_900 = var_d34[4];
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
         short[] var0 = Class_1b0.sub_569((short)263, new Object[]{new Short((short)var_e17[var_6c8][var_6d8]), String.valueOf(toolStats[sub_e5c(var_e17[var_6c8][var_6d8])][0]), String.valueOf(toolStats[sub_e5c(var_e17[var_6c8][var_6d8])][1])});
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
            Class_3d.callGc();
            threadSleep(10L);
            threadSleep(10L);
            LevelManager.sub_74();
            break;
         case 2:
            var_1217 = 0;
            //var10000 = new int[]{1, 4, 5, 3};
            LevelManager.sub_48();
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
            sub_7c1();
         }

         var_157e = false;
      }
   }

   private static void sub_b8e(Graphics var0) {
      if (var_1217 != 0) {
         short[] var1;
         int var2 = (var1 = Class_1b0.readTextFromLng((short)130)).length * Class_1b0.var_12;
         byte var3 = Class_1b0.var_a9;
         int var4 = (var_1180 >> 1) - (var2 >> 1);
         int var5 = (var_11cf >> 1) - (var3 >> 1);
         Class_1b0.sub_20e(var0, var4 - 8, var5 - 4, var2 + 16, var3 + 8, true, 11665470);
         Class_1b0.sub_47c(var0, var1, var4, var5);
         var_123b = true;
      }
   }

   private static void sub_ba6() {
      var_6bc = false;
      short[] var0 = new short[]{0};
      if (!var_6ac) {
         var_f69 = 0;
         var_f83 = var_11cf - Class_1b0.var_a9 - 2;
         var_fa9 = var_1180;
         var0 = Class_1b0.readTextFromLng((short)LevelObjectData.var_65[var_ca0][2]);
         var_6bc = !var_129e[7 + var_ca0] && var_5bb == -1;
         if (var_12fc && var_6bc) {
            var_129e[7 + var_ca0] = true;
            Class_1b0.sub_7c6();
            var_6bc = false;
         }
      }

      if (var0 != null) {
         sub_daa(var0, var_f69, var_f83, var_fa9, 1);
      }

   }

   private static boolean sub_bbb() {
      var_93a = 999999;
      var_5e0 = true;
      if (var_6ac) {
         var_649 = true;
      }

      if (Class_19e.var_838 == null) {
         return false;
      } else {
         Object var0 = Class_19e.var_838;
         short var1 = 0;
         if (var0 instanceof Short) {
            var1 = ((Short)var0).shortValue();
         }

         int var3;
         switch(Class_19e.var_7ed) {
         case 2:
            Class_205 var12 = var_d34[var_f0d];
            switch(var1) {
            case 122:
               sub_2c8((byte)0, new byte[]{5, var12.var_3a}, (short)(var12.var_3a == 0 ? 147 : 148), new Object[]{new Integer(LevelManager.thiefStats[var12.var_3a][0]), new Integer(LevelManager.thiefStats[var12.var_3a][1]), new Short((short)(var12.var_3a + 99))}, new short[]{126}, (short)(41 + var12.var_3a));
               return true;
            case 123:
               var12.sub_19d();
               var12.sub_3e7(true);
               LevelManager.var_99f.removeElement(var12);
               return false;
            case 124:
               LevelManager.var_99f.addElement(var_d34[var_f0d]);
               var_d34[var_f0d].sub_1e();
               var_6ac = true;
               var_12fc = false;
               var_649 = true;
               var_6c8 = 0;
               var_6d8 = 0;
               var_bfe = 24;
               var_c60 = 44;
               Class_3d.sub_1cf(var12.var_451, 0, var_1123, 0, var_1123.length);
               return sub_1b8((byte)5, (byte)5, var12.var_3a, false);
            case 125:
               var_6ac = true;
               var_649 = true;
               var_12fc = false;
               var_6c8 = 0;
               var_6d8 = 0;
               Class_3d.sub_1cf(var12.var_451, 0, var_1123, 0, var_1123.length);
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
               Class_1b0.sub_870();
               sub_3f1();
               break;
            case 209:
               sub_2c8((byte)0, (byte[])null, (short)8, (Object[])null, new short[]{126}, (short)135);
               return true;
            }

            return true;
         case 4:
            sub_670();
            if (MusicManager.someMusicIndexVar2 != var_129e[0]) {
               MusicManager.someMusicIndexVar2 = var_129e[0];
               if (MusicManager.someMusicIndexVar2) {
                  musicManager.switchMusicPlayer(0, -1);
               } else {
                  musicManager.clearCurrentMusicPlayer();
               }
            }

            MusicManager.someMusicIndexVar = var_129e[1];
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
                  sub_2c8((byte)28, new byte[]{5, 5}, (short)177, new Object[]{new Integer(LevelManager.var_7f3)}, new short[]{126, 127}, (short)189);
                  return true;
               }

               return false;
            case 219:
               var3 = 0;
               boolean var11 = false;

               for(int var13 = 1; var13 < 6; ++var13) {
                  if (LevelManager.var_779[var13] > 0) {
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
               (var14 = new Object[2 + var3])[0] = new Integer(LevelManager.var_779[0]);
               var14[1] = new Short((short)(var11 ? 175 : 176));
               var3 = 2;

               for(int var15 = 1; var15 < 6; ++var15) {
                  if (LevelManager.var_779[var15] > 0) {
                     var14[var3] = new Short((short)(235 + var15));
                     ++var3;
                  }
               }

               sub_2c8((byte)25, (byte[])null, (short)174, var14, new short[]{126, 127}, (short)137);
               return true;
            case 220:
               return sub_c62();
            default:
               return false;
            }
         case 11:
         case 31:
            if (var_d50.size() <= var_d82.size()) {
               sub_cec();
            } else {
               Short var10 = new Short((short)160);
               Short var5 = new Short((short)161);
               Object[] var6 = new Object[(var_d50.size() << 1) - 1];
               int var7 = 0;

               for(int var8 = 0; var8 < var6.length; var8 += 2) {
                  var6[var8] = new Short((short)(((Class_205)var_d50.elementAt(var7++)).var_3a + 41));
                  if (var8 != var6.length - 1) {
                     var6[var8 + 1] = var10;
                  }

                  if (var8 == var6.length - 3) {
                     var6[var8 + 1] = var5;
                  }
               }

               musicManager.switchMusicPlayer(4, 1);
               sub_2c8((byte)13, new byte[]{48, 0}, (short)159, var6, new short[]{126}, (short)136);
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
               if (var_5bb > 0) {
                  sub_2c8((byte)35, (byte[])null, (short)158, new Object[]{new Integer(var_10ff)}, new short[]{126}, (short)191);
                  --var_10ff;
               } else {
                  sub_c15();
               }

               return true;
            }
            break;
         case 15:
            Class_1b0.sub_759();
            var_ab2 = 0;
            sub_7c1();
            return true;
         case 19:
            if (var1 == 199) {
               sub_3f1();
            }

            return true;
         case 20:
            var_9fe = var1 - 228;
            sub_2c8((byte)26, new byte[]{5, 5}, (short)(var1 == 234 ? 180 : 179), new Object[]{new Short((short)(221 + var_9fe)), new Integer(LevelManager.var_7a3[var_9fe])}, new short[]{126, 127}, (short)189);
            return true;
         case 25:
            if (var0.equals(String.valueOf(126))) {
               return sub_c29();
            }
            break;
         case 26:
            if (var0.equals(String.valueOf(126))) {
               if (var_e38 >= LevelManager.var_7a3[var_9fe]) {
                  var_e38 -= LevelManager.var_7a3[var_9fe];
                  LevelManager.var_7a3[var_9fe] = 0;
                  if (221 + var_9fe == 227) {
                     sub_2c8((byte)34, new byte[]{5, 5}, LevelManager.levelAdditionalData_TimerEtc[var_dc6 - 1][26], (Object[])null, new short[]{126}, (short)189);
                     return true;
                  }

                  return sub_c29();
               }

               sub_2c8((byte)0, (byte[])null, (short)181, new Object[]{new Integer(LevelManager.var_7a3[var_9fe]), new Integer(var_e38)}, new short[]{126}, (short)136);
               return true;
            }
            break;
         case 28:
            if (var0.equals(String.valueOf(126))) {
               if (var_e38 < LevelManager.var_7f3) {
                  sub_2c8((byte)0, (byte[])null, (short)181, new Object[]{new Integer(LevelManager.var_7f3), new Integer(var_e38)}, new short[]{126}, (short)136);
                  return true;
               }

               var_e38 -= LevelManager.var_7f3;
               LevelManager.var_7f3 = 0;
            }
            break;
         case 29:
            byte var9 = Byte.parseByte((String)var0);

            for(var3 = 0; var3 < var_d50.size(); ++var3) {
               Class_205 var4 = (Class_205)var_d50.elementAt(var3);
               if (var9 == var3) {
                  var_900 = var4;
                  sub_2c8((byte)30, new byte[]{5, var4.var_3a}, (short)178, new Object[]{new Integer(var4.var_3fa[0] * 1000)}, new short[]{126, 127}, (short)(41 + var4.var_3a));
                  return true;
               }
            }

            return false;
         case 30:
            if (var0.equals(String.valueOf(126))) {
               int var2 = var_900.var_3fa[0] * 1000;
               if (var_e38 < var2) {
                  sub_2c8((byte)0, (byte[])null, (short)181, new Object[]{new Integer(var2), new Integer(var_e38)}, new short[]{126}, (short)136);
                  return true;
               }

               var_d50.removeElement(var_900);
               var_900.sub_41a();
               var_900.sub_3e7(false);
               var_900.var_29a = 0;
               var_e38 -= var2;
            }
            break;
         case 32:
            var_ab2 = 0;
            sub_7c1();
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
            Class_1b0.sub_759();
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
      var_e38 = var_e86;
      LevelManager.someLevelDataVarLast = LevelManager.var_c9e;
      LevelManager.sub_140(LevelManager.var_8ff, LevelManager.alarmWithZonesMap);
      LevelManager.sub_f0(LevelManager.var_896, LevelManager.var_84c);
      LevelManager.var_99f.removeAllElements();
      Enumeration var0 = LevelManager.var_9d3.elements();

      while(var0.hasMoreElements()) {
         Class_205 var1;
         (var1 = (Class_205)var0.nextElement()).sub_41a();
         var1.sub_44c();
         LevelManager.var_99f.addElement(var1);
      }

      var_d50.removeAllElements();
      var0 = var_d82.elements();

      while(var0.hasMoreElements()) {
         var_d50.addElement(var0.nextElement());
      }

      for(int var2 = 0; var2 < 3; ++var2) {
         var_d34[0].var_451[var2] = LevelManager.var_a1e[var2];
      }

      var_d34[0].sub_41a();
      var_d34[0].sub_2a1();
      sub_d4e(var_dc6);
      Class_1b0.sub_71d();
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
         sub_260((byte)20, (byte[])null, var4, var2, Class_1b0.readTextFromLng((short)143), (byte)2);
         return true;
      } else {
         return false;
      }
   }

   private static boolean sub_c62() {
      if (var_d50.isEmpty()) {
         return false;
      } else {
         short[] var0 = new short[var_d50.size()];
         Object[][] var1 = new Object[var_d50.size()][1];
         byte[][] var2 = new byte[var_d50.size()][2];

         for(int var3 = 0; var3 < var_d50.size(); ++var3) {
            Class_205 var4 = (Class_205)var_d50.elementAt(var3);
            var0[var3] = (short)(47 + var4.var_3a - 1);
            var1[var3][0] = new Integer(var4.var_3fa[0] * 1000);
            var2[var3][0] = 42;
            var2[var3][1] = var4.var_3a;
         }

         sub_2a5((byte)29, false, (byte[])null, var0, var1, var2, (boolean[])null, (short)46, (byte)2);
         return true;
      }
   }

   private static void sub_c89(byte var0) {
      int var2 = 0;
      int var1;
      if (LevelManager.sub_bc9(var0) != 113 && LevelManager.sub_bc9(var0) != 114) {
         for(var1 = 0; var1 < Class_205.toolUsingTimeStats.length; ++var1) {
            if (Class_205.toolUsingTimeStats[var1][var0] > 0 && var1 != 11) {
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

         for(var1 = 0; var1 < Class_205.toolUsingTimeStats.length; ++var1) {
            if (Class_205.toolUsingTimeStats[var1][var0] > 0 && var1 != 11) {
               var3[var2] = 82;
               var4[var2][0] = new Short((short)(51 + var1));
               var4[var2][1] = new Integer(Class_205.toolUsingTimeStats[var1][var0]);
               var5[var2][0] = 4;
               var5[var2][1] = LevelObjectData.var_da[var1][4];
               ++var2;
            }
         }

         sub_29b((byte)0, new byte[]{8, var0}, var3, var4, var5, (boolean[])null, LevelManager.sub_bc9(var0), (byte)1);
      } else {
         sub_2c8((byte)0, new byte[]{8, var0}, (short)(LevelManager.sub_bc9(var0) == 113 ? 83 : 84), new Object[]{new Integer(Class_205.toolUsingTimeStats[0][var0])}, new short[]{126}, LevelManager.sub_bc9(var0));
      }
   }

   private static void sub_cec() {
      short[] var0;
      if (var_10ff > 0 && var_5bb != -1) {
         var0 = new short[]{192, 191};
      } else {
         var0 = new short[]{192};
      }

      sub_22b((byte)14, (byte[])null, var0, Class_1b0.readTextFromLng((short)130), (byte)1);
   }

   private static void sub_d10() {
      if (var_5bb < 2) {
         var_10ff = 3;
      }

      if (LevelManager.var_99f.size() > 0) {
         Class_205 var1;
         for(Enumeration var0 = LevelManager.var_99f.elements(); var0.hasMoreElements(); var1.var_29a = 0) {
            (var1 = (Class_205)var0.nextElement()).sub_3e7(false);
            var1.sub_41a();
         }

         LevelManager.var_99f.removeAllElements();
      }

      var_d34[0].sub_3e7(false);
      var_d34[0].sub_41a();
      var_d34[0].var_29a = 0;
      var_e86 = var_e38;
      sub_d4e((byte)(var_dc6 + 1));
      Class_1b0.sub_6f5();
      Class_1b0.sub_837();
   }

   public static void sub_d4e(byte var0) {
      var_1217 = 3;
      if (var_5bb == -1 && var0 > 6) {
         var_ea3 = 165;
      } else if (var0 > 26) {
         var_ea3 = 164;
      } else {
         if (var_dc6 != var0) {
            var_dc6 = var0;
            LevelManager.loadLevel(var_dc6);
            if (var_dc6 == 1 || var_dc6 == 7) {
               LevelManager.var_99f.removeAllElements();
               var_d50.removeAllElements();
            }

            for(int var1 = 0; var1 < var_d34.length; ++var1) {
               var_d34[var1].sub_1e();
               var_d34[var1].sub_3e7(false);
               var_d34[var1].sub_41a();
               var_d34[var1].var_29a = 0;
            }

            if (var_dc6 == 1) {
               var_ea3 = 2;

               for(byte var2 = 2; var2 < var_129e.length; ++var2) {
                  var_129e[var2] = false;
               }

               Class_1b0.sub_7c6();
            } else {
               var_ea3 = 9;
            }
         }

         LevelManager.var_c64 = 0;
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
      if (var_ff4 != null && (var_b74 == var_bfe && var_bca == var_c60 || var_26f == 1) && (var_12fc || var_6ac)) {
         Class_1b0.drawText(var0, var_ff4, var_10ea, var_105e, var_102d, var_102d + var_109d);
      }

   }

   private static void sub_e10() {
      if (var_ff4 != null && (var_12fc || var_6ac)) {
         if (var_10c8 == -2 && var_8a4 > 3) {
            var_10c8 = -1;
         }

         if (var_10c8 == -1 && var_10ea + var_ff4.length * Class_1b0.var_12 < var_102d + var_109d) {
            return;
         }

         if (var_10c8 > -2) {
            --var_10ea;
         }

         if (var_10ea + var_ff4.length * Class_1b0.var_12 < var_102d) {
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

            for(byte var2 = 0; var2 < var_129e.length; ++var2) {
               var_129e[var2] = var12[var2] == 1;
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
      String var1 = Class_1b0.sub_5a0((short)275);
      var_a60 = Class_1b0.sub_80d();
      short[][] var2 = (short[][])((short[][])var_a60.elementAt(0));
      int[] var3 = (int[])((int[])var_a60.elementAt(1));

      int var0;
      for(var0 = 0; var0 < 5; ++var0) {
         var1 = var1 + "&n" + var0 + "=" + Class_1b0.sub_5df(var2[var0]) + "&s" + var0 + "=" + var3[var0];
      }

      var1 = var1.replace(' ', '_');
      HttpConnection var4 = null;
      InputStream var5 = null;
      DataInputStream var6 = null;
      boolean var7 = false;

      try {
         Display.getDisplay(var_3e2).setCurrent((Displayable)null);
         var4 = (HttpConnection)Connector.open(var1, 3, true);
         Display.getDisplay(var_3e2).setCurrent(var_13a7);
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
                     var2[var0] = Class_1b0.sub_533(var11);
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

      Class_1b0.sub_7ec(var2, var3);
      Class_3d.callGc();
      return var7;
   }

   public final void hideNotify() {
      sub_4d();
   }

   public final void showNotify() {
      this.sub_29();
   }

   public final void sizeChanged(int var1, int var2) {
      if (var_13cf != -1 && var_26f == 5) {
         var_26f = var_2b9;
         var_1180 = LevelManager.screenWidth = this.getWidth();
         var_11cf = LevelManager.screenHeight = this.getHeight();
         var_130f = null;
      }

   }

   static {
      var_bfe = var_b74;
      var_c60 = var_bca;
      var_d34 = new Class_205[5];
      var_d50 = new Vector();
      var_d82 = new Vector();
      var_dc6 = -1;
      toolStats = new short[][]{{50, 10, 0, 4}, {120, 15, 1, 6}, {7000, 11, 2, 11}, {3000, 1, 3, 9}, {1500, 8, 4, 7}, {12000, 22, 5, 12}, {200, 2, 6, 8}, {4000, 5, 7, 10}, {30000, 9, 8, 10}, {2000, 10, 9, 5}, {9000, 20, 10, 5}, {500, 1, 11, 13}};
      var_dff = toolStats.length / 6;
      var_e17 = new byte[6][var_dff];
      var_e38 = 4000;
      var_e86 = 4000;
      var_10ff = 3;
      var_1123 = new byte[3];
      var_114a = 0;
      var_1217 = 0;
      var_129e = new boolean[]{false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false};
      var_13cf = -1;
      var_157e = false;
   }
}
