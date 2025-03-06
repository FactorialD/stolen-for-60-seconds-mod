package main;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Graphics;

public final class Class_19e implements LevelObjectData {
   private static byte var_51 = 2;
   public static final int var_ac;
   private static final int var_d0;
   public static int var_12e;
   public static int var_18c;
   public static int var_1bd;
   public static int var_1cf;
   private static int var_202;
   public static int var_257;
   public static int var_285;
   public static int var_297;
   public static int var_2b5;
   public static int var_2e2;
   public static int var_327;
   private static int var_34f;
   private static int var_3ad;
   private static int var_3e5;
   private static int var_424;
   public static byte var_45d;
   private static int var_46d;
   private static int var_4fa;
   public static int var_508;
   private static int var_557;
   private static boolean var_5b6;
   private static int var_5ff;
   private static int var_644;
   private static int var_662;
   private static boolean var_673;
   private static boolean var_6ce;
   private static boolean var_780;
   public static Class_178 var_790;
   public static byte var_7c6;
   public static byte var_7ed;
   public static Object var_838;
   public static byte[] var_850;
   public static short[] var_882;
   public static short[] var_89d;
   public static short[] var_8ca;
   public static Object[][] var_914;
   public static int[] var_95a;
   private static int var_9a0;
   public static boolean[] var_a44;
   public static boolean var_a80;
   public static byte[][] var_abc;
   private static short[] var_b16;
   private static final byte[] var_b61;
   private static byte var_bf0;
   public static boolean var_c24;
   public static boolean var_c2e;

   public static void sub_23() {
      var_257 = 0;
      var_45d = 0;
      var_12e = 0;
      var_18c = 0;
      var_1bd = 0;
      var_1cf = 0;
      var_2b5 = 0;
      var_285 = 0;
      var_297 = 0;
      var_4fa = 0;
      var_46d = 0;
      var_557 = 0;
      var_202 = 0;
      var_508 = 0;
      var_673 = false;
      var_838 = null;
      var_850 = null;
      var_882 = null;
      var_89d = null;
      var_8ca = null;
      var_914 = (Object[][])null;
      var_95a = null;
      var_5b6 = false;
      var_9a0 = 0;
      var_a44 = null;
      var_a80 = false;
      var_abc = (byte[][])null;
      var_b16 = null;
   }

   public static void sub_6f() {
      var_6ce = false;
      int var0 = LevelManager.screenWidth - 2 - 2 - 2;
      var_257 = LevelManager.screenHeight - 3 - 3 - (var_7ed == 22 ? 0 : var_d0 - 5);
      if (Class_178.var_2f7 == 0) {
         var0 += 4;
      }

      var_45d = (byte)(Class_1b0.var_a9 + Class_1b0.var_a9 / 5);
      var_202 = 4 + var_45d;
      var_1bd = var_882.length + 6;
      if (var_7c6 == 0) {
         sub_c6(var0);
      } else {
         sub_db(var0);
      }

      if (var_850 != null) {
         var_34f = var_12e + (var_1bd - LevelObjectData.spriteTypesArr[var_850[0]][2] >> 1);
         var_3ad = var_18c + var_202 + 4;
      }

      var_3e5 = var_12e + (var_1bd - var_882.length * Class_1b0.var_12 >> 1);
      var_424 = var_18c + 2 + (var_202 - Class_1b0.var_a9 >> 1);
      if (var_673) {
         var_5ff = var_327 - LevelObjectData.spriteTypesArr[44][3] * 2;
         var_644 = var_12e + var_1bd - var_662 - 2 - 1;
      }

      var_5b6 = true;
      var_6ce = true;
      var_780 = Class_178.var_338;
   }

