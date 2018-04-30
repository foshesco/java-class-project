package com.ustglobal;

public class Instructor {

	String firstname;
	String lastname;
	String deptid;
	int office;
	String phonenumber;
	String email;
	
	public Instructor(String firstname, String lastname, String deptid, int office, String phonenumber, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.deptid = deptid;
		this.office = office;
		this.phonenumber = phonenumber;
		this.email = email;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public int getOffice() {
		return office;
	}
	public void setOffice(int office) {
		this.office = office;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
}
