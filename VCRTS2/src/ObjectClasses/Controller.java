package ObjectClasses;

import java.sql.Date;
import java.util.*;

public class Controller {

	private static ArrayList<VehicleRenter> vehicleRenters = new ArrayList<VehicleRenter>();
	private static ArrayList<VehicleOwner> vehicleOwners;
	private static ArrayList<Integer> jobIDList;
	private static ArrayList<Integer> completionTimes = new ArrayList<Integer>();
	private static int nextJobID;

	public Controller() {
		jobIDList = new ArrayList<Integer>();
		completionTimes = new ArrayList<Integer>();
		vehicleRenters = new ArrayList<VehicleRenter>();
		vehicleOwners = new ArrayList<VehicleOwner>();
		nextJobID = 0;
	}

	/*
	 * In the future, this method should calculate job completion times in order of their ID number. ID Numbers
	 * are now set to generate in order from 0 upwards. So it can just use the jobIDList to calculate job 
	 * completion times for ease of use.
	 */
	public static ArrayList<Integer> calculateCompletionTime()  { // shouldn't this return something?
		int completionTime = 0;
		for (VehicleRenter renter : vehicleRenters) {
			ArrayList<Job> jobList = new ArrayList<>(renter.getJobList());
			for (int i = 0; i < jobList.size(); i++) {
				completionTime += jobList.get(i).getJobDuration();
				jobList.get(i).setCompletionTime(completionTime);
				completionTimes.add(completionTime);
			}
		}
	return completionTimes;
		
	}

	//Incomplete
	public void approveJob() {

	}

	/*
	 * Adds a VehicleOwner to the list of renters known to the Controller.
	 */
	public static void addOwner(String name, String email, int phoneNumber, String id, String licensePlate, String carMake,
			String carModel, int carYear, int residencyTime) {
		vehicleOwners.add(new VehicleOwner(name, email, phoneNumber, id, licensePlate, carMake, carModel, carYear,
				residencyTime));

	}
	
	/*
	 * Removes a VehicleOwner from the list of renters known to the Controller using their email to find and 
	 * remove them.
	 */
	public static boolean removeOwner(String email) {
		boolean removed = false;
		for (int i = 0; i < vehicleOwners.size(); i++) {
			if (vehicleOwners.get(i).getEmail().equalsIgnoreCase(email)) {
				vehicleOwners.remove(i);
				removed = true;
			}
		}
		return removed;
	}

	/*
	 * Adds a VehicleRenter to the list of renters known to the Controller.
	 */
	public static void addRenter(String name, String email, int phoneNum, String id, int jobDuration, int jobID) {
		vehicleRenters.add(new VehicleRenter(name, email, phoneNum, id, jobDuration, jobID));

	}
	
	
	

	/*
	 * Removes a VehicleRenter from the list of renters known to the Controller using their email to find and 
	 * remove them.
	 */
	public static boolean removeRenter(String email) {
		boolean removed = false;
		for (int i = 0; i < vehicleOwners.size(); i++) {
			if (vehicleRenters.get(i).getEmail().equalsIgnoreCase(email)) {
				vehicleRenters.remove(i);
				removed = true;
			}
		}
		return removed;
	}
	
	public static boolean addJob(String email, int jobDuration, Date jobDeadline, int jobPriorityLevel, int jobID) {
		boolean jobAdded = false;
		for (int i = 0; i < vehicleRenters.size(); i++) {
			if (vehicleRenters.get(i).getEmail().equalsIgnoreCase(email)) {
				vehicleRenters.get(i).requestJob(jobDuration, jobDeadline, jobPriorityLevel, jobID);
				jobAdded = true;
			}
		}
		return jobAdded;
	}
	
	public static boolean addVehicle(String email, String licensePlate, String carMake, String carModel, int carYear, int residencyTime) {
		boolean vehicleAdded = false;
		for(int i = 1 ; i < vehicleOwners.size(); i++) {
			if(vehicleOwners.get(i).getEmail().equalsIgnoreCase(email)) {
				vehicleOwners.get(i).addVehicle(licensePlate, carMake, carModel, carYear, residencyTime);
				vehicleAdded = true;
			}
		}
		return vehicleAdded;
	}

	public static int generateJobID() {
		//Controller controller = new Controller ();
		jobIDList.add(nextJobID+1);
		nextJobID += 1;
		return nextJobID;
	}
	
	public static ArrayList<Integer> getJobIDList(){
		return jobIDList;
	}

}