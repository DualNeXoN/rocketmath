import javafx.application.Application;
import javafx.stage.Stage;
import me.dualnexon.rocketmath.GameManager;
import me.dualnexon.rocketmath.GlobalOptions;

/**
 * Launch classa
 * @author DualNexon
 *
 */
public class Start extends Application {
	
	/**
	 * Main metoda vykonana hneï po spusteni do aplikacie
	 * @param args - spustacie argumenty
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Nacita globalne nastavenia pre aplikaciu a vnori sa do GameManagera
	 */
	@Override
	public void start(Stage arg0) throws Exception {
		GlobalOptions.loadDefault();
		new GameManager();
	}
	
}
