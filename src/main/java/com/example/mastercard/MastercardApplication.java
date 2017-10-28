package com.example.mastercard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.github.javafaker.Faker;
import com.example.mastercard.Models.Students;
import com.example.mastercard.Repositories.studentRepository;

@SpringBootApplication
public class MastercardApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(MastercardApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MastercardApplication.class, args);
	}
	
	Faker faker = new Faker(); // Faker class which generates random names to populate repository
	Students temp = new Students(); 

	@Bean
	public CommandLineRunner setup(studentRepository repository) {
		return (args) -> {
			for(int i = 0; i<20; i++) //Populates repository with 20 different students 
			{
				String firstName = faker.name().firstName();
				String lastName = faker.name().lastName();
				repository.save(new Students(firstName, lastName, temp.generateEmail(firstName, lastName), temp.generateCourse(), faker.address().streetAddress(), faker.number().numberBetween(18,28)));
			}
			logger.info("The sample data has been generated");
		};
	}
}