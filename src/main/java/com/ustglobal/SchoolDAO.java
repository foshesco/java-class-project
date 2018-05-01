package com.ustglobal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.ustglobal")
@PropertySource("classpath:db.properties")
public class SchoolDAO {
	private JdbcTemplate jdbcTemplate;
	PreparedStatement ps;
	ResultSet rs;
	
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
	
	public int addInstructor(Instructor i) {
		return jdbcTemplate.update("INSERT INTO instructors VALUES(?, ?, ?, ?, ?, ?)", i.getFirstname(), i.getLastname(), i.getDeptid(), i.getOffice(), i.getPhonenumber(), i.getEmail());
	}

	public String addCourse() {
		return null;

	}

	public String dropCourse() {
		return null;
	}

	public String requestTranscript() {
		return null;
	}

	public String payFee() {
		return null;
	}
}
