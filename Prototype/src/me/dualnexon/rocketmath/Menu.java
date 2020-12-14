package me.dualnexon.rocketmath;

import java.io.File;

import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Menu {
	
	private String pathButton = Sprite.ROOT_PATH + "button" + File.separator;
	private GameManager gm = GameManager.getGM();
	private Group group;
	
	private String[] desc = {
			"Desc 1",
			"Desc 2"
			};
	
	public Menu() {
		
		gm.getMainFrame().setGroup(new Group());
		group = gm.getMainFrame().getGroup();
		
		createBackground();
		createButtons();
		createLogo();
		//createDescription();
		
	}
	
	private void createBackground() {
		
		Canvas background = new Canvas(gm.getMainFrame().getScene().getWidth(), gm.getMainFrame().getScene().getHeight());
		background.getGraphicsContext2D().drawImage(new Image(new File(Sprite.ROOT_PATH + "background.png").toURI().toString()), 0, 0, background.getWidth(), background.getHeight());
		group.getChildren().add(background);
		
	}
	
	private void createLogo() {
		
		Canvas logo = new Canvas(600, 250);
		logo.getGraphicsContext2D().drawImage(new Image(new File(Sprite.ROOT_PATH + "logo.png").toURI().toString()), 0, 0, logo.getWidth(), logo.getHeight());
		group.getChildren().add(logo);
		logo.setLayoutX(550);
		logo.setLayoutY(100);
		
	}
	
	@SuppressWarnings("unused")
	private void createDescription() {
		
		for(int index = 0; index < desc.length; index++) {
			Text text = new Text(desc[index]);
			group.getChildren().add(text);
			text.setFont(new Font(40));
			text.setFill(Color.WHITE);
			text.setTextAlignment(TextAlignment.CENTER);
			double layoutX = 700;
			double layoutY = 400 + index*45;
			text.setLayoutX(layoutX);
			text.setLayoutY(layoutY);
		}
		
	}
	
	private void createButtons() {
		
		Canvas bPlayEasy = new Canvas(400, 80);
		bPlayEasy.getGraphicsContext2D().drawImage(new Image(new File(pathButton + "button2.png").toURI().toString()), 0, 0, bPlayEasy.getWidth(), bPlayEasy.getHeight());
		bPlayEasy.getGraphicsContext2D().setFill(Color.WHITE);
		bPlayEasy.getGraphicsContext2D().setFont(new Font(36));
		bPlayEasy.getGraphicsContext2D().setTextAlign(TextAlignment.CENTER);
		bPlayEasy.getGraphicsContext2D().fillText("¼ahká obtiažnos", bPlayEasy.getWidth()/2, 57);
		group.getChildren().add(bPlayEasy);
		bPlayEasy.setLayoutX(40);
		bPlayEasy.setLayoutY(60);
		
		bPlayEasy.setOnMouseEntered((e) -> {
			gm.getMainFrame().getScene().setCursor(Cursor.HAND);
		});
		
		bPlayEasy.setOnMouseExited((e) -> {
			gm.getMainFrame().getScene().setCursor(Cursor.DEFAULT);
		});
		
		bPlayEasy.setOnMousePressed((e) -> {
			gm.runGame(EDifficulty.EASY);
		});
		
		Canvas bPlayMedium = new Canvas(400, 80);
		bPlayMedium.getGraphicsContext2D().drawImage(new Image(new File(pathButton + "button1.png").toURI().toString()), 0, 0, bPlayMedium.getWidth(), bPlayMedium.getHeight());
		bPlayMedium.getGraphicsContext2D().setFill(Color.WHITE);
		bPlayMedium.getGraphicsContext2D().setFont(new Font(36));
		bPlayMedium.getGraphicsContext2D().setTextAlign(TextAlignment.CENTER);
		bPlayMedium.getGraphicsContext2D().fillText("Stredná obtiažnos", bPlayMedium.getWidth()/2, 57);
		group.getChildren().add(bPlayMedium);
		bPlayMedium.setLayoutX(40);
		bPlayMedium.setLayoutY(170);
		
		bPlayMedium.setOnMouseEntered((e) -> {
			gm.getMainFrame().getScene().setCursor(Cursor.HAND);
		});
		
		bPlayMedium.setOnMouseExited((e) -> {
			gm.getMainFrame().getScene().setCursor(Cursor.DEFAULT);
		});
		
		bPlayMedium.setOnMousePressed((e) -> {
			gm.runGame(EDifficulty.MEDIUM);
		});
		
		Canvas bPlayHard = new Canvas(400, 80);
		bPlayHard.getGraphicsContext2D().drawImage(new Image(new File(pathButton + "button0.png").toURI().toString()), 0, 0, bPlayHard.getWidth(), bPlayHard.getHeight());
		bPlayHard.getGraphicsContext2D().setFill(Color.WHITE);
		bPlayHard.getGraphicsContext2D().setFont(new Font(36));
		bPlayHard.getGraphicsContext2D().setTextAlign(TextAlignment.CENTER);
		bPlayHard.getGraphicsContext2D().fillText("ažká obtiažnos", bPlayHard.getWidth()/2, 57);
		group.getChildren().add(bPlayHard);
		bPlayHard.setLayoutX(40);
		bPlayHard.setLayoutY(280);
		
		bPlayHard.setOnMouseEntered((e) -> {
			gm.getMainFrame().getScene().setCursor(Cursor.HAND);
		});
		
		bPlayHard.setOnMouseExited((e) -> {
			gm.getMainFrame().getScene().setCursor(Cursor.DEFAULT);
		});
		
		bPlayHard.setOnMousePressed((e) -> {
			gm.runGame(EDifficulty.HARD);
		});
		
		Canvas bExit = new Canvas(400, 80);
		bExit.getGraphicsContext2D().drawImage(new Image(new File(pathButton + "button3.png").toURI().toString()), 0, 0, bExit.getWidth(), bExit.getHeight());
		bExit.getGraphicsContext2D().setFill(Color.WHITE);
		bExit.getGraphicsContext2D().setFont(new Font(36));
		bExit.getGraphicsContext2D().setTextAlign(TextAlignment.CENTER);
		bExit.getGraphicsContext2D().fillText("Ukonèi hru", bExit.getWidth()/2, 57);
		group.getChildren().add(bExit);
		bExit.setLayoutX(40);
		bExit.setLayoutY(520);
		
		bExit.setOnMouseEntered((e) -> {
			gm.getMainFrame().getScene().setCursor(Cursor.HAND);
		});
		
		bExit.setOnMouseExited((e) -> {
			gm.getMainFrame().getScene().setCursor(Cursor.DEFAULT);
		});
		
		bExit.setOnMousePressed((e) -> {
			System.exit(0);
		});
		
	}
	
}
