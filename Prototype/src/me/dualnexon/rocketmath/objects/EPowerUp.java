package me.dualnexon.rocketmath.objects;

import javafx.scene.paint.Color;

public enum EPowerUp {
	
	FREEZE(Color.CYAN),
	TIME(Color.YELLOW);
	
	public Color color;
	
	private EPowerUp(Color color) {
		this.color = color;
	}
	
}
