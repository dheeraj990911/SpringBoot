package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all the Students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("No. of Rows Deleted: "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId =3;
		System.out.println("Deleting the Student with id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting the Student with id: "+studentId);
		Student myStudent = studentDAO.findByID(studentId);
		System.out.println("Updating the Student");
		myStudent.setFirstname("John");
		studentDAO.update(myStudent);
		System.out.println("Updated Student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		for(Student tempStudents: theStudents){
			System.out.println(tempStudents);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents =studentDAO.findAll();
		for (Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating the new Student...");
		Student tempStudent = new Student("Daffy","Duck","daffy@luv2code.com");
		System.out.println("Saving the new Student to the database");
		studentDAO.save(tempStudent);
		int theID = tempStudent.getId();
		System.out.println("Saved Student Generated ID: "+theID);
		System.out.println("Retreving the student with id: "+theID);
		Student myStudent = studentDAO.findByID(theID);
		System.out.println("Found the Student: "+myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating the 3 new student objs...");
		Student tempStudent1 = new Student("John","Doe","john@luv2code.com");
		Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita","Applebum","bonita@luv2code.com");
		System.out.println("Saving the new Students in the database...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating the new student obj...");
		Student tempStudent = new Student("Paul","Doe","paul@luv2code.com");
		System.out.println("Saving the new Student in the database...");
		studentDAO.save(tempStudent);
		System.out.println("Saved Student"+tempStudent.getId());
	}

}