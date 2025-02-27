package pkg_4d;

import java.io.DataInputStream;
import java.io.EOFException;
import java.util.Hashtable;
import pkg_65.Class_10b;

public final class Class_1f8 {
   private static Hashtable var_48 = new Hashtable();
   public static String var_84;
   public static String var_ce;
   public static String var_dd;
   public static String var_131;
   public static String var_194;
   public static String var_1d3;
   public static String var_215;
   public static String var_258;
   public static String var_2a8;
   public static String var_2e7;
   public static String var_323;
   public static String var_382;
   public static String var_3cd;
   public static String var_3e6;
   public static String var_425;
   public static String var_44f;
   public static String var_48e;
   public static String var_4da;
   public static String var_528;
   public static String var_569;
   public static String var_575;
   public static String var_598;
   public static String var_5b9;
   public static String var_614;
   public static String var_670;
   public static String var_6bb;
   public static String var_715;
   public static String var_768;
   public static String var_77f;
   public static String var_796;
   public static String var_7df;
   public static String var_828;
   public static String var_848 = "English";
   public static String var_852 = "Русский";
   public static String var_887;
   public static final int var_8be = 0;
   public static final int var_8d6 = 1;
   public static final int var_924 = 2;
   public static final int var_940 = 3;
   public static final int var_955 = 4;
   public static final int var_9b3 = 5;
   public static final int var_9d8 = 6;
   public static final int var_a35 = 8;
   public static final int var_a6b = 9;
   public static final int var_ace = 10;
   public static final int var_b1d = 11;
   public static final int var_b64 = 12;
   public static final int var_bc7 = 13;
   public static final int var_c28 = 14;
   public static final int var_c7f = 15;
   public static final int var_ccb = 16;
   public static final int var_cdf = 17;
   public static final int var_d27 = 18;
   public static final int var_d61 = 19;
   public static final int var_d99 = 101;
   public static final int var_db5 = 100;
   public static String var_de9;
   public static String var_e14;
   public static String var_e50;
   public static String var_e91;
   public static String var_e9c;
   public static String var_ee0;
   public static String var_f2e;
   public static String var_f7a;
   public static String var_fa1;
   public static String var_fc4;
   public static String var_1024;
   public static String var_1083;
   public static String var_10ad;
   public static String var_10cb;
   public static String var_111b;
   public static String var_116d = "";
   public static final int var_117a = 4;
   public static final String var_11b9 = ",ru_a,ru,az,am,by,ge,kz,kg,md,tj,tm,uz,ua,";

   private static String sub_54(Object var0) {
      return (String)var_48.get(var0);
   }

   public static void sub_98(String var0) {
      var_116d = var0;
      String var1 = "/glomoRes/en.lang";
      if (var0.compareTo(var_848) == 0) {
         var1 = "/glomoRes/en.lang";
      } else if (var0.compareTo(var_852) == 0) {
         var1 = "/glomoRes/ru.lang";
      }

      var_48.clear();
      DataInputStream var5 = new DataInputStream((new Class_1f8()).getClass().getResourceAsStream(var1));

      while(true) {
         try {
            if ((var1 = var5.readUTF()).compareTo("") != 0) {
               String[] var6 = Class_10b.sub_30("\t", var1);
               var_48.put(var6[0], var6[1]);
            }
            continue;
         } catch (EOFException var3) {
         } catch (Exception var4) {
            var4.printStackTrace();
         }

         try {
            var5.close();
         } catch (Exception var2) {
            var2.printStackTrace();
         }

         var_84 = sub_54("WND_TITLE_START_ALERT");
         var_ce = sub_54("WND_TITLE_ACTIVATE");
         var_dd = sub_54("WND_TITLE_ACTIVATE_RU");
         var_131 = sub_54("WND_TITLE_ACTIVATE_EN");
         var_194 = sub_54("WND_TITLE_COUNTRY_LIST");
         var_1d3 = sub_54("WND_TITLE_COUNTRY_LIST_RU");
         var_215 = sub_54("WND_TITLE_COUNTRY_LIST_EN");
         var_258 = sub_54("WND_TITLE_SERIAL_NUMBER");
         var_2a8 = sub_54("WND_TITLE_ERROR_ALERT");
         var_2e7 = sub_54("WND_TITLE_ERROR_ALERT_RU");
         var_323 = sub_54("WND_TITLE_ERROR_ALERT_EN");
         var_382 = sub_54("BTN_EXIT");
         var_3cd = sub_54("BTN_EXIT_RU");
         var_3e6 = sub_54("BTN_EXIT_EN");
         var_425 = sub_54("BTN_BACK");
         var_44f = sub_54("BTN_SELECT");
         var_48e = sub_54("BTN_SELECT_RU");
         var_4da = sub_54("BTN_SELECT_EN");
         var_528 = sub_54("BTN_YES");
         var_569 = sub_54("BTN_YES_RU");
         var_575 = sub_54("BTN_YES_EN");
         var_598 = sub_54("BTN_NO");
         var_5b9 = sub_54("BTN_NO_RU");
         var_614 = sub_54("BTN_NO_EN");
         var_670 = sub_54("BTN_OK");
         var_6bb = sub_54("BTN_CANCEL");
         var_715 = sub_54("MENU_ACTIVATE_GAME");
         var_768 = sub_54("MENU_SERIAL_NUMBER");
         var_77f = sub_54("MENU_CHANGE_COUNTRY");
         var_796 = sub_54("MENU_SEND_TO_FRIEND");
         var_7df = sub_54("MENU_MORE_GAMES");
         var_828 = sub_54("MENU_INTERFACE_LANGUAGE");
         var_887 = sub_54("MENU_HELP");
         var_de9 = sub_54("TEXT_START_ALERT_RU");
         var_e14 = sub_54("TEXT_START_ALERT_EN");
         var_e50 = sub_54("TEXT_REGISTERED_OK");
         var_e91 = sub_54("TEXT_REGISTERED_FAILED");
         var_e9c = sub_54("TEXT_SENT_TO_FRIEND_OK");
         var_ee0 = sub_54("TEXT_SENT_TO_FRIEND_FAILED");
         var_f2e = sub_54("TEXT_SERIAL_NUMBER_RIGHT");
         var_f7a = sub_54("TEXT_SERIAL_NUMBER_WRONG");
         var_fa1 = sub_54("TEXT_ACTIVATE_FORM");
         var_fc4 = sub_54("TEXT_SEND_TO_FRIEND");
         var_1024 = sub_54("TEXT_ALERT_GLOMO_ERROR_CODE_0");
         var_1083 = sub_54("TEXT_ALERT_GLOMO_ERROR_CODE_0_RU");
         var_10ad = sub_54("TEXT_ALERT_GLOMO_ERROR_CODE_0_EN");
         var_10cb = sub_54("TEXT_HELP");
         var_111b = sub_54("TEXT_ACTIVATE_IN_PROGRESS_ALERT");
         return;
      }
   }
}
