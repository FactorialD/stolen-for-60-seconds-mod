package pkg_4d;

import javax.microedition.lcdui.Form;

public final class Class_f3 extends Form {
   private String var_f = "";
   private static Class_f3 var_60 = null;

   public static Class_f3 sub_3b() {
      if (var_60 == null || var_60.var_f.compareTo(Class_1f8.var_116d) != 0) {
         var_60 = new Class_f3();
      }

      var_60.var_f = Class_1f8.var_116d;
      return var_60;
   }

   public Class_f3() {
      super("����� �ڧԧ��");
   }
}
