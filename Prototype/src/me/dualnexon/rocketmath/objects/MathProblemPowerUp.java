package me.dualnexon.rocketmath.objects;

import java.io.File;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import me.dualnexon.rocketmath.GameManager;
import me.dualnexon.rocketmath.MathFunc;
import me.dualnexon.rocketmath.ProblemGenerator;
import me.dualnexon.rocketmath.Sprite;
import me.dualnexon.rocketmath.Timer;

public class MathProblemPowerUp extends MathProblem {
	
	private static final Image imgFreeze = new Image(new File(Sprite.ROOT_PATH + "freeze" + File.separator + "snow0.png").toURI().toString());
	private static final Image imgTime = new Image(new File(Sprite.ROOT_PATH + "time" + File.separator + "time0.png").toURI().toString());
	
	private EPowerUp powerUp;
	private Timer timer;
	private Canvas bar;
	private Canvas icon;
	
	public MathProblemPowerUp(String problem, EPowerUp powerUp) {
		super(problem);
		if((MathProblemFalling.getFreezeSpeed() > MathProblem.getMaxSpeed()) && powerUp.equals(EPowerUp.FREEZE)) powerUp = EPowerUp.TIME;
		this.powerUp = powerUp;
		
		timer = new Timer(GameManager.getGM().getGameDifficulty().spawnTime*2);
		
		createBar();
		createIcon();
		
	}
	
	public MathProblemPowerUp() {
		this(ProblemGenerator.generate(), ((MathFunc.getRandomInRange(1, 2) == 1) ? EPowerUp.TIME : EPowerUp.FREEZE));
	}
	
	public MathProblemPowerUp(String problem) {
		this(problem, ((MathFunc.getRandomInRange(1, 2) == 1) ? EPowerUp.TIME : EPowerUp.FREEZE));
	}
	
	public MathProblemPowerUp(EPowerUp powerUp) {
		this(ProblemGenerator.generate(), powerUp);
	}
	
	private void createBar() {
		bar = new Canvas(getWidth(), 10);
		GameManager.getGM().getMainFrame().getGroup().getChildren().add(bar);
		bar.setLayoutX(x);
		bar.setLayoutY(getLayoutY() - bar.getHeight() + 4);
		renderBar();
	}
	
	private void createIcon() {
		if(powerUp.equals(EPowerUp.FREEZE)) icon = new Canvas(44, 44);
		else icon = new Canvas(92, 64);
		GameManager.getGM().getMainFrame().getGroup().getChildren().add(icon);
		icon.setLayoutX(x + (getWidth() / 2) - (icon.getWidth() / 2));
		int posun = -4;
		if(powerUp.equals(EPowerUp.TIME)) posun = 8;
		icon.setLayoutY(bar.getLayoutY() - icon.getHeight() + posun);
		
		Image img = null;
		if(powerUp.equals(EPowerUp.FREEZE)) {
			img = imgFreeze;
		} else {
			img = imgTime;
		}
		
		icon.getGraphicsContext2D().drawImage(img, 0, 0, icon.getWidth(), icon.getHeight());
	}
	
	private void renderBar() {
		bar.getGraphicsContext2D().clearRect(0, 0, bar.getWidth(), bar.getHeight());
		bar.getGraphicsContext2D().setFill(powerUp.color);
		bar.getGraphicsContext2D().fillRect(0, 0, (bar.getWidth()/100d)*timer.getPercentage(), bar.getHeight());
		bar.getGraphicsContext2D().setStroke(Color.WHITE);
		bar.getGraphicsContext2D().setLineWidth(3);
		bar.getGraphicsContext2D().strokeRect(0, 0, bar.getWidth(), bar.getHeight());
	}
	
	@Override
	protected void generatePosition() {
		
		x = GameManager.getGM().getMainFrame().getScene().getWidth()-40-getWidth();
		y = MathFunc.getRandomInRange(30, (int)(GameManager.getGM().getMainFrame().getScene().getHeight()-40-getHeight()));
		
		setLayoutX(x);
		setLayoutY(y);
		
	}
	
	@Override
	public void tick() {
		renderBar();
		if(timer.isOver()) setToDestroy();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		
		timer.destroy();
		GameManager.getGM().getMainFrame().getGroup().getChildren().remove(bar);
		GameManager.getGM().getMainFrame().getGroup().getChildren().remove(icon);
		
		if(!timer.isOver()) {
			if(powerUp.equals(EPowerUp.TIME)) {
				GameManager.getGM().getTimeLeft().addTime(10);
			} else {
				MathProblemFalling.incFreezeSpeed(0.5);
			}			
		}
		
	}
	
}
