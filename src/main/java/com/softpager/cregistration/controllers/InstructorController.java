package com.softpager.cregistration.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softpager.cregistration.entities.Instructor;
import com.softpager.cregistration.services.InstructorService;
import com.softpager.cregistration.utils.ViewNames;

@Controller
@RequestMapping("/instructors")
public class InstructorController {
	
	@Autowired
	private InstructorService  instructorService;
	
	@GetMapping("/list")
	public String getInstructors(Model model) {
		List<Instructor> allInstructors = instructorService.getInstructors();
		System.out.println(allInstructors);
		model.addAttribute("instructors", allInstructors);
		return  ViewNames.ALL_INSTRUCOTR;
	}
	
	@GetMapping("/details")
	public String getInstructor(@RequestParam("studentId") int theId, Model model) {
		Instructor theInstructor = instructorService.getInstructor(theId);
		model.addAttribute("instructor", theInstructor);
		return "instructor-detail";
	}


}




















