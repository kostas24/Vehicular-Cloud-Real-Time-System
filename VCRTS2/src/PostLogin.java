import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//test
public class PostLogin implements ActionListener{

    JFrame frame = new JFrame();
   
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;


	private JLabel test;
	private JPanel panel;
	private JTextField nameField;
	private JButton enterName;
	private JLabel welcomeLabel;
	private Color lav = new Color(221,160,221);
	//test
	
	public PostLogin() {
		test = new JLabel("Login Here. "); 
		test.setBounds(200,10,350,50);
		
		test.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		nameField = new JTextField("Name: ");
		nameField.setBounds(175, 100, 150, 25);
		
		createButtonName();
		createWelcomeLabel();
		createPanel();
		
		
		
		frame.setTitle("VCRTS"); //setting Title on top left corner of GUI
		
		ImageIcon CloudComputingIcon = new ImageIcon("Cloud Computing.jpg");
		frame.setIconImage(CloudComputingIcon.getImage()); //Changing Frame Icon to cloud computing icon
		
		//INPUTTING SIZE OF GUI from VARIABLES
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = nameField.getText();
		welcomeLabel.setText("Welcome " + name);
		
	}
	
	public void checkName() {
		
	}
	
	public void createButtonName() {
		enterName = new JButton("Enter");
		enterName.setBounds(175, 125, 150, 25);
		enterName.setBackground(lav);
		enterName.addActionListener(this);
	}
	
	public void createWelcomeLabel() {
		welcomeLabel = new JLabel(" ");
		welcomeLabel.setBounds(190, 200, 350, 50);
		welcomeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
	}
	
	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.CYAN);
		panel.add(test);
		panel.add(nameField);
		panel.add(enterName);
		panel.add(welcomeLabel);
		

		// adds to current object
		frame.add(panel);
	}


	
}
