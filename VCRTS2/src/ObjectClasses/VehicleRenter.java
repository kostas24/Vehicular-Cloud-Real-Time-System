package ObjectClasses;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

public class VehicleRenter extends Account {

	private ArrayList<Job> jobs;

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
	private void requestJob(int jobDuration, int jobID) {
		jobs.add(new Job(jobDuration, jobID));
		File jobRegistry = new File("VCRTSjobs.txt");
		FileWriter fWriter;
		try {
			fWriter = new FileWriter(jobRegistry);
			fWriter.write("Job ID: " + jobID + " _ Job Duration: " + jobDuration);
			fWriter.close();
		}
		catch (IOException error) {
			System.out.println("An error has occured");
		}
	}
	
	/*
	 * Overloaded method with all parameters to add a job for future implementation.
	 */
	private void requestJob(int jobDuration, Date jobDeadline, int jobPriorityLevel, int jobID) {
		jobs.add(new Job(jobDuration, jobDeadline, jobPriorityLevel, jobID));
	}
	
	/*
	 * Method to delete a job using its JobID and returns a boolean to confirm the job was found and 
	 * deleted to be used in GUI to throw error if the job is not found. 
	 */
	private boolean deleteJob(int jobID) {
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
