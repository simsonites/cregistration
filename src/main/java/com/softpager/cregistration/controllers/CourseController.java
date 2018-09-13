package com.softpager.cregistration.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softpager.cregistration.entities.Course;
import com.softpager.cregistration.services.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/list")
	public String getCourses(Model model) {
		List<Course> allCourses = courseService.getCourses();
		System.out.println(allCourses);
		model.addAttribute("course", allCourses);
		return "courses";
	}

}





















