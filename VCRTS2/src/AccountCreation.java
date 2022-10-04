import java.awt.*;
import javax.swing.*;

public class AccountCreation {

    JFrame frame = new JFrame();
   
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 600;


	private JLabel test;
	private JLabel confirmLabel;
	private JPanel panel;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField phoneNumField;
	private JButton createAccount;
	private JCheckBox c1;
	private JCheckBox c2;
	private Color lav = new Color(221, 160, 221);
	
	public AccountCreation() {
		test = new JLabel("Create Account Here"); 
		test.setBounds(200,100,400,50);
		
		test.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		nameField = new JTextField("Name: ");
		nameField.setBounds(200, 100, 150, 25);
		emailField = new JTextField("Email: ");
		emailField.setBounds(200, 170, 150, 25);
		phoneNumField = new JTextField("Phone Number: ");
		phoneNumField.setBounds(200, 240, 150, 25);
		
		c1 = new JCheckBox("Vehicle Owner");
		c1.setBounds(200, 280, 150, 25);
	        c1.setSelected(false);
	    
		c2 = new JCheckBox("Vehicle Renter");
		c2.setBounds(200, 320, 150, 25);
		c2.setSelected(false);
		
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
		createAccount.setBounds(200,410,150,25);
		createAccount.setBackground(lav);
		
	}
	public void actionPerformed(ActionEvent e) {
		String name = nameField.getText();
		confirmLabel.setText(name);
		String email = emailField.getText();
		confirmLabel.setText(email);
		String phoneNum = phoneNumField.getText();
		confirmLabel.setText(phoneNum);
		
	}
	private void createPanel() {
		panel = new JPanel();

		panel.setLayout(null);
		panel.setBackground(Color.CYAN);
		panel.add(test);
		panel.add(nameField);
		panel.add(emailField);
		panel.add(phoneNumField);
		panel.add(createAccount);
		panel.add(c1);
		panel.add(c2);

		// adds to current object
			frame.add(panel);
	}
}
