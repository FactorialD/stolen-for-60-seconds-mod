package pkg_4d;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Image;

public final class Class_492 extends Alert implements CommandListener {
   private String var_5f = "";
   private static Class_492 var_7e = null;

   public static Class_492 sub_47() {
      if (var_7e == null || var_7e.var_5f.compareTo(Class_1f8.var_116d) != 0) {
         var_7e = new Class_492();
      }

      var_7e.var_5f = Class_1f8.var_116d;
      return var_7e;
   }

   public Class_492() {
      super(Class_1f8.var_ce, Class_1f8.var_e91, (Image)null, (AlertType)null);
      this.setTimeout(2000);
      this.addCommand(new Command(Class_1f8.var_670, 4, 1));
      this.setCommandListener(this);
   }

   public final void commandAction(Command var1, Displayable var2) {
      Class_4d4.sub_1cc(4);
   }
}
