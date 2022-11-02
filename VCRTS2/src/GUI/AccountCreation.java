package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.io.File;
import javax.swing.*;

import ObjectClasses.Controller;
import ObjectClasses.VehicleOwner;
import ObjectClasses.VehicleRenter;

public class AccountCreation implements ActionListener {

	JFrame frame = new JFrame();
	JFrame ownerFrame;
	JFrame renterFrame;
	JFrame popup;
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;

	// Labels and variables for the Frame and Panel
	private JLabel accounttextLabel;
	private JLabel informationLabel;
	private JLabel nameLabel;
	private JLabel emailLabel;
	private JLabel phoneNumLabel;
	private JLabel IDLabel;
	private JLabel jobDurationLabel;
	private JLabel jobDeadlineLabel;
	private JLabel licensePlateLabel;
	private JLabel carMakeLabel;
	private JLabel carModelLabel;
	private JLabel carYearLabel;
	private JLabel carResiTimeLabel;
	private JPanel panel;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField phoneNumField;
	private JTextField idNumberField;
	private JTextField licensePlateField;
	private JTextField carMakeField;
	private JTextField carModelField;
	private JTextField carYearField;
	private JTextField jobDurationField;
	private JTextField jobDeadlineField;
	private JTextField residencyTimeField;
	private JButton createAccount;
	private JButton createBack;
	private JButton createClear;
	private JCheckBox vehicleOwnerCheckBox;
	private JCheckBox vehicleRenterCheckBox;
	private Color BLUE = Color.BLUE;

	// Labels and variables to hold user information; to be stored to file
	private boolean vehicleOwnerStatus; // Not being used at this time
	private boolean vehicleRenterStatus; // Not being used at this time
	
	private ArrayList<VehicleOwner> owners = new ArrayList<>();
	private ArrayList<VehicleRenter> renters = new ArrayList<>();

	protected String email;
	protected String carMake;
	protected String carModel;
	protected String carYear;
	protected String jobDuration;
	protected String jobDeadline;
	protected String name;
	protected String phoneNum;
	protected String ID;
	protected String licensePlate;
	protected String residencyTime;

