package ObjectClasses;
import java.util.*;

public class Controller {
	
	Queue<VehicleRenter> vehicleRenters;	
	Queue<VehicleOwner> vehicleOwners;
	ArrayList<Integer> jobIDList;
	ArrayList<Integer> completionTimes;
	public Controller()
	{
		jobIDList = new ArrayList<Integer> ();
		completionTimes = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> calculateCompletionTime() { //shouldn't this return something?
		int completionTime = 0;
		for(VehicleRenter renter: vehicleRenters) {
			ArrayList<Job> jobList = new ArrayList<>(renter.getJobList());
			for(int i=0; i<jobList.size(); i++ ) {
				completionTime += jobList.get(i).getJobDuration();
				jobList.get(i).setCompletionTime(completionTime);
				completionTimes.add(completionTime);
			}
		}
		return completionTimes;
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
