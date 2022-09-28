import java.awt.*;
import javax.swing.*;

public class PostLogin {

    JFrame frame = new JFrame();
   
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;


	private JLabel test;
	private JPanel panel;
	
	public PostLogin() {
		test = new JLabel("Login Here. "); 
		test.setBounds(0,0,300,50);
		
		test.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
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

		// adds to current object
		frame.add(panel);
	}
}
