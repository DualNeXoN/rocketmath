package me.dualnexon.rocketmath.ui;

import java.util.LinkedList;

import javafx.geometry.Bounds;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import me.dualnexon.rocketmath.GameManager;

/**
 * Trieda spracuva vstup z klavesnice
 * @author DualNexon
 *
 */
public class PlayerInput implements IGameUI {
	
	private Text text;
	private Bounds bounds;
	private LinkedList<Long> userSubmit = new LinkedList<>();
	
	
	/**
	 * Konstruktor vytvori UI element vstupu z klavesnice a zacne inicializuje event vstupu
	 */
	public PlayerInput() {
		
		text = new Text("");
		text.setFont(new Font(58));
		text.setFill(Color.WHITE);
		text.setStroke(Color.RED);
		text.setStrokeWidth(1.5);
		text.setTextAlignment(TextAlignment.CENTER);
		
		GameManager.getGM().getMainFrame().getGroup().getChildren().add(text);
		updatePosition();
		
		GameManager.getGM().getMainFrame().getScene().setOnKeyPressed((e) -> onKeyPressed(e.getCode()));
		
	}
	
	/**
	 * Vykona sa po stlaceni lubovolnej klavesy. Filtruje vstup hraca a aktualizuje poziciu podla dlzky znakov (centruje)
	 * @param code - Tlacidlo
	 */
	private void onKeyPressed(KeyCode code) {
		
		if(code.equals(KeyCode.BACK_SPACE)) {
			
			if(text.getText().length() > 0) {
				text.setText(text.getText().substring(0, text.getText().length()-1));
			}
			
		} else if(Character.isDigit(code.getChar().charAt(0)) || code.isKeypadKey()) {
			
			if(Character.isDigit(code.getChar().charAt(0))) {
				text.setText(text.getText() + code.getChar());
			} else {
				text.setText(text.getText() + (char)(code.getChar().charAt(0) - 48));
			}
			
		} else if(code.getChar().charAt(0) == 109) {
			
			if(text.getText().length() == 0) {
				text.setText("-");				
			}
			
		} else if(code.equals(KeyCode.ENTER)) {
			
			if(text.getText().length() > 0) {
				userSubmit.addFirst(Long.parseLong(text.getText()));
				text.setText("");
			}
			
		}
		
		updatePosition();
	}
	
	/**
	 * Zisti, ci hrac poslal odpoved
	 * @return TRUE ano / FALSE nie
	 */
	public boolean hasSubmit() {
		return (userSubmit.size() > 0);
	}
	
	/**
	 * Vrati odpoved hraca a oznaci za spracovane zmazanim z listu
	 * @return
	 */
	public long getSubmit() {
		long value = userSubmit.getLast();
		userSubmit.removeLast();
		return value;
	}
	
	/**
	 * Responzivne updatne poziciu UI elementu
	 */
	private void updatePosition() {
		
		bounds = text.getLayoutBounds();
		
		text.setLayoutX(GameManager.getGM().getMainFrame().getScene().getWidth()/2-bounds.getWidth()/2);
		text.setLayoutY(GameManager.getGM().getMainFrame().getScene().getHeight()-40);
		
	}
	
	/**
	 * Aktualizuje UI
	 */
	@Override
	public void updateUI() {
		text.toFront();
	}
	
	/**
	 * Znici UI
	 */
	@Override
	public void destroyUI() {
		GameManager.getGM().getMainFrame().getGroup().getChildren().remove(text);
	}

}