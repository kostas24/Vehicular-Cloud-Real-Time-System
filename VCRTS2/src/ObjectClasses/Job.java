package ObjectClasses;

import java.sql.Date;
import java.util.*;

public class Job {

	private int jobDuration;
	private Date jobDeadline;
	private int jobPriorityLevel;
	private int jobID;
	private boolean jobInProgress;

	public Job(int jobDuration, int jobID) {
		this.jobDuration = jobDuration;
		this.jobID = jobID;
		jobInProgress = false;
	}

	public Job(int jobDuration, Date jobDeadline, int jobPriorityLevel, int jobID) {
		this.jobDuration = jobDuration;
		this.jobDeadline = jobDeadline;
		this.jobPriorityLevel = jobPriorityLevel;
		this.jobID = jobID;
		jobInProgress = false;
	}

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

	public int getJobID() {
		return jobID;
	}

	public void setJobID(int jobID) {
		this.jobID = jobID;
	}

	public boolean isJobInProgress() {
		return jobInProgress;
	}

	public void setJobInProgress(boolean jobInProgress) {
		this.jobInProgress = jobInProgress;
	}

	public void generateCheckpointImage() { // Incomplete

	}

}
