package ObjectClasses;
import java.util.*;

public class Controller {
	
	Queue<VehicleRenter> vehicleRenters;	
	Queue<VehicleOwner> vehicleOwners;
	ArrayList<Integer> jobIDList;
	
	public Controller()
	{
		jobIDList = new ArrayList <Integer> ();
	}
	
	public int calculateCompletionTime() { //incomplete
		return 0;
	}
	
	public void approveJob() {
		
	}
	
	public int generateJobID() {
		Random rand = new Random();
		int jobID = rand.nextInt(10000);
		while (jobIDList.contains(jobID)) {
			jobID = rand.nextInt(10000);
		}
		return jobID;
	}
	
	
	
}
