package com.interview.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.interview.assignment.exceptions.RecordNotFoundException;
import com.interview.assignment.model.Student;
import com.interview.assignment.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST, headers = "Accept=application/json")
    public Student addStudent(@RequestBody Student student) throws Exception {
 
        Student stud=studentService.addStudent(student);
        return stud;
    }
	
	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST, headers = "Accept=application/json")
    public Student updateStudent(@RequestBody Student student) throws RecordNotFoundException {
        Student stud=studentService.updateStudent(student);
        return stud;
    }
	
	
	
	@RequestMapping(value = "/getAllStudents", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Student> getStudents() {
 
        List<Student> studenList = studentService.getAllStudents();
        return studenList;
    }
	
	@RequestMapping(value="/getStudent/{id}", method=RequestMethod.GET , headers="Accept=application/json")
	public Student getStudentById(@PathVariable("id") int id) {
		return studentService.getStudentById(id).get();
	}
	
	@RequestMapping(value="/deleteStudent/{id}", method=RequestMethod.DELETE, headers="Accept=application/json")
	public void deleteStudent(@PathVariable("id") int id) {
		studentService.deleteStudent(id);
	}
}











