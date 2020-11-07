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
		
		int x = MathFunc.getRandomInRange(2, 10);
		int y = MathFunc.getRandomInRange(2, 10);
		
		char operation = '+';
		
		switch(MathFunc.getRandomInRange(1, 2)) {
		case 1: operation = '+'; break;
		case 2: operation = '-'; break;
		}
		
		return x + "" + operation + "" + y;
	}
	
}
