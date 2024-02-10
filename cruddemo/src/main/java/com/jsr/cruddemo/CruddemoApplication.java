package com.jsr.cruddemo;

import com.jsr.cruddemo.dao.StudentDAO;
import com.jsr.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);

//			createMultipleStudents(studentDAO);

//			findbyid(studentDAO);

//			findAllStudent(studentDAO);

			deleteId(studentDAO);
		};
	}

	private void deleteId(StudentDAO studentDAO) {
		System.out.println("Before Deletion :");
		findAllStudent(studentDAO);

		studentDAO.deleteById(4);

		System.out.println("After Deletion :");
		findAllStudent(studentDAO);
	}

	private void findAllStudent(StudentDAO studentDAO) {
		List<Student> l=studentDAO.findAll();
		System.out.println("All students are : ");
		for(Student var:l){
			System.out.println(var.toString());
		}
	}

	private void findbyid(StudentDAO studentDAO) {
		Student s=studentDAO.findById(1);
		System.out.println("The Student is "+s);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student s1=new Student("A","K","bd@gmail.com");
		Student s2=new Student("A","Singh","c@gmail.com");

		studentDAO.save(s1);
		studentDAO.save(s2);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create student
		Student s=new Student("Paul","Doe","abc@gmail.com");

		//save
		studentDAO.save(s);

		//display results for check
		System.out.println("Saved student ... Id = "+s.getId());
	}
}
