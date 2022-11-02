package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
//import ObjectClasses.Controller;

public class ControllerDashboard implements ActionListener{

		JFrame ControllerFrame = new JFrame();
		private static final int FRAME_WIDTH = 800;
		private static final int FRAME_HEIGHT = 800;
		
		private JButton buttonCompletionTime;
		private JLabel completionTimeLabel;
		private JPanel panel;
		private JButton createBack;
		//private Controller controller = new Controller();
		private ArrayList<Integer> completionTimes;
		
		
		public ControllerDashboard() {
			//completionTimes = controller.calculateCompletionTime()
			completionTimeLabel = new JLabel("----------"); 
			completionTimeLabel.setBounds(300, 300, 350, 40); 
			completionTimeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
			completionTimeLabel.setForeground(Color.white);
			
			createButtonCompletionTime();
			createBackButton();
			createPanel();			
			ControllerFrame.setTitle("VCRTS - Vehicle Controller Dashboard"); 
			
			ImageIcon CloudComputingIcon = new ImageIcon("Images/Cloud Computing.jpg");
			ControllerFrame.setIconImage(CloudComputingIcon.getImage()); 
			
			//INPUTTING SIZE OF GUI from VARIABLES
			ControllerFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

			ControllerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    ControllerFrame.setVisible(true);
		}

		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == buttonCompletionTime)
			{		
				Controller controller = new Controller();
				controller.calculateCompletionTime();
				
				
				//Maybe add an if statement to detect if there are no Jobs/completionTime arraylist is empty?
				/*
				StringBuilder sb = new StringBuilder();
				for (Integer i : completionTimes) {
				    sb.append(i == null ? "" : i.toString());
				}
				completionTimeLabel.setText(sb.toString());
			*/		
			}
			
			if(e.getSource() == createBack)
			{
				ControllerFrame.dispose();
				LaunchPage launch = new LaunchPage();
			}
		}
		
		private void createButtonCompletionTime() {
			buttonCompletionTime = new JButton("Find Completion Time");
			buttonCompletionTime.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
			buttonCompletionTime.setForeground(Color.white);
			buttonCompletionTime.setBounds(220, 360, 360, 40); 
			buttonCompletionTime.setBackground(Color.BLUE);
			buttonCompletionTime.setBorderPainted(false);
			buttonCompletionTime.addActionListener(this);
		}
		
		 private void createBackButton() {
		        createBack = new JButton("Back");
		        createBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		        createBack.setForeground(Color.white);
		        createBack.setBounds(10, 10, 100, 40); //Set location of button
		        createBack.setBackground(Color.BLUE);
		        createBack.setOpaque(true);
				createBack.setBorderPainted(false);
		        createBack.addActionListener(this);
		    }

		private void createPanel() {
			panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(new Color (32, 42, 68));
			panel.add(buttonCompletionTime);
			panel.add(completionTimeLabel);
			panel.add(createBack);
			ControllerFrame.add(panel);
		
		}
		
	
}
