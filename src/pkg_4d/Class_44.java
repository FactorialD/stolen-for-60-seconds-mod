package pkg_4d;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Image;

public final class Class_44 extends Alert implements CommandListener {
   private String var_41 = "";
   private static Class_44 var_61 = null;

   public static Class_44 sub_35() {
      if (var_61 == null || var_61.var_41.compareTo(Class_1f8.var_116d) != 0) {
         var_61 = new Class_44();
      }

      var_61.var_41 = Class_1f8.var_116d;
      return var_61;
   }

   public Class_44() {
      super(Class_1f8.var_ce, Class_1f8.var_e50, (Image)null, (AlertType)null);
      this.setTimeout(2000);
      this.addCommand(new Command(Class_1f8.var_670, 4, 1));
      this.setCommandListener(this);
   }

   public final void commandAction(Command var1, Displayable var2) {
      Class_4d4.sub_1cc(4);
   }
}
