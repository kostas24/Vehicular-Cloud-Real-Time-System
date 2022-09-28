
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SystemFrame extends JFrame{

	private static final int FRAME_WIDTH = 500;
	   private static final int FRAME_HEIGHT = 500;
	   
	   private JLabel tLabel;
	   private JTextField tField;
	   private JButton buttonHU;
	   private JButton buttonVO;
	   private JLabel welcomeLabel;
	   private JLabel optionLabel;
	   
	   public SystemFrame()
	   {  	
			this.setBackground(Color.black);
			this.setFocusable(true);
	      welcomeLabel = new JLabel("Welcome to VCRTS");
	      welcomeLabel.setBounds(105, 10, 300, 30);   
	      welcomeLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
	      optionLabel = new JLabel("Please login or create an account below");
	      optionLabel.setBounds(105, 100, 300, 30);   
	      optionLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
	      
	      
	      //createTextField();
	      createButtonHU();
	      createButtonVO();
	      createPanel();
	      setTitle("VCRTS");
	      setSize(FRAME_WIDTH, FRAME_HEIGHT);
	   }
	   

	   class AddInterestListener implements ActionListener
	   {
	      public void actionPerformed(ActionEvent event)
	      {
	        // String name= tField.getText();
	        // welcomeLabel.setText("Hello " + name+ " have a great day!");
	      }            
	   }
	      /*
	   private void createTextField()
	   {
		  
	      tLabel = new JLabel("Enter Name: ");
	      
	      final int FIELD_WIDTH = 10;
	      tField = new JTextField(FIELD_WIDTH);
	      tField.setText("");
	   }
	   */
	   
	   // create a button
	   private void createButtonHU()
	   {
	      buttonHU = new JButton("Create Account");
	     // Dimension size = buttonHU.getPreferredSize();
	      buttonHU.setBounds(180, 220, 140, 25);
	      ActionListener listener = new AddInterestListener();
	      buttonHU.addActionListener(listener);   
	   }

	   private void createButtonVO()
	   {
	      buttonVO = new JButton("Login");
	     // Dimension size = buttonVO.getPreferredSize();
	      buttonVO.setBounds(180, 180, 140, 25);
	      ActionListener listener = new AddInterestListener();
	      buttonVO.addActionListener(listener);   
	   }
	   
	   //create a panel
	   private void createPanel()
	   {
	      JPanel panel = new JPanel();
	      //panel.add(tLabel);
	     // panel.add(tField);
	      
	      panel.setLayout(null);
	      panel.add(buttonHU);
	      panel.add(buttonVO);
	      panel.add(welcomeLabel); 
	      panel.add(optionLabel); 
	      // adds to current object
	      add(panel);
	   } 
	   
	   
}