package me.dualnexon.rocketmath.ui;

import java.io.File;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import me.dualnexon.rocketmath.GameManager;

/**
 * UI element pre pozadie hernej plochy
 * @author DualNexon
 *
 */
public class UIBackground implements IGameUI {
	
	private GameManager gm = GameManager.getGM();
	
	private Canvas backgroundFrame;
	private Canvas background;
	
	/**
	 * Konstruktor vytvori pozadie a umiestni na spravne miesto
	 */
	public UIBackground() {
		
		File path = new File(System.getProperty("user.dir") + File.separator + "assets" + File.separator + "background.png");
		Image image = new Image(path.toURI().toString());
		
		background = new Canvas(gm.getMainFrame().getScene().getWidth(), gm.getMainFrame().getScene().getHeight());
		background.getGraphicsContext2D().drawImage(image, 0, 0, background.getWidth(), background.getHeight());
		gm.getMainFrame().getGroup().getChildren().add(background);
		
		
		backgroundFrame = new Canvas(gm.getMainFrame().getScene().getWidth(), gm.getMainFrame().getScene().getHeight());
		backgroundFrame.getGraphicsContext2D().drawImage(image, 0, 0, backgroundFrame.getWidth(), backgroundFrame.getHeight());
		backgroundFrame.getGraphicsContext2D().clearRect(29, 25, backgroundFrame.getWidth()-28*2, backgroundFrame.getHeight()-27*2);
		gm.getMainFrame().getGroup().getChildren().add(backgroundFrame);
		
	}
	
	/**
	 * Vrati pozadie
	 * @return
	 */
	public Canvas getBackground() {
		return background;
	}
	
	/**
	 * Vrati ram pozadia
	 * @return
	 */
	public Canvas getBackgroundFrame() {
		return backgroundFrame;
	}
	
	/**
	 * Aktualizuje UI
	 */
	@Override
	public void updateUI() {
		background.toBack();
		backgroundFrame.toFront();
	}
	
	/**
	 * Znici UI
	 */
	@Override
	public void destroyUI() {
		gm.getMainFrame().getGroup().getChildren().remove(background);
		gm.getMainFrame().getGroup().getChildren().remove(backgroundFrame);
	}
	
}
