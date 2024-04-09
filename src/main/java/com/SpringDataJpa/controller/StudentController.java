package com.SpringDataJpa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringDataJpa.entity.Student;
import com.SpringDataJpa.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	@GetMapping("/students")
	public List<Student> getAllStudent()
	{
		
		return studentService.getAllStudents();
	}
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable("id") int id)
	{
		return studentService.getStudentById(id);
	}
	@PostMapping
	public Student createStudent(@RequestBody Student student)
	{
		return studentService.createStudent(student);
	}
	@PutMapping("/student/{id}")
	public Student updateStudent(@PathVariable("id") int id,@RequestBody Student student)
	{
		return studentService.updateStudent(id, student);
		
	}
	 @DeleteMapping("/student/{id}")
	    public void deleteStudent(@PathVariable("id") int id) {
	        studentService.deleteStudent(id);
	    }
	 @GetMapping("/students/{city}")
	    public List<Student> getStudentsByCity(@PathVariable String city) {
	        return studentService.getStudentsByCity(city);
	    }
	 
}
