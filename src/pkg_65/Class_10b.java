package pkg_65;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.microedition.midlet.MIDlet;

public class Class_10b {
   private static Random random = new Random();
   private static String var_7a = "0123456789ABCDEF";
   private static String var_c1 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

   public static final String[] sub_30(String var0, String var1) {
      int var2 = 1;
      int var4 = 0;

      int var3;
      for(var3 = 0; (var3 = var1.indexOf(var0, var3) + 1) > 0; ++var2) {
      }

      String[] var5 = new String[var2];
      var2 = 0;

      for(var3 = 0; (var3 = var1.indexOf(var0, var3) + 1) > 0; var4 = var3 - 1 + var0.length()) {
         var5[var2] = var1.substring(var4, var3 - 1);
         ++var2;
      }

      var5[var2] = var1.substring(var4);
      return var5;
   }

   public static final String sub_66(String var0, String[] var1) {
      return sub_a3(var0, var1, '%');
   }

   public static final String sub_a3(String var0, String[] var1, char var2) {
      StringBuffer var3 = new StringBuffer("");
      int var4 = 0;

      for(int var5 = 0; var5 < var0.length(); ++var5) {
         char var6;
         if ((var6 = var0.charAt(var5)) == var2) {
            if (var5 + 1 < var0.length() && var0.charAt(var5 + 1) == var2) {
               var3.append(var6);
               ++var5;
            } else {
               var3.append(var1[var4++]);
            }
         } else {
            var3.append(var6);
         }
      }

      return var3.toString();
   }

   public static final String[] sub_ee(String[] var0, String[][] var1) {
      String[] var2 = new String[var0.length];

      for(int var3 = 0; var3 < var0.length; ++var3) {
         var2[var3] = sub_66(var0[var3], var1[var3]);
      }

      return var2;
   }

   public static final int sub_12b(String var0) {
      return sub_1dd(var0, 0, 0);
   }

   public static final int sub_17d(String var0, int var1) {
      return sub_1dd(var0, var1, 0);
   }

   public static final int sub_1dd(String var0, int var1, int var2) {
      int var3 = 0;
      if (var2 == 0) {
         while(var1 < var0.length()) {
            var3 = ((var3 << 1 | (var3 & 128) >> 7) & 255 ^ var0.charAt(var1) & 255) & 255;
            ++var1;
         }
      }

      return var3;
   }

   public static final String sub_1eb(String var0, String var1) {
      int var2;
      return (var2 = var1.indexOf(var0)) >= 0 ? var1.substring(0, var2 - 1) : var1;
   }

   public static String[] sub_241(MIDlet var0, String var1) {
      return sub_27c(var0, var1, true);
   }

   public static String[] sub_27c(MIDlet var0, String var1, boolean var2) {
      return sub_30("\n", sub_2e0(var0, var1, var2));
   }

   public static String sub_2bd(MIDlet var0, String var1) {
      return sub_2e0(var0, var1, true);
   }

   public static String sub_2e0(MIDlet var0, String var1, boolean var2) {
      try {
         InputStream var7;
         char[] var10 = new char[(var7 = var0.getClass().getResourceAsStream(var1)).available() / 2 - 1];
         ByteArrayOutputStream var3 = new ByteArrayOutputStream();

         int var4;
         while((var4 = var7.read()) != -1) {
            var3.write(var4);
         }

         ByteArrayInputStream var8 = new ByteArrayInputStream(var3.toByteArray());
         DataInputStream var11;
         (var11 = new DataInputStream(var8)).readChar();

         for(int var5 = 0; var5 < var10.length; ++var5) {
            var10[var5] = var11.readChar();
         }

         var11.close();
         var8.close();
         var3.close();
         String var9;
         sub_604(var9 = new String(var10), 0);
         return var2 ? sub_604(var9, 0) : var9;
      } catch (Exception var6) {
         var6.printStackTrace();
         return null;
      }
   }

   public static final int sub_319(int var0, int var1) {
      return Math.abs(random.nextInt()) % (var1 - var0) + var0;
   }

   public static final long sub_360(int var0) {
      if (var0 != 0) {
         return 0L;
      } else {
         Integer.parseInt(Class_189.var_95.sub_477());
         var0 = 1;
         int var1 = 9;

         for(int var2 = 0; var2 < 5; ++var2) {
            var0 *= 10;
            var1 = var1 * 10 + 9;
         }

         return (long)sub_319(var0, var1);
      }
   }

