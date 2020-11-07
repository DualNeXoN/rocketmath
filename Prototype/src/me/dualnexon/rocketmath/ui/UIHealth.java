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
public class UIHealth implements IGameUI {
	
	private GameManager gm = GameManager.getGM();
	
	private Text text;
	private Sprite sprite;
	
	/**
	 * Konstruktor vytvori textovy element pre zobrazenie zivotov a umiestni na spravne miesto
	 */
	public UIHealth() {
		
		sprite = new Sprite(200, 200, 14, "heart" + File.separator, "pulse", "png", 50);
		sprite.setLayoutX(-20);
		sprite.setLayoutY(-22);
		
		text = new Text(Integer.toString(gm.getPlayer().getHealth()));
		
		text.setFill(Color.WHITE);
		text.setStroke(Color.BLACK);
		text.setStrokeWidth(1.5);
		
		updateLayout();
		
		gm.getMainFrame().getGroup().getChildren().add(text);
		
	}
	
	public void updateLayout() {
		
		if(text.getText().length() >= 3) text.setFont(new Font(40));
		else if(text.getText().length() == 2) text.setFont(new Font(48));
		else text.setFont(new Font(56));
		
		double layoutX = sprite.getLayoutX() + (sprite.getWidth()/2) - text.getLayoutBounds().getWidth()/2;
		double layoutY = sprite.getLayoutY() + (sprite.getHeight()/2) + text.getLayoutBounds().getHeight()/5;
		text.setLayoutX(layoutX);
		text.setLayoutY(layoutY);
	}
	
	/**
	 * Aktualizuje UI
	 */
	@Override
	public void updateUI() {
		
		int healthCurrent = gm.getPlayer().getHealth();
		sprite.toFront();
		text.setText(Integer.toString(healthCurrent));
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
