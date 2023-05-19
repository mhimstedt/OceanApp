package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OceanObjectFactory {

	public final static String PLAYER = "Player";
	public final static String FISH = "Fish";
	public final static String BUBBLE = "Bubble";

	
	public static OceanObject createOceanObject(String name, String type, double x, double y, Ocean ocean) {
		
		OceanObject result = null;
		
		switch(type) {
		case FISH:
			Image image = loadImage("img/fish1.png");
			if(image != null) {
				result = new Fish(name, x, y, image.getWidth(null), image.getHeight(null), image, ocean );
			}
			break;
		case PLAYER:
			Image imagePlayer = loadImage("img/fish2.png");
			if(imagePlayer != null) {
				result = new PlayerObject(name, x, y, imagePlayer.getWidth(null), imagePlayer.getHeight(null), imagePlayer, ocean, 0.1);
			}			
			break;
		case BUBBLE:
			image = loadImage("img/Bubble.png");
			if(image != null) {
				result = new Bubble(name, x, y, image.getWidth(null), image.getHeight(null), image, ocean);
			}			
			break;			
		}
		return result;
	}
	
	
	private static Image loadImage(String path) {
		
		Image result = null;
		try {
			result = ImageIO.read(new File(path));
			
		} catch (IOException e) {
			e.printStackTrace();
		}				
		return result;
	}
	
	
}