   public static final String sub_3c0(int var0, String var1, long var2) {
      boolean var4 = false;
      String var9;
      if (Class_189.sub_84() > 1) {
         Integer.parseInt(Class_189.var_95.sub_477());
         String var5;
         String var6 = (var5 = Class_189.var_95.sub_93()).substring(0, 2);
         var5 = var5.substring(2, 5);
         var9 = sub_4c4(sub_586((var2 != 0L ? var2 : sub_360(0)) * 10000L + Long.parseLong(var5) * 10L + (long)(var0 % 10), 7), 2);

         try {
            var4 = Long.parseLong(var9) == 0L;
         } catch (Exception var7) {
         }

         return var4 ? "" : var1 + var6 + var9 + Class_189.sub_105().substring(0, 1);
      } else {
         var9 = sub_4c4(sub_586((var2 != 0L ? var2 : sub_360(0)) * 10000L + Long.parseLong(Class_189.var_95.sub_3c()) * 10L + (long)(var0 % 10), 7), 2);

         try {
            var4 = Long.parseLong(var9) == 0L;
         } catch (Exception var8) {
         }

         return var4 ? "" : var1 + var9 + Class_189.sub_105().substring(0, 1);
      }
   }

   public static byte[] sub_410(byte[] var0, int var1) {
      byte[] var2 = new byte[var0.length];
      if (var1 == 0) {
         for(var1 = 0; var1 < var0.length; ++var1) {
            var2[(var1 + 5) % var0.length] = (byte)(37 ^ var0[var1]);
         }

         for(var1 = 0; var1 < var0.length; ++var1) {
            var2[var1] ^= var2[(var1 + 2) % var0.length];
         }
      }

      return var2;
   }

   public static byte[] sub_44b(byte[] var0, int var1) {
      byte[] var2 = new byte[var0.length];
      if (var1 == 0) {
         for(var1 = var0.length - 1; var1 >= 0; --var1) {
            var0[var1] ^= var0[(var1 + 2) % var0.length];
         }

         for(var1 = 0; var1 < var0.length; ++var1) {
            var2[var1] = (byte)(37 ^ var0[(var1 + 5) % var0.length]);
         }
      }

      return var2;
   }

   public static byte[] sub_489(String var0) {
      if (var0.length() % 2 == 1) {
         var0 = var0 + "0";
      }

      byte[] var1 = new byte[var0.length() / 2];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = (byte)(Byte.parseByte(var0.substring(var2 << 1, (var2 << 1) + 1)) + (byte)(Byte.parseByte(var0.substring((var2 << 1) + 1, (var2 << 1) + 2)) << 4));
      }

