package com.interview.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.assignment.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
	
	
}
