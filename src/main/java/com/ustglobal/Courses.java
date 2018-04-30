package com.ustglobal;

public class Courses {

	int classnumber;
	String classtitle;
	int hours;
	int deptid;
	
	public Courses(int classnumber, String classtitle, int hours, int deptid) {
		super();
		this.classnumber = classnumber;
		this.classtitle = classtitle;
		this.hours = hours;
		this.deptid = deptid;
	}
	
	public int getClassnumber() {
		return classnumber;
	}
	public void setClassnumber(int classnumber) {
		this.classnumber = classnumber;
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
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
}
