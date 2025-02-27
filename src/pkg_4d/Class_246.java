package pkg_4d;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;

public final class Class_246 extends Alert implements CommandListener {
   private String var_2e = "";
   private static Class_246 var_38 = null;

   public static Class_246 sub_26() {
      if (var_38 == null || var_38.var_2e.compareTo(Class_1f8.var_116d) != 0) {
         var_38 = new Class_246();
      }

      var_38.var_2e = Class_1f8.var_116d;
      return var_38;
   }

   public Class_246() {
      super(Class_1f8.var_258);
      this.setString(Class_1f8.var_f7a);
      this.setTimeout(3000);
      this.addCommand(new Command(Class_1f8.var_670, 4, 1));
      this.setCommandListener(this);
   }

   public final void commandAction(Command var1, Displayable var2) {
      int var3;
      if ((var3 = var1.getCommandType()) == 4 || var3 == 1) {
         Class_4d4.sub_1cc(4);
      }

   }
}
