package main;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;

public abstract class Class_26a extends Canvas implements SomeLevelDataVariablesInterface {
   public static int musicManagerPriorityLevel;
   public static int var_140 = 21;
   public static int var_1d5 = 22;
   public static int var_223 = -20;
   public static int var_27f = -21;
   public static boolean var_2bb = false;

   public Class_26a() {
      this.setFullScreenMode(true);
   }

   public void paint(Graphics g) {
      this.sub_12a(g);
   }

   public final void sub_5b() {
      this.repaint();
      this.serviceRepaints();
   }

   public abstract void sub_12a(Graphics g);

   public final int sub_97(int var1) {
      if (var1 != var_140 && var1 != var_223) {
         if (var1 != var_1d5 && var1 != var_27f) {
            int var2 = 0;
            int var3 = 999999;

            try {
               var2 = this.getGameAction(var1);
            } catch (Exception var4) {
            }

            if (var1 == 42) {
               var3 = 0;
            } else if (var1 == 35) {
               var3 = 1;
            } else if (var1 == 48) {
               var3 = 11;
            } else if (var1 == 49) {
               var3 = 6;
            } else if (var1 == 50) {
               var3 = 2;
            } else if (var1 == 51) {
               var3 = 7;
            } else if (var1 == 52) {
               var3 = 4;
            } else if (var1 == 53) {
               var3 = 10;
            } else if (var1 == 54) {
               var3 = 5;
            } else if (var1 == 55) {
               var3 = 8;
            } else if (var1 == 56) {
               var3 = 3;
            } else if (var1 == 57) {
               var3 = 9;
            } else if (var2 == 1) {
               var3 = 2;
            } else if (var2 == 2) {
               var3 = 4;
            } else if (var2 == 8) {
               var3 = 10;
            } else if (var2 == 5) {
               var3 = 5;
            } else if (var2 == 6) {
               var3 = 3;
            }

            return var3;
         } else {
            return 13;
         }
      } else {
         return 12;
      }
   }

   public static final boolean sub_ee(String var0) {
      if (!var_2bb) {
         return false;
      } else {
         try {
            return Class_178.var_3e2.platformRequest(var0);
         } catch (Exception var2) {
            return false;
         }
      }
   }

   public static final boolean sub_11d() {
      return sub_ee("http://wap.herocraft.com/sss/index.wml");
   }

   public static final boolean sub_180() {
      return sub_ee(Class_1b0.sub_5a0((short)266));
   }

   public void commandAction(Command command, Displayable var2) {
      if (command.getCommandType() == 4) {
         this.keyPressed(var_140);
      } else {
         if (command.getCommandType() == 1) {
            this.keyPressed(var_1d5);
         }

      }
   }

   public static boolean sub_1e0() {
      return false;
   }
}
