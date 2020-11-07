package me.dualnexon.rocketmath.objects;

import org.mariuszgromada.math.mxparser.Expression;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import me.dualnexon.rocketmath.ProblemGenerator;

/**
 * Vseobecna trieda hernych objektov matematickych prikladov
 * @author DualNexon
 *
 */
public abstract class MathProblem extends GameObject {
	
	protected String problem;
	protected long solved;
	protected double speed = 1.5;
	
	/**
	 * Konstruktor vypocita z parametru matematicky priklad, vytvori a vyrenderuje grafiku objektu, responzivne si zvoli rozmery a vygeneruje nahodnu polohu na osi X
	 * @param problem - Matematicky priklad
	 */
	public MathProblem(String problem) {
		super();
		this.problem = problem + "=?";
		solved = (int) new Expression(problem).calculate();
		
		g2d.setFont(new Font(46));
		
		Text text = new Text(this.problem);
		text.setFont(g2d.getFont());
		Bounds bounds = text.getLayoutBounds();
		
		width = bounds.getWidth();
		height = bounds.getHeight() / 1.4;
		setWidth(width);
		setHeight(height);
		
		render();
		generatePosition();
	}
	
	/**
	 * Konstruktor vypocita nahodny matematicky priklad, vytvori a vyrenderuje grafiku objektu, responzivne si zvoli rozmery a vygeneruje nahodnu polohu na osi X
	 */
	public MathProblem() {
		this(ProblemGenerator.generate());
	}
	
	/**
	 * Vygeneruje nahodnu polohu na osi X
	 */
	protected abstract void generatePosition();
	
	/**
	 * Vyrenderuje graficke prvky objektu
	 */
	protected void render() {
		
		g2d.setFill(Color.WHITE);
		g2d.fillText(problem, 0, getHeight()-1);
		g2d.setStroke(Color.BLACK);
		g2d.setLineWidth(1.5);
		g2d.strokeText(problem, 0, getHeight()-1);
		
	}
	
	/**
	 * Vrati spravnu odpoved matematickeho prikladu
	 * @return
	 */
	public long getProblemSolved() {
		return solved;
	}
	
	/**
	 * Vrati zapis matematickeho prikladu
	 * @return
	 */
	public String getProblem() {
		return problem;
	}
	
	/**
	 * Vykona sa kazdy update hry. Aplikuje pohyb objektu a zisti, ci je mozne instanciu znicit
	 */
	@Override
	public abstract void tick();
	
}
