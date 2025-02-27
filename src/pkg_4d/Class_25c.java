package pkg_4d;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import pkg_65.GlomoFileClass;

public final class Class_25c extends Alert implements CommandListener {
   private String var_1b = "";
   private static Class_25c var_a6 = null;

   public static Class_25c sub_4c(GlomoFileClass var0) {
      if (var_a6 == null || var_a6.var_1b.compareTo(Class_1f8.var_116d) != 0) {
         var_a6 = new Class_25c(var0);
      }

      var_a6.var_1b = Class_1f8.var_116d;
      return var_a6;
   }

   public Class_25c(GlomoFileClass var1) {
      super(Class_1f8.var_ce);
      this.setString(var1.sub_14c());
      this.setTimeout(-2);
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
