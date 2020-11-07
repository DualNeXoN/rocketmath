package me.dualnexon.rocketmath.threads;

import java.util.Iterator;

import javafx.application.Platform;
import me.dualnexon.rocketmath.GameManager;
import me.dualnexon.rocketmath.GlobalOptions;
import me.dualnexon.rocketmath.objects.GameObject;
import me.dualnexon.rocketmath.objects.MathProblem;
import me.dualnexon.rocketmath.ui.UIHandler;

/**
 * Vlakno hernej slucky ma na starost vykonavanie prac a modifikacii hernych instancii v presne urcenom case a vyhodnocuje odpovede hraca
 * @author DualNexon
 *
 */
public class TGameLoop extends GameThread {
	
	private GameManager gm = GameManager.getGM();
	private Thread spawner;
	private long gameTickSleep;
	
	/**
	 * Konstruktor vypocita cas odstupu medzi updatmi hry, vytvori vlakno pre spawnovanie matematickych prikladov, nastavi vlajku behu hernej slucky na TRUE 
	 * a samostatne sa vlakno spusti
	 */
	public TGameLoop() {
		this.gameTickSleep = 1000 / GlobalOptions.getGameTick();
		setDaemon(true);
		
		spawner = new TSpawner(2000);
		
		gm.setGameRunning(true);
		start();
	}
	
	/**
	 * Herna slucka, ktora bezi dokym je vlajka behu hernej slucky v logickej jednotke. Spracuva odpovede hraca, vykonava tick hernych objektov a zistuje,
	 * ci je treba instancie znicit
	 */
	@Override
	public void run() {
		
		while(gm.getGameRunning()) {
			Platform.runLater(new Runnable() {			
				@Override
				public void run() {
					checkPlayerInput();
					if(gm.getGameRunning()) {
						tick();
					}
					UIHandler.get().game().updateUI();
				}
			});
			sleepNow(gameTickSleep);
		}
		
		try {
			spawner.interrupt();
			spawner.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		stopMessage();
	}
	
	/**
	 * Spracovanie odpovedi hraca
	 */
	private void checkPlayerInput() {
		
		if(UIHandler.get().game().getPlayerInput().hasSubmit()) {
			
			boolean correct = false;
			long submit = UIHandler.get().game().getPlayerInput().getSubmit();
			
			Iterator<GameObject> i = gm.getGameRoom().getObjects().iterator();
			while(i.hasNext()) {
				
				GameObject obj = i.next();
				
				if(obj instanceof MathProblem) {
					
					MathProblem mathProblem = (MathProblem) obj;
					
					if(mathProblem.getProblemSolved() == submit) {
						gm.getGameRoom().removeObject(mathProblem);
						correct = true;
						break;
					}
					
				}
				
			}
			
			if(!correct) {
				gm.getPlayer().decHealth(1);
			}
			
		}
		
	}
	
	/**
	 * Vykona vseobecny tick objektov na zaklade postupnej logiky
	 */
	private void tick() {
		tickObjects();
		destroyObjects();
	}
	
	/**
	 * Vykona iba tick objektov
	 */
	private void tickObjects() {
		
		Iterator<GameObject> i = gm.getGameRoom().getObjects().iterator();
		while(i.hasNext()) {
			i.next().tick();
		}
		
	}
	
	/**
	 * Znici objekty, ktore maju vlajku znicenia nastavenu na TRUE
	 */
	private void destroyObjects() {
		
		for(int index = gm.getGameRoom().getObjects().size()-1; index >= 0; index--) {
			GameObject obj = gm.getGameRoom().getObjects().get(index);
			if(obj.getToDestroy()) obj.destroy();
		}
		
	}

}
