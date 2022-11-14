package ObjectClasses;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import java.sql.Date;
import java.util.*;

public class Controller {
	
	static ServerSocket serverSocketRent;
	static ServerSocket serverSocketOwn;
	static Socket socketRent;
	static Socket socketOwn;
	static DataInputStream inputStreamRent;
	static DataOutputStream outputStreamRent;
	static DataInputStream inputStreamOwn;
	static DataOutputStream outputStreamOwn;

	private static ArrayList<VehicleRenter> vehicleRenters = new ArrayList<VehicleRenter>();
	private static ArrayList<VehicleOwner> vehicleOwners;
	private static ArrayList<Integer> jobIDList;
	private static ArrayList<Integer> completionTimes = new ArrayList<Integer>();
	public static VehicleRenter latestRenter;
	
	public static void main(String[] args) {
		
		String messageIn = "";
		String messageOut = "";
		Scanner keyInput;
		
		try {
		System.out.println("----------$$$ This is server side $$$--------");
		System.out.println("wating for client to connect...");
		serverSocketRent = new ServerSocket(1);
		//serverSocketOwn = new ServerSocket(2);
		// sever accepts connection request from client
		socketRent = serverSocketRent.accept();
	//	socketOwn = serverSocketOwn.accept();
		
		System.out.println("client is connected!");
		
		inputStreamRent = new DataInputStream(socketRent.getInputStream());
		outputStreamRent = new DataOutputStream(socketRent.getOutputStream());
		
	//	inputStreamOwn = new DataInputStream(socketOwn.getInputStream());
	//	outputStreamOwn = new DataOutputStream(socketOwn.getOutputStream());
		
		
		
		while (!messageIn.equals("exit")) {

			// extract the message from client
			messageIn = inputStreamRent.readUTF();
			// server prints the message received from client to console
			System.out.println("message received from client: " + "\"" + messageIn + "\"");

			// ********************************************************
			// server reads a message from keyboard
			System.out.println("Enter a message you want to send to client side: ");
			keyInput = new Scanner(System.in);
			messageOut = keyInput.nextLine();
			// server sends the message to client
			outputStreamRent.writeUTF(messageOut);
		}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public Controller() {
		jobIDList = new ArrayList<Integer>();
		completionTimes = new ArrayList<Integer>();
		vehicleRenters = new ArrayList<VehicleRenter>();
		vehicleOwners = new ArrayList<VehicleOwner>();
	}

	public static ArrayList<Integer> calculateCompletionTime()  { // shouldn't this return something?
		completionTimes.clear();
		int completionTime = 0;
		for (VehicleRenter renter : vehicleRenters) {
			ArrayList<Job> jobList = new ArrayList<>(renter.getJobList());
			for (int i = 0; i < jobList.size(); i++) {
				completionTime += jobList.get(i).getJobDuration();
				jobList.get(i).setCompletionTime(completionTime);
				completionTimes.add(completionTime);
				jobList.remove(i);
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
	public static void addRenter(String name, String email, int phoneNum, String id, int jobDuration, int jobID) throws IOException {
		VehicleRenter newRenter = new VehicleRenter(name, email, phoneNum, id, jobDuration, jobID);
		vehicleRenters.add(newRenter);
		latestRenter = newRenter;
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
		Random rand = new Random();
		int jobID = rand.nextInt(10000);
		while (jobIDList.contains(jobID)) {
			jobID = rand.nextInt(10000);
		}
		return jobID;
	}
	
	public static void addJobID(int jobID) {
		jobIDList.add(jobID);
	}
	
	public static VehicleRenter returnRenter (String ID) {
		for (VehicleRenter renter: vehicleRenters) {
			if(renter.getIDNumber().equals(ID)) {
				return renter;
			}
		}
		return null;
		}
	
	public static ArrayList<Integer> getJobIDList(){
		return jobIDList;
	}
	}

