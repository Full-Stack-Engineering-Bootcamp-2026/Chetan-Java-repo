package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.model.Student;



@Service
public class StudentService {
	
	//ArrayList<Student> students=new ArrayList<Student>();
	

	
//	
//	ArrayList<Student> students=new ArrayList<Student>(Arrays.asList(
//			new Student(1, "chetan", "cdac", "chetan@gmail.com"),
//			new Student(2, "yash", "cdac", "yash@gmail.com")));
//	

	
//		List<Student> students=List.of(
//				new Student(1, "chetan", "cdac", "chetan@gmail.com"),
//				new Student(2, "yash", "cdac", "yash@gmail.com"),
//				new Student(3, "pravin", "cdac", "pravin@gmail.com")
//				);
	
	List<Student> students = new ArrayList<>(List.of(
	    new Student(1, "chetan", "cdac", "chetan@gmail.com"), 
	    new Student(2, "yash", "cdac", "yash@gmail.com"), 
	    new Student(3, "pravin", "IACSD", "pravin@gmail.com")
	));

		
		public List<Student> getAllStudents(){
			System.out.println(students);
			return students;
		}


		public Optional<Student> getByid(long id) {
			
			
			Optional<Student> student =students.stream().filter(a -> a.id==id).findFirst();
			return student;
		}


		
		
				
}
