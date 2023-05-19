

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

import javax.swing.JPanel;

import model.ImageObject;

public class OceanCanvas extends JPanel {
	
	private List<ImageObject> imageObjects = new ArrayList<ImageObject>();
		
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		for(ImageObject imageObject : imageObjects) {
			
			g.drawImage(imageObject.getImage(), (int) imageObject.getX(), (int) imageObject.getY(), null);
		
		}
		
	}

	public List<ImageObject> getImageObjects() {
		return imageObjects;
	}

	public void setImageObjects(List<ImageObject> imageObjects) {
		this.imageObjects = imageObjects;
	}
	
	

}
