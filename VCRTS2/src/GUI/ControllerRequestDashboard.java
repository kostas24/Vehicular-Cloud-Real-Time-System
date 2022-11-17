package GUI;

import javax.swing.*;

import ObjectClasses.Controller;

import java.awt.*;
import java.awt.event.*;

public class ControllerRequestDashboard implements ActionListener {

	JFrame ControllerRequestsFrame = new JFrame();
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	JFrame popup;
	JPanel panel;
	
	JButton backButton;
	JButton refreshButton;
	JButton acceptButton;
	JButton rejectButton;
	JTable tempJobInfoTable;
	JTable tempVehicleInfoTable;
	JScrollPane tempJobScrollPane;
	JScrollPane tempVehicleScrollPane;
	JLabel emailLabel;
	JTextField emailField;

	public ControllerRequestDashboard() {

		tempJobInfoTable = Controller.getTempJobInfoTable();

		tempJobScrollPane = new JScrollPane(tempJobInfoTable);
		tempJobScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tempJobScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tempJobScrollPane.setBounds(25, 70, 750, 150);

		tempVehicleInfoTable = Controller.getTempVehicleInfoTable();

		tempVehicleScrollPane = new JScrollPane(tempVehicleInfoTable);
		tempVehicleScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tempVehicleScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tempVehicleScrollPane.setBounds(25, 240, 750, 150);

		emailLabel = new JLabel("Enter Email: ");
		emailLabel.setBounds(80, 600, 160, 40);
		emailLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		emailLabel.setForeground(Color.white);

		emailField = new JTextField("");
		emailField.setBounds(220, 600, 360, 40);
		emailField.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));

		createAcceptButton();
		createRejectButton();
		createBackButton();
		createRefreshButton();
		
		createPanel();

		ControllerRequestsFrame.setTitle("VCRTS - Vehicle Controller Requests Dashboard");
		ImageIcon CloudComputingIcon = new ImageIcon("Images/Cloud Computing.jpg");
		ControllerRequestsFrame.setIconImage(CloudComputingIcon.getImage());
		ControllerRequestsFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		ControllerRequestsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ControllerRequestsFrame.setVisible(true);
	}

	private void createRejectButton() {
		rejectButton = new JButton("Reject Job");
		rejectButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
		rejectButton.setForeground(Color.white);
		rejectButton.setBounds(220, 700, 360, 40);
		rejectButton.setBackground(Color.RED);
		rejectButton.setOpaque(true);
		rejectButton.setBorderPainted(false);
		rejectButton.addActionListener(this);
	}

	private void createAcceptButton() {
		acceptButton = new JButton("Accept Job");
		acceptButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
		acceptButton.setForeground(Color.white);
		acceptButton.setBounds(220, 650, 360, 40);
		acceptButton.setBackground(Color.GREEN);
		acceptButton.setOpaque(true);
		acceptButton.setBorderPainted(false);
		acceptButton.addActionListener(this);

	}
	
	private void createBackButton() {
		backButton = new JButton("Back");
		backButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		backButton.setForeground(Color.white);
		backButton.setBounds(25, 10, 100, 40); // Set location of button
		backButton.setBackground(Color.BLUE);
		backButton.setOpaque(true);
		backButton.setBorderPainted(false);
		backButton.addActionListener(this);
	}

	private void createRefreshButton() {
		refreshButton = new JButton("Refresh");
		refreshButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		refreshButton.setForeground(Color.white);
		refreshButton.setBounds(625, 10, 150, 40);
		refreshButton.setBackground(Color.red);
		refreshButton.setOpaque(true);
		refreshButton.setBorderPainted(false);
		refreshButton.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == acceptButton) {
			String searchEmail = emailField.getText();
			boolean found = false;
			
			for (int i = 0; i < Controller.getTempVehicleOwner().size(); i++) {
				if(searchEmail.equals(Controller.getTempVehicleOwner().get(i).getEmail())) {
					Controller.approveOwner(Controller.getTempVehicleOwner().get(i));
					popup = new JFrame();
					JOptionPane.showMessageDialog(popup, "The job of " + searchEmail + " has been accepted (vehicleOwner)", "Accepted Job",
							JOptionPane.INFORMATION_MESSAGE);
					found = true;
					
					//Insert File Writing Method
				}
			}
			
			for (int j = 0; j < Controller.getTempVehicleRenter().size(); j++) {
				if(searchEmail.equals(Controller.getTempVehicleRenter().get(j).getEmail())) {
					Controller.approveRenter(Controller.getTempVehicleRenter().get(j));
					popup = new JFrame();
					JOptionPane.showMessageDialog(popup, "The job of " + searchEmail + " has been accepted (vehicleRenter)", "Accepted Job",
							JOptionPane.INFORMATION_MESSAGE);
					found = true;
					
					//Insert File Writing Method
				}
			}
			
			if (!found) {
				popup = new JFrame();
				JOptionPane.showMessageDialog(popup, "ERROR: User '" + searchEmail + "' not found", "USER NOT FOUND",
						JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if(e.getSource() == rejectButton)
		{
			String searchEmail = emailField.getText();
			boolean found = false;
			
			for(int j =0; j <Controller.getTempVehicleRenter().size(); j++) {
				if(Controller.getTempVehicleRenter().get(j).getEmail().equals(searchEmail)) {
					System.out.println("The job of "+searchEmail+ " has been rejected(vehicleRenter)");
					popup = new JFrame();
					JOptionPane.showMessageDialog(popup, "The job of "+searchEmail+ " has been rejected (vehicleRenter)", "Rejected Job",
						JOptionPane.INFORMATION_MESSAGE);		
					Controller.rejectRenter(Controller.getTempVehicleRenter().get(j));	
					found = true;
					
					}	
				}
			
			for(int j =0; j <Controller.getTempVehicleOwner().size(); j++) {
				if(Controller.getTempVehicleOwner().get(j).getEmail().equals(searchEmail)) {
					System.out.println("The vehicle of "+searchEmail+ " has been rejected (vehicleOwner)");
					popup = new JFrame();
					JOptionPane.showMessageDialog(popup, "The vehicle of "+searchEmail+ " has been rejected (vehicleOwner)", "Rejected Vehicle",
							JOptionPane.INFORMATION_MESSAGE);	
					Controller.rejectOwner(Controller.getTempVehicleOwner().get(j));
					found = true; 
				}
			}
			if (!found) {
				popup = new JFrame();
				JOptionPane.showMessageDialog(popup, "ERROR: User '" + searchEmail + "' not found", "USER NOT FOUND",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (e.getSource() == backButton) {
			ControllerRequestsFrame.dispose();
			ControllerDashboard controllerDashboard = new ControllerDashboard();
		}

		if (e.getSource() == refreshButton) {
			ControllerRequestsFrame.dispose();
			ControllerRequestDashboard controllerRequestDashboard = new ControllerRequestDashboard();
		}
	}
	
	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(32, 42, 68));
		panel.add(acceptButton);
		panel.add(rejectButton);
		panel.add(tempJobScrollPane);
		panel.add(tempVehicleScrollPane);
		panel.add(backButton);
		panel.add(refreshButton);
		panel.add(emailLabel);
		panel.add(emailField);
		ControllerRequestsFrame.add(panel);
	}
	
}
