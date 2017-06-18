package trng.imcs.app.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Employee {
	
	private int number;
	private String fname,lname;
	private String gender, dob,doj;
	//private Date dob,doj;
	
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
//	public Date getDob() {
//		return dob;
//	}
//	public void setDob(Date dob) {
//		this.dob = dob;
//	}
//	public Date getDoj() {
//		return doj;
//	}
//	public void setDoj(Date doj) {
//		this.doj = doj;
//	}
	
	// SETTING AND GETTING VALUES FOR THE GENDER ENUM
	public String getGender() {
	    return gender;
	}

	public void setGender(String gender) {
	    this.gender = gender;
	}
	public Employee(int number, String fname, String lname, String gender, String dob, String doj) {
		super();
		this.number = number;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.dob = dob;
		this.doj = doj;
	}
	public Employee() {
		super();
	}
	
	
}