   private static void sub_c6(int var0) {
      int var1 = (var0 - 4 - 5 - 5) / Class_1b0.var_12;
      int var2 = sub_19b();
      var_2e2 = var_1bd;
      if (var_b16.length > var1 * var2) {
         var_2e2 = var1;
      } else {
         var_46d = 1;

         while(true) {
            if (var_2e2 > var1) {
               var_2e2 = var1;
            }

            if (var_46d > var2) {
               var_46d = var2;
            }

            if (var_b16.length <= var_2e2 * var_46d || var_2e2 == var1 && var_46d == var2) {
               break;
            }

            ++var_2e2;
            ++var_46d;
         }
      }

      var_4fa = Class_1b0.sub_1e5(var_b16, var_2e2);
      var_2b5 = var_2e2 * Class_1b0.var_12;
      if (var_4fa > var2) {
         var_46d = var2;
         var_2b5 -= var_662;
         var_2e2 = sub_500(var_2b5);
         var_4fa = Class_1b0.sub_1e5(var_b16, var_2e2);
         var_673 = true;
      } else {
         var_46d = var_4fa;
         var_673 = false;
      }

      int var3 = var_673 ? var_662 : 0;
      var_1bd = Math.min(var_2b5 + var3 + 4 + 5 + 5, var0);
      var_327 = var_46d * var_45d;
      var_1cf = var_202 + var_327 + 4 + 3 + 2 + sub_1ea();
      sub_151();
   }

   private static void sub_db(int var0) {
      if (Class_26a.sub_1e0() && MM.var_5a.hasPointerEvents()) {
         var_51 = 9;
      }

      var_45d += var_c2e ? 1 : var_51;
      var_95a = new int[var_8ca.length];
      int var1 = 0;
      if (var_a80) {
         var1 = LevelObjectData.spriteTypesArr[6][2] + 2;
      }

      if (var_abc != null) {
         var1 += LevelObjectData.spriteTypesArr[var_abc[var_abc.length - 1][0]][2] + 4;
      }

      int var3;
      int var2 = (var3 = sub_500(var1 + 4 + 5 + 5)) * Class_1b0.var_12;
      var_1bd += 2;

      int var4;
      for(var4 = 0; var4 < var_8ca.length; ++var4) {
         var_1bd = Math.max(var_1bd, sub_1fc(var4).length + 1 + var3);
      }

      var_1bd = Math.min(var_1bd * Class_1b0.var_12, var0);
      var_4fa = sub_ef(var_1bd - var2);
      if ((var4 = sub_19b()) >= var_4fa) {
         var4 = var_4fa;
         var_673 = false;
      } else {
         var_673 = true;
         var_4fa = sub_ef(var_1bd - var2);
         var_2b5 = -Class_1b0.var_12;
      }

      var_4fa = var_8ca.length;
      var_1cf = var4 * var_45d + var_202 + 4 + 3 + 2 + sub_1ea();
      sub_151();
      var_285 += var1;
      var_46d = sub_19b();
      var_2b5 += var_1bd - var2;
      var_2e2 = sub_500(var_2b5);
      var_327 = var_46d * var_45d;
   }

   private static byte sub_ef(int var0) {
      byte var1 = 0;
      int var2 = sub_500(var0);

      for(int var3 = 0; var3 < var_8ca.length; ++var3) {
         var_95a[var3] = Class_1b0.sub_1e5(sub_1fc(var3), var2);
         if (var_abc != null) {
            int var4 = var_abc[var3] == null ? 1 : LevelObjectData.spriteTypesArr[var_abc[var3][0]][3];

            int var5;
            for(var5 = 0; var4 > var_45d; ++var5) {
               var4 -= var_45d;
            }

            if (var4 > 0) {
               ++var5;
            }

            if (var_95a[var3] < var5) {
               var_95a[var3] = var5;
            }
         }

         var1 = (byte)(var1 + var_95a[var3]);
      }

      return var1;
   }

