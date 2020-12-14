package me.dualnexon.rocketmath.objects;

import me.dualnexon.rocketmath.GameManager;
import me.dualnexon.rocketmath.MathFunc;
import me.dualnexon.rocketmath.ProblemGenerator;

public class MathProblemFalling extends MathProblem {
	
	private static double freezeSpeed = 0;
	
	public static void setFreezeSpeed(double freezeSpeed) {
		if(freezeSpeed < 0) freezeSpeed = 0;
		MathProblemFalling.freezeSpeed = freezeSpeed;
	}
	
	public static void incFreezeSpeed(double freezeSpeed) {
		MathProblemFalling.freezeSpeed += freezeSpeed;
	}
	
	public static void decFreezeSpeed(double freezeSpeed) {
		MathProblemFalling.freezeSpeed -= freezeSpeed;
		if(MathProblemFalling.freezeSpeed < 0) MathProblemFalling.freezeSpeed = 0;
	}
	
	public static double getFreezeSpeed() {
		return freezeSpeed;
	}
	
	/**
	 * Vytvori objekt na zaklade rodica s matematickym prikladom z parametra
	 * @param problem - Matematicky priklad
	 */
	public MathProblemFalling(String problem) {
		super(problem);
	}
	
	/**
	 * Vytvori objekt na zaklade rodica s nahodnym matematickym prikladom
	 */
	public MathProblemFalling() {
		this(ProblemGenerator.generate());
	}
	
	/**
	 * Vygeneruje nahodnu poziciu objektu
	 */
	@Override
	protected void generatePosition() {
		
		x = MathFunc.getRandomInRange(140, (int)(GameManager.getGM().getMainFrame().getScene().getWidth()-40-200-getWidth()));
		y = -getHeight();
		
		setLayoutX(x);
		setLayoutY(y);
		
	}
	
	/**
	 * Vykona sa kazdy update hry. Aplikuje pohyb objektu a zisti, ci je mozne instanciu znicit
	 */
	@Override
	public void tick() {
		
		y += ((speed - freezeSpeed) >= 0) ? (speed - freezeSpeed) : 0;
		setLayoutY(y);
		
		if(y > GameManager.getGM().getMainFrame().getScene().getHeight()) {
			GameManager.getGM().getPlayer().decHealth(1);
			setToDestroy();
		}
		
	}
	
}
