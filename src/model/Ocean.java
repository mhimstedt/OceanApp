package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Ocean {

	private double width;
	private double height;

	private List<OceanObject> oceanObjects = new ArrayList<OceanObject>();

	private PlayerObject player;

	public Ocean(double width, double height) {

		this.width = width;
		this.height = height;

		player = (PlayerObject) OceanObjectFactory.createOceanObject("Player1", OceanObjectFactory.PLAYER, width / 2, height / 2, this);
		oceanObjects.add(player);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public List<ImageObject> getOceanObjects() {
		return Collections.unmodifiableList(oceanObjects);
	}

	public void addOceanObject(OceanObject oceanObject) {
		oceanObjects.add(oceanObject);
	}

	public boolean removeOceanObject(String name) {
		// TODO implement
		return true;
	}

	public PlayerObject getPlayer() {
		return player;
	}

	public void moveAll() {
		for (OceanObject obj1 : oceanObjects) {
			obj1.move();

			// Pruefung in Bubble ausgelagert
//			if (obj1 instanceof Bubble) {
//				for (OceanObject obj2 : oceanObjects) {
//					if (!(obj2 instanceof Bubble) && obj1.intersect(obj2)) {
//						obj1.dead = true;
//						break;
//					}
//				}
//			}
			
			// Pruefung in Fish ausgelagert
//			if (obj1 instanceof Fish) {
//				Fish fish = (Fish) obj1;
//				if (fish.intersect(player)) {
//					fish.dead = true;
//				}
//			}
			
		}
		
		// Entfernen aller Objekte mit dead = true

		// Ansatz 1: Ueber separate List und removeAll()
		// (Achtung: Entfernen von Objekten in einer Liste, waehrend diese durchlaufen wird, fuehrt zu einer ConcurrentModificationException) 
//		ArrayList<OceanObject> toRemove = new ArrayList<>();
//		for(OceanObject o : oceanObjects) {
//			if (o.dead) toRemove.add(o);
//		}
//		oceanObjects.removeAll(toRemove);
		
		// Ansatz 2a: Über einen sog. Predicate (boolean-valued function)
//		Predicate<OceanObject> myPredicate = new MyPredicate();
//		oceanObjects.removeIf(myPredicate);
		
		// Ansatz 2b: Dasselbe ueber einen Lamda-Ausdruck 
		// (Schnittstelle Predicate ist ein Interface mit nur einer funktionalen Methode, ein sog. funktionales Interface)
//		Predicate<OceanObject> myPredicate = (OceanObject o) -> (o.dead);
//		oceanObjects.removeIf(myPredicate);
		
		// Ansatz 2c: Wir sparen uns auch die Deklaration des Predicate
		oceanObjects.removeIf(o -> o.dead);
	}

	public void generateBubble() {
		double x = Math.random() * width;
		double y = Math.random() * height;

		OceanObject oceanObject = OceanObjectFactory.createOceanObject("Bubble", OceanObjectFactory.BUBBLE, x, y, this);

		if (oceanObject != null) {
			this.addOceanObject(oceanObject);
		}

	}

	public boolean isObjectInOcean(double x, double y, double width, double height) {
//		if (x > 0 && x + width < this.width && y > 0 && y + height < this.height)
//			return true;
//		else
//			return false;
		return (x > 0 && x + width < this.width && y > 0 && y + height < this.height);
	}

}

class MyPredicate implements Predicate<OceanObject> {
	@Override
	public boolean test(OceanObject o) {
		return o.dead;
	}
}
