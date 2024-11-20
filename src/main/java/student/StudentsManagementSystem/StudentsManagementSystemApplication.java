package student.StudentsManagementSystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import student.StudentsManagementSystem.entity.Student;
import student.StudentsManagementSystem.service.StudentManagement;

@SpringBootApplication
public class StudentsManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsManagementSystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentManagement studentManagement) {

		Student student1 = new Student("Ace");
		Student student2 = new Student("Jack");
		Student student3 = new Student("Cathy");
		Student student4 = new Student("Peter");
		Student student5 = new Student("Jacob");

		return runner -> {

			try {
				studentManagement.addStudent(student1);
				studentManagement.addStudent(student2);
				studentManagement.addStudent(student3);
				studentManagement.addStudent(student4);
				studentManagement.addStudent(student5);

				Thread.sleep(100); // 等待 100 毫秒
				studentManagement.updateStudent(1L, 90, 80, 100);
				studentManagement.updateStudent(2L, 85, 75, 65);
				studentManagement.updateStudent(3L, 93, 82, 77);
				studentManagement.updateStudent(4L, 96, 91, 72);
				studentManagement.updateStudent(5L, 70, 80, 60);

				Thread.sleep(100); // 等待 100 毫秒
				studentManagement.updateAverageScore(1L);
				studentManagement.updateAverageScore(2L);
				studentManagement.updateAverageScore(3L);
				studentManagement.updateAverageScore(4L);
				studentManagement.updateAverageScore(5L);

				// 查詢所有學生
				System.out.println("所有學生:");
				studentManagement.getAllStudents().forEach(System.out::println);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
	}
}
