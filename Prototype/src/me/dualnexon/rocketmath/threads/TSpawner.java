package me.dualnexon.rocketmath.threads;

import javafx.application.Platform;
import me.dualnexon.rocketmath.GameManager;
import me.dualnexon.rocketmath.MathFunc;
import me.dualnexon.rocketmath.objects.MathProblemPowerUp;
import me.dualnexon.rocketmath.objects.MathProblem;
import me.dualnexon.rocketmath.objects.MathProblemFalling;

/**
 * Vlakno spawnovania vytvara herne objekty na zaklade internej logiky
 * @author DualNexon
 *
 */
public class TSpawner extends GameThread {
	
	private GameManager gm = GameManager.getGM();
	private long millis;
	
	/**
	 * Konstruktor nastavi dåzku odstupu medzi vytvaranim novych instancii a samostatne sa  vlakno spusti
	 * @param millis - Milisekundy
	 */
	public TSpawner(long millis) {
		this.millis = millis;
		setDaemon(true);
		start();
	}
	
	/**
	 * Vytvara objekty s casovym odstupom dokym je vlajka behu hernej slucky v logickej jednotke
	 */
	@Override
	public void run() {
		
		while(gm.getGameRunning()) {
			
			Platform.runLater(new Runnable() {			
				@Override
				public void run() {
					
					if(MathProblemFalling.getFreezeSpeed() <= MathProblem.getMaxSpeed()/2)
						gm.getGameRoom().addObject(new MathProblemFalling());
					
					if(MathFunc.getRandomInRange(1, 100) < 29)
						gm.getGameRoom().addObject(new MathProblemPowerUp());
					
				}
			});
		
			sleepNow(millis);
			
		}
		
		stopMessage();
		
	}
	
}
