import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LaunchPage implements ActionListener{

	
	//Variables for size of Entire GUI
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 1000;

	JFrame frame = new JFrame();
	private JButton ButtonAccount;
	private JButton ButtonLogin;
	private JLabel welcomeLabel;
	private JLabel optionLabel;
	private JPanel panel;
	private Color lav = new Color(221,160,221);

	public LaunchPage() {
		//INPUTTING SIZE OF GUI from VARIABLES
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		welcomeLabel = new JLabel("Welcome to VCRTS"); 
		welcomeLabel.setBounds(250, 10, 500, 50); //Set location of label
		welcomeLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		optionLabel = new JLabel("Please login or create an account below");
		optionLabel.setBounds(210, 300, 600, 50); //Set location of label
		optionLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));

		ImageIcon CloudComputingIcon = new ImageIcon("Cloud Computing.jpg");
		frame.setIconImage(CloudComputingIcon.getImage()); //Changing Frame Icon to cloud computing icon
		createButtonAccount(); 
		createButtonLogin();
		createPanel();	
		 frame.setVisible(true);
		frame.setTitle("VCRTS"); //setting Title on top left corner of GUI	
	}

		public void actionPerformed(ActionEvent event) {

			if(event.getSource() == ButtonLogin)
			{
				frame.dispose();
				PostLogin login = new PostLogin();
			}
			else if(event.getSource() == ButtonAccount)
			{
				frame.dispose();
				AccountCreation account = new AccountCreation();
			}
			/*
			createNameField("Name", 180, 275, 140, 25);
			createPasswordField("Password", 180, 315, 140, 25);
			String name = nameField.getText();
			String password = passwordField.getText();
*/
		}
	
		/*
	//Creates a textField that asks for name
	private void createNameField(String text, int x, int y, int width, int height) {

		// tLabel = new JLabel("Enter Name: ");
		// tLabel.setBounds(180, 195, 140, 25);
		// final int FIELD_WIDTH = 10;
		// tField = new JTextField(FIELD_WIDTH);
		
		nameField = new JTextField(text);
		nameField.setBounds(x, y, width, height);
	
		// tField.setText("");
	}
	//Creates a textField that asks for password
	private void createPasswordField(String text, int x, int y, int width, int height) {
		passwordField = new JTextField(text);
		passwordField.setBounds(x, y, width, height);

	}
*/
	// Creating Button to Create Account
	private void createButtonAccount() {
		ButtonAccount = new JButton("Create Account");
		ButtonAccount.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		ButtonAccount.setBounds(350, 420, 280, 50); //Set location of button	
		ButtonAccount.setBackground(lav);
		ButtonAccount.addActionListener(this);

	}

	//Create Login Button
	private void createButtonLogin() {
		ButtonLogin = new JButton("Login");
		ButtonLogin.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		ButtonLogin.setBounds(350, 360, 280, 50); //Set location of button
		ButtonLogin.setBackground(lav);
		ButtonLogin.addActionListener(this);
	}

	// create a panel to show the labels/buttons on GUI
	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.add(ButtonAccount);
		panel.add(ButtonLogin);
		panel.add(welcomeLabel);
		panel.add(optionLabel);
		panel.setBackground(Color.CYAN); //panel color
		// adds to current object
		frame.add(panel);
		
		
	}

}
