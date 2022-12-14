package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LaunchPage implements ActionListener{
	//Variables for size of Entire GUI
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;

	JFrame frame = new JFrame();
	private JButton ButtonAccount;
	private JButton ButtonLogin;
	private JLabel welcomeLabel;
	private JLabel optionLabel;
	private JPanel panel;
	private Color BLUE = Color.BLUE;
	private JLabel cloudImage;
	
	public LaunchPage() {
		//INPUTTING SIZE OF GUI from VARIABLES
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		welcomeLabel = new JLabel("VCRTS"); 
		welcomeLabel.setBounds(330, 180, 150, 50); 
		welcomeLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		welcomeLabel.setForeground(Color.white);
		optionLabel = new JLabel("Please login or create an account below");
		optionLabel.setBounds(110, 300, 600, 50); 
		optionLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		optionLabel.setForeground(Color.white);
		cloudImage = new JLabel("");
		cloudImage.setIcon(new ImageIcon("Images/cloud.png"));
		cloudImage.setBounds(220, 5, 300, 250);
		ImageIcon CloudComputingIcon = new ImageIcon("Images/Cloud Computing.jpg");
		frame.setIconImage(CloudComputingIcon.getImage()); 
		createButtonAccount(); 
		createButtonLogin();
		createPanel();	
		frame.setVisible(true);
		frame.setTitle("VCRTS - Launch Page"); 
		
	}

		public void actionPerformed(ActionEvent event) {

			if(event.getSource() == ButtonLogin)
			{
				frame.dispose();
				LoginGUI login = new LoginGUI();
			}
			else if(event.getSource() == ButtonAccount)
			{
				frame.dispose();
				AccountCreation account = new AccountCreation();
			}
		}

	// Creating Button to Create Account
	private void createButtonAccount() {
		ButtonAccount = new JButton("Create Account");
		ButtonAccount.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
		ButtonAccount.setForeground(Color.white);
		ButtonAccount.setBounds(270, 410, 250, 40); //Set location of button	
		ButtonAccount.setBackground(BLUE);
		ButtonAccount.setOpaque(true);
		ButtonAccount.setBorderPainted(false);
		ButtonAccount.addActionListener(this);

	}

	//Create Login Button
	private void createButtonLogin() {
		ButtonLogin = new JButton("Login");
		ButtonLogin.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
		ButtonLogin.setForeground(Color.white);
		ButtonLogin.setBounds(270, 360, 250, 40); //Set location of button
		ButtonLogin.setBackground(BLUE);
		ButtonLogin.setOpaque(true);
		ButtonLogin.setBorderPainted(false);
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
		panel.add(cloudImage);
		panel.setBackground(new Color (32, 42, 68)); //panel color
		// adds to current object
		frame.add(panel);
		
		
	}

}