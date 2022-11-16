package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import ObjectClasses.Controller;
import ObjectClasses.VehicleOwner;
public class OwnerDashboard extends AccountCreation implements ActionListener{

	JFrame ownerFrame = new JFrame();
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	//private VehicleOwner currentOwner = Controller.latestOwner;
	
	private JPanel panel;
	private JButton buttonAddJob;
	private JButton createBack;
	private JLabel licenseLabel;
	private JLabel carMakeLabel;
	private JLabel carModelLabel;
	private JLabel carYearLabel;
	private JLabel residencyLabel;
	private JTextField licenseField;
	private JTextField carMakeField;
	private JTextField carModelField;
	private JTextField carYearField;
	private JTextField residencyField;

	//*********************************
	//private Job jobs = new Job(0, null, 0, 0); //how can i get values that we inputted in GUI?
	//private Vehicleowner vr = new Vehicleowner(null, null, 0, null, 0, null, 0, 0); //how can i get values that we inputted in GUI?
	
	public OwnerDashboard() {
		
		licenseLabel = new JLabel("License Plate: ", SwingConstants.RIGHT);
		licenseLabel.setBounds(25, 50, 300, 20);
		licenseLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		licenseLabel.setForeground(Color.white);
		
		carMakeLabel = new JLabel("Car Make: ", SwingConstants.RIGHT);
		carMakeLabel.setBounds(25, 90, 300, 20);
		carMakeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		carMakeLabel.setForeground(Color.white);
		
		carModelLabel = new JLabel("License Plate: ", SwingConstants.RIGHT);
		carModelLabel.setBounds(25, 130, 300, 20);
		carModelLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		carModelLabel.setForeground(Color.white);
		
		carYearLabel = new JLabel("Car Year: ", SwingConstants.RIGHT);
		carYearLabel.setBounds(25, 170, 300, 20);
		carYearLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		carYearLabel.setForeground(Color.white);
		
		residencyLabel = new JLabel("Residency Time (Hours): ", SwingConstants.RIGHT);
		residencyLabel.setBounds(25, 210, 300, 20);
		residencyLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		residencyLabel.setForeground(Color.white);
		
		licenseField = new JTextField();
		licenseField.setBounds(325, 50, 350, 35);
		licenseField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		carMakeField = new JTextField();
		carMakeField.setBounds(325, 90, 350, 35);
		carMakeField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		carModelField = new JTextField();
		carModelField.setBounds(325, 130, 350, 35);
		carModelField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		carYearField = new JTextField();
		carYearField.setBounds(325, 170, 350, 35);
		carYearField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		residencyField = new JTextField();
		residencyField.setBounds(325, 210, 350, 35);
		residencyField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
	
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
		buttonAddJob.setBounds(300, 500, 200, 40); 
		buttonAddJob.setBackground(Color.BLUE);
		buttonAddJob.setBorderPainted(false);
		buttonAddJob.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == buttonAddJob)
		{
			String licensePlate = licenseField.getText();
			System.out.println(licensePlate);
			
			String carMake = carMakeField.getText();
			System.out.println(carMake);
			
			String carModel = carModelField.getText();
			System.out.println(carModel);
			
			String carYear = carYearField.getText();
			System.out.println(carYear);
			
			String residencyTime = residencyField.getText();
			System.out.println(residencyTime);
			
			
		/*	
			Thread thread = new Thread(currentOwner);
			
			try {
				currentOwner.requestVehicle(licensePlate, carMake, carModel, carYear, residencyTime);
			} catch (Exception error ) {
				
				error.printStackTrace();
			} 
			
			thread.start();
			*/
			
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
		panel.add(licenseLabel);
		panel.add(carMakeLabel);
		panel.add(carModelLabel);
		panel.add(carYearLabel);
		panel.add(residencyLabel);
		panel.add(licenseField);
		panel.add(carMakeField);
		panel.add(carModelField);
		panel.add(carYearField);
		panel.add(residencyField);
		ownerFrame.add(panel);
	
	}
	
}