   private static void sub_151() {
      var_12e = LevelManager.screenWidth - var_1bd >> 1;
      var_18c = LevelManager.screenHeight - (var_7ed == 22 ? 0 : var_d0 - 5) - var_1cf >> 1;
      var_285 = var_12e + 2 + 5;
      var_297 = var_18c + 2 + var_202 + 3 + sub_1ea();
   }

   private static int sub_19b() {
      int var0;
      return (var0 = var_257 - 4 - var_202 - 3 - 2 - sub_1ea()) / var_45d + Class_1b0.sub_619(var0, var_45d);
   }

   private static int sub_1ea() {
      return var_850 != null ? LevelObjectData.spriteTypesArr[var_850[0]][3] + 4 : 0;
   }

   private static short[] sub_1fc(int var0) {
      short[] var1;
      if (var_914 != null) {
         var1 = Class_1b0.sub_569(var_8ca[var0], var_914[var0]);
      } else {
         var1 = Class_1b0.readTextFromLng(var_8ca[var0]);
      }

      return var1;
   }

   public static void sub_25f(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      if (var7) {
         sub_29c(var0);
      }

      var0.setClip(0, 0, LevelManager.screenWidth, LevelManager.screenHeight);
      var0.setColor(0);

      for(int var8 = 1; var8 < 3; ++var8) {
         var0.drawRect(var1 + 2 + var8, var2 + 2 + var8, var3 - (var8 << 1), var4 - (var8 << 1));
      }

      var0.setStrokeStyle(0);
      Class_1b0.sub_20e(var0, var1, var2, var3, var4, true, var5 > 0 ? 9211020 : 11446175);
      if (var5 > 0) {
         Class_1b0.sub_20e(var0, var1 + var5, var2 + var5, var3 - (var5 << 1), var4 - (var5 << 1), false, 11446175);
      }

      Class_1b0.sub_20e(var0, var1 + var5, var2 + var5, var3 - (var5 << 1), var6, false, 6518395);
      Class_1b0.drawSprite2(var0, (byte)45, 0, var1 + var5 + 2, var2 + var5 + 2);
      Class_1b0.drawSprite2(var0, (byte)45, 0, var1 + var5 + var3 - (var5 << 1) - 2 - LevelObjectData.spriteTypesArr[45][2], var2 + var5 + 2);
   }

   public static void sub_29c(Graphics var0) {
      for(int var1 = 0; var1 < LevelManager.var_12a + 2; ++var1) {
         for(int var2 = 0; var2 < LevelManager.var_18b + 2; ++var2) {
            Class_1b0.drawSprite2(var0, (byte)19, 0, var1 * 24, var2 * 24);
         }
      }

   }

   public static void sub_2c9(Graphics var0, Graphics var1) {
      boolean var2 = false;
      if (var_5b6) {
         Class_178.var_338 = true;
         if (var_6ce) {
            if (Class_178.var_2f7 == 0) {
               Class_178.var_114a = 25;
               var_790.sub_451(var0);
            }

            var0.setColor(0);
            if (!var_c24) {
               sub_25f(var0, var_12e, var_18c, var_1bd, var_1cf, 2, var_202, true);
               Class_1b0.sub_47c(var0, var_882, var_3e5, var_424);
               if (var_850 != null) {
                  if (var_850.length == 3) {
                     Class_1b0.drawSprite2(var0, var_850[0], var_850[2], var_34f, var_3ad);
                  }

                  Class_1b0.drawSprite2(var0, var_850[0], var_850[1], var_34f, var_3ad);
               }
            }

            if (var_7ed != 22) {
               var2 = true;
            }

            var0.setColor(0);
         }

         if (var_7c6 == 0) {
            sub_2f0(var0, var1);
         } else {
            sub_316(var0, var1);
         }

         if (var2) {
            sub_36c(var0);
         }

         if (var_780) {
            var_6ce = true;
            var_780 = false;
         }

         Class_178.var_338 = false;
      }
   }

