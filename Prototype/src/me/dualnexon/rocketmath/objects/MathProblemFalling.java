package me.dualnexon.rocketmath.objects;

import me.dualnexon.rocketmath.GameManager;
import me.dualnexon.rocketmath.MathFunc;
import me.dualnexon.rocketmath.ProblemGenerator;

public class MathProblemFalling extends MathProblem {
	
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
		
		x = MathFunc.getRandomInRange(140, (int)(GameManager.getGM().getMainFrame().getScene().getWidth()-40-getWidth()));
		y = -getHeight();
		
		setLayoutX(x);
		setLayoutY(y);
		
	}
	
	/**
	 * Vykona sa kazdy update hry. Aplikuje pohyb objektu a zisti, ci je mozne instanciu znicit
	 */
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
