package main;
import java.io.DataInputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class Class_b3 implements Class_1cc {
   public static int var_1d;
   public static int var_b0;
   public static int var_cf;
   public static Class_178 var_f0;
   public static int var_12a;
   public static int var_18b;
   public static int var_1dc;
   public static int var_1fb;
   public static byte var_209;
   public static byte var_23c;
   public static short var_247 = -1;
   public static Image var_25f;
   public static Graphics var_2a1;
   public static boolean var_2c9 = true;
   public static boolean var_314;
   private static boolean var_35f = true;
   private static int var_390;
   public static final short[][] var_3e7 = new short[][]{{-1, 0, 1, 0}, {0, -1, 0, 1}};
   private static final short[][] var_42b = new short[][]{{-1, 1, 1, -1}, {-1, -1, 1, 1}};
   public static final byte[] var_475 = new byte[]{-6, 0, -4, 0, -3, 0, -2, 0, -1, 0, -1, 0};
   public static byte var_4a5;
   public static final short[] var_4e5 = new short[]{0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
   public static final short[][] var_52f = new short[][]{{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, {8, 8, 9, 9, 10, 10, 11, 11, 10, 10, 9, 9}, {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, {168, 168, 169, 169, 170, 170, 171, 171, 171, 171, 170, 170}, {137, 137, 137, 138, 138, 138, 139, 139, 139, 138, 138, 138}, {24, 24, 25, 25, 26, 26, 27, 27, 27, 27, 26, 26}, {40, 40, 41, 42, 43, 43, 43, 43, 42, 42, 41, 41}, {88, 89, 90, 91, 88, 89, 90, 91, 88, 89, 90, 91}, {184, 184, 185, 185, 186, 186, 185, 185, 186, 186, 187, 187}, {56, 56, 57, 57, 58, 58, 59, 59, 57, 57, 59, 59}, {120, 120, 120, 120, 123, 123, 123, 123, 121, 121, 121, 121}, {152, 153, 152, 153, 152, 153, 154, 155, 154, 155, 154, 155}, {104, 104, 105, 105, 106, 106, 107, 107, 106, 106, 105, 105}, {72, 72, 73, 73, 74, 74, 75, 75, 74, 74, 73, 73}, {6}, {136}};
   private static final short[][] var_590 = new short[][]{{0}, {1}, {2}, {3, 5}, {4, 6, 5}, {5}, {6, 5}, {7, 9, 5}, {8, 9, 5}, {9, 5}, {10, 9, 5}, {11, 7, 9, 5}, {12, 9, 5}, {13, 9, 5}, {14}, {15, 14}};
   private static final byte[][] var_5cd = new byte[][]{{1, 0, 1, 0, -1}, {1, -1, -1, 1, 1}};
   public static final Class_240[][] var_619 = new Class_240[][]{{new Class_240((byte)0, (byte)0, (byte)1, (byte)0, (byte)0), new Class_240((byte)0, (byte)0, (byte)1, (byte)1, (byte)0), new Class_240((byte)0, (byte)0, (byte)0, (byte)1, (byte)0)}, {new Class_240((byte)0, (byte)0, (byte)1, (byte)3, (byte)0), new Class_240((byte)0, (byte)0, (byte)0, (byte)3, (byte)0), new Class_240((byte)0, (byte)0, (byte)0, (byte)3, (byte)0)}, {new Class_240((byte)0, (byte)0, (byte)1, (byte)0, (byte)0), new Class_240((byte)0, (byte)0, (byte)1, (byte)3, (byte)0), new Class_240((byte)0, (byte)0, (byte)0, (byte)3, (byte)0)}, {new Class_240((byte)0, (byte)0, (byte)1, (byte)1, (byte)0), new Class_240((byte)0, (byte)0, (byte)0, (byte)1, (byte)0), new Class_240((byte)0, (byte)0, (byte)0, (byte)1, (byte)0)}, {new Class_240((byte)0, (byte)0, (byte)1, (byte)2, (byte)0), new Class_240((byte)0, (byte)0, (byte)1, (byte)1, (byte)0), new Class_240((byte)0, (byte)0, (byte)0, (byte)1, (byte)0)}};
   public static final byte[][] var_64c = new byte[][]{{0}, {1}, {2, 1}, {3}, {4}, {5}, {6}, {7, 3}, {8, 3}, {9}, {10}, {11}, {12}, {13}, {14, 13}, {15, 14, 13}, {16, 23}, {-1}, {18, 23}, {-1}, {-1}, {21, 26, 10}, {22}, {23}, {24, 23}, {-1}, {26, 10}, {27, 26, 10}, {28, 5}};
   public static final short[][] var_68a = new short[][]{{500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 50, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 9}, {500, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 50, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 10}, {500, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 50, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 11}, {500, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 300, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 12}, {500, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 11100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 13}, {140, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1800, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 14}, {140, 0, 3, 0, 5, 0, 9, 0, 0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 15, 35}, {200, 12, 5, 0, 15, 0, 22, 0, 1, 0, 1, 10, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 16, 36}, {260, 0, 0, 50, 40, 0, 30, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 17}, {250, 0, 30, 60, 20, 0, 50, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 18}, {160, 100, 0, 0, 0, 0, 50, 1, 0, 0, 1, 30, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 19, 37}, {320, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 40, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 20, 38}, {230, 0, 0, 0, 10, 250, 70, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 21}, {150, 0, 43, 50, 10, 0, 35, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 33}, {200, 45, 26, 0, 3, 0, 60, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 22}, {320, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 23}, {150, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 26}, {185, 0, 0, 0, 65, 0, 50, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 24}, {210, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 45, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 32, 39}, {340, 0, 0, 0, 0, 150, 80, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 25}, {180, 0, 70, 0, 40, 0, 60, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 28}, {110, 0, 0, 70, 0, 0, 55, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 31}, {240, 0, 0, 0, 0, 0, 70, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 27}, {135, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 30}, {130, 100, 0, 0, 0, 0, 50, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 29}, {170, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 50, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 34, 40}};
   public static final byte[][] var_6c9 = new byte[][]{{18, 0, 0}, {30, 20, 30}, {25, 15, 12}, {22, 12, 10}, {20, 10, 8}};
   public static final short[][] var_71c = new short[][]{{0, 0}, {1000, 2}, {1000, 1}, {1000, 0}, {1000, 1}, {1000, 3}};
   private static byte[][] var_753;
   public static int[] var_779 = new int[6];
   public static int[] var_7a3 = new int[7];
   public static int var_7f3;
   public static final Hashtable var_826 = new Hashtable();
   public static final Hashtable var_84c = new Hashtable();
   public static final Hashtable var_896 = new Hashtable();
   public static final Hashtable var_8dc = new Hashtable();
   public static final Hashtable var_8ff = new Hashtable();
   public static byte var_953;
   public static byte var_96a;
   public static Class_205 var_983;
   public static final Vector var_99f = new Vector();
   public static final Vector var_9d3 = new Vector();
   public static final byte[] var_a1e = new byte[]{116, 116, 116};
   public static byte var_a5a;
   private static boolean var_a93;
   private static boolean var_aad;
   private static boolean var_b0a;
   private static boolean var_b69;
   public static byte var_bc1;
   public static byte var_bf6;
   public static final int[] var_c58 = new int[]{0, 16711680, 65280, 255, 16711935};
   public static byte var_c64;
   public static int var_c7c;
   public static int var_c9e;
   private static int var_cdc;
   private static int var_cf8;
   public static boolean var_d39;
   public static boolean var_d55;
   private static int var_d80;
   private static int var_dc9;
   private static int var_de4;
   private static int var_e2f;
   public static byte var_e52;
   private static boolean var_e7f;

   public static void sub_48() {
      Class_178.sub_3b5(1);
      Class_178.var_55f.sub_8c(1, -1);
      Class_178.var_ff4 = null;
      Class_178.var_6bc = false;
      Class_178.var_93a = 999999;
      var_953 = -1;
      var_a5a = 0;
      var_99f.removeElement(Class_178.var_d34[0]);
      if (var_99f.size() > 0) {
         sub_8c6(-1);
      } else {
         var_983 = null;
      }

      sub_80d(var_bc1, var_bf6, true, false, false);
      sub_3d2();
      Class_178.var_26f = 1;
      var_2c9 = true;
   }

   public static void sub_74() {
      if (Class_178.var_dc6 <= 6 && var_99f.size() == 0) {
         Class_178.sub_2c8((byte)0, (byte[])null, (short)167, (Object[])null, new short[]{126}, (short)137);
      } else {
         Class_178.var_55f.sub_8c(3, -1);
         var_25f = null;
         Class_178.sub_187(10L);
         var_2a1 = null;
         Class_178.sub_3b5(0);
         sub_c2();
         Class_3d.sub_198();
         Class_178.sub_187(50L);
         Class_178.var_26f = 1;
         var_25f = Image.createImage(var_1d, var_b0);
         var_2a1 = var_25f.getGraphics();
         Class_3d.sub_198();
         Class_178.sub_187(10L);
         Class_178.var_ff4 = null;
         var_a93 = false;
         var_aad = false;
         var_b0a = false;
         var_b69 = false;
         var_a5a = 1;
         Class_178.var_17e = 0;
         Class_178.var_e86 = Class_178.var_e38;
         var_c9e = var_c7c;
         Class_178.var_6bc = false;
         var_9d3.removeAllElements();
         Enumeration var0 = var_99f.elements();

         while(var0.hasMoreElements()) {
            Class_205 var1;
            (var1 = (Class_205)var0.nextElement()).sub_2a1();
            var_9d3.addElement(var1);
         }

         int var2;
         for(var2 = 0; var2 < 3; ++var2) {
            var_a1e[var2] = Class_178.var_d34[0].var_451[var2];
         }

         Class_178.var_d82.removeAllElements();
         var0 = Class_178.var_d50.elements();

         while(var0.hasMoreElements()) {
            Class_178.var_d82.addElement(var0.nextElement());
         }

         sub_140(var_8dc, var_8ff);
         sub_f0(var_84c, var_896);
         var_84c.clear();
         sub_192(false);
         if (Class_178.var_5bb > -1 || Class_178.var_dc6 == 6) {
            var_99f.addElement(Class_178.var_d34[0]);
            Class_178.var_d34[0].sub_1e();
         }

         var_953 = (byte)(var_99f.size() - 1);
         var_983 = sub_b2d();
         Class_205.var_4aa = 0;
         Class_178.var_17e = 0;
         sub_80d(var_983.var_bb, var_983.var_123, true, false, false);
         sub_3d2();
         var_de4 = 2;
         var_e52 = 5;
         var_390 = 0;
         var_cdc = var_1d;

         for(var2 = 0; var2 < Class_205.var_552.length; ++var2) {
            Class_205.var_552[var2] = 0;
         }

         sub_702();
      }
   }

   private static void sub_c2() {
      if (!var_e7f) {
         int var0 = Class_1b0.var_217[6].getHeight() * Class_1b0.var_217[6].getWidth() / 576;

         int var1;
         int var2;
         for(var1 = 0; var1 < var_52f.length; ++var1) {
            for(var2 = 0; var2 < var_590[var1].length && var_52f[var1][0] >= var0; ++var2) {
               var_52f[var1] = var_52f[var_590[var1][var2 + 1]];
            }
         }

         var0 = Class_1b0.var_217[5].getHeight() * Class_1b0.var_217[5].getWidth() / 576;

         for(var1 = 0; var1 < Class_1cc.var_da.length; ++var1) {
            for(var2 = 0; var2 < var_64c[var1].length && Class_1cc.var_da[var1][0] >= var0; ++var2) {
               if (var_64c[var1][0] == -1) {
                  Class_1cc.var_da[var1][0] = Class_1cc.var_da[var1][1] = Class_1cc.var_da[var1][2] = Class_1cc.var_da[var1][3] = (byte)var0;
                  Class_1cc.var_da[var1][4] = -1;
                  break;
               }

               Class_1cc.var_da[var1][0] = Class_1cc.var_da[var_64c[var1][var2 + 1]][0];
               Class_1cc.var_da[var1][1] = Class_1cc.var_da[var_64c[var1][var2 + 1]][1];
               Class_1cc.var_da[var1][2] = Class_1cc.var_da[var_64c[var1][var2 + 1]][2];
               Class_1cc.var_da[var1][3] = Class_1cc.var_da[var_64c[var1][var2 + 1]][3];
               Class_1cc.var_da[var1][5] = Class_1b0.sub_6b7(Class_1cc.var_da[var1][5], (byte)6, Class_1b0.sub_678(Class_1cc.var_da[var_64c[var1][var2 + 1]][5], (byte)6));
               Class_1cc.var_da[var1][5] = Class_1b0.sub_6b7(Class_1cc.var_da[var1][5], (byte)7, Class_1b0.sub_678(Class_1cc.var_da[var_64c[var1][var2 + 1]][5], (byte)7));
               Class_1cc.var_da[var1][6] = Class_1cc.var_da[var_64c[var1][var2 + 1]][6];
            }
         }

         var_e7f = true;
      }
   }

   public static void sub_f0(Hashtable var0, Hashtable var1) {
      var1.clear();
      Enumeration var2 = var0.elements();

      while(var2.hasMoreElements()) {
         Class_7c var3 = (Class_7c)var2.nextElement();
         Class_7c var4;
         (var4 = new Class_7c(var3.var_4c, var3.var_71, var3.var_119, var3.var_163, (byte)0, var3.var_1f5, var3.var_22c)).var_18d = var3.var_18d;
         var4.var_1a5 = var3.var_1a5;
         var1.put(sub_201(var3.var_71, var3.var_119), var4);
      }

   }

   public static void sub_140(Hashtable var0, Hashtable var1) {
      var1.clear();
      Enumeration var2 = var0.keys();

      while(var2.hasMoreElements()) {
         Integer var3 = (Integer)var2.nextElement();
         Integer var4 = (Integer)var0.get(var3);
         var1.put(var3, var4);
      }

   }

   private static void sub_181() {
      Class_178.var_ff4 = null;
      var_e52 = 0;
      if (var_c64 == 5) {
         var_99f.removeElement(Class_178.var_d34[0]);
         Class_178.sub_2c8((byte)36, (byte[])null, (short)155, (Object[])null, new short[]{126}, (short)142);
      } else {
         if (var_c64 == 4) {
            var_99f.removeElement(Class_178.var_d34[0]);
            Class_178.var_ea3 = 153;
         } else {
            if (var_c64 == 2) {
               short var4;
               if (Class_178.var_d50.contains(Class_178.var_d34[0]) && !var_99f.isEmpty()) {
                  var4 = 157;
               } else {
                  var4 = 154;
               }

               Class_178.sub_2c8((byte)36, new byte[]{48, 0}, var4, (Object[])null, new short[]{126}, (short)142);
               Class_178.var_55f.sub_8c(4, 1);
               return;
            }

            int var0 = 0;

            int var1;
            for(var1 = 0; var1 < var_99f.size(); ++var1) {
               Class_205 var2 = (Class_205)var_99f.elementAt(var1);
               var0 += var2.var_3fa[1] * var_71c[1][0] + var2.var_3fa[2] * var_71c[2][0] + var2.var_3fa[3] * var_71c[3][0] + var2.var_3fa[4] * var_71c[4][0] + var2.var_3fa[5] * var_71c[5][0];
               var2.sub_41a();
               var2.sub_44c();
            }

            var_99f.removeElement(Class_178.var_d34[0]);
            var1 = 0;
            if (var0 > 0) {
               if (var_c64 == 3) {
                  var0 -= var_390;
               }

               for(int var5 = var_99f.size() - 1; var5 >= 0; --var5) {
                  Class_205 var3 = (Class_205)var_99f.elementAt(var5);
                  var1 += var0 * var_6c9[var3.var_3a][1] / 100;
               }

               Class_178.var_e38 += var0 - var1;
               Class_178.var_ea3 = (short)(var_390 > 0 ? 151 : 150);
               Class_178.var_eff = new Object[]{new Integer(100 * var0 / var_779[0]), new Integer(var0), new Integer(var0 - var1)};
            } else {
               Class_178.var_ea3 = 152;
            }
         }

         Class_178.var_1217 = 3;
      }
   }

   public static void sub_192(boolean var0) {
      Enumeration var1 = var_826.elements();

      while(var1.hasMoreElements()) {
         ((Class_7c)var1.nextElement()).sub_c6(var0);
      }

   }

   public static void sub_1aa() {
      var_12a = var_1d / 24 - 1 - var_12a % 2;
      var_18b = var_b0 / 24 - 1 - var_18b % 2;
   }

   public static Integer sub_201(int var0, int var1) {
      return new Integer(var0 << 8 | var1);
   }

   public static void sub_233(byte var0) {
      var_c7c = 180;
      var_826.clear();
      var_84c.clear();
      var_8dc.clear();
      DataInputStream var1 = null;

      try {
         var_209 = (var1 = Class_1b0.sub_272(var0)).readByte();
         var_23c = var1.readByte();
         var_753 = new byte[var_209][var_23c];
         byte[] var2 = new byte[var_209 * var_23c];
         var1.readFully(var2);
         int var3 = 0;

         int var5;
         for(int var4 = 0; var4 < var_23c; ++var4) {
            for(var5 = 0; var5 < var_209; ++var5) {
               var_753[var5][var4] = var2[var3++];
            }
         }

         short var19;
         var2 = new byte[(var19 = var1.readShort()) * 7];
         var1.readFully(var2);

         for(var3 = 0; var3 < var19; ++var3) {
            var5 = var3 * 7;
            var_826.put(sub_201(var2[var5 + 1], var2[var5 + 2]), new Class_7c(var2[var5++], var2[var5++], var2[var5++], var2[var5++], var2[var5++], var2[var5++], var2[var5]));
         }

         byte var24 = var1.readByte();

         for(var3 = 0; var3 < var24; ++var3) {
            Integer var6 = sub_201(var1.readByte(), var1.readByte());
            byte var7;
            var2 = new byte[var7 = var1.readByte()];
            var1.readFully(var2);

            for(int var8 = 0; var8 < var7; var8 += 2) {
               var_8dc.put(sub_201(var2[var8], var2[var8 + 1]), var6);
            }
         }

         if (var1.readByte() > 0) {
            var_bc1 = (byte)var1.readShort();
            var_bf6 = (byte)var1.readShort();
            var1.readShort();
            var_c7c = var1.readShort();
         }
      } catch (Exception var16) {
      } finally {
         try {
            if (var1 != null) {
               var1.close();
            }
         } catch (Exception var15) {
         }

         Class_3d.sub_198();
      }

      var_7a3 = new int[]{0, var_68a[var0 - 1][1] * 100, var_68a[var0 - 1][2] * 100, var_68a[var0 - 1][3] * 100, var_68a[var0 - 1][4] * 100, var_68a[var0 - 1][5] * 100, var_68a[var0 - 1][11] * 100};
      var_7f3 = var_68a[var0 - 1][6] * 100;
      if (Class_178.var_5bb == -1) {
         Class_178.var_e38 = var_68a[var0 - 1][12];
      }

      var_779 = new int[6];
      Hashtable var18 = new Hashtable();
      Enumeration var22 = var_826.elements();

      Class_7c var20;
      Integer var21;
      Integer[] var25;
      while(var22.hasMoreElements()) {
         var20 = (Class_7c)var22.nextElement();
         var25 = new Integer[3];
         if (var20.var_22c > 0 && var20.var_1f5 != 0 && Class_1b0.sub_678(Class_1cc.var_da[var20.var_4c][5], (byte)4)) {
            var21 = sub_201(var20.var_1f5, var20.var_22c);
            if (var18.containsKey(var21)) {
               (var25 = (Integer[])((Integer[])var18.get(var21)))[0] = new Integer(var20.var_22c);
               var25[1] = new Integer(var25[1].intValue() + 1);
               var25[2] = var25[1];
               var18.remove(var21);
               var18.put(var21, var25);
            } else {
               var25[0] = new Integer(var20.var_22c);
               var25[1] = new Integer(1);
               var25[2] = new Integer(1);
               var18.put(var21, var25);
            }
         }
      }

      var22 = var_826.elements();

      while(true) {
         while(true) {
            do {
               do {
                  do {
                     do {
                        if (!var22.hasMoreElements()) {
                           var22 = var_826.elements();

                           while(var22.hasMoreElements()) {
                              var20 = (Class_7c)var22.nextElement();
                              if (Class_1b0.sub_678(Class_1cc.var_da[var20.var_4c][5], (byte)4) && var20.var_1f5 < 6) {
                                 int[] var27 = var_779;
                                 var27[0] += var20.var_22c * var_71c[var20.var_1f5][0];
                                 var27 = var_779;
                                 byte var28 = var20.var_1f5;
                                 var27[var28] += var20.var_22c * var_71c[var20.var_1f5][0];
                              }
                           }

                           var_779[0] = var_779[0] / 1000 * 1000;
                           var_c7c = var_68a[var0 - 1][0] + Class_1b0.sub_21(0, 10);
                           return;
                        }
                     } while((var20 = (Class_7c)var22.nextElement()).var_22c <= 0);
                  } while(var20.var_1f5 == 0);
               } while(!Class_1b0.sub_678(Class_1cc.var_da[var20.var_4c][5], (byte)4));

               var21 = sub_201(var20.var_1f5, var20.var_22c);
            } while(!var18.containsKey(var21));

            if ((var25 = (Integer[])((Integer[])var18.get(var21)))[1].intValue() > 1) {
               var20.var_22c = 0;
               if (var25[1].intValue() == 2 && var25[2].intValue() == 2) {
                  int var23;
                  if ((var23 = Class_1b0.sub_21(0, 2)) == 1) {
                     var20.var_22c = (byte)Class_1b0.sub_21(0, var25[0].intValue());
                  } else if (var23 == 2) {
                     var20.var_22c = (byte)var25[0].byteValue();
                  }
               } else if (Class_1b0.sub_21(0, 1) == 1) {
                  var20.var_22c = (byte)Math.min(Class_1b0.sub_21(0, var25[0].intValue() >> 1), var25[0].intValue());
               }

               var25[0] = new Integer(var25[0].intValue() - var20.var_22c);
               var25[1] = new Integer(var25[1].intValue() - 1);
               var18.remove(var21);
               var18.put(var21, var25);
            } else if (var25[1].intValue() == 1) {
               var20.var_22c = var25[0].byteValue();
               var25[0] = new Integer(0);
               var25[1] = new Integer(0);
               var18.remove(var21);
               var18.put(var21, var25);
            } else {
               var20.var_22c = 0;
            }
         }
      }
   }

   public static void sub_26f(Graphics var0) {
      if (var_2a1 != null) {
         Class_178.var_338 = true;
         if (var_2c9 && (var_209 * 24 < var_1d || var_23c * 24 < var_cf)) {
            var_2a1.setColor(var_a5a == 0 ? 0 : 10066329);
            var_2a1.setClip(0, 0, var_1d, var_b0);
            var_2a1.fillRect(0, 0, var_1d, var_b0);
         }

         sub_45a(var0);
         if (var_a5a == 1) {
            sub_44c(var0);
            sub_38e(var0);
         }

         sub_422(var0);
         if (var_a5a == 1) {
            sub_3a8(var0);
         }

         sub_2d2(var0);
         sub_33b(var0);
         Class_178.sub_94f(var0, Class_178.var_b74, Class_178.var_bca, false);
         var_2c9 = false;
         var_35f = false;
         if (var_314) {
            var_2c9 = true;
            var_314 = false;
         }

         Class_178.var_338 = false;
      }
   }

   private static void sub_2d2(Graphics var0) {
      var0.setClip(0, var_b0 - Class_1cc.var_b6[9][3], var_1d, Class_1cc.var_b6[9][3]);
      var0.drawImage(var_25f, 0, 0, 0);
      if (var_a5a == 1 && var_983 != null && var_983.var_3d8 != null && var_983.sub_311()) {
         byte var1 = var_983.var_1a6 == 5 ? 1 : var_983.var_3d8.var_4c;
         byte var2 = var_983.var_1a6 == 3 ? 8 : Class_205.var_2a[var1][Class_178.sub_e5c(var_983.var_451[var_983.var_47f])];
         var_983.var_3d8.sub_92(var0, var2, var_983.var_1a6 != 3);
      }

      if (var_983 != null) {
         int var9 = var_1d < 130 ? 2 : 4;
         Class_1b0.sub_2db(var0, (byte)24, 0, var9, var_b0 - Class_1cc.var_b6[24][3]);
         Class_1b0.sub_2db(var0, (byte)5, var_983.var_3a, var9 + (Class_1cc.var_b6[24][2] >> 1) - (Class_1cc.var_b6[5][2] >> 1), var_b0 - Class_1cc.var_b6[24][3] + (Class_1cc.var_b6[24][3] >> 1) - (Class_1cc.var_b6[5][3] >> 1) + 1);
         if (var_a5a == 0 && Class_178.var_80 > 6 && var_983.var_29a < var_983.var_2d2) {
            int var10 = var_b0 - Class_1cc.var_b6[9][3];
            int var3 = Class_1cc.var_b6[9][3] - Class_1cc.var_b6[26][3] + 1 >> 1;
            int var4;
            int var5 = (var4 = var9 + Class_1cc.var_b6[24][2] + var9) + 1;
            int var6 = var10 + var3 + 1;
            int var7 = Class_1cc.var_b6[25][2] - 2;
            int var8 = Class_1cc.var_b6[25][3] - 2;
            Class_1b0.sub_2db(var0, (byte)25, 0, var4, var10 + var3);
            var0.setColor(0);
            var0.setClip(0, 0, var_1d, var_b0);
            var0.fillRect(var5, var6, var7, var8 - var8 * var_983.var_2d2 / var_6c9[var_983.var_3a][0]);
         }
      }

   }

   public static void sub_2df(Graphics var0, boolean var1) {
      int var2 = var_b0 - Class_1cc.var_b6[9][3];
      int var3 = Class_1cc.var_b6[9][3] - Class_1cc.var_b6[26][3] + 1 >> 1;
      int var4 = 0;
      int var5 = var_1d < 130 ? 2 : 4;
      if (var_983 == null) {
         var1 = true;
      }

      while(var4 < var_1d) {
         Class_1b0.sub_2db(var0, (byte)(var1 ? 9 : 12), 0, var4, var2);
         var4 += Class_1cc.var_b6[var1 ? 9 : 12][2];
      }

      if (var_983 != null) {
         Class_1b0.sub_2db(var0, (byte)24, 0, var5, var_b0 - Class_1cc.var_b6[24][3]);
         Class_1b0.sub_2db(var0, (byte)5, var_983.var_3a, var5 + (Class_1cc.var_b6[24][2] >> 1) - (Class_1cc.var_b6[5][2] >> 1), var_b0 - Class_1cc.var_b6[24][3] + (Class_1cc.var_b6[24][3] >> 1) - (Class_1cc.var_b6[5][3] >> 1) + 1);
         int var6 = (var4 = var5 + Class_1cc.var_b6[24][2] + var5) + 1;
         int var7 = var2 + var3 + 1;
         int var8 = Class_1cc.var_b6[25][2] - 2;
         int var9 = Class_1cc.var_b6[25][3] - 2;
         Class_1b0.sub_2db(var0, (byte)25, 0, var4, var2 + var3);
         var4 += Class_1cc.var_b6[25][2] + var5;

         for(int var10 = 0; var10 < var_983.var_451.length; ++var10) {
            Class_1b0.sub_2db(var0, (byte)26, 0, var4, var2 + var3);
            if (var_983.var_451[var10] != 116) {
               Class_1b0.sub_2db(var0, (byte)8, Class_178.sub_e5c(var_983.var_451[var10]), var4 + 2, var2 + var3 + 2);
            }

            var4 += Class_1cc.var_b6[26][2] + var5;
         }

         var0.setColor(0);
         var0.setClip(0, 0, var_1d, var_b0);
         var0.fillRect(var6, var7, var8, var9 - var9 * var_983.var_29a / var_6c9[var_983.var_3a][0]);
      } else {
         Class_19e.sub_388(var0, 2, var2 + Class_19e.var_ac, 1, 4);
         var4 = 2 + Class_1cc.var_b6[38][2] + 5;
         Class_1b0.sub_47c(var0, Class_1b0.sub_42b((short)262), var4, var2 + (Class_1cc.var_b6[9][3] >> 1) - (Class_1b0.var_a9 >> 1));
      }
   }

   private static void sub_33b(Graphics var0) {
      if (var_983 != null) {
         int var1 = Class_205.var_4aa / 60;
         int var2 = Class_205.var_4aa - var1 * 60;
         int var3;
         if (var_a5a == 1) {
            var3 = var_c7c - 30;
         } else {
            var3 = var_68a[Class_178.var_dc6 - 1][0] + 0;
         }

         String var5 = String.valueOf(var1) + ':' + (var2 < 10 ? "0" : "") + var2;
         if (Class_1b0.var_19d) {
            int var6 = 5 * Class_1b0.var_12 + 4;
            int var7 = Class_1b0.var_a9 + 4;
            var0.setClip(0, 0, var_1d, var_b0);
            var0.setColor(11446175);
            var0.fillRect(var_1d - var6 - 2, var_b0 - Class_1cc.var_b6[9][3] - var7 + 4, var6, var7);
            if (Class_205.var_4aa > var3 && Class_178.var_80 > 6) {
               var0.setColor(16711680);
               var0.fillRect(var_1d - var6 - 2, var_b0 - Class_1cc.var_b6[9][3] - var7 + 4, var6, var7);
            }

            Class_1b0.sub_46a(var0, var5, var_1d - var6 - 2 + (var6 - var5.length() * Class_1b0.var_12 >> 1), var_b0 - Class_1cc.var_b6[9][3] - var7 + 2 + 4);
         } else {
            Class_1b0.sub_2db(var0, (byte)27, 0, var_1d - Class_1cc.var_b6[27][2] - 2, var_b0 - Class_1cc.var_b6[9][3] - 10);
            if (Class_205.var_4aa > var3 && Class_178.var_80 > 6) {
               var0.setColor(16711680);
               var0.fillRect(var_1d - Class_1cc.var_b6[27][2] - 2 + 4, var_b0 - Class_1cc.var_b6[9][3] - 10 + 4, Class_1cc.var_b6[27][2] - 8, Class_1cc.var_b6[27][3] - 4);
            }

            Class_1b0.sub_46a(var0, var5, var_1d - Class_1cc.var_b6[27][2] - 2 + (Class_1cc.var_b6[27][2] - 4 * Class_1b0.var_12 >> 1), var_b0 - Class_1cc.var_b6[9][3] - 10 + 4);
         }
      }
   }

   private static void sub_38e(Graphics var0) {
      if (var_a5a == 1) {
         Class_1b0.sub_2db(var0, (byte)(var_d39 ? 20 : 21), 0, var_cdc + 17, var_cf8 + 19);
         Class_1b0.sub_2db(var0, (byte)(var_d55 ? 22 : 23), 0, var_cdc + 17, var_cf8 + 5 - Class_1cc.var_b6[var_d55 ? 22 : 23][3]);
      }

   }

   private static void sub_3a8(Graphics var0) {
      if (var_a5a == 1) {
         Class_1b0.sub_2e7(var0, 10, 0, var_cdc, var_cf8, 0, 0, 0, var_cf8 + Class_1cc.var_b6[46][3] - var_cf);
         Class_1b0.sub_2db(var0, (byte)14, 0, var_d80, var_dc9);
      } else if (var_2c9 && var_cf8 <= var_cf) {
         Class_1b0.sub_2e7(var_2a1, 46, 0, var_cdc, var_cf8, 0, 0, 0, var_cf8 + Class_1cc.var_b6[46][3] - var_cf);
         var_2a1.setClip(0, 0, var_1d, var_b0);
      }
   }

   public static void sub_3d2() {
      if (var_e52 == 0 || var_e52 == 2) {
         var_cdc = var_1dc + var_bc1 * 24 - 12;
         var_cf8 = var_1fb + var_bf6 * 24;
      }

      if (var_e52 != 4) {
         var_d80 = -Class_1cc.var_b6[14][2];
         var_dc9 = var_cf8;
      }

      switch(var_e52) {
      case 0:
         return;
      case 1:
         var_cdc -= var_de4++;
         if (var_cdc + 48 < 0 && var_e2f++ > 48) {
            sub_181();
            return;
         }
         break;
      case 2:
         var_de4 = 1;
         return;
      case 3:
         var_cdc -= var_de4++;
         if (var_cdc + 48 < 0 && var_e2f++ > 48) {
            if (Class_205.var_4aa > var_c7c - 30) {
               sub_7b0();
               var_e2f = 0;
               var_e52 = 4;
               var_de4 = 2;
               return;
            }

            sub_181();
            return;
         }
         break;
      case 4:
         int var0;
         if ((var0 = var_1dc + var_bc1 * 24 - 12 - 4 - (var_d80 + Class_1cc.var_b6[14][2])) > 0) {
            var_d80 += Math.max(var_de4, 1);
            if (var0 < 15) {
               --var_de4;
            }
         } else {
            ++var_e2f;
         }

         var_dc9 = var_cf8;
         if (var_e2f > 48) {
            sub_181();
            return;
         }
         break;
      case 5:
         var_cdc -= var_de4;
         if (var_cdc <= var_1dc + var_bc1 * 24 - 12) {
            Class_178.var_55f.sub_8c(2, -1);
            var_e52 = 0;
         }
      }

   }

   private static void sub_422(Graphics var0) {
      if (var_99f.size() != 0) {
         var_d55 = false;
         var_d39 = false;
         Enumeration var1 = var_99f.elements();

         while(var1.hasMoreElements()) {
            ((Class_205)var1.nextElement()).sub_1f3(var0);
         }

         if (var_e52 == 2 || var_e52 == 3) {
            var1 = Class_178.var_d50.elements();

            while(var1.hasMoreElements()) {
               Class_205 var2 = (Class_205)var1.nextElement();
               if (!Class_178.var_d82.contains(var2)) {
                  var2.var_1a6 = 0;
                  var2.sub_1f3(var0);
               }
            }
         }

      }
   }

   private static void sub_44c(Graphics var0) {
      if (var_84c.size() > 0) {
         Enumeration var1;
         if (var_a5a == 1) {
            var1 = var_84c.elements();

            while(var1.hasMoreElements()) {
               ((Class_7c)var1.nextElement()).sub_59(var0);
            }
         }

         if (var_a5a == 0) {
            var1 = var_84c.elements();

            while(var1.hasMoreElements()) {
               Class_7c var2;
               if ((var2 = (Class_7c)var1.nextElement()).var_18d - 5 <= Class_205.var_4aa) {
                  var2.sub_59(var0);
               }
            }
         }
      }

   }

   private static void sub_45a(Graphics var0) {
      if (var_2c9) {
         var_35f = true;
         int var1 = var_a5a == 0 ? 2 : 0;
         int var3;
         int var4 = (var3 = -var_1dc / 24) + var_12a + 2;
         int var5;
         int var6 = (var5 = -var_1fb / 24) + var_18b + 2;
         boolean[] var9 = new boolean[4];
         if (var_a5a == 1) {
            boolean var11 = false;

            for(int var12 = var5; var12 <= var6; ++var12) {
               for(int var13 = var3; var13 <= var4; ++var13) {
                  if (var13 >= 0 && var13 < var_209 && var12 >= 0 && var12 < var_23c && sub_49a(var13, var12, false) <= 12) {
                     var9[0] = var9[1] = var9[2] = var9[3] = false;

                     int var7;
                     byte var10;
                     for(var7 = 0; var7 < 4; ++var7) {
                        if ((var10 = sub_49a(var13 + var_3e7[0][var7], var12 + var_3e7[1][var7], true)) > 12) {
                           if ((var7 == 0 || var7 == 2) && (var10 == 14 || var10 == 15)) {
                              var10 = 13;
                           }

                           if ((var7 == 1 || var7 == 3) && (var10 == 17 || var10 == 18)) {
                              var10 = 16;
                           }

                           Class_1b0.sub_2e7(var_2a1, var1, var10, var_1dc + var13 * 24, var_1fb + var12 * 24, var7 == 2 ? 12 : 0, var7 == 0 ? 12 : 0, var7 == 3 ? 12 : 0, var7 == 1 ? 12 : 0);
                           var9[var7] = var9[var7 == 0 ? 3 : var7 - 1] = true;
                        }
                     }

                     for(var7 = 0; var7 < 4; ++var7) {
                        if (!var9[var7]) {
                           label300: {
                              if ((var10 = sub_49a(var13 + var_42b[0][var7], var12 + var_42b[1][var7], true)) > 12) {
                                 if (var10 == 14 || var10 == 15) {
                                    var10 = 13;
                                 }

                                 if (var10 != 17 && var10 != 18) {
                                    break label300;
                                 }
                              }

                              var10 = 16;
                           }

                           Class_1b0.sub_2e7(var_2a1, var1, var10, var_1dc + var13 * 24, var_1fb + var12 * 24, var_42b[0][var7] == -1 ? 0 : 12, var_42b[0][var7] == 1 ? 0 : 12, var_42b[1][var7] == -1 ? 0 : 12, var_42b[1][var7] == 1 ? 0 : 12);
                        }
                     }
                  }
               }
            }
         }

         for(int var24 = var5; var24 <= var6; ++var24) {
            for(int var20 = var3; var20 <= var4; ++var20) {
               byte var2;
               if (var20 >= 0 && var20 < var_209 && var24 >= 0 && var24 < var_23c) {
                  var2 = var_753[var20][var24];
                  if (var_a5a == 0 && var2 > 12) {
                     var2 = 13;
                  }
               } else {
                  var2 = 16;
                  if (var_a5a == 0) {
                     var2 = 14;
                  }
               }

               Integer var22 = sub_201(var20, var24);
               Class_7c var25 = null;
               boolean var14 = false;
               if (var_826.containsKey(var22)) {
                  var14 = (var25 = (Class_7c)var_826.get(var22)) != null && (var25.var_4c == 1 || var25.var_4c == 2);
               }

               if (!var14 || var_a5a == 0) {
                  if (var_a5a == 0) {
                     Class_1b0.sub_2db(var_2a1, (byte)var1, 13, var_1dc + var20 * 24, var_1fb + var24 * 24);
                  }

                  Class_1b0.sub_2db(var_2a1, (byte)var1, var2, var_1dc + var20 * 24, var_1fb + var24 * 24);
               }

               if (var_a5a == 0 && var_8dc.containsKey(var22) && var_7f3 == 0) {
                  Class_1b0.sub_2db(var_2a1, (byte)var1, (byte)(15 + ((Class_7c)var_826.get(var_8dc.get(var22))).var_22c), var_1dc + var20 * 24, var_1fb + var24 * 24);
               }

               if (var25 != null) {
                  var25.sub_59(var_2a1);
               }
            }
         }

         if (var_a5a == 0) {
            var_2a1.setClip(0, 0, var_1d, var_b0);
            Enumeration var21 = var_99f.elements();

            while(var21.hasMoreElements()) {
               Class_205 var23;
               (var23 = (Class_205)var21.nextElement()).var_2d2 = var23.var_29a;
               byte var27 = 0;

               for(int var28 = 0; var28 < Class_205.var_4aa && var28 < var23.var_39c.size(); ++var28) {
                  Class_240 var26;
                  if ((var26 = var23.sub_ff(var28)).sub_a2() == 1 && var26.var_29 >= var3 && var26.var_29 <= var4 && var26.var_86 >= var5 && var26.var_86 <= var6) {
                     short var15 = var_3e7[0][var26.sub_106()];
                     short var16 = var_3e7[1][var26.sub_106()];
                     int var17 = var_1dc + var26.var_29 * 24;
                     int var18 = var_1fb + var26.var_86 * 24;
                     var_2a1.setColor(var_c58[var23.var_3a]);

                     for(int var19 = 0; var19 < 24; var19 += 2) {
                        var_2a1.fillRect(var17 + 12 - 1 + var23.var_3a + var19 * var15, var18 + 12 - 1 + var23.var_3a + var19 * var16, 2, 2);
                     }
                  }

                  if (var_983 != null && var23.var_3a == var_983.var_3a) {
                     if ((var26.sub_a2() == 3 || var26.sub_a2() == 4 && var23.var_451[var26.sub_123()] == 115) && var27 != var26.var_df) {
                        var27 = var26.var_df;
                        byte var29 = var23.var_bb;
                        byte var30 = var23.var_123;
                        byte var31 = var23.var_17b;
                        var23.var_bb = var26.var_29;
                        var23.var_123 = var26.var_86;
                        var23.var_17b = var26.sub_106();
                        var23.var_3d8 = sub_912(var23);
                        var23.var_bb = var29;
                        var23.var_123 = var30;
                        var23.var_17b = var31;
                        if (var23.var_3d8 != null && var23.var_3d8.var_1f5 != 0 && var23.var_3d8.var_22c > 0 && var_7a3[var23.var_3d8.var_1f5] <= 0) {
                           var23.var_2d2 = (byte)(var23.var_2d2 + var_71c[var23.var_3d8.var_1f5][1]);
                        }
                     } else if (var27 != var26.var_df) {
                        var27 = 0;
                     }

                     if (var26.var_29 == var_bc1 && var26.var_86 == var_bf6) {
                        var23.var_2d2 = var23.var_29a;
                     }
                  }
               }
            }

            sub_3a8(var_2a1);
            sub_44c(var_2a1);
         }
      }

      if (var_35f) {
         sub_2df(var_2a1, false);
      }

      var0.drawImage(var_25f, 0, 0 - var_4a5, 0);
   }

   private static byte sub_49a(int var0, int var1, boolean var2) {
      if (var0 >= 0 && var0 < var_209 && var1 >= 0 && var1 < var_23c) {
         byte var3;
         if ((var3 = var_753[var0][var1]) <= 12) {
            return var3;
         } else {
            Class_7c var4;
            if ((var4 = (Class_7c)var_826.get(sub_201(var0, var1))) != null && (var4.var_4c == 1 || var4.var_4c == 2)) {
               var3 = 12;
            }

            return var3;
         }
      } else {
         return (byte)(var2 ? 12 : 16);
      }
   }

   public static boolean sub_4d1(Class_205 var0, boolean var1) {
      if (!var0.sub_3a5()) {
         return false;
      } else if (Class_205.var_51f == var_bf6 && (Class_205.var_4ca == var_bc1 - 1 || Class_205.var_4ca == var_bc1 + 1)) {
         return false;
      } else {
         boolean var2;
         if ((var2 = var_753[Class_205.var_4ca][Class_205.var_51f] > 12) && !var1) {
            Enumeration var3 = var_99f.elements();

            label59: {
               int var5;
               int var6;
               do {
                  do {
                     do {
                        Class_205 var4;
                        do {
                           if (!var3.hasMoreElements()) {
                              break label59;
                           }
                        } while((var4 = (Class_205)var3.nextElement()).var_24a > 0);

                        var5 = var4.var_bb;
                        var6 = var4.var_123;
                        if (var4.var_1a6 == 1 && var4 != var0) {
                           var5 = var4.var_bb + var_3e7[0][var4.var_17b];
                           var6 = var4.var_123 + var_3e7[1][var4.var_17b];
                        }
                     } while(var5 != Class_205.var_4ca);
                  } while(var6 != Class_205.var_51f);
               } while(var5 == var_bc1 && var6 == var_bf6);

               var2 = false;
            }

            if (var2 && var_a5a == 1) {
               sub_538(sub_201(Class_205.var_4ca, Class_205.var_51f));
            }
         }

         return var2;
      }
   }

   public static boolean sub_4f6(Class_205 var0, boolean var1) {
      if (!var0.sub_3a5()) {
         return false;
      } else {
         Integer var2 = sub_201(Class_205.var_4ca, Class_205.var_51f);
         boolean var3;
         if (var3 = var_826.containsKey(var2)) {
            Class_7c var4;
            if ((var4 = (Class_7c)var_826.get(var2)).var_4c == 20 || var4.var_4c == 25) {
               return false;
            }

            if (var4.var_4c == 6 && (var_7f3 > 0 || var4.var_18d > 0 && var4.var_18d <= Class_205.var_4aa)) {
               return false;
            }

            if (var4.var_4c == 4 && var1 && (var_7a3[5] > 0 || var4.var_18d > 0 && var4.var_18d <= Class_205.var_4aa)) {
               return false;
            }

            if (var4.var_4c == 1 || var4.var_4c == 2) {
               if (!var1 && var4.var_1bc[0] <= 0) {
                  return false;
               }

               if (var1 && var4.var_18d > 0 && var4.var_18d <= Class_205.var_4aa) {
                  return false;
               }
            }
         }

         return var3;
      }
   }

   private static void sub_538(Integer var0) {
      if (var_8dc.containsKey(var0)) {
         if (Class_178.var_5bb == -1) {
            var_c64 = 5;
            Class_178.sub_2c8((byte)39, (byte[])null, (short)156, (Object[])null, new short[]{126}, (short)137);
         } else {
            if (!var_a93) {
               var_c7c = Math.min(var_c7c, Class_205.var_4aa + Class_1b0.sub_21(20, 30));
               var_a93 = true;
               Class_178.sub_2c8((byte)0, (byte[])null, (short)146, (Object[])null, new short[]{126}, (short)137);
            }

         }
      }
   }

   private static void sub_574(boolean var0) {
      if (!var_a93) {
         if (var0) {
            if (!var_b0a) {
               if (var_aad) {
                  var_c7c -= Class_1b0.sub_21(0, 30);
               } else {
                  var_c7c -= Class_1b0.sub_21(30, 50);
               }

               var_b0a = true;
               return;
            }
         } else if (!var_aad && !var_b0a) {
            var_c7c -= Class_1b0.sub_21(10, 30);
            var_aad = true;
         }

      }
   }

   public static void sub_585(Class_205 var0, boolean var1) {
      Enumeration var2 = var_99f.elements();

      while(true) {
         while(true) {
            Class_205 var3;
            do {
               if (!var2.hasMoreElements()) {
                  sub_6bc();
                  return;
               }
            } while((var3 = (Class_205)var2.nextElement()).var_3a == var0.var_3a);

            if (var3.var_39c.size() <= Class_205.var_4aa) {
               var3.var_341 = (short)(var3.var_39c.size() - 1);
               var3.sub_7b(true);
            } else {
               var3.var_341 = Class_205.var_4aa;
               var3.sub_7b(true);
               if (var3.var_1a6 != 0) {
                  var3.var_341 = (short)(Class_205.var_4aa + 1);
                  var3.sub_7b(true);
                  byte var4 = var3.var_1a6;
                  var3.var_341 = Class_205.var_4aa;
                  var3.sub_7b(true);
                  var3.var_210 = var1;
                  if (var3.var_1a6 == 1 && var_f0.sub_97(Class_178.var_93a) == 1) {
                     var3.var_bb = (byte)(var3.var_bb + var_3e7[0][var3.var_17b]);
                     var3.var_123 = (byte)(var3.var_123 + var_3e7[1][var3.var_17b]);
                  }

                  if (var3.var_1a6 == 4 && var4 != 4 || var3.var_1a6 == 3 && var4 != 3) {
                     sub_702();
                  }
               }
            }
         }
      }
   }

   private static void sub_5a5(Class_205 var0) {
      if (var_a5a == 0) {
         int var1 = 0;
         int var2 = 0;
         if (var0.var_1a6 == 1) {
            var1 = var_3e7[0][var0.var_17b] * (var0.var_1ec * 24 / 12);
            var2 = var_3e7[1][var0.var_17b] * (var0.var_1ec * 24 / 12);
         }

         int var4 = var_1dc + var0.var_bb * 24 + var1;
         int var5 = var_1fb + var0.var_123 * 24 + var2;
         var_2a1.setColor(var_c58[var0.var_3a]);
         var_2a1.setClip(0, 0, var_1d, var_cf);
         var_2a1.fillRect(var4 + 12 - 1 + var0.var_3a, var5 + 12 - 1 + var0.var_3a, 2, 2);
      }

   }

   public static void sub_5fd() {
      if (var_247 != -1) {
         short var0 = var_247;
         var_247 = -1;
         switch(var0) {
         case 185:
            Class_178.sub_2c8((byte)0, new byte[]{5, var_983.var_3a}, (short)185, (Object[])null, new short[]{126}, (short)(41 + var_983.var_3a));
            return;
         case 186:
            Class_178.sub_2c8((byte)0, new byte[]{5, var_983.var_3a}, (short)186, (Object[])null, new short[]{126}, (short)(41 + var_983.var_3a));
            return;
         }
      }

      if (var_983 != null) {
         if (var_953 == -1) {
            var_983 = null;
            sub_702();
         } else {
            if (var_a5a == 1 && Class_178.var_91 == 0 && var_e52 != 5) {
               ++Class_205.var_4aa;
               if (Class_205.var_4aa > var_c7c - 10 && Class_178.var_5bb > -1 && !var_b69) {
                  Class_178.var_55f.sub_8c(6, -1);
                  var_b69 = true;
               } else if (Class_205.var_4aa == var_c7c - 1 && Class_178.var_5bb > -1) {
                  if (var_bc1 == Class_178.var_d34[0].var_bb && var_bf6 == Class_178.var_d34[0].var_123 && !Class_178.var_d34[0].var_210 && var_e52 == 0) {
                     sub_a0e();
                  }
               } else if (Class_205.var_4aa > var_c7c) {
                  if (Class_178.var_5bb == -1) {
                     var_c64 = 5;
                     sub_181();
                  } else if (var_e52 == 0) {
                     var_c64 = 2;
                     var_de4 = 4;
                     var_e2f = 0;
                     sub_7b0();
                     sub_3d2();
                     var_e52 = 4;
                  }
               }
            }

            Enumeration var5 = var_99f.elements();

            while(var5.hasMoreElements() && var_e52 != 5) {
               Class_205 var1 = (Class_205)var5.nextElement();
               if (var_983.var_3a == var1.var_3a && var_e52 == 0) {
                  sub_80d(var1.var_bb, var1.var_123, false, false, false);
               }

               if (var1.var_24a > 0) {
                  ++var1.var_1ec;
                  if (var1.var_1ec >= 12) {
                     var1.var_1ec = 0;
                     --var1.var_24a;
                  }
               } else {
                  if (var1.var_210) {
                     if (var_983.var_3a == var1.var_3a && Class_178.var_93a == 999999) {
                        Class_178.var_9af = 999999;
                     }

                     ++var1.var_1ec;
                     sub_5a5(var1);
                     if (var1.var_1ec >= 12) {
                        var1.var_1ec = 0;
                        if (var1.var_1a6 == 1) {
                           var1.var_bb = (byte)(var1.var_bb + var_3e7[0][var1.var_17b]);
                           var1.var_123 = (byte)(var1.var_123 + var_3e7[1][var1.var_17b]);
                           var1.var_210 = false;
                           if (var1.var_bb == var_bc1 && var1.var_123 == var_bf6) {
                              sub_65f();
                           }
                        }

                        if (var_a5a == 0 || var1.var_1a6 == 2) {
                           var1.var_210 = false;
                        }

                        if (var1.var_3d8 != null) {
                           if (var_a5a == 0) {
                              var1.var_210 = false;
                              var1.var_3d8 = null;
                           } else if (var_a5a == 1) {
                              label210: {
                                 switch(var1.var_1a6) {
                                 case 3:
                                    if (var1.var_3d8.var_1bc[1] > 0 && var1.var_3d8.var_1bc[0] <= 0) {
                                       --var1.var_3d8.var_1bc[1];
                                       if (var1.var_3d8.var_1bc[1] > 0) {
                                          break label210;
                                       }

                                       var1.sub_373();
                                       var_2c9 = true;
                                    }
                                    break;
                                 case 4:
                                    if (var1.var_3d8.var_1bc[0] <= 0) {
                                       var1.sub_1ba(var1.var_1a6, var1.var_17b);
                                       var1.var_210 = false;
                                       var1.var_3d8 = null;
                                       break label210;
                                    }

                                    --var1.var_3d8.var_1bc[0];
                                    if (var1.var_3d8.var_1bc[0] > 0) {
                                       break label210;
                                    }

                                    if (var1.var_3d8.var_4c == 6) {
                                       Integer var2 = sub_201(var1.var_3d8.var_71, var1.var_3d8.var_119);
                                       Enumeration var3 = var_8dc.keys();

                                       while(var3.hasMoreElements()) {
                                          Integer var4 = (Integer)var3.nextElement();
                                          if (var2.equals(var_8dc.get(var4))) {
                                             var_8dc.remove(var4);
                                          }
                                       }
                                    } else if (var1.var_3d8.var_4c == 4) {
                                       if (var1.sub_373()) {
                                          var1.var_3d8.var_1bc[1] = 0;
                                       } else if (var1.var_3d8.var_22c == 0) {
                                          var1.var_3d8.var_1bc[0] = 0;
                                          var1.var_3d8.var_1bc[1] = 0;
                                       } else {
                                          var1.var_3d8.var_1bc[0] = Class_205.var_2a[4][Class_178.sub_e5c(var1.var_451[var1.var_47f])];
                                          var1.var_3d8.var_1bc[1] = 8;
                                       }
                                    }

                                    sub_538(sub_201(var1.var_3d8.var_71, var1.var_3d8.var_119));
                                    var_2c9 = true;
                                    break;
                                 case 5:
                                    if (var1.var_3d8.var_1bc[0] > 0) {
                                       --var1.var_3d8.var_1bc[0];
                                       if (var1.var_3d8.var_1bc[0] <= 0) {
                                          var1.var_3d8.var_1bc[1] = 5;
                                          var_2c9 = true;
                                          break;
                                       }
                                    }
                                 default:
                                    break label210;
                                 }

                                 var1.sub_1ba(var1.var_1a6, var1.var_17b);
                                 var1.var_210 = false;
                                 var1.var_3d8 = null;
                              }
                           }
                        }
                     }
                  }

                  if (!var1.var_210) {
                     if (var_a5a != 1) {
                        if (var_983.var_3a == var1.var_3a && var1.sub_256()) {
                           var1.var_210 = true;
                           sub_585(var1, true);
                           var1.sub_119((byte)1);
                           ++Class_205.var_4aa;
                        }
                     } else {
                        if (var1.var_3a == 0) {
                           if (var_e52 != 2 && var_e52 != 3) {
                              if (var_983.var_3a == var1.var_3a && var_e52 == 0) {
                                 var1.sub_256();
                              }
                           } else {
                              var1.sub_7b(false);
                           }
                        } else {
                           var1.sub_7b(false);
                        }

                        if (var1.var_1a6 != 0) {
                           if (var1.var_1a6 == 1) {
                              if (!sub_4f6(var1, false) && sub_4d1(var1, false)) {
                                 var1.var_1a6 = 1;
                                 ++var1.var_341;
                                 if (var_e52 == 2) {
                                    int var10002 = Class_205.var_552[var1.var_3a]++;
                                 }

                                 var1.var_210 = true;
                              } else {
                                 var1.var_1a6 = 2;
                              }
                           } else if (var1.var_1a6 == 2) {
                              if (var1.var_3a != 0) {
                                 var1.var_210 = true;
                                 ++var1.var_341;
                              }
                           } else {
                              var1.var_3d8 = sub_912(var1);
                              if (var1.var_3d8 != null) {
                                 var1.var_1ec = (byte)Class_1b0.sub_21(0, 6);
                                 if (var1.var_1a6 == 5) {
                                    byte var6 = var1.var_3d8.var_4c;
                                    var1.var_3d8 = new Class_7c((byte)9, var1.var_bb, var1.var_123, var1.var_17b, (byte)0, var1.var_451[var1.var_47f], (byte)0);
                                    var1.var_3d8.var_1bc[0] = Class_205.var_2a[var6][Class_178.sub_e5c(var1.var_451[var1.var_47f])];
                                    var_84c.put(sub_201(var1.var_bb, var1.var_123), var1.var_3d8);
                                    ++var1.var_341;
                                    var1.var_210 = true;
                                    var_2c9 = true;
                                 } else if (var1.var_1a6 == 4) {
                                    if (var1.var_3d8.var_1bc[0] == 120) {
                                       var1.var_3d8.var_1bc[0] = Class_205.var_2a[var1.var_3d8.var_4c][Class_178.sub_e5c(var1.var_451[var1.var_47f])];
                                    }

                                    ++var1.var_341;
                                    var1.var_210 = true;
                                 } else if (var1.var_1a6 == 3) {
                                    ++var1.var_341;
                                    var1.var_210 = true;
                                 } else {
                                    var1.var_1a6 = 2;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            sub_68d();
            sub_3d2();
            if (var_a5a == 1) {
               Class_178.sub_1b8((byte)6, (byte)-1, (byte)0, false);
            } else {
               Class_178.sub_1b8((byte)4, (byte)-1, (byte)0, false);
            }
         }
      }
   }

   private static void sub_65f() {
      if (var_a5a != 1) {
         if (var_983 != null && var_983.var_bb == var_bc1 && var_983.var_123 == var_bf6) {
            var_983.var_2d2 = var_983.var_29a;
         }
      } else {
         boolean var0 = true;
         int var1 = var_99f.size() - 1;

         while(true) {
            if (var1 < 0) {
               if (!var0) {
                  return;
               }

               if (var_e52 != 2) {
                  if (var_e52 == 0) {
                     Class_178.sub_2c8((byte)17, (byte[])null, (short)173, (Object[])null, new short[]{126, 127}, (short)137);
                  }

                  return;
               }

               sub_7b0();
               var_de4 = 1;
               var_e2f = 0;
               var_e52 = 3;
               break;
            }

            Class_205 var2;
            if ((var2 = (Class_205)var_99f.elementAt(var1)).var_bb == var_bc1 && var2.var_123 == var_bf6) {
               var2.sub_44c();
               if (var2.var_3a == 0 && var_983.var_3a == 0) {
                  Class_178.var_93a = 999999;
                  Class_178.var_9af = 999999;
               }
            } else {
               var0 = false;
            }

            --var1;
         }
      }

   }

   private static void sub_68d() {
      if (var_84c.size() > 0 && var_a5a == 1) {
         Enumeration var0 = var_84c.elements();

         while(true) {
            Class_7c var1;
            do {
               do {
                  do {
                     if (!var0.hasMoreElements()) {
                        return;
                     }
                  } while((var1 = (Class_7c)var0.nextElement()).var_1bc[0] > 0);

                  ++var1.var_22c;
               } while(var1.var_22c < 12);

               var1.var_22c = 0;
            } while(var1.var_1bc[1] < 0);

            --var1.var_1bc[1];
            if (var1.var_1bc[1] == 0) {
               sub_75c(var1.var_71, var1.var_119, false, false, 0, var1.var_1f5 == 114, false);
               if (var1.var_1f5 == 114) {
                  sub_75c(var1.var_71, var1.var_119, false, false, 0, var1.var_1f5 == 114, true);
               }

               Enumeration var2 = var_99f.elements();

               while(var2.hasMoreElements()) {
                  Class_205 var3;
                  if (Math.abs((var3 = (Class_205)var2.nextElement()).var_bb - var1.var_71) <= 1 && Math.abs(var3.var_123 - var1.var_119) <= 1) {
                     var3.var_24a = 10;
                  }
               }

               var_2c9 = true;
            }

            if (var1.var_1bc[1] < 0) {
               var_4a5 = 0;
            }
         }
      }
   }

   private static void sub_6bc() {
      if (var_84c.size() > 0 && var_a5a == 0) {
         Enumeration var0 = var_84c.elements();

         while(var0.hasMoreElements()) {
            if (((Class_7c)var0.nextElement()).var_18d == Class_205.var_4aa + 1) {
               sub_702();
            }
         }
      }

   }

   public static void sub_702() {
      var_2c9 = true;
      if (Class_178.var_338) {
         var_314 = true;
      }

   }

   public static void sub_75c(int var0, int var1, boolean var2, boolean var3, int var4, boolean var5, boolean var6) {
      for(int var9 = 0; var9 < 4; ++var9) {
         int var7 = var0 + (var6 ? var_42b[0][var9] : var_3e7[0][var9]);
         int var8 = var1 + (var6 ? var_42b[1][var9] : var_3e7[1][var9]);
         Integer var10 = sub_201(var7, var8);
         if (var_826.containsKey(var10)) {
            if (!var2) {
               sub_538(var10);
               sub_574(var5);
            }

            Class_7c var11;
            if ((var11 = (Class_7c)var_826.get(var10)).var_4c != 6 && var11.var_4c != 9 && var11.var_4c != 4 && !Class_1b0.sub_678(Class_1cc.var_da[var11.var_4c][5], (byte)5) && (var5 || var_753[var11.var_71][var11.var_119] > 12 || sub_ae6(var11, var0, var1))) {
               if (var2) {
                  if (var3) {
                     if (var11.var_18d == var4) {
                        var11.var_18d = 0;
                     }
                  } else if (var11.var_18d > var4 || var11.var_18d == 0) {
                     var11.var_18d = (short)var4;
                  }
               } else {
                  var11.var_1bc[0] = 0;
               }
            }
         }
      }

   }

   private static void sub_7b0() {
      sub_80d(var_bc1, var_bf6, true, false, false);
   }

   private static void sub_80d(int var0, int var1, boolean var2, boolean var3, boolean var4) {
      int var5 = var_1dc;
      int var6 = var_1fb;
      if (var_209 * 24 <= var_1d) {
         var_1dc = var_1d - var_12a * 24 >> 1;
      } else {
         if (var4) {
            var_1dc -= var0;
         } else if (var2) {
            var_1dc = -(24 * var0) + (var_1d >> 1) - 12;
         } else if (var_1dc + 24 * var0 > var_1d - 36 && var_1dc > -(var_209 * 24 - var_1d)) {
            var_1dc = -(24 * var0) + 24;
         } else if (var_1dc + 24 * var0 < 12) {
            var_1dc = -(24 * var0 - (var_1d - 48));
         }

         if (var5 != var_1dc) {
            if (var3) {
               var_1dc = -(24 * var0) + (var_1d >> 1) - 12;
            }

            var_1dc = Math.min(Math.max(var_1dc, -(var_209 * 24 - var_1d)), 0);
         }
      }

      if (var_23c * 24 < var_cf) {
         var_1fb = var_cf - var_18b * 24 >> 1;
      } else {
         if (var4) {
            var_1fb -= var1;
         } else if (var2) {
            var_1fb = -(24 * var1) + (var_cf >> 1) - 12;
         } else if (var_1fb + 24 * var1 > var_cf - 36 && var_1fb > -(var_23c * 24 - var_cf)) {
            var_1fb = -(24 * var1) + 24;
         } else if (var_1fb + 24 * var1 < 12) {
            var_1fb = -(24 * var1 - (var_cf - 48));
         }

         if (var6 != var_1fb) {
            if (var3) {
               var_1fb = -(24 * var1) + (var_cf >> 1) - 12;
            }

            var_1fb = Math.min(Math.max(var_1fb, -(var_23c * 24 - var_cf)), 0);
         }
      }

      if (var5 != var_1dc || var6 != var_1fb) {
         sub_3d2();
         sub_702();
      }

   }

   public static void sub_85b() {
      if (var_983 != null) {
         if (var_a5a != 0 || !var_983.var_210) {
            if (Class_178.var_93a != 999999 && var_e52 == 0) {
               Class_205 var1;
               switch(var_f0.sub_97(Class_178.var_93a)) {
               case 0:
                  if (var_a5a == 0 && (Class_178.var_80 == 0 || Class_178.var_80 == 6 || Class_178.var_80 == 3 || Class_178.var_80 == 9) && Class_178.var_165 > 2) {
                     var1 = sub_b2d();
                     if (Class_205.var_4aa > 0) {
                        Class_178.var_165 = 3;
                        var1.sub_174();
                        sub_585(var1, false);
                        sub_702();
                     }

                     return;
                  }
                  break;
               case 1:
                  if (var_a5a == 0 && Class_205.var_4aa < 599 && (Class_178.var_80 == 0 || Class_178.var_80 == 6 || Class_178.var_80 == 3 || Class_178.var_80 == 9) && Class_178.var_165 > 2) {
                     Class_178.var_165 = 3;
                     (var1 = sub_b2d()).var_1a6 = 2;
                     var1.sub_2da((byte)1, false);
                     var1.var_210 = false;
                     sub_702();
                  }
               }

            }
         }
      }
   }

   public static void sub_896() {
      if (Class_178.var_93a != 999999 && var_e52 == 0) {
         if (var_a5a != 0 || var_983 == null || !var_983.var_210) {
            Class_178.var_9af = Class_178.var_93a;
            int var0;
            if ((var0 = var_f0.sub_97(Class_178.var_93a)) == 12) {
               if (var_983 == null) {
                  if (var_99f.size() == 0) {
                     Class_178.var_1217 = 3;
                  } else {
                     Class_178.var_93a = 999999;
                     sub_8c6(var_96a);
                  }
               }
            } else if (var0 == 13) {
               if (var_983 != null) {
                  if (var_a5a == 0) {
                     Class_178.sub_1b8((byte)7, (byte)-1, (byte)0, true);
                     Class_178.var_6bc = false;
                     return;
                  }

                  Class_178.sub_1b8((byte)8, (byte)-1, (byte)0, true);
               }

               return;
            }

            if (Class_178.var_12fc) {
               Class_178.var_12fc = false;
            }

            int var2;
            if (var_983 == null) {
               int var8 = 0;
               var2 = 0;
               switch(var0) {
               case 0:
                  if (var_99f.size() == 0) {
                     Class_178.var_1217 = 3;
                     return;
                  }

                  Class_178.var_93a = 999999;
                  sub_8c6(var_96a);
                  return;
               case 1:
               default:
                  return;
               case 2:
                  var2 = -(var_cf >> 1);
                  break;
               case 3:
                  var2 = var_cf >> 1;
                  break;
               case 4:
                  var8 = -(var_1d >> 1);
                  break;
               case 5:
                  var8 = var_1d >> 1;
               }

               sub_80d(var8, var2, false, false, true);
            } else {
               Class_205 var7;
               switch(var0) {
               case 0:
                  if (var_a5a == 0) {
                     var7 = sub_b2d();
                     if (Class_205.var_4aa > 0) {
                        var7.sub_174();
                        sub_585(var7, false);
                        sub_702();
                        Class_178.var_165 = 1;
                     }

                     return;
                  }

                  return;
               case 1:
                  if (var_a5a == 0 && Class_205.var_4aa < 599) {
                     (var7 = sub_b2d()).var_1a6 = 2;
                     var7.sub_2da((byte)1, false);
                     var7.var_210 = false;
                     Class_178.var_165 = 1;
                     sub_702();
                     return;
                  }

                  return;
               case 2:
               case 3:
               case 4:
               case 5:
               case 8:
               default:
                  return;
               case 6:
                  Class_7c var1;
                  if (var_a5a == 0 && (var1 = sub_912(var_983)) != null) {
                     var2 = 0;

                     for(int var3 = 0; var3 < 12; ++var3) {
                        if (Class_205.var_2a[var1.var_4c][var3] > 0) {
                           ++var2;
                        }
                     }

                     if (var2 > 0) {
                        byte[][] var9 = new byte[var2][2];
                        short[] var4 = new short[var2];
                        Object[][] var5 = new Object[var2][1];
                        var2 = 0;

                        for(int var6 = 0; var6 < 12; ++var6) {
                           if (Class_205.var_2a[var1.var_4c][var6] > 0) {
                              var9[var2][0] = 8;
                              var9[var2][1] = (byte)Class_178.toolStats[var6][2];
                              var5[var2][0] = new Integer(Class_205.var_2a[var1.var_4c][var6]);
                              var4[var2] = (short)(85 + var6);
                              ++var2;
                           }
                        }

                        Class_178.sub_2a5((byte)0, false, (byte[])null, var4, var5, var9, (boolean[])null, (short)98, (byte)1);
                     }
                  }
                  break;
               case 7:
                  sub_80d(var_983.var_bb, var_983.var_123, true, false, false);
                  break;
               case 9:
                  var_96a = var_953;
                  var_953 = -1;
                  break;
               case 10:
                  Class_178.var_93a = 999999;
                  sub_b8e();
                  return;
               case 11:
                  Class_178.var_93a = 999999;
                  sub_8c6(-1);
                  return;
               }

               Class_178.var_93a = 999999;
            }
         }
      }
   }

   private static void sub_8c6(int var0) {
      boolean var1 = var_983 == null;
      if (var0 == -1) {
         ++var_953;
         var_35f = true;
         if (var_953 >= var_99f.size() || var_983 == null) {
            var_953 = 0;
         }
      } else {
         var_953 = (byte)var0;
      }

      var_983 = sub_b2d();
      if (var_a5a == 0) {
         var_983.var_341 = (short)(var_983.var_39c.size() - 1);
         var_983.sub_7b(true);
         Class_205.var_4aa = var_983.var_341;
         sub_585(var_983, false);
      }

      sub_80d(var_983.var_bb, var_983.var_123, false, true, false);
      if (var_a5a == 0 || var1) {
         sub_702();
      }

   }

   public static Class_7c sub_912(Class_205 var0) {
      int var1 = var0.var_bb + var_3e7[0][var0.var_17b];
      int var2 = var0.var_123 + var_3e7[1][var0.var_17b];
      Integer var3 = sub_201(var1, var2);
      if (var_826.containsKey(var3)) {
         Class_7c var4;
         return (var4 = (Class_7c)var_826.get(var3)).var_4c == 6 && var_7f3 > 0 ? null : var4;
      } else {
         return null;
      }
   }

   private static boolean sub_950(Class_7c var0) {
      boolean var1 = false;
      if (var_a5a == 0) {
         if (var0.var_18d > 0 && var0.var_18d <= Class_205.var_4aa) {
            var1 = Class_1b0.sub_678(Class_1cc.var_da[var0.var_4c][5], (byte)4);
         }
      } else if (var0.var_1bc[0] <= 0) {
         var1 = Class_1b0.sub_678(Class_1cc.var_da[var0.var_4c][5], (byte)4);
      }

      return var1;
   }

   public static boolean sub_9a0() {
      var_2c9 = true;
      if (Class_19e.var_838 == null) {
         return false;
      } else {
         Object var0 = Class_19e.var_838;
         switch(Class_19e.var_7ed) {
         case 2:
            switch(((Short)var0).shortValue()) {
            case 117:
               sub_a0e();
               return false;
            case 118:
               Class_205 var10000 = var_983;
               var10000.var_29a -= var_983.sub_46a();
               var_983.var_2d2 = var_983.var_29a;
               var_983.sub_3e7(false);
               var_983.var_29a = var_983.var_2d2;
               return false;
            case 119:
            default:
               return false;
            case 120:
               Class_178.var_1217 = 3;
               return false;
            case 121:
               var_983.sub_19d();
               sub_80d(var_983.var_bb, var_983.var_123, true, false, false);
               return false;
            }
         case 8:
            Class_205 var11 = sub_b2d();
            byte var2 = Byte.parseByte((String)var0);
            if (var11.var_3d8 == null) {
               Class_178.sub_2c8((byte)0, (byte[])null, (short)169, (Object[])null, new short[]{126}, (short)137);
               return true;
            }

            boolean var12 = sub_950(var11.var_3d8);
            if (var2 == 0 && var12) {
               if (Class_205.var_4aa + 8 > 599) {
                  return false;
               }

               var11.var_1a6 = 3;
               var11.sub_2da((byte)8, true);
               break;
            } else {
               for(byte var13 = 0; var13 < 3; ++var13) {
                  if (var11.var_451[var13] != 116) {
                     --var2;
                  }

                  if (var2 < 0) {
                     byte var5 = Class_178.sub_e5c(var11.var_451[var13]);
                     byte var6 = sub_a94(var11, var5);
                     var11.var_47f = var13;
                     switch(var6) {
                     case -2:
                        Class_178.sub_2c8((byte)0, (byte[])null, (short)168, (Object[])null, new short[]{126}, (short)137);
                        return true;
                     case -1:
                        Class_178.sub_2c8((byte)0, (byte[])null, (short)166, (Object[])null, new short[]{126}, (short)137);
                        return true;
                     case 0:
                     case 1:
                     case 2:
                     case 3:
                     default:
                        return false;
                     case 4:
                        if (Class_205.var_4aa + Class_205.var_2a[var11.var_3d8.var_4c][var5] > 599) {
                           return false;
                        }

                        var11.var_1a6 = var6;
                        var11.sub_2da(Class_205.var_2a[var11.var_3d8.var_4c][var5], true);
                        if (var_a5a == 1 && var11.var_3d8.var_1bc[0] == 120) {
                           var11.var_3d8.var_1bc[0] = Class_205.var_2a[var11.var_3d8.var_4c][var5];
                        }

                        return false;
                     case 5:
                        if (Class_205.var_4aa + Class_205.var_2a[var11.var_3d8.var_4c][var5] > 599) {
                           return false;
                        }

                        Class_7c var7;
                        if (var_a5a == 0 && var_84c.containsKey(sub_201(var11.var_bb, var11.var_123)) && (var7 = (Class_7c)var_84c.get(sub_201(var11.var_bb, var11.var_123))) != null) {
                           int var8 = var7.var_18d / 60;
                           int var9 = (var7.var_18d - var8 * 60) / 10;
                           int var10 = var7.var_18d - var8 * 60 - var9 * 10;
                           Class_178.sub_2c8((byte)0, (byte[])null, (short)172, new Object[]{new Integer(var8), new Integer(var9), new Integer(var10)}, new short[]{126}, (short)137);
                           return true;
                        }

                        var11.var_1a6 = var6;
                        var11.sub_2da(Class_205.var_2a[var11.var_3d8.var_4c][var5], true);
                        return false;
                     }
                  }
               }

               return false;
            }
         case 17:
            if (var0.equals(String.valueOf(126))) {
               if (Class_178.var_5bb == -1) {
                  var_c64 = sub_9c4();
               } else {
                  var_c64 = 1;
               }

               for(int var3 = var_99f.size() - 1; var3 >= 0; --var3) {
                  Class_205 var4;
                  (var4 = (Class_205)var_99f.elementAt(var3)).var_210 = false;
                  var4.var_1ec = 0;
                  var4.var_1a6 = 0;
               }

               var_de4 = 1;
               var_e2f = 0;
               var_e52 = 1;
            }
            break;
         case 32:
            Class_1b0.sub_759();
            Class_178.var_ab2 = 0;
            Class_178.sub_7c1();
            return true;
         case 35:
            Class_1b0.sub_71d();
            Class_178.sub_c15();
            Class_178.var_1217 = 3;
            return true;
         case 36:
         case 39:
            if (Class_178.var_10ff > 0) {
               Object[] var1;
               if (Class_178.var_5bb > 0) {
                  --Class_178.var_10ff;
                  var1 = new Object[]{new Integer(Class_178.var_10ff)};
               } else {
                  var1 = new Object[]{new Short((short)257)};
               }

               Class_178.sub_2c8((byte)35, (byte[])null, (short)158, var1, new short[]{126}, (short)191);
               return true;
            }

            Class_178.sub_2c8((byte)32, new byte[]{5, 6}, (short)162, (Object[])null, new short[]{126}, (short)163);
            return true;
         }

         return false;
      }
   }

   private static byte sub_9c4() {
      byte var0 = 5;
      switch(Class_178.var_dc6) {
      case 1:
         if (((Class_7c)var_826.get(sub_201(4, 4))).var_1bc[0] <= 0) {
            var0 = 4;
         }
         break;
      case 2:
         if (((Class_7c)var_826.get(sub_201(3, 5))).var_1bc[1] <= 0) {
            var0 = 4;
         }
         break;
      case 3:
         if (((Class_7c)var_826.get(sub_201(3, 11))).var_1bc[1] <= 0) {
            var0 = 4;
         }
         break;
      case 4:
         if (((Class_7c)var_826.get(sub_201(5, 6))).var_1bc[1] <= 0) {
            var0 = 4;
         }
         break;
      case 5:
         Class_7c var1 = (Class_7c)var_84c.get(sub_201(4, 5));
         Class_7c var2 = (Class_7c)var_84c.get(sub_201(8, 5));
         if (var1 != null && var2 != null && var1.var_1f5 == 113 && var2.var_1f5 == 114 && var1.var_1bc[1] <= 0 && var2.var_1bc[1] <= 0 && ((Class_7c)var_826.get(sub_201(9, 5))).var_1bc[1] <= 0) {
            var0 = 4;
         }
         break;
      case 6:
         if (((Class_7c)var_826.get(sub_201(3, 6))).var_1bc[1] <= 0) {
            var0 = 4;
         }
      }

      return var0;
   }

   private static void sub_a0e() {
      sub_7b0();
      var_e52 = 2;
      if (Class_178.var_5bb == -1) {
         var_c64 = sub_9c4();
      } else {
         var_c64 = 3;
      }

      int var0 = var_c7c - Class_205.var_4aa;

      for(int var1 = var_99f.size() - 1; var1 >= 0; --var1) {
         Class_205 var2 = (Class_205)var_99f.elementAt(var1);
         if ((2 * (Math.abs(var2.var_bb - var_bc1) + Math.abs(var2.var_123 - var_bf6)) > var0 || var2.var_24a > 0) && Class_178.var_5bb != -1) {
            short var4 = (short)(Math.max(var_6c9[var2.var_3a][2] * 1000, var2.var_3fa[1] * var_71c[1][0] + var2.var_3fa[2] * var_71c[2][0] + var2.var_3fa[3] * var_71c[3][0] + var2.var_3fa[4] * var_71c[4][0] + var2.var_3fa[5] * var_71c[5][0]) / 1000);
            var2.sub_41a();
            var2.var_3fa[0] = var4;
            var2.sub_44c();
            Class_178.var_d50.addElement(var2);
            var_99f.removeElement(var2);
            if (var2.var_3a == 0) {
               var_c64 = 2;
            }
         } else if (var2.var_bb == var_bc1 && var2.var_123 == var_bf6) {
            if (var2.var_1a6 == 1) {
               var2.var_1a6 = 0;
               var2.var_1ec = 0;
               var2.var_210 = false;
            }
         } else {
            var_390 += (var2.var_3fa[1] * var_71c[1][0] + var2.var_3fa[2] * var_71c[2][0] + var2.var_3fa[3] * var_71c[3][0] + var2.var_3fa[4] * var_71c[4][0] + var2.var_3fa[5] * var_71c[5][0]) * 50 / 100;
            var2.var_1ec = 0;
            var2.var_210 = false;
            var2.var_bb = (byte)(var_bc1 + var_5cd[0][var2.var_3a]);
            var2.var_123 = (byte)(var_bf6 + var_5cd[1][var2.var_3a]);
         }
      }

      if (var_99f.isEmpty()) {
         var_e2f = 0;
         var_e52 = 4;
         var_de4 = 4;
      }

      sub_3d2();
      sub_65f();
   }

   public static void sub_a53(Class_205 var0) {
      var0.var_3d8 = sub_912(var0);
      if (var0.var_3d8 != null) {
         if (!Class_1b0.sub_678(Class_1cc.var_da[var0.var_3d8.var_4c][5], (byte)5)) {
            if (var_753[var0.var_3d8.var_71][var0.var_3d8.var_119] > 12 || sub_ae6(var0.var_3d8, var0.var_bb, var0.var_123)) {
               if (var_a5a == 0) {
                  if (var0.var_3d8.var_1a5 > 0 && var0.var_3d8.var_1a5 <= Class_205.var_4aa) {
                     return;
                  }
               } else if (var0.var_3d8.var_1bc[1] <= 0) {
                  return;
               }

               Class_7c var1;
               if ((var1 = (Class_7c)var_84c.get(sub_201(var0.var_bb, var0.var_123))) != null && var_a5a == 1 && var1.var_1bc[1] >= 0) {
                  Class_178.sub_2c8((byte)0, (byte[])null, (short)171, (Object[])null, new short[]{126}, (short)137);
               } else {
                  int var2 = 0;
                  int var3;
                  boolean var4;
                  if (var4 = sub_950(var0.var_3d8)) {
                     var3 = 1;
                  } else {
                     var3 = 3;

                     for(int var5 = 0; var5 < 3; ++var5) {
                        if (var0.var_451[var5] == 116) {
                           --var3;
                        }
                     }
                  }

                  if (var3 == 0) {
                     Class_178.sub_2c8((byte)0, (byte[])null, (short)170, (Object[])null, new short[]{126}, (short)137);
                  } else {
                     byte[][] var8 = new byte[var3][2];
                     short[] var6 = new short[var3];
                     if (var4) {
                        var8[0][0] = 49;
                        var8[0][1] = 0;
                        var6[0] = 119;
                     } else {
                        for(int var7 = 0; var7 < 3; ++var7) {
                           if (var0.var_451[var7] != 116) {
                              var8[var2][0] = 8;
                              var8[var2][1] = Class_178.sub_e5c(var0.var_451[var7]);
                              var6[var2] = (short)var0.var_451[var7];
                              ++var2;
                           }
                        }
                     }

                     Class_178.sub_2a5((byte)8, false, (byte[])null, var6, (Object[][])null, var8, (boolean[])null, (short)139, (byte)2);
                  }
               }
            }
         }
      }
   }

   private static byte sub_a94(Class_205 var0, byte var1) {
      byte var2 = -1;
      if (Class_205.var_2a[var0.var_3d8.var_4c][var1] > 0) {
         if (sub_bc9(var1) != 113 && sub_bc9(var1) != 114) {
            var2 = 4;
         } else {
            var2 = 5;
         }
      }

      if (var2 != -1 && !sub_ae6(var0.var_3d8, var0.var_bb, var0.var_123)) {
         var2 = -2;
      }

      return var2;
   }

   private static boolean sub_ae6(Class_7c var0, int var1, int var2) {
      boolean var3 = false;

      int var5;
      for(var5 = 0; var5 < 4; ++var5) {
         int var4;
         if ((var4 = var0.var_163 + var5) > 3) {
            var4 -= 4;
         }

         if (var1 == var0.var_71 + var_3e7[0][var4] && var2 == var0.var_119 + var_3e7[1][var4]) {
            break;
         }
      }

      if (Class_1b0.sub_678(Class_1cc.var_da[var0.var_4c][5], (byte)var5)) {
         var3 = true;
      }

      return var3;
   }

   private static Class_205 sub_b2d() {
      return (Class_205)var_99f.elementAt(var_953);
   }

   private static void sub_b8e() {
      short[] var0;
      if (var_a5a == 0) {
         (var0 = new short[2])[0] = 120;
         var0[1] = 121;
      } else {
         if (var_983.var_24a > 0) {
            return;
         }

         if (var_983.var_3a == 0 && var_983.sub_46a() > 0 && !var_983.var_210) {
            (var0 = new short[2])[0] = 117;
            var0[1] = 118;
         } else {
            (var0 = new short[1])[0] = 117;
         }
      }

      Class_178.sub_22b((byte)2, new byte[]{5, sub_b2d().var_3a}, var0, Class_1b0.sub_42b((short)138), (byte)2);
   }

   public static short sub_bc9(byte var0) {
      return (short)(var0 + 104);
   }

   static {
      var_d80 = -Class_1cc.var_b6[14][2];
      var_e52 = 0;
   }
}
