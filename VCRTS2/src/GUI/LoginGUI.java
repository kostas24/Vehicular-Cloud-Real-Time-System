package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ObjectClasses.Controller;

public class LoginGUI implements ActionListener{

    JFrame frame = new JFrame();
    JFrame popup;
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	
	private JLabel loginLabel;
	private JLabel nameLabel;
	private JLabel passwordLabel;
	private JPanel panel;
	private JTextField nameField;
	private JPasswordField passwordField;
	private JButton enterName;
	private JButton createBack;
	private JLabel welcomeLabel;
	private JLabel noAccountLabel;
	private Color BLUE = Color.BLUE;
	
	public LoginGUI() {
		noAccountLabel= new JLabel(""); 
		noAccountLabel.setForeground(Color.white);
		noAccountLabel.setBounds(70, 430, 650, 40);
		noAccountLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		loginLabel = new JLabel("Login Below"); 
		loginLabel.setForeground(Color.white);
		loginLabel.setBounds(290, 10, 270, 60); 
		loginLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		nameField = new JTextField("");
		nameField.setBounds(240, 300, 320, 35);
		nameField.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(135, 340, 100, 35);
		passwordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		passwordLabel.setForeground(Color.white);
		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(170, 300, 100, 35);
		nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		nameLabel.setForeground(Color.white);
		passwordField = new JPasswordField("");
		passwordField.setBounds(240, 340, 320, 35);
		passwordField.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		createButtonName();
		createWelcomeLabel();
		createBackButton();
		createPanel();			
		frame.setTitle("VCRTS - Login"); 
		
		ImageIcon CloudComputingIcon = new ImageIcon("Images/Cloud Computing.jpg");
		frame.setIconImage(CloudComputingIcon.getImage());  
		
		//INPUTTING SIZE OF GUI from VARIABLES
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String name = nameField.getText();
		String password = String.valueOf(passwordField.getPassword());
		if(e.getSource() == createBack)
		{
			frame.dispose();
			LaunchPage launch = new LaunchPage();
		}
		if(!name.isEmpty() && !password.isEmpty())
		{
		
		welcomeLabel.setText("Welcome " + name);
		welcomeLabel.setForeground(Color.white);
		welcomeLabel.setBounds(330 - (name.length()*5), 240, 450, 60);
		welcomeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		noAccountLabel.setText("It seems you do not have an account, please create an account");
		
			if(name.equals("admin") && password.equals("admin"))
			{			
				frame.dispose();
				ControllerDashboard controller = new ControllerDashboard();
			}
			else {			
				for (int i = 0; i < Controller.getTempVehicleOwner().size(); i++) {
					if(name.equals(Controller.getTempVehicleOwner().get(i).getEmail())) {
						frame.dispose();
						OwnerDashboard OwnerDashboard = new OwnerDashboard(Controller.getTempVehicleOwner().get(i));
					}
				}
				
				for (int i = 0; i < Controller.getTempVehicleRenter().size(); i++) {
					if(name.equals(Controller.getTempVehicleRenter().get(i).getEmail())) {
						frame.dispose();
						RenterDashboard RenterDashboard = new RenterDashboard(Controller.getTempVehicleRenter().get(i));
					}
				}	
			}
		}
		else if(!(e.getSource() == createBack)){
			 popup = new JFrame();
			 welcomeLabel.setText("");
			 JOptionPane.showMessageDialog(popup, "Please fill out all the fields to continue", "Error", JOptionPane.ERROR_MESSAGE);
			 
		}
		

		
	}
	
	public void createButtonName() {
		enterName = new JButton("Enter");
		enterName.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
		enterName.setForeground(Color.white);
		enterName.setBounds(270, 390, 250, 40);
		enterName.setBackground(BLUE);
		enterName.setOpaque(true);
		enterName.setBorderPainted(false);
		enterName.addActionListener(this);
	}
	
    private void createBackButton() {
        createBack = new JButton("Back");
        createBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        createBack.setForeground(Color.white);
        createBack.setBounds(10, 10, 100, 40); 
        createBack.setBackground(BLUE);
        createBack.setOpaque(true);
		createBack.setBorderPainted(false);
        createBack.addActionListener(this);
    }
	
	public void createWelcomeLabel() {
		welcomeLabel = new JLabel(" ");
	}
	
	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color (32, 42, 68));
		panel.add(loginLabel);
		panel.add(passwordLabel);
		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(passwordField);
		panel.add(enterName);
		panel.add(welcomeLabel);
		panel.add(createBack);
		panel.add(noAccountLabel);

		// adds to current object
		frame.add(panel);
	}


	
}