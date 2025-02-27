package pkg_4d;

import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Image;
import pkg_65.Class_10b;
import pkg_65.GlomoFileClass;

public class Class_381 extends Class_c8 {
   private String var_9a = "";
   private static Class_381 var_ee = null;

   public static Class_381 sub_a(GlomoFileClass var0) {
      if (var_ee == null || var_ee.var_9a.compareTo(Class_1f8.var_116d) != 0) {
         var_ee = new Class_381(var0);
      }

      var_ee.var_9a = Class_1f8.var_116d;
      return var_ee;
   }

   public Class_381(GlomoFileClass var1) {
      super(Class_1f8.var_887, Class_10b.sub_66(Class_1f8.var_10cb, new String[]{var1.sub_f0().sub_af(), Class_1f8.var_77f, Class_1f8.var_670, Class_1f8.var_715, Class_1f8.var_768, var1.sub_14c(), var1.sub_f0().sub_241(), var1.sub_f0().sub_323()}), (Image)null, (AlertType)null, 4, new Command[]{new Command(Class_1f8.var_670, 4, 1)});
   }
}
