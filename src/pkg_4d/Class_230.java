package pkg_4d;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;

public final class Class_230 extends Alert implements CommandListener {
   private String var_2c = "";
   private static Class_230 var_6d = null;

   public static Class_230 sub_58() {
      if (var_6d == null || var_6d.var_2c.compareTo(Class_1f8.var_116d) != 0) {
         var_6d = new Class_230();
      }

      var_6d.var_2c = Class_1f8.var_116d;
      return var_6d;
   }

   public Class_230() {
      super(Class_1f8.var_258);
      this.setString(Class_1f8.var_f2e);
      this.setTimeout(3000);
      this.addCommand(new Command(Class_1f8.var_670, 4, 1));
      this.setCommandListener(this);
   }

   public final void commandAction(Command var1, Displayable var2) {
      int var3;
      if ((var3 = var1.getCommandType()) == 4 || var3 == 1) {
         Class_4d4.sub_1cc(1);
      }

   }
}
