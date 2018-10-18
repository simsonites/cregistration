package com.softpager.cregistration.controllers;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softpager.cregistration.entities.Student;
import com.softpager.cregistration.services.StudentService;
import com.softpager.cregistration.utils.ResourceMappings;
import com.softpager.cregistration.utils.ViewNames;

@Controller
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping(ResourceMappings.LIST)
	public String getStudents(Model model) {
		List<Student> allStudents = studentService.getStudents();
		System.out.println(allStudents);
		model.addAttribute("student", allStudents);
		return ViewNames.ALL_STUDNETS;
	}

	@GetMapping(ResourceMappings.DETAILS)
	public String getStudent(@RequestParam("studentId") int theId, Model model) {
		Student theStudent = studentService.getStudent(theId);
		model.addAttribute("student", theStudent);
		return ViewNames.STUDENT;
	}

	@GetMapping(ResourceMappings.FORM)
	public String studentForm(Model model) {
		Student theStudent = new Student();
		model.addAttribute("student", theStudent);
		return ViewNames.STUDENT_FORM;
	}

	@PostMapping(ResourceMappings.CREATE)
	public String addStudent(@ModelAttribute("student") Student newStudent) {
		studentService.create(newStudent);
		return "redirect:" + ViewNames.ALL_STUDNETS;
	}
	
	// updating the student
		@GetMapping(ResourceMappings.UPDATE)
		public String updateStudent(@RequestParam("studentId") int theId, Model model) {
			Student theStudent = studentService.getStudent(theId);
			model.addAttribute("student", theStudent);
			return  ViewNames.STUDENT_FORM;
		}

		// deleting the student
		@GetMapping(ResourceMappings.DELETE)
		public String delete(@RequestParam("studentId") int theId) {
			studentService.delete(theId);
			return "redirect:"+ ViewNames.ALL_STUDNETS;
		}
				
		// Searching for student
		@PostMapping(ResourceMappings.SEARCH)
		public String searchStudent(@RequestParam("searchString") String studentName, Model model) {
			List<Student> theStudent = studentService.searchStudent(studentName);
			model.addAttribute("students", theStudent);
			return ViewNames.ALL_STUDNETS;
		}

}





























