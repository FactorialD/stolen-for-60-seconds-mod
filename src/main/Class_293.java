package main;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import pkg_4d.Class_96;
import pkg_65.GlomoFileClass;

public class Class_293 {
   private static GlomoFileClass glomoClass = null;
   private static String var_aa = "Stolen in 60 sec, /icons/icon.png, MM";

   public static void sub_4d(MIDlet var0) {
//    boolean var2 = false;
//    String[] var3 = new String[]{var_aa};
//      if (Class_131.sub_60(var0, var3).compareTo("") == 0) {
//         var_55 = new Class_131(var0);
//         var2 = true;
//      }

//      if (!var2) {
//         try {
//            Display.getDisplay(var0).setCurrent((Displayable)null);
//            var0.notifyDestroyed();
//         } catch (Exception var4) {
//            var4.printStackTrace();
//         }
//      } else {
//         Class_96 var5 = new Class_96(var0, var_55);
//         if (var_55.sub_b23() < 3 || !var_55.sub_40b()) {
//            var5.start();
//         }
//
//      }
      glomoClass = new GlomoFileClass(var0);
      
      Class_96 var5 = new Class_96(var0, glomoClass);
      if (glomoClass.sub_b23() < 3 || !glomoClass.sub_40b()) {
         var5.start();
      }
      
   }
}