      return var1;
   }

   public static String sub_499(byte[] var0) {
      StringBuffer var1 = new StringBuffer("");

      for(int var2 = 0; var2 < var0.length; ++var2) {
         var1.append(String.valueOf(var_7a.charAt(var0[var2] & 15)));
         var1.append(String.valueOf(var_7a.charAt(var0[var2] >> 4 & 15)));
      }

      return var1.toString();
   }

   public static String sub_4c4(String var0, int var1) {
      if (var0.length() == 0) {
         return var0;
      } else if (var1 == 0) {
         return new String(sub_410(var0.getBytes(), var1));
      } else if (var1 == 1) {
         return sub_499(sub_410(sub_489(var0), 0));
      } else if (var1 == 2 && var0.length() > 2) {
         StringBuffer var3 = new StringBuffer(var0.substring(0, 2));

         for(int var2 = 0; var2 < var0.length() - 2; ++var2) {
            var3.append(var0.charAt(2 + (var2 + var_c1.indexOf(var0.charAt(1))) % (var0.length() - 2)));
         }

         return var3.toString();
      } else {
         return var0;
      }
   }

   public static String sub_528(String var0, int var1) {
      if (var1 == 0) {
         return new String(sub_44b(var0.getBytes(), var1));
      } else if (var1 == 1) {
         return sub_499(sub_44b(sub_489(var0), 0));
      } else if (var1 == 2 && var0.length() > 2) {
         StringBuffer var4 = new StringBuffer(var0.substring(0, 2));
         int var2 = var0.length() - 2;

         for(int var3 = 0; var3 < var2; ++var3) {
            var4.append(var0.charAt(2 + (var3 + var2 - var_c1.indexOf(var0.charAt(1)) % var2) % var2));
         }

         return var4.toString();
      } else {
         return var0;
      }
   }

   public static String sub_586(long var0, int var2) {
      StringBuffer var3;
      for(var3 = new StringBuffer(""); var0 > 0L; var0 /= 36L) {
         var3.append(var_c1.charAt((int)(var0 % 36L)));
      }

      while(var3.length() < var2) {
         var3.append("0");
      }

      return var3.toString();
   }

   public static long sub_5df(String var0) {
      long var1 = 0L;
      long var3 = 1L;

      for(int var5 = 0; var5 < var0.length(); var3 *= 36L) {
         var1 += var3 * (long)var_c1.indexOf(var0.charAt(var5));
         ++var5;
      }

      return var1;
   }

   public static String sub_604(String var0, int var1) {
      char[] var13;
      char[] var14 = new char[(var13 = var0.toCharArray()).length];
      int var3 = var13.length + 1;

      int var5;
      for(var5 = 1; var5 < var3; ++var5) {
         var14[var5 - 1] = var13[var5 - 1];
      }

      int var4;
      for(var4 = 1; var4 < var3; var4 = var4 << 1 | 1) {
      }

      var4 >>= 1;

      for(int var11 = var3 - var4; var11 > 0; var11 -= var13.length - var4 + (var13.length - var4 > 0 ? 0 : 1)) {
         int var10 = 0;

         for(int var9 = 4; var9 <= var4 + 1 << 1; var9 += 2) {
            var5 = 0;
            int var12 = 0;
            int var8 = 0;
            int var6 = 1;

            for(int var7 = var4 + 1 >> 1; var5 <= var10; var7 >>= 1) {
               int var2;
               var12 = var5 >= var10 && (var9 >> 1) - 2 + (var10 << 1) - var12 - (var4 >> 1) <= 0 ? (var14[var11 + (var9 >> 1) - 3] = (char)(var14[var11 + (var9 >> 1) - 3] + (var14[var11 - 1 - (var10 << 1) + var12 + (var4 >> 1)] - (var14[var11 - 1 - (var10 << 1) + var12 + (var4 >> 1)] = var14[var11 + (var9 >> 1) - 3])))) + ((var9 >> 1) + (var10 << 1) - (var4 >> 1) - var12 - 2 == 0 ? 0 : (var14[var11 + (var9 >> 1) - 3] = (char)(((var2 = var14[var11 + (var9 >> 1) - 3] + 142) % 10 + 10 + (var11 - 3) % 10) % 10 + var2 / 10 * 10 - 142))) + (var14[var11 - 1 - (var10 << 1) + var12 + (var4 >> 1)] = (char)(((var2 = var14[var11 - 1 - (var10 << 1) + var12 + (var4 >> 1)] + 142) % 10 + 10 + (var11 - 3) % 10) % 10 + var2 / 10 * 10 - 142)) : (var8 += (((var9 >> 1) - 2 & var6) == 0 ? 1 : -1) * (var7 >> 1) + 2);
               ++var5;
               var6 <<= 1;
            }

            var10 += var9 >> 1 == 2 << var10 ? 1 : 0;
         }
      }

      for(var5 = 1; var5 < var3; ++var5) {
         var13[var5 - 1] = var14[var5 - 1];
      }

      return new String(var13);
   }

   public static String sub_62f(Date var0) {
      Calendar var1;
      (var1 = Calendar.getInstance()).setTime(var0);
      int var7 = var1.get(1);
      int var2 = var1.get(2) + 1;
      int var3 = var1.get(5);
      int var4 = var1.get(11);
      int var5 = var1.get(12);
      int var6 = var1.get(13);
      int var8 = var1.get(14);
      return var7 + "-" + (var2 <= 10 ? "0" : "") + var2 + "-" + (var3 <= 10 ? "0" : "") + var3 + " " + (var4 <= 10 ? "0" : "") + var4 + ":" + (var5 <= 10 ? "0" : "") + var5 + ":" + (var6 <= 10 ? "0" : "") + var6 + "." + var8;
   }

   public static final String sub_64b(MIDlet var0, String var1) {
      try {
         String var3;
         String var10000 = var3 = var0.getAppProperty(var1) == null ? "" : var0.getAppProperty(var1);
         if (var10000.charAt(var10000.length() - 1) == ';') {
            var3 = var3.substring(0, var3.length() - 1);
         }

         return var3;
      } catch (Exception var2) {
         return "";
      }
   }
}
