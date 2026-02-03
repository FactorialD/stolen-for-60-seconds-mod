package main;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class Thief implements LevelObjectData {
   public static byte[][] toolUsingTimeStats = new byte[][]{{0, 0, 35, 80, 65, 20, 0, 0, 30, 15, 8, 0}, {22, 18, 14, 30, 20, 0, 0, 0, 0, 15, 8, 0}, {0, 55, 35, 55, 45, 25, 0, 0, 0, 15, 8, 0}, {25, 20, 17, 15, 0, 0, 0, 0, 0, 15, 8, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10}, {14, 8, 0, 20, 0, 0, 0, 0, 0, 15, 8, 0}, {0, 0, 0, 0, 0, 0, 50, 30, 15, 0, 0, 0}, {15, 10, 8, 12, 0, 0, 30, 0, 0, 15, 8, 0}, {25, 20, 17, 15, 0, 0, 0, 0, 0, 15, 8, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 8, 0}, {17, 11, 0, 20, 0, 0, 0, 0, 0, 15, 8, 0}, {15, 10, 0, 0, 0, 0, 0, 0, 0, 15, 8, 0}, {0, 0, 35, 70, 20, 15, 0, 0, 25, 15, 8, 0}, {14, 8, 0, 20, 0, 0, 0, 0, 0, 15, 8, 0}, {20, 15, 15, 30, 0, 0, 0, 0, 0, 15, 8, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {17, 10, 0, 20, 0, 0, 0, 0, 0, 15, 8, 0}, {17, 10, 0, 20, 0, 0, 0, 0, 0, 15, 8, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
   public final byte thiefId;
   public byte positionX;
   public byte positionY;
   public byte direction;
   public byte actionState;// 0: Стоит  1: Идет  2: Ждет  3: Лутает  4: Взламывает  5: Использует предмет
   public byte moveInterpolation;
   public boolean isBusy;
   public short stunTimer;
   public byte currentLoad;
   public byte projectedLoad;// Прогнозируемый вес в конце маршрута (для планирования)
   public short timelineIndex; //"Курсор" воспроизведения. Указывает на текущий элемент в recordedActions
   public final Vector recordedActions = new Vector();
   public LevelObject targetObject;
   public final short[] collectedLoot = new short[6];
   public final byte[] inventoryTools = new byte[3];
   public byte selectedToolSlot;
   public static short globalTimer;
   public static int targetX;
   public static int targetY;
   public static int[] exitAnimationProgress = new int[]{0, 0, 0, 0, 0};

   public Thief(byte thiefId) {
      this.thiefId = thiefId;
      this.clearThievesState(false);
   }

   public final void resetToSpawn() {
      exitAnimationProgress[0] = 0;
      this.positionX = LevelManager.exitX;
      this.positionY = LevelManager.exitY;
      this.stunTimer = 0;
      this.recordedActions.removeAllElements();
      this.recordedActions.addElement(new TimelineNode(this.positionX, this.positionY, (byte)0, (byte)0, (byte)0));
   }

   public final void applyTimelineState(boolean setPos) {
      if (LevelManager.cameraState == 3) {
         this.actionState = 2;
      } else {
         if (LevelManager.cameraState == 2) {
            if (this.positionX != LevelManager.exitX || this.positionY != LevelManager.exitY) {
               if (exitAnimationProgress[this.thiefId] < 3) {
                  this.actionState = LevelManager.var_619[this.thiefId][exitAnimationProgress[this.thiefId]].getAction();
                  this.direction = LevelManager.var_619[this.thiefId][exitAnimationProgress[this.thiefId]].getDirection();
                  return;
               } else {
                  this.actionState = 0;
                  return;
               }
            }
         } else if (this.recordedActions.size() > 0 && this.timelineIndex < this.recordedActions.size()) {
            TimelineNode node = (TimelineNode)this.recordedActions.elementAt(this.timelineIndex);
            this.actionState = node.getAction();
            if (setPos) {
               this.positionX = node.x;
               this.positionY = node.y;
            }

            this.direction = node.getDirection();
            this.selectedToolSlot = node.getToolSlot();
            return;
         }

         this.actionState = 0;
      }
   }

   private TimelineNode sub_e8() {
      return this.sub_ff(this.timelineIndex);
   }

   public final TimelineNode sub_ff(int var1) {
      return this.recordedActions.size() > 0 && var1 < this.recordedActions.size() ? (TimelineNode)this.recordedActions.elementAt(var1) : null;
   }

   public final void addWaitAction(byte seconds) {
      byte x = this.positionX;
      byte y = this.positionY;

      for(int var5 = 0; var5 < seconds; ++var5) {
         TimelineNode var2;
         (var2 = (TimelineNode)this.recordedActions.elementAt(globalTimer + var5)).x = x;
         var2.y = y;
         var2.setAction(this.actionState);
         var2.setDirection(this.direction);
         var2.setToolSlot(this.selectedToolSlot);
         if (this.actionState == 1) {
            x = (byte)(x + LevelManager.offsetTypes[0][this.direction]);
            y = (byte)(y + LevelManager.offsetTypes[1][this.direction]);
         }

         this.recordedActions.addElement(new TimelineNode(x, y, (byte)0, this.direction, (byte)0));
      }

   }

   public final void undoLastAction() {
      this.timelineIndex = (short)(globalTimer - 1);
      boolean var2 = this.timelineIndex == 0;
      this.applyTimelineState(var2);
      short var3 = (short)this.actionState;
      byte var4 = this.direction;
      short var5 = globalTimer;
      boolean var6 = false;
      boolean var7 = false;
      if (this.isInteracting()) {
         this.targetObject = LevelManager.sub_912(this);
         if (this.targetObject != null) {
            switch(this.actionState) {
            case 3:
               var7 = true;
               break;
            case 4:
               var6 = true;
               break;
            case 5:
               var6 = true;
               this.targetObject = (LevelObject)LevelManager.levelObjects.get(LevelManager.combineInts(this.positionX, this.positionY));
               LevelManager.sub_75c(this.positionX, this.positionY, true, true, this.timelineIndex + 1 + 5, this.targetObject.var_1f5 == 114, false);
               if (this.targetObject.var_1f5 == 114) {
                  LevelManager.sub_75c(this.positionX, this.positionY, true, true, this.timelineIndex + 1 + 5, this.targetObject.var_1f5 == 114, true);
               }

               LevelManager.levelObjects.remove(LevelManager.combineInts(this.positionX, this.positionY));
            }
         }
      }

      while(this.actionState == var3 && this.direction == var4) {
         this.isBusy = true;
         --globalTimer;
         this.recordedActions.removeElementAt(globalTimer);
         this.timelineIndex = globalTimer;
         if (this.timelineIndex > 0) {
            --this.timelineIndex;
         }

         this.applyTimelineState(!var2);
         if (this.actionState == 1) {
            this.timelineIndex = globalTimer;
            this.positionX = (byte)(this.positionX + LevelManager.offsetTypes[0][this.direction]);
            this.positionY = (byte)(this.positionY + LevelManager.offsetTypes[1][this.direction]);
         }

         if (this.actionState == 2) {
            this.timelineIndex = globalTimer;
         }

         TimelineNode var1;
         (var1 = (TimelineNode)this.recordedActions.elementAt(globalTimer)).x = this.positionX;
         var1.y = this.positionY;
         var1.setAction((byte)0);
         var1.setDirection(this.direction);
         var1.setToolSlot(this.selectedToolSlot);
         if (this.actionState == 1 || this.actionState == 2) {
            break;
         }
      }

      this.isBusy = false;
      if (var6 && this.targetObject.interactionTickTimestamp > globalTimer && this.targetObject.interactionTickTimestamp <= var5) {
         this.targetObject.interactionTickTimestamp = 0;
      }

      if (var7 && this.targetObject.var_1a5 > globalTimer && this.targetObject.var_1a5 <= var5) {
         this.targetObject.var_1a5 = 0;
      }

   }

   public final void sub_19d() {
      while(this.recordedActions.size() > 1) {
         globalTimer = (short)(this.recordedActions.size() - 1);
         this.undoLastAction();
      }

      this.resetToSpawn();
   }

   public final void sub_1ba(byte var1, byte var2) {
      while(this.actionState == var1 && this.direction == var2) {
         this.applyTimelineState(false);
         ++this.timelineIndex;
      }

      --this.timelineIndex;
   }

   public final void sub_1f3(Graphics var1) {
      int var2 = 0;
      int var3 = 0;
      if (this.actionState == 1 && this.stunTimer <= 0) {
         var2 = LevelManager.offsetTypes[0][this.direction] * (this.moveInterpolation * 24 / 12);
         var3 = LevelManager.offsetTypes[1][this.direction] * (this.moveInterpolation * 24 / 12);
      }

      if (this.isInteracting() && this.targetObject != null) {
         var2 = LevelManager.offsetTypes[0][this.direction] * LevelObjectData.spriteIndexes[this.targetObject.objectType][6];
         var3 = LevelManager.offsetTypes[1][this.direction] * LevelObjectData.spriteIndexes[this.targetObject.objectType][6];
      }

      int var4 = LevelManager.mapOffsetX + this.positionX * 24 + var2;
      int var5 = LevelManager.mapOffsetY + this.positionY * 24 + var3;
      if (LevelManager.gameState == 1) {
         if (LevelManager.exitX == this.positionX && LevelManager.exitY == this.positionY) {
            if (var2 == 0 && var3 == 0) {
               return;
            }

            if (var3 < 0) {
               LevelManager.var_d55 = true;
            } else if (var3 > 0) {
               LevelManager.var_d39 = true;
            }
         }

         if (LevelManager.exitX == this.positionX + LevelManager.offsetTypes[0][this.direction] && LevelManager.exitY == this.positionY + LevelManager.offsetTypes[1][this.direction]) {
            if (var3 < 0) {
               LevelManager.var_d39 = true;
            } else if (var3 > 0) {
               LevelManager.var_d55 = true;
            }
         }

         ReadingDrawingClass.drawSpriteNoOffset(var1, (byte)1, this.stunTimer > 0 ? (LevelManager.var_52f[15][0] == LevelManager.var_52f[14][0] ? LevelManager.var_52f[14][0] : LevelManager.var_52f[15][0] + (this.direction << 2)) : LevelManager.var_52f[this.actionState == 4 ? GlobalManager.toolStats[GlobalManager.sub_e5c(this.inventoryTools[this.selectedToolSlot])][3] : this.actionState][this.moveInterpolation] + (this.direction << 2), var4, var5);
         if (LevelManager.selectedThief != null && LevelManager.selectedThief.thiefId == this.thiefId) {
            ReadingDrawingClass.drawSpriteNoOffset(var1, (byte)1, 7, var4, var5);
            return;
         }
      } else {
         ReadingDrawingClass.drawSpriteNoOffset(var1, (byte)50, this.direction, var4 + this.thiefId, var5 + this.thiefId);
         if (LevelManager.selectedThief != null && LevelManager.selectedThief.thiefId == this.thiefId && GlobalManager.var_91 > 6 && !this.isBusy) {
            ReadingDrawingClass.drawSpriteNoOffset(var1, (byte)51, LevelManager.selectedThief.thiefId - 1, var4 + 12 - 3 + this.thiefId, var5 + 12 - 3 + this.thiefId);
            if (LevelManager.selectedThief.positionX == LevelManager.exitX && LevelManager.selectedThief.positionY == LevelManager.exitY) {
               LevelManager.selectedThief.projectedLoad = LevelManager.selectedThief.currentLoad;
            }
         }
      }

   }

   public final boolean handleInputAndCollision() {
      if (globalTimer >= 599) {
         return false;
      } else {
         boolean var1 = false;
         boolean var2 = false;
         int var3;
         if (GlobalManager.keyCodePressed == 999999) {
            var3 = LevelManager.instance.sub_435(GlobalManager.var_9af);
         } else {
            GlobalManager.var_9af = 999999;
            var3 = LevelManager.instance.mapInputToGameAction(GlobalManager.keyCodePressed);
         }

         switch(var3) {
         case 2:
            this.direction = 1;
            var2 = true;
            break;
         case 3:
            this.direction = 3;
            var2 = true;
            break;
         case 4:
            this.direction = 0;
            var2 = true;
            break;
         case 5:
            this.direction = 2;
            var2 = true;
         }

         if (var2) {
            if (LevelManager.checkObjectInteraction(this, LevelManager.gameState == 0)) {
               if (this.actionState == 1) {
                  this.actionState = 2;
                  GlobalManager.keyCodePressed = 999999;
               } else {
                  LevelManager.sub_a53(this);
               }
            } else if (LevelManager.checkWallCollision(this, LevelManager.gameState == 0)) {
               this.actionState = 1;
               var1 = true;
            } else {
               this.actionState = 2;
            }
         } else {
            this.actionState = 2;
         }

         return var1;
      }
   }

   public final void sub_2a1() {
      exitAnimationProgress[this.thiefId] = 0;
      this.timelineIndex = 0;
      TimelineNode var1 = this.sub_e8();
      this.actionState = 0;
      if (var1 != null) {
         this.positionX = var1.x;
         this.positionY = var1.y;
         this.moveInterpolation = 0;
      }

      this.isBusy = false;
      this.targetObject = null;
      this.stunTimer = 0;
      this.sub_44c();
   }

   public final void addActionToTimeline(byte duration, boolean isInteract) {
      this.isBusy = true;
      if (LevelManager.gameState == 0) {
         if (this.actionState == 5 && LevelManager.levelObjects.containsKey(LevelManager.combineInts(this.positionX, this.positionY))) {
            GlobalManager.showDialog((byte)0, (byte[])null, (short)172, (Object[])null, new short[]{126}, (short)137);
            return;
         }

         this.addWaitAction(duration);
         globalTimer = (short)(globalTimer + (duration - 1));
         LevelManager.sub_585(this, isInteract);
         ++globalTimer;
         if (this.isInteracting() && this.targetObject != null) {
            switch(this.actionState) {
            case 3:
               this.targetObject.var_1a5 = globalTimer;
               LevelManager.sub_702();
               if (this.targetObject.var_1f5 != 0 && this.targetObject.var_22c > 0 && LevelManager.var_7a3[this.targetObject.var_1f5] <= 0 && this.projectedLoad + LevelManager.var_71c[this.targetObject.var_1f5][1] > LevelManager.thiefStats[this.thiefId][0]) {
                  if (LevelManager.thiefStats[this.thiefId][0] - this.calculateCurrentWeight() < LevelManager.var_71c[this.targetObject.var_1f5][1]) {
                     LevelManager.var_247 = 186;
                  } else {
                     LevelManager.var_247 = 185;
                  }
               }
               break;
            case 4:
               this.targetObject.interactionTickTimestamp = globalTimer;
               LevelManager.sub_702();
               if (this.inventoryTools[this.selectedToolSlot] == 115 && this.targetObject.var_1f5 != 0 && this.targetObject.var_22c > 0 && LevelManager.var_7a3[this.targetObject.var_1f5] <= 0 && this.projectedLoad + LevelManager.var_71c[this.targetObject.var_1f5][1] > LevelManager.thiefStats[this.thiefId][0]) {
                  if (LevelManager.thiefStats[this.thiefId][0] - this.calculateCurrentWeight() < LevelManager.var_71c[this.targetObject.var_1f5][1]) {
                     LevelManager.var_247 = 186;
                  } else {
                     LevelManager.var_247 = 185;
                  }
               }
               break;
            case 5:
               this.targetObject = new LevelObject((byte)9, this.positionX, this.positionY, this.direction, (byte)1, this.inventoryTools[this.selectedToolSlot], (byte)0);
               LevelManager.sub_75c(this.positionX, this.positionY, true, false, globalTimer + 5, this.targetObject.var_1f5 == 114, false);
               if (this.targetObject.var_1f5 == 114) {
                  LevelManager.sub_75c(this.positionX, this.positionY, true, false, globalTimer + 5, this.targetObject.var_1f5 == 114, true);
               }

               LevelManager.levelObjects.put(LevelManager.combineInts(this.positionX, this.positionY), this.targetObject);
               this.targetObject.interactionTickTimestamp = (short)(globalTimer + 5);
               LevelManager.sub_702();
            }
         }
      }

      if (LevelManager.gameState == 1 && this.actionState == 5) {
         this.targetObject = new LevelObject((byte)9, this.positionX, this.positionY, this.direction, (byte)0, this.inventoryTools[this.selectedToolSlot], (byte)0);
         LevelManager.levelObjects.put(LevelManager.combineInts(this.positionX, this.positionY), this.targetObject);
         this.targetObject.progressData[0] = duration;
      }

   }

   public final boolean isInteracting() {
      return this.actionState == 4 || this.actionState == 5 || this.actionState == 3;
   }

   public final boolean collectLoot() {
      if (this.targetObject.var_1f5 != 0 && this.targetObject.var_22c > 0) {
         if (LevelManager.thiefStats[this.thiefId][0] - this.currentLoad >= LevelManager.var_71c[this.targetObject.var_1f5][1]) {
            short[] var10000 = this.collectedLoot;
            byte var10001 = this.targetObject.var_1f5;
            var10000[var10001] = (short)(var10000[var10001] + this.targetObject.var_22c);
            this.currentLoad = (byte)(this.currentLoad + LevelManager.var_71c[this.targetObject.var_1f5][1]);
            return true;
         }

         this.targetObject.progressData[1] = 8;
         GlobalManager.showDialog((byte)0, new byte[]{5, this.thiefId}, (short)184, (Object[])null, new short[]{126}, (short)(41 + this.thiefId));
      }

      return false;
   }

   public final boolean calculateNextPosition() {
      targetX = this.positionX + LevelManager.offsetTypes[0][this.direction];
      targetY = this.positionY + LevelManager.offsetTypes[1][this.direction];
      return targetX >= 0 && targetX < LevelManager.mapWidth && targetY >= 0 && targetY < LevelManager.mapHeight;
   }

   public final void clearThievesState(boolean var1) {
      for(int var2 = 0; var2 < 3; ++var2) {
         if (var1 && this.inventoryTools[var2] != 116 && this.inventoryTools[var2] != 0) {
            GlobalManager.currentMoney += GlobalManager.toolStats[GlobalManager.sub_e5c(this.inventoryTools[var2])][0];
         }

         this.inventoryTools[var2] = 116;
      }

      this.currentLoad = 0;
   }

   public final void sub_41a() {
      for(int var1 = 1; var1 < this.collectedLoot.length; ++var1) {
         this.collectedLoot[var1] = 0;
      }

   }

   public final void sub_44c() {
      this.currentLoad = this.calculateCurrentWeight();
   }

   public final byte calculateCurrentWeight() {
      byte var1 = 0;

      for(int var2 = 0; var2 < 3; ++var2) {
         if (this.inventoryTools[var2] != 0 && this.inventoryTools[var2] != 116) {
            var1 = (byte)(var1 + GlobalManager.toolStats[GlobalManager.sub_e5c(this.inventoryTools[var2])][1]);
         }
      }

      return var1;
   }
}
