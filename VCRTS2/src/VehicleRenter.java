
public class VehicleRenter extends AccountCreation{

	public VehicleRenter(String name, String email, String phoneNum, String ID, String jobDuration, String jobDeadline)
	{
		this.name = name;
		this.email = email;
		this.phoneNum = phoneNum;
		this.ID = ID;
		this.jobDuration = jobDuration;
		this.jobDeadline = jobDeadline;
	}
	
	private void requestJob() {
		
		
	}
	
	private void deleteJob() {
		
		
	}
	
	private void checkInfo() {
		//Temporary. Where should we show this info? On GUI? Not sure how to do this.
		System.out.println(name);
		System.out.println(email);
		System.out.println(phoneNum);
		System.out.println(ID);
		System.out.println(jobDuration);
		System.out.println(jobDeadline);
	}

}
