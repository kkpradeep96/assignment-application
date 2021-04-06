package com.interview.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interview.assignment.exceptions.RecordNotFoundException;
import com.interview.assignment.model.Student;
import com.interview.assignment.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	public Student addStudent(Student student) throws Exception{
		
		Optional<Student> studentToAdd=getStudentById(student.getId());
		if(studentToAdd.isPresent()) {
			throw new Exception("Student already exists");
		}
		else {
			studentRepository.save(student);
			return student;
		}
	}
	
	@Transactional
	public Student updateStudent(Student student) throws RecordNotFoundException{
		Optional<Student> studentToAdd=getStudentById(student.getId());
		if(studentToAdd.isPresent()) {
			Student stud=studentToAdd.get();
			stud.setFirstName(student.getFirstName());
			stud.setLastName(student.getLastName());
			stud.setPhone(student.getPhone());
			studentRepository.save(stud);
			return stud;
		}
		else {
			throw new RecordNotFoundException("Student updated doesnt exist");
		}
		
	}
	
	@Transactional
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	@Transactional
	public Optional<Student> getStudentById(int id){
		return studentRepository.findById(id);
	}
	
	@Transactional
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}
	
}
