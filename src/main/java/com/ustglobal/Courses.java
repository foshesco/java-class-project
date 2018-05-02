package com.ustglobal;

public class Courses {

	int coursenumber;
	String classtitle;
	int hours;
	String deptid;
	
	public Courses() {}
	
	public Courses(int coursenumber, String classtitle, int hours, String deptid) {
		super();
		this.coursenumber = coursenumber;
		this.classtitle = classtitle;
		this.hours = hours;
		this.deptid = deptid;
	}
	
	public int getCoursenumber() {
		return coursenumber;
	}
	public void setCoursenumber(int coursenumber) {
		this.coursenumber = coursenumber;
	}
	public String getClasstitle() {
		return classtitle;
	}
	public void setClasstitle(String classtitle) {
		this.classtitle = classtitle;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
}
