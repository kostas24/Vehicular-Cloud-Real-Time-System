package ObjectClasses;

import java.util.*;

public class Controller {

	private static ArrayList<VehicleRenter> vehicleRenters;
	private static ArrayList<VehicleOwner> vehicleOwners;
	private static ArrayList<Integer> jobIDList;
	private static ArrayList<Integer> completionTimes;

	public Controller() {
		jobIDList = new ArrayList<Integer>();
		completionTimes = new ArrayList<Integer>();
		vehicleRenters = new ArrayList<VehicleRenter>();
		vehicleOwners = new ArrayList<VehicleOwner>();
	}

	public void calculateCompletionTime() { // shouldn't this return something?
		int completionTime = 0;
		ArrayList<Job> jobList = new ArrayList<Job>();
		System.out.println("here");
		System.out.println(vehicleRenters.size());
		for (int i=0; i<vehicleRenters.size(); i++) {
			jobList = vehicleRenters.get(i).getJobList();
			System.out.println("here");
			System.out.println(jobList.get(0).getCompletionTime());
			for (int j = 0; j < jobList.size(); j++) {
				completionTime += jobList.get(i).getJobDuration();
				jobList.get(i).setCompletionTime(completionTime);
				completionTimes.add(completionTime);
			}
		}
		//return jobList.size();
	}

	public void approveJob() {

	}

	/*
	 * Adds a VehicleOwner to the list of renters known to the Controller.
	 */
	public void addOwner(String name, String email, int phoneNumber, String id, String licensePlate, String carMake,
			String carModel, int carYear, int residencyTime) {
		vehicleOwners.add(new VehicleOwner(name, email, phoneNumber, id, licensePlate, carMake, carModel, carYear,
				residencyTime));

	}
	
	/*
	 * Removes a VehicleOwner from the list of renters known to the Controller using their email to find and 
	 * remove them.
	 */
	public boolean removeOwner(String email) {
		boolean removed = false;
		for (int i = 0; i < vehicleOwners.size(); i++) {
			if (vehicleOwners.get(i).getEmail().equals(email)) {
				vehicleOwners.remove(i);
				removed = true;
			}
		}
		return removed;
	}

	/*
	 * Adds a VehicleRenter to the list of renters known to the Controller.
	 */
	public void addRenter(String name, String email, int phoneNum, String id, int jobDuration, int jobID) {
		vehicleRenters.add(new VehicleRenter(name, email, phoneNum, id, jobDuration, jobID));

	}

	/*
	 * Removes a VehicleRenter from the list of renters known to the Controller using their email to find and 
	 * remove them.
	 */
	public boolean removeRenter(String email) {
		boolean removed = false;
		for (int i = 0; i < vehicleOwners.size(); i++) {
			if (vehicleRenters.get(i).getEmail().equals(email)) {
				vehicleRenters.remove(i);
				removed = true;
			}
		}
		return removed;
	}

	public int generateJobID() {
		Random rand = new Random();
		int jobID = rand.nextInt(10000);
		while (jobIDList.contains(jobID)) {
			jobID = rand.nextInt(10000);
		}
		return jobID;
	}
	
	public void addNewRenter (VehicleRenter renter) {
		vehicleRenters.add(renter);
		System.out.println(vehicleRenters.get(0).getName());
		System.out.println(vehicleRenters.size());
	}

}