package me.dualnexon.rocketmath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.scene.Group;
import me.dualnexon.rocketmath.objects.GameObject;

/**
 * Classa pre hernu plochu ma na starost pracu s hernymi objektami
 * @author DualNexon
 *
 */
public class GameRoom {
	
	private Group group;
	private List<GameObject> objects = new ArrayList<>();
	
	/**
	 * Konstruktor ulozi instanciu korena objektov pre okno
	 * @param group
	 */
	public GameRoom(Group group) {
		this.group = group;
	}
	
	/**
	 * Vrati kolekciu instancii vsetkych hernych objektov
	 * @return - Kolekcia hernych objektov
	 */
	public List<GameObject> getObjects() {
		return objects;
	}
	
	/**
	 * Prida instanciu herneho objektu do kolekcie a do sceny
	 * @param obj - Herny objekt
	 */
	public void addObject(GameObject obj) {
		objects.add(obj);
		group.getChildren().add(obj);
	}
	
	/**
	 * Odstrani instanciu herneho objektu z kolekcie a zo sceny
	 * @param obj - Herny objekt
	 */
	public void removeObject(GameObject obj) {
		objects.remove(obj);
		group.getChildren().remove(obj);
	}
	
	/**
	 * Zisti pocet vytvorenych a aktivnych vsetkych hernych objektov
	 * @return
	 */
	public int getObjectCount() {
		return getObjectCount(GameObject.class.getName());
	}
	
	/**
	 * Zisti pocet vytvorenych a aktivnych hernych objektov zvoleneho typu
	 * @param className - Meno triedy (typ objektu)
	 * @return
	 */
	public int getObjectCount(String className) {
		
		int count = 0;
		
		Iterator<GameObject> i = objects.iterator();
		while(i.hasNext()) {
			GameObject obj = (GameObject) i.next();
			
			try {
				if(Class.forName(className).isInstance(obj)) count++;
			} catch (ClassNotFoundException e) {
				System.err.println("Vyskytla sa chyba pri scitani instancii objektu \"" + className + "\" (meno objektu neexistuje)");
				e.printStackTrace();
			}
		}
		
		return count;
	}
	
}
