package vn.wed.server.service;

import vn.wed.server.entity.Student;

public interface StudentRepository {
	public boolean create(Student student);
	public Student getByName(String name);
}