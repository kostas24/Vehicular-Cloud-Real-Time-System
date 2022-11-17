package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import ObjectClasses.Controller;
import ObjectClasses.VehicleOwner;

public class OwnerDashboard extends AccountCreation implements ActionListener {

	JFrame ownerFrame = new JFrame();
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	JFrame popup;

	private JPanel panel;
	private JButton createBack;
	private JTable vehicleInfoTable;
	private JScrollPane vehicleScrollPane;
	private JLabel acceptedStatus;
	private JLabel acceptedStatusText;
	private JButton refreshButton;
	private VehicleOwner vehicleOwner;
	private JLabel headerLabel;

	public OwnerDashboard(VehicleOwner Owner) {
		
		vehicleOwner = Owner;
		
		String[] columnNames = { "Name", "Email", "ID Number", "Phone Number", "License Plate", "Residency Time",
				"Car Make", "Car Model", "Car Year" };
		String[][] vehicleList = {{ Owner.getName(), Owner.getEmail(), Owner.getId(), Integer.toString(Owner.getPhoneNum()),
				Owner.getVehicleList().get(0).getLicensePlate(),
				Integer.toString(Owner.getVehicleList().get(0).getResidencyTime()),
				Owner.getVehicleList().get(0).getCarMake(), Owner.getVehicleList().get(0).getCarModel(),
				Integer.toString(Owner.getVehicleList().get(0).getCarYear())},
				{"", "","","","","","","",""}};
		vehicleInfoTable = new JTable(vehicleList, columnNames);

		vehicleScrollPane = new JScrollPane(vehicleInfoTable);
		vehicleScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		vehicleScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		vehicleScrollPane.setBounds(25, 240, 750, 150);
		
		headerLabel = new JLabel("Vehicle Owner Information");
		headerLabel.setBounds(220, 140, 500, 40);
		headerLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		headerLabel.setForeground(Color.white);
		
		acceptedStatus = new JLabel(String.valueOf(Owner.getAcceptedStatus()).toUpperCase());
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
		
		ownerFrame.setTitle("VCRTS - Vehicle owner Dashboard"); 
		ImageIcon CloudComputingIcon = new ImageIcon("Images/Cloud Computing.jpg");
		ownerFrame.setIconImage(CloudComputingIcon.getImage()); 
		ownerFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		ownerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ownerFrame.setVisible(true);
		
		if(Owner.getStatusChanged()) {
			popup = new JFrame();
			if(Owner.getAcceptedStatus()) {
				JOptionPane.showMessageDialog(popup, "The status of your request has changed!", "Request Accepted",
						JOptionPane.INFORMATION_MESSAGE);	
				Owner.setStatusChanged(false);
			}
			else if(!Owner.getAcceptedStatus()) {
				JOptionPane.showMessageDialog(popup, "The status of your request has changed!", "Request Rejected",
						JOptionPane.INFORMATION_MESSAGE);
				Owner.setStatusChanged(false);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == createBack) {
			ownerFrame.dispose();
			LaunchPage launch = new LaunchPage();
		}
		
		if (e.getSource() == refreshButton) {
			ownerFrame.dispose();
			OwnerDashboard ownerDashboard = new OwnerDashboard(vehicleOwner);
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
		panel.add(vehicleScrollPane);
		panel.add(acceptedStatus);
		panel.add(acceptedStatusText);
		panel.add(refreshButton);
		panel.add(headerLabel);
		ownerFrame.add(panel);

	}

}