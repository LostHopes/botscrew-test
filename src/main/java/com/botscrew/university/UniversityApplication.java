package com.botscrew.university;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.botscrew.university.misc.ChoiceMenu;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(
			"""
				1. Who is the head of department?
				2. Show department statistics
				3. Show the average salary for the department
				4. Show count of employee for department
				5. Global search\n"""
		);

		Scanner scanner = new Scanner(System.in);
		System.out.print("Select number:");
		int userInput = scanner.nextInt();
		scanner.close();

		switch(userInput) {
			case ChoiceMenu.HEAD_OF_DEPARTMENT:
				break;
			
			case ChoiceMenu.SHOW_DEPARTMENT_STATISTICS:
				break;
			
			case ChoiceMenu.SHOW_AVERAGE_SALARY:
				break;
			
			case ChoiceMenu.SHOW_COUNT_OF_EMPLOYEE:
				break;
			
			case ChoiceMenu.GLOBAL_SEARCH:
				break;
			
			default:
				break;
		}
	}

}
