package me.dualnexon.rocketmath;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import me.dualnexon.rocketmath.objects.MathProblem;
import me.dualnexon.rocketmath.objects.MathProblemFalling;

public class TimeLeft {
	
	private int time;
	private Timeline timeline;
	
	public TimeLeft(int time) {
		this.time = time;
		
		timeline = new Timeline(new KeyFrame(Duration.seconds(1), (e -> decTime()) ));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
	}
	
	public void setRunning(boolean running) {
		if(running) {
			timeline.play();
		} else {
			timeline.pause();
		}
	}
	
	private void decTime() {
		if(time > 0) {
			if(MathProblemFalling.getFreezeSpeed() < MathProblem.getMaxSpeed()/2) {
				if(--time <= 0) {
					GameManager.getGM().setGameRunning(false);
					destroy();
				}
			}
		}
	}
	
	public void destroy() {
		timeline.stop();
	}
	
	public int getTime() {
		return time;
	}
	
	public void addTime(int value) {
		time += value;
	}
	
}
