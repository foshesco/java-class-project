package com.ustglobal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

public class SchoolDAO {
	private JdbcTemplate jdbcTemplate;
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	
	@Value("${jdbc.driver}")
	String driver;
	@Value("${jdbc.url}")
	String url;
	@Value("${jdbc.username}")
	String username;				
	@Value("${jdbc.password}")
	String password;

	public Connection connectMe() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		this.con = DriverManager.getConnection(url, username, password);
		return con;
	}
	
	public boolean createCourse(Courses c) {
		String query = "insert into courses values(" + "'" + c.getCoursenumber() + "','" + c.getClasstitle() + "','"
				+ c.getHours() + "','" + c.getDeptid() + "')";
		
		System.out.println(c.getCoursenumber());
		System.out.println(c.getClasstitle()); 
		System.out.println(c.getHours()); 
		System.out.println(c.getDeptid());
		return true;
	}
	
	public boolean addInstructor(Instructor i) {
		String query = "insert into instructors values(" + "'" + i.getFirstname() + "','" + i.getLastname() + "','" + i.getDeptid() +
				"','" + i.getOffice() + "','" + i.getPhonenumber() + "','" + i.getEmail() + "')";
		
		System.out.println(i.getFirstname());
		System.out.println(i.getLastname());
		System.out.println(i.getDeptid());
		System.out.println(i.getOffice());
		System.out.println(i.getPhonenumber());
		System.out.println(i.getEmail());
		return true;
	}

//	public String addCourse() {
//
//	}
//
//	public String dropCourse() {
//
//	}
//
//	public String requestTranscript() {
//
//	}
//
//	public String payFee() {
//
//	}
}
