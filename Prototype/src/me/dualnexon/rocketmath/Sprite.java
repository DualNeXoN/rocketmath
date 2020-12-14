package me.dualnexon.rocketmath;

import java.io.File;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;

/**
 * Trieda vykonavajuca render a logiku spritov
 * @author DualNexon
 *
 */
public class Sprite extends Canvas {
	
	public static final String ROOT_PATH = System.getProperty("user.dir") + File.separator + "assets" + File.separator;
	
	private GraphicsContext g2d;
	private Timeline animation;
	
	private String filePath;
	private String fileName;
	private String fileExtension;
	
	private int spriteCurrent = 0;
	private int spriteCount;
	
	private int updateInMillis;
	
	private Image[] sprites;
	
	/**
	 * Konstruktor prida objekt na hernu plochu, nastavi rozmery, nacita grafiku z obrazkov a spusti animaciu
	 * @param width - Sirka spritu
	 * @param height - Vyska spritu
	 * @param spriteCount - Pocet obrazkov pre animaciu
	 * @param filePath - Cesta k priecinku suboru (cesta k priecinku assets uz je automaticky doplnena)
	 * @param fileName - Nazov suboru (bez pripony a cisla postupnosti animacie)
	 * @param fileExtension - Nazov pripony (bez bodky)
	 * @param updateInMillis - Zmena obrazka animacie v milisekundach
	 */
	public Sprite(double width, double height, int spriteCount, String filePath, String fileName, String fileExtension, int updateInMillis) {
		super(width, height);
		
		g2d = getGraphicsContext2D();
		
		this.filePath = ROOT_PATH + filePath;
		this.fileName = fileName;
		this.fileExtension = fileExtension;
		this.spriteCount = spriteCount;
		
		loadSprites();
		
		setUpdateInMillis(updateInMillis);
		
		GameManager.getGM().getMainFrame().getGroup().getChildren().add(this);
		
	}
	
	/**
	 * Nacita obrazky do jednorozmerneho pola
	 */
	public void loadSprites() {
		
		sprites = new Image[spriteCount];
		
		for(int index = 0; index < spriteCount; index++) {
			sprites[index] = new Image(new File(filePath + fileName + index + "." + fileExtension).toURI().toString());
		}
		
	}
	
	/**
	 * Znici objekt
	 */
	public void destroy() {
		
		g2d.clearRect(0, 0, getWidth(), getHeight());
		animation.stop();
		GameManager.getGM().getMainFrame().getGroup().getChildren().remove(this);
		
	}
	
	/**
	 * Aktualizuje objekt
	 */
	public void update() {
		
		spriteCurrent = ++spriteCurrent % spriteCount;
		render();
		
	}
	
	/**
	 * Vyrenderuje objekt
	 */
	public void render() {
		
		g2d.clearRect(0, 0, getWidth(), getHeight());
		g2d.drawImage(sprites[spriteCurrent], 0, 0, getWidth(), getHeight());
		
	}
	
	/**
	 * Zastavi animaciu
	 */
	public void stopAnimation() {
		if(animation != null) animation.stop();
	}
	
	/**
	 * Spusti animaciu
	 */
	public void playAnimation() {
		if(animation != null) animation.play();
	}
	
	/**
	 * Zmeni rychlost animacie (funguje aj pocas behu animacie)
	 * @param updateInMillis - Zmena obrazka animacie v milisekundach
	 */
	public void setUpdateInMillis(int updateInMillis) {
		this.updateInMillis = updateInMillis;
		stopAnimation();
		animation = new Timeline(new KeyFrame(Duration.millis(updateInMillis), e -> update()));
		animation.setCycleCount(Timeline.INDEFINITE);
		playAnimation();
		
	}
	
	/**
	 * Vrati cas zmeny obrazka animacie
	 * @return - Cas zmeny obrazka animacie v milisekundach
	 */
	public int getUpdateInMillis() {
		return updateInMillis;
	}
	
}