   private static void sub_2f0(Graphics var0, Graphics var1) {
      if (var_6ce) {
         var0.setClip(0, 0, LevelManager.screenWidth, LevelManager.screenHeight);
         if (var_673) {
            sub_3a6(var0, var_46d, var_508);
         }

         Class_3d.callGc();
         Class_1b0.sub_5d(var0, var_b16, var_508, var_285, var_297, var_2e2, var_46d, var_45d);
         var_6ce = false;
      } else {
         var1.drawImage(LevelManager.var_25f, 0, 0, 0);
         if (var_673) {
            sub_3c5(var1, var_46d, var_508);
         }

      }
   }

   private static void sub_316(Graphics var0, Graphics var1) {
      int var2;
      int var3;
      if (var_6ce) {
         var0.setClip(0, 0, LevelManager.screenWidth, LevelManager.screenHeight);
         var2 = 0;
         var3 = var_8ca.length;
         int var4;
         int var5;
         if (var_673) {
            var4 = 0;

            for(var5 = 0; var5 <= var_508; ++var5) {
               var4 += var_95a[var5];
            }

            var5 = 0;
            int var6;
            if (var4 > var_46d) {
               for(var6 = 0; var6 <= var_508; ++var6) {
                  if (var4 - var5 <= var_46d) {
                     var2 = var6;
                     break;
                  }

                  var5 += var_95a[var6];
               }
            }

            var5 = 0;

            for(var6 = var2; var6 < var_8ca.length; ++var6) {
               if ((var5 += var_95a[var6]) > var_46d) {
                  var3 = var6;
                  break;
               }
            }

            var_557 = var3 - var2;
            if (var_7ed != 22) {
               sub_3a6(var0, var_557, var2);
            }

            var0.setClip(var_12e, var_18c, var_1bd, var_1cf);
         }

         var4 = var_297;
         var_9a0 = 0;

         for(var5 = var2; var5 < var3; ++var5) {
            if (var_abc != null) {
               short var9 = 0;
               if (var_a80) {
                  var9 = (short)(0 + LevelObjectData.spriteTypesArr[6][2] + 3);
               }

               if (var_abc[var5] != null) {
                  if (var_c2e) {
                     Class_1b0.sub_2c5(var0, var_abc[var5][1], (byte)1, var_12e + 5 + var9, var4, 0);
                  } else {
                     Class_1b0.drawSprite2(var0, var_abc[var5][0], var_abc[var5][1], var_12e + 5 + var9, var4);
                  }
               }
            }

            if (var_a80) {
               Class_1b0.drawSprite2(var0, (byte)6, (byte)(var_a44[var5] ? 1 : 0), var_12e + 5, var4 + 1);
            }

            if (var5 < var_508) {
               var_9a0 += var_95a[var5];
            }

            short[] var10;
            if (var_914 == null) {
               var10 = Class_1b0.readTextFromLng(var_8ca[var5]);
            } else {
               var10 = Class_1b0.sub_569(var_8ca[var5], var_914[var5]);
            }

            int var7 = 0;
            if (var_7c6 != 2 && var10.length < var_2e2) {
               var7 = var_2b5 - var10.length * Class_1b0.var_12 >> 1;
            }

            if (var_abc != null && var_abc[var5] == null) {
               var7 = -(LevelObjectData.spriteTypesArr[var_abc[var_abc.length - 1][0]][2] + 4 >> 1);
            }

            if (var_c2e && var5 > 0) {
               var0.setColor(4342338);
               var0.setStrokeStyle(1);
               var0.setClip(var_285, var4 - 2, var_2b5 - 2, 1);
               var0.drawLine(var_285, var4 - 2, var_285 + var_2b5 - 2, var4 - 2);
               var0.setStrokeStyle(0);
            }

            if (var_95a[var5] == 1) {
               Class_1b0.sub_47c(var0, var10, var_285 + var7, var4);
            } else {
               Class_1b0.sub_5d(var0, var10, 0, var_285 + var7, var4, var_2e2, var_95a[var5], var_45d);
            }

            var4 += var_45d * var_95a[var5];
         }

         var_790.hasPointerEvents();
         var_6ce = false;
         Class_3d.callGc();
      } else {
         var1.drawImage(LevelManager.var_25f, 0, 0, 0);
         if (var_673) {
            var2 = var_2b5;
            if (var_7ed != 22) {
               sub_3c5(var1, var_557, var_508);
            }
         } else {
            var2 = var_2b5 + 3;
         }

         if (var_7ed == 22) {
            Class_1b0.drawSprite2(var1, (byte)16, 0, var_285 - (LevelObjectData.spriteTypesArr[16][2] << 1) + Math.abs(12 - Class_178.var_115), var_297 + var_45d * var_9a0 - 2);
            Class_1b0.drawSprite2(var1, (byte)16, 0, var_285 + (LevelObjectData.spriteTypesArr[16][2] >> 1) + var2 - Math.abs(12 - Class_178.var_115), var_297 + var_45d * var_9a0 - 2);
         } else {
            if (!var_c2e) {
               var3 = 0;
               if (var_7c6 == 0 && var_673 || var_7c6 != 0) {
                  var3 = 65793 * ((Math.abs(12 - Class_178.var_115) << 1) * 255 / 24);
               }

               try {
                  Class_1b0.sub_250(var1, var_285 - 2, var_297 + var_45d * var_9a0 - 2, var2, var_45d * var_95a[var_508], true, -1, var3, var3);
                  return;
               } catch (Exception var8) {
               }
            }

         }
      }
   }

