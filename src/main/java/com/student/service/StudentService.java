package com.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	public Integer createStudent(Student student)
	{
		 return studentRepo.createStudent(student);
    }
	
	
	public Student getStudent(Integer id)
	{
		 return studentRepo.getStudent(id);
	}

}
