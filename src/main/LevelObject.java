package main;
import javax.microedition.lcdui.Graphics;

public final class LevelObject implements LevelObjectData {
   public final byte objectType;
   /*01 - wooden door, 
    * 05 - glass vertical witrine, 
    * 06 - alarm panel
    * 13 - glass shelf looking down
    * 27 - glass square witrine
    * */
   public final byte x;
   public final byte y;
   public final byte var_163;
   public short var_18d;
   public short var_1a5;
   public final byte[] var_1bc = new byte[]{120, 8};
   public byte var_1f5;
   public byte var_22c;

   public LevelObject(byte objectType, byte x, byte y, byte var4, byte var5, byte var6, byte var7) {
      this.objectType = objectType;
      this.x = x;
      this.y = y;
      this.var_163 = var4;
      this.var_1f5 = var6;
      this.var_22c = var7;
      this.var_1bc[0] = (byte)(var5 == 0 ? 120 : 0);
   }

   public final void sub_59(Graphics g) {
      int var2;
      if (LevelManager.var_a5a != 0) {
         byte var3;
         if ((var3 = this.objectType) == 6 && LevelManager.levelAdditionalData_TimerEtc[Class_178.var_dc6 - 1][25] == 32) {
            var3 = 4;
         }

         boolean var4 = Class_1b0.sub_678(LevelObjectData.var_da[var3][5], (byte)6) || Class_1b0.sub_678(LevelObjectData.var_da[var3][5], (byte)7);
         if (var3 == 6 && LevelManager.var_7f3 > 0) {
            return;
         }

         if (this.var_1bc[0] <= 0 && var3 == 4) {
            return;
         }

         if (var3 == 9) {
            if (this.var_1bc[0] > 0) {
               return;
            }

            var2 = this.var_1bc[1] <= 0 ? 1 : 0;
         } else {
            var2 = this.var_1bc[0] <= 0 ? 1 : 0;
         }

         if (var4) {
            int var5 = 0;
            int var6 = 0;
            int var7 = 0;
            int var8 = 0;
            int var9 = 0;
            int var10 = 0;
            if (Class_1b0.sub_678(LevelObjectData.var_da[var3][5], (byte)6)) {
               var7 = this.var_163 == 2 ? 12 : 0;
               var8 = this.var_163 == 0 ? 12 : 0;
               var9 = this.var_163 == 3 ? 12 : 0;
               var10 = this.var_163 == 1 ? 12 : 0;
            } else if (Class_1b0.sub_678(LevelObjectData.var_da[var3][5], (byte)7)) {
               var5 = LevelManager.var_3e7[0][this.var_163] * 12;
               var6 = LevelManager.var_3e7[1][this.var_163] * 12;
               var7 = this.var_163 == 0 ? 12 : 0;
               var8 = this.var_163 == 2 ? 12 : 0;
               var9 = this.var_163 == 1 ? 12 : 0;
               var10 = this.var_163 == 3 ? 12 : 0;
            }

            Class_1b0.drawSprite(g, 4, (byte)(LevelObjectData.var_da[var3][this.var_163] + var2), LevelManager.var_1dc + this.x * 24 + var5, LevelManager.var_1fb + this.y * 24 + var6, var7, var8, var9, var10);
         } else {
            Class_1b0.drawSprite2(g, (byte)4, (byte)(LevelObjectData.var_da[var3][this.var_163] + var2), LevelManager.var_1dc + this.x * 24, LevelManager.var_1fb + this.y * 24);
         }

         if (var3 == 9) {
            if (this.var_1bc[0] <= 0 && this.var_1bc[1] > 0) {
               Class_1b0.sub_46a(g, String.valueOf(this.var_1bc[1]), LevelManager.var_1dc + this.x * 24, LevelManager.var_1fb + this.y * 24);
            }

            if (this.var_1bc[1] == 0) {
               Class_1b0.drawSprite2(g, (byte)11, LevelManager.var_4e5[this.var_22c], LevelManager.var_1dc + this.x * 24, LevelManager.var_1fb + this.y * 24);
               LevelManager.var_4a5 = LevelManager.var_475[this.var_22c];
            }
         }
      } else {
         if (this.objectType == 6 && (LevelManager.var_7f3 > 0 || LevelManager.levelAdditionalData_TimerEtc[Class_178.var_dc6 - 1][25] == 32)) {
            return;
         }

         if (this.objectType == 4 && LevelManager.levelAdditionalData_TimerEtc[Class_178.var_dc6 - 1][25] == 32) {
            return;
         }

         if (this.objectType != 22 && this.objectType != 23 && this.objectType != 24) {
            if (this.objectType == 6) {
               var2 = this.var_22c == 0 ? 16711680 : (this.var_22c == 1 ? 315140 : 255);
            } else {
               var2 = this.var_22c > 0 ? 12058726 : 0;
               if (Class_1b0.sub_678(LevelObjectData.var_da[this.objectType][5], (byte)5)) {
                  var2 = 5855577;
               } else if (LevelManager.var_7a3[this.var_1f5] > 0 || LevelManager.levelAdditionalData_TimerEtc[Class_178.var_dc6 - 1][25] == 20) {
                  var2 = 0;
               }

               if (this.objectType == 11) {
                  var2 = 0;
               }
            }

            Class_1b0.sub_2c5(g, LevelObjectData.var_da[this.objectType][4], this.var_163, LevelManager.var_1dc + this.x * 24, LevelManager.var_1fb + this.y * 24, var2);
         } else {
            Class_1b0.drawSprite2(g, (byte)47, 0, LevelManager.var_1dc + this.x * 24, LevelManager.var_1fb + this.y * 24);
         }

         if (this.var_18d > 0 && this.var_18d <= Class_205.var_4aa) {
            Class_1b0.drawSprite2(g, (byte)2, 18, LevelManager.var_1dc + this.x * 24, LevelManager.var_1fb + this.y * 24);
         }

         if (this.var_1a5 > 0 && this.var_1a5 <= Class_205.var_4aa) {
            Class_1b0.drawSprite2(g, (byte)2, 19, LevelManager.var_1dc + this.x * 24, LevelManager.var_1fb + this.y * 24);
            return;
         }
      }

   }

   public final void sub_92(Graphics g, byte var2, boolean var3) {
      if (var2 > 0) {
         int var4 = 360 * (var3 ? this.var_1bc[0] : this.var_1bc[1]) / var2;
         g.setClip(0, 0, 16, 16);
         g.setColor(var3 ? 10027008 : 26112);
         g.fillArc(0, 0, 15, 15, 0, 360);
         g.setColor(16777215);
         g.fillArc(0, 0, 15, 15, 90, var4);
      }

   }

   public final void sub_c6(boolean var1) {
      if (var1) {
         this.var_18d = 0;
         this.var_1a5 = 0;
      } else {
         this.var_1bc[0] = 120;
         this.var_1bc[1] = 8;
      }
   }
}
