package main;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.rms.RecordStore;

public final class Class_1b0 implements LevelObjectData {
   public static byte var_12 = 7;
   public static byte var_a9 = 9;
   private static final Random var_e3 = new Random();
   private static String[] mainImageNames = new String[]{"abc", "pic1", "pic2", "pic3", "pic4", "pic5", "pic6"};
   public static short var_12d;
   private static final short[][] var_13b = new short[][]{{64, 11, 116, 106, 54, 25, 64, 93, 46, 41, 54, 77}, {49, 0, 77, 15, 49, 112, 77, 127, 56, 15, 70, 112, 48, 26, 56, 42, 70, 25, 78, 42}, {49, 0, 77, 15, 49, 112, 77, 127, 56, 15, 70, 112, 43, 15, 82, 112, 37, 26, 43, 44, 82, 26, 92, 44}, {55, 8, 113, 118, 17, 38, 55, 78, 28, 38, 41, 78}, {34, 13, 49, 113, 31, 23, 34, 105}, {27, 0, 100, 127, 40, 0, 87, 127}, {4, 22, 30, 56, 20, 100, 30, 111, 13, 36, 30, 44, 20, 73, 30, 85, 30, 0, 48, 127}, {27, 0, 100, 127, 40, 47, 88, 94, 65, 68, 79, 79, 50, 54, 71, 55, 51, 70, 54, 77}, {43, 1, 111, 125, 1, 27, 43, 76, 13, 27, 25, 76, 83, 22, 94, 97, 56, 93, 66, 102}, {12, 11, 113, 116, 35, 32, 91, 92, 12, 45, 35, 82, 45, 92, 85, 116, 43, 11, 84, 32, 91, 44, 113, 83}, {42, 32, 81, 86, 34, 99, 89, 124, 57, 50, 64, 61, 51, 86, 73, 99}, {32, 10, 48, 118, 4, 47, 18, 81, 18, 16, 33, 110}, {11, 0, 48, 127, 24, 18, 48, 109}, {9, 1, 49, 126, 4, 22, 9, 37, 4, 91, 9, 104}, {11, 16, 29, 109, 11, 0, 48, 127}, {43, 6, 104, 120, 82, 6, 104, 120, 43, 105, 82, 120, 43, 6, 82, 22}, {29, 28, 99, 100, 29, 94, 35, 100, 29, 28, 35, 34, 93, 28, 99, 34, 93, 94, 99, 100}, {40, 21, 90, 37, 90, 37, 106, 85, 40, 85, 90, 100, 26, 37, 40, 85}, {28, 34, 102, 82, 11, 73, 28, 82, 11, 34, 28, 43, 48, 34, 82, 82, 102, 44, 118, 73}, {27, 0, 100, 127}, {0, 25, 37, 25, 52, 8, 118, 119, 118, 77, 126, 100, 62, 0, 105, 8, 62, 119, 105, 127, 37, 25, 37, 102, 0, 8, 52, 8, 0, 102, 37, 102, 0, 119, 52, 119, 118, 27, 126, 52}, {32, 32, 99, 87, 48, 50, 82, 60, 49, 73, 49, 87, 66, 73, 66, 87, 81, 73, 81, 87}, {12, 11, 113, 116, 35, 32, 91, 92}, {24, 24, 101, 101}};
   private static String allCharactersStr;
   public static boolean var_19d;
   private static final Hashtable gameTexts = new Hashtable();
   public static Image[] mainImages;
   private static short var_279;
   private static short var_2a2;
   private static short[] var_2c7;
   private static int var_2d5 = -1;
   private static boolean var_305 = true;

   public static int sub_21(int var0, int var1) {
      if (var0 >= var1) {
         return var0;
      } else {
         int var2;
         for(int var3 = Math.abs(var2 = var_e3.nextInt()) % 5 + 3; var3 > 0; --var3) {
            var2 = var_e3.nextInt();
         }

         return Math.abs(var2) % (var1 - var0 + 1) + var0;
      }
   }

