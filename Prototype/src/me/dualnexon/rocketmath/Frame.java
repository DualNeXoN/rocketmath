package me.dualnexon.rocketmath;

import java.io.File;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Classa pre pracu s oknom a jeho komponentami
 * @author DualNexon
 *
 */
public class Frame {
	
	private Stage stage;
	private Scene scene;
	
	/**
	 * Konstruktor, ktory vytvori primarne okno aplikacie a aplikuje vychodzie nastavenia
	 */
	public Frame() {
		
		stage = new Stage();
		
		stage.setFullScreen(GlobalOptions.getFullscreenMode());
		stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		stage.setFullScreenExitHint(stage.getFullScreenExitKeyCombination() + " ukonci mod fullscreen");
		
		stage.setResizable(false);
		
		File iconPath = new File("assets" + File.separator + "icon.png");
		stage.getIcons().add(new Image(iconPath.toURI().toString()));
		
		
		setGroup(new Group());
		scene.setFill(Color.rgb(164, 164, 164));
		
	}
	
	/**
	 * Konstruktor, ktory vytvori primarne okno aplikacie a aplikuje vychodzie nastavenia s moznostou pomenovania okna
	 * @param frameTitle - meno okna
	 */
	public Frame(String frameTitle) {
		this();
		stage.setTitle(frameTitle);
	}
	
	/**
	 * Zobrazi/skryje okno
	 * @param value - TRUE zobrazi, FALSE skryje
	 */
	public void show(boolean value) {
		if(value) stage.show();
		else stage.hide();
	}
	
	/**
	 * Vrati stage okna
	 * @return
	 */
	public Stage getStage() {
		return stage;
	}
	
	/**
	 * Vrati scenu okna
	 * @return
	 */
	public Scene getScene() {
		return scene;
	}
	
	/**
	 * Nastavi scenu okna
	 * @param scene - scena
	 */
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	/**
	 * Vrati skupinu komponentov v kolekcii
	 * @return
	 */
	public Group getGroup() {
		return (Group) scene.getRoot();
	}
	
	public void setGroup(Group group) {
		scene = new Scene(group, GlobalOptions.getWindowWidth(), GlobalOptions.getWindowHeight());
		stage.setScene(scene);
	}
	
}
