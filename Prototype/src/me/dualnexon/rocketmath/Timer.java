package me.dualnexon.rocketmath;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Timer {
	
	private int maxTime;
	private int currentTime;
	private Timeline timeline;
	
	public Timer(int maxTime) {
		this.maxTime = maxTime;
		this.currentTime = maxTime;
		
		timeline = new Timeline(new KeyFrame(Duration.millis(1), (e -> decTime()) ));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
	}
	
	private void decTime() {
		if(currentTime > 0) {
			currentTime--;
			if(isOver()) destroy();
		}
	}
	
	public boolean isOver() {
		return (currentTime == 0);
	}
	
	public double getPercentage() {
		return MathFunc.getPercentage(maxTime, currentTime);
	}
	
	public void destroy() {
		timeline.stop();
	}
	
}
