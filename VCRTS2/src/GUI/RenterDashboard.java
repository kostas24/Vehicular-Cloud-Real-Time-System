package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class RenterDashboard {

	JFrame renterFrame = new JFrame();
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	
	private JLabel nameLabel;
	private JPanel panel;
	
	public RenterDashboard() {
		nameLabel = new JLabel("Sample Renter"); //Should be users name top right corner of frame im thinking
		nameLabel.setBounds(0, 0, 200, 35);
		nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		nameLabel.setForeground(Color.white);
		
		createPanel();			
		renterFrame.setTitle("VCRTS - Vehicle Renter Dashboard"); //setting Title on top left corner of GUI
		
		ImageIcon CloudComputingIcon = new ImageIcon("Images/Cloud Computing.jpg");
		renterFrame.setIconImage(CloudComputingIcon.getImage()); //Changing Frame Icon to cloud computing icon
		
		//INPUTTING SIZE OF GUI from VARIABLES
		renterFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		renterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    renterFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color (32, 42, 68));
		panel.add(nameLabel);
		
		renterFrame.add(panel);
	
	}
	
}
