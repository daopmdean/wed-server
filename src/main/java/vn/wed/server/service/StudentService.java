package vn.wed.server.service;

import vn.wed.server.entity.Student;

public class StudentService {
	private StudentRepository repo;
	
	public StudentService(StudentRepository repo) {
		this.repo = repo;
	}

	public boolean create(Student student) {
		return this.repo.create(student);
	}
	
	public Student getByName(String name) {
		return this.repo.getByName(name);
	}
}

