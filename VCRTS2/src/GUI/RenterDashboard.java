package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ObjectClasses.Controller;
import ObjectClasses.Job;
import ObjectClasses.VehicleOwner;
import ObjectClasses.VehicleRenter;

import javax.swing.*;

public class RenterDashboard extends AccountCreation implements ActionListener {

	JFrame renterFrame = new JFrame();
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;

	private JPanel panel;
	private JButton createBack;
	private JTable jobInfoTable;
	private JScrollPane jobScrollPane;
	private JLabel acceptedStatus;
	private JLabel acceptedStatusText;
	private JButton refreshButton;
	private JLabel headerLabel;
	private VehicleRenter vehicleRenter;

	public RenterDashboard(VehicleRenter Renter) {
		vehicleRenter = Renter;

		String[] columnNames = { "Name", "Email", "ID Number", "Phone Number", "Job Duration", "Job ID" };
		String[][] jobList = {
				{ Renter.getName(), Renter.getEmail(), Renter.getId(), Integer.toString(Renter.getPhoneNum()),
						Integer.toString(((Job) Renter.getJobList().get(0)).getJobDuration()),
						Integer.toString(((Job) Renter.getJobList().get(0)).getJobID()) },
				{ "", "", "", "", "", "" } };
		jobInfoTable = new JTable(jobList, columnNames);

		jobScrollPane = new JScrollPane(jobInfoTable);
		jobScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jobScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jobScrollPane.setBounds(25, 240, 750, 150);

		headerLabel = new JLabel("Vehicle Renter Information");
		headerLabel.setBounds(220, 140, 500, 40);
		headerLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		headerLabel.setForeground(Color.white);

		acceptedStatus = new JLabel(String.valueOf(Renter.getAcceptedStatus()).toUpperCase());
		acceptedStatus.setBounds(450, 550, 160, 40);
		acceptedStatus.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		acceptedStatus.setForeground(Color.white);

		acceptedStatusText = new JLabel("Accepted Status: ");
		acceptedStatusText.setBounds(250, 550, 360, 40);
		acceptedStatusText.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		acceptedStatusText.setForeground(Color.white);

		createBackButton();
		createRefreshButton();

		createPanel();

		renterFrame.setTitle("VCRTS - Vehicle Renter Dashboard");
		ImageIcon CloudComputingIcon = new ImageIcon("Images/Cloud Computing.jpg");
		renterFrame.setIconImage(CloudComputingIcon.getImage());
		renterFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		renterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		renterFrame.setVisible(true);

		if (Renter.getStatusChanged()) {
			popup = new JFrame();
			if (Renter.getAcceptedStatus()) {
				JOptionPane.showMessageDialog(popup, "The status of your request has changed!", "Request Accepted",
						JOptionPane.INFORMATION_MESSAGE);
				Renter.setStatusChanged(false);
			} else if (!Renter.getAcceptedStatus()) {
				JOptionPane.showMessageDialog(popup, "The status of your request has changed!", "Request Rejected",
						JOptionPane.INFORMATION_MESSAGE);
				Renter.setStatusChanged(false);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == createBack) {
			renterFrame.dispose();
			LaunchPage launch = new LaunchPage();
		}

		if (e.getSource() == refreshButton) {
			renterFrame.dispose();
			RenterDashboard renterDashboard = new RenterDashboard(vehicleRenter);
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

	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(32, 42, 68));
		panel.add(createBack);
		panel.add(acceptedStatus);
		panel.add(acceptedStatusText);
		panel.add(headerLabel);
		panel.add(jobScrollPane);
		panel.add(refreshButton);
		renterFrame.add(panel);

	}

}