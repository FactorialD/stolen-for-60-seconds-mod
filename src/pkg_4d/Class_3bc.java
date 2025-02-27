package pkg_4d;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import pkg_65.Class_10b;
import pkg_65.GlomoFileClass;

public class Class_3bc extends Alert implements CommandListener {
   private String var_58 = "";
   private static Class_3bc var_67 = null;

   public static Class_3bc sub_3e(GlomoFileClass var0) {
      if (var_67 == null || var_67.var_58.compareTo(Class_1f8.var_116d) != 0) {
         var_67 = new Class_3bc(var0);
      }

      var_67.var_58 = Class_1f8.var_116d;
      return var_67;
   }

   public Class_3bc(GlomoFileClass var1) {
      super(Class_1f8.var_796);
      this.setString(Class_10b.sub_66(Class_1f8.var_fc4, new String[]{Class_1f8.var_670}));
      this.setTimeout(-2);
      this.addCommand(new Command(Class_1f8.var_670, 4, 1));
      this.setCommandListener(this);
   }

   public void commandAction(Command var1, Displayable var2) {
      int var3;
      if ((var3 = var1.getCommandType()) == 4 || var3 == 1) {
         Class_4d4.sub_1cc(14);
      }

   }
}
