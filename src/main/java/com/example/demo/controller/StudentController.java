package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentServiceImpl;

@Controller
public class StudentController {
	//Aissa chbaba
	@Autowired
	private StudentServiceImpl repo;
	public StudentController(StudentServiceImpl repo) {
		super();
		this.repo = repo;
	}

	@GetMapping("/responsible/students/new")
	public String showNewStudentForm(Model model) {
		//List<Departement> listDepartements =departementRepo.findAll();
		
		model.addAttribute("student", new Student());
		//model.addAttribute("listSts", listDepartements);
		model.addAttribute("added", true);
		
		return "/responsible/create_student";
	}
	@PostMapping("/responsible/students")
	public String saveStudent(@ModelAttribute("students") Student student) {
		repo.saveStudent(student);
		return "redirect:/responsible/students";
	}
	
	@GetMapping("/responsible/students")
	public String listStudents(Model model) {
			model.addAttribute("students", repo.getAllStudents());
			return "/responsible/students";
		}

	@GetMapping("/responsible/students/{id}")
	public String showEditStudentForm(@PathVariable("id") long id, Model model) {
		Student student =repo.getStudentById(id);
		model.addAttribute("student ", student );
		model.addAttribute("edit", true);
		
		//List<Etablissement> listDepartements =etablissementRepo.findAll();
		
		//model.addAttribute("listDepartements", listDepartements);
		return "/responsible/edit_student";
	}
	
	@GetMapping("/responsible/students/edit/{id}")
	public String editStudentForm(@PathVariable Integer id, Model model) {
		model.addAttribute("student", repo.getStudentById(id));
		return "/responsible/edit_student";
	}
	
	@PostMapping("/responsible/students/{id}")
	public String updateStudent(@PathVariable long id,
			@ModelAttribute("students") Student student, Model model) {
		
		// get student from database by id
		Student existingStudent = repo.getStudentById(id);
		existingStudent.setId(student.getId());
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		// save updated student object
		if(existingStudent!=null)
				repo.updateStudent(existingStudent);
		return "redirect:/responsible/students";
		}
	
	@GetMapping("/responsible/students/delete/{id}")
	public String deleteStudent(@PathVariable("id") long id, Model model) {
		repo.deleteStudentById(id);
		return "redirect:/responsible/students";
	}
	
}
