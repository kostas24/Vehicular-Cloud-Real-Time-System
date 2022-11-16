package ObjectClasses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class VehicleOwner extends Account implements Runnable{

	private ArrayList<Vehicle> vehicles;

	static ServerSocket serverSocket2;
	static Socket socket2;
	static DataInputStream inputStream2;
	static DataOutputStream outputStream2;
	public String requestedVehicle;
	
	public void run() {
		String messageIn = "";
		String messageIyt = "";
		Scanner keyInput;
		
		try {
			
			System.out.println("----------*** This is Owner client side ***--------");
			System.out.println("Owner started!");
			
			Socket socket2 = new Socket("localhost", 2);
			
			inputStream2 = new DataInputStream(socket2.getInputStream());
			outputStream2 = new DataOutputStream(socket2.getOutputStream());
			
			System.out.println("Owner connected to server");
			
			outputStream2.writeUTF(requestedVehicle);
			
			System.out.println("Client vehicle request sent");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Constructor to create a VehicleOwner object and calls method to associate a
	 * vehicle with the VehicleOwner.
	 */
	public VehicleOwner(String name, String email, int phoneNumber, String id, String licensePlate, String carMake,
			String carModel, int carYear, int residencyTime) {
		super(name, email, phoneNumber, id);
		vehicles = new ArrayList<Vehicle>();
		this.requestedVehicle = "License Plate: " + licensePlate + ", Car Make: " + carMake + ", Car Model: " +  carModel + ", Car Year: " + carYear + ", Residency Time (Hours): " + residencyTime;
		addVehicle(licensePlate, carMake, carModel, carYear, residencyTime);
	}
	
	public void requestVehicle(String licensePlate, String carMake, String carModel, String carYear, String residencyTime) {
		String requestedVehicle = "License Plate: " + licensePlate + ", Car Make: " + carMake + ", Car Model: " +  carModel + ", Car Year: " + carYear + ", Residency Time (Hours): " + residencyTime;
		System.out.println(requestedVehicle);
		this.requestedVehicle = requestedVehicle;
	}

	/*
	 * This method is used to add a new vehicle to the list of vehicles associated
	 * with a particular vehicle owner.
	 * 
	 * @parameters: License Plate, Car Make, Car Mode, Car Year, Residency Time
	 */
	void addVehicle(String licensePlate, String carMake, String carModel, int carYear, int residencyTime)

	{
		vehicles.add(new Vehicle(carMake, carModel, carYear, licensePlate, residencyTime));
	}

	/*
	 * This method uses the license plate to search for a vehicle and delete it from
	 * the list of vehicles associated with a particular vehicle owner.
	 * 
	 * @parameters: Vehicle License Plate
	 * 
	 * @returns: Boolean with the status if vehicle was deleted so confirmation
	 * message can be provided to the user/controller
	 */
	public boolean deleteVehicle(String licensePlate) // private? public?
	{
		boolean vehicleFound = false;
		for (int i = 0; i < vehicles.size(); i++)
			if (vehicles.get(i).getLicensePlate().equals(licensePlate)) {
				vehicles.remove(i);
				vehicleFound = true;
			}
		return vehicleFound;
	}

	/*
	 * The method uses the license plate of the vehicle to identify and change the
	 * idle status of the vehicle to the opposite of its previous state.
	 */
	public void setAvailability(String licensPlate) {
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getLicensePlate().equals(licensPlate)) {
				if (vehicles.get(i).isIdle() == true) {
					vehicles.get(i).setAvailability(false);
				} else {
					vehicles.get(i).setAvailability(true);
				}
			}
		}
	}
	
	public ArrayList<Vehicle> getVehicleList() {
		return vehicles;
	}

}