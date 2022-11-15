package ObjectClasses;
import java.util.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.net.ServerSocket;
import java.net.Socket;

public class VehicleRenter extends Account implements Runnable{

	private ArrayList<Job> jobs;
	
	static ServerSocket serverSocket;
	static Socket socket;
	static DataInputStream inputStream;
	static DataOutputStream outputStream;
	public String requestedJob;
	
	public void run() {
		// TODO Auto-generated method stub

		String messageIn = "";
		String messageOut = "";
		Scanner keyInput;

		try {

			System.out.println("----------*** This is Renter client side ***--------");
			System.out.println("client started!");
			// connect the client socket to server
			Socket socket = new Socket("localhost", 1);

			// client reads a message from Server
			inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new DataOutputStream(socket.getOutputStream());

			System.out.println("Client connected to server");
			
			outputStream.writeUTF(requestedJob);
			
			System.out.println("Client job request sent");
			

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	/*
	 * Basic constructor for current Milestone that only adds job to this vehicle
	 * renter with the job duration and ID since none of the other information is
	 * currently necessary.
	 */
	public VehicleRenter(String name, String email, int phoneNum, String id, int jobDuration, int jobID) {

		super(name, email, phoneNum, id);
		jobs = new ArrayList<Job>();
		requestJob(jobDuration, jobID);
	}

	/*
	 * Overloaded constructor with all the parameters necessary to construct a
	 * vehicle renter object with all parameters for a job for future implementation.
	 */
	public VehicleRenter(String name, String email, int phoneNum, String id, int jobDuration, Date jobDeadline,
			int jobPriorityLevel, int jobID) {

		super(name, email, phoneNum, id);
		jobs = new ArrayList<Job>();
		requestJob(jobDuration, jobDeadline, jobPriorityLevel, jobID);
	}
	
	/*
	 * Basic method in order to add a job using just jobDuration and jobID for current implementation.
	 */
	public void requestJob(int jobDuration, int jobID) {
		//jobs.add(new Job(jobDuration, jobID));
		String jobDurationString = Integer.toString(jobDuration);
		String jobIDString = Integer.toString(jobID);

		String requestedJob = "Job Duration: " + jobDurationString + ", " + "Job ID: " + jobIDString;
		System.out.println(requestedJob);
		this.requestedJob = requestedJob;

	}
	
	/*
	 * Overloaded method with all parameters to add a job for future implementation.
	 */
	void requestJob(int jobDuration, Date jobDeadline, int jobPriorityLevel, int jobID) {
		jobs.add(new Job(jobDuration, jobDeadline, jobPriorityLevel, jobID));
	}
	
	/*
	 * Method to delete a job using its JobID and returns a boolean to confirm the job was found and 
	 * deleted to be used in GUI to throw error if the job is not found. 
	 */
	public boolean deleteJob(int jobID) {
		boolean jobFound = false;
		for (int i = 0; i < jobs.size(); i++) {
			if (jobs.get(i).getJobID() == jobID) {
				jobs.remove(i);
				jobFound = true;
			}
		}
		return jobFound;
	}
	
	public ArrayList getJobList() {
		return jobs;
	}

}