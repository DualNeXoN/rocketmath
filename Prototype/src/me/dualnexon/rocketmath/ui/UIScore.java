package me.dualnexon.rocketmath.ui;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import me.dualnexon.rocketmath.GameManager;

public class UIScore implements IGameUI {
	
	private GameManager gm = GameManager.getGM();
	
	private Text text;
	
	public UIScore() {
		
		text = new Text("");
		
		text.setFill(Color.WHITE);
		text.setStroke(Color.BLACK);
		text.setStrokeWidth(1.5);
		text.setFont(new Font(52));
		
		updateLayout();
		
		gm.getMainFrame().getGroup().getChildren().add(text);
		
	}
	
	private void updateLayout() {
		
		double layoutX = 78 - text.getLayoutBounds().getWidth() / 2;
		double layoutY = gm.getMainFrame().getScene().getHeight() - 50;
		
		text.setLayoutX(layoutX);
		text.setLayoutY(layoutY);
		
	}
	
	@Override
	public void updateUI() {
		text.setText(Integer.toString(gm.getScore().get()));
		updateLayout();
		text.toFront();
	}

	@Override
	public void destroyUI() {
		gm.getMainFrame().getGroup().getChildren().remove(text);
	}
	
}
