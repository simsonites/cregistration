package com.softpager.cregistration.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softpager.cregistration.entities.Course;
import com.softpager.cregistration.services.CourseService;
import com.softpager.cregistration.utils.ResourceMappings;
import com.softpager.cregistration.utils.ViewNames;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	private CourseService courseService;
	
	@Autowired
	public CourseController(CourseService courseService) {	
		this.courseService = courseService;
	}

	@GetMapping(ResourceMappings.LIST)
	public String getCourses(Model model) {
		List<Course> allCourses = courseService.getCourses();
		System.out.println(allCourses);
		model.addAttribute("courses", allCourses);
		return  ViewNames.ALL_COURSES;
	}
			
	@GetMapping(ResourceMappings.DETAILS)
	public String getCourse(@RequestParam("courseId") int theId, Model model) {
		Course theCourse = courseService.getCourse(theId);
		model.addAttribute("course", theCourse);
		return ViewNames.COURSE;		
	}
	
	@PostMapping(ResourceMappings.REG_FOR_COURSE)
	public String registerForCourse(@RequestAttribute("courseId") int cId,
			                                                                 @RequestAttribute("studentId") int sId, Model model) {
		courseService.registerForCourse(sId, cId);		
		return ViewNames.STUDENT;
		
	}


}





















