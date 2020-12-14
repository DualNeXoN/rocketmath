package me.dualnexon.rocketmath;

/**
 * Globalne nastavenia aplikacie
 * @author DualNexon
 *
 */
public abstract class GlobalOptions {
	
	/**
	 * Udava pocet cyklov (updatov) hry za sekundu
	 */
	private static final long GAME_TICK = 20;
	
	/**
	 * Vrati pocet cyklov hry za sekundu
	 * @return
	 */
	public static long getGameTick() {
		return GAME_TICK;
	}
	
	private static double windowWidth = 1280;
	
	public static double getWindowWidth() {
		return windowWidth;
	}
	
	public static void setWindowWidth(double windowWidth) {
		GlobalOptions.windowWidth = windowWidth;
	}
	
	private static double windowHeight = 693;
	
	public static double getWindowHeight() {
		return windowHeight;
	}
	
	public static void setWindowHeight(double windowHeight) {
		GlobalOptions.windowHeight = windowHeight;
	}
	
	private static boolean fullscreenMode;
	
	public static boolean getFullscreenMode() {
		return fullscreenMode;
	}
	
	public static void setFullscreenMode(boolean fullscreenMode) {
		GlobalOptions.fullscreenMode = fullscreenMode;
	}
	
	private static int defaultHealthCount = 10;
	
	public static int getDefaultHealthCount() {
		return defaultHealthCount;
	}
	
	private static int powerUpTime = 8;
	
	public static int getPowerUpTime() {
		return powerUpTime;
	}
	
	/**
	 * Nacita defaultne nastavenia
	 */
	public static void loadDefault() {
		
		/*
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		
		windowWidth = screenBounds.getWidth() / 1.5;
		windowHeight = screenBounds.getHeight() / 1.5;
		*/
		
		fullscreenMode = false;
		
	}
	
}