   public static void sub_5d(Graphics g, short[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = 0;
      int var9 = 0;

      for(int var11 = var6 + var2; var8 < var11; ++var8) {
         var_2d5 = -1;
         int var10 = Math.min(var1.length, sub_bd(var1, var9, var9 + var5 - 1, var5));
         if (var9 <= var10) {
            byte var12 = 0;

            int var13;
            for(var13 = var9; var13 < var10; ++var13) {
               if (var1[var13] == var_279) {
                  var10 = var13 + 1;
                  var12 = 1;
                  var_2d5 = -1;
                  break;
               }
            }

            if (var8 >= var2 && var8 < var11) {
               var13 = var10 - var9 - var12;
               int var15 = 0;
               if (var_2d5 != -1) {
                  var15 = var_2d5;
               } else if (var12 == 0 && (var15 = var5 - var13 + 1) + var10 > var1.length) {
                  var15 = 0;
               }

               short[] var14 = sub_6c(var9, var10, var12, var1, var13, var15);
               if (var_2d5 != -1 && var14.length > 1) {
                  for(int var16 = var14.length - 1; var16 > 0; --var16) {
                     if (var14[var16] != 0) {
                        var14[var16 + 1] = var_2a2;
                        break;
                     }
                  }
               }

               sub_47c(g, var14, var3, var4 + (var8 - var2) * var7);
            }
         }

         var9 = var10;
      }

   }

   private static short[] sub_6c(int var0, int var1, int var2, short[] var3, int var4, int var5) {
      int var7 = 0;
      boolean var8 = false;
      int var9;
      if (var5 > 0) {
         for(var9 = var0; var9 < var1 - var2; ++var9) {
            if (var8 || var3[var9] != 0) {
               if (var3[var9] != 0) {
                  var8 = true;
               } else {
                  ++var7;
                  var8 = false;
               }
            }
         }
      }

      if (!var8) {
         --var7;
      }

      short[] var6 = new short[var4 + var5 + 1];
      if (var7 > 0) {
         int var10 = (var9 = var5 / var7) + var5 % var7;
         var8 = false;
         int var11 = 0;
         int var12 = var0 + var6.length - 1;
         int var13 = var0;

         for(int var14 = var0; var14 < var12; ++var14) {
            if (var8 || var3[var13] != 0) {
               var6[var14 - var0] = var3[var13];
               if (var3[var13] != 0) {
                  var8 = true;
               } else {
                  if (var11 == 0) {
                     var14 += var10;
                  } else {
                     var14 += var9;
                  }

                  ++var11;
                  var8 = false;
               }

               ++var13;
            }
         }
      } else {
         Class_3d.sub_1cf(var3, var0, var6, 0, var4);
      }

      return var6;
   }

   private static int sub_bd(short[] var0, int var1, int var2, int var3) {
      if ((var2 = Math.min(var0.length - 1, var2)) == var0.length - 1) {
         return var2 + 1;
      } else if (var2 + 2 >= var0.length || var0[var2 + 1] != 0 && var0[var2 + 1] != var_279) {
         short var4;
         for(var4 = -1; var1 < var2; --var2) {
            if (var0[var2] == 0 || var0[var2] == var_279) {
               var4 = var0[var2];
               break;
            }
         }

         if (var4 != -1 && (!var_305 || var4 != 0)) {
            ++var2;
         } else {
            var2 = sub_111(var1, var2, var3, var0);
         }

         return Math.min(var0.length, var2);
      } else {
         return var2 + 2;
      }
   }

   private static int sub_111(int var0, int var1, int var2, short[] var3) {
      int var4 = var0 + var2 - 1;
      int var5 = allCharactersStr.indexOf(46);
      boolean var6 = false;
      int var7;
      if (var4 - var1 > 2) {
         int var8;
         for(var8 = var7 = var1 + 1; var8 < var3.length && var3[var8] != 0 && var3[var8] < var5; ++var8) {
         }

         int var9;
         if ((var9 = var8 - var7) > 3) {
            int var10;
            if ((var10 = sub_175(var3, var9, var4 - var1 - 1, var7)) != -1) {
               var_2d5 = var4 - var10;
               return var10;
            }

            var6 = true;
         } else {
            var6 = true;
         }
      }

      if (!var6) {
         return var1 + 1;
      } else {
         for(var7 = var4; var0 < var7; --var7) {
            if (var3[var7] == 0 || var3[var7] == var5) {
               ++var7;
               break;
            }
         }

         return var7 <= var0 ? var4 : var7;
      }
   }

   private static int sub_175(short[] var0, int var1, int var2, int var3) {
      int var4 = var3 + var1;
      short[] var5 = readTextFromLng((short)265);
      if (sub_1ce(var3, var4, var0) > 1) {
         for(int var6 = var3 + var2; var6 > var3; --var6) {
            int var7;
            int var8;
            if ((var7 = sub_1ce(var3, var6, var0)) != 0 && (var8 = sub_1ce(var6, var3 + var1, var0)) != 0) {
               boolean var9 = false;

               int var10;
               for(var10 = 0; var10 < var5.length; ++var10) {
                  if (var5[var10] == var0[var6]) {
                     var9 = true;
                     break;
                  }
               }

               if (!var9) {
                  var10 = var6 - var3;
                  if (var7 != var10 && var8 != var4 - var6 && (!sub_1bb(var0[var6 - 2]) && sub_1bb(var0[var6 - 1]) && !sub_1bb(var0[var6]) || sub_1bb(var0[var6 - 1]) && sub_1bb(var0[var6]) || !sub_1bb(var0[var6 - 1]) && !sub_1bb(var0[var6]))) {
                     return var6;
                  }
               }
            }
         }
      }

      return -1;
   }

   private static boolean sub_1bb(short var0) {
      for(int var1 = 0; var1 < var_2c7.length; ++var1) {
         if (var0 == var_2c7[var1]) {
            return true;
         }
      }

      return false;
   }

   private static int sub_1ce(int var0, int var1, short[] var2) {
      int var3 = 0;

      for(int var4 = var0; var4 < var1; ++var4) {
         if (sub_1bb(var2[var4])) {
            ++var3;
         }
      }

      return var3;
   }

   public static int sub_1e5(short[] var0, int var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < var0.length; ++var2) {
         int var4 = sub_bd(var0, var3, var3 + var1 - 1, var1);

         for(int var5 = var3; var5 < var4; ++var5) {
            if (var0[var5] == var_279) {
               var4 = var5 + 1;
               break;
            }
         }

         var3 = Math.min(var0.length, var4);
      }

      return var2;
   }

   public static String sub_1f4(String var0, byte var1) {
      int var2 = 0;

      int var3;
      for(var3 = 0; var1 > 0; --var1) {
         var3 = var2;
         if ((var2 = var0.indexOf(59, var2)) == -1) {
            return null;
         }

         ++var2;
      }

      return var0.substring(var3, var2 - 1);
   }

   public static void sub_20e(Graphics var0, int var1, int var2, int var3, int var4, boolean var5, int var6) {
      sub_250(var0, var1, var2, var3, var4, var5, var6, 12500156, 4342338);
   }

