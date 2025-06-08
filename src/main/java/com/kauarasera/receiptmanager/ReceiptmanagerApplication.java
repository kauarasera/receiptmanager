package com.kauarasera.receiptmanager;

import com.kauarasera.receiptmanager.entity.Person;
import com.kauarasera.receiptmanager.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReceiptmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceiptmanagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner testPersonRepository(PersonRepository personRepository) {
		return args -> {
			Person p = new Person(
					null,
					"João",
					"Silva",
					"12345678900",
					"11999999999",
					"Rua das Flores, 123",
					"Banco Exemplo",
					"1234",
					"56789-0",
					"Checking"
			);
			personRepository.save(p);
		};
	}
}