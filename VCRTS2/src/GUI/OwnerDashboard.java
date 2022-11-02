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
	
	private JPanel panel;
	private JButton buttonAddJob;
	private JButton createBack;


	//*********************************
	//private Job jobs = new Job(0, null, 0, 0); //how can i get values that we inputted in GUI?
	//private Vehicleowner vr = new Vehicleowner(null, null, 0, null, 0, null, 0, 0); //how can i get values that we inputted in GUI?
	
	public OwnerDashboard() {
	
		createButtonAddJob();
		createBackButton();
		createPanel();			
		ownerFrame.setTitle("VCRTS - Vehicle owner Dashboard"); //setting Title on top left corner of GUI
		
		ImageIcon CloudComputingIcon = new ImageIcon("Images/Cloud Computing.jpg");
		ownerFrame.setIconImage(CloudComputingIcon.getImage()); //Changing Frame Icon to cloud computing icon
		
		//INPUTTING SIZE OF GUI from VARIABLES
		ownerFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		ownerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    ownerFrame.setVisible(true);
	}
	
	private void createButtonAddJob() {
		buttonAddJob = new JButton("Add Job");
		buttonAddJob.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));
		buttonAddJob.setForeground(Color.white);
		buttonAddJob.setBounds(300, 350, 200, 40); 
		buttonAddJob.setBackground(Color.BLUE);
		buttonAddJob.setBorderPainted(false);
		buttonAddJob.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == buttonAddJob)
		{
			
		}
		
		if(e.getSource() == createBack)
		{
			ownerFrame.dispose();
			LaunchPage launch = new LaunchPage();
		}
	}
	
	 private void createBackButton() {
	        createBack = new JButton("Back");
	        createBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
	        createBack.setForeground(Color.white);
	        createBack.setBounds(10, 10, 100, 40); //Set location of button
	        createBack.setBackground(Color.BLUE);
	        createBack.setOpaque(true);
			createBack.setBorderPainted(false);
	        createBack.addActionListener(this);
	    }
	
	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color (32, 42, 68));
		panel.add(buttonAddJob);
		panel.add(createBack);
		ownerFrame.add(panel);
	
	}
	
}