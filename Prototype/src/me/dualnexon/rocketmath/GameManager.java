package me.dualnexon.rocketmath;

import me.dualnexon.rocketmath.threads.TGameLoop;
import me.dualnexon.rocketmath.ui.UIHandler;

/**
 * Manazer hry ma na starost chod celej aplikacie
 * @author DualNexon
 *
 */
public class GameManager {
	
	private static GameManager instance;
	
	/**
	 * Vrati staticku premennu aktualnej instancie
	 * @return
	 */
	public static GameManager getGM() {
		return instance;
	}
	
	/**
	 * Zisti, ci instancia manazera existuje
	 * @return TRUE existuje / FALSE neexistuje
	 */
	public static boolean exists() {
		return (instance != null);
	}
	
	private Frame mainFrame;
	private boolean gameRunning = false;
	private GameRoom gameRoom;
	private Player player;
	
	/**
	 * Konstruktor ulozi vlastnu instanciu do statickej premennej a vytvori instanciu objektu Frame. Nasledne spusti hru
	 */
	public GameManager() {
		if(!exists()) {
			instance = this;
			
			mainFrame = new Frame("Rocket Math");
			mainFrame.show(true);
		}
		
		runGame();
		
	}
	
	/**
	 * Vykona vsetko potrebne pre spustenie hlavneho cyklu hry
	 */
	private void runGame() {
		
		gameRoom = new GameRoom(mainFrame.getGroup());
		constructGame();		
		new TGameLoop();
		
	}
	
	/**
	 * Vytvori hraca a inicializuje stream pre vstup z klavesnice
	 */
	private void constructGame() {
		player = new Player();
		new UIHandler(EGameState.GAME_ROOM);
	}
	
	/**
	 * Vrati instanciu hraca
	 * @return
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Vrati instanciu hlavneho okna
	 * @return
	 */
	public Frame getMainFrame() {
		return mainFrame;
	}
	
	/**
	 * Vrati instanciu hernej plochy v ktorej su ulozene instancie hernych objektov a disponuje funkciami pre ich modifikaciu
	 * @return
	 */
	public GameRoom getGameRoom() {
		return gameRoom;
	}
	
	/**
	 * Vrati logicku hodnotu, ci ma herna slucka stale bezat
	 * @return TRUE ano(hra stale prebieha) / FALSE nie(hra ma skoncit ak sa tak este nestalo)
	 */
	public boolean getGameRunning() {
		return gameRunning;
	}
	
	/**
	 * Nastavi logicku hodnotu bezania hernej slucky
	 * @param gameRunning - TRUE ma bezat / FALSE ma skoncit
	 */
	public void setGameRunning(boolean gameRunning) {
		this.gameRunning = gameRunning;
	}
	
}
