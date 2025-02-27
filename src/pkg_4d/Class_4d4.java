package pkg_4d;

import java.util.Hashtable;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import pkg_65.GlomoFileClass;

public final class Class_4d4 {
   private static Displayable var_66 = null;
   private static MIDlet var_b5 = null;
   private static GlomoFileClass var_13d = null;
   private static Displayable var_173 = null;
   private static Hashtable var_1cc = null;
   private static boolean var_25a = false;

   public static void sub_28(Displayable var0, MIDlet var1, GlomoFileClass var2) {
      var_66 = var0;
      var_b5 = var1;
      var_13d = var2;
      var_1cc = new Hashtable();
   }

   public static boolean sub_c8() {
      return var_25a;
   }

   public static boolean sub_12c(boolean var0) {
      var_25a = var0;
      return sub_c8();
   }

   public static Object sub_18f(int var0, Object var1) {
      Integer var3 = new Integer(var0);
      if (!var_1cc.containsKey(var3)) {
         var_1cc.put(var3, var1);
      }

      return var1;
   }

   public static void sub_1cc(int var0) {
      Object var1 = null;
      sub_2d9(var0, -1, (CommandListener)var1);
   }

   public static void sub_216(int var0, int var1) {
      sub_2d9(var0, var1, (CommandListener)null);
   }

   public static void sub_244(int var0, int var1, boolean var2, boolean var3) {
      sub_343(var0, var1, var2, var3, 0, (CommandListener)null);
   }

   public static void sub_270(int var0, int var1, boolean var2, boolean var3, int var4) {
      sub_343(var0, var1, var2, var3, var4, (CommandListener)null);
   }

   public static void sub_2c9(int var0, CommandListener var1) {
      sub_2d9(var0, -1, var1);
   }

   public static void sub_2d9(int var0, int var1, CommandListener var2) {
      sub_30a(var0, var1, true, false, var2);
   }

   public static void sub_30a(int var0, int var1, boolean var2, boolean var3, CommandListener var4) {
      sub_343(var0, var1, var2, var3, 0, var4);
   }

   public static void sub_343(int var0, int var1, boolean var2, boolean var3, int var4, CommandListener var5) {
      if (var0 == 100) {
         sub_4c7();
      } else {
         var_173 = null;
         Object var8 = null;
         int var6 = 0;
         Integer var7 = new Integer(var0);
         var_1cc.containsKey(var7);
         Object var9 = null;
         switch(var0) {
         case 1:
            var9 = var_66;
            break;
         case 2:
            var9 = Class_32b.sub_1a();
            break;
         case 3:
            var9 = Class_69.sub_1b(var_13d, var2);
            break;
         case 4:
            var9 = Class_40e.sub_58(var_13d);
            break;
         case 5:
            var9 = var8 = Class_44.sub_35();
            var6 = var0;
            var_173 = (Displayable)sub_18f(4, Class_40e.sub_58(var_13d));
            break;
         case 6:
            var9 = var8 = Class_492.sub_47();
            var6 = var0;
            var_173 = (Displayable)sub_18f(4, Class_40e.sub_58(var_13d));
            break;
         case 7:
         default:
            var_173 = null;
            break;
         case 8:
            var9 = Class_36d.sub_35(var_13d);
            break;
         case 9:
            var9 = Class_230.sub_58();
            break;
         case 10:
            var9 = Class_246.sub_26();
            break;
         case 11:
            var9 = Class_315.sub_54();
            break;
         case 12:
            var9 = Class_134.sub_54(var_13d);
            break;
         case 13:
            var9 = Class_3bc.sub_3e(var_13d);
            break;
         case 14:
            var9 = Class_45e.sub_2b(var_13d);
            break;
         case 15:
            var9 = Class_a1.sub_37(true);
            break;
         case 16:
            var9 = Class_a1.sub_37(false);
            break;
         case 17:
            var9 = Class_2ec.sub_51(var4, var2, var1);
            break;
         case 18:
            var9 = Class_381.sub_a(var_13d);
            break;
         case 19:
            var9 = Class_1ab.sub_13(var_13d);
         }

         if (var9 != null) {
            sub_18f(var0, var9);
            if (var5 != null) {
               ((Displayable)var9).setCommandListener(var5);
            }
         }

         if (var8 != null) {
            sub_18f(var6, var8);
         }

         if (var_173 == null) {
            var_173 = (Displayable)var9;
         }

         sub_408((Alert)var8, var_173);
      }
   }

   public static void sub_3a4(Displayable var0) {
      sub_408((Alert)null, var0);
   }

   public static void sub_408(Alert var0, Displayable var1) {
      if (var0 != null) {
         Display.getDisplay(var_b5).setCurrent(var0, var1);
      } else {
         Display.getDisplay(var_b5).setCurrent(var1);
      }
   }

   public static void sub_423(String var0) {
      if (var0 != null) {
         try {
            var_b5.platformRequest(var0);
            return;
         } catch (ConnectionNotFoundException var1) {
            var1.printStackTrace();
         }
      }

   }

   public static void sub_4c7() {
      Object var0 = null;
      sub_408((Alert)null, (Displayable)var0);
      var_b5.notifyDestroyed();
   }

   public static MIDlet sub_4e1() {
      return var_b5;
   }
}
