package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import ObjectClasses.Controller;
import ObjectClasses.VehicleRenter;

public class ControllerDashboard implements ActionListener {

	JFrame ControllerFrame = new JFrame();
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	JFrame popup;
	private JButton buttonCompletionTime;
	private JLabel jobTimeTextLabel;
	private JLabel idTextLabel;
	private JLabel completionTimeLabel;
	private JLabel completionIDLabel;
	private JPanel panel;
	private JButton createBack;
	private JScrollPane jobScrollPane;
	private JTable jobInfoTable;
	private JScrollPane vehicleScrollPane;
	private JTable vehicleInfoTable;
	private JButton refreshTablesButton;
	private JButton acceptButton;
	private JButton rejectButton;
	private JTextField enterEmail;
	private JLabel enterEmailLabel;

	// private Controller controller = new Controller();
	private ArrayList<Integer> completionTimes;
//	private ArrayList<VehicleRenter> renterList; 
	public ControllerDashboard() {
		// completionTimes = controller.calculateCompletionTime()
		// Controller controller = new Controller();

		jobInfoTable = Controller.getJobInfoTable();

		enterEmailLabel = new JLabel("Enter Email: ");
		enterEmailLabel.setBounds(80, 550, 160, 40);
		enterEmailLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		enterEmailLabel.setForeground(Color.white);
		
		enterEmail = new JTextField("");
		enterEmail.setBounds(220, 550, 360, 40);
		enterEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		
		jobScrollPane = new JScrollPane(jobInfoTable);
		jobScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jobScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jobScrollPane.setBounds(25, 70, 750, 150);

		vehicleInfoTable = Controller.getVehicleInfoTable();

		vehicleScrollPane = new JScrollPane(vehicleInfoTable);
		vehicleScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		vehicleScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		vehicleScrollPane.setBounds(25, 240, 750, 150);

		idTextLabel = new JLabel("Job ID's: ");
		idTextLabel.setBounds(230, 410, 200, 40);
		idTextLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		idTextLabel.setForeground(Color.white);

		jobTimeTextLabel = new JLabel("Duration: ");
		jobTimeTextLabel.setBounds(230, 450, 200, 40);
		jobTimeTextLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		jobTimeTextLabel.setForeground(Color.white);

		completionIDLabel = new JLabel("-----------");
		completionIDLabel.setBounds(450, 410, 350, 40);
		completionIDLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		completionIDLabel.setForeground(Color.white);

		completionTimeLabel = new JLabel("-----------");
		completionTimeLabel.setBounds(450, 450, 350, 40);
		completionTimeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		completionTimeLabel.setForeground(Color.white);

		createButtonCompletionTime();
		createBackButton();
		createRefreshButton();
		createAcceptButton();
		createRejectButton();
		createPanel();
		ControllerFrame.setTitle("VCRTS - Vehicle Controller Dashboard");
		ImageIcon CloudComputingIcon = new ImageIcon("Images/Cloud Computing.jpg");
		ControllerFrame.setIconImage(CloudComputingIcon.getImage());

		/*
		 * scrollPane.add(completionIDLabel); scrollPane.add(completionTimeLabel);
		 * scrollPane.add(idTextLabel); scrollPane.add(jobTimeTextLabel);
		 */

		// INPUTTING SIZE OF GUI from VARIABLES
		ControllerFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		ControllerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ControllerFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonCompletionTime) {

			ArrayList<Integer> times = new ArrayList<Integer>(Controller.calculateCompletionTime());
			// System.out.println(times.toString());
			completionTimeLabel.setText(times.toString());
			completionIDLabel.setText(Controller.getJobIDList().toString());
		}

		if (e.getSource() == createBack) {
			ControllerFrame.dispose();
			LaunchPage launch = new LaunchPage();
		}

		if (e.getSource() == refreshTablesButton) {
			jobInfoTable = Controller.getJobInfoTable();
			vehicleInfoTable = Controller.getVehicleInfoTable();

			jobScrollPane = new JScrollPane(jobInfoTable);
			vehicleScrollPane = new JScrollPane(vehicleInfoTable);
			
			panel.revalidate();
			ControllerFrame.revalidate();
		}
		File acceptedJobs = new File("VCRTSjobs.txt");
		if(e.getSource() == acceptButton)
		{
			
			ArrayList<String> accepted = new ArrayList<String>();
		//	accepted.add();
			
			//write accepted jobs to file
			FileWriter fWriter;
			try {              
				fWriter = new FileWriter(acceptedJobs, true);
				java.util.Date time = new java.util.Date();
				
				fWriter.write("" + "\n");
				fWriter.write(time.toString() + "\n");
				//if(Controller.getVehicleRenter().get().getEmail().equals(enterEmail.getText())|| 
						//Controller.getVehicleOwner().get().getEmail().equals(enterEmail.getText()))
				
				for(int j =0; j <Controller.getVehicleRenter().size(); j++) {
					if(Controller.getVehicleRenter().get(j).getEmail().equals(enterEmail.getText())) {
						fWriter.write(enterEmail.getText() + "\n"); // PRINT ACCEPTED JOB INFORMATION in "" IF NEED BE WE CAN ADD OTHER INFO AS WELL
						System.out.println("The job of "+enterEmail.getText()+ " has been accepted(vehicleRenter)");
						popup = new JFrame();
						JOptionPane.showMessageDialog(popup, "The job of "+enterEmail.getText()+ " has been accepted(vehicleRenter)", "Accepted Job",
								JOptionPane.INFORMATION_MESSAGE);		
					}
				}
				
				for(int j =0; j <Controller.getVehicleOwner().size(); j++) {

					if(Controller.getVehicleOwner().get(j).getEmail().equals(enterEmail.getText())) {
						fWriter.write(enterEmail.getText() + "\n"); // PRINT ACCEPTED JOB INFORMATION in "" IF NEED BE WE CAN ADD OTHER INFO AS WELL
						System.out.println("The vehicle of "+enterEmail.getText()+ " has been accepted(vehicleOwner)");
						popup = new JFrame();
						JOptionPane.showMessageDialog(popup, "The vehicle of "+enterEmail.getText()+ " has been accepted(vehicleOwner)", "Accepted Vehicle",
								JOptionPane.INFORMATION_MESSAGE);	
					}
				}
				
				fWriter.close();
				
			} 
			catch (IOException error) {
				System.out.println("An error has occured writing to VCRTSjobs.txt file");
			}

			
		}
		
