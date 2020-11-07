package me.dualnexon.rocketmath;

/**
 * Trieda hraca uchovava zivoty a pracu s nimi (zatial)
 * @author DualNexon
 *
 */
public class Player {
	
	private int health;
	
	public Player(int health) {
		this.health = health;
	}
	
	public Player() {
		this(GlobalOptions.getDefaultHealthCount());
	}
	
	/**
	 * Zisti, ci hrac ma este zivoty
	 * @return TRUE ma / FALSE nema
	 */
	public boolean hasHealth() {
		return (health > 0);
	}
	
	/**
	 * Vrati pocet zivotov
	 * @return
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Zvysi pocet zivotov o zadane mnozstvo
	 * @param value - mnozstvo
	 */
	public void incHealth(int value) {
		health += value;
	}
	
	/**
	 * Znizi pocet zivotov a zadane mnozstvo a zisti, ci hrac este ma zivoty. Ak nie, tak nastavi zastavi beh slucky (tzv. game over)
	 * @param value - mnozstvo
	 */
	public void decHealth(int value) {
		health -= value;
		if(!hasHealth()) GameManager.getGM().setGameRunning(false);
	}
	
}
