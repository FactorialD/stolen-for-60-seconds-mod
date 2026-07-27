package main;
import java.io.DataInputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class LevelManager implements LevelObjectData {
   public static int screenWidth;
   public static int screenHeight;
   public static int var_cf;
   public static GlobalManager instance;
   public static int tilesInScreenX;
   public static int tilesInScreenY;
   public static int mapOffsetX;
   public static int mapOffsetY;
   public static byte mapWidth;
   public static byte mapHeight;
   public static short var_247 = -1;
   public static Image var_25f;
   public static Graphics graphics;
   public static boolean needRepaint = true;
   public static boolean var_314;
   private static boolean var_35f = true;
   private static int totalLootValue;
   public static final short[][] offsetTypes = new short[][]{{-1, 0, 1, 0}, {0, -1, 0, 1}};
   private static final short[][] var_42b = new short[][]{{-1, 1, 1, -1}, {-1, -1, 1, 1}};
   public static final byte[] var_475 = new byte[]{-6, 0, -4, 0, -3, 0, -2, 0, -1, 0, -1, 0};
   public static byte var_4a5;
   public static final short[] var_4e5 = new short[]{0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
   public static final short[][] var_52f = new short[][]{{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, {8, 8, 9, 9, 10, 10, 11, 11, 10, 10, 9, 9}, {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, {168, 168, 169, 169, 170, 170, 171, 171, 171, 171, 170, 170}, {137, 137, 137, 138, 138, 138, 139, 139, 139, 138, 138, 138}, {24, 24, 25, 25, 26, 26, 27, 27, 27, 27, 26, 26}, {40, 40, 41, 42, 43, 43, 43, 43, 42, 42, 41, 41}, {88, 89, 90, 91, 88, 89, 90, 91, 88, 89, 90, 91}, {184, 184, 185, 185, 186, 186, 185, 185, 186, 186, 187, 187}, {56, 56, 57, 57, 58, 58, 59, 59, 57, 57, 59, 59}, {120, 120, 120, 120, 123, 123, 123, 123, 121, 121, 121, 121}, {152, 153, 152, 153, 152, 153, 154, 155, 154, 155, 154, 155}, {104, 104, 105, 105, 106, 106, 107, 107, 106, 106, 105, 105}, {72, 72, 73, 73, 74, 74, 75, 75, 74, 74, 73, 73}, {6}, {136}};
   private static final short[][] var_590 = new short[][]{{0}, {1}, {2}, {3, 5}, {4, 6, 5}, {5}, {6, 5}, {7, 9, 5}, {8, 9, 5}, {9, 5}, {10, 9, 5}, {11, 7, 9, 5}, {12, 9, 5}, {13, 9, 5}, {14}, {15, 14}};
   private static final byte[][] var_5cd = new byte[][]{{1, 0, 1, 0, -1}, {1, -1, -1, 1, 1}};
   public static final TimelineNode[][] var_619 = new TimelineNode[][]{{new TimelineNode((byte)0, (byte)0, (byte)1, (byte)0, (byte)0), new TimelineNode((byte)0, (byte)0, (byte)1, (byte)1, (byte)0), new TimelineNode((byte)0, (byte)0, (byte)0, (byte)1, (byte)0)}, {new TimelineNode((byte)0, (byte)0, (byte)1, (byte)3, (byte)0), new TimelineNode((byte)0, (byte)0, (byte)0, (byte)3, (byte)0), new TimelineNode((byte)0, (byte)0, (byte)0, (byte)3, (byte)0)}, {new TimelineNode((byte)0, (byte)0, (byte)1, (byte)0, (byte)0), new TimelineNode((byte)0, (byte)0, (byte)1, (byte)3, (byte)0), new TimelineNode((byte)0, (byte)0, (byte)0, (byte)3, (byte)0)}, {new TimelineNode((byte)0, (byte)0, (byte)1, (byte)1, (byte)0), new TimelineNode((byte)0, (byte)0, (byte)0, (byte)1, (byte)0), new TimelineNode((byte)0, (byte)0, (byte)0, (byte)1, (byte)0)}, {new TimelineNode((byte)0, (byte)0, (byte)1, (byte)2, (byte)0), new TimelineNode((byte)0, (byte)0, (byte)1, (byte)1, (byte)0), new TimelineNode((byte)0, (byte)0, (byte)0, (byte)1, (byte)0)}};
   // Legacy data kept for backward compatibility if magic number is missing
   public static final byte[][] var_64c = new byte[][]{{0}, {1}, {2, 1}, {3}, {4}, {5}, {6}, {7, 3}, {8, 3}, {9}, {10}, {11}, {12}, {13}, {14, 13}, {15, 14, 13}, {16, 23}, {-1}, {18, 23}, {-1}, {-1}, {21, 26, 10}, {22}, {23}, {24, 23}, {-1}, {26, 10}, {27, 26, 10}, {28, 5}};
   public static final short[][] levelAdditionalData_TimerEtc = new short[][]{{500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 50, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 9}, {500, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 50, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 10}, {500, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 50, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 11}, {500, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 300, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 12}, {500, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 11100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 13}, {140, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1800, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 14}, {140, 0, 3, 0, 5, 0, 9, 0, 0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 15, 35}, {200, 12, 5, 0, 15, 0, 22, 0, 1, 0, 1, 10, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 16, 36}, {260, 0, 0, 50, 40, 0, 30, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 17}, {250, 0, 30, 60, 20, 0, 50, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 18}, {160, 100, 0, 0, 0, 0, 50, 1, 0, 0, 1, 30, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 19, 37}, {320, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 40, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 20, 38}, {230, 0, 0, 0, 10, 250, 70, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 21}, {150, 0, 43, 50, 10, 0, 35, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 33}, {200, 45, 26, 0, 3, 0, 60, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 22}, {320, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 23}, {150, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 26}, {185, 0, 0, 0, 65, 0, 50, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 24}, {210, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 45, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 32, 39}, {340, 0, 0, 0, 0, 150, 80, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 25}, {180, 0, 70, 0, 40, 0, 60, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 28}, {110, 0, 0, 70, 0, 0, 55, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 31}, {240, 0, 0, 0, 0, 0, 70, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 27}, {135, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 30}, {130, 100, 0, 0, 0, 0, 50, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 29}, {170, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 50, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 34, 40}};
   public static byte[][] thiefStats = new byte[][]{{18, 0, 0}, {30, 20, 30}, {25, 15, 12}, {22, 12, 10}, {20, 10, 8}};
   public static short[][] var_71c = new short[][]{{0, 0}, {1000, 2}, {1000, 1}, {1000, 0}, {1000, 1}, {1000, 3}};
   private static byte[][] mapArray; // > 12: Стены/препятствия. <= 12: Проходимый пол.
   public static int[] lootValues = new int[6];
   public static int[] var_7a3 = new int[7];
   public static int var_7f3;
   public static final Hashtable levelObjectsMap = new Hashtable();
   public static final Hashtable levelObjects = new Hashtable();
   public static final Hashtable var_896 = new Hashtable();
   public static final Hashtable alarmWithZonesMap = new Hashtable();
   public static final Hashtable var_8ff = new Hashtable();
   public static byte selectedThiefIndex;
   public static byte var_96a;
   public static Thief selectedThief;
   public static final Vector thievesList = new Vector();
   public static final Vector var_9d3 = new Vector();
   public static final byte[] var_a1e = new byte[]{116, 116, 116};
   public static byte gameState;
   private static boolean var_a93;
   private static boolean var_aad;
   private static boolean var_b0a;
   private static boolean var_b69;
   public static byte exitX;
   public static byte exitY;
   public static final int[] var_c58 = new int[]{0, 16711680, 65280, 255, 16711935};
   public static byte winState; // 0: Игра идет.  2: Победа (ушли с лутом).  5: Провал (поймали/время вышло).
   public static int timeLimitSeconds;
   public static int var_c9e;
   private static int var_cdc;
   private static int var_cf8;
   public static boolean var_d39;
   public static boolean var_d55;
   private static int var_d80;
   private static int var_dc9;
   private static int var_de4;
   private static int var_e2f;
   public static byte cameraState; //0: Свободная камера / слежение за вором.  1, 3, 4: Автоматический скроллинг (паннинг) к выходу или событию.
   private static boolean var_e7f;
   
   // --- NEW FIELDS FOR EXTENDED FORMAT ---
   public static byte winType; // 0=Loot, 1=Object
   public static byte winTargetX;
   public static byte winTargetY;
   
   public static int requiredLootAmount;
   public static boolean allowChief;
   // --------------------------------------

   public static void loadLootConfiguration() {
      try {
         java.io.InputStream is = MM.getResourceStream("/dat/loot_type.dat");
         if (is != null) {
            java.io.DataInputStream dis = new java.io.DataInputStream(is);
            for(int i = 0; i < 6; i++) {
               var_71c[i][0] = dis.readShort();
               var_71c[i][1] = dis.readShort();
            }
            dis.close();
         }
      } catch (Exception e) {}
   }
   

   public static void loadThiefConfiguration() {
      try {
         java.io.InputStream is = MM.getResourceStream("/dat/thieves.dat");
         if (is != null) {
            java.io.DataInputStream dis = new java.io.DataInputStream(is);
            for(int i = 0; i < 5; i++) {
               thiefStats[i][0] = dis.readByte(); // Strength
               thiefStats[i][1] = dis.readByte(); // Speed
               thiefStats[i][2] = dis.readByte(); // Stealth
            }
            dis.close();
         }
      } catch (Exception e) {}
   }

   public static void switchLevelToActionMode() {
      GlobalManager.loadResourcesForState(1);
      GlobalManager.musicManager.switchMusicPlayer(1, -1);
      GlobalManager.var_ff4 = null;
      GlobalManager.var_6bc = false;
      GlobalManager.keyCodePressed = 999999;
      selectedThiefIndex = -1;
      gameState = 0;
      thievesList.removeElement(GlobalManager.allThievesArray[0]);
      if (thievesList.size() > 0) {
         selectThief(-1);
      } else {
         selectedThief = null;
      }

      setCameraPos(exitX, exitY, true, false, false);
      sub_3d2();
      GlobalManager.gameState = 1;
      needRepaint = true;
   }

   public static void initLevelInPlanningMode() {
	   if (thievesList.size() == 0 && !allowChief) {
         GlobalManager.showDialog((byte)0, (byte[])null, (short)167, (Object[])null, new short[]{126}, (short)137);
      } else {
         GlobalManager.musicManager.switchMusicPlayer(3, -1);
         var_25f = null;
         GlobalManager.threadSleep(10L);
         graphics = null;
         GlobalManager.loadResourcesForState(0);
         sub_c2();
         HackManager.callGc();
         GlobalManager.threadSleep(50L);
         GlobalManager.gameState = 1;
         var_25f = Image.createImage(screenWidth, screenHeight);
         graphics = var_25f.getGraphics();
         HackManager.callGc();
         GlobalManager.threadSleep(10L);
         GlobalManager.var_ff4 = null;
         var_a93 = false;
         var_aad = false;
         var_b0a = false;
         var_b69 = false;
         gameState = 1;
         GlobalManager.var_17e = 0;
         GlobalManager.var_e86 = GlobalManager.currentMoney;
         var_c9e = timeLimitSeconds;
         GlobalManager.var_6bc = false;
         var_9d3.removeAllElements();
         Enumeration var0 = thievesList.elements();

         while(var0.hasMoreElements()) {
            Thief var1;
            (var1 = (Thief)var0.nextElement()).sub_2a1();
            var_9d3.addElement(var1);
         }

         int var2;
         for(var2 = 0; var2 < 3; ++var2) {
            var_a1e[var2] = GlobalManager.allThievesArray[0].inventoryTools[var2];
         }

         GlobalManager.possibleThieves.removeAllElements();
         var0 = GlobalManager.selectedThieves.elements();

         while(var0.hasMoreElements()) {
            GlobalManager.possibleThieves.addElement(var0.nextElement());
         }

         sub_140(alarmWithZonesMap, var_8ff);
         sub_f0(levelObjects, var_896);
         levelObjects.clear();
         sub_192(false);
         // Use allowChief flag to determine if Chief joins
         if (GlobalManager.gameMode > -1 || GlobalManager.levelId == 6 || allowChief) {
            thievesList.addElement(GlobalManager.allThievesArray[0]);
            GlobalManager.allThievesArray[0].resetToSpawn();
         }

         selectedThiefIndex = (byte)(thievesList.size() - 1);
         selectedThief = sub_b2d();
         Thief.globalTimer = 0;
         GlobalManager.var_17e = 0;
         setCameraPos(selectedThief.positionX, selectedThief.positionY, true, false, false);
         sub_3d2();
         var_de4 = 2;
         cameraState = 5;
         totalLootValue = 0;
         var_cdc = screenWidth;

         for(var2 = 0; var2 < Thief.exitAnimationProgress.length; ++var2) {
            Thief.exitAnimationProgress[var2] = 0;
         }

         sub_702();
      }
   }

   private static void sub_c2() {
      if (!var_e7f) {
         int var0 = ReadingDrawingClass.mainImages[6].getHeight() * ReadingDrawingClass.mainImages[6].getWidth() / 576;

         int var1;
         int var2;
         for(var1 = 0; var1 < var_52f.length; ++var1) {
            for(var2 = 0; var2 < var_590[var1].length && var_52f[var1][0] >= var0; ++var2) {
               var_52f[var1] = var_52f[var_590[var1][var2 + 1]];
            }
         }

         var0 = ReadingDrawingClass.mainImages[5].getHeight() * ReadingDrawingClass.mainImages[5].getWidth() / 576;

         for(var1 = 0; var1 < LevelObjectData.spriteIndexes.length; ++var1) {
            for(var2 = 0; var2 < var_64c[var1].length && LevelObjectData.spriteIndexes[var1][0] >= var0; ++var2) {
               if (var_64c[var1][0] == -1) {
                  LevelObjectData.spriteIndexes[var1][0] = LevelObjectData.spriteIndexes[var1][1] = LevelObjectData.spriteIndexes[var1][2] = LevelObjectData.spriteIndexes[var1][3] = (byte)var0;
                  LevelObjectData.spriteIndexes[var1][4] = -1;
                  break;
               }

               LevelObjectData.spriteIndexes[var1][0] = LevelObjectData.spriteIndexes[var_64c[var1][var2 + 1]][0];
               LevelObjectData.spriteIndexes[var1][1] = LevelObjectData.spriteIndexes[var_64c[var1][var2 + 1]][1];
               LevelObjectData.spriteIndexes[var1][2] = LevelObjectData.spriteIndexes[var_64c[var1][var2 + 1]][2];
               LevelObjectData.spriteIndexes[var1][3] = LevelObjectData.spriteIndexes[var_64c[var1][var2 + 1]][3];
               LevelObjectData.spriteIndexes[var1][5] = ReadingDrawingClass.sub_6b7(LevelObjectData.spriteIndexes[var1][5], (byte)6, ReadingDrawingClass.checkBit(LevelObjectData.spriteIndexes[var_64c[var1][var2 + 1]][5], (byte)6));
               LevelObjectData.spriteIndexes[var1][5] = ReadingDrawingClass.sub_6b7(LevelObjectData.spriteIndexes[var1][5], (byte)7, ReadingDrawingClass.checkBit(LevelObjectData.spriteIndexes[var_64c[var1][var2 + 1]][5], (byte)7));
               LevelObjectData.spriteIndexes[var1][6] = LevelObjectData.spriteIndexes[var_64c[var1][var2 + 1]][6];
            }
         }

         var_e7f = true;
      }
   }

   public static void sub_f0(Hashtable var0, Hashtable var1) {
      var1.clear();
      Enumeration var2 = var0.elements();

      while(var2.hasMoreElements()) {
         LevelObject var3 = (LevelObject)var2.nextElement();
         LevelObject var4;
         (var4 = new LevelObject(var3.objectType, var3.x, var3.y, var3.offsetType, (byte)0, var3.var_1f5, var3.var_22c)).interactionTickTimestamp = var3.interactionTickTimestamp;
         var4.var_1a5 = var3.var_1a5;
         var1.put(combineInts(var3.x, var3.y), var4);
      }

   }

   public static void sub_140(Hashtable var0, Hashtable var1) {
      var1.clear();
      Enumeration var2 = var0.keys();

      while(var2.hasMoreElements()) {
         Integer var3 = (Integer)var2.nextElement();
         Integer var4 = (Integer)var0.get(var3);
         var1.put(var3, var4);
      }

   }

   private static void finishLevel() {
      GlobalManager.var_ff4 = null;
      cameraState = 0;
      if (winState == 5) {
         thievesList.removeElement(GlobalManager.allThievesArray[0]);
         GlobalManager.showDialog((byte)36, (byte[])null, (short)155, (Object[])null, new short[]{126}, (short)142);
      } else {
         if (winState == 4) {
            thievesList.removeElement(GlobalManager.allThievesArray[0]);
            GlobalManager.var_ea3 = 153;
         } else {
            if (winState == 2) {
               short var4;
               if (GlobalManager.selectedThieves.contains(GlobalManager.allThievesArray[0]) && !thievesList.isEmpty()) {
                  var4 = 157;
               } else {
                  var4 = 154;
               }

               GlobalManager.showDialog((byte)36, new byte[]{48, 0}, var4, (Object[])null, new short[]{126}, (short)142);
               GlobalManager.musicManager.switchMusicPlayer(4, 1);
               return;
            }

            int var0 = 0;

            int var1;
            for(var1 = 0; var1 < thievesList.size(); ++var1) {
               Thief var2 = (Thief)thievesList.elementAt(var1);
               var0 += var2.collectedLoot[1] * var_71c[1][0] + var2.collectedLoot[2] * var_71c[2][0] + var2.collectedLoot[3] * var_71c[3][0] + var2.collectedLoot[4] * var_71c[4][0] + var2.collectedLoot[5] * var_71c[5][0];
               var2.sub_41a();
               var2.sub_44c();
            }

            thievesList.removeElement(GlobalManager.allThievesArray[0]);
            var1 = 0;
            if (var0 > 0) {
               if (winState == 3) {
                  var0 -= totalLootValue;
               }

               for(int var5 = thievesList.size() - 1; var5 >= 0; --var5) {
                  Thief var3 = (Thief)thievesList.elementAt(var5);
                  var1 += var0 * thiefStats[var3.thiefId][1] / 100;
               }

               GlobalManager.currentMoney += var0 - var1;
               GlobalManager.var_ea3 = (short)(totalLootValue > 0 ? 151 : 150);
               GlobalManager.var_eff = new Object[]{new Integer(100 * var0 / lootValues[0]), new Integer(var0), new Integer(var0 - var1)};
            } else {
               GlobalManager.var_ea3 = 152;
            }
         }

         GlobalManager.var_1217 = 3;
      }
   }

   public static void sub_192(boolean var0) {
      Enumeration var1 = levelObjectsMap.elements();

      while(var1.hasMoreElements()) {
         ((LevelObject)var1.nextElement()).sub_c6(var0);
      }

   }

   public static void sub_1aa() {
      tilesInScreenX = screenWidth / 24 - 1 - tilesInScreenX % 2;
      tilesInScreenY = screenHeight / 24 - 1 - tilesInScreenY % 2;
   }

   public static Integer combineInts(int high, int low) {
      return new Integer(high << 8 | low);
   }

   public static void loadLevel(byte level) {
      timeLimitSeconds = 180;
      winType = 0;
      winTargetX = 0;
      winTargetY = 0;
      requiredLootAmount = 0;
      allowChief = false;
      levelObjectsMap.clear();
      levelObjects.clear();
      alarmWithZonesMap.clear();
      DataInputStream dataInputStream = null;

      try {
    	 dataInputStream = ReadingDrawingClass.getLevelDataStream(level);
    	 // Two first bytes is height and width
    	  
    	 // Read height and width
         mapWidth = dataInputStream.readByte();
         mapHeight = dataInputStream.readByte();
         
         mapArray = new byte[mapWidth][mapHeight];
         byte[] levelDataBytesBuffer = new byte[mapWidth * mapHeight];
         dataInputStream.readFully(levelDataBytesBuffer);
         

         // Filling map array with data from dataBytes
         int tmpCounter = 0;
         for(int i = 0; i < mapHeight; ++i) {
            for(int j = 0; j < mapWidth; ++j) {
               mapArray[j][i] = levelDataBytesBuffer[tmpCounter++];
            }
         }

         //At next, read all object on map
         
         // Read next two bytes as 16-bit number
         // Then multiply it by 7 and thus get length of next data block
         // Read this data block
         short objectBaseLength = dataInputStream.readShort();
         levelDataBytesBuffer = new byte[objectBaseLength  * 7];
         dataInputStream.readFully(levelDataBytesBuffer);

         // Puts in HashTable object,
         // Key - 2nd + 3rd bytes as Short - coordinates of game object
         // and value is object with data of 1-7 bytes
         for(tmpCounter = 0; tmpCounter < objectBaseLength; ++tmpCounter) {
            int index = tmpCounter * 7;
            levelObjectsMap.put(
            		combineInts(levelDataBytesBuffer[index + 1], levelDataBytesBuffer[index + 2]), //hash key is coordinates
            		new LevelObject(
            				levelDataBytesBuffer[index++], //type of object
            				levelDataBytesBuffer[index++], //x
            				levelDataBytesBuffer[index++], //y
            				levelDataBytesBuffer[index++], 
            				levelDataBytesBuffer[index++], 
            				levelDataBytesBuffer[index++], 
            				levelDataBytesBuffer[index]));
         }

         // Read next byte for next data object length
         // it is count of alarms with zones 
         byte alarmsCount = dataInputStream.readByte();

         // for that byte, read next 2 bytes and combine them
         for(tmpCounter = 0; tmpCounter < alarmsCount; ++tmpCounter) {
            Integer alarmCoods = combineInts(dataInputStream.readByte(), dataInputStream.readByte());
            
            // then read next byte (its count of alarm zones)
            // and for that byte create new buffer of its size
            // and from that buffer read paired bytes in HashTable (coords of alarm zones)
            byte alarmZonesCount = dataInputStream.readByte();
            levelDataBytesBuffer = new byte[alarmZonesCount];
            dataInputStream.readFully(levelDataBytesBuffer);

            for(int i = 0; i < alarmZonesCount; i += 2) {
               alarmWithZonesMap.put(combineInts(levelDataBytesBuffer[i], levelDataBytesBuffer[i + 1]), alarmCoods);
            }
         }
         
         //read next byte and if it > 0
         // then read 2 more bytes and write it to some variables
         // then read (skip) one short and write one more byte to some variable

         if (dataInputStream.readByte() > 0) {
            exitX = (byte)dataInputStream.readShort();
            exitY = (byte)dataInputStream.readShort();
            int magic = dataInputStream.readUnsignedShort(); // MAGIC number location
            timeLimitSeconds = dataInputStream.readShort();
            
            if (magic == 0x7777) {
                // Extended format
                int startMoney = dataInputStream.readInt();
                int requiredLoot = dataInputStream.readInt();
                byte thievesMask = dataInputStream.readByte();
                
                requiredLootAmount = requiredLoot;
                allowChief = (thievesMask & 16) != 0; // Bit 4
                
                winType = dataInputStream.readByte();
                winTargetX = dataInputStream.readByte();
                winTargetY = dataInputStream.readByte();
                
                
                // Informant Hint Costs
                var_7f3 = dataInputStream.readInt(); // Alarm
                var_7a3 = new int[7]; 
                // Read 6 hints (5 loot + 1 general)
                for(int k=1; k<=6; k++) {
                    var_7a3[k] = dataInputStream.readInt();
                }
                
                // Briefing Text ID override
                short textId = dataInputStream.readShort();
                if (level > 0 && level <= levelAdditionalData_TimerEtc.length) {
                    levelAdditionalData_TimerEtc[level - 1][25] = textId;
                }
                
               // Custom Text Reading
                try {
                    if (dataInputStream.available() > 0) {
                        int strLen = dataInputStream.readUnsignedShort();
                        if (strLen > 0) {
                            byte[] strBytes = new byte[strLen];
                            dataInputStream.readFully(strBytes);
                            String customText = new String(strBytes, "UTF-8");
                            // Magic constant 32000 for custom text
                            ReadingDrawingClass.setCustomText((short)32000, customText);
                            if (level > 0 && level <= levelAdditionalData_TimerEtc.length) {
                                levelAdditionalData_TimerEtc[level - 1][25] = (short)32000;
                            }
                        }
                    }
                } catch (Exception e) {}
                
                // Update money if first time or not campaign
                if (GlobalManager.gameMode == -1) {
                    GlobalManager.currentMoney = startMoney;
                }
                
                // Apply allowed thieves configuration to the static legacy array used by GlobalManager menu logic
                if (level > 0 && level <= levelAdditionalData_TimerEtc.length) {
                   short[] legacyData = levelAdditionalData_TimerEtc[level - 1];
                   legacyData[7] = (short)((thievesMask & 1) != 0 ? 1 : 0); // Thief 1
                   legacyData[8] = (short)((thievesMask & 2) != 0 ? 1 : 0); // Thief 2
                   legacyData[9] = (short)((thievesMask & 4) != 0 ? 1 : 0); // Thief 3
                   legacyData[10] = (short)((thievesMask & 8) != 0 ? 1 : 0); // Thief 4
                }
            } else {
                // Legacy Fallback
                loadLegacyData(level);
            }
         } else {
                loadLegacyData(level);
         }
      } catch (Exception var16) {
      } finally {
         try {
            if (dataInputStream != null) {
               dataInputStream.close();
            }
         } catch (Exception var15) {
         }

         HackManager.callGc();
      }

      lootValues = new int[6];
      Hashtable var18 = new Hashtable();
      Enumeration levelObjectsList = levelObjectsMap.elements();

      LevelObject var20;
      Integer var21;
      Integer[] var25;
      while(levelObjectsList.hasMoreElements()) {
         var20 = (LevelObject)levelObjectsList.nextElement();
         var25 = new Integer[3];
         if (var20.var_22c > 0 && var20.var_1f5 != 0 && ReadingDrawingClass.checkBit(LevelObjectData.spriteIndexes[var20.objectType][5], (byte)4)) {
            var21 = combineInts(var20.var_1f5, var20.var_22c);
            if (var18.containsKey(var21)) {
               (var25 = (Integer[])((Integer[])var18.get(var21)))[0] = new Integer(var20.var_22c);
               var25[1] = new Integer(var25[1].intValue() + 1);
               var25[2] = var25[1];
               var18.remove(var21);
               var18.put(var21, var25);
            } else {
               var25[0] = new Integer(var20.var_22c);
               var25[1] = new Integer(1);
               var25[2] = new Integer(1);
               var18.put(var21, var25);
            }
         }
      }

      levelObjectsList = levelObjectsMap.elements();

      while(true) {
         while(true) {
            do {
               do {
                  do {
                     do {
                        if (!levelObjectsList.hasMoreElements()) {
                           levelObjectsList = levelObjectsMap.elements();

                           while(levelObjectsList.hasMoreElements()) {
                              var20 = (LevelObject)levelObjectsList.nextElement();
                              if (ReadingDrawingClass.checkBit(LevelObjectData.spriteIndexes[var20.objectType][5], (byte)4) && var20.var_1f5 < 6) {
                                 int[] var27 = lootValues;
                                 var27[0] += var20.var_22c * var_71c[var20.var_1f5][0];
                                 var27 = lootValues;
                                 byte var28 = var20.var_1f5;
                                 var27[var28] += var20.var_22c * var_71c[var20.var_1f5][0];
                              }
                           }

                           lootValues[0] = lootValues[0] / 1000 * 1000;
                           // Legacy random time override
                           // timeLimitSeconds = levelAdditionalData_TimerEtc[level - 1][0] + ReadingDrawingClass.randomRange(0, 10);
                           return;
                        }
                     } while((var20 = (LevelObject)levelObjectsList.nextElement()).var_22c <= 0);
                  } while(var20.var_1f5 == 0);
               } while(!ReadingDrawingClass.checkBit(LevelObjectData.spriteIndexes[var20.objectType][5], (byte)4));

               var21 = combineInts(var20.var_1f5, var20.var_22c);
            } while(!var18.containsKey(var21));

            if ((var25 = (Integer[])((Integer[])var18.get(var21)))[1].intValue() > 1) {
               var20.var_22c = 0;
               if (var25[1].intValue() == 2 && var25[2].intValue() == 2) {
                  int var23;
                  if ((var23 = ReadingDrawingClass.randomRange(0, 2)) == 1) {
                     var20.var_22c = (byte)ReadingDrawingClass.randomRange(0, var25[0].intValue());
                  } else if (var23 == 2) {
                     var20.var_22c = (byte)var25[0].byteValue();
                  }
               } else if (ReadingDrawingClass.randomRange(0, 1) == 1) {
                  var20.var_22c = (byte)Math.min(ReadingDrawingClass.randomRange(0, var25[0].intValue() >> 1), var25[0].intValue());
               }

               var25[0] = new Integer(var25[0].intValue() - var20.var_22c);
               var25[1] = new Integer(var25[1].intValue() - 1);
               var18.remove(var21);
               var18.put(var21, var25);
            } else if (var25[1].intValue() == 1) {
               var20.var_22c = var25[0].byteValue();
               var25[0] = new Integer(0);
               var25[1] = new Integer(0);
               var18.remove(var21);
               var18.put(var21, var25);
            } else {
               var20.var_22c = 0;
            }
         }
      }
   }
   
   private static void loadLegacyData(byte level) {
	      if (level > 0 && level <= levelAdditionalData_TimerEtc.length) {
	          var_7a3 = new int[]{
	                  0, 
	                  levelAdditionalData_TimerEtc[level - 1][1] * 100, 
	                  levelAdditionalData_TimerEtc[level - 1][2] * 100, 
	                  levelAdditionalData_TimerEtc[level - 1][3] * 100, 
	                  levelAdditionalData_TimerEtc[level - 1][4] * 100, 
	                  levelAdditionalData_TimerEtc[level - 1][5] * 100, 
	                  levelAdditionalData_TimerEtc[level - 1][11] * 100
	          };
	          var_7f3 = levelAdditionalData_TimerEtc[level - 1][6] * 100;
	          
	          if (GlobalManager.gameMode == -1) {
	             GlobalManager.currentMoney = levelAdditionalData_TimerEtc[level - 1][12];
	          }
	      }
	   }

   public static void paint(Graphics g) {
      if (graphics != null) {
         GlobalManager.needRepaint = true;
         if (needRepaint && (mapWidth * 24 < screenWidth || mapHeight * 24 < var_cf)) {
            graphics.setColor(gameState == 0 ? 0 : 10066329);
            graphics.setClip(0, 0, screenWidth, screenHeight);
            graphics.fillRect(0, 0, screenWidth, screenHeight);
         }

         drawMap(g);
         if (gameState == 1) {
            drawAllObjects(g);
            sub_38e(g);
         }

         drawThieves(g);
         if (gameState == 1) {
            sub_3a8(g);
         }

         drawHud(g);
         sub_33b(g);
         GlobalManager.sub_94f(g, GlobalManager.cursorXCurrent, GlobalManager.var_bca, false);
         needRepaint = false;
         var_35f = false;
         if (var_314) {
            needRepaint = true;
            var_314 = false;
         }

         GlobalManager.needRepaint = false;
      }
   }

   private static void drawHud(Graphics g) {
      g.setClip(0, screenHeight - LevelObjectData.spriteTypesArr[9][3], screenWidth, LevelObjectData.spriteTypesArr[9][3]);
      g.drawImage(var_25f, 0, 0, 0);
      if (gameState == 1 && selectedThief != null && selectedThief.targetObject != null && selectedThief.isInteracting()) {
         byte var1 = selectedThief.actionState == 5 ? 1 : selectedThief.targetObject.objectType;
         byte var2 = selectedThief.actionState == 3 ? 8 : Thief.toolUsingTimeStats[var1][GlobalManager.sub_e5c(selectedThief.inventoryTools[selectedThief.selectedToolSlot])];
         selectedThief.targetObject.drawTimerCircle(g, var2, selectedThief.actionState != 3);
      }

      if (selectedThief != null) {
         int var9 = screenWidth < 130 ? 2 : 4;
         ReadingDrawingClass.drawSpriteNoOffset(g, (byte)24, 0, var9, screenHeight - LevelObjectData.spriteTypesArr[24][3]);
         ReadingDrawingClass.drawSpriteNoOffset(g, (byte)5, selectedThief.thiefId, var9 + (LevelObjectData.spriteTypesArr[24][2] >> 1) - (LevelObjectData.spriteTypesArr[5][2] >> 1), screenHeight - LevelObjectData.spriteTypesArr[24][3] + (LevelObjectData.spriteTypesArr[24][3] >> 1) - (LevelObjectData.spriteTypesArr[5][3] >> 1) + 1);
         if (gameState == 0 && GlobalManager.var_80 > 6 && selectedThief.currentLoad < selectedThief.projectedLoad) {
            int var10 = screenHeight - LevelObjectData.spriteTypesArr[9][3];
            int var3 = LevelObjectData.spriteTypesArr[9][3] - LevelObjectData.spriteTypesArr[26][3] + 1 >> 1;
            int var4;
            int var5 = (var4 = var9 + LevelObjectData.spriteTypesArr[24][2] + var9) + 1;
            int var6 = var10 + var3 + 1;
            int var7 = LevelObjectData.spriteTypesArr[25][2] - 2;
            int var8 = LevelObjectData.spriteTypesArr[25][3] - 2;
            ReadingDrawingClass.drawSpriteNoOffset(g, (byte)25, 0, var4, var10 + var3);
            g.setColor(0);
            g.setClip(0, 0, screenWidth, screenHeight);
            g.fillRect(var5, var6, var7, var8 - var8 * selectedThief.projectedLoad / thiefStats[selectedThief.thiefId][0]);
         }
      }

   }

   public static void sub_2df(Graphics var0, boolean var1) {
      int var2 = screenHeight - LevelObjectData.spriteTypesArr[9][3];
      int var3 = LevelObjectData.spriteTypesArr[9][3] - LevelObjectData.spriteTypesArr[26][3] + 1 >> 1;
      int var4 = 0;
      int var5 = screenWidth < 130 ? 2 : 4;
      if (selectedThief == null) {
         var1 = true;
      }

      while(var4 < screenWidth) {
         ReadingDrawingClass.drawSpriteNoOffset(var0, (byte)(var1 ? 9 : 12), 0, var4, var2);
         var4 += LevelObjectData.spriteTypesArr[var1 ? 9 : 12][2];
      }

      if (selectedThief != null) {
         ReadingDrawingClass.drawSpriteNoOffset(var0, (byte)24, 0, var5, screenHeight - LevelObjectData.spriteTypesArr[24][3]);
         ReadingDrawingClass.drawSpriteNoOffset(var0, (byte)5, selectedThief.thiefId, var5 + (LevelObjectData.spriteTypesArr[24][2] >> 1) - (LevelObjectData.spriteTypesArr[5][2] >> 1), screenHeight - LevelObjectData.spriteTypesArr[24][3] + (LevelObjectData.spriteTypesArr[24][3] >> 1) - (LevelObjectData.spriteTypesArr[5][3] >> 1) + 1);
         int var6 = (var4 = var5 + LevelObjectData.spriteTypesArr[24][2] + var5) + 1;
         int var7 = var2 + var3 + 1;
         int var8 = LevelObjectData.spriteTypesArr[25][2] - 2;
         int var9 = LevelObjectData.spriteTypesArr[25][3] - 2;
         ReadingDrawingClass.drawSpriteNoOffset(var0, (byte)25, 0, var4, var2 + var3);
         var4 += LevelObjectData.spriteTypesArr[25][2] + var5;

         for(int var10 = 0; var10 < selectedThief.inventoryTools.length; ++var10) {
            ReadingDrawingClass.drawSpriteNoOffset(var0, (byte)26, 0, var4, var2 + var3);
            if (selectedThief.inventoryTools[var10] != 116) {
               ReadingDrawingClass.drawSpriteNoOffset(var0, (byte)8, GlobalManager.sub_e5c(selectedThief.inventoryTools[var10]), var4 + 2, var2 + var3 + 2);
            }

            var4 += LevelObjectData.spriteTypesArr[26][2] + var5;
         }

         var0.setColor(0);
         var0.setClip(0, 0, screenWidth, screenHeight);
         var0.fillRect(var6, var7, var8, var9 - var9 * selectedThief.currentLoad / thiefStats[selectedThief.thiefId][0]);
      } else {
         DialogManager.sub_388(var0, 2, var2 + DialogManager.var_ac, 1, 4);
         var4 = 2 + LevelObjectData.spriteTypesArr[38][2] + 5;
         ReadingDrawingClass.sub_47c(var0, ReadingDrawingClass.readTextFromLng((short)262), var4, var2 + (LevelObjectData.spriteTypesArr[9][3] >> 1) - (ReadingDrawingClass.var_a9 >> 1));
      }
   }

   private static void sub_33b(Graphics var0) {
      if (selectedThief != null) {
         int var1 = Thief.globalTimer / 60;
         int var2 = Thief.globalTimer - var1 * 60;
         int var3;
         if (gameState == 1) {
            var3 = timeLimitSeconds - 30;
         } else {
            var3 = levelAdditionalData_TimerEtc[GlobalManager.levelId - 1][0] + 0;
         }

         String var5 = String.valueOf(var1) + ':' + (var2 < 10 ? "0" : "") + var2;
         if (ReadingDrawingClass.useSystemFont) {
            int var6 = 5 * ReadingDrawingClass.var_12 + 4;
            int var7 = ReadingDrawingClass.var_a9 + 4;
            var0.setClip(0, 0, screenWidth, screenHeight);
            var0.setColor(11446175);
            var0.fillRect(screenWidth - var6 - 2, screenHeight - LevelObjectData.spriteTypesArr[9][3] - var7 + 4, var6, var7);
            if (Thief.globalTimer > var3 && GlobalManager.var_80 > 6) {
               var0.setColor(16711680);
               var0.fillRect(screenWidth - var6 - 2, screenHeight - LevelObjectData.spriteTypesArr[9][3] - var7 + 4, var6, var7);
            }

            ReadingDrawingClass.sub_46a(var0, var5, screenWidth - var6 - 2 + (var6 - var5.length() * ReadingDrawingClass.var_12 >> 1), screenHeight - LevelObjectData.spriteTypesArr[9][3] - var7 + 2 + 4);
         } else {
            ReadingDrawingClass.drawSpriteNoOffset(var0, (byte)27, 0, screenWidth - LevelObjectData.spriteTypesArr[27][2] - 2, screenHeight - LevelObjectData.spriteTypesArr[9][3] - 10);
            if (Thief.globalTimer > var3 && GlobalManager.var_80 > 6) {
               var0.setColor(16711680);
               var0.fillRect(screenWidth - LevelObjectData.spriteTypesArr[27][2] - 2 + 4, screenHeight - LevelObjectData.spriteTypesArr[9][3] - 10 + 4, LevelObjectData.spriteTypesArr[27][2] - 8, LevelObjectData.spriteTypesArr[27][3] - 4);
            }

            ReadingDrawingClass.sub_46a(var0, var5, screenWidth - LevelObjectData.spriteTypesArr[27][2] - 2 + (LevelObjectData.spriteTypesArr[27][2] - 4 * ReadingDrawingClass.var_12 >> 1), screenHeight - LevelObjectData.spriteTypesArr[9][3] - 10 + 4);
         }
      }
   }

   private static void sub_38e(Graphics var0) {
      if (gameState == 1) {
         ReadingDrawingClass.drawSpriteNoOffset(var0, (byte)(var_d39 ? 20 : 21), 0, var_cdc + 17, var_cf8 + 19);
         ReadingDrawingClass.drawSpriteNoOffset(var0, (byte)(var_d55 ? 22 : 23), 0, var_cdc + 17, var_cf8 + 5 - LevelObjectData.spriteTypesArr[var_d55 ? 22 : 23][3]);
      }

   }

   private static void sub_3a8(Graphics var0) {
      if (gameState == 1) {
         ReadingDrawingClass.drawSprite(var0, 10, 0, var_cdc, var_cf8, 0, 0, 0, var_cf8 + LevelObjectData.spriteTypesArr[46][3] - var_cf);
         ReadingDrawingClass.drawSpriteNoOffset(var0, (byte)14, 0, var_d80, var_dc9);
      } else if (needRepaint && var_cf8 <= var_cf) {
         ReadingDrawingClass.drawSprite(graphics, 46, 0, var_cdc, var_cf8, 0, 0, 0, var_cf8 + LevelObjectData.spriteTypesArr[46][3] - var_cf);
         graphics.setClip(0, 0, screenWidth, screenHeight);
      }
   }

   public static void sub_3d2() {
      if (cameraState == 0 || cameraState == 2) {
         var_cdc = mapOffsetX + exitX * 24 - 12;
         var_cf8 = mapOffsetY + exitY * 24;
      }

      if (cameraState != 4) {
         var_d80 = -LevelObjectData.spriteTypesArr[14][2];
         var_dc9 = var_cf8;
      }

      switch(cameraState) {
      case 0:
         return;
      case 1:
         var_cdc -= var_de4++;
         if (var_cdc + 48 < 0 && var_e2f++ > 48) {
            finishLevel();
            return;
         }
         break;
      case 2:
         var_de4 = 1;
         return;
      case 3:
         var_cdc -= var_de4++;
         if (var_cdc + 48 < 0 && var_e2f++ > 48) {
            if (Thief.globalTimer > timeLimitSeconds - 30) {
               sub_7b0();
               var_e2f = 0;
               cameraState = 4;
               var_de4 = 2;
               return;
            }

            finishLevel();
            return;
         }
         break;
      case 4:
         int var0;
         if ((var0 = mapOffsetX + exitX * 24 - 12 - 4 - (var_d80 + LevelObjectData.spriteTypesArr[14][2])) > 0) {
            var_d80 += Math.max(var_de4, 1);
            if (var0 < 15) {
               --var_de4;
            }
         } else {
            ++var_e2f;
         }

         var_dc9 = var_cf8;
         if (var_e2f > 48) {
            finishLevel();
            return;
         }
         break;
      case 5:
         var_cdc -= var_de4;
         if (var_cdc <= mapOffsetX + exitX * 24 - 12) {
            GlobalManager.musicManager.switchMusicPlayer(2, -1);
            cameraState = 0;
         }
      }

   }

   private static void drawThieves(Graphics var0) {
      if (thievesList.size() != 0) {
         var_d55 = false;
         var_d39 = false;
         Enumeration var1 = thievesList.elements();

         while(var1.hasMoreElements()) {
            ((Thief)var1.nextElement()).sub_1f3(var0);
         }

         if (cameraState == 2 || cameraState == 3) {
            var1 = GlobalManager.selectedThieves.elements();

            while(var1.hasMoreElements()) {
               Thief var2 = (Thief)var1.nextElement();
               if (!GlobalManager.possibleThieves.contains(var2)) {
                  var2.actionState = 0;
                  var2.sub_1f3(var0);
               }
            }
         }

      }
   }

   private static void drawAllObjects(Graphics g) {
      if (levelObjects.size() > 0) {
         Enumeration allObjects;
         if (gameState == 1) {
            allObjects = levelObjects.elements();

            while(allObjects.hasMoreElements()) {
               ((LevelObject)allObjects.nextElement()).drawObject(g);
            }
         }

         if (gameState == 0) {
            allObjects = levelObjects.elements();

            while(allObjects.hasMoreElements()) {
               LevelObject levelObject = (LevelObject)allObjects.nextElement();
               if (levelObject.interactionTickTimestamp - 5 <= Thief.globalTimer) {
                  levelObject.drawObject(g);
               }
            }
         }
      }

   }

   private static void drawMap(Graphics g) {
      if (needRepaint) {
         var_35f = true;
         int spriteTypeId = gameState == 0 ? 2 : 0;
         int var3;
         int var4 = (var3 = -mapOffsetX / 24) + tilesInScreenX + 2;
         int var5;
         int var6 = (var5 = -mapOffsetY / 24) + tilesInScreenY + 2;
         boolean[] var9 = new boolean[4];
         if (gameState == 1) {
            boolean var11 = false;

            for(int var12 = var5; var12 <= var6; ++var12) {
               for(int var13 = var3; var13 <= var4; ++var13) {
                  if (var13 >= 0 && var13 < mapWidth && var12 >= 0 && var12 < mapHeight && getTileAt(var13, var12, false) <= 12) {
                     var9[0] = var9[1] = var9[2] = var9[3] = false;

                     int var7;
                     byte var10;
                     for(var7 = 0; var7 < 4; ++var7) {
                        if ((var10 = getTileAt(var13 + offsetTypes[0][var7], var12 + offsetTypes[1][var7], true)) > 12) {
                           if ((var7 == 0 || var7 == 2) && (var10 == 14 || var10 == 15)) {
                              var10 = 13;
                           }

                           if ((var7 == 1 || var7 == 3) && (var10 == 17 || var10 == 18)) {
                              var10 = 16;
                           }

                           ReadingDrawingClass.drawSprite(graphics, spriteTypeId, var10, mapOffsetX + var13 * 24, mapOffsetY + var12 * 24, var7 == 2 ? 12 : 0, var7 == 0 ? 12 : 0, var7 == 3 ? 12 : 0, var7 == 1 ? 12 : 0);
                           var9[var7] = var9[var7 == 0 ? 3 : var7 - 1] = true;
                        }
                     }

                     for(var7 = 0; var7 < 4; ++var7) {
                        if (!var9[var7]) {
                           label300: {
                              if ((var10 = getTileAt(var13 + var_42b[0][var7], var12 + var_42b[1][var7], true)) > 12) {
                                 if (var10 == 14 || var10 == 15) {
                                    var10 = 13;
                                 }

                                 if (var10 != 17 && var10 != 18) {
                                    break label300;
                                 }
                              }

                              var10 = 16;
                           }

                           ReadingDrawingClass.drawSprite(graphics, spriteTypeId, var10, mapOffsetX + var13 * 24, mapOffsetY + var12 * 24, var_42b[0][var7] == -1 ? 0 : 12, var_42b[0][var7] == 1 ? 0 : 12, var_42b[1][var7] == -1 ? 0 : 12, var_42b[1][var7] == 1 ? 0 : 12);
                        }
                     }
                  }
               }
            }
         }

         for(int i = var5; i <= var6; ++i) {
            for(int j = var3; j <= var4; ++j) {
               byte mapTileCode;
               if (j >= 0 && j < mapWidth && i >= 0 && i < mapHeight) {
                  mapTileCode = mapArray[j][i];
                  if (gameState == 0 && mapTileCode > 12) {
                     mapTileCode = 13;
                  }
               } else {
                  mapTileCode = 16;
                  if (gameState == 0) {
                     mapTileCode = 14;
                  }
               }

               Integer var22 = combineInts(j, i);
               LevelObject var25 = null;
               boolean var14 = false;
               if (levelObjectsMap.containsKey(var22)) {
                  var14 = (var25 = (LevelObject)levelObjectsMap.get(var22)) != null && (var25.objectType == 1 || var25.objectType == 2);
               }

               // MODDED: Always draw the floor tile.
               // Original code skipped floor drawing if (var14 == true) i.e., if a door was present.
               // With transparent PNG objects, this causes black voids.
               // We remove the !var14 check to ensure the floor is always drawn underneath.
               
               if (gameState == 0) {
                   ReadingDrawingClass.drawSpriteNoOffset(graphics, (byte)spriteTypeId, 13, mapOffsetX + j * 24, mapOffsetY + i * 24);
               }
               ReadingDrawingClass.drawSpriteNoOffset(graphics, (byte)spriteTypeId, mapTileCode, mapOffsetX + j * 24, mapOffsetY + i * 24);
               

               if (gameState == 0 && alarmWithZonesMap.containsKey(var22) && var_7f3 == 0) {
                  ReadingDrawingClass.drawSpriteNoOffset(graphics, (byte)spriteTypeId, (byte)(15 + ((LevelObject)levelObjectsMap.get(alarmWithZonesMap.get(var22))).var_22c), mapOffsetX + j * 24, mapOffsetY + i * 24);
               }

               if (var25 != null) {
                  var25.drawObject(graphics);
               }
            }
         }

         if (gameState == 0) {
            graphics.setClip(0, 0, screenWidth, screenHeight);
            Enumeration var21 = thievesList.elements();

            while(var21.hasMoreElements()) {
               Thief var23;
               (var23 = (Thief)var21.nextElement()).projectedLoad = var23.currentLoad;
               byte var27 = 0;

               for(int var28 = 0; var28 < Thief.globalTimer && var28 < var23.recordedActions.size(); ++var28) {
                  TimelineNode var26;
                  if ((var26 = var23.sub_ff(var28)).getAction() == 1 && var26.x >= var3 && var26.x <= var4 && var26.y >= var5 && var26.y <= var6) {
                     short var15 = offsetTypes[0][var26.getDirection()];
                     short var16 = offsetTypes[1][var26.getDirection()];
                     int var17 = mapOffsetX + var26.x * 24;
                     int var18 = mapOffsetY + var26.y * 24;
                     graphics.setColor(var_c58[var23.thiefId]);

                     for(int var19 = 0; var19 < 24; var19 += 2) {
                        graphics.fillRect(var17 + 12 - 1 + var23.thiefId + var19 * var15, var18 + 12 - 1 + var23.thiefId + var19 * var16, 2, 2);
                     }
                  }

                  if (selectedThief != null && var23.thiefId == selectedThief.thiefId) {
                     if ((var26.getAction() == 3 || var26.getAction() == 4 && var23.inventoryTools[var26.getToolSlot()] == 115) && var27 != var26.packedData) {
                        var27 = var26.packedData;
                        byte var29 = var23.positionX;
                        byte var30 = var23.positionY;
                        byte var31 = var23.direction;
                        var23.positionX = var26.x;
                        var23.positionY = var26.y;
                        var23.direction = var26.getDirection();
                        var23.targetObject = sub_912(var23);
                        var23.positionX = var29;
                        var23.positionY = var30;
                        var23.direction = var31;
                        if (var23.targetObject != null && var23.targetObject.var_1f5 != 0 && var23.targetObject.var_22c > 0 && var_7a3[var23.targetObject.var_1f5] <= 0) {
                           var23.projectedLoad = (byte)(var23.projectedLoad + var_71c[var23.targetObject.var_1f5][1]);
                        }
                     } else if (var27 != var26.packedData) {
                        var27 = 0;
                     }

                     if (var26.x == exitX && var26.y == exitY) {
                        var23.projectedLoad = var23.currentLoad;
                     }
                  }
               }
            }

            sub_3a8(graphics);
            drawAllObjects(graphics);
         }
      }

      if (var_35f) {
         sub_2df(graphics, false);
      }

      g.drawImage(var_25f, 0, 0 - var_4a5, 0);
   }

   private static byte getTileAt(int var0, int var1, boolean var2) {
      if (var0 >= 0 && var0 < mapWidth && var1 >= 0 && var1 < mapHeight) {
         byte var3;
         if ((var3 = mapArray[var0][var1]) <= 12) {
            return var3;
         } else {
            LevelObject var4;
            if ((var4 = (LevelObject)levelObjectsMap.get(combineInts(var0, var1))) != null && (var4.objectType == 1 || var4.objectType == 2)) {
               var3 = 12;
            }

            return var3;
         }
      } else {
         return (byte)(var2 ? 12 : 16);
      }
   }

   public static boolean checkWallCollision(Thief thief, boolean var1) {
      if (!thief.calculateNextPosition()) {
         return false;
      } else if (Thief.targetY == exitY && (Thief.targetX == exitX - 1 || Thief.targetX == exitX + 1)) {
         return false;
      } else {
         boolean var2;
         if ((var2 = mapArray[Thief.targetX][Thief.targetY] > 12) && !var1) {
            Enumeration var3 = thievesList.elements();

            label59: {
               int var5;
               int var6;
               do {
                  do {
                     do {
                        Thief var4;
                        do {
                           if (!var3.hasMoreElements()) {
                              break label59;
                           }
                        } while((var4 = (Thief)var3.nextElement()).stunTimer > 0);

                        var5 = var4.positionX;
                        var6 = var4.positionY;
                        if (var4.actionState == 1 && var4 != thief) {
                           var5 = var4.positionX + offsetTypes[0][var4.direction];
                           var6 = var4.positionY + offsetTypes[1][var4.direction];
                        }
                     } while(var5 != Thief.targetX);
                  } while(var6 != Thief.targetY);
               } while(var5 == exitX && var6 == exitY);

               var2 = false;
            }

            if (var2 && gameState == 1) {
               sub_538(combineInts(Thief.targetX, Thief.targetY));
            }
         }

         return var2;
      }
   }

   public static boolean checkObjectInteraction(Thief thief, boolean var1) {
      if (!thief.calculateNextPosition()) {
         return false;
      } else {
         Integer var2 = combineInts(Thief.targetX, Thief.targetY);
         boolean var3;
         if (var3 = levelObjectsMap.containsKey(var2)) {
            LevelObject var4;
            if ((var4 = (LevelObject)levelObjectsMap.get(var2)).objectType == 20 || var4.objectType == 25) {
               return false;
            }

            if (var4.objectType == 6 && (var_7f3 > 0 || var4.interactionTickTimestamp > 0 && var4.interactionTickTimestamp <= Thief.globalTimer)) {
               return false;
            }

            if (var4.objectType == 4 && var1 && (var_7a3[5] > 0 || var4.interactionTickTimestamp > 0 && var4.interactionTickTimestamp <= Thief.globalTimer)) {
               return false;
            }

            if (var4.objectType == 1 || var4.objectType == 2) {
               if (!var1 && var4.progressData[0] <= 0) {
                  return false;
               }

               if (var1 && var4.interactionTickTimestamp > 0 && var4.interactionTickTimestamp <= Thief.globalTimer) {
                  return false;
               }
            }
         }

         return var3;
      }
   }

   private static void sub_538(Integer var0) {
      if (alarmWithZonesMap.containsKey(var0)) {
         if (GlobalManager.gameMode == -1) {
            winState = 5;
            GlobalManager.showDialog((byte)39, (byte[])null, (short)156, (Object[])null, new short[]{126}, (short)137);
         } else {
            if (!var_a93) {
               timeLimitSeconds = Math.min(timeLimitSeconds, Thief.globalTimer + ReadingDrawingClass.randomRange(20, 30));
               var_a93 = true;
               GlobalManager.showDialog((byte)0, (byte[])null, (short)146, (Object[])null, new short[]{126}, (short)137);
            }

         }
      }
   }

   private static void sub_574(boolean var0) {
      if (!var_a93) {
         if (var0) {
            if (!var_b0a) {
               if (var_aad) {
                  timeLimitSeconds -= ReadingDrawingClass.randomRange(0, 30);
               } else {
                  timeLimitSeconds -= ReadingDrawingClass.randomRange(30, 50);
               }

               var_b0a = true;
               return;
            }
         } else if (!var_aad && !var_b0a) {
            timeLimitSeconds -= ReadingDrawingClass.randomRange(10, 30);
            var_aad = true;
         }

      }
   }

   public static void sub_585(Thief var0, boolean var1) {
      Enumeration var2 = thievesList.elements();

      while(true) {
         while(true) {
            Thief var3;
            do {
               if (!var2.hasMoreElements()) {
                  sub_6bc();
                  return;
               }
            } while((var3 = (Thief)var2.nextElement()).thiefId == var0.thiefId);

            if (var3.recordedActions.size() <= Thief.globalTimer) {
               var3.timelineIndex = (short)(var3.recordedActions.size() - 1);
               var3.applyTimelineState(true);
            } else {
               var3.timelineIndex = Thief.globalTimer;
               var3.applyTimelineState(true);
               if (var3.actionState != 0) {
                  var3.timelineIndex = (short)(Thief.globalTimer + 1);
                  var3.applyTimelineState(true);
                  byte var4 = var3.actionState;
                  var3.timelineIndex = Thief.globalTimer;
                  var3.applyTimelineState(true);
                  var3.isBusy = var1;
                  if (var3.actionState == 1 && instance.mapInputToGameAction(GlobalManager.keyCodePressed) == 1) {
                     var3.positionX = (byte)(var3.positionX + offsetTypes[0][var3.direction]);
                     var3.positionY = (byte)(var3.positionY + offsetTypes[1][var3.direction]);
                  }

                  if (var3.actionState == 4 && var4 != 4 || var3.actionState == 3 && var4 != 3) {
                     sub_702();
                  }
               }
            }
         }
      }
   }

   private static void sub_5a5(Thief var0) {
      if (gameState == 0) {
         int var1 = 0;
         int var2 = 0;
         if (var0.actionState == 1) {
            var1 = offsetTypes[0][var0.direction] * (var0.moveInterpolation * 24 / 12);
            var2 = offsetTypes[1][var0.direction] * (var0.moveInterpolation * 24 / 12);
         }

         int var4 = mapOffsetX + var0.positionX * 24 + var1;
         int var5 = mapOffsetY + var0.positionY * 24 + var2;
         graphics.setColor(var_c58[var0.thiefId]);
         graphics.setClip(0, 0, screenWidth, var_cf);
         graphics.fillRect(var4 + 12 - 1 + var0.thiefId, var5 + 12 - 1 + var0.thiefId, 2, 2);
      }

   }

   public static void updateGameLogic() {
      if (var_247 != -1) {
         short var0 = var_247;
         var_247 = -1;
         switch(var0) {
         case 185:
            GlobalManager.showDialog((byte)0, new byte[]{5, selectedThief.thiefId}, (short)185, (Object[])null, new short[]{126}, (short)(41 + selectedThief.thiefId));
            return;
         case 186:
            GlobalManager.showDialog((byte)0, new byte[]{5, selectedThief.thiefId}, (short)186, (Object[])null, new short[]{126}, (short)(41 + selectedThief.thiefId));
            return;
         }
      }

      if (selectedThief != null) {
         if (selectedThiefIndex == -1) {
            selectedThief = null;
            sub_702();
         } else {
            if (gameState == 1 && GlobalManager.var_91 == 0 && cameraState != 5) {
               ++Thief.globalTimer;
               if (Thief.globalTimer > timeLimitSeconds - 10 && GlobalManager.gameMode > -1 && !var_b69) {
                  GlobalManager.musicManager.switchMusicPlayer(6, -1);
                  var_b69 = true;
               } else if (Thief.globalTimer == timeLimitSeconds - 1 && GlobalManager.gameMode > -1) {
                  if (exitX == GlobalManager.allThievesArray[0].positionX && exitY == GlobalManager.allThievesArray[0].positionY && !GlobalManager.allThievesArray[0].isBusy && cameraState == 0) {
                     checkWinCondition();
                  }
               } else if (Thief.globalTimer > timeLimitSeconds) {
                  if (GlobalManager.gameMode == -1) {
                     winState = 5;
                     finishLevel();
                  } else if (cameraState == 0) {
                     winState = 2;
                     var_de4 = 4;
                     var_e2f = 0;
                     sub_7b0();
                     sub_3d2();
                     cameraState = 4;
                  }
               }
            }

            Enumeration var5 = thievesList.elements();

            while(var5.hasMoreElements() && cameraState != 5) {
               Thief var1 = (Thief)var5.nextElement();
               if (selectedThief.thiefId == var1.thiefId && cameraState == 0) {
                  setCameraPos(var1.positionX, var1.positionY, false, false, false);
               }

               if (var1.stunTimer > 0) {
                  ++var1.moveInterpolation;
                  if (var1.moveInterpolation >= 12) {
                     var1.moveInterpolation = 0;
                     --var1.stunTimer;
                  }
               } else {
                  if (var1.isBusy) {
                     if (selectedThief.thiefId == var1.thiefId && GlobalManager.keyCodePressed == 999999) {
                        GlobalManager.var_9af = 999999;
                     }

                     ++var1.moveInterpolation;
                     sub_5a5(var1);
                     if (var1.moveInterpolation >= 12) {
                        var1.moveInterpolation = 0;
                        if (var1.actionState == 1) {
                           var1.positionX = (byte)(var1.positionX + offsetTypes[0][var1.direction]);
                           var1.positionY = (byte)(var1.positionY + offsetTypes[1][var1.direction]);
                           var1.isBusy = false;
                           if (var1.positionX == exitX && var1.positionY == exitY) {
                              sub_65f();
                           }
                        }

                        if (gameState == 0 || var1.actionState == 2) {
                           var1.isBusy = false;
                        }

                        if (var1.targetObject != null) {
                           if (gameState == 0) {
                              var1.isBusy = false;
                              var1.targetObject = null;
                           } else if (gameState == 1) {
                              label210: {
                                 switch(var1.actionState) {
                                 case 3:
                                    if (var1.targetObject.progressData[1] > 0 && var1.targetObject.progressData[0] <= 0) {
                                       --var1.targetObject.progressData[1];
                                       if (var1.targetObject.progressData[1] > 0) {
                                          break label210;
                                       }

                                       var1.collectLoot();
                                       needRepaint = true;
                                    }
                                    break;
                                 case 4:
                                    if (var1.targetObject.progressData[0] <= 0) {
                                       var1.sub_1ba(var1.actionState, var1.direction);
                                       var1.isBusy = false;
                                       var1.targetObject = null;
                                       break label210;
                                    }

                                    --var1.targetObject.progressData[0];
                                    if (var1.targetObject.progressData[0] > 0) {
                                       break label210;
                                    }

                                    if (var1.targetObject.objectType == 6) {
                                       Integer var2 = combineInts(var1.targetObject.x, var1.targetObject.y);
                                       Enumeration var3 = alarmWithZonesMap.keys();

                                       while(var3.hasMoreElements()) {
                                          Integer var4 = (Integer)var3.nextElement();
                                          if (var2.equals(alarmWithZonesMap.get(var4))) {
                                             alarmWithZonesMap.remove(var4);
                                          }
                                       }
                                    } else if (var1.targetObject.objectType == 4) {
                                       if (var1.collectLoot()) {
                                          var1.targetObject.progressData[1] = 0;
                                       } else if (var1.targetObject.var_22c == 0) {
                                          var1.targetObject.progressData[0] = 0;
                                          var1.targetObject.progressData[1] = 0;
                                       } else {
                                          var1.targetObject.progressData[0] = Thief.toolUsingTimeStats[4][GlobalManager.sub_e5c(var1.inventoryTools[var1.selectedToolSlot])];
                                          var1.targetObject.progressData[1] = 8;
                                       }
                                    }

                                    sub_538(combineInts(var1.targetObject.x, var1.targetObject.y));
                                    needRepaint = true;
                                    break;
                                 case 5:
                                    if (var1.targetObject.progressData[0] > 0) {
                                       --var1.targetObject.progressData[0];
                                       if (var1.targetObject.progressData[0] <= 0) {
                                          var1.targetObject.progressData[1] = 5;
                                          needRepaint = true;
                                          break;
                                       }
                                    }
                                 default:
                                    break label210;
                                 }

                                 var1.sub_1ba(var1.actionState, var1.direction);
                                 var1.isBusy = false;
                                 var1.targetObject = null;
                              }
                           }
                        }
                     }
                  }

                  if (!var1.isBusy) {
                     if (gameState != 1) {
                        if (selectedThief.thiefId == var1.thiefId && var1.handleInputAndCollision()) {
                           var1.isBusy = true;
                           sub_585(var1, true);
                           var1.addWaitAction((byte)1);
                           ++Thief.globalTimer;
                        }
                     } else {
                        if (var1.thiefId == 0) {
                           if (cameraState != 2 && cameraState != 3) {
                              if (selectedThief.thiefId == var1.thiefId && cameraState == 0) {
                                 var1.handleInputAndCollision();
                              }
                           } else {
                              var1.applyTimelineState(false);
                           }
                        } else {
                           var1.applyTimelineState(false);
                        }

                        if (var1.actionState != 0) {
                           if (var1.actionState == 1) {
                              if (!checkObjectInteraction(var1, false) && checkWallCollision(var1, false)) {
                                 var1.actionState = 1;
                                 ++var1.timelineIndex;
                                 if (cameraState == 2) {
                                    int var10002 = Thief.exitAnimationProgress[var1.thiefId]++;
                                 }

                                 var1.isBusy = true;
                              } else {
                                 var1.actionState = 2;
                              }
                           } else if (var1.actionState == 2) {
                              if (var1.thiefId != 0) {
                                 var1.isBusy = true;
                                 ++var1.timelineIndex;
                              }
                           } else {
                              var1.targetObject = sub_912(var1);
                              if (var1.targetObject != null) {
                                 var1.moveInterpolation = (byte)ReadingDrawingClass.randomRange(0, 6);
                                 if (var1.actionState == 5) {
                                    byte var6 = var1.targetObject.objectType;
                                    var1.targetObject = new LevelObject((byte)9, var1.positionX, var1.positionY, var1.direction, (byte)0, var1.inventoryTools[var1.selectedToolSlot], (byte)0);
                                    var1.targetObject.progressData[0] = Thief.toolUsingTimeStats[var6][GlobalManager.sub_e5c(var1.inventoryTools[var1.selectedToolSlot])];
                                    levelObjects.put(combineInts(var1.positionX, var1.positionY), var1.targetObject);
                                    ++var1.timelineIndex;
                                    var1.isBusy = true;
                                    needRepaint = true;
                                 } else if (var1.actionState == 4) {
                                    if (var1.targetObject.progressData[0] == 120) {
                                       var1.targetObject.progressData[0] = Thief.toolUsingTimeStats[var1.targetObject.objectType][GlobalManager.sub_e5c(var1.inventoryTools[var1.selectedToolSlot])];
                                    }

                                    ++var1.timelineIndex;
                                    var1.isBusy = true;
                                 } else if (var1.actionState == 3) {
                                    ++var1.timelineIndex;
                                    var1.isBusy = true;
                                 } else {
                                    var1.actionState = 2;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            sub_68d();
            sub_3d2();
            if (gameState == 1) {
               GlobalManager.sub_1b8((byte)6, (byte)-1, (byte)0, false);
            } else {
               GlobalManager.sub_1b8((byte)4, (byte)-1, (byte)0, false);
            }
         }
      }
   }

   private static void sub_65f() {
      if (gameState != 1) {
         if (selectedThief != null && selectedThief.positionX == exitX && selectedThief.positionY == exitY) {
            selectedThief.projectedLoad = selectedThief.currentLoad;
         }
      } else {
         boolean var0 = true;
         int var1 = thievesList.size() - 1;

         while(true) {
            if (var1 < 0) {
               if (!var0) {
                  return;
               }

               if (cameraState != 2) {
                  if (cameraState == 0) {
                     GlobalManager.showDialog((byte)17, (byte[])null, (short)173, (Object[])null, new short[]{126, 127}, (short)137);
                  }

                  return;
               }

               sub_7b0();
               var_de4 = 1;
               var_e2f = 0;
               cameraState = 3;
               break;
            }

            Thief var2;
            if ((var2 = (Thief)thievesList.elementAt(var1)).positionX == exitX && var2.positionY == exitY) {
               var2.sub_44c();
               if (var2.thiefId == 0 && selectedThief.thiefId == 0) {
                  GlobalManager.keyCodePressed = 999999;
                  GlobalManager.var_9af = 999999;
               }
            } else {
               var0 = false;
            }

            --var1;
         }
      }

   }

   private static void sub_68d() {
      if (levelObjects.size() > 0 && gameState == 1) {
         Enumeration var0 = levelObjects.elements();

         while(true) {
            LevelObject var1;
            do {
               do {
                  do {
                     if (!var0.hasMoreElements()) {
                        return;
                     }
                  } while((var1 = (LevelObject)var0.nextElement()).progressData[0] > 0);

                  ++var1.var_22c;
               } while(var1.var_22c < 12);

               var1.var_22c = 0;
            } while(var1.progressData[1] < 0);

            --var1.progressData[1];
            if (var1.progressData[1] == 0) {
               sub_75c(var1.x, var1.y, false, false, 0, var1.var_1f5 == 114, false);
               if (var1.var_1f5 == 114) {
                  sub_75c(var1.x, var1.y, false, false, 0, var1.var_1f5 == 114, true);
               }

               Enumeration var2 = thievesList.elements();

               while(var2.hasMoreElements()) {
                  Thief var3;
                  if (Math.abs((var3 = (Thief)var2.nextElement()).positionX - var1.x) <= 1 && Math.abs(var3.positionY - var1.y) <= 1) {
                     var3.stunTimer = 10;
                  }
               }

               needRepaint = true;
            }

            if (var1.progressData[1] < 0) {
               var_4a5 = 0;
            }
         }
      }
   }

   private static void sub_6bc() {
      if (levelObjects.size() > 0 && gameState == 0) {
         Enumeration var0 = levelObjects.elements();

         while(var0.hasMoreElements()) {
            if (((LevelObject)var0.nextElement()).interactionTickTimestamp == Thief.globalTimer + 1) {
               sub_702();
            }
         }
      }

   }

   public static void sub_702() {
      needRepaint = true;
      if (GlobalManager.needRepaint) {
         var_314 = true;
      }

   }

   public static void sub_75c(int var0, int var1, boolean var2, boolean var3, int var4, boolean var5, boolean var6) {
      for(int var9 = 0; var9 < 4; ++var9) {
         int var7 = var0 + (var6 ? var_42b[0][var9] : offsetTypes[0][var9]);
         int var8 = var1 + (var6 ? var_42b[1][var9] : offsetTypes[1][var9]);
         Integer var10 = combineInts(var7, var8);
         if (levelObjectsMap.containsKey(var10)) {
            if (!var2) {
               sub_538(var10);
               sub_574(var5);
            }

            LevelObject var11;
            if ((var11 = (LevelObject)levelObjectsMap.get(var10)).objectType != 6 && var11.objectType != 9 && var11.objectType != 4 && !ReadingDrawingClass.checkBit(LevelObjectData.spriteIndexes[var11.objectType][5], (byte)5) && (var5 || mapArray[var11.x][var11.y] > 12 || sub_ae6(var11, var0, var1))) {
               if (var2) {
                  if (var3) {
                     if (var11.interactionTickTimestamp == var4) {
                        var11.interactionTickTimestamp = 0;
                     }
                  } else if (var11.interactionTickTimestamp > var4 || var11.interactionTickTimestamp == 0) {
                     var11.interactionTickTimestamp = (short)var4;
                  }
               } else {
                  var11.progressData[0] = 0;
               }
            }
         }
      }

   }

   private static void sub_7b0() {
      setCameraPos(exitX, exitY, true, false, false);
   }

   private static void setCameraPos(int var0, int var1, boolean var2, boolean var3, boolean var4) {
      int oldX = mapOffsetX;
      int oldY = mapOffsetY;

      int pixelX = var0 * 24 + 12;
      int pixelY = var1 * 24 + 12;

      // Враховуємо плавну анімацію вора, якщо камера слідує за ним і він РУХАЄТЬСЯ
      if (selectedThief != null && selectedThief.positionX == var0 && selectedThief.positionY == var1) {
         // Враховуємо зміщення лише якщо стан вора відповідає руху (зазвичай 1 або 2)
         // Якщо він зламує (стан дії > 2), ми не рухаємо камеру за анімацією на місці
         if (selectedThief.actionState == 1 || selectedThief.actionState == 2) {
            pixelX += offsetTypes[0][selectedThief.direction] * (selectedThief.moveInterpolation * 24 / 12);
            pixelY += offsetTypes[1][selectedThief.direction] * (selectedThief.moveInterpolation * 24 / 12);
         }
      }

      int targetOffsetX;
      int targetOffsetY;

      // Розрахунок цільового зміщення по горизонталі
      if (mapWidth * 24 <= screenWidth) {
         targetOffsetX = screenWidth - tilesInScreenX * 24 >> 1;
      } else {
         targetOffsetX = (screenWidth >> 1) - pixelX;
         // Обмеження межами мапи
         if (targetOffsetX > 0) targetOffsetX = 0;
         if (targetOffsetX < -(mapWidth * 24 - screenWidth)) targetOffsetX = -(mapWidth * 24 - screenWidth);
      }

      // Розрахунок цільового зміщення по вертикалі
      if (mapHeight * 24 < var_cf) {
         targetOffsetY = var_cf - tilesInScreenY * 24 >> 1;
      } else {
         targetOffsetY = (var_cf >> 1) - pixelY;
         // Обмеження межами мапи
         if (targetOffsetY > 0) targetOffsetY = 0;
         if (targetOffsetY < -(mapHeight * 24 - var_cf)) targetOffsetY = -(mapHeight * 24 - var_cf);
      }

      // Якщо встановлено прапорець негайного переміщення (var2 або var3), копіюємо координати миттєво
      if (var2 || var3) {
         mapOffsetX = targetOffsetX;
         mapOffsetY = targetOffsetY;
      } else {
         // Плавне наближення до цілі (smoothing)
         // Використовуємо коефіцієнт 4 для м'якого фільтрування тремтіння
         int dx = targetOffsetX - mapOffsetX;
         int dy = targetOffsetY - mapOffsetY;

         if (dx > 0) mapOffsetX += (dx + 3) / 4;
         else if (dx < 0) mapOffsetX += (dx - 3) / 4;

         if (dy > 0) mapOffsetY += (dy + 3) / 4;
         else if (dy < 0) mapOffsetY += (dy - 3) / 4;
      }

      // Якщо позиція змінилася — оновлюємо необхідні буфери
      if (oldX != mapOffsetX || oldY != mapOffsetY) {
         sub_3d2();
         sub_702();
      }
   }

   public static void sub_85b() {
      if (selectedThief != null) {
         if (gameState != 0 || !selectedThief.isBusy) {
            if (GlobalManager.keyCodePressed != 999999 && cameraState == 0) {
               Thief var1;
               switch(instance.mapInputToGameAction(GlobalManager.keyCodePressed)) {
               case 0:
                  if (gameState == 0 && (GlobalManager.var_80 == 0 || GlobalManager.var_80 == 6 || GlobalManager.var_80 == 3 || GlobalManager.var_80 == 9) && GlobalManager.var_165 > 2) {
                     var1 = sub_b2d();
                     if (Thief.globalTimer > 0) {
                        GlobalManager.var_165 = 3;
                        var1.undoLastAction();
                        sub_585(var1, false);
                        sub_702();
                     }

                     return;
                  }
                  break;
               case 1:
                  if (gameState == 0 && Thief.globalTimer < 599 && (GlobalManager.var_80 == 0 || GlobalManager.var_80 == 6 || GlobalManager.var_80 == 3 || GlobalManager.var_80 == 9) && GlobalManager.var_165 > 2) {
                     GlobalManager.var_165 = 3;
                     (var1 = sub_b2d()).actionState = 2;
                     var1.addActionToTimeline((byte)1, false);
                     var1.isBusy = false;
                     sub_702();
                  }
               }

            }
         }
      }
   }

   public static void sub_896() {
      if (GlobalManager.keyCodePressed != 999999 && cameraState == 0) {
         if (gameState != 0 || selectedThief == null || !selectedThief.isBusy) {
            GlobalManager.var_9af = GlobalManager.keyCodePressed;
            int var0;
            if ((var0 = instance.mapInputToGameAction(GlobalManager.keyCodePressed)) == 12) {
               if (selectedThief == null) {
                  if (thievesList.size() == 0) {
                     GlobalManager.var_1217 = 3;
                  } else {
                     GlobalManager.keyCodePressed = 999999;
                     selectThief(var_96a);
                  }
               }
            } else if (var0 == 13) {
               if (selectedThief != null) {
                  if (gameState == 0) {
                     GlobalManager.sub_1b8((byte)7, (byte)-1, (byte)0, true);
                     GlobalManager.var_6bc = false;
                     return;
                  }

                  GlobalManager.sub_1b8((byte)8, (byte)-1, (byte)0, true);
               }

               return;
            }

            if (GlobalManager.var_12fc) {
               GlobalManager.var_12fc = false;
            }

            int var2;
            if (selectedThief == null) {
               int var8 = 0;
               var2 = 0;
               switch(var0) {
               case 0:
                  if (thievesList.size() == 0) {
                     GlobalManager.var_1217 = 3;
                     return;
                  }

                  GlobalManager.keyCodePressed = 999999;
                  selectThief(var_96a);
                  return;
               case 1:
               default:
                  return;
               case 2:
                  var2 = -(var_cf >> 1);
                  break;
               case 3:
                  var2 = var_cf >> 1;
                  break;
               case 4:
                  var8 = -(screenWidth >> 1);
                  break;
               case 5:
                  var8 = screenWidth >> 1;
               }

               setCameraPos(var8, var2, false, false, true);
            } else {
               Thief var7;
               switch(var0) {
               case 0:
                  if (gameState == 0) {
                     var7 = sub_b2d();
                     if (Thief.globalTimer > 0) {
                        var7.undoLastAction();
                        sub_585(var7, false);
                        sub_702();
                        GlobalManager.var_165 = 1;
                     }

                     return;
                  }

                  return;
               case 1:
                  if (gameState == 0 && Thief.globalTimer < 599) {
                     (var7 = sub_b2d()).actionState = 2;
                     var7.addActionToTimeline((byte)1, false);
                     var7.isBusy = false;
                     GlobalManager.var_165 = 1;
                     sub_702();
                     return;
                  }

                  return;
               case 2:
               case 3:
               case 4:
               case 5:
               case 8:
               default:
                  return;
               case 6:
                  LevelObject var1;
                  if (gameState == 0 && (var1 = sub_912(selectedThief)) != null) {
                     var2 = 0;

                     for(int var3 = 0; var3 < 12; ++var3) {
                        if (Thief.toolUsingTimeStats[var1.objectType][var3] > 0) {
                           ++var2;
                        }
                     }

                     if (var2 > 0) {
                        byte[][] var9 = new byte[var2][2];
                        short[] var4 = new short[var2];
                        Object[][] var5 = new Object[var2][1];
                        var2 = 0;

                        for(int var6 = 0; var6 < 12; ++var6) {
                           if (Thief.toolUsingTimeStats[var1.objectType][var6] > 0) {
                              var9[var2][0] = 8;
                              var9[var2][1] = (byte)GlobalManager.toolStats[var6][2];
                              var5[var2][0] = new Integer(Thief.toolUsingTimeStats[var1.objectType][var6]);
                              var4[var2] = (short)(85 + var6);
                              ++var2;
                           }
                        }

                        GlobalManager.sub_2a5((byte)0, false, (byte[])null, var4, var5, var9, (boolean[])null, (short)98, (byte)1);
                     }
                  }
                  break;
               case 7:
                  setCameraPos(selectedThief.positionX, selectedThief.positionY, true, false, false);
                  break;
               case 9:
                  var_96a = selectedThiefIndex;
                  selectedThiefIndex = -1;
                  break;
               case 10:
                  GlobalManager.keyCodePressed = 999999;
                  sub_b8e();
                  return;
               case 11:
                  GlobalManager.keyCodePressed = 999999;
                  selectThief(-1);
                  return;
               }

               GlobalManager.keyCodePressed = 999999;
            }
         }
      }
   }

   private static void selectThief(int thiefIndex) {
      boolean var1 = selectedThief == null;
      if (thiefIndex == -1) {
         ++selectedThiefIndex;
         var_35f = true;
         if (selectedThiefIndex >= thievesList.size() || selectedThief == null) {
            selectedThiefIndex = 0;
         }
      } else {
         selectedThiefIndex = (byte)thiefIndex;
      }

      selectedThief = sub_b2d();
      if (gameState == 0) {
         selectedThief.timelineIndex = (short)(selectedThief.recordedActions.size() - 1);
         selectedThief.applyTimelineState(true);
         Thief.globalTimer = selectedThief.timelineIndex;
         sub_585(selectedThief, false);
      }

      setCameraPos(selectedThief.positionX, selectedThief.positionY, false, true, false);
      if (gameState == 0 || var1) {
         sub_702();
      }

   }

   public static LevelObject sub_912(Thief var0) {
      int var1 = var0.positionX + offsetTypes[0][var0.direction];
      int var2 = var0.positionY + offsetTypes[1][var0.direction];
      Integer var3 = combineInts(var1, var2);
      if (levelObjectsMap.containsKey(var3)) {
         LevelObject var4;
         return (var4 = (LevelObject)levelObjectsMap.get(var3)).objectType == 6 && var_7f3 > 0 ? null : var4;
      } else {
         return null;
      }
   }

   private static boolean sub_950(LevelObject var0) {
      boolean var1 = false;
      if (gameState == 0) {
         if (var0.interactionTickTimestamp > 0 && var0.interactionTickTimestamp <= Thief.globalTimer) {
            var1 = ReadingDrawingClass.checkBit(LevelObjectData.spriteIndexes[var0.objectType][5], (byte)4);
         }
      } else if (var0.progressData[0] <= 0) {
         var1 = ReadingDrawingClass.checkBit(LevelObjectData.spriteIndexes[var0.objectType][5], (byte)4);
      }

      return var1;
   }

   public static boolean sub_9a0() {
      needRepaint = true;
      if (DialogManager.var_838 == null) {
         return false;
      } else {
         Object var0 = DialogManager.var_838;
         switch(DialogManager.var_7ed) {
         case 2:
            switch(((Short)var0).shortValue()) {
            case 117:
               checkWinCondition();
               return false;
            case 118:
               Thief var10000 = selectedThief;
               var10000.currentLoad -= selectedThief.calculateCurrentWeight();
               selectedThief.projectedLoad = selectedThief.currentLoad;
               selectedThief.clearThievesState(false);
               selectedThief.currentLoad = selectedThief.projectedLoad;
               return false;
            case 119:
            default:
               return false;
            case 120:
               GlobalManager.var_1217 = 3;
               return false;
            case 121:
               selectedThief.sub_19d();
               setCameraPos(selectedThief.positionX, selectedThief.positionY, true, false, false);
               return false;
            }
         case 8:
            Thief var11 = sub_b2d();
            byte var2 = Byte.parseByte((String)var0);
            if (var11.targetObject == null) {
               GlobalManager.showDialog((byte)0, (byte[])null, (short)169, (Object[])null, new short[]{126}, (short)137);
               return true;
            }

            boolean var12 = sub_950(var11.targetObject);
            if (var2 == 0 && var12) {
               if (Thief.globalTimer + 8 > 599) {
                  return false;
               }

               var11.actionState = 3;
               var11.addActionToTimeline((byte)8, true);
               break;
            } else {
               for(byte var13 = 0; var13 < 3; ++var13) {
                  if (var11.inventoryTools[var13] != 116) {
                     --var2;
                  }

                  if (var2 < 0) {
                     byte var5 = GlobalManager.sub_e5c(var11.inventoryTools[var13]);
                     byte var6 = sub_a94(var11, var5);
                     var11.selectedToolSlot = var13;
                     switch(var6) {
                     case -2:
                        GlobalManager.showDialog((byte)0, (byte[])null, (short)168, (Object[])null, new short[]{126}, (short)137);
                        return true;
                     case -1:
                        GlobalManager.showDialog((byte)0, (byte[])null, (short)166, (Object[])null, new short[]{126}, (short)137);
                        return true;
                     case 0:
                     case 1:
                     case 2:
                     case 3:
                     default:
                        return false;
                     case 4:
                        if (Thief.globalTimer + Thief.toolUsingTimeStats[var11.targetObject.objectType][var5] > 599) {
                           return false;
                        }

                        var11.actionState = var6;
                        var11.addActionToTimeline(Thief.toolUsingTimeStats[var11.targetObject.objectType][var5], true);
                        if (gameState == 1 && var11.targetObject.progressData[0] == 120) {
                           var11.targetObject.progressData[0] = Thief.toolUsingTimeStats[var11.targetObject.objectType][var5];
                        }

                        return false;
                     case 5:
                        if (Thief.globalTimer + Thief.toolUsingTimeStats[var11.targetObject.objectType][var5] > 599) {
                           return false;
                        }

                        LevelObject var7;
                        if (gameState == 0 && levelObjects.containsKey(combineInts(var11.positionX, var11.positionY)) && (var7 = (LevelObject)levelObjects.get(combineInts(var11.positionX, var11.positionY))) != null) {
                           int var8 = var7.interactionTickTimestamp / 60;
                           int var9 = (var7.interactionTickTimestamp - var8 * 60) / 10;
                           int var10 = var7.interactionTickTimestamp - var8 * 60 - var9 * 10;
                           GlobalManager.showDialog((byte)0, (byte[])null, (short)172, new Object[]{new Integer(var8), new Integer(var9), new Integer(var10)}, new short[]{126}, (short)137);
                           return true;
                        }

                        var11.actionState = var6;
                        var11.addActionToTimeline(Thief.toolUsingTimeStats[var11.targetObject.objectType][var5], true);
                        return false;
                     }
                  }
               }

               return false;
            }
         case 17:
            if (var0.equals(String.valueOf(126))) {
               if (GlobalManager.gameMode == -1) {
                  winState = sub_9c4();
               } else {
                  winState = 1;
               }

               for(int var3 = thievesList.size() - 1; var3 >= 0; --var3) {
                  Thief var4;
                  (var4 = (Thief)thievesList.elementAt(var3)).isBusy = false;
                  var4.moveInterpolation = 0;
                  var4.actionState = 0;
               }

               var_de4 = 1;
               var_e2f = 0;
               cameraState = 1;
            }
            break;
         case 32:
            ReadingDrawingClass.sub_759();
            GlobalManager.var_ab2 = 0;
            GlobalManager.initShop();
            return true;
         case 35:
            ReadingDrawingClass.sub_71d();
            GlobalManager.sub_c15();
            GlobalManager.var_1217 = 3;
            return true;
         case 36:
         case 39:
            if (GlobalManager.var_10ff > 0) {
               Object[] var1;
               if (GlobalManager.gameMode > 0) {
                  --GlobalManager.var_10ff;
                  var1 = new Object[]{new Integer(GlobalManager.var_10ff)};
               } else {
                  var1 = new Object[]{new Short((short)257)};
               }

               GlobalManager.showDialog((byte)35, (byte[])null, (short)158, var1, new short[]{126}, (short)191);
               return true;
            }

            GlobalManager.showDialog((byte)32, new byte[]{5, 6}, (short)162, (Object[])null, new short[]{126}, (short)163);
            return true;
         }

         return false;
      }
   }

   private static byte sub_9c4() {
	      // Replaced Hardcoded Switch with Logic check based on WinType
	      // 0 = Default (Loot) - logic handled in checkWinCondition
	      // 1 = Specific Object State
	      
	      if (winType == 1) {
	          LevelObject target = (LevelObject)levelObjectsMap.get(combineInts(winTargetX, winTargetY));
	          if (target != null) {
	              // Check if object is "open" or "done" (progress <= 0)
	              // For doors/crates progressData[0], for some loot containers progressData[1]
	              if (target.progressData[0] <= 0) return 4; // 4 = Win condition met? (Based on logic 4 seems to be 'all good')
	          }
	          return 5; // 5 = Fail/Not met?
	      } else {
	          // WinType 0: Check Loot
	          int calculatedLootForWin = 0;
	          
	          for(int i = thievesList.size() - 1; i >= 0; --i) {
	             Thief thief = (Thief)thievesList.elementAt(i);
	             for(int j = 1; j < 6; j++) {
	                calculatedLootForWin += thief.collectedLoot[j] * var_71c[j][0];
	             }
	          }
	          
	          if (calculatedLootForWin >= requiredLootAmount) {
	              return 3; // Win
	          } else {
	              return 5; // Fail
	          }
	      }
	   }

   private static void checkWinCondition() {
	     // sub_7b0(); // Method missing in current context
	      cameraState = 2;
	      
	      // Determine base win state from objectives
	      if (GlobalManager.gameMode == -1) {
	         winState = sub_9c4();
	      } else {
	         winState = 3;
	      }

	      int timeLeft = timeLimitSeconds - Thief.globalTimer;
	      int calculatedLootForWin = 0;

	      for(int i = thievesList.size() - 1; i >= 0; --i) {
	         Thief thief = (Thief)thievesList.elementAt(i);
	         
	         // Check if thief is caught (Time out or Stunned)
	         // 2 * Distance is roughly travel time needed
	         if ((2 * (Math.abs(thief.positionX - exitX) + Math.abs(thief.positionY - exitY)) > timeLeft || thief.stunTimer > 0) && GlobalManager.gameMode != -1) {
	            // Calculate Ransom/Penalty
	            int currentThiefLoot = thief.collectedLoot[1] * var_71c[1][0] + 
	                                   thief.collectedLoot[2] * var_71c[2][0] + 
	                                   thief.collectedLoot[3] * var_71c[3][0] + 
	                                   thief.collectedLoot[4] * var_71c[4][0] + 
	                                   thief.collectedLoot[5] * var_71c[5][0];
	            
	            // Penalty calculation from original source
	            short ransom = (short)(Math.max(thiefStats[thief.thiefId][2] * 1000, currentThiefLoot) / 1000);
	            
	            thief.sub_41a();
	            thief.collectedLoot[0] = ransom;
	            thief.sub_44c();
	            
	            GlobalManager.selectedThieves.addElement(thief);
	            thievesList.removeElement(thief);
	            
	            // Chief caught or "Boss Mode" fail logic
	            if (thief.thiefId == 0) {
	               winState = 2; // Critical Fail/End state if Chief caught (triggers fail dialog in finishLevel)
	            }
	         } else if (thief.positionX == exitX && thief.positionY == exitY) {
	            // Thief successfully at exit
	            if (thief.actionState == 1) {
	               thief.actionState = 0;
	               thief.moveInterpolation = 0;
	               thief.isBusy = false;
	            }
	            
	            // Accumulate loot for Win Condition check
	            for(int j = 1; j < 6; j++) {
	                calculatedLootForWin += thief.collectedLoot[j] * var_71c[j][0];
	            }
	         } else {
	            // Thief safe but assumed escaping off-screen? 
	            int currentThiefLoot = thief.collectedLoot[1] * var_71c[1][0] + 
	                                   thief.collectedLoot[2] * var_71c[2][0] + 
	                                   thief.collectedLoot[3] * var_71c[3][0] + 
	                                   thief.collectedLoot[4] * var_71c[4][0] + 
	                                   thief.collectedLoot[5] * var_71c[5][0];
	            
	            // Add to score display (Original logic adds 50%)
	            totalLootValue += currentThiefLoot * 50 / 100;
	            
	            // Add FULL loot to win condition check
	            calculatedLootForWin += currentThiefLoot;
	            
	            thief.moveInterpolation = 0;
	            thief.isBusy = false;
	            thief.positionX = (byte)(exitX + var_5cd[0][thief.thiefId]);
	            thief.positionY = (byte)(exitY + var_5cd[1][thief.thiefId]);
	         }
	      }

	      // If standard check failed (2), keep it. 
          // If sub_9c4 returned 3 (Win), keep it.
          // If sub_9c4 returned 5 (Fail), keep it.
          // The logic is now centralized in sub_9c4 so checkWinCondition mainly handles "Caught" logic.

	      if (thievesList.isEmpty()) {
	         var_e2f = 0;
	         cameraState = 4;
	         var_de4 = 4;
	      }

	      sub_3d2();
	      sub_65f();
   }

   public static void sub_a53(Thief var0) {
      var0.targetObject = sub_912(var0);
      if (var0.targetObject != null) {
         if (!ReadingDrawingClass.checkBit(LevelObjectData.spriteIndexes[var0.targetObject.objectType][5], (byte)5)) {
            if (mapArray[var0.targetObject.x][var0.targetObject.y] > 12 || sub_ae6(var0.targetObject, var0.positionX, var0.positionY)) {
               if (gameState == 0) {
                  if (var0.targetObject.var_1a5 > 0 && var0.targetObject.var_1a5 <= Thief.globalTimer) {
                     return;
                  }
               } else if (var0.targetObject.progressData[1] <= 0) {
                  return;
               }

               LevelObject var1;
               if ((var1 = (LevelObject)levelObjects.get(combineInts(var0.positionX, var0.positionY))) != null && gameState == 1 && var1.progressData[1] >= 0) {
                  GlobalManager.showDialog((byte)0, (byte[])null, (short)171, (Object[])null, new short[]{126}, (short)137);
               } else {
                  int var2 = 0;
                  int var3;
                  boolean var4;
                  if (var4 = sub_950(var0.targetObject)) {
                     var3 = 1;
                  } else {
                     var3 = 3;

                     for(int var5 = 0; var5 < 3; ++var5) {
                        if (var0.inventoryTools[var5] == 116) {
                           --var3;
                        }
                     }
                  }

                  if (var3 == 0) {
                     GlobalManager.showDialog((byte)0, (byte[])null, (short)170, (Object[])null, new short[]{126}, (short)137);
                  } else {
                     byte[][] var8 = new byte[var3][2];
                     short[] var6 = new short[var3];
                     if (var4) {
                        var8[0][0] = 49;
                        var8[0][1] = 0;
                        var6[0] = 119;
                     } else {
                        for(int var7 = 0; var7 < 3; ++var7) {
                           if (var0.inventoryTools[var7] != 116) {
                              var8[var2][0] = 8;
                              var8[var2][1] = GlobalManager.sub_e5c(var0.inventoryTools[var7]);
                              var6[var2] = (short)var0.inventoryTools[var7];
                              ++var2;
                           }
                        }
                     }

                     GlobalManager.sub_2a5((byte)8, false, (byte[])null, var6, (Object[][])null, var8, (boolean[])null, (short)139, (byte)2);
                  }
               }
            }
         }
      }
   }

   private static byte sub_a94(Thief var0, byte var1) {
      byte var2 = -1;
      if (Thief.toolUsingTimeStats[var0.targetObject.objectType][var1] > 0) {
         if (sub_bc9(var1) != 113 && sub_bc9(var1) != 114) {
            var2 = 4;
         } else {
            var2 = 5;
         }
      }

      if (var2 != -1 && !sub_ae6(var0.targetObject, var0.positionX, var0.positionY)) {
         var2 = -2;
      }

      return var2;
   }

   private static boolean sub_ae6(LevelObject var0, int var1, int var2) {
      boolean var3 = false;

      int var5;
      for(var5 = 0; var5 < 4; ++var5) {
         int var4;
         if ((var4 = var0.offsetType + var5) > 3) {
            var4 -= 4;
         }

         if (var1 == var0.x + offsetTypes[0][var4] && var2 == var0.y + offsetTypes[1][var4]) {
            break;
         }
      }

      if (ReadingDrawingClass.checkBit(LevelObjectData.spriteIndexes[var0.objectType][5], (byte)var5)) {
         var3 = true;
      }

      return var3;
   }

   private static Thief sub_b2d() {
      return (Thief)thievesList.elementAt(selectedThiefIndex);
   }

   private static void sub_b8e() {
      short[] var0;
      if (gameState == 0) {
         (var0 = new short[2])[0] = 120;
         var0[1] = 121;
      } else {
         if (selectedThief.stunTimer > 0) {
            return;
         }

         if (selectedThief.thiefId == 0 && selectedThief.calculateCurrentWeight() > 0 && !selectedThief.isBusy) {
            (var0 = new short[2])[0] = 117;
            var0[1] = 118;
         } else {
            (var0 = new short[1])[0] = 117;
         }
      }

      GlobalManager.sub_22b((byte)2, new byte[]{5, sub_b2d().thiefId}, var0, ReadingDrawingClass.readTextFromLng((short)138), (byte)2);
   }

   public static short sub_bc9(byte var0) {
      return (short)(var0 + 104);
   }

   static {
      var_d80 = -LevelObjectData.spriteTypesArr[14][2];
      cameraState = 0;
   }
}
