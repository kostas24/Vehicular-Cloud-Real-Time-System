import java.awt.*;
import javax.swing.*;

public class PostLogin {

    JFrame frame = new JFrame();
   
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;


	private JLabel test;
	private JPanel panel;
	private JTextField nameField;
	
	public PostLogin() {
		test = new JLabel("Login Here. "); 
		test.setBounds(200,10,350,50);
		
		test.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		nameField = new JTextField("Name:");
		nameField.setBounds(150, 50, 200, 25);
		nameField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		createPanel();
		
		
		frame.setTitle("VCRTS"); //setting Title on top left corner of GUI
		
		ImageIcon CloudComputingIcon = new ImageIcon("Cloud Computing.jpg");
		frame.setIconImage(CloudComputingIcon.getImage()); //Changing Frame Icon to cloud computing icon
		
		//INPUTTING SIZE OF GUI from VARIABLES
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
	
	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.CYAN);
		panel.add(test);
		panel.add(nameField);

		// adds to current object
		frame.add(panel);
	}
}
