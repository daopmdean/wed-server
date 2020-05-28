package vn.wed.server.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import vn.wed.server.entity.Student;
import vn.wed.server.service.StudentRepository;

@Component
public class StudentRepositoryImpl implements StudentRepository {
	private List<Student> students;
	
	public StudentRepositoryImpl() {
		students = new ArrayList<Student>();
		students.add(new Student("Alex", "alex@gmail.com"));
		students.add(new Student("Tom", "tom@gmail.com"));
		students.add(new Student("Helen", "helen@gmail.com"));
	}

	@Override
	public boolean create(Student student) {
		return students.add(student);
	}

	@Override
	public Student getByName(String name) {
		for (Student student : students) {
			if (student.getName().equals(name)) {
				return student;
			}
		}
		return null;
	}

	@Override
	public List<Student> getStudents() {
		return students;
	}
}
