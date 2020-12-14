package me.dualnexon.rocketmath;

/**
 * Trieda generuje matematicke priklady na zaklade obtiaznosti a inych nastaveni
 * @author DualNexon
 *
 */
public abstract class ProblemGenerator {
	
	/**
	 * Vrati vygenerovany matematicky priklad
	 * @return
	 */
	public static String generate() {
		
		switch(GameManager.getGM().getGameDifficulty()) {
		case EASY: return easy();
		case MEDIUM: return medium();
		case HARD: return hard();
		default: return medium();
		
		}
		
	}
	
	private static String easy() {
		int x = MathFunc.getRandomInRange(0, 10);
		int y = MathFunc.getRandomInRange(0, 10);
		
		char operation = '+';
		
		switch(MathFunc.getRandomInRange(1, 2)) {
		case 1: operation = '+'; break;
		case 2: operation = '-'; break;
		}
		
		return x + "" + operation + "" + y;
	}
	
	private static String medium() {
		int x = MathFunc.getRandomInRange(0, 20);
		int y = MathFunc.getRandomInRange(0, 20);
		
		char operation = '+';
		
		switch(MathFunc.getRandomInRange(1, 2)) {
		case 1: operation = '+'; break;
		case 2: operation = '-'; break;
		}
		
		return x + "" + operation + "" + y;
	}
	
	private static String hard() {
		int x = MathFunc.getRandomInRange(0, 10);
		int y = MathFunc.getRandomInRange(0, 10);
		
		char operation = '+';
		
		switch(MathFunc.getRandomInRange(1, 3)) {
		case 1: operation = '+'; break;
		case 2: operation = '-'; break;
		case 3: operation = '*'; break;
		}
		
		return x + "" + operation + "" + y;
	}
	
}
