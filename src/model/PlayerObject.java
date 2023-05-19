package model;

import java.awt.Image;

public class PlayerObject extends OceanObject {

	private double distanceX;
	private double distanceY;

	private double speed; // [px]/[ms]

	public PlayerObject(String name, double x, double y, double width, double height, Image image, Ocean ocean,
			double speed) {
		super(name, x, y, width, height, image, ocean);

		this.speed = speed;

	}

	@Override
	public void move() {

		double xnew = x + distanceX;
		double ynew = y + distanceY;

		if (!ocean.isObjectInOcean(x, ynew, width, height)) {
			ynew = y;
		}

		if (!ocean.isObjectInOcean(xnew, y, width, height)) {
			xnew = x;
		}

		x = xnew;
		y = ynew;

	}

	public void clearDistances() {
		distanceX = 0.0;
		distanceY = 0.0;
	}

	public void setDistanceX(int frametime) {
		distanceX = frametime * speed; // [px]
	}

	public void setDistanceY(int frametime) {
		distanceY = frametime * speed; // [px]
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

}
