package me.dualnexon.rocketmath.objects;

import me.dualnexon.rocketmath.GameManager;
import me.dualnexon.rocketmath.MathFunc;
import me.dualnexon.rocketmath.ProblemGenerator;

/**
 * 
 * @author DualNexon
 *
 */
public class MathProblemBlink extends MathProblem {
	
	public MathProblemBlink(String problem) {
		super(problem);
	}
	
	public MathProblemBlink() {
		this(ProblemGenerator.generate());
	}
	
	@Override
	protected void generatePosition() {
		x = MathFunc.getRandomInRange(140, (int)(GameManager.getGM().getMainFrame().getScene().getWidth()-40-getWidth()));
		y = -getHeight();
		setLayoutX(x);
		setLayoutY(y);
	}
	
	@Override
	public void tick() {
		y += speed;
		setLayoutY(y);
		if(y > GameManager.getGM().getMainFrame().getScene().getHeight()) {
			GameManager.getGM().getPlayer().decHealth(1);
			setToDestroy();
		}
	}
	
}