   public static void sub_36c(Graphics var0) {
      if (Class_178.var_46) {
         var_790.removeCommand(Class_178.var_3bb);
         var_790.removeCommand(Class_178.var_392);
         Class_178.var_3bb = new Command(Class_1b0.sub_5a0(var_89d[0]), 4, 1);
         var_790.addCommand(Class_178.var_3bb);
         if (var_89d.length > 1) {
            Class_178.var_392 = new Command(Class_1b0.sub_5a0(var_89d[1]), 1, 2);
            var_790.addCommand(Class_178.var_392);
         }

      } else {
         int var1 = LevelManager.screenHeight - LevelObjectData.spriteTypesArr[9][3];

         for(int var2 = 0; var2 < LevelManager.screenWidth; var2 += LevelObjectData.spriteTypesArr[9][2]) {
            Class_1b0.drawSprite2(var0, (byte)9, 0, var2, var1);
         }

         sub_388(var0, 2, var1 + var_ac, var_89d[0] - 126, 4);
         if (var_89d.length > 1) {
            int var3 = LevelManager.screenWidth - LevelObjectData.spriteTypesArr[38][2] - 2;
            sub_388(var0, var3, var1 + var_ac, var_89d[1] - 126, 5);
         }

      }
   }

   public static void sub_388(Graphics var0, int var1, int var2, int var3, int var4) {
      Class_1b0.drawSprite2(var0, (byte)38, 0, var1, var2);
      Class_1b0.drawSprite2(var0, (byte)39, (byte)var3, var1 + (LevelObjectData.spriteTypesArr[38][2] >> 1) - (LevelObjectData.spriteTypesArr[39][2] >> 1), var2 + (LevelObjectData.spriteTypesArr[38][3] >> 1) - (LevelObjectData.spriteTypesArr[39][3] >> 1));
   }

