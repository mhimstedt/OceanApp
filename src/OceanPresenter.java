

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

import model.*;

public class OceanPresenter {

	private OceanApp window;

	private OceanCanvas oceanCanvas;

	private Ocean ocean;

	private Timer timer;

	private int frameTime = 10; // [ms]

	private int counter = 0;

	// Status der Tasten
	private Set<Integer> statusTasten = new HashSet<Integer>();

	public OceanPresenter(OceanApp window) {
		super();
		this.window = window;
		oceanCanvas = window.getOceanCanvas();

		int oceanWidth = Integer.parseInt(window.getTxtWidth().getText());
		int oceanHeight = Integer.parseInt(window.getTextHeight().getText());

		ocean = new Ocean(oceanWidth, oceanHeight);

		oceanCanvas.setPreferredSize(new Dimension(oceanWidth, oceanHeight));
		window.pack();
		oceanCanvas.setImageObjects(ocean.getOceanObjects());

		timer = new Timer(frameTime, e -> {

			updatePlayer();
			if (counter == 0) {
				ocean.generateBubble();
			}
			counter++;
			if (counter > 10) {
				counter = 0;
			}

			ocean.moveAll();			// Aktualisierung des Model-Zustands

//			oceanCanvas.setImageObjects(ocean.getOceanObjects());
			oceanCanvas.repaint();		// Neudarstellung des Models im View

		});
		timer.start();
	}

	private void updatePlayer() {

		ocean.getPlayer().clearDistances();

		if (statusTasten.contains(KeyEvent.VK_UP)) {
			ocean.getPlayer().setDistanceY(-frameTime);
		}
		if (statusTasten.contains(KeyEvent.VK_DOWN)) {
			ocean.getPlayer().setDistanceY(frameTime);
		}
		if (statusTasten.contains(KeyEvent.VK_LEFT)) {
			ocean.getPlayer().setDistanceX(-frameTime);
		}
		if (statusTasten.contains(KeyEvent.VK_RIGHT)) {
			ocean.getPlayer().setDistanceX(frameTime);
		}

	}

	public void addOceanObject() {

		String name = window.getTxtName().getText();
		String type = window.getCbxType().getSelectedItem().toString();
		int x = ((Number) window.getSpinX().getValue()).intValue();
		int y = ((Number) window.getSpinY().getValue()).intValue();

		OceanObject oceanObject = OceanObjectFactory.createOceanObject(name, type, x, y, ocean);

		if (oceanObject != null) {
			ocean.addOceanObject(oceanObject);
		}

		oceanCanvas.setImageObjects(ocean.getOceanObjects());
	}

	public void addPressedKey(int keyCode) {
		statusTasten.add(keyCode);
	}

	public void removePressedKey(int keyCode) {
		statusTasten.remove(keyCode);
	}

	public void updateOceanDimension() {
		int oceanWidth = Integer.parseInt(window.getTxtWidth().getText());
		int oceanHeight = Integer.parseInt(window.getTextHeight().getText());

		ocean.setWidth(oceanWidth);
		ocean.setHeight(oceanHeight);
				
		oceanCanvas.setPreferredSize(new Dimension(oceanWidth, oceanHeight));
		window.pack();
	}

}
