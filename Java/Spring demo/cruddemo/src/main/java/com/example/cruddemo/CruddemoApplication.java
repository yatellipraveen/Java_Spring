package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
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

		return runner -> {
//			createStudent(studentDAO);

			createMultipleStudents(studentDAO);

//			readStudent(studentDAO);

//			queryForStudent(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteALL(studentDAO);
		};


	}

	private void deleteALL(StudentDAO studentDAO) {
		System.out.println("Deleting all the students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Delete number of rows:" + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId=3;
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrive student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		//change first name to "Scooby"
		myStudent.setFirstName("John");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated Student : " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Does");
		//display list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();
		//display list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new student object");
		Student temmpStudent1 = new Student("Daffy", "Does", "Daffy@gmail.com");

		//save the student
		studentDAO.save((temmpStudent1));

		//display id of the saved student
		System.out.println("Saved student. Generated id:"+ temmpStudent1.getId());

		//retrive student based on the id
		Student returivedStudent = studentDAO.findById(temmpStudent1.getId());

		//display student

		System.out.println("New Student : " + returivedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating new student object");
		Student temmpStudent1 = new Student("John", "Does", "paul@gmail.com");
		Student temmpStudent2 = new Student("Mike", "Meline", "Mike@gmail.com");
		Student temmpStudent3 = new Student("Celine", "Potter", "Celine@gmail.com");

		//save the student objects
		studentDAO.save(temmpStudent1);
		studentDAO.save(temmpStudent2);
		studentDAO.save(temmpStudent3);

		System.out.println("Saved student. Generated id:"+ temmpStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object");
		Student temmpStudent = new Student("Paul", "Does", "paul@gmail.com");
		//save the student object

		studentDAO.save(temmpStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id:"+ temmpStudent.getId());
	}

}