   private static void sub_3a6(Graphics var0, int var1, int var2) {
      for(int var3 = var_297 + LevelObjectData.spriteTypesArr[44][3]; var3 < var_297 + var_327 - LevelObjectData.spriteTypesArr[44][3]; var3 += LevelObjectData.spriteTypesArr[44][3]) {
         Class_1b0.drawSprite2(var0, (byte)44, 2, var_644, var3);
      }

      Class_1b0.drawSprite2(var0, (byte)44, 0, var_644, var_297);
      Class_1b0.drawSprite2(var0, (byte)44, 1, var_644, var_297 + var_327 - LevelObjectData.spriteTypesArr[44][3]);
      int var4 = Math.max(100 * var1 / var_4fa * var_5ff / 100, 4);
      int var5 = 100 * var2 / var_4fa * var_5ff / 100;
      var5 = Math.min(var_5ff - var4, var5);
      if (var_4fa - var2 <= var1) {
         var5 = var_5ff - var4;
      }

      Class_1b0.sub_20e(var0, var_644 + 1, var_297 + LevelObjectData.spriteTypesArr[44][3] + var5, var_662 - 2, var4, true, 6518395);
      Class_1b0.drawSprite2(var0, (byte)45, 0, var_644 + 1 + (var_662 - 2 >> 1) - (LevelObjectData.spriteTypesArr[45][2] >> 1), var_297 + LevelObjectData.spriteTypesArr[44][3] + var5 + (var4 >> 1) - (LevelObjectData.spriteTypesArr[45][3] >> 1));
   }

   private static void sub_3c5(Graphics var0, int var1, int var2) {
      int var3 = 0;
      if (var_7c6 == 0 && var_673 || var_7c6 != 0) {
         var3 = 65793 * ((Math.abs(12 - Class_178.var_115) << 1) * 255 / 24);
      }

      if (var2 > 0 || var_7c6 != 0 && var_673) {
         Class_1b0.sub_250(var0, var_644, var_297, LevelObjectData.spriteTypesArr[44][2], LevelObjectData.spriteTypesArr[44][3], true, -1, var3, var3);
      }

      if (var_4fa - var2 > var1 || var_7c6 != 0 && var_673) {
         Class_1b0.sub_250(var0, var_644, var_297 + var_327 - LevelObjectData.spriteTypesArr[44][3], LevelObjectData.spriteTypesArr[44][2], LevelObjectData.spriteTypesArr[44][3], true, -1, var3, var3);
      }

   }

   public static void sub_3ee() {
      if (Class_178.var_93a != 999999) {
         int var0 = var_790.sub_97(Class_178.var_93a);
         Class_178.var_165 = 1;
         var_6ce = true;
         var_780 = Class_178.var_338;
         if (var_7c6 == 0) {
            sub_41e(var0);
         } else {
            sub_47d(var0);
         }

         Class_178.var_93a = 999999;
      }
   }

   private static void sub_41e(int var0) {
      int var1;
      if (var_bf0 >= var_b61.length - 1) {
         if (var_bf0 == var_b61.length - 1 && Class_178.var_93a >= 48 && Class_178.var_93a <= 50) {
            var_b61[var_bf0] = (byte)(Class_178.var_93a - 48);
            ++var_bf0;
         } else {
            if (var_bf0 == var_b61.length) {
               var_bf0 = 0;
               if ((var1 = Class_178.var_93a) == 999999) {
                  var1 = 53;
               }

               int var2;
               if ((var2 = var_b61[var_b61.length - 1] * 10 + (var1 - 48) + 6) > 6 && var2 <= 27) {
                  Class_178.sub_d4e((byte)var2);
               }

               return;
            }

            var_bf0 = 0;
            if (var0 == 3) {
               Class_178.var_e38 = 1000000;
            } else if (var0 == 9) {
               var_b16 = Class_1b0.sub_533(Runtime.getRuntime().totalMemory() + "_" + Runtime.getRuntime().freeMemory());
            } else if (var0 == 4) {
               Class_178.var_5bb = 0;
            } else if (var0 == 5) {
               Class_178.var_5bb = 1;
            }
         }
      } else if (var_b61[var_bf0] == var0) {
         ++var_bf0;
      } else {
         var_bf0 = 0;
      }

      if ((var0 == 1 || var0 == 13) && var_89d.length == 2) {
         var_838 = String.valueOf(var_89d[1]);
         Class_178.sub_30c();
      } else if (var0 != 0 && var0 != 10 && var0 != 12) {
         if (var_673) {
            var1 = 0;
            if (var0 == 2) {
               var1 = -1;
            } else if (var0 == 3) {
               var1 = 1;
            } else if (var0 == 7) {
               var1 = -var_46d;
            } else if (var0 == 9) {
               var1 = var_46d;
            }

            if (var1 != 0) {
               var_508 += var1;
               if (var_508 < 0) {
                  var_508 = 0;
               }

               if (var_508 > var_4fa - var_46d) {
                  var_508 = var_4fa - var_46d;
               }
            }
         }

      } else {
         var_838 = String.valueOf(var_89d[0]);
         Class_178.sub_30c();
      }
   }

