package model;

import java.awt.Image;

public class Fish extends OceanObject {

	private int direction = 1;
	public static final double MOVE_DISTANCE = 0.5;	
	
	
	public Fish(String name, double x, double y, double width, double height, Image image, Ocean ocean) {
		super(name, x, y, width, height, image, ocean);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		
		double xnew = x + direction * MOVE_DISTANCE;
		
		if(!ocean.isObjectInOcean(xnew, y, width, height)) {
			direction *= -1;
			xnew = x + direction*MOVE_DISTANCE;
		}

		if (this.intersect(ocean.getPlayer())) {
			dead = true;
		}

		x = xnew;
		
	}
	
	
	
	

}