	public AccountCreation() {
		accounttextLabel = new JLabel("Create Account Here");
		accounttextLabel.setForeground(Color.white);
		accounttextLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		accounttextLabel.setBounds(220, 10, 400, 40);

		informationLabel = new JLabel("Please enter your personal information below: ");
		informationLabel.setForeground(Color.white);
		informationLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));
		informationLabel.setBounds(120, 130, 600, 30);

		nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(170, 200, 350, 35);
		nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		nameLabel.setForeground(Color.white);

		emailLabel = new JLabel("Email: ");
		emailLabel.setBounds(170, 245, 350, 35);
		emailLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		emailLabel.setForeground(Color.white);

		phoneNumLabel = new JLabel("Phone Number: ");
		phoneNumLabel.setBounds(100, 290, 350, 35);
		phoneNumLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		phoneNumLabel.setForeground(Color.white);

		IDLabel = new JLabel("ID Number: ");
		IDLabel.setBounds(125, 335, 350, 35);
		IDLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		IDLabel.setForeground(Color.white);

		jobDurationLabel = new JLabel("Job Duration(Hours): ");
		jobDurationLabel.setBounds(40, 450, 350, 35);
		jobDurationLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		jobDurationLabel.setForeground(Color.white);

		jobDeadlineLabel = new JLabel("Job Deadline: ");
		jobDeadlineLabel.setBounds(110, 495, 350, 35);
		jobDeadlineLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		jobDeadlineLabel.setForeground(Color.white);

		licensePlateLabel = new JLabel("License Plate: ");
		licensePlateLabel.setBounds(110, 450, 350, 35);
		licensePlateLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		licensePlateLabel.setForeground(Color.white);

		carMakeLabel = new JLabel("Car Make: ");
		carMakeLabel.setBounds(130, 495, 350, 35);
		carMakeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		carMakeLabel.setForeground(Color.white);

		carModelLabel = new JLabel("Car Model: ");
		carModelLabel.setBounds(130, 540, 350, 35);
		carModelLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		carModelLabel.setForeground(Color.white);

		carYearLabel = new JLabel("Car Year: ");
		carYearLabel.setBounds(130, 585, 350, 35);
		carYearLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		carYearLabel.setForeground(Color.white);

		carResiTimeLabel = new JLabel("Residency Time(Hours): ");
		carResiTimeLabel.setBounds(15, 630, 350, 35);
		carResiTimeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		carResiTimeLabel.setForeground(Color.white);

		nameField = new JTextField("");
		nameField.setBounds(240, 200, 350, 35);
		nameField.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		emailField = new JTextField("");
		emailField.setBounds(240, 245, 350, 35);
		emailField.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		phoneNumField = new JTextField("");
		phoneNumField.setBounds(240, 290, 350, 35);
		phoneNumField.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		idNumberField = new JTextField("");
		idNumberField.setBounds(240, 335, 350, 35);
		idNumberField.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));

		// Setting up fields for if user wants to register as Vehicle Owner
		licensePlateField = new JTextField("");
		licensePlateField.setBounds(240, 450, 350, 35);
		licensePlateField.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		carMakeField = new JTextField("");
		carMakeField.setBounds(240, 495, 350, 35);
		carMakeField.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		carModelField = new JTextField("");
		carModelField.setBounds(240, 540, 350, 35);
		carModelField.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		carYearField = new JTextField("");
		carYearField.setBounds(240, 585, 350, 35);
		carYearField.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		residencyTimeField = new JTextField("");
		residencyTimeField.setBounds(240, 630, 350, 35);
		residencyTimeField.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));

		// Setting fields to not be visible unless checkbox is clicked
		carMakeField.setVisible(false);
		carModelField.setVisible(false);
		carYearField.setVisible(false);
		licensePlateField.setVisible(false);
		residencyTimeField.setVisible(false);

		carMakeLabel.setVisible(false);
		carModelLabel.setVisible(false);
		carYearLabel.setVisible(false);
		licensePlateLabel.setVisible(false);
		carResiTimeLabel.setVisible(false);

		// Check boxes with their default values set to false
		vehicleOwnerCheckBox = new JCheckBox("Vehicle Owner", false);
		vehicleOwnerCheckBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		vehicleOwnerCheckBox.setBounds(330, 385, 150, 25);
		vehicleOwnerCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (vehicleOwnerCheckBox.isSelected()) {
					vehicleRenterCheckBox.setSelected(false);
					vehicleOwnerStatus = true;
					// System.out.println("Vehicle Owner Check Box Clicked!");
					carMakeField.setVisible(true);
					carModelField.setVisible(true);
					carYearField.setVisible(true);
					licensePlateField.setVisible(true);
					residencyTimeField.setVisible(true);

					carMakeLabel.setVisible(true);
					carModelLabel.setVisible(true);
					carYearLabel.setVisible(true);
					licensePlateLabel.setVisible(true);
					carResiTimeLabel.setVisible(true);
					createAccount.setBounds(240, 675, 250, 40);
					createClear.setBounds(500, 680, 90, 30); // Set location of buttons
				} else if (!vehicleOwnerCheckBox.isSelected()) {
					vehicleOwnerStatus = false;
					// System.out.println("Vehicle Owner Check Box UnClicked!");
					carMakeField.setVisible(false);
					carModelField.setVisible(false);
					carYearField.setVisible(false);
					licensePlateField.setVisible(false);
					residencyTimeField.setVisible(false);

					carMakeLabel.setVisible(false);
					carModelLabel.setVisible(false);
					carYearLabel.setVisible(false);
					licensePlateLabel.setVisible(false);
					carResiTimeLabel.setVisible(false);
				}
			}
		});
		// Setting up fields for if user wants to register as Vehicle Renter
		jobDurationField = new JTextField("");
		jobDurationField.setBounds(240, 450, 350, 35);
		jobDurationField.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		jobDeadlineField = new JTextField("");
		jobDeadlineField.setBounds(240, 495, 350, 35);
		jobDeadlineField.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));

		// Setting fields to not be visible unless checkbox is clicked
		jobDeadlineField.setVisible(false);
		jobDurationField.setVisible(false);

		jobDurationLabel.setVisible(false);
		jobDeadlineLabel.setVisible(false);

		vehicleRenterCheckBox = new JCheckBox("Vehicle Renter", false);
		vehicleRenterCheckBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		vehicleRenterCheckBox.setBounds(330, 415, 150, 25);
		vehicleRenterCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (vehicleRenterCheckBox.isSelected()) {
					vehicleOwnerCheckBox.setSelected(false);
					vehicleRenterStatus = true;
					// System.out.println("Vehicle Renter Check Box Clicked!");
					jobDurationField.setVisible(true);
					jobDeadlineField.setVisible(true);

					jobDurationLabel.setVisible(true);
					jobDeadlineLabel.setVisible(true);

					createAccount.setBounds(240, 550, 250, 40); 
					createClear.setBounds(500, 555, 90, 30); // Set location of buttons
				} else if (!vehicleRenterCheckBox.isSelected()) {
					vehicleRenterStatus = false;
					jobDurationField.setVisible(false);
					jobDeadlineField.setVisible(false);

					jobDurationLabel.setVisible(false);
					jobDeadlineLabel.setVisible(false);
				}
			}
		});

		createButtonCreateAccount();
		createBackButton();
		createClearButton();
		createPanel();

		frame.setTitle("VCRTS - Create Account"); // setting Title on top left corner of GUI

		ImageIcon CloudComputingIcon = new ImageIcon("Images/Cloud Computing.jpg");
		frame.setIconImage(CloudComputingIcon.getImage()); // Changing Frame Icon to cloud computing icon

		// INPUTTING SIZE OF GUI from VARIABLES
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void createButtonCreateAccount() {
		createAccount = new JButton("Create Account");
		createAccount.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
		createAccount.setForeground(Color.white);
		createAccount.setBounds(240, 675, 250, 40); // Set location of button
		createAccount.setBackground(BLUE);
		createAccount.setOpaque(true);
		createAccount.setBorderPainted(false);
		createAccount.addActionListener(this);
	}

	private void createBackButton() {
		createBack = new JButton("Back");
		createBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		createBack.setForeground(Color.white);
		createBack.setBounds(10, 10, 100, 40); // Set location of button
		createBack.setBackground(BLUE);
		createBack.setOpaque(true);
		createBack.setBorderPainted(false);
		createBack.addActionListener(this);
	}
	
	private void createClearButton() {
		createClear = new JButton("Clear");
		createClear.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		createClear.setForeground(Color.white); 
		createClear.setBounds(500, 680, 90, 30); //Set location of button
		createClear.setBackground(Color.red);
		createClear.setOpaque(true);
		createClear.setBorderPainted(false);
		createClear.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		name = nameField.getText();
		email = emailField.getText();
		phoneNum = phoneNumField.getText();
		ID = idNumberField.getText();
		jobDuration = jobDurationField.getText();
		jobDeadline = jobDeadlineField.getText();
		licensePlate = licensePlateField.getText();
		carMake = carMakeField.getText();
		carModel = carModelField.getText();
		carYear = carYearField.getText();
		residencyTime = residencyTimeField.getText();

		if (e.getSource() == createBack) {
			frame.dispose();
			LaunchPage launch = new LaunchPage();
		}
		
		if(e.getSource() == createClear) {
			clearTextFields();
		}
		
		File registry = new File("VCRTSregistry.txt");
		if (registry.isFile() == true && e.getSource() == createAccount) {
			if (!name.isEmpty() && !email.isEmpty() && !phoneNum.isEmpty() && !ID.isEmpty() && !licensePlate.isEmpty()
					&& !carMake.isEmpty() && !carModel.isEmpty() && !carYear.isEmpty() && !residencyTime.isEmpty()
					&& vehicleOwnerCheckBox.isSelected()) {
				FileWriter fWriter;
				try {               //adds vehicle owner to registry and arraylist
					fWriter = new FileWriter(registry, true);
					java.util.Date time = new java.util.Date();
					
					fWriter.write("" + "\n");
					fWriter.write("1");
					fWriter.write(time.toString() + "\n");
					fWriter.write(name + "\n");
					fWriter.write(email + "\n");
					fWriter.write(phoneNum + "\n");
					fWriter.write(ID + "\n");

					fWriter.write(licensePlate + "\n");
					fWriter.write(carMake + "\n");
					fWriter.write(carModel + "\n");
					fWriter.write(carYear + "\n");
					fWriter.write(residencyTime + "\n");
					fWriter.close();
					
					//owners.add(new VehicleOwner(name, email, phoneNum, ID, licensePlate, carMake, carModel, carYear, residencyTime));
					//^creates new jframe for some reason. no good
					
					clearTextFields();
				
					
					popup = new JFrame();
					JOptionPane.showMessageDialog(popup, "You have successfully registered as a Vehicle Owner", "Account Creation Confirmed",
							JOptionPane.INFORMATION_MESSAGE);
					
					
					
					//TEMPORARY, SHOULD BE IN LOGINGUI. SHOULD DIRECT YOU HERE AFTER LOGIN, FOR NOW WE WILL DO THIS.
					frame.dispose();
					OwnerDashboard ownerDash = new OwnerDashboard();
					
				} 
				
				catch (IOException error) {
					System.out.println("An error has occured");
				}

			}

			else if (!name.isEmpty() && !email.isEmpty() && !phoneNum.isEmpty() && !ID.isEmpty()
					&& !jobDuration.isEmpty() && !jobDeadline.isEmpty() && vehicleRenterCheckBox.isSelected()) {
				FileWriter fWriter;
				try {               //adds vehicle renter to registry and arraylist
					fWriter = new FileWriter(registry, true);
					java.util.Date time = new java.util.Date();

					fWriter.write("" + "\n");
					fWriter.write("0");
					fWriter.write(time.toString() + "\n");
					fWriter.write(name + "\n");
					fWriter.write(email + "\n");
					fWriter.write(phoneNum + "\n");
					fWriter.write(ID + "\n");

					fWriter.write(jobDuration + "\n");
					fWriter.write(jobDeadline + "\n");
					fWriter.close();
				
					int phoneNumber = Integer.parseInt(phoneNum);
					int jobDuration_Number = Integer.parseInt(jobDuration);
					int jobID = 12;
					
					Controller.addRenter(name, email, phoneNumber, ID, jobDuration_Number, jobID);
					
				//	renters.add(new VehicleRenter(name, email, phoneNum, ID, jobDuration, jobDeadline));
					//^creates new jframe for some reason. no good
					
					clearTextFields();
					
					popup = new JFrame();
					JOptionPane.showMessageDialog(popup, "You have successfully registered as a Vehicle Renter", "Account Creation Confirmed",
							JOptionPane.INFORMATION_MESSAGE);
					
					//TEMPORARY, SHOULD BE IN LOGINGUI. SHOULD DIRECT YOU HERE AFTER LOGIN, FOR NOW WE WILL DO THIS.
					frame.dispose();
					RenterDashboard renterDash = new RenterDashboard();
				}
		
				catch (IOException error) {
					System.out.println("An error has occured");
				}
			}
			

			else if (!(e.getSource() == createBack)) {
				popup = new JFrame();
				JOptionPane.showMessageDialog(popup, "Please fill out all the fields to continue", "Error",
						JOptionPane.ERROR_MESSAGE);

			}
		}
	}

	private void clearTextFields() {
		nameField.setText("");
		emailField.setText("");
		phoneNumField.setText("");
		idNumberField.setText("");
		licensePlateField.setText("");
		carMakeField.setText("");
		carModelField.setText("");
		carYearField.setText("");
		jobDurationField.setText("");
		jobDeadlineField.setText("");
		residencyTimeField.setText("");
	}
	
	
	private void createPanel() {
		panel = new JPanel();

		// Default fields
		panel.setLayout(null);
		panel.setBackground(new Color(32, 42, 68));
		panel.add(accounttextLabel);
		panel.add(nameField);
		panel.add(emailField);
		panel.add(phoneNumField);
		panel.add(createAccount);
		panel.add(createBack);
		panel.add(createClear);
		panel.add(vehicleOwnerCheckBox);
		panel.add(vehicleRenterCheckBox);
		panel.add(idNumberField);
		panel.add(informationLabel);
		panel.add(nameLabel);
		panel.add(emailLabel);
		panel.add(phoneNumLabel);
		panel.add(IDLabel);
		panel.add(jobDurationLabel);
		panel.add(jobDeadlineLabel);
		panel.add(licensePlateLabel);
		panel.add(carMakeLabel);
		panel.add(carModelLabel);
		panel.add(carYearLabel);
		panel.add(carResiTimeLabel);

		// Vehicle Owner fields
		panel.add(licensePlateField);
		panel.add(carMakeField);
		panel.add(carModelField);
		panel.add(carYearField);
		panel.add(residencyTimeField);

		// Vehicle Owner fields
		panel.add(jobDeadlineField);
		panel.add(jobDurationField);

		// adds to current object
		frame.add(panel);
	}
	
}