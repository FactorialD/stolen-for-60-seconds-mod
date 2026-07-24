package main;
import javax.microedition.lcdui.Graphics;

public final class LevelObject implements LevelObjectData {
   public final byte objectType;
   /*01 - wooden door, 
    * 05 - glass vertical witrine, 
    * 06 - alarm panel
    * 13 - glass shelf looking down
    * 27 - glass square witrine
    * */
   public final byte x;
   public final byte y;
   public final byte offsetType;
   public short interactionTickTimestamp;
   public short var_1a5;
   public final byte[] progressData = new byte[]{120, 8};
   public byte var_1f5;
   public byte var_22c;

   public LevelObject(byte objectType, byte x, byte y, byte offsetType, byte var5, byte var6, byte var7) {
      this.objectType = objectType;
      this.x = x;
      this.y = y;
      this.offsetType = offsetType;
      this.var_1f5 = var6;
      this.var_22c = var7;
      this.progressData[0] = (byte)(var5 == 0 ? 120 : 0);
   }

   public final void drawObject(Graphics g) {
	      int state = 0;
	      
	      // LOGIC: Determine if object is "Open/Active" (State 1) or "Closed/Normal" (State 0)
	      if (LevelManager.gameState != 0) {
	         if (objectType == 9) {
	            // For Loot Item (Type 9), state depends on progressData[1]
	            // If collected or empty, maybe don't draw or draw state 1? 
	            // Original code: if progressData[0] > 0 return; if progressData[1] <= 0 state=1;
	            if (this.progressData[0] > 0) {
	               return; 
	            }
	            state = this.progressData[1] <= 0 ? 1 : 0;
	         } else {
	            // For Standard Objects (Doors, Safes, etc)
	            // State 1 if progressData[0] <= 0 (Open/Hacked)
	            state = this.progressData[0] <= 0 ? 1 : 0;
	         }
	         
	         // Special case for Alarm (Type 6) with Type 32 (Briefing ID?) override -> Type 4
	         byte effectiveType = this.objectType;
	         if (effectiveType == 6 && LevelManager.levelAdditionalData_TimerEtc[GlobalManager.levelId - 1][25] == 32) {
	            effectiveType = 4;
	         }
	         
	         // If Alarm and cost > 0, do not draw? (Original logic preserved)
	         if (effectiveType == 6 && LevelManager.var_7f3 > 0) {
	            return;
	         }
	         
	         // If Container (Type 4) and closed, check... wait original logic:
	         // if (this.progressData[0] <= 0 && objectType == 4) return;
	         if (effectiveType == 4 && this.progressData[0] <= 0) {
	             return;
	         }

	         // Calculate Draw Position
	         int drawX = LevelManager.mapOffsetX + this.x * 24;
	         int drawY = LevelManager.mapOffsetY + this.y * 24;

	         // Construct Filename: obj_XX_X_X.png
	         // Format: obj_{TYPE}_{OFFSET}_{STATE}
	         // Ensure Type is 2 digits
	         String typeStr = effectiveType < 10 ? "0" + effectiveType : String.valueOf(effectiveType);
	         String imgName = "obj_" + typeStr + "_" + this.offsetType + "_" + state;
	         
	         // Draw using new method
	         ReadingDrawingClass.drawExternalImage(g, imgName, drawX, drawY);

	         // Extra Logic for Type 9 (Loot Item) text overlay
	         if (objectType == 9) {
	            if (this.progressData[0] <= 0 && this.progressData[1] > 0) {
	               ReadingDrawingClass.sub_46a(g, String.valueOf(this.progressData[1]), drawX, drawY);
	            }
	            if (this.progressData[1] == 0) {
	               ReadingDrawingClass.drawSpriteNoOffset(g, (byte)11, LevelManager.var_4e5[this.var_22c], drawX, drawY);
	               LevelManager.var_4a5 = LevelManager.var_475[this.var_22c];
	            }
	         }

	      } else {
	         // --- PLANNING MODE (gameState == 0) ---
	         
	         // Filter out hidden alarms/boxes in planning mode
	         if (this.objectType == 6 && (LevelManager.var_7f3 > 0 || LevelManager.levelAdditionalData_TimerEtc[GlobalManager.levelId - 1][25] == 32)) {
	            return;
	         }
	         if (this.objectType == 4 && LevelManager.levelAdditionalData_TimerEtc[GlobalManager.levelId - 1][25] == 32) {
	            return;
	         }

	         // In planning mode, we mostly draw specific icons, but sometimes the object itself
	         if (this.objectType != 22 && this.objectType != 23 && this.objectType != 24) {
	             // Logic for Alarms (Colored icons) and hints
	             int tintColor = 0;
	             if (this.objectType == 6) {
	                 // Alarm: Color based on var_22c (0=Red, 1=Green?, 2=Blue?)
	                 tintColor = this.var_22c == 0 ? 16711680 : (this.var_22c == 1 ? 315140 : 255);
	             } else {
	                 if (this.var_22c > 0) tintColor = 12058726;
	                 // Check bit 5 (Trap?)
	                 if (ReadingDrawingClass.checkBit(LevelObjectData.spriteIndexes[this.objectType][5], (byte)5)) {
	                     tintColor = 5855577;
	                 } else if (LevelManager.var_7a3[this.var_1f5] > 0 || LevelManager.levelAdditionalData_TimerEtc[GlobalManager.levelId - 1][25] == 20) {
	                     tintColor = 0;
	                 }
	                 if (this.objectType == 11) tintColor = 0;
	             }
	             
	             // In planning, we can still use the new sprite system for the base shape, 
	             // OR fallback to the tiny icons (sheet 4). 
	             // Original logic used sub_2c5 which likely draws a small icon/dot for planning.
	             // We will keep sub_2c5 logic for Planning Mode to preserve the map look.
	             ReadingDrawingClass.sub_2c5(g, LevelObjectData.spriteIndexes[this.objectType][4], this.offsetType, LevelManager.mapOffsetX + this.x * 24, LevelManager.mapOffsetY + this.y * 24, tintColor);
	         } else {
	             ReadingDrawingClass.drawSpriteNoOffset(g, (byte)47, 0, LevelManager.mapOffsetX + this.x * 24, LevelManager.mapOffsetY + this.y * 24);
	         }

	         // Interaction Timers overlays
	         if (this.interactionTickTimestamp > 0 && this.interactionTickTimestamp <= Thief.globalTimer) {
	            ReadingDrawingClass.drawSpriteNoOffset(g, (byte)2, 18, LevelManager.mapOffsetX + this.x * 24, LevelManager.mapOffsetY + this.y * 24);
	         }
	         if (this.var_1a5 > 0 && this.var_1a5 <= Thief.globalTimer) {
	            ReadingDrawingClass.drawSpriteNoOffset(g, (byte)2, 19, LevelManager.mapOffsetX + this.x * 24, LevelManager.mapOffsetY + this.y * 24);
	         }
	      }
	   }

   public final void drawTimerCircle(Graphics g, byte var2, boolean var3) {
      if (var2 > 0) {
         int var4 = 360 * (var3 ? this.progressData[0] : this.progressData[1]) / var2;
         g.setClip(0, 0, 16, 16);
         g.setColor(var3 ? 10027008 : 26112);
         g.fillArc(0, 0, 15, 15, 0, 360);
         g.setColor(16777215);
         g.fillArc(0, 0, 15, 15, 90, var4);
      }

   }

   public final void sub_c6(boolean var1) {
      if (var1) {
         this.interactionTickTimestamp = 0;
         this.var_1a5 = 0;
      } else {
         this.progressData[0] = 120;
         this.progressData[1] = 8;
      }
   }
}
