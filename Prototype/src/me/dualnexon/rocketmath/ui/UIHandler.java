package me.dualnexon.rocketmath.ui;

import me.dualnexon.rocketmath.EGameState;

/**
 * Trieda pre spracovanie vsetkych UI elementov
 * @author DualNexon
 *
 */
public class UIHandler {
	
	private static UIHandler instance;
	
	/**
	 * Vrati staticku premennu aktualnej instancie
	 * @return
	 */
	public static UIHandler get() {
		return instance;
	}
	
	private UIGame game;
	private UIMainMenu mainMenu;
	
	/**
	 * Konstruktor ulozi vlastnu instanciu do statickej premennej
	 * @param state - Ktore UI ma vytvorit
	 */
	public UIHandler(EGameState state) {
		instance = this;
		
		switch(state) {
		case GAME_ROOM:
			game = new UIGame();
			break;
		case MAIN_MENU:
			mainMenu = new UIMainMenu();
			break;
		}
		
	}
	
	public UIGame game() {
		return game;
	}
	
	public UIMainMenu mainMenu() {
		return mainMenu;
	}
	
	/**
	 * Podtrieda pr pracu s UI na hernej ploche
	 * @author DualNexon
	 *
	 */
	public class UIGame implements IGameUI {
		
		private UIBackground uiBackground;
		private UIHealth uiHealth;
		private PlayerInput playerInput;
		
		/**
		 * Konstruktor vytvori UI
		 */
		public UIGame() {
			uiBackground = new UIBackground();
			uiHealth = new UIHealth();
			playerInput = new PlayerInput();
		}
		
		/**
		 * Aktualizuje UI
		 */
		@Override
		public void updateUI() {
			uiBackground.updateUI();
			uiHealth.updateUI();
			playerInput.updateUI();
		}
		
		/**
		 * Vr·ti inötanciu pre vstup hr·Ëa
		 * @return
		 */
		public PlayerInput getPlayerInput() {
			return playerInput;
		}
		
		/**
		 * Znici UI
		 */
		@Override
		public void destroyUI() {
			uiBackground.destroyUI();
			uiHealth.destroyUI();
			playerInput.destroyUI();
		}
		
	}
	
	public class UIMainMenu implements IGameUI {
		
		/**
		 * Aktualizuje UI
		 */
		@Override
		public void updateUI() {
		}
		
		/**
		 * Znici UI
		 */
		@Override
		public void destroyUI() {
		}
		
	}
	
}
