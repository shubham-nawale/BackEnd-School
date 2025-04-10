package com.nawale.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nawale.models.Student;
import com.nawale.repo.StudentRepository;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:5173") // allow frontend
public class StudentController {
	public final StudentRepository studentRepository;
	
	public StudentController(StudentRepository repository)
	{
		this.studentRepository = repository;
	}
	
	@GetMapping
	public List<Student> getAllStudent()
	{
		return studentRepository.findAll();
	}

	@PostMapping
	public Student createStudent(@RequestBody Student student)
	{
		return studentRepository.save(student);
	}
}
