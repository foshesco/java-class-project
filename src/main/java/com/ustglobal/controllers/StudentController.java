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

	@RequestMapping(value = "/addCourse", method = RequestMethod.GET)
	public String addCourse(Courses c) {
		if (c != null) {
			SchoolDAO.addCourse(c);
		}
		return "addCourse";
	}

	@RequestMapping(value = "/dropCourse", method = RequestMethod.GET)
	public String dropCourse(Courses c) {
		if (c != null) {
			SchoolDAO.dropCourse(c);
		}
		return "dropCourse";
	}

	@RequestMapping(value = "/requestTranscript", method = RequestMethod.GET)
	public String requestTranscript(Courses c) {
		if (c != null) {
			SchoolDAO.requestTranscript(c);
		}
		return "requestTranscript";
	}

	@RequestMapping(value="/payFee", method=RequestMethod.GET)
	public String payFee() {
		if(? != null) {
			SchoolDAO.payFee(?);
		}
		return "payFee";
	}

	@RequestMapping(value="/quit", method=RequestMethod.GET)
	public String quit() {
		if(? != null) {
			SchoolDAO.payFee(?);
		}
		return "quit";
	}
}
