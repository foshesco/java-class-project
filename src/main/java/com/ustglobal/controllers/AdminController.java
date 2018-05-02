package com.ustglobal.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
		return "createCourse";
	}

	@RequestMapping(value = "/courseDirectory", method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception { 
		ModelAndView modelAndView = new ModelAndView("courseList");
		List<Courses> courseList = SchoolDAO.getCourses();
		modelAndView.addObject("courseList", courseList);
		return modelAndView;
	}
	
//	@RequestMapping(value = "/dropCourse", method = RequestMethod.GET)
//	public String dropCourse(Courses c) {
//		if (c != null) {
//			SchoolDAO.dropCourse(c);
//		}
//		return "course";
//	}
//	
//	@RequestMapping("/courseList")
//	public ModelAndView courseList() throws SQLException {
//		List<Courses> courseList = SchoolDAO.getCourse();
//		return new ModelAndView("courses", "courseList", courseList);
//	}
//	
//	
//
//	@RequestMapping(value = "/prepareSchedule", method = RequestMethod.GET)
//	public String prepareSchedule(Courses c) {
//		if (c != null) {
//			SchoolDAO.dropCourse(c);
//		}
//		return "schedule";
//	}
//
	@RequestMapping(value = "/addInstructor", method = RequestMethod.GET)
	public ModelAndView addInstructor(Instructor i) {
		if (i != null) {
			SchoolDAO.addInstructor(i);
		}
		ModelAndView modelAndView = new ModelAndView("addInstructor");
		modelAndView.addObject("instructor", i);
		return modelAndView;
	}
//
//	@RequestMapping(value = "/dropInstructor", method = RequestMethod.GET)
//	public String addInstructor(Instructor i) {
//		if (i != null) {
//			SchoolDAO.addInstructor(i);
//		}
//		return "dropInstructor";
//	}
//
//	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
//	public String addStudent(Students s) {
//		if (s != null) {
//			SchoolDAO.addStudent(s);
//		}
//		return "addStudent";
//	}
//
//	@RequestMapping(value = "/dropStudent", method = RequestMethod.GET)
//	public String dropStudent(Students s) {
//		if (s != null) {
//			SchoolDAO.dropStudent(s);
//		}
//		return "dropStudent";
//	}
//
//	@RequestMapping(value="/quit", method=RequestMethod.GET)
//	public String quit() {
//		if(? != null) {
//			SchoolDAO.quit(?);
//		}
//		return "quit";
//	}
}
