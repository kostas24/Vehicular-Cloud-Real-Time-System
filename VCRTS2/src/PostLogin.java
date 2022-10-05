import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//loginLabel
public class PostLogin implements ActionListener{

    JFrame frame = new JFrame();
   
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 1000;


	private JLabel loginLabel;
	private JPanel panel;
	private JTextField nameField;
	private JButton enterName;
	private JButton createBack;
	private JLabel welcomeLabel;
	private Color lav = new Color(221,160,221);
	//loginLabel
	
	public PostLogin() {
		loginLabel = new JLabel("Login Below"); 
		loginLabel.setBounds(350, 10, 270, 70); //Set location of label
		
		loginLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		nameField = new JTextField("Name: ");
		nameField.setBounds(320, 300, 350, 40);
		nameField.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		createButtonName();
		createWelcomeLabel();
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
	
	public void actionPerformed(ActionEvent e) {
		String name = nameField.getText().substring(5).trim();
		welcomeLabel.setText("Welcome " + name);
		welcomeLabel.setBounds(370, 240, 250, 60);
		welcomeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		
		if(e.getSource() == createBack)
		{
			frame.dispose();
			LaunchPage launch = new LaunchPage();
		}
	}
	
	public void checkName() {
		
	}
	
	public void createButtonName() {
		enterName = new JButton("Enter");
		enterName.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		enterName.setBounds(350, 360, 280, 50); //Set location of button	
		enterName.setBackground(lav);
		enterName.addActionListener(this);
	}
	
    private void createBackButton() {
        createBack = new JButton("Back");
        createBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
        createBack.setBounds(700, 900, 240, 50); //Set location of button
        createBack.setBackground(lav);
        createBack.addActionListener(this);

    }
	
	public void createWelcomeLabel() {
		welcomeLabel = new JLabel(" ");
	}
	
	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.CYAN);
		panel.add(loginLabel);
		panel.add(nameField);
		panel.add(enterName);
		panel.add(welcomeLabel);
		panel.add(createBack);

		// adds to current object
		frame.add(panel);
	}


	
}
