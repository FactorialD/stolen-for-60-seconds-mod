package main;
import java.io.InputStream;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public final class MM extends MIDlet {
	public static GlobalManager globalManager;
	public static String gameVersion;
	private static boolean isFirstStart = true;

	public final void startApp() {
		//Class_293.sub_4d(this);
		HackManager.callGc();
		if (isFirstStart) {
			gameVersion = this.getAppProperty("MIDlet-Version");
			if (gameVersion == null) {
				gameVersion = "1.0";
			}

			GlobalManager.mainMidlet = this;
			globalManager = new GlobalManager();
			Display.getDisplay(this).setCurrent(globalManager);
			isFirstStart = false;
		}

		globalManager.runGameThread();
	}

	public final void pauseApp() {
		GlobalManager.pauseGameThread();
		this.notifyPaused();
	}

	public final void destroyApp(boolean var1) {
		if (GlobalManager.var_511 && LevelManager.gameState != 1) {
			ReadingDrawingClass.sub_870();
		}

		GlobalManager.sub_9b();
		this.notifyDestroyed();
	}

	public static final InputStream getResourceStream(String var0) {
		return GlobalManager.mainMidlet.getClass().getResourceAsStream(var0);
	}
}
