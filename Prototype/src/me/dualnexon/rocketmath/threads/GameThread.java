package me.dualnexon.rocketmath.threads;

/**
 * Rodic hernych vlakien
 * @author DualNexon
 *
 */
public abstract class GameThread extends Thread {
	
	/**
	 * Necha zaspat vlakno na urcitu dobu
	 * @param millis - Milisekundy
	 */
	protected void sleepNow(long millis) {
		
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			System.out.println("Waking up thread " + getClass().getSimpleName());
		}
		
	}
	
	/**
	 * Vypise oznam o skonceni vlakna
	 */
	protected void stopMessage() {
		System.out.println("Stopping thread " + getClass().getSimpleName());
	}
	
}
