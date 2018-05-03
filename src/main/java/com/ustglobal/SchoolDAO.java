package com.ustglobal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;


@Configuration
@ComponentScan("com.ustglobal")
@PropertySource("classpath:db.properties")
public class SchoolDAO {
	private JdbcTemplate jdbcTemplate;
	PreparedStatement ps;
	SqlRowSet rs;
	
	@Value("${jdbc.driver}")
	String driver;
	@Value("${jdbc.url}")
	String url;
	@Value("${jdbc.username}")
	String username;				
	@Value("${jdbc.password}")
	String password;

	@Bean
	public DataSource mysqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int createCourse(Courses c) {
		return jdbcTemplate.update("INSERT INTO courses VALUES(?, ?, ?, ?)", c.getCoursenumber(), c.getClasstitle(), c.getHours(), c.getDeptid());
	}
	
//	public List<Courses> getCourses() throws SQLException {
//		ArrayList<Courses> courseList = new ArrayList<>();
//		rs = jdbcTemplate.queryForRowSet("SELECT * FROM courses");
//			while (rs.next()) {
//				Courses courses = new Courses();
//				courses.setCoursenumber(rs.getInt(1));
//				courses.setClasstitle(rs.getString(2));
//				courses.setHours(rs.getInt(3));
//				courses.setDeptid(rs.getString(4));
//				System.out.println(rs.getInt(1));
//				courseList.add(courses);
//			}
//		return courseList;
//	}
	
	public int addInstructor(Instructor i) {
		return jdbcTemplate.update("INSERT INTO instructors VALUES(?, ?, ?, ?, ?, ?)", i.getFirstname(), i.getLastname(), i.getDeptid(), i.getOffice(), i.getPhonenumber(), i.getEmail());
	}
	
	public Courses dropCourse(int cno, int sid) {
		// Update hours after dropping course
		Students student = retrieveStudentClasses();
		String dropCourseStr = null;
		if (student.getClassname().charAt(0) != ',') {
			dropCourseStr = student.getClassname().replaceAll(cno + ", ", "");
		} else {
			dropCourseStr = student.getClassname().replace(", " + cno, "");
		}
		System.out.println(dropCourseStr);
		jdbcTemplate.update("UPDATE students SET class=? WHERE sid=?", dropCourseStr, sid);
		return getCourse(cno);
	}

	public void requestTranscript(int sid) {
		ArrayList<Courses> transcriptList = new ArrayList<Courses>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet("SELECT c.cno, s.sid FROM students s "
				+ "INNER JOIN sections sec ON e.lineno = sec.lineno AND e.term = sec.term"
				+ "INNER JOIN courses c ON sec.cno = c.cno"
				+ "INNER JOIN enrollement e  ON s.sid = e.sid");
//				+ "INNER JOIN departments d ON s.dept_id = d.dept_id "
//				+ "INNER JOIN courses c ON d.dept_id = c.dept_id");
		
//		return transcriptList;
	}

	public double payFee(int sid) {
		int sum = 0;		
		String[] courseList = retrieveStudentClasses().getClassname().split(", ");
		for(String course : courseList) {
			sum += getCourse(Integer.parseInt(course)).getHours();
		}
		double price = sum * 300;
		return price;
	}
	
	public Students retrieveStudentClasses() {
		SqlRowSet rs = jdbcTemplate.queryForRowSet("SELECT * FROM students WHERE sid=?", 321);
		String courses = null;
		Students students = new Students();
		while (rs.next()) {
			students.setSid(rs.getInt(1));
			students.setFirstname(rs.getString(2));
			students.setLastname(rs.getString(3));
			students.setClassname(rs.getString(4));
			students.setPhone(rs.getString(5));
			students.setStreet(rs.getString(6));
			students.setCity(rs.getString(7));
			students.setState(rs.getString(8));
			students.setZip(rs.getInt(9));
			students.setDegree(rs.getString(10));
			students.setDeptid(rs.getString(11));
			students.setHours(rs.getInt(12));
			students.setGpa(rs.getDouble(13));
		}
		
		return students;
	}
	
	public Courses getCourse(int cno) {
		SqlRowSet rs = jdbcTemplate.queryForRowSet("SELECT * FROM courses WHERE cno=?", cno);
		Courses course = null;
		while (rs.next()) {
			course = new Courses();
			course.setCoursenumber(rs.getInt(1));
			course.setClasstitle(rs.getString(2));
			course.setHours(rs.getInt(3));
			course.setDeptid(rs.getString(4));
		}
		return course;
	}

	public Courses addCourse(int cno, int sid) {
		Students student = retrieveStudentClasses();
		String addCourseStr = student.getClassname() +", " + cno;
		jdbcTemplate.update("UPDATE students SET class=? WHERE sid=?", addCourseStr, sid);
		return getCourse(cno);
	}
}
