package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.Services.StudentService;
import com.org.entities.Student;

@RestController
public class MyController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getAllStudent(){
		return this.studentService.getAllStudent();
	}
	
	@GetMapping("/students/{studentid}")
	public Student getStudent(@PathVariable String studentid) {
		return this.studentService.getStudent(Long.parseLong(studentid));
	}
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		return this.studentService.addStudent(student);
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		return this.studentService.updateStudent(student);
	}
	
	@DeleteMapping("/students/{studentid}")
	public ResponseEntity<Object> deleteStudent(@PathVariable long studentid){
		try {
			boolean isStudentDeleted = studentService.deleteStudent(studentid);
			if(isStudentDeleted) {
				return new ResponseEntity<>("Student is deleted Successfully..",HttpStatus.OK);
			}
			return new ResponseEntity<>("Student is Not found",HttpStatus.NOT_FOUND);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
