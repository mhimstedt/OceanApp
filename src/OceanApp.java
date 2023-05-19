

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class OceanApp extends JFrame {

//	private OceanApp frame;
	private JPanel panel;
	private JPanel panelOceanDimension;
	private JPanel panelAddOceanObject;
	private JLabel lblWidth;
	private JTextField txtWidth;
	private JLabel lblHeight;
	private JTextField textHeight;
	private OceanCanvas oceanCanvas;
	private JLabel lblType;
	private JLabel lblName;
	private JTextField txtName;
	private JComboBox cbxType;
	private JButton btnAdd;
	private JLabel lblX;
	private JLabel lblY;
	private JSpinner spinX;
	private JButton btnOk;
	private JSpinner spinY;
	
	private OceanPresenter presenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OceanApp window = new OceanApp();	
					window.setResizable(false);					
					OceanPresenter presenter = new OceanPresenter(window);
					window.setPresenter(presenter);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OceanApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setAlignOnBaseline(true);
		this.add(panel, BorderLayout.NORTH);
		
		panelOceanDimension = new JPanel();
		panelOceanDimension.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ocean Dimension", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panelOceanDimension);
		GridBagLayout gbl_panelOceanDimension = new GridBagLayout();
		gbl_panelOceanDimension.columnWidths = new int[]{0, 0, 0};
		gbl_panelOceanDimension.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelOceanDimension.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelOceanDimension.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelOceanDimension.setLayout(gbl_panelOceanDimension);
		
		lblWidth = new JLabel("Width");
		GridBagConstraints gbc_lblWidth = new GridBagConstraints();
		gbc_lblWidth.insets = new Insets(0, 5, 5, 5);
		gbc_lblWidth.gridx = 0;
		gbc_lblWidth.gridy = 0;
		panelOceanDimension.add(lblWidth, gbc_lblWidth);
		
		txtWidth = new JTextField();
		txtWidth.setText("800");
		GridBagConstraints gbc_txtWidth = new GridBagConstraints();
		gbc_txtWidth.insets = new Insets(0, 10, 5, 10);
		gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWidth.gridx = 1;
		gbc_txtWidth.gridy = 0;
		panelOceanDimension.add(txtWidth, gbc_txtWidth);
		txtWidth.setColumns(20);
		
		lblHeight = new JLabel("Height");
		GridBagConstraints gbc_lblHeight = new GridBagConstraints();
		gbc_lblHeight.anchor = GridBagConstraints.EAST;
		gbc_lblHeight.insets = new Insets(0, 5, 5, 5);
		gbc_lblHeight.gridx = 0;
		gbc_lblHeight.gridy = 1;
		panelOceanDimension.add(lblHeight, gbc_lblHeight);
		
		textHeight = new JTextField();
		textHeight.setText("400");
		GridBagConstraints gbc_textHeight = new GridBagConstraints();
		gbc_textHeight.insets = new Insets(0, 10, 5, 10);
		gbc_textHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_textHeight.gridx = 1;
		gbc_textHeight.gridy = 1;
		panelOceanDimension.add(textHeight, gbc_textHeight);
		textHeight.setColumns(10);
		
		btnOk = new JButton("OK");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.anchor = GridBagConstraints.WEST;
		gbc_btnOk.insets = new Insets(0, 10, 10, 5);
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 2;
		panelOceanDimension.add(btnOk, gbc_btnOk);
		
		btnOk.addActionListener( e -> {
			presenter.updateOceanDimension();
		});
		
		
		panelAddOceanObject = new JPanel();
		panelAddOceanObject.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Ocean Object", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panelAddOceanObject);
		GridBagLayout gbl_panelAddOceanObject = new GridBagLayout();
		gbl_panelAddOceanObject.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panelAddOceanObject.rowHeights = new int[] {0, 0, 0};
		gbl_panelAddOceanObject.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelAddOceanObject.rowWeights = new double[]{0.0, 0.0, 0.0};
		panelAddOceanObject.setLayout(gbl_panelAddOceanObject);
		
		lblType = new JLabel("Type");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.anchor = GridBagConstraints.EAST;
		gbc_lblType.insets = new Insets(0, 5, 5, 5);
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 0;
		panelAddOceanObject.add(lblType, gbc_lblType);
		
		cbxType = new JComboBox();
		GridBagConstraints gbc_cbxType = new GridBagConstraints();
		gbc_cbxType.insets = new Insets(0, 0, 5, 5);
		gbc_cbxType.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxType.gridx = 1;
		gbc_cbxType.gridy = 0;
		panelAddOceanObject.add(cbxType, gbc_cbxType);
		
		lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 5, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		panelAddOceanObject.add(lblName, gbc_lblName);
		
		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 5);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 1;
		panelAddOceanObject.add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		lblY = new JLabel("Y");
		GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.insets = new Insets(0, 10, 5, 5);
		gbc_lblY.gridx = 2;
		gbc_lblY.gridy = 1;
		panelAddOceanObject.add(lblY, gbc_lblY);
		
		spinY = new JSpinner();
		GridBagConstraints gbc_spinY = new GridBagConstraints();
		gbc_spinY.ipadx = 40;
		gbc_spinY.insets = new Insets(0, 0, 5, 0);
		gbc_spinY.gridx = 3;
		gbc_spinY.gridy = 1;
		panelAddOceanObject.add(spinY, gbc_spinY);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.addOceanObject();
			}
		});
		
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.anchor = GridBagConstraints.WEST;
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 2;
		panelAddOceanObject.add(btnAdd, gbc_btnAdd);
		
		lblX = new JLabel("X");
		GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.insets = new Insets(0, 10, 5, 5);
		gbc_lblX.gridx = 2;
		gbc_lblX.gridy = 0;
		panelAddOceanObject.add(lblX, gbc_lblX);
		
		spinX = new JSpinner();
		GridBagConstraints gbc_spinX = new GridBagConstraints();
		gbc_spinX.ipadx = 40;
		gbc_spinX.insets = new Insets(0, 0, 5, 0);
		gbc_spinX.gridx = 3;
		gbc_spinX.gridy = 0;
		panelAddOceanObject.add(spinX, gbc_spinX);
		
		oceanCanvas = new OceanCanvas();
		oceanCanvas.setBackground(Color.BLUE);
		this.add(oceanCanvas, BorderLayout.CENTER);
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {

			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (e.getID() == KeyEvent.KEY_PRESSED) {
					presenter.addPressedKey(e.getKeyCode());
				} else if (e.getID() == KeyEvent.KEY_RELEASED) {
					presenter.removePressedKey(e.getKeyCode());
				}
				return true;
			}
			return false;

		});
		
		cbxType.setModel(new DefaultComboBoxModel(new String[] {"Fish", "Stone", "Plant"}));
		
		
	}

	public OceanCanvas getOceanCanvas() {
		return oceanCanvas;
	}

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	public JTextField getTextHeight() {
		return textHeight;
	}

	public void setTextHeight(JTextField textHeight) {
		this.textHeight = textHeight;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public JComboBox getCbxType() {
		return cbxType;
	}

	public void setCbxType(JComboBox cbxType) {
		this.cbxType = cbxType;
	}

	public JSpinner getSpinX() {
		return spinX;
	}

	public void setSpinX(JSpinner spinX) {
		this.spinX = spinX;
	}

	public JSpinner getSpinY() {
		return spinY;
	}

	public void setSpinY(JSpinner spinY) {
		this.spinY = spinY;
	}

	public OceanPresenter getPresenter() {
		return presenter;
	}

	public void setPresenter(OceanPresenter presenter) {
		this.presenter = presenter;
	}
	
	
	
	
	
	
	
	
}
