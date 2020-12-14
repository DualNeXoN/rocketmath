package me.dualnexon.rocketmath;

import java.util.Random;

/**
 * Trieda pomocnych matematickych vypoctov a nahodneho generovania
 * @author DualNexon
 *
 */
public abstract class MathFunc {
	
	/**
	 * Vrati nahodne cislo vo zvolenom intervale
	 * @param min - Minimum z intervalu
	 * @param max - Maximum z intervalu
	 * @return
	 */
	public static int getRandomInRange(int min, int max) {
		
        if(min > max) {
        	int pom = max;
        	max = min;
        	min = pom;
        }
        
        return new Random().nextInt((max - min) + 1) + min;
    }
	
	public static double getPercentage(int max, int current) {
		return (current / (double)max) * 100;
	}
	
}
