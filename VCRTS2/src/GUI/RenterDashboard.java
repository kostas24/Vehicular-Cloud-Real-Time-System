package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import ObjectClasses.Controller;
import ObjectClasses.VehicleRenter;

public class RenterDashboard extends AccountCreation implements ActionListener {

	JFrame renterFrame = new JFrame();
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;

	private JPanel panel;
	private JButton buttonAddJob;
	private JButton createBack;
	private JLabel jobDurationLabel;
	private JTextField jobDurationField;
	private JLabel jobIDLabel;
	private JTextField jobIDField;
	private VehicleRenter currentRenter = Controller.latestRenter;

	// *********************************
	// private Job jobs = new Job(0, null, 0, 0); //how can i get values that we
	// inputted in GUI?
	// private VehicleRenter vr = new VehicleRenter(null, null, 0, null, 0, null, 0,
	// 0); //how can i get values that we inputted in GUI?

	public RenterDashboard() {

		jobDurationLabel = new JLabel("Job Duration(Hours): ");
		jobDurationLabel.setBounds(40, 300, 350, 35);
		jobDurationLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		jobDurationLabel.setForeground(Color.white);

		jobDurationField = new JTextField();
		jobDurationField.setBounds(240, 300, 350, 35);
		jobDurationField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		// jobDurationField.setForeground(Color.white);

		jobIDLabel = new JLabel("Job ID: ");
		jobIDLabel.setBounds(165, 260, 350, 35);
		jobIDLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		jobIDLabel.setForeground(Color.white);

		jobIDField = new JTextField();
		jobIDField.setBounds(240, 260, 350, 35);
		jobIDField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		// jobIDField.setForeground(Color.white);

		createButtonAddJob();
		createBackButton();
		createPanel();
		renterFrame.setTitle("VCRTS - Vehicle Renter Dashboard"); // setting Title on top left corner of GUI

		ImageIcon CloudComputingIcon = new ImageIcon("Images/Cloud Computing.jpg");
		renterFrame.setIconImage(CloudComputingIcon.getImage()); // Changing Frame Icon to cloud computing icon

		// INPUTTING SIZE OF GUI from VARIABLES
		renterFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		renterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		renterFrame.setVisible(true);
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

		if (e.getSource() == buttonAddJob) {
			String jobID = jobIDField.getText();
			int jobID_Number = Integer.parseInt(jobID);

			String jobDuration = jobDurationField.getText();
			int jobDuration_Number = Integer.parseInt(jobDuration);

			boolean test = false;
			if (Controller.returnRenter(ID) != null) {
				test = true;
			}
			System.out.println(test);
			// Controller.returnRenter(ID).requestJob(jobDuration_Number, jobID_Number);

			Thread t = new Thread(currentRenter);
			
			try {
			currentRenter.requestJob(jobDuration_Number, jobID_Number);
			} catch (Exception error) {

				error.printStackTrace();
		}
			
			t.start(); 
			
			

		if (e.getSource() == createBack) {
			renterFrame.dispose();
			LaunchPage launch = new LaunchPage();
		}
	}
	}

	private void createBackButton() {
		createBack = new JButton("Back");
		createBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		createBack.setForeground(Color.white);
		createBack.setBounds(10, 10, 100, 40); // Set location of button
		createBack.setBackground(Color.BLUE);
		createBack.setOpaque(true);
		createBack.setBorderPainted(false);
		createBack.addActionListener(this);
	}

	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(32, 42, 68));
		panel.add(buttonAddJob);
		panel.add(createBack);
		panel.add(jobDurationField);
		panel.add(jobDurationLabel);
		panel.add(jobIDField);
		panel.add(jobIDLabel);
		renterFrame.add(panel);

	}

}