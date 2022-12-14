package ObjectClasses;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.sql.Date;
import java.util.*;

import javax.swing.JTable;

public class Controller {

	private static ArrayList<VehicleRenter> vehicleRenters;
	private static ArrayList<VehicleOwner> vehicleOwners;
	private static ArrayList<VehicleRenter> tempVehicleRenters;
	private static ArrayList<VehicleOwner> tempVehicleOwners;
	private static ArrayList<Integer> jobIDList;
	private static ArrayList<Integer> completionTimes;

	private static int nextJobID;

	static ServerSocket serverSocketRent;
	static ServerSocket serverSocketOwn;
	static Socket socketRent;
	static Socket socketOwn;
	static DataInputStream inputStreamRent;
	static DataOutputStream outputStreamRent;
	static DataInputStream inputStreamOwn;
	static DataOutputStream outputStreamOwn;

	public static VehicleOwner latestOwner;
	public static VehicleRenter latestRenter;

	public static boolean socketRentFound = false;
	public static boolean socketOwnFound = false;

	public static void main(String[] args) {

		String messageInRenter = "";
		String messageOutRenter = "";
		String messageInOwner = "";
		String messageOutOwner = "";
		Scanner keyInput;

		try {
			System.out.println("----------$$$ This is server side $$$--------");
			System.out.println("wating for client to connect...");
			serverSocketRent = new ServerSocket(1);
			serverSocketOwn = new ServerSocket(2);

			// server accepts connection request from client
			while (true) {
				if (socketRentFound = true) {
					socketRent = serverSocketRent.accept();
					System.out.println("Renter is connected!");
					inputStreamRent = new DataInputStream(socketRent.getInputStream());
					outputStreamRent = new DataOutputStream(socketRent.getOutputStream());
					messageInRenter = inputStreamRent.readUTF();
					System.out.println("Renter - " + messageInRenter);
					socketRent.close();
				}

				if (socketOwnFound = true) {
					socketOwn = serverSocketOwn.accept();
					System.out.println("Owner is connected!");
					inputStreamOwn = new DataInputStream(socketOwn.getInputStream());
					outputStreamOwn = new DataOutputStream(socketOwn.getOutputStream());
					messageInOwner = inputStreamOwn.readUTF();
					System.out.println("Owner - " + messageInOwner);
					socketOwn.close();
				}
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
		tempVehicleRenters = new ArrayList<VehicleRenter>();
		tempVehicleOwners = new ArrayList<VehicleOwner>();
		nextJobID = 0;
	}

	public static ArrayList<Integer> calculateCompletionTime() {
		completionTimes.clear();
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

	public static void approveOwner(VehicleOwner Owner) {
		if(!vehicleOwners.contains(Owner)) {
			vehicleOwners.add(Owner);
			Owner.setAcceptedStatus(true);
			Owner.setStatusChanged(true);
		}
	}
	
	public static void approveRenter(VehicleRenter Renter) {
		if (!vehicleRenters.contains(Renter)) {
			vehicleRenters.add(Renter);
			Renter.setAcceptedStatus(true);
			Renter.setStatusChanged(true);
		}
	}
	
	public static void rejectOwner(VehicleOwner Owner) {
		for (int i = 0; i < vehicleOwners.size(); i++) {
			if(vehicleOwners.get(i).equals(Owner)) {
				vehicleOwners.remove(i);
			}
		}
		Owner.setAcceptedStatus(false);
		Owner.setStatusChanged(true);
	}
	
	public static void rejectRenter(VehicleRenter Renter) {
		for (int i = 0; i < vehicleRenters.size(); i++) {
			if(vehicleRenters.get(i).equals(Renter)) {
				vehicleRenters.remove(i);
			}
		}
		Renter.setAcceptedStatus(false);
		Renter.setStatusChanged(true);
	}

	public static void addOwner(String name, String email, int phoneNumber, String id, String licensePlate,
			String carMake, String carModel, int carYear, int residencyTime) {
		VehicleOwner newOwner = new VehicleOwner(name, email, phoneNumber, id, licensePlate, carMake, carModel, carYear,
				residencyTime);
		tempVehicleOwners.add(newOwner);
		latestOwner = newOwner;
	}

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


	public static void addRenter(String name, String email, int phoneNum, String id, int jobDuration, int jobID) {
		VehicleRenter newRenter = new VehicleRenter(name, email, phoneNum, id, jobDuration, jobID);
		tempVehicleRenters.add(newRenter);
		latestRenter = newRenter;
	}

	public static boolean removeRenter(String email) {
		boolean removed = false;
		int jobID = 0;
		for (int i = 0; i < vehicleRenters.size(); i++) {
			if (vehicleRenters.get(i).getEmail().equalsIgnoreCase(email)) {
				jobID = ((Job) vehicleRenters.get(i).getJobList().get(0)).getJobID();
				vehicleRenters.remove(i);
				removed = true;
			}
		}

		for (int i = 0; i < jobIDList.size(); i++) {
			if (jobID == jobIDList.get(i)) {
				jobIDList.remove(i);
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

	public static boolean addVehicle(String email, String licensePlate, String carMake, String carModel, int carYear,
			int residencyTime) {
		boolean vehicleAdded = false;
		for (int i = 1; i < vehicleOwners.size(); i++) {
			if (vehicleOwners.get(i).getEmail().equalsIgnoreCase(email)) {
				vehicleOwners.get(i).addVehicle(licensePlate, carMake, carModel, carYear, residencyTime);
				vehicleAdded = true;
			}
		}
		return vehicleAdded;
	}

	public static int generateJobID() {
		jobIDList.add(nextJobID + 1);
		nextJobID += 1;
		return nextJobID;
	}

	public static ArrayList<Integer> getJobIDList() {
		return jobIDList;
	}

	public static ArrayList<VehicleRenter> getVehicleRenter() {
		return vehicleRenters;
	}

	public static ArrayList<VehicleOwner> getVehicleOwner() {
		return vehicleOwners;
	}
	
	public static ArrayList<VehicleRenter> getTempVehicleRenter() {
		return tempVehicleRenters;
	}
	
	public static ArrayList<VehicleOwner> getTempVehicleOwner() {
		return tempVehicleOwners;
	}

	public static JTable getJobInfoTable() {

		String[] columnNames = { "Name", "Email", "ID Number", "Phone Number", "Job Duration", "Job ID" };
		String[][] jobInfoArray = new String[vehicleRenters.size()][6];

		if (jobInfoArray.length > 0) {
			for (int i = 0; i < jobInfoArray.length; i++) {
				for (int j = 0; j < jobInfoArray[i].length; j++) {

					if (j == 0) {
						jobInfoArray[i][j] = vehicleRenters.get(i).getName();
					} else if (j == 1) {
						jobInfoArray[i][j] = vehicleRenters.get(i).getEmail();
					} else if (j == 2) {
						jobInfoArray[i][j] = vehicleRenters.get(i).getId();
					} else if (j == 3) {
						jobInfoArray[i][j] = Integer.toString(vehicleRenters.get(i).getPhoneNum());
					} else if (j == 4) {
						jobInfoArray[i][j] = Integer
								.toString(((Job) vehicleRenters.get(i).getJobList().get(0)).getJobDuration());
					} else if (j == 5) {
						jobInfoArray[i][j] = Integer
								.toString(((Job) vehicleRenters.get(i).getJobList().get(0)).getJobID());
					}
				}
			}
		}

		JTable jobInfoTable = new JTable(jobInfoArray, columnNames);
		return jobInfoTable;
	}

	public static JTable getVehicleInfoTable() {
		String[] columnNames = { "Name", "Email", "ID Number", "Phone Number", "License Plate", "Residency Time",
				"Car Make", "Car Model", "Car Year" };
		String[][] vehicleInfoArray = new String[vehicleOwners.size()][9];

		if (vehicleInfoArray.length > 0) {
			for (int i = 0; i < vehicleInfoArray.length; i++) {
				for (int j = 0; j < vehicleInfoArray[i].length; j++) {

					if (j == 0) {
						vehicleInfoArray[i][j] = vehicleOwners.get(i).getName();
					} else if (j == 1) {
						vehicleInfoArray[i][j] = vehicleOwners.get(i).getEmail();
					} else if (j == 2) {
						vehicleInfoArray[i][j] = vehicleOwners.get(i).getId();
					} else if (j == 3) {
						vehicleInfoArray[i][j] = Integer.toString(vehicleOwners.get(i).getPhoneNum());
					} else if (j == 4) {
						vehicleInfoArray[i][j] = vehicleOwners.get(i).getVehicleList().get(0).getLicensePlate();
					} else if (j == 5) {
						vehicleInfoArray[i][j] = Integer
								.toString(vehicleOwners.get(i).getVehicleList().get(0).getResidencyTime());
					} else if (j == 6) {
						vehicleInfoArray[i][j] = vehicleOwners.get(i).getVehicleList().get(0).getCarMake();
					} else if (j == 7) {
						vehicleInfoArray[i][j] = vehicleOwners.get(i).getVehicleList().get(0).getCarModel();
					} else if (j == 8) {
						vehicleInfoArray[i][j] = Integer
								.toString(vehicleOwners.get(i).getVehicleList().get(0).getCarYear());
					}

				}
			}
		}

		JTable vehicleInfoTable = new JTable(vehicleInfoArray, columnNames);
		return vehicleInfoTable;
	}
	
	public static JTable getTempJobInfoTable() {

		String[] columnNames = { "Name", "Email", "ID Number", "Phone Number", "Job Duration", "Job ID" };
		String[][] jobInfoArray = new String[tempVehicleRenters.size()][6];

		if (jobInfoArray.length > 0) {
			for (int i = 0; i < jobInfoArray.length; i++) {
				for (int j = 0; j < jobInfoArray[i].length; j++) {

					if (j == 0) {
						jobInfoArray[i][j] = tempVehicleRenters.get(i).getName();
					} else if (j == 1) {
						jobInfoArray[i][j] = tempVehicleRenters.get(i).getEmail();
					} else if (j == 2) {
						jobInfoArray[i][j] = tempVehicleRenters.get(i).getId();
					} else if (j == 3) {
						jobInfoArray[i][j] = Integer.toString(tempVehicleRenters.get(i).getPhoneNum());
					} else if (j == 4) {
						jobInfoArray[i][j] = Integer
								.toString(((Job) tempVehicleRenters.get(i).getJobList().get(0)).getJobDuration());
					} else if (j == 5) {
						jobInfoArray[i][j] = Integer
								.toString(((Job) tempVehicleRenters.get(i).getJobList().get(0)).getJobID());
					}
				}
			}
		}

		JTable jobInfoTable = new JTable(jobInfoArray, columnNames);
		return jobInfoTable;
	}
	
	public static JTable getTempVehicleInfoTable() {
		String[] columnNames = { "Name", "Email", "ID Number", "Phone Number", "License Plate", "Residency Time",
				"Car Make", "Car Model", "Car Year" };
		String[][] vehicleInfoArray = new String[tempVehicleOwners.size()][9];

		if (vehicleInfoArray.length > 0) {
			for (int i = 0; i < vehicleInfoArray.length; i++) {
				for (int j = 0; j < vehicleInfoArray[i].length; j++) {

					if (j == 0) {
						vehicleInfoArray[i][j] = tempVehicleOwners.get(i).getName();
					} else if (j == 1) {
						vehicleInfoArray[i][j] = tempVehicleOwners.get(i).getEmail();
					} else if (j == 2) {
						vehicleInfoArray[i][j] = tempVehicleOwners.get(i).getId();
					} else if (j == 3) {
						vehicleInfoArray[i][j] = Integer.toString(tempVehicleOwners.get(i).getPhoneNum());
					} else if (j == 4) {
						vehicleInfoArray[i][j] = tempVehicleOwners.get(i).getVehicleList().get(0).getLicensePlate();
					} else if (j == 5) {
						vehicleInfoArray[i][j] = Integer
								.toString(tempVehicleOwners.get(i).getVehicleList().get(0).getResidencyTime());
					} else if (j == 6) {
						vehicleInfoArray[i][j] = tempVehicleOwners.get(i).getVehicleList().get(0).getCarMake();
					} else if (j == 7) {
						vehicleInfoArray[i][j] = tempVehicleOwners.get(i).getVehicleList().get(0).getCarModel();
					} else if (j == 8) {
						vehicleInfoArray[i][j] = Integer
								.toString(tempVehicleOwners.get(i).getVehicleList().get(0).getCarYear());
					}

				}
			}
		}

		JTable vehicleInfoTable = new JTable(vehicleInfoArray, columnNames);
		return vehicleInfoTable;
	}
}