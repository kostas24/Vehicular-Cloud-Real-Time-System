package ObjectClasses;
public class Account {

	private String name;
	private String email;
	private int phoneNum;
	private String id;
	
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

}