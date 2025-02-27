package pkg_4d;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;

public class Class_a1 extends Alert implements CommandListener {
   private boolean var_43;
   private String var_6c = "";
   private static Class_a1 var_b1 = null;

   public static Class_a1 sub_37(boolean var0) {
      if (var_b1 == null || var_b1.var_43 != var0 || var_b1.var_6c.compareTo(Class_1f8.var_116d) != 0) {
         var_b1 = new Class_a1(var0);
      }

      var_b1.var_6c = Class_1f8.var_116d;
      return var_b1;
   }

   public Class_a1(boolean var1) {
      super(Class_1f8.var_796);
      this.var_43 = var1;
      this.setString(var1 ? Class_1f8.var_e9c : Class_1f8.var_ee0);
      this.setTimeout(3000);
      this.addCommand(new Command(Class_1f8.var_670, 4, 1));
      this.setCommandListener(this);
   }

   public void commandAction(Command var1, Displayable var2) {
      int var3;
      if ((var3 = var1.getCommandType()) == 4 || var3 == 1) {
         Class_4d4.sub_1cc(4);
      }

   }
}
