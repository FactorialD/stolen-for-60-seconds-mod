package main;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;

public abstract class BaseGameManager extends Canvas implements LevelObjectData {
   public static int musicManagerPriorityLevel;
   public static int KEY_OK = 21;
   public static int KEY_BACK = 22;
   public static int KEY_MENU = -20;
   public static int KEY_CANCEL = -21;
   public static boolean allowOpenLinks = false; // Если true, игра может открывать браузер (например, "Купить полную версию" или "Другие игры").

   public BaseGameManager() {
      this.setFullScreenMode(true);
   }

   public void paint(Graphics g) {
      this.paintGame(g);
   }

   public final void forceRepaint() {
      this.repaint();
      this.serviceRepaints();
   }

   public abstract void paintGame(Graphics g);

   public final int mapInputToGameAction(int inputCode) {
      if (inputCode != KEY_OK && inputCode != KEY_MENU) {
         if (inputCode != KEY_BACK && inputCode != KEY_CANCEL) {
            int var2 = 0;
            int var3 = 999999;

            try {
               var2 = this.getGameAction(inputCode);
            } catch (Exception var4) {
            }

            if (inputCode == 42) {
               var3 = 0;
            } else if (inputCode == 35) {
               var3 = 1;
            } else if (inputCode == 48) {
               var3 = 11;
            } else if (inputCode == 49) {
               var3 = 6;
            } else if (inputCode == 50) {
               var3 = 2;
            } else if (inputCode == 51) {
               var3 = 7;
            } else if (inputCode == 52) {
               var3 = 4;
            } else if (inputCode == 53) {
               var3 = 10;
            } else if (inputCode == 54) {
               var3 = 5;
            } else if (inputCode == 55) {
               var3 = 8;
            } else if (inputCode == 56) {
               var3 = 3;
            } else if (inputCode == 57) {
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

   public static final boolean openBrowser(String link) {
      if (!allowOpenLinks) {
         return false;
      } else {
         try {
            return GlobalManager.mainMidlet.platformRequest(link);
         } catch (Exception e) {
            return false;
         }
      }
   }

   public static final boolean openHerocraftLink() {
      return openBrowser("http://wap.herocraft.com/sss/index.wml");
   }

   public static final boolean openMoreGames() {
      return openBrowser(ReadingDrawingClass.getTextById((short)266));
   }

   public void commandAction(Command command, Displayable var2) {
      if (command.getCommandType() == 4) {
         this.keyPressed(KEY_OK);
      } else {
         if (command.getCommandType() == 1) {
            this.keyPressed(KEY_BACK);
         }

      }
   }

   public static boolean sub_1e0() {
      return false;
   }
}
