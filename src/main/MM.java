package main;
import java.io.InputStream;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public final class MM extends MIDlet {
	public static Class_178 var_5a;
	public static String var_a1;
	private static boolean var_d4 = true;

	public final void startApp() {
		//Class_293.sub_4d(this);
		Class_3d.sub_198();
		if (var_d4) {
			var_a1 = this.getAppProperty("MIDlet-Version");
			if (var_a1 == null) {
				var_a1 = "1.0";
			}

			Class_178.var_3e2 = this;
			var_5a = new Class_178();
			Display.getDisplay(this).setCurrent(var_5a);
			var_d4 = false;
		}

		var_5a.sub_29();
	}

	public final void pauseApp() {
		Class_178.sub_4d();
		this.notifyPaused();
	}

	public final void destroyApp(boolean var1) {
		if (Class_178.var_511 && Class_b3.var_a5a != 1) {
			Class_1b0.sub_870();
		}

		Class_178.sub_9b();
		this.notifyDestroyed();
	}

	public static final InputStream sub_d(String var0) {
		return Class_178.var_3e2.getClass().getResourceAsStream(var0);
	}
}
