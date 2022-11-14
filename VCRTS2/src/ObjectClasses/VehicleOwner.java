package ObjectClasses;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class VehicleOwner extends Account {

	private ArrayList<Vehicle> vehicles;
	static ServerSocket serverSocket;
	static Socket socket;
	static DataInputStream inputStream;
	static DataOutputStream outputStream;
	
public static void main(String[] args) {
		
		String messageIn = "";
		String messageOut = "";
		Scanner keyInput;
		
		try {

			System.out.println("----------*** This is Owner client side ***--------");
			System.out.println("client started!");
			//connect the client socket to server
			Socket socket = new Socket("localhost", 2);
			
			
			//client reads a message from Server
			inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new DataOutputStream(socket.getOutputStream());
			
			while(!messageIn.equals("exit")) {
				messageIn = inputStream.readUTF();
				// client prints the message received from server to console
				System.out.println("message received from server: " + "\"" + messageIn + "\"");
				
				
				// ********************************************************
				// client reads a message from keyboard
				System.out.println("Enter a message you want to send to server side: ");
				keyInput = new Scanner(System.in);
				messageOut = keyInput.nextLine();
				// server sends the message to client
				outputStream.writeUTF(messageOut);
				
			}
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
		addVehicle(licensePlate, carMake, carModel, carYear, residencyTime);
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

}