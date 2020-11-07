package me.dualnexon.rocketmath;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

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
	
	private static double windowWidth;
	
	public static double getWindowWidth() {
		return windowWidth;
	}
	
	public static void setWindowWidth(double windowWidth) {
		GlobalOptions.windowWidth = windowWidth;
	}
	
	private static double windowHeight;
	
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
	
	/**
	 * Nacita defaultne nastavenia
	 */
	public static void loadDefault() {
		
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		
		windowWidth = screenBounds.getWidth() / 1.5;
		windowHeight = screenBounds.getHeight() / 1.5;
		
		fullscreenMode = false;
		
	}
	
}
