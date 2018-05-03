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
		Students student = retrieveStudent(sid);
		String dropCourseStr = null;
		if (Character.isDigit(student.getClassname().charAt(0))) {
			dropCourseStr = student.getClassname().replaceAll(cno + ", ", "");
		} else {
			dropCourseStr = student.getClassname().replace(", " + cno, "");
		}
		System.out.println(dropCourseStr);
		jdbcTemplate.update("UPDATE students SET class=? WHERE sid=?", dropCourseStr, sid);
		updateHours(sid, getCourse(cno).getHours(), "subtract");
		return getCourse(cno);
	}

	public void requestTranscript(int sid) {
		ArrayList<Courses> transcriptList = new ArrayList<Courses>();

	}

	public double payFee(int sid) {
		int sum = 0;		
		String[] courseList = retrieveStudent(sid).getClassname().split(", ");
		for(String course : courseList) {
			sum += getCourse(Integer.parseInt(course)).getHours();
		}
		double price = sum * 300;
		return price;
	}
	
	public Students retrieveStudent(int sid) {
		SqlRowSet rs = jdbcTemplate.queryForRowSet("SELECT * FROM students WHERE sid=?", sid);
		String courses = null;
		Students students = new Students();
		while (rs.next()) {
			students.setSid(rs.getInt("sid"));
			students.setFirstname(rs.getString("first_name"));
			students.setLastname(rs.getString("last_name"));
			students.setClassname(rs.getString("class"));
			students.setPhone(rs.getString("phone"));
			students.setStreet(rs.getString("street"));
			students.setCity(rs.getString("city"));
			students.setState(rs.getString("state"));
			students.setZip(rs.getInt("zip"));
			students.setDegree(rs.getString("degree"));
			students.setDeptid(rs.getString("dept_id"));
			students.setHours(rs.getInt("hours"));
			students.setGpa(rs.getDouble("gpa"));
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
	
	public void updateHours(int sid, int hours, String operation) {
		switch (operation) {
        case "add" : jdbcTemplate.update("UPDATE students SET hours=? WHERE sid=?", retrieveStudent(sid).getHours() + hours, sid);
                 break;
        case "subtract" : jdbcTemplate.update("UPDATE students SET hours=? WHERE sid=?", retrieveStudent(sid).getHours() - hours, sid);
                 break;
        default:
        	break;
		}
	}

	public Courses addCourse(int cno, int sid) {
		Students student = retrieveStudent(sid);
		String addCourseStr = student.getClassname() +", " + cno;
		jdbcTemplate.update("UPDATE students SET class=? WHERE sid=?", addCourseStr, sid);
		updateHours(sid, getCourse(cno).getHours(), "add");
		return getCourse(cno);
	}
}
