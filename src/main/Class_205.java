package main;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class Class_205 implements SomeLevelDataVariablesInterface {
   public static final byte[][] toolUsingTimeStats = new byte[][]{{0, 0, 35, 80, 65, 20, 0, 0, 30, 15, 8, 0}, {22, 18, 14, 30, 20, 0, 0, 0, 0, 15, 8, 0}, {0, 55, 35, 55, 45, 25, 0, 0, 0, 15, 8, 0}, {25, 20, 17, 15, 0, 0, 0, 0, 0, 15, 8, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10}, {14, 8, 0, 20, 0, 0, 0, 0, 0, 15, 8, 0}, {0, 0, 0, 0, 0, 0, 50, 30, 15, 0, 0, 0}, {15, 10, 8, 12, 0, 0, 30, 0, 0, 15, 8, 0}, {25, 20, 17, 15, 0, 0, 0, 0, 0, 15, 8, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 8, 0}, {17, 11, 0, 20, 0, 0, 0, 0, 0, 15, 8, 0}, {15, 10, 0, 0, 0, 0, 0, 0, 0, 15, 8, 0}, {0, 0, 35, 70, 20, 15, 0, 0, 25, 15, 8, 0}, {14, 8, 0, 20, 0, 0, 0, 0, 0, 15, 8, 0}, {20, 15, 15, 30, 0, 0, 0, 0, 0, 15, 8, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {17, 10, 0, 20, 0, 0, 0, 0, 0, 15, 8, 0}, {17, 10, 0, 20, 0, 0, 0, 0, 0, 15, 8, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
   public final byte var_3a;
   public byte var_bb;
   public byte var_123;
   public byte var_17b;
   public byte var_1a6;
   public byte var_1ec;
   public boolean var_210;
   public short var_24a;
   public byte var_29a;
   public byte var_2d2;
   public short var_341;
   public final Vector var_39c = new Vector();
   public SomeLevelDataCLass var_3d8;
   public final short[] var_3fa = new short[6];
   public final byte[] var_451 = new byte[3];
   public byte var_47f;
   public static short var_4aa;
   public static int var_4ca;
   public static int var_51f;
   public static int[] var_552 = new int[]{0, 0, 0, 0, 0};

   public Class_205(byte var1) {
      this.var_3a = var1;
      this.sub_3e7(false);
   }

   public final void sub_1e() {
      var_552[0] = 0;
      this.var_bb = Class_b3.someLevelDataVar1;
      this.var_123 = Class_b3.someLevelDataVar2;
      this.var_24a = 0;
      this.var_39c.removeAllElements();
      this.var_39c.addElement(new Class_240(this.var_bb, this.var_123, (byte)0, (byte)0, (byte)0));
   }

   public final void sub_7b(boolean var1) {
      if (Class_b3.var_e52 == 3) {
         this.var_1a6 = 2;
      } else {
         if (Class_b3.var_e52 == 2) {
            if (this.var_bb != Class_b3.someLevelDataVar1 || this.var_123 != Class_b3.someLevelDataVar2) {
               if (var_552[this.var_3a] < 3) {
                  this.var_1a6 = Class_b3.var_619[this.var_3a][var_552[this.var_3a]].sub_a2();
                  this.var_17b = Class_b3.var_619[this.var_3a][var_552[this.var_3a]].sub_106();
                  return;
               } else {
                  this.var_1a6 = 0;
                  return;
               }
            }
         } else if (this.var_39c.size() > 0 && this.var_341 < this.var_39c.size()) {
            Class_240 var2 = (Class_240)this.var_39c.elementAt(this.var_341);
            this.var_1a6 = var2.sub_a2();
            if (var1) {
               this.var_bb = var2.var_29;
               this.var_123 = var2.var_86;
            }

            this.var_17b = var2.sub_106();
            this.var_47f = var2.sub_123();
            return;
         }

         this.var_1a6 = 0;
      }
   }

   private Class_240 sub_e8() {
      return this.sub_ff(this.var_341);
   }

   public final Class_240 sub_ff(int var1) {
      return this.var_39c.size() > 0 && var1 < this.var_39c.size() ? (Class_240)this.var_39c.elementAt(var1) : null;
   }

   public final void sub_119(byte var1) {
      byte var3 = this.var_bb;
      byte var4 = this.var_123;

      for(int var5 = 0; var5 < var1; ++var5) {
         Class_240 var2;
         (var2 = (Class_240)this.var_39c.elementAt(var_4aa + var5)).var_29 = var3;
         var2.var_86 = var4;
         var2.sub_15(this.var_1a6);
         var2.sub_4c(this.var_17b);
         var2.sub_7a(this.var_47f);
         if (this.var_1a6 == 1) {
            var3 = (byte)(var3 + Class_b3.var_3e7[0][this.var_17b]);
            var4 = (byte)(var4 + Class_b3.var_3e7[1][this.var_17b]);
         }

         this.var_39c.addElement(new Class_240(var3, var4, (byte)0, this.var_17b, (byte)0));
      }

   }

   public final void sub_174() {
      this.var_341 = (short)(var_4aa - 1);
      boolean var2 = this.var_341 == 0;
      this.sub_7b(var2);
      short var3 = (short)this.var_1a6;
      byte var4 = this.var_17b;
      short var5 = var_4aa;
      boolean var6 = false;
      boolean var7 = false;
      if (this.sub_311()) {
         this.var_3d8 = Class_b3.sub_912(this);
         if (this.var_3d8 != null) {
            switch(this.var_1a6) {
            case 3:
               var7 = true;
               break;
            case 4:
               var6 = true;
               break;
            case 5:
               var6 = true;
               this.var_3d8 = (SomeLevelDataCLass)Class_b3.var_84c.get(Class_b3.combineInts(this.var_bb, this.var_123));
               Class_b3.sub_75c(this.var_bb, this.var_123, true, true, this.var_341 + 1 + 5, this.var_3d8.var_1f5 == 114, false);
               if (this.var_3d8.var_1f5 == 114) {
                  Class_b3.sub_75c(this.var_bb, this.var_123, true, true, this.var_341 + 1 + 5, this.var_3d8.var_1f5 == 114, true);
               }

               Class_b3.var_84c.remove(Class_b3.combineInts(this.var_bb, this.var_123));
            }
         }
      }

      while(this.var_1a6 == var3 && this.var_17b == var4) {
         this.var_210 = true;
         --var_4aa;
         this.var_39c.removeElementAt(var_4aa);
         this.var_341 = var_4aa;
         if (this.var_341 > 0) {
            --this.var_341;
         }

         this.sub_7b(!var2);
         if (this.var_1a6 == 1) {
            this.var_341 = var_4aa;
            this.var_bb = (byte)(this.var_bb + Class_b3.var_3e7[0][this.var_17b]);
            this.var_123 = (byte)(this.var_123 + Class_b3.var_3e7[1][this.var_17b]);
         }

         if (this.var_1a6 == 2) {
            this.var_341 = var_4aa;
         }

         Class_240 var1;
         (var1 = (Class_240)this.var_39c.elementAt(var_4aa)).var_29 = this.var_bb;
         var1.var_86 = this.var_123;
         var1.sub_15((byte)0);
         var1.sub_4c(this.var_17b);
         var1.sub_7a(this.var_47f);
         if (this.var_1a6 == 1 || this.var_1a6 == 2) {
            break;
         }
      }

      this.var_210 = false;
      if (var6 && this.var_3d8.var_18d > var_4aa && this.var_3d8.var_18d <= var5) {
         this.var_3d8.var_18d = 0;
      }

      if (var7 && this.var_3d8.var_1a5 > var_4aa && this.var_3d8.var_1a5 <= var5) {
         this.var_3d8.var_1a5 = 0;
      }

   }

   public final void sub_19d() {
      while(this.var_39c.size() > 1) {
         var_4aa = (short)(this.var_39c.size() - 1);
         this.sub_174();
      }

      this.sub_1e();
   }

   public final void sub_1ba(byte var1, byte var2) {
      while(this.var_1a6 == var1 && this.var_17b == var2) {
         this.sub_7b(false);
         ++this.var_341;
      }

      --this.var_341;
   }

   public final void sub_1f3(Graphics var1) {
      int var2 = 0;
      int var3 = 0;
      if (this.var_1a6 == 1 && this.var_24a <= 0) {
         var2 = Class_b3.var_3e7[0][this.var_17b] * (this.var_1ec * 24 / 12);
         var3 = Class_b3.var_3e7[1][this.var_17b] * (this.var_1ec * 24 / 12);
      }

      if (this.sub_311() && this.var_3d8 != null) {
         var2 = Class_b3.var_3e7[0][this.var_17b] * SomeLevelDataVariablesInterface.var_da[this.var_3d8.var_4c][6];
         var3 = Class_b3.var_3e7[1][this.var_17b] * SomeLevelDataVariablesInterface.var_da[this.var_3d8.var_4c][6];
      }

      int var4 = Class_b3.var_1dc + this.var_bb * 24 + var2;
      int var5 = Class_b3.var_1fb + this.var_123 * 24 + var3;
      if (Class_b3.var_a5a == 1) {
         if (Class_b3.someLevelDataVar1 == this.var_bb && Class_b3.someLevelDataVar2 == this.var_123) {
            if (var2 == 0 && var3 == 0) {
               return;
            }

            if (var3 < 0) {
               Class_b3.var_d55 = true;
            } else if (var3 > 0) {
               Class_b3.var_d39 = true;
            }
         }

         if (Class_b3.someLevelDataVar1 == this.var_bb + Class_b3.var_3e7[0][this.var_17b] && Class_b3.someLevelDataVar2 == this.var_123 + Class_b3.var_3e7[1][this.var_17b]) {
            if (var3 < 0) {
               Class_b3.var_d39 = true;
            } else if (var3 > 0) {
               Class_b3.var_d55 = true;
            }
         }

         Class_1b0.sub_2db(var1, (byte)1, this.var_24a > 0 ? (Class_b3.var_52f[15][0] == Class_b3.var_52f[14][0] ? Class_b3.var_52f[14][0] : Class_b3.var_52f[15][0] + (this.var_17b << 2)) : Class_b3.var_52f[this.var_1a6 == 4 ? Class_178.toolStats[Class_178.sub_e5c(this.var_451[this.var_47f])][3] : this.var_1a6][this.var_1ec] + (this.var_17b << 2), var4, var5);
         if (Class_b3.var_983 != null && Class_b3.var_983.var_3a == this.var_3a) {
            Class_1b0.sub_2db(var1, (byte)1, 7, var4, var5);
            return;
         }
      } else {
         Class_1b0.sub_2db(var1, (byte)50, this.var_17b, var4 + this.var_3a, var5 + this.var_3a);
         if (Class_b3.var_983 != null && Class_b3.var_983.var_3a == this.var_3a && Class_178.var_91 > 6 && !this.var_210) {
            Class_1b0.sub_2db(var1, (byte)51, Class_b3.var_983.var_3a - 1, var4 + 12 - 3 + this.var_3a, var5 + 12 - 3 + this.var_3a);
            if (Class_b3.var_983.var_bb == Class_b3.someLevelDataVar1 && Class_b3.var_983.var_123 == Class_b3.someLevelDataVar2) {
               Class_b3.var_983.var_2d2 = Class_b3.var_983.var_29a;
            }
         }
      }

   }

   public final boolean sub_256() {
      if (var_4aa >= 599) {
         return false;
      } else {
         boolean var1 = false;
         boolean var2 = false;
         int var3;
         if (Class_178.var_93a == 999999) {
            var3 = Class_b3.var_f0.sub_435(Class_178.var_9af);
         } else {
            Class_178.var_9af = 999999;
            var3 = Class_b3.var_f0.sub_97(Class_178.var_93a);
         }

         switch(var3) {
         case 2:
            this.var_17b = 1;
            var2 = true;
            break;
         case 3:
            this.var_17b = 3;
            var2 = true;
            break;
         case 4:
            this.var_17b = 0;
            var2 = true;
            break;
         case 5:
            this.var_17b = 2;
            var2 = true;
         }

         if (var2) {
            if (Class_b3.sub_4f6(this, Class_b3.var_a5a == 0)) {
               if (this.var_1a6 == 1) {
                  this.var_1a6 = 2;
                  Class_178.var_93a = 999999;
               } else {
                  Class_b3.sub_a53(this);
               }
            } else if (Class_b3.sub_4d1(this, Class_b3.var_a5a == 0)) {
               this.var_1a6 = 1;
               var1 = true;
            } else {
               this.var_1a6 = 2;
            }
         } else {
            this.var_1a6 = 2;
         }

         return var1;
      }
   }

   public final void sub_2a1() {
      var_552[this.var_3a] = 0;
      this.var_341 = 0;
      Class_240 var1 = this.sub_e8();
      this.var_1a6 = 0;
      if (var1 != null) {
         this.var_bb = var1.var_29;
         this.var_123 = var1.var_86;
         this.var_1ec = 0;
      }

      this.var_210 = false;
      this.var_3d8 = null;
      this.var_24a = 0;
      this.sub_44c();
   }

   public final void sub_2da(byte var1, boolean var2) {
      this.var_210 = true;
      if (Class_b3.var_a5a == 0) {
         if (this.var_1a6 == 5 && Class_b3.var_84c.containsKey(Class_b3.combineInts(this.var_bb, this.var_123))) {
            Class_178.sub_2c8((byte)0, (byte[])null, (short)172, (Object[])null, new short[]{126}, (short)137);
            return;
         }

         this.sub_119(var1);
         var_4aa = (short)(var_4aa + (var1 - 1));
         Class_b3.sub_585(this, var2);
         ++var_4aa;
         if (this.sub_311() && this.var_3d8 != null) {
            switch(this.var_1a6) {
            case 3:
               this.var_3d8.var_1a5 = var_4aa;
               Class_b3.sub_702();
               if (this.var_3d8.var_1f5 != 0 && this.var_3d8.var_22c > 0 && Class_b3.var_7a3[this.var_3d8.var_1f5] <= 0 && this.var_2d2 + Class_b3.var_71c[this.var_3d8.var_1f5][1] > Class_b3.thiefStats[this.var_3a][0]) {
                  if (Class_b3.thiefStats[this.var_3a][0] - this.sub_46a() < Class_b3.var_71c[this.var_3d8.var_1f5][1]) {
                     Class_b3.var_247 = 186;
                  } else {
                     Class_b3.var_247 = 185;
                  }
               }
               break;
            case 4:
               this.var_3d8.var_18d = var_4aa;
               Class_b3.sub_702();
               if (this.var_451[this.var_47f] == 115 && this.var_3d8.var_1f5 != 0 && this.var_3d8.var_22c > 0 && Class_b3.var_7a3[this.var_3d8.var_1f5] <= 0 && this.var_2d2 + Class_b3.var_71c[this.var_3d8.var_1f5][1] > Class_b3.thiefStats[this.var_3a][0]) {
                  if (Class_b3.thiefStats[this.var_3a][0] - this.sub_46a() < Class_b3.var_71c[this.var_3d8.var_1f5][1]) {
                     Class_b3.var_247 = 186;
                  } else {
                     Class_b3.var_247 = 185;
                  }
               }
               break;
            case 5:
               this.var_3d8 = new SomeLevelDataCLass((byte)9, this.var_bb, this.var_123, this.var_17b, (byte)1, this.var_451[this.var_47f], (byte)0);
               Class_b3.sub_75c(this.var_bb, this.var_123, true, false, var_4aa + 5, this.var_3d8.var_1f5 == 114, false);
               if (this.var_3d8.var_1f5 == 114) {
                  Class_b3.sub_75c(this.var_bb, this.var_123, true, false, var_4aa + 5, this.var_3d8.var_1f5 == 114, true);
               }

               Class_b3.var_84c.put(Class_b3.combineInts(this.var_bb, this.var_123), this.var_3d8);
               this.var_3d8.var_18d = (short)(var_4aa + 5);
               Class_b3.sub_702();
            }
         }
      }

      if (Class_b3.var_a5a == 1 && this.var_1a6 == 5) {
         this.var_3d8 = new SomeLevelDataCLass((byte)9, this.var_bb, this.var_123, this.var_17b, (byte)0, this.var_451[this.var_47f], (byte)0);
         Class_b3.var_84c.put(Class_b3.combineInts(this.var_bb, this.var_123), this.var_3d8);
         this.var_3d8.var_1bc[0] = var1;
      }

   }

   public final boolean sub_311() {
      return this.var_1a6 == 4 || this.var_1a6 == 5 || this.var_1a6 == 3;
   }

   public final boolean sub_373() {
      if (this.var_3d8.var_1f5 != 0 && this.var_3d8.var_22c > 0) {
         if (Class_b3.thiefStats[this.var_3a][0] - this.var_29a >= Class_b3.var_71c[this.var_3d8.var_1f5][1]) {
            short[] var10000 = this.var_3fa;
            byte var10001 = this.var_3d8.var_1f5;
            var10000[var10001] = (short)(var10000[var10001] + this.var_3d8.var_22c);
            this.var_29a = (byte)(this.var_29a + Class_b3.var_71c[this.var_3d8.var_1f5][1]);
            return true;
         }

         this.var_3d8.var_1bc[1] = 8;
         Class_178.sub_2c8((byte)0, new byte[]{5, this.var_3a}, (short)184, (Object[])null, new short[]{126}, (short)(41 + this.var_3a));
      }

      return false;
   }

   public final boolean sub_3a5() {
      var_4ca = this.var_bb + Class_b3.var_3e7[0][this.var_17b];
      var_51f = this.var_123 + Class_b3.var_3e7[1][this.var_17b];
      return var_4ca >= 0 && var_4ca < Class_b3.mapWidth && var_51f >= 0 && var_51f < Class_b3.mapHeight;
   }

   public final void sub_3e7(boolean var1) {
      for(int var2 = 0; var2 < 3; ++var2) {
         if (var1 && this.var_451[var2] != 116 && this.var_451[var2] != 0) {
            Class_178.var_e38 += Class_178.toolStats[Class_178.sub_e5c(this.var_451[var2])][0];
         }

         this.var_451[var2] = 116;
      }

      this.var_29a = 0;
   }

   public final void sub_41a() {
      for(int var1 = 1; var1 < this.var_3fa.length; ++var1) {
         this.var_3fa[var1] = 0;
      }

   }

   public final void sub_44c() {
      this.var_29a = this.sub_46a();
   }

   public final byte sub_46a() {
      byte var1 = 0;

      for(int var2 = 0; var2 < 3; ++var2) {
         if (this.var_451[var2] != 0 && this.var_451[var2] != 116) {
            var1 = (byte)(var1 + Class_178.toolStats[Class_178.sub_e5c(this.var_451[var2])][1]);
         }
      }

      return var1;
   }
}
