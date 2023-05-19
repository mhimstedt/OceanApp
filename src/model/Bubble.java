package model;

import java.awt.Image;

public class Bubble extends OceanObject {
	
	public static final double MOVE_DISTANCE = 0.2;	

	public Bubble(String name, double x, double y, double width, double height, Image image, Ocean ocean) {
		super(name, x, y, width, height, image, ocean);
	
	}

	@Override
	public void move() {
		double ynew = y - MOVE_DISTANCE;
		
		if(!ocean.isObjectInOcean(x, ynew, width, height)) {
			dead = true;
		}
		
		for (ImageObject imgObj : ocean.getOceanObjects()) {
			OceanObject oceanObj = (OceanObject) imgObj;
			if (!(oceanObj instanceof Bubble) && intersect(oceanObj)) {
				dead = true;
				break;
			}
		}
		
		y = ynew;
		
	}
	
	

}
