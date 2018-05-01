package com.ustglobal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ustglobal.Courses;
import com.ustglobal.Instructor;
import com.ustglobal.SchoolDAO;

@Controller
public class AdminController {

	@Autowired
	SchoolDAO SchoolDAO;

	@RequestMapping(value = "/createCourse", method = RequestMethod.GET)
	public String createCourse(Courses c) {
		if (c != null) {
			SchoolDAO.createCourse(c);
		}
		return "success";
	}

	@RequestMapping(value = "/dropCourse", method = RequestMethod.GET)
	public String dropCourse(Courses c) {
		if (c != null) {
			SchoolDAO.dropCourse(c);
		}
		return "dropCourse";
	}

	@RequestMapping(value = "/prepareSchedule", method = RequestMethod.GET)
	public String prepareSchedule(Courses c) {
		if (c != null) {
			SchoolDAO.dropCourse(c);
		}
		return "dropCourse";
	}

	@RequestMapping(value = "/addInstructor", method = RequestMethod.GET)
	public String addInstructor(Instructor i) {
		if (i != null) {
			SchoolDAO.addInstructor(i);
		}
		return "success23";
	}

	@RequestMapping(value = "/dropInstructor", method = RequestMethod.GET)
	public String addInstructor(Instructor i) {
		if (i != null) {
			SchoolDAO.addInstructor(i);
		}
		return "dropInstructor";
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public String addStudent(Students s) {
		if (s != null) {
			SchoolDAO.addStudent(s);
		}
		return "addStudent";
	}

	@RequestMapping(value = "/dropStudent", method = RequestMethod.GET)
	public String dropStudent(Students s) {
		if (s != null) {
			SchoolDAO.dropStudent(s);
		}
		return "dropStudent";
	}

	@RequestMapping(value="/quit", method=RequestMethod.GET)
	public String quit() {
		if(? != null) {
			SchoolDAO.payFee(?);
		}
		return "quit";
	}
}