   public static void sub_250(Graphics g, int var1, int var2, int var3, int var4, boolean var5, int var6, int var7, int var8) {
      g.setStrokeStyle(0);
      g.setClip(var1, var2, var3, var4);
      int var9;
      int var10;
      if (var5) {
         var9 = var7;
         var10 = var8;
      } else {
         var9 = var8;
         var10 = var7;
      }

      if (var6 >= 0) {
         g.setColor(var6);
         g.fillRect(var1, var2, var3 - 1, var4 - 1);
      }

      g.setColor(var10);
      g.drawRect(var1, var2, var3 - 1, var4 - 1);
      g.setColor(var9);
      g.drawLine(var1, var2, var1 + var3 - 1, var2);
      g.drawLine(var1, var2, var1, var2 + var4 - 2);
   }

   /** Return stream with bias at level data position
    * */
//   public static DataInputStream getLevelDataStream(byte level) throws IOException {
//      DataInputStream levelStream = getDataInputStreamFromDat("m");
//      byte var2 = 1;
//
//      // Get level data size from first 2 bytes
//      // Then skip current level data, until get to needed level data
//      for(short var3 = levelStream.readShort(); var2 != level; ++var2) {
//         levelStream.skipBytes(var3);
//         var3 = levelStream.readShort();
//      }
//
//      return levelStream;
//   }
   
   /** Return stream with bias at level data position
    * */
   public static DataInputStream getLevelDataStream(byte level) throws IOException {
      DataInputStream levelStream = getDataInputStreamFromDat("map" + (level < 10 ? "0" : "") + level + ".dat");

      return levelStream;
   }

   public static void sub_2c5(Graphics g, byte var1, byte var2, int var3, int var4, int var5) {
      if (var1 >= 0) {
         g.setColor(var5);
         g.setClip(var3, var4, 24, 24);
         int var13 = var_13b[var1].length;

         for(int var14 = 0; var14 < var13; var14 += 4) {
            int var7 = var_13b[var1][var14] * 24 >> 7;
            int var8 = var_13b[var1][var14 + 1] * 24 >> 7;
            int var9 = var_13b[var1][var14 + 2] * 24 >> 7;
            int var10 = var_13b[var1][var14 + 3] * 24 >> 7;

            for(int var6 = 0; var6 < var2; ++var6) {
               int var11 = var7;
               int var12 = var9;
               var7 = 23 - var10;
               var9 = 23 - var8;
               var8 = var11;
               var10 = var12;
            }

            g.drawRect(var3 + var7, var4 + var8, var9 - var7, var10 - var8);
         }

      }
   }

   public static void sub_2db(Graphics var0, byte var1, int var2, int var3, int var4) {
      sub_2e7(var0, var1, var2, var3, var4, 0, 0, 0, 0);
   }

   public static void sub_2e7(Graphics g, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      short var9 = LevelObjectData.var_b6[var1][2];
      short var10 = LevelObjectData.var_b6[var1][3];
      if (var3 + var9 > 0 && var3 < LevelManager.var_1d && var4 + var10 > 0 && var4 < LevelManager.var_b0) {
         int var11 = var3 + var9 - LevelManager.var_1d;
         int var12 = var4 + var10 - LevelManager.var_b0;
         int var13 = Math.max(var5, var3 < 0 ? -var3 : 0);
         int var14 = Math.max(var6, var11 > 0 ? var11 : 0);
         int var15 = Math.max(var7, var4 < 0 ? -var4 : 0);
         int var16 = Math.max(var8, var12 > 0 ? var12 : 0);
         int var17 = 0;
         if (var2 >= LevelObjectData.var_b6[var1][4]) {
            var17 = var2 / LevelObjectData.var_b6[var1][4];
            var2 -= var17 * LevelObjectData.var_b6[var1][4];
         }

         g.setClip(var3 + var13, var4 + var15, LevelObjectData.var_b6[var1][2] - var14 - var13, LevelObjectData.var_b6[var1][3] - var16 - var15);
         Image var18 = mainImages[LevelObjectData.var_b6[var1][5]];
         // maybe here loading maptiles
         if (var18 != null) {
            g.drawImage(var18, var3 - var2 * LevelObjectData.var_b6[var1][2] - LevelObjectData.var_b6[var1][0], var4 - LevelObjectData.var_b6[var1][1] - var17 * LevelObjectData.var_b6[var1][3], 20);
         }
      }
   }

   public static void loadMainImage(int imageIndex) {
      Class_3d.callGc();

      try {
         if (mainImages == null) {
            mainImages = new Image[7];
         }

         mainImages[imageIndex] = loadImagePng(mainImageNames[imageIndex]);
      } catch (Exception var1) {
      }

      Class_3d.callGc();
   }