   private static void sub_47d(int var0) {
      if (var_7c6 == 2) {
         if (var0 == 10 || var0 == 12 && !var_a80) {
            if (var_a80) {
               boolean[] var10000 = var_a44;
               int var10001 = var_508;
               var10000[var10001] ^= true;
               return;
            } else {
               var_838 = String.valueOf(var_508);
               Class_178.sub_30c();
               return;
            }
         }

         if (var0 == 0 || var0 == 12) {
            if (var_a80) {
               StringBuffer var1 = new StringBuffer();

               for(int var2 = 0; var2 < var_a44.length; ++var2) {
                  var1.append(var_a44[var2]).append(';');
               }

               var_838 = var1.toString();
            } else {
               var_838 = String.valueOf(var_508);
            }

            Class_178.sub_30c();
            return;
         }

         if ((var0 == 1 || var0 == 13) && var_89d.length > 1) {
            var_838 = null;
            Class_178.sub_30c();
            return;
         }
      }

      if ((var0 == 1 || var0 == 13) && var_89d.length > 1) {
         var_838 = null;
         Class_178.sub_30c();
      } else if (var0 != 0 && var0 != 10 && var0 != 12) {
         if (var0 == 3) {
            if (var_508 < var_557 && var_c2e && var_673) {
               var_508 = var_557;
            } else {
               ++var_508;
            }

            if (var_508 >= var_8ca.length) {
               if (var_c2e) {
                  --var_508;
                  return;
               }

               var_508 = 0;
               return;
            }
         } else if (var0 == 2) {
            --var_508;
            if (var_508 < 0) {
               if (var_c2e) {
                  var_508 = 0;
                  return;
               }

               var_508 = var_8ca.length - 1;
               return;
            }
         } else if (var0 == 7) {
            var_508 -= var_557;
            if (var_508 < 0) {
               var_508 = var_8ca.length - 1;
               return;
            }
         } else if (var0 == 9) {
            var_508 += var_557;
            if (var_508 >= var_8ca.length) {
               var_508 = 0;
            }
         }

      } else {
         var_838 = new Short(var_8ca[var_508]);
         Class_178.sub_30c();
      }
   }

   public static void sub_4ac(short var0, Object[] var1) {
      var_b16 = Class_1b0.sub_569(var0, var1);
   }

   public static void sub_4bd(short var0) {
      var_882 = Class_1b0.readTextFromLng(var0);
   }

   public static void sub_4ea(short var0, Object[] var1) {
      var_882 = Class_1b0.sub_569(var0, var1);
   }

   private static int sub_500(int var0) {
      return var0 / Class_1b0.var_12 + Class_1b0.sub_619(var0, Class_1b0.var_12);
   }

   static {
      var_ac = LevelObjectData.spriteTypesArr[9][3] - LevelObjectData.spriteTypesArr[38][3] + 1 >> 1;
      var_d0 = LevelObjectData.spriteTypesArr[9][3] + 2;
      var_662 = LevelObjectData.spriteTypesArr[44][2];
      var_6ce = true;
      var_b61 = new byte[]{8, 8, 8, 8, 8, 8, 8, 0};
   }
}
