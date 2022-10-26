public class Vehicle {
	
	private String carMake;
	private String carModel;
	private int carYear;
	private String licensePlate;
	private int residencyTime;
	private boolean isIdle;
	
	public Vehicle(String carMake, String carModel, int carYear, String licensePlate, int residencyTime) {
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = carYear;
		this.licensePlate = licensePlate;
		this.residencyTime = residencyTime;
	}

	public String getCarMake() {
		return carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public int getCarYear() {
		return carYear;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public int getResidencyTime() {
		return residencyTime;
	}

	public boolean isIdle() {
		return isIdle;
	}
	

}
