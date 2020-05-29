package vn.wed.server.service;

import java.util.List;

import vn.wed.server.entity.Student;

public interface StudentRepository {
	public boolean create(Student student);
	public Student getByName(String name);
	public List<Student> getStudents();
}