   public static Image loadImagePng(String imageName) {
      Class_3d.callGc();
      try {
		return Image.createImage("/dat/" + imageName + ".png");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
   }

   public static void readCharactersFromLng() {
      Class_3d.callGc();
      var_12d = (short)((byte)(mainImages[0].getWidth() / var_12));
      LevelObjectData.var_b6[43][4] = var_12d;
      DataInputStream dataStream = null;

      try {
         var_19d = (dataStream = getDataInputStreamFromDat("lng")).readByte() == 1;
         allCharactersStr = dataStream.readUTF();
         var_279 = (short)allCharactersStr.indexOf(95);
         var_2a2 = (short)allCharactersStr.indexOf(45);
         // this accordingly to lng file, never runs
         if (var_19d) {
            var_12 = (byte)Font.getDefaultFont().charWidth('W');
            var_a9 = (byte)Font.getDefaultFont().getHeight();
            LevelObjectData.var_b6[43][2] = (short)var_12;
            LevelObjectData.var_b6[43][3] = (short)var_a9;
         }

         short var2 = dataStream.readShort();
         short var3 = 1;

         while(true) {
            if (var3 <= 1) {
               if (var_19d) {
                  var2 = (short)(var2 << 1);
               }

               dataStream.skipBytes(var2);
            } else {
               short[] var4 = new short[var2];

               int var5;
               for(var5 = 0; var5 < var2; ++var5) {
                  if (var_19d) {
                     var4[var5] = dataStream.readShort();
                  } else {
                     var4[var5] = (short)dataStream.readByte();
                     if (var4[var5] < 0) {
                        var4[var5] = (short)(255 & (byte)var4[var5]);
                     }
                  }
               }

               if (var3 >= 267) {
                  try {
                     var5 = 0;
                     if (var3 != 275) {
                        var5 = Integer.parseInt(sub_5df(var4));
                     }

                     switch(var3) {
                     case 267:
                        var_305 = var5 == 1;
                        break;
                     case 268:
                        Class_178.var_46 = var5 == 1;
                        break;
                     case 269:
                        Class_26a.var_140 = var5;
                        break;
                     case 270:
                        Class_26a.var_1d5 = var5;
                        break;
                     case 271:
                        Class_26a.var_223 = var5;
                        break;
                     case 272:
                        Class_26a.var_27f = var5;
                        break;
                     case 273:
                        Class_26a.musicManagerPriorityLevel = var5;
                        break;
                     case 274:
                        Class_26a.var_2bb = var5 == 1;
                        break;
                     case 275:
                        Class_178.var_b17 = var2 > 0;
                        gameTexts.put(new Short(var3), var4);
                        break;
                     default:
                        gameTexts.put(new Short(var3), var4);
                     }
                  } catch (NumberFormatException var7) {
                  }
               } else {
                  gameTexts.put(new Short(var3), var4);
               }
            }

            ++var3;
            var2 = dataStream.readShort();
         }
      } catch (Exception var8) {
         try {
            if (dataStream != null) {
               dataStream.close();
            }
         } catch (IOException var6) {
         }

         var_2c7 = readTextFromLng((short)264);
         Class_3d.callGc();
      }
   }

   private static DataInputStream getDataInputStreamFromDat(String filename) {
      return new DataInputStream(MM.sub_d("/dat/" + filename));
   }

   public static short[] readTextFromLng(short var0) {
      short[] fastResult;
      if ((fastResult = (short[])((short[])gameTexts.get(new Short(var0)))) != null) {
         return fastResult;
      } else {
         DataInputStream dataStream = null;

         try {
            dataStream = getDataInputStreamFromDat("lng");
            byte var3 = 1;
            // skip character dictionary bytes and go to text ones
            dataStream.readByte();
            short someTextDataLength = dataStream.readShort();
            dataStream.skipBytes(someTextDataLength);
            
            someTextDataLength = dataStream.readShort();

            while(var3 <= 1) {
               if (1 == var0) {
                  short[] resultTextData = new short[someTextDataLength];

                  for(int i = 0; i < someTextDataLength; ++i) {
                     if (var_19d) {
                        resultTextData[i] = dataStream.readShort();
                     } else {
                        resultTextData[i] = (short)dataStream.readByte();
                        if (resultTextData[i] < 0) {
                           resultTextData[i] = (short)(255 & (byte)resultTextData[i]);
                        }
                     }
                  }

                  return resultTextData;
               }

               if (var_19d) {
                  someTextDataLength = (short)(someTextDataLength << 1);
               }

               dataStream.skipBytes(someTextDataLength);
               var3 = 2;
               dataStream.readShort();
            }

            return null;
         } catch (Exception var8) {
            try {
               if (dataStream != null) {
                  dataStream.close();
               }
            } catch (Exception var7) {
            }

            return null;
         }
      }
   }

   public static void sub_46a(Graphics var0, String var1, int var2, int var3) {
      sub_47c(var0, sub_533(var1), var2, var3);
   }

   public static void sub_47c(Graphics var0, short[] var1, int var2, int var3) {
      drawText(var0, var1, var2, var3, 0, 0);
   }

   public static void drawText(Graphics g, short[] textCodes, int var2, int var3, int var4, int var5) {
      if (var_19d && g != null) {
         g.setClip(0, 0, LevelManager.var_1d, LevelManager.var_b0);
      }

      int var6 = var2;

      for(int var7 = 0; var7 < textCodes.length; ++var7) {
         short var8;
         if ((var8 = textCodes[var7]) != -1) {
            if (!var_19d) {
               var6 = var2 + var7 * var_12;
            }

            boolean var9;
            if (var3 + var_a9 > 0 && var3 < LevelManager.var_b0 && (!(var9 = var4 != var5) && var6 + var_12 > 0 && var6 < LevelManager.var_1d || var9 && var6 >= var4 && var6 + var_12 <= var5)) {
               if (var_19d) {
                  try {
                     g.setColor(5, 5, 5);
                     g.drawSubstring(allCharactersStr, var8, 1, var6 + 1, var3 + 1, 20);
                     g.setColor(254, 250, 254);
                     g.drawSubstring(allCharactersStr, var8, 1, var6, var3, 20);
                     var6 += Font.getDefaultFont().substringWidth(allCharactersStr, var8, 1);
                  } catch (Exception var10) {
                     var6 = var2 + var7 * var_12;
                  }
               } else {
                  sub_2db(g, (byte)43, var8, var6, var3);
               }
            }
         }
      }

   }

   public static short[] sub_533(String var0) {
      int var1;
      short[] var2 = new short[var1 = var0.length()];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = (short)allCharactersStr.indexOf(var0.charAt(var3));
      }

      return var2;
   }

