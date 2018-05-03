package com.ustglobal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ustglobal.Courses;
import com.ustglobal.Instructor;
import com.ustglobal.SchoolDAO;
import com.ustglobal.Students;

@Controller
@SessionAttributes("sid")
public class StudentController {

	@Autowired
	SchoolDAO schoolDAO;
	Students student;

	@RequestMapping(value = "/addCourse", method = RequestMethod.GET)
	public ModelAndView addCourse(String cno) {
		schoolDAO.addCourse(Integer.parseInt(cno), student.getSid());
		ModelAndView mav = new ModelAndView("addCourse");
		mav.addObject("addCourse", schoolDAO.getCourse(Integer.parseInt(cno)));
		return mav;
		}


	@RequestMapping(value = "/dropCourse", method = RequestMethod.GET)
	public ModelAndView dropCourse(String cno) {
		schoolDAO.dropCourse(Integer.parseInt(cno), student.getSid()); 
		ModelAndView mav = new ModelAndView("dropCourse");
		mav.addObject("dropCourse", schoolDAO.getCourse(Integer.parseInt(cno)));
		return mav;
	}

//	@RequestMapping(value = "/requestTranscript", method = RequestMethod.GET)
//	public String requestTranscript(Courses c) {
//		if (c != null) {
//			SchoolDAO.requestTranscript(c);
//		}
//		return "requestTranscript";
//	}
//
	@RequestMapping(value="/payFee", method=RequestMethod.GET)
	public ModelAndView payFee() {
		schoolDAO.payFee(this.student.getSid());
		ModelAndView mav = new ModelAndView("payFee");
		mav.addObject("payFee", schoolDAO.payFee(student.getSid()));
		return mav;
	}

	@RequestMapping(value="/quit", method=RequestMethod.GET)
	public String quit() {
		return "quit";
	}
	
	@RequestMapping(value="/studentMenu", method=RequestMethod.POST)
		public ModelAndView studentMenu(@RequestParam String sid) {
		this.student = schoolDAO.retrieveStudent(Integer.parseInt(sid));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("studentMenu");
		mav.addObject("student", this.student);
		return mav;
	}
}
