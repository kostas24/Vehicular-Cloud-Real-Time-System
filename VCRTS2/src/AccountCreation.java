import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;


import javax.swing.*;

public class AccountCreation implements ActionListener{

    JFrame frame = new JFrame();

    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 1000;

    //Labels and variables for the Frame and Panel
    private JLabel accounttextLabel;
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
    private JTextField jobDurationField;
    private JTextField jobDeadlineField;
    private JTextField residencyTimeField;
    private JButton createAccount;
    private JButton createBack;
    private JCheckBox vehicleOwnerCheckBox;
    private JCheckBox vehicleRenterCheckBox;
    private Color lav = new Color(221, 160, 221);

    //Labels and variables to hold user information; to be stored to file
    private boolean vehicleOwnerStatus; //Not being used at this time
    private boolean vehicleRenterStatus; //Not being used at this time

    private String email;
    private String carMake;
    private String carModel;
    private String carYear;
    private String jobDuration;
    private String jobDeadline;
    private String name;
    private String phoneNum;
    private String ID;
    private String licensePlate;
    private String residencyTime;

    public AccountCreation() {
        accounttextLabel = new JLabel("Create Account Here");
        accounttextLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
        accounttextLabel.setBounds(250, 10, 500, 80);

        informationLabel = new JLabel("Please enter your personal information below: ");
        informationLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
        informationLabel.setBounds(150, 130, 700, 50);

        nameField = new JTextField("Name: ");
		nameField.setBounds(320, 200, 350, 40);
		nameField.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        emailField = new JTextField("Email: ");
		emailField.setBounds(320, 245, 350, 40);
		emailField.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        phoneNumField = new JTextField("Phone Number: ");
		phoneNumField.setBounds(320, 290, 350, 40);
		phoneNumField.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        idNumberField = new JTextField("ID Number: ");
		idNumberField.setBounds(320, 335, 350, 40);
		idNumberField.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

        //Setting up fields for if user wants to register as Vehicle Owner
        licensePlateField = new JTextField("License Plate #: ");
        licensePlateField.setBounds(320, 450, 350, 40);
        licensePlateField.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        carMakeField = new JTextField("Car Make: ");
        carMakeField.setBounds(320, 495, 350, 40);
        carMakeField.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        carModelField = new JTextField("Car Model: ");
        carModelField.setBounds(320, 540, 350, 40);
        carModelField.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        carYearField = new JTextField("Car Year: ");
        carYearField.setBounds(320, 585, 350, 40);
        carYearField.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        residencyTimeField = new JTextField("Residency Time (In Hours): ");
        residencyTimeField.setBounds(320, 630,350, 40);
        residencyTimeField.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

        //Setting fields to not be visible unless checkbox is clicked
        carMakeField.setVisible(false);
        carModelField.setVisible(false);
        carYearField.setVisible(false);
        licensePlateField.setVisible(false);
        residencyTimeField.setVisible(false);

        //Check boxes with their default values set to false
        vehicleOwnerCheckBox = new JCheckBox("Vehicle Owner", false);
        vehicleOwnerCheckBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        vehicleOwnerCheckBox.setBounds(410, 385, 150, 25);
        vehicleOwnerCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(vehicleOwnerCheckBox.isSelected())
                {
                	vehicleRenterCheckBox.setSelected(false); 
                    vehicleOwnerStatus = true;
                    //System.out.println("Vehicle Owner Check Box Clicked!");
                    carMakeField.setVisible(true);
                    carModelField.setVisible(true);
                    carYearField.setVisible(true);
                    licensePlateField.setVisible(true);
                    residencyTimeField.setVisible(true);
                    createAccount.setBounds(350, 675, 280, 50); //Set location of button
                }
                else if(!vehicleOwnerCheckBox.isSelected())
                {
                    vehicleOwnerStatus = false;
                    //System.out.println("Vehicle Owner Check Box UnClicked!");
                    carMakeField.setVisible(false);
                    carModelField.setVisible(false);
                    carYearField.setVisible(false);
                    licensePlateField.setVisible(false);
                    residencyTimeField.setVisible(false);
                }
            }
        });
        //Setting up fields for if user wants to register as Vehicle Renter
        jobDurationField = new JTextField("Job Duration (In Hours): ");
        jobDurationField.setBounds(320, 450, 350, 40);
        jobDurationField.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        jobDeadlineField = new JTextField("Job Deadline: ");
        jobDeadlineField.setBounds(320, 495, 350, 40);
        jobDeadlineField.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

        //Setting fields to not be visible unless checkbox is clicked
        jobDeadlineField.setVisible(false);
        jobDurationField.setVisible(false);

        vehicleRenterCheckBox = new JCheckBox("Vehicle Renter", false);
        vehicleRenterCheckBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        vehicleRenterCheckBox.setBounds(410, 415, 150, 25);
        vehicleRenterCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(vehicleRenterCheckBox.isSelected()) {
                	vehicleOwnerCheckBox.setSelected(false); 
                    vehicleRenterStatus = true;
                    //System.out.println("Vehicle Renter Check Box Clicked!");
                    jobDurationField.setVisible(true);
                    jobDeadlineField.setVisible(true);
                    createAccount.setBounds(350, 550, 280, 50); //Set location of button
                }
                else if (!vehicleRenterCheckBox.isSelected()){
                    vehicleRenterStatus = false;
                    jobDurationField.setVisible(false);
                    jobDeadlineField.setVisible(false);
                }
            }
        });


        createButtonCreateAccount();
        createBackButton();
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
    	createAccount.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		createAccount.setBounds(350, 655, 280, 50); //Set location of button
        createAccount.setBackground(lav);
        createAccount.addActionListener(this);

    }
    
    private void createBackButton() {
        createBack = new JButton("Back");
        createBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
        createBack.setBounds(700, 900, 240, 50); //Set location of button
        createBack.setBackground(lav);
        createBack.addActionListener(this);

    }
    
    public void actionPerformed(ActionEvent e) {
        name = nameField.getText().substring(6).trim();;
       // confirmLabel.setText(name);
        email = emailField.getText().substring(7).trim();;
     //   confirmLabel.setText(email);
        phoneNum = phoneNumField.getText().substring(14).trim();;
      //  confirmLabel.setText(phoneNum);
        ID = idNumberField.getText().substring(11).trim();;
        
        if(e.getSource() == createBack)
		{
			frame.dispose();
			LaunchPage launch = new LaunchPage();
		}
        else if(e.getSource() == createAccount)
        {
        	
        }

        File registry = new File("VCRTSregistry.txt");
        
        if(registry.isFile() == true) {
        try {
        	FileWriter fWriter = new FileWriter(registry, true);
        	fWriter.write(""+"\n");
        	fWriter.write(name + "\n");
        	fWriter.write(email + "\n");
        	fWriter.write(phoneNum + "\n");
        	fWriter.write(ID + "\n");
        	
        	if(vehicleRenterCheckBox.isSelected()) {
        		jobDuration = jobDurationField.getText().substring(25).trim();;
        		jobDeadline = jobDeadlineField.getText().substring(14).trim();;
        		fWriter.write(jobDuration + "\n");
        		fWriter.write(jobDeadline + "\n");
        	}
        	
        	if(vehicleOwnerCheckBox.isSelected()) {
        		carMake = carMakeField.getText().substring(10).trim();;
        		carModel = carModelField.getText().substring(11).trim();;
        		carYear = carYearField.getText().substring(10).trim();;
        		licensePlate = licensePlateField.getText().substring(17);
        		residencyTime = residencyTimeField.getText().substring(26);
        		fWriter.write(carMake + "\n");
        		fWriter.write(carModel + "\n");
        		fWriter.write(carYear + "\n");
        		fWriter.write(licensePlate + "\n");
        		fWriter.write(residencyTime + "\n");
        	}
        	fWriter.close();
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
        panel.add(accounttextLabel);
        panel.add(nameField);
        panel.add(emailField);
        panel.add(phoneNumField);
        panel.add(createAccount);
        panel.add(createBack);
        panel.add(vehicleOwnerCheckBox);
        panel.add(vehicleRenterCheckBox);
        panel.add(idNumberField);
        panel.add(informationLabel);

        //Vehicle Owner fields
        panel.add(licensePlateField);
        panel.add(carMakeField);
        panel.add(carModelField);
        panel.add(carYearField);
        panel.add(residencyTimeField);

        //Vehicle Owner fields
        panel.add(jobDeadlineField);
        panel.add(jobDurationField);


        // adds to current object
        frame.add(panel);
    }
}
