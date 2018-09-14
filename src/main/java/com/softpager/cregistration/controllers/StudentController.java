package com.softpager.cregistration.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softpager.cregistration.entities.Student;
import com.softpager.cregistration.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/list")
	public String getStudents(Model model){		
		List<Student> allStudents = studentService.getStudents();	
		System.out.println(allStudents);
		model.addAttribute("student", allStudents);
		return  "students";			
	}
		
@GetMapping("/details")
public String getStudent(@ModelAttribute("studentId") int theId, Model model) {
	Student theStudent = studentService.getStudent(theId);
	model.addAttribute("student", theStudent);
	return "student-detail";
}

}




















