package vn.wed.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.wed.server.entity.Student;
import vn.wed.server.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;

	@GetMapping("/student")
	public Student getStudent(
		@RequestParam(value = "name", defaultValue = "World") String name
	) {
		Student student = this.service.getByName(name);
		return student;
	}
	
	@PostMapping("/student")
	public boolean createStudent(@RequestBody CreateStudentRequestBody body) {
		Student student = new Student(body.getName(), body.getEmail());
		return this.service.create(student);
	}
}

class CreateStudentRequestBody {
	private String name;
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}