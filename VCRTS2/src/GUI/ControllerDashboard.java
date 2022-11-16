package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import ObjectClasses.Controller;

public class ControllerDashboard implements ActionListener {

	JFrame ControllerFrame = new JFrame();
	JFrame popup;
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;

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

	// private Controller controller = new Controller();
	private ArrayList<Integer> completionTimes;

	public ControllerDashboard() {
		// completionTimes = controller.calculateCompletionTime()
		// Controller controller = new Controller();

		jobInfoTable = Controller.getJobInfoTable();

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

		completionTimeLabel = new JLabel("----------");
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
		}
		if(e.getSource() == acceptButton)
		{
			popup = new JFrame();
			JOptionPane.showMessageDialog(popup, "Job has been accepted successfully", "Job Accepted",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(e.getSource() == rejectButton)
		{
			popup = new JFrame();
			JOptionPane.showMessageDialog(popup, "Your job has been rejected", "Please try again",
					JOptionPane.INFORMATION_MESSAGE);
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
		ControllerFrame.add(panel);

	}

}

