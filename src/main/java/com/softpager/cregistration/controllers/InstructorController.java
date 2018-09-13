package com.softpager.cregistration.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softpager.cregistration.entities.Instructor;
import com.softpager.cregistration.services.InstructorService;

@Controller
@RequestMapping("/instructors")
public class InstructorController {
	
	@Autowired
	private InstructorService  instructorService;
	
	@GetMapping("/list")
	public String getInstructors(Model model) {
		List<Instructor> allInstructors = instructorService.getInstructors();
		System.out.println(allInstructors);
		model.addAttribute("instructor", allInstructors);
		return "instructors";
	}

}




















