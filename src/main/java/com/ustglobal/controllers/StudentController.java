package com.ustglobal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ustglobal.Courses;
import com.ustglobal.Instructor;
import com.ustglobal.SchoolDAO;

@Controller
public class StudentController {

	@Autowired
	SchoolDAO SchoolDAO;
	
	@RequestMapping(value="/createCourse", method=RequestMethod.GET)
	public String createCourse(Courses c) {
		if(c != null) {
			SchoolDAO.createCourse(c);
		}
		return "success";
	}
	
	@RequestMapping(value="/addInstructor", method=RequestMethod.GET)
	public String addInstructor(Instructor i) {
		if(i != null) {
			SchoolDAO.addInstructor(i);
		}
		return "success23";
	}
}
