package model;

public class User {
	private String studentNumber;
	private String pass;
	private String firstName;
	private String lastName;
	private String tel;
	private String mailAddress;
	
	public User(String studentNumber, String pass,
				String firstName, String lastName, String tel, String mailAddress) {
		this.studentNumber = studentNumber;
		this.pass = pass;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tel = tel;
		this.mailAddress = mailAddress;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
}
