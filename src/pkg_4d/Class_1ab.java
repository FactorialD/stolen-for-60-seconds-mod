package pkg_4d;

import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import pkg_65.GlomoFileClass;

public class Class_1ab extends Form {
   private Gauge var_59 = null;
   private String var_97 = "";
   private static Class_1ab var_cb = null;

   public static Class_1ab sub_13(GlomoFileClass var0) {
      if (var_cb == null || var_cb.var_97.compareTo(Class_1f8.var_116d) != 0) {
         var_cb = new Class_1ab(var0);
      }

      var_cb.var_97 = Class_1f8.var_116d;
      return var_cb;
   }

   public Class_1ab(GlomoFileClass var1) {
      super(Class_1f8.var_ce);
      this.var_59 = new Gauge(Class_1f8.var_111b, false, -1, 2);
      this.append(this.var_59);
   }
}