		if(e.getSource() == rejectButton)
		{
			
			String x = enterEmail.getText();
						
			//System.out.println(Controller.getVehicleRenter().toString());
			//renterList = new ArrayList<VehicleRenter>(Controller.getVehicleRenter());
			for(int j =0; j <Controller.getVehicleRenter().size(); j++) {
			if(Controller.getVehicleRenter().get(j).getEmail().equals(x)) {
				System.out.println("The job of "+x+ " has been rejected(vehicleRenter)");
				popup = new JFrame();
				JOptionPane.showMessageDialog(popup, "The job of "+x+ " has been rejected(vehicleRenter)", "Rejected Job",
						JOptionPane.INFORMATION_MESSAGE);		
				Controller.removeRenter(enterEmail.getText());
				//for(int i =0; i < Controller.getVehicleRenter().size();i++)
					//System.out.println(Controller.getVehicleRenter().get(i).getEmail());
				
				
			}
			}
			for(int j =0; j <Controller.getVehicleOwner().size(); j++) {

				if(Controller.getVehicleOwner().get(j).getEmail().equals(x)) {
					System.out.println("The vehicle of "+x+ " has been rejected(vehicleOwner)");
					popup = new JFrame();
					JOptionPane.showMessageDialog(popup, "The vehicle of "+x+ " has been rejected(vehicleOwner)", "Rejected Vehicle",
							JOptionPane.INFORMATION_MESSAGE);	
					Controller.removeOwner(enterEmail.getText());
				//for(int i =0; i < Controller.getVehicleOwner().size();i++)				
					//System.out.println(Controller.getVehicleOwner().get(i).getEmail());			
				}
		}
			
			//Controller.rejectRenterJob(enterEmail.getText());
		//	System.out.println(Controller.getVehicleRenter());
			
			
			
			//remove job?
			//Controller.getJobIDList().remove(0);
			//for(int i =0; i < Controller.getJobIDList().size();i++)
			//System.out.println(Controller.getJobIDList());
			
		}
		
	}
	private void createRejectButton() {
		rejectButton = new JButton("Reject Job");
		rejectButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
		rejectButton.setForeground(Color.white);
		rejectButton.setBounds(220, 650, 360, 40);
		rejectButton.setBackground(Color.RED);
		rejectButton.setOpaque(true);
		rejectButton.setBorderPainted(false);
		rejectButton.addActionListener(this);
	}
	
	private void createAcceptButton() {
		acceptButton = new JButton("Accept Job");
		acceptButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
		acceptButton.setForeground(Color.white);
		acceptButton.setBounds(220, 600, 360, 40);
		acceptButton.setBackground(Color.GREEN);
		acceptButton.setOpaque(true);
		acceptButton.setBorderPainted(false);
		acceptButton.addActionListener(this);

	}

	private void createButtonCompletionTime() {
		buttonCompletionTime = new JButton("Find Completion Time");
		buttonCompletionTime.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
		buttonCompletionTime.setForeground(Color.white);
		buttonCompletionTime.setBounds(220, 700, 360, 40);
		buttonCompletionTime.setBackground(Color.BLUE);
		buttonCompletionTime.setOpaque(true);
		buttonCompletionTime.setBorderPainted(false);
		buttonCompletionTime.addActionListener(this);
	}

	private void createBackButton() {
		createBack = new JButton("Back");
		createBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		createBack.setForeground(Color.white);
		createBack.setBounds(25, 10, 100, 40); // Set location of button
		createBack.setBackground(Color.BLUE);
		createBack.setOpaque(true);
		createBack.setBorderPainted(false);
		createBack.addActionListener(this);
	}

	private void createRefreshButton() {
		refreshTablesButton = new JButton("Refresh");
		refreshTablesButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		refreshTablesButton.setForeground(Color.white);
		refreshTablesButton.setBounds(625, 10, 150, 40);
		refreshTablesButton.setBackground(Color.red);
		refreshTablesButton.setOpaque(true);
		refreshTablesButton.setBorderPainted(false);
		refreshTablesButton.addActionListener(this);
	}

	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(32, 42, 68));
		panel.add(buttonCompletionTime);
		panel.add(completionTimeLabel);
		panel.add(createBack);
		panel.add(completionIDLabel);
		panel.add(refreshTablesButton);
		panel.add(idTextLabel);
		panel.add(jobTimeTextLabel);
		panel.add(jobScrollPane);
		panel.add(vehicleScrollPane);
		panel.add(rejectButton);
		panel.add(acceptButton);
		panel.add(enterEmail);
		panel.add(enterEmailLabel);
		ControllerFrame.add(panel);

	}

}