   public static short[] sub_569(short var0, Object[] var1) {
      String var2 = sub_5a0(var0);
      boolean var3 = false;
      StringBuffer var4 = new StringBuffer();
      int var5 = var2.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7;
         if (var3) {
            var3 = false;
            if ((var7 = var2.indexOf(125, var6)) > -1) {
               try {
                  int var8;
                  if ((var8 = Integer.parseInt(var2.substring(var6, var7))) < var1.length) {
                     if (var1[var8] instanceof Short) {
                        var4.append(sub_5a0(((Short)var1[var8]).shortValue()));
                     } else if (var1[var8] instanceof byte[]) {
                        var4.append(sub_5df((short[])((short[])var1[var8])));
                     } else {
                        var4.append(var1[var8]);
                     }
                  }

                  var6 = var7;
               } catch (Exception var9) {
                  var4.append('{').append(var2.charAt(var6));
               }
            } else {
               var4.append('{').append(var2.charAt(var6));
            }
         } else if (var2.charAt(var6) == '{') {
            if ((var7 = var2.indexOf(123, var6 + 1)) > -1 && var7 < var2.indexOf(125, var6)) {
               var4.append(var2.charAt(var6));
            } else {
               var3 = true;
            }
         } else {
            var4.append(var2.charAt(var6));
         }
      }

