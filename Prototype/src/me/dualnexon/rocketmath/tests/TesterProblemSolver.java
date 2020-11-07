package me.dualnexon.rocketmath.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import me.dualnexon.rocketmath.objects.MathProblem;
import me.dualnexon.rocketmath.objects.MathProblemFalling;

/**
 * Tester vypoctov matematickych prikladov
 * @author DualNexon
 *
 */
class TesterProblemSolver {

	@Test
	void test() {
		
		MathProblem mathProblem = new MathProblemFalling("1+1");
		assertEquals(2, mathProblem.getProblemSolved());
		
		mathProblem = new MathProblemFalling("1+3");
		assertEquals(4, mathProblem.getProblemSolved());
		
		mathProblem = new MathProblemFalling("3+1");
		assertEquals(4, mathProblem.getProblemSolved());
		
		mathProblem = new MathProblemFalling("10+10");
		assertEquals(20, mathProblem.getProblemSolved());
		
		mathProblem = new MathProblemFalling("16+19");
		assertEquals(35, mathProblem.getProblemSolved());
		
		mathProblem = new MathProblemFalling("21+8");
		assertEquals(29, mathProblem.getProblemSolved());
		
		mathProblem = new MathProblemFalling("18+22");
		assertEquals(40, mathProblem.getProblemSolved());
		
	}

}
