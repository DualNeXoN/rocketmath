package me.dualnexon.rocketmath.objects;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import me.dualnexon.rocketmath.GameManager;

/**
 * Abstraktna trieda vseobecneho herneho objektu od ktoreho dedia potomkovia zakladne atributy a vlastnosti
 * @author DualNexon
 *
 */
public abstract class GameObject extends Canvas {
	
	protected GraphicsContext g2d;
	protected double width, height;
	protected boolean toDestroy = false;
	protected double x, y;
	
	/**
	 * Konstruktor vytvori Canvas na zaklade zadanych rozmerov
	 * @param width - sirka
	 * @param height - vyska
	 */
	public GameObject(double width, double height) {
		super(width, height);
		g2d = getGraphicsContext2D();
	}
	
	/**
	 * Konstruktor vytvori Canvas s nulovymi rozmermi
	 */
	public GameObject() {
		this(0, 0);
	}
	
	/**
	 * Znici instanciu
	 */
	public void destroy() {
		GameManager.getGM().getGameRoom().removeObject(this);
	}
	
	/**
	 * Nastavi vlajku pre najblizsie znicenie instancie
	 */
	public void setToDestroy() {
		toDestroy = true;
	}
	
	/**
	 * Vrati vlajku najblizsieho znicenia instancie
	 * @return TRUE ma sa najblizsie znicit / FALSE nema sa este znicit
	 */
	public boolean getToDestroy() {
		return toDestroy;
	}
	
	public abstract void tick();
	
}