      return sub_533(var4.toString());
   }

   public static String sub_5a0(short var0) {
      StringBuffer var1 = new StringBuffer();
      short[] var2 = readTextFromLng(var0);

      for(int var3 = 0; var3 < var2.length; ++var3) {
         try {
            var1.append(allCharactersStr.charAt(var2[var3]));
         } catch (Exception var4) {
         }
      }

      return var1.toString();
   }

   public static String sub_5df(short[] var0) {
      StringBuffer var1 = new StringBuffer();

      for(int var2 = 0; var2 < var0.length; ++var2) {
         try {
            var1.append(allCharactersStr.charAt(var0[var2]));
         } catch (Exception var3) {
         }
      }

      return var1.toString();
   }

   public static byte sub_619(int var0, int var1) {
      return (byte)(var0 % var1 > (var1 >> 1) - (var1 + 1) % 2 ? 1 : 0);
   }

   public static boolean sub_678(byte var0, byte var1) {
      return (var0 >> var1 & 1) == 1;
   }

   public static byte sub_6b7(byte var0, byte var1, boolean var2) {
      return var2 ? (byte)(1 << var1 | var0) : (byte)(255 - (1 << var1) & var0);
   }

   public static void sub_6da() {
      RecordStore var0 = null;
      ByteArrayInputStream var1 = null;
      DataInputStream var2 = null;
      boolean var13 = false;

      label138: {
         try {
            var13 = true;
            var0 = RecordStore.openRecordStore("save1", false);
            var1 = new ByteArrayInputStream(var0.getRecord(1));
            var2 = new DataInputStream(var1);
            byte var3 = Class_178.var_dc6;
            Class_178.var_5bb = var2.readByte();
            Class_178.var_dc6 = var2.readByte();
            Class_178.var_e38 = var2.readInt();
            if (Class_178.var_dc6 != var3) {
               LevelManager.loadLevel(Class_178.var_dc6);
            } else {
               LevelManager.var_84c.clear();
               LevelManager.sub_192(true);
            }

            Class_178.var_d50.removeAllElements();
            byte var4 = var2.readByte();

            for(int var5 = 0; var5 < var4; ++var5) {
               byte var6 = var2.readByte();
               Class_178.var_d50.addElement(Class_178.var_d34[var6]);
            }

            Class_178.var_10ff = var0.getRecord(2)[0];
            var13 = false;
            break label138;
         } catch (Exception var17) {
            var13 = false;
         } finally {
            if (var13) {
               if (var0 != null) {
                  try {
                     var0.closeRecordStore();
                     if (var2 != null) {
                        var2.close();
                     }

                     if (var1 != null) {
                        var1.close();
                     }
                  } catch (Exception var14) {
                  }
               }

               Class_3d.callGc();
            }
         }

         if (var0 != null) {
            try {
               var0.closeRecordStore();
               if (var2 != null) {
                  var2.close();
               }

               if (var1 != null) {
                  var1.close();
               }
            } catch (Exception var15) {
            }
         }

         Class_3d.callGc();
         return;
      }

      if (var0 != null) {
         try {
            var0.closeRecordStore();
            var2.close();
            var1.close();
         } catch (Exception var16) {
         }
      }

      Class_3d.callGc();
   }

   public static void sub_6f5() {
      RecordStore var0 = null;
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      DataOutputStream var2 = null;
      boolean var11 = false;

      label116: {
         try {
            var11 = true;
            var2 = new DataOutputStream(var1);
            int var3;
            if ((var0 = RecordStore.openRecordStore("save1", true)).getNumRecords() == 0) {
               var3 = 6 + Class_178.var_d34.length * 2 + 4 + 5;
               var0.addRecord(new byte[var3], 0, var3);
               var0.addRecord(new byte[1], 0, 1);
            }

            var2.writeByte(Class_178.var_5bb);
            var2.writeByte(Class_178.var_dc6);
            var2.writeInt(Class_178.var_e38);
            var3 = Class_178.var_d50.size();
            var2.writeByte(var3);

            for(int var4 = 0; var4 < var3; ++var4) {
               var2.writeByte(((Class_205)Class_178.var_d50.elementAt(var4)).var_3a);
            }

            byte[] var17 = var1.toByteArray();
            var0.setRecord(1, var17, 0, var17.length);
            var0.setRecord(2, new byte[]{Class_178.var_10ff}, 0, 1);
            Class_178.var_1cd = true;
            var11 = false;
            break label116;
         } catch (Exception var15) {
            var11 = false;
         } finally {
            if (var11) {
               try {
                  var0.closeRecordStore();
                  if (var2 != null) {
                     var2.close();
                  }

                  var1.close();
               } catch (Exception var12) {
               }

               Class_3d.callGc();
            }
         }

         try {
            var0.closeRecordStore();
            if (var2 != null) {
               var2.close();
            }

            var1.close();
         } catch (Exception var13) {
         }

         Class_3d.callGc();
         return;
      }

      try {
         var0.closeRecordStore();
         var2.close();
         var1.close();
      } catch (Exception var14) {
      }

      Class_3d.callGc();
   }

   public static void sub_71d() {
      RecordStore var0 = null;

      try {
         (var0 = RecordStore.openRecordStore("save1", true)).setRecord(2, new byte[]{Class_178.var_10ff}, 0, 1);
         return;
      } catch (Exception var9) {
      } finally {
         try {
            if (var0 != null) {
               var0.closeRecordStore();
            }
         } catch (Exception var8) {
         }

         Class_3d.callGc();
      }

   }

   public static void sub_759() {
      try {
         RecordStore.deleteRecordStore("save1");
         Class_178.var_1cd = false;
      } catch (Exception var0) {
      }
   }

   public static boolean sub_7ad(int var0) {
      boolean var1 = false;
      RecordStore var2 = null;

      try {
         if ((var2 = RecordStore.openRecordStore("save" + var0, false)) != null && var2.getNumRecords() > 0) {
            var1 = true;
         }
      } catch (Exception var11) {
      } finally {
         if (var2 != null) {
            try {
               var2.closeRecordStore();
            } catch (Exception var10) {
            }
         }

      }

      return var1;
   }

   public static void sub_7c6() {
      RecordStore var0 = null;

      try {
         var0 = RecordStore.openRecordStore("option", false);
         byte[] var1 = new byte[Class_178.var_129e.length];

         for(byte var2 = 0; var2 < var1.length; ++var2) {
            var1[var2] = (byte)(Class_178.var_129e[var2] ? 1 : 0);
         }

         var0.setRecord(1, var1, 0, var1.length);
      } catch (Exception var10) {
      } finally {
         try {
            if (var0 != null) {
               var0.closeRecordStore();
            }
         } catch (Exception var9) {
         }

      }

   }

   public static void sub_7ec(short[][] var0, int[] var1) {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      DataOutputStream var3 = null;
      RecordStore var4 = null;
      boolean var14 = false;

      label161: {
         try {
            var14 = true;
            var4 = RecordStore.openRecordStore("winner", true);
            var3 = new DataOutputStream(var2);

            int var6;
            for(var6 = 0; var6 < 5; ++var6) {
               for(int var7 = 0; var7 < 5; ++var7) {
                  var3.writeShort(var0[var6][var7]);
               }
            }

            for(var6 = 0; var6 < 5; ++var6) {
               var3.writeInt(var1[var6]);
            }

            byte[] var5 = var2.toByteArray();
            if (var4.getNumRecords() > 0) {
               var4.setRecord(1, var5, 0, var5.length);
               var14 = false;
            } else {
               var4.addRecord(var5, 0, var5.length);
               var14 = false;
            }
            break label161;
         } catch (Exception var18) {
            var14 = false;
         } finally {
            if (var14) {
               try {
                  if (var4 != null) {
                     var4.closeRecordStore();
                  }

                  if (var3 != null) {
                     var3.close();
                  }
               } catch (Exception var15) {
               }

            }
         }

         try {
            if (var4 != null) {
               var4.closeRecordStore();
            }

            if (var3 != null) {
               var3.close();
            }

            return;
         } catch (Exception var16) {
            return;
         }
      }

      try {
         if (var4 != null) {
            var4.closeRecordStore();
         }

         var3.close();
      } catch (Exception var17) {
         return;
      }

   }

   public static Vector sub_80d() {
      Vector var0 = new Vector(2);
      RecordStore var1 = null;
      ByteArrayInputStream var2 = null;
      DataInputStream var3 = null;
      boolean var13 = false;

      label182: {
         try {
            var13 = true;
            var1 = RecordStore.openRecordStore("winner", false);
            var2 = new ByteArrayInputStream(var1.getRecord(1));
            var3 = new DataInputStream(var2);
            short[][] var4 = new short[5][5];

            int var6;
            for(int var5 = 0; var5 < 5; ++var5) {
               for(var6 = 0; var6 < 5; ++var6) {
                  var4[var5][var6] = var3.readShort();
               }
            }

            int[] var19 = new int[5];

            for(var6 = 0; var6 < 5; ++var6) {
               var19[var6] = var3.readInt();
            }

            var0.addElement(var4);
            var0.addElement(var19);
            var13 = false;
            break label182;
         } catch (Exception var17) {
            var13 = false;
         } finally {
            if (var13) {
               if (var1 != null) {
                  try {
                     var1.closeRecordStore();
                     if (var3 != null) {
                        var3.close();
                     }

                     if (var2 != null) {
                        var2.close();
                     }
                  } catch (Exception var14) {
                  }
               }

               Class_3d.callGc();
            }
         }

         if (var1 != null) {
            try {
               var1.closeRecordStore();
               if (var3 != null) {
                  var3.close();
               }

               if (var2 != null) {
                  var2.close();
               }
            } catch (Exception var15) {
            }
         }

         Class_3d.callGc();
         return var0;
      }

      if (var1 != null) {
         try {
            var1.closeRecordStore();
            var3.close();
            var2.close();
         } catch (Exception var16) {
         }
      }

      Class_3d.callGc();
      return var0;
   }

   public static void sub_837() {
      try {
         RecordStore.deleteRecordStore("path");
      } catch (Exception var0) {
      }
   }

   public static void sub_870() {
      ByteArrayOutputStream byteArrOutStream = new ByteArrayOutputStream();
      DataOutputStream outStream = null;
      RecordStore var2 = null;
      boolean var20 = false;

      label352: {
         try {
            var20 = true;
            outStream = new DataOutputStream(byteArrOutStream);
            sub_8fa();
            var2 = RecordStore.openRecordStore("path", true);

            int var3;
            for(var3 = 0; var3 < var2.getNumRecords(); ++var3) {
               var2.deleteRecord(var3);
            }

            outStream.writeByte(Class_178.var_dc6);
            outStream.writeInt(Class_178.var_e38);
            outStream.writeByte(LevelManager.var_c64);

            for(var3 = 0; var3 < LevelManager.var_7a3.length; ++var3) {
               outStream.writeInt(LevelManager.var_7a3[var3]);
            }

            outStream.writeInt(LevelManager.var_7f3);
            var3 = LevelManager.var_99f.size();
            outStream.writeByte(var3);

            int var4;
            int var6;
            for(var4 = 0; var4 < var3; ++var4) {
               Class_205 var5 = (Class_205)LevelManager.var_99f.elementAt(var4);
               outStream.writeByte(var5.var_3a);
               outStream.write(var5.var_451);

               for(var6 = 0; var6 < var5.var_3fa.length; ++var6) {
                  outStream.writeShort(var5.var_3fa[var6]);
               }
            }

            outStream.write(Class_178.var_d34[0].var_451);
            var4 = Class_178.var_d50.size();
            outStream.writeByte(var4);

            int var26;
            for(var26 = 0; var26 < var4; ++var26) {
               outStream.writeByte(((Class_205)Class_178.var_d50.elementAt(var26)).var_3a);
            }

            for(var26 = 1; var26 < Class_178.var_d34.length; ++var26) {
               int var7;
               Class_205 var27;
               if ((var7 = (var27 = Class_178.var_d34[var26]).var_39c.size()) <= 1) {
                  outStream.writeShort(0);
               } else {
                  Class_240 var8 = (Class_240)var27.var_39c.elementAt(0);
                  short var9 = 0;
                  byte var10 = -1;

                  int var11;
                  for(var11 = 0; var11 < var7; ++var11) {
                     Class_240 var12 = (Class_240)var27.var_39c.elementAt(var11);
                     ++var10;
                     if (var8.var_df != var12.var_df || var10 > 125) {
                        var10 = 0;
                        ++var9;
                        var8 = var12;
                     }
                  }

                  var10 = -1;
                  outStream.writeShort(var9);
                  var11 = 0;
                  int var32 = 0;

                  for(var8 = (Class_240)var27.var_39c.elementAt(0); var11 < var9; ++var32) {
                     ++var10;
                     Class_240 var13 = (Class_240)var27.var_39c.elementAt(var32);
                     if (var8.var_df != var13.var_df || var10 > 125) {
                        outStream.writeByte(var8.var_df);
                        outStream.writeByte(var10);
                        var10 = 0;
                        var8 = var13;
                        ++var11;
                     }
                  }
               }
            }

            for(var26 = 0; var26 < LevelManager.mapWidth; ++var26) {
               for(var6 = 0; var6 < LevelManager.mapHeight; ++var6) {
                  LevelObject var29;
                  if ((var29 = (LevelObject)LevelManager.levelObjectsMap.get(LevelManager.combineInts(var26, var6))) != null) {
                     outStream.writeShort(var29.var_18d);
                     outStream.writeShort(var29.var_1a5);
                     outStream.writeByte(var29.var_22c);
                  }
               }
            }

            outStream.writeByte(LevelManager.var_84c.size());
            Enumeration var28 = LevelManager.var_84c.elements();

            while(var28.hasMoreElements()) {
               LevelObject var31 = (LevelObject)var28.nextElement();
               outStream.writeByte(var31.x);
               outStream.writeByte(var31.y);
               outStream.writeShort(var31.var_18d);
               outStream.writeShort(var31.var_1a5);
               outStream.writeByte(var31.var_1f5);
            }

            byte[] var30 = byteArrOutStream.toByteArray();
            if (var2.getNumRecords() == 0) {
               var2.addRecord(var30, 0, var30.length);
               var20 = false;
            } else {
               var2.setRecord(1, var30, 0, var30.length);
               var20 = false;
            }
            break label352;
         } catch (Exception var24) {
            var20 = false;
         } finally {
            if (var20) {
               try {
                  if (var2 != null) {
                     var2.closeRecordStore();
                  }

                  if (outStream != null) {
                     outStream.close();
                  }
               } catch (Exception var22) {
               }

            }
         }

         try {
            if (var2 != null) {
               var2.closeRecordStore();
            }

            if (outStream != null) {
               outStream.close();
            }

            return;
         } catch (Exception var21) {
            return;
         }
      }

      try {
         if (var2 != null) {
            var2.closeRecordStore();
         }

         outStream.close();
      } catch (Exception var23) {
      }
   }

   public static void sub_8ce() {
      RecordStore var0 = null;
      ByteArrayInputStream var1 = null;
      DataInputStream var2 = null;
      boolean var26 = false;

      label371: {
         label372: {
            try {
               int var5;
               try {
                  var26 = true;
                  var0 = RecordStore.openRecordStore("path", false);
                  var1 = new ByteArrayInputStream(var0.getRecord(1));
                  byte var3 = (var2 = new DataInputStream(var1)).readByte();
                  if (Class_178.var_dc6 != var3) {
                     if (var0 != null) {
                        try {
                           var0.closeRecordStore();
                           var2.close();
                           var1.close();
                        } catch (Exception var29) {
                        }
                     }

                     var0 = null;
                     var2 = null;
                     var1 = null;
                     Class_3d.callGc();
                     var26 = false;
                     break label371;
                  }

                  Class_178.var_e38 = var2.readInt();
                  LevelManager.var_c64 = var2.readByte();

                  for(int var4 = 0; var4 < LevelManager.var_7a3.length; ++var4) {
                     LevelManager.var_7a3[var4] = var2.readInt();
                  }

                  LevelManager.var_7f3 = var2.readInt();
                  LevelManager.var_99f.removeAllElements();
                  byte var33 = var2.readByte();

                  byte var6;
                  Class_205 var7;
                  for(var5 = 0; var5 < var33; ++var5) {
                     var6 = var2.readByte();
                     var7 = Class_178.var_d34[var6];
                     LevelManager.var_99f.addElement(var7);
                     var2.read(var7.var_451);

                     for(int var8 = 0; var8 < var7.var_3fa.length; ++var8) {
                        var7.var_3fa[var8] = var2.readShort();
                     }

                     var7.sub_44c();
                  }

                  var2.read(Class_178.var_d34[0].var_451);
                  Class_178.var_d34[0].sub_44c();
                  Class_178.var_d50.removeAllElements();
                  byte var34 = var2.readByte();

                  int var35;
                  for(var35 = 0; var35 < var34; ++var35) {
                     byte var36 = var2.readByte();
                     Class_178.var_d50.addElement(Class_178.var_d34[var36]);
                  }

                  for(var35 = 1; var35 < Class_178.var_d34.length; ++var35) {
                     var7 = Class_178.var_d34[var35];
                     byte var38 = LevelManager.someLevelDataVar1;
                     byte var9 = LevelManager.someLevelDataVar2;
                     var7.sub_1e();
                     byte var10 = 0;
                     byte var11 = 0;
                     short var12;
                     if ((var12 = var2.readShort()) > 0) {
                        for(int var13 = 0; var13 < var12; ++var13) {
                           byte var14 = var2.readByte();
                           byte var15 = var2.readByte();
                           int var16 = var7.var_39c.size() - 1;

                           for(int var17 = 0; var17 < var15; ++var17) {
                              Class_240 var18;
                              (var18 = (Class_240)var7.var_39c.elementAt(var16 + var17)).var_29 = var38;
                              var18.var_86 = var9;
                              var18.var_df = var14;
                              if (var17 == 0) {
                                 var10 = var18.sub_a2();
                                 var11 = var18.sub_106();
                              }

                              if (var10 == 1) {
                                 var38 = (byte)(var38 + LevelManager.var_3e7[0][var11]);
                                 var9 = (byte)(var9 + LevelManager.var_3e7[1][var11]);
                              }

                              var7.var_39c.addElement(new Class_240(var38, var9, (byte)0, var11, (byte)0));
                           }
                        }

                        var7.var_bb = var38;
                        var7.var_123 = var9;
                        var7.var_17b = var11;
                        var7.var_1a6 = var10;
                     }
                  }

                  int var37;
                  LevelObject var39;
                  for(var35 = 0; var35 < LevelManager.mapWidth; ++var35) {
                     for(var37 = 0; var37 < LevelManager.mapHeight; ++var37) {
                        if ((var39 = (LevelObject)LevelManager.levelObjectsMap.get(LevelManager.combineInts(var35, var37))) != null) {
                           var39.var_18d = var2.readShort();
                           var39.var_1a5 = var2.readShort();
                           var39.var_22c = var2.readByte();
                        }
                     }
                  }

                  LevelManager.var_84c.clear();
                  var6 = var2.readByte();

                  for(var37 = 0; var37 < var6; ++var37) {
                     (var39 = new LevelObject((byte)9, var2.readByte(), var2.readByte(), (byte)3, (byte)0, (byte)0, (byte)0)).var_18d = var2.readShort();
                     var39.var_1a5 = var2.readShort();
                     var39.var_1f5 = var2.readByte();
                     LevelManager.var_84c.put(LevelManager.combineInts(var39.x, var39.y), var39);
                  }

                  var26 = false;
                  break label372;
               } catch (Exception var31) {
                  Class_178.var_dc6 = -1;
                  sub_6da();

                  for(var5 = 0; var5 < Class_178.var_d34.length; ++var5) {
                     Class_178.var_d34[var5].sub_1e();
                     Class_178.var_d34[var5].sub_3e7(false);
                     Class_178.var_d34[var5].sub_41a();
                     Class_178.var_d34[var5].var_29a = 0;
                  }
               }

               var26 = false;
            } finally {
               if (var26) {
                  if (var0 != null) {
                     try {
                        var0.closeRecordStore();
                        if (var2 != null) {
                           var2.close();
                        }

                        if (var1 != null) {
                           var1.close();
                        }
                     } catch (Exception var27) {
                     }
                  }

                  Class_3d.callGc();
               }
            }

            if (var0 != null) {
               try {
                  var0.closeRecordStore();
                  if (var2 != null) {
                     var2.close();
                  }

                  if (var1 != null) {
                     var1.close();
                  }
               } catch (Exception var28) {
               }
            }

            Class_3d.callGc();
            return;
         }

         if (var0 != null) {
            try {
               var0.closeRecordStore();
               var2.close();
               var1.close();
            } catch (Exception var30) {
            }
         }

         Class_3d.callGc();
         return;
      }

      Class_3d.callGc();
   }

   private static void sub_8fa() {
      try {
         RecordStore.deleteRecordStore("path");
         Thread.sleep(1000L);
      } catch (Exception var0) {
      }
   }
}
