package vn.wed.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.wed.server.entity.Student;

@Component
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public boolean create(Student student) {
		return this.repo.create(student);
	}
	
	public Student getByName(String name) {
		return this.repo.getByName(name);
	}
	
	public List<Student> getStudents() {
		return this.repo.getStudents();
	}
}

