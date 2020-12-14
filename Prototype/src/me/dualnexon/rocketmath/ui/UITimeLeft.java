package me.dualnexon.rocketmath.ui;

import java.io.File;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import me.dualnexon.rocketmath.GameManager;
import me.dualnexon.rocketmath.Sprite;

/**
 * UI element na zobrazenie zivota hraca
 * @author DualNexon
 *
 */
public class UITimeLeft implements IGameUI {
	
	private GameManager gm = GameManager.getGM();
	
	private Text text;
	private Sprite sprite;
	
	/**
	 * Konstruktor vytvori textovy element pre zobrazenie zivotov a umiestni na spravne miesto
	 */
	public UITimeLeft() {
		
		sprite = new Sprite(220, 150, 1, "time" + File.separator, "time", "png", 50);
		sprite.setLayoutX(-30);
		sprite.setLayoutY(150);
		
		text = new Text("");
		
		text.setFill(Color.WHITE);
		text.setStroke(Color.BLACK);
		text.setStrokeWidth(1.2);
		
		updateLayout();
		
		gm.getMainFrame().getGroup().getChildren().add(text);
		
	}
	
	public void updateLayout() {
		
		text.setFont(new Font(40));
		
		double layoutX = sprite.getLayoutX() + (sprite.getWidth()/2) - text.getLayoutBounds().getWidth()/2;
		double layoutY = sprite.getLayoutY() + sprite.getHeight();
		text.setLayoutX(layoutX);
		text.setLayoutY(layoutY);
	}
	
	/**
	 * Aktualizuje UI
	 */
	@Override
	public void updateUI() {
		
		sprite.toFront();
		text.setText(Integer.toString(gm.getTimeLeft().getTime()));
		updateLayout();
		text.toFront();
		
	}
	
	/**
	 * Znici UI
	 */
	@Override
	public void destroyUI() {
		
		gm.getMainFrame().getGroup().getChildren().remove(text);
		sprite.destroy();
		
	}
	
}
