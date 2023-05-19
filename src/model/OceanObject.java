package model;

import java.awt.Image;

public abstract class OceanObject implements ImageObject {

	private String name;

	protected double x;
	protected double y;

	protected double width;
	protected double height;

	private Image image;

	protected Ocean ocean;

	protected boolean dead;

	public OceanObject(String name, double x, double y, double width, double height, Image image, Ocean ocean) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
		this.ocean = ocean;
	}

	public String getName() {
		return name;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public boolean intersect(OceanObject oceanObject) {		
		return !(this.x + this.width < oceanObject.x || this.y + this.height < oceanObject.y
				|| oceanObject.x + oceanObject.width < this.x || oceanObject.y + oceanObject.height < this.y);
	}

	@Override
	public Image getImage() {
		return image;
	}

	public abstract void move();

}
