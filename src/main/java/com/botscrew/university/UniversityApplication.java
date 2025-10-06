package com.botscrew.university;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.botscrew.university.dto.Lector;
import com.botscrew.university.dto.Role;
import com.botscrew.university.misc.ChoiceMenu;
import com.botscrew.university.misc.SampleData;
import com.botscrew.university.repos.DepartmentRepository;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}

	private final SampleData sampleData;
	private final DepartmentRepository departmentRepository;

	public UniversityApplication(SampleData sampleData, DepartmentRepository departmentRepository) {
		this.sampleData = sampleData;
		this.departmentRepository = departmentRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		sampleData.generate();

		Scanner scanner = new Scanner(System.in);

		// TODO: add error error handlers for Scanner
		System.out.print("Enter department name: ");
		String departmentName = scanner.nextLine().strip();

		System.out.println(
			"""
				1. Who is the head of department?
				2. Show department statistics
				3. Show the average salary for the department
				4. Show count of employee for department
				5. Global search\n"""
		);

		System.out.print("Select number:");
		int userInput = scanner.nextInt();

		switch(userInput) {
			case ChoiceMenu.HEAD_OF_DEPARTMENT:

				Optional<Lector> head = departmentRepository.findDepartmentHead(departmentName);

				if (!head.isPresent()) {
					System.out.println("Invalid input or head of the department doesn't exist");
					break;
				}

				System.out.println(String.format("Head of the department is %s", head.get().getName()));
				break;
			
			case ChoiceMenu.SHOW_DEPARTMENT_STATISTICS:
				int assistants = departmentRepository.countByRole(departmentName, Role.ASSISTANT);
				int associates = departmentRepository.countByRole(departmentName, Role.ASSOCIATE_PROFESSOR);
				int professors = departmentRepository.countByRole(departmentName, Role.PROFESSOR);

				System.out.println(
					String.format("""
							Assistants %d
							Associates %d
							Professors %d""",
							assistants, associates, professors)
				);
				break;
			
			case ChoiceMenu.SHOW_AVERAGE_SALARY:
				int salary = departmentRepository.calculateAvgSalary(departmentName);
				System.out.println(String.format("Average salary for department: %d UAH", salary));
				break;
			
			case ChoiceMenu.SHOW_COUNT_OF_EMPLOYEE:
				int amountOfEmployees = departmentRepository.countEmployees(departmentName);
				System.out.println(String.format("Amount of employees %d", amountOfEmployees));
				break;
			
			case ChoiceMenu.GLOBAL_SEARCH:
				List<Lector> lectors = departmentRepository.searchLectorsByTemplate(departmentName, "ss");

				for (Lector lector : lectors) {
					System.out.println(lector.getName());
				}
				break;
			
			default:
				break;
		}
		scanner.close();
	}

}
