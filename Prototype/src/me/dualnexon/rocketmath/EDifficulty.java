package me.dualnexon.rocketmath;

public enum EDifficulty {
	
	EASY(180, 15, 6000, 1, 0.002),
	MEDIUM(120, 8, 4000, 1.5, 0.003),
	HARD(60, 5, 2500, 2, 0.005);
	
	public int time;
	public int lives;
	public int spawnTime;
	public double maxSpeed;
	public double recoveryFactor;
	
	private EDifficulty(int time, int lives, int spawnTime, double maxSpeed, double recoveryFactor) {
		this.time = time;
		this.lives = lives;
		this.spawnTime = spawnTime;
		this.maxSpeed = maxSpeed;
		this.recoveryFactor = recoveryFactor;
	}
	
}
