package main;
import javax.microedition.lcdui.Graphics;

public final class Class_7c implements Class_1cc {
   public final byte var_4c;
   public final byte var_71;
   public final byte var_119;
   public final byte var_163;
   public short var_18d;
   public short var_1a5;
   public final byte[] var_1bc = new byte[]{120, 8};
   public byte var_1f5;
   public byte var_22c;

   public Class_7c(byte var1, byte var2, byte var3, byte var4, byte var5, byte var6, byte var7) {
      this.var_4c = var1;
      this.var_71 = var2;
      this.var_119 = var3;
      this.var_163 = var4;
      this.var_1f5 = var6;
      this.var_22c = var7;
      this.var_1bc[0] = (byte)(var5 == 0 ? 120 : 0);
   }

   public final void sub_59(Graphics var1) {
      int var2;
      if (Class_b3.var_a5a != 0) {
         byte var3;
         if ((var3 = this.var_4c) == 6 && Class_b3.var_68a[Class_178.var_dc6 - 1][25] == 32) {
            var3 = 4;
         }

         boolean var4 = Class_1b0.sub_678(Class_1cc.var_da[var3][5], (byte)6) || Class_1b0.sub_678(Class_1cc.var_da[var3][5], (byte)7);
         if (var3 == 6 && Class_b3.var_7f3 > 0) {
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
            if (Class_1b0.sub_678(Class_1cc.var_da[var3][5], (byte)6)) {
               var7 = this.var_163 == 2 ? 12 : 0;
               var8 = this.var_163 == 0 ? 12 : 0;
               var9 = this.var_163 == 3 ? 12 : 0;
               var10 = this.var_163 == 1 ? 12 : 0;
            } else if (Class_1b0.sub_678(Class_1cc.var_da[var3][5], (byte)7)) {
               var5 = Class_b3.var_3e7[0][this.var_163] * 12;
               var6 = Class_b3.var_3e7[1][this.var_163] * 12;
               var7 = this.var_163 == 0 ? 12 : 0;
               var8 = this.var_163 == 2 ? 12 : 0;
               var9 = this.var_163 == 1 ? 12 : 0;
               var10 = this.var_163 == 3 ? 12 : 0;
            }

            Class_1b0.sub_2e7(var1, 4, (byte)(Class_1cc.var_da[var3][this.var_163] + var2), Class_b3.var_1dc + this.var_71 * 24 + var5, Class_b3.var_1fb + this.var_119 * 24 + var6, var7, var8, var9, var10);
         } else {
            Class_1b0.sub_2db(var1, (byte)4, (byte)(Class_1cc.var_da[var3][this.var_163] + var2), Class_b3.var_1dc + this.var_71 * 24, Class_b3.var_1fb + this.var_119 * 24);
         }

         if (var3 == 9) {
            if (this.var_1bc[0] <= 0 && this.var_1bc[1] > 0) {
               Class_1b0.sub_46a(var1, String.valueOf(this.var_1bc[1]), Class_b3.var_1dc + this.var_71 * 24, Class_b3.var_1fb + this.var_119 * 24);
            }

            if (this.var_1bc[1] == 0) {
               Class_1b0.sub_2db(var1, (byte)11, Class_b3.var_4e5[this.var_22c], Class_b3.var_1dc + this.var_71 * 24, Class_b3.var_1fb + this.var_119 * 24);
               Class_b3.var_4a5 = Class_b3.var_475[this.var_22c];
            }
         }
      } else {
         if (this.var_4c == 6 && (Class_b3.var_7f3 > 0 || Class_b3.var_68a[Class_178.var_dc6 - 1][25] == 32)) {
            return;
         }

         if (this.var_4c == 4 && Class_b3.var_68a[Class_178.var_dc6 - 1][25] == 32) {
            return;
         }

         if (this.var_4c != 22 && this.var_4c != 23 && this.var_4c != 24) {
            if (this.var_4c == 6) {
               var2 = this.var_22c == 0 ? 16711680 : (this.var_22c == 1 ? 315140 : 255);
            } else {
               var2 = this.var_22c > 0 ? 12058726 : 0;
               if (Class_1b0.sub_678(Class_1cc.var_da[this.var_4c][5], (byte)5)) {
                  var2 = 5855577;
               } else if (Class_b3.var_7a3[this.var_1f5] > 0 || Class_b3.var_68a[Class_178.var_dc6 - 1][25] == 20) {
                  var2 = 0;
               }

               if (this.var_4c == 11) {
                  var2 = 0;
               }
            }

            Class_1b0.sub_2c5(var1, Class_1cc.var_da[this.var_4c][4], this.var_163, Class_b3.var_1dc + this.var_71 * 24, Class_b3.var_1fb + this.var_119 * 24, var2);
         } else {
            Class_1b0.sub_2db(var1, (byte)47, 0, Class_b3.var_1dc + this.var_71 * 24, Class_b3.var_1fb + this.var_119 * 24);
         }

         if (this.var_18d > 0 && this.var_18d <= Class_205.var_4aa) {
            Class_1b0.sub_2db(var1, (byte)2, 18, Class_b3.var_1dc + this.var_71 * 24, Class_b3.var_1fb + this.var_119 * 24);
         }

         if (this.var_1a5 > 0 && this.var_1a5 <= Class_205.var_4aa) {
            Class_1b0.sub_2db(var1, (byte)2, 19, Class_b3.var_1dc + this.var_71 * 24, Class_b3.var_1fb + this.var_119 * 24);
            return;
         }
      }

   }

   public final void sub_92(Graphics var1, byte var2, boolean var3) {
      if (var2 > 0) {
         int var4 = 360 * (var3 ? this.var_1bc[0] : this.var_1bc[1]) / var2;
         var1.setClip(0, 0, 16, 16);
         var1.setColor(var3 ? 10027008 : 26112);
         var1.fillArc(0, 0, 15, 15, 0, 360);
         var1.setColor(16777215);
         var1.fillArc(0, 0, 15, 15, 90, var4);
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
