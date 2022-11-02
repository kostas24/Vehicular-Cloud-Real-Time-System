ppackage GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RenterDashboard {

    JFrame renterFrame = new JFrame();
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 800;

    private JLabel nameLabel;
    private JPanel panel;
    private JLabel addJobLabel;
    private JLabel deleteJobLabel;
    private JLabel jobStatusLabel;
    private JLabel jobCompletionTimeLabel;

    private JTextField jobDuration;
    private JTextField jobDeadline;
    private JTextField jobId;

    private JButton addJobButton;
    private JButton deleteJobButton;
    private JButton viewJobStatusButton;
    private JButton jobCompletionTimeButton;
    private Color BLUE=Color.BLUE;



    public RenterDashboard() {
        nameLabel = new JLabel("Sample Renter"); //Should be users name top right corner of frame im thinking
        nameLabel.setBounds(0, 0, 200, 35);
        nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        nameLabel.setForeground(Color.white);

        addJobLabel = new JLabel("Add Job");
        addJobLabel.setBounds(0, 50, 200, 35);
        addJobLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        addJobLabel.setForeground(Color.white);

        deleteJobLabel = new JLabel("Delete Job");
        deleteJobLabel.setBounds(0, 100, 200, 35);
        deleteJobLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        deleteJobLabel.setForeground(Color.white);

        jobStatusLabel = new JLabel("View Job Status");
        jobStatusLabel.setBounds(0, 150, 200, 35);
        jobStatusLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        jobStatusLabel.setForeground(Color.white);

        jobDuration = new JTextField("");
        jobDuration.setBounds(240, 200, 350, 35);
        jobDuration.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));

        jobDeadline = new JTextField("");
        jobDeadline.setBounds(240, 230, 350, 35);
        jobDeadline.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));

        jobId = new JTextField("");
        jobId.setBounds(240, 260, 350, 35);
        jobId.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
        createPanel();
        renterFrame.setTitle("VCRTS - Vehicle Renter Dashboard"); //setting Title on top left corner of GUI

        ImageIcon CloudComputingIcon = new ImageIcon("Images/Cloud Computing.jpg");
        renterFrame.setIconImage(CloudComputingIcon.getImage()); //Changing Frame Icon to cloud computing icon

        //INPUTTING SIZE OF GUI from VARIABLES
        renterFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        renterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        renterFrame.setVisible(true);

        addJobLabel.setVisible(false);
        deleteJobLabel.setVisible(false);
        jobStatusLabel.setVisible(false);
        jobCompletionTimeLabel.setVisible(false);
        jobDuration.setVisible(false);
        jobDeadline.setVisible(false);
        jobId.setVisible(false);

        // addJobButton= new JButton("Add Job",false)
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == addJobButton) {
            addJobLabel.setVisible(true);
            jobDuration.setVisible(true);
            jobDeadline.setVisible(true);
            jobId.setVisible(true);
        } else if (event.getSource() == deleteJobButton) {
            jobId.setVisible(true);
        } else if (event.getSource() == jobCompletionTimeButton) {
            jobId.setVisible(true);
        }
    }

    private void createAddButton() {
        addJobButton = new JButton("Add Job");
        addJobButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
        addJobButton.setForeground(Color.white);
        addJobButton.setBounds(270, 410, 250, 40);
        addJobButton.setBackground(BLUE);
        addJobButton.setOpaque(true);
        addJobButton.setBorderPainted(false);
        addJobButton.addActionListener((ActionListener) this);
    }
    private void createDeleteButton(){
        deleteJobButton = new JButton("Add Job");
        deleteJobButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
        deleteJobButton.setForeground(Color.white);
        deleteJobButton.setBounds(270, 410, 250, 40);
        deleteJobButton.setBackground(BLUE);
        deleteJobButton.setOpaque(true);
        deleteJobButton.setBorderPainted(false);
        deleteJobButton.addActionListener((ActionListener) this);

    }

    private void createPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color (32, 42, 68));
        panel.add(nameLabel);
        panel.add(addJobLabel);
        panel.add(deleteJobLabel);
        //panel.add(JobStatusLabel);
        panel.add(jobDuration);
        panel.add(jobDeadline);
        panel.add(jobId);
        panel.add(addJobButton);
        panel.add(deleteJobButton);
        panel.add(jobCompletionTimeButton);
        panel.add(jobCompletionTimeLabel);

        renterFrame.add(panel);
    }
}
