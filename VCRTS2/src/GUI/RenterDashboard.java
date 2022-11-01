package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import ObjectClasses.Job;
import ObjectClasses.VehicleRenter;

public class RenterDashboard implements ActionListener{

	JFrame renterFrame = new JFrame();
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	
	private JLabel nameLabel;
	private JPanel panel;
	private JButton buttonAddJob;
	
	
	//*********************************
	private Job jobs = new Job(0, null, 0, 0); //how can i get values that we inputted in GUI?
	private VehicleRenter vr = new VehicleRenter(null, null, 0, null, 0, null, 0, 0); //how can i get values that we inputted in GUI?
	
	public RenterDashboard() {
		nameLabel = new JLabel("Sample Renter"); //Should be users name top right corner of frame im thinking
		nameLabel.setBounds(0, 0, 200, 35);
		nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		nameLabel.setForeground(Color.white);
		createButtonAddJob();
		createPanel();			
		renterFrame.setTitle("VCRTS - Vehicle Renter Dashboard"); //setting Title on top left corner of GUI
		
		ImageIcon CloudComputingIcon = new ImageIcon("Images/Cloud Computing.jpg");
		renterFrame.setIconImage(CloudComputingIcon.getImage()); //Changing Frame Icon to cloud computing icon
		
		//INPUTTING SIZE OF GUI from VARIABLES
		renterFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		renterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    renterFrame.setVisible(true);
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
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == buttonAddJob)
		{
			
		}
	}
	
	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color (32, 42, 68));
		panel.add(nameLabel);
		panel.add(buttonAddJob);
		renterFrame.add(panel);
	
	}
	
}
