package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OwnerDashboard implements ActionListener{

	JFrame ownerFrame = new JFrame();
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	
	private JButton buttonAddJob;
	private JPanel panel;
	
	public OwnerDashboard() {
	
		createButtonAddJob();
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
		
		if(e.getSource() == buttonAddJob)
		{
			
		}
		
		
		
	}
	
	private void createButtonAddJob() {
		buttonAddJob = new JButton("Add Job");
		buttonAddJob.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));
		buttonAddJob.setForeground(Color.white);
		buttonAddJob.setBounds(270, 360, 200, 40); 
		buttonAddJob.setBackground(Color.BLUE);
		buttonAddJob.setBorderPainted(false);
		buttonAddJob.addActionListener(this);
	}
	
	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color (32, 42, 68));
		panel.add(buttonAddJob);
		ownerFrame.add(panel);
	
	}
	
}