package ObjectClasses;
public class Account {

	//CLASS MIGHT NOT BE Needed? Can't we just Use AccountCreation as the Superclass?
	
	private String name;
	private String email;
	private int phoneNum;
	private String id;
	//private boolean adminStatus;
	
	public Account(String name, String email, int phoneNum, String id) {
		this.name = name;
		this.email = email;
		this.phoneNum = phoneNum;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/*
	public boolean isAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(boolean adminStatus) {
		this.adminStatus = adminStatus;
	}
	*/
}