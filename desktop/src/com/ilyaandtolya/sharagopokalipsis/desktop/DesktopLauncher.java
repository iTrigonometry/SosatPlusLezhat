package com.ilyaandtolya.sharagopokalipsis.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ilyaandtolya.sharagopokalipsis.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 854;
		config.height = 480;
		config.foregroundFPS = 65;
		config.vSyncEnabled = false;

		new LwjglApplication(new Main(), config);
	}
}
