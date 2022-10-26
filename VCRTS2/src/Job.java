import java.util.*;

public class Job {

	private int jobDuration;
	private Date jobDeadline;
	private int jobPriorityLevel;
	private String jobID;
	private boolean jobInProgress;
	
	
	public Job()
	{
		
	}
	
	//private on public methods? not sure, will fix in future;
	public int getJobDuration() {
		return jobDuration;
	}
	public void setJobDuration(int jobDuration) {
		this.jobDuration = jobDuration;
	}
	public Date getJobDeadline() {
		return jobDeadline;
	}
	public void setJobDeadline(Date jobDeadline) {
		this.jobDeadline = jobDeadline;
	}
	public int getJobPriorityLevel() {
		return jobPriorityLevel;
	}
	public void setJobPriorityLevel(int jobPriorityLevel) {
		this.jobPriorityLevel = jobPriorityLevel;
	}
	public String getJobID() {
		return jobID;
	}
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}
	public boolean isJobInProgress() {
		return jobInProgress;
	}
	public void setJobInProgress(boolean jobInProgress) {
		this.jobInProgress = jobInProgress;
	}
	public void generateCheckpointImage(){	//Incomplete
		
	}
	
	
	
	
	
}
