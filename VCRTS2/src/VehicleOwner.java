
public class VehicleOwner extends AccountCreation{


	public VehicleOwner(String name, String email, String phoneNum, String ID, String licensePlate, String carMake, String carModel, String carYear, String residencyTime)
	{
		this.name = name;
		this.email = email;
		this.phoneNum = phoneNum;
		this.ID = ID;
		this.licensePlate = licensePlate;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = carYear;
		this.residencyTime = residencyTime;
	}	
	
	private void addVehicle() // private? public?
	{
		
	}
	
	private void deleteVehicle() // private? public?
	{
		
	}
	
	private void setAvailability()
	{
		
	}
	
	private void checkInfo() {
		//Temporary. Where should we show this info? On GUI? Not sure how to do this.
				System.out.println(name);
				System.out.println(email);
				System.out.println(phoneNum);
				System.out.println(ID);
				System.out.println(licensePlate);
				System.out.println(carMake);
				System.out.println(carModel);
				System.out.println(carYear);
				System.out.println(residencyTime);
	}
	
	

}
