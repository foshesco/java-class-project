package com.ustglobal;

public class Students {

	int sid;
	String lastname;
	String firstname;
	String classname;
	String phone;
	String street;
	String city;
	String state;
	int zip;
	String degree;
	String deptid;
	int hours;
	double gpa;
	
	public Students() {}
	
	public Students(int sid, String lastname, String firstname, String classname, String phone, String street, String city,
			String state, int zip, String degree, String deptid, int hours, double gpa) {
		super();
		this.sid = sid;
		this.lastname = lastname;
		this.firstname = firstname;
		this.classname = classname;
		this.phone = phone;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.degree = degree;
		this.deptid = deptid;
		this.hours = hours;
		this.gpa = gpa;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}
