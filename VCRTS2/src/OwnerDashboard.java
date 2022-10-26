import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class OwnerDashboard {

	JFrame ownerFrame = new JFrame();
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	
	private JLabel nameLabel;
	private JPanel panel;
	
	public OwnerDashboard() {
		nameLabel = new JLabel("Sample Owner"); //Should be users name top right corner of frame im thinking
		nameLabel.setBounds(0, 0, 200, 35);
		nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		nameLabel.setForeground(Color.white);
		
		createPanel();			
		ownerFrame.setTitle("VCRTS - Vehicle Owner Dashboard"); //setting Title on top left corner of GUI
		
		ImageIcon CloudComputingIcon = new ImageIcon("Images/Cloud Computing.jpg");
		ownerFrame.setIconImage(CloudComputingIcon.getImage()); //Changing Frame Icon to cloud computing icon
		
		//INPUTTING SIZE OF GUI from VARIABLES
		ownerFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		ownerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    ownerFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color (32, 42, 68));
		panel.add(nameLabel);
		
		ownerFrame.add(panel);
	
	}
	
}
