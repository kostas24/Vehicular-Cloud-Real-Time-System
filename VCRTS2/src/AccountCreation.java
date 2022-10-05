import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

import javax.swing.*;

public class AccountCreation implements ActionListener{

    JFrame frame = new JFrame();

    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 600;

    //Labels and variables for the Frame and Panel
    private JLabel test;
    private JLabel confirmLabel;
    private JLabel informationLabel;
    private JPanel panel;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneNumField;
    private JTextField idNumberField;
    private JTextField licensePlateField;
    private JTextField carMakeField;
    private JTextField carModelField;
    private JTextField carYearField;
    private JTextField JobDurationField;
    private JTextField JobDeadlineField;
    private JButton createAccount;

    private JCheckBox vehicleOwnerCheckBox;
    private JCheckBox vehicleRenterCheckBox;
    //private ItemListener vehicleOwnerListener;
    //private ItemListener vehicleRenterListener;
    private Color lav = new Color(221, 160, 221);

    //Labels and variables to hold user information; to be stored to file
    private boolean vehicleOwnerStatus;
    private boolean vehicleRenterStatus;
    private String email;
    private String carMake;
    private String carModel;
    private String carYear;
    private String JobDuration;
    private String JobDeadline;
    private String name;
    private String phoneNum;
    private String ID;
    private String licensePlate;

    public AccountCreation() {
        test = new JLabel("Create Account Here");
        test.setBounds(200,10,400,50);

        informationLabel = new JLabel("Please enter your personal information below: ");
        informationLabel.setBounds(140, 30, 400, 50);

        test.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        nameField = new JTextField("First Name: ");
        nameField.setBounds(188, 100, 175, 25);
        emailField = new JTextField("Email: ");
        emailField.setBounds(188, 140, 175, 25);
        phoneNumField = new JTextField("Phone Number: ");
        phoneNumField.setBounds(188, 180, 175, 25);
        idNumberField = new JTextField("ID Number: ");
        idNumberField.setBounds(188, 220, 175, 25);

        //Setting up fields for if user wants to register as Vehicle Owner
        licensePlateField = new JTextField("License Plate #: ");
        licensePlateField.setBounds(188, 340, 175, 25);
        carMakeField = new JTextField("Car Make: ");
        carMakeField.setBounds(200, 380, 150, 25);
        carModelField = new JTextField("Car Model: ");
        carModelField.setBounds(200, 420, 150, 25);
        carYearField = new JTextField("Car Year: ");
        carYearField.setBounds(225, 460, 100, 25);

        //Setting fields to not be visible unless checkbox is clicked
        carMakeField.setVisible(false);
        carModelField.setVisible(false);
        carYearField.setVisible(false);
        licensePlateField.setVisible(false);

        //Check boxes with their default values set to false
        vehicleOwnerCheckBox = new JCheckBox("Vehicle Owner", false);
        vehicleOwnerCheckBox.setBounds(200, 260, 150, 25);
        vehicleOwnerCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(vehicleOwnerCheckBox.isSelected())
                {
                    vehicleOwnerStatus = true;
                    //System.out.println("Vehicle Owner Check Box Clicked!");
                    carMakeField.setVisible(true);
                    carModelField.setVisible(true);
                    carYearField.setVisible(true);
                    licensePlateField.setVisible(true);
                }
                else if(!vehicleOwnerCheckBox.isSelected())
                {
                    vehicleOwnerStatus = false;
                    //System.out.println("Vehicle Owner Check Box UnClicked!");
                    carMakeField.setVisible(false);
                    carModelField.setVisible(false);
                    carYearField.setVisible(false);
                    licensePlateField.setVisible(false);
                }
            }
        });
        //Setting up fields for if user wants to register as Vehicle Renter
        JobDurationField = new JTextField("Job Duration (In Hours): ");
        JobDurationField.setBounds(188, 340, 215, 40);
        JobDeadlineField = new JTextField("Job Deadline: ");
        JobDeadlineField.setBounds(188, 390, 175, 40);

        //Setting fields to not be visible unless checkbox is clicked
        JobDeadlineField.setVisible(false);
        JobDurationField.setVisible(false);

        vehicleRenterCheckBox = new JCheckBox("Vehicle Renter", false);
        vehicleRenterCheckBox.setBounds(200, 300, 150, 25);
        vehicleRenterCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(vehicleRenterCheckBox.isSelected()) {
                    vehicleRenterStatus = true;
                    //System.out.println("Vehicle Renter Check Box Clicked!");
                    JobDurationField.setVisible(true);
                    JobDeadlineField.setVisible(true);
                }
                else if (!vehicleRenterCheckBox.isSelected()){
                    vehicleRenterStatus = false;
                    JobDurationField.setVisible(false);
                    JobDeadlineField.setVisible(false);
                }
            }
        });


        createButtonCreateAccount();
        createPanel();


        frame.setTitle("VCRTS"); //setting Title on top left corner of GUI

        ImageIcon CloudComputingIcon = new ImageIcon("Cloud Computing.jpg");
        frame.setIconImage(CloudComputingIcon.getImage()); //Changing Frame Icon to cloud computing icon

        //INPUTTING SIZE OF GUI from VARIABLES
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    private void createButtonCreateAccount() {
        createAccount = new JButton("Create Account");
        createAccount.setBounds(200,510,150,25);
        createAccount.setBackground(lav);
        createAccount.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e) {
        name = nameField.getText();
       // confirmLabel.setText(name);
        email = emailField.getText();
     //   confirmLabel.setText(email);
        phoneNum = phoneNumField.getText();
      //  confirmLabel.setText(phoneNum);
        ID = idNumberField.getText();
        
        
        
        
        File registry = new File("VCRTSregistry.txt");
        
        if(registry.isFile() == true) {
        try {
        	FileWriter fWriter = new FileWriter(registry, true);
        	fWriter.write(name + "\n");
        	fWriter.write(email + "\n");
        	fWriter.write(phoneNum + "\n");
        	fWriter.write(ID + "\n");
        	
        	if(vehicleRenterCheckBox.isSelected()) {
        		JobDuration = JobDurationField.getText();
        		JobDeadline = JobDeadlineField.getText();
        		fWriter.write(JobDuration + "\n");
        		fWriter.write(JobDeadline + "\n");
        	}
        	
        	if(vehicleOwnerCheckBox.isSelected()) {
        		carMake = carMakeField.getText();
        		carModel = carModelField.getText();
        		carYear = carYearField.getText();
        		licensePlate = licensePlateField.getText();
        		fWriter.write(carMake + "\n");
        		fWriter.write(carModel + "\n");
        		fWriter.write(carYear + "\n");
        		fWriter.write(licensePlate + "\n");
        	}
        	fWriter.close();
        	System.out.println("here");
        } catch(IOException error) {
        	System.out.println("An error has occured");
        }
        }
    
        } 
        
      


    private void createPanel() {
        panel = new JPanel();

        //Default fields
        panel.setLayout(null);
        panel.setBackground(Color.CYAN);
        panel.add(test);
        panel.add(nameField);
        panel.add(emailField);
        panel.add(phoneNumField);
        panel.add(createAccount);
        panel.add(vehicleOwnerCheckBox);
        panel.add(vehicleRenterCheckBox);
        panel.add(idNumberField);
        panel.add(informationLabel);

        //Vehicle Owner fields
        panel.add(licensePlateField);
        panel.add(carMakeField);
        panel.add(carModelField);
        panel.add(carYearField);

        //Vehicle Owner fields
        panel.add(JobDeadlineField);
        panel.add(JobDurationField);


        // adds to current object
        frame.add(panel);
    }
}
