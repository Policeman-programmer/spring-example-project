package com.epam.springexample;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.epam.springexample.model.Customer;
import com.epam.springexample.model.EventImpl;
import com.epam.springexample.model.TicketImpl;
import com.epam.springexample.model.UserAccountImpl;
import com.epam.springexample.model.UserImpl;
import com.epam.springexample.repositories.CustomerRepository;
import com.epam.springexample.repositories.EventRepository;
import com.epam.springexample.repositories.TicketRepository;
import com.epam.springexample.repositories.UserRepository;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AccessingDataJpaApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
		app.run(args);
	}

		@Bean
	public CommandLineRunner testEventRepository(EventRepository repository) {
		return (args) -> {
//			 save a few events
			repository.save(new EventImpl("Romeo and Juliet", LocalDateTime.of(2020,
					Month.NOVEMBER, 11, 18, 30, 40)));
		};
	}

//	@Bean
//	public CommandLineRunner testEventRepository(EventRepository repository) {
//		return (args) -> {
////			 save a few events
//			repository.save(new EventImpl("Romeo and Juliet", LocalDateTime.of(2020,
//					Month.SEPTEMBER, 15, 19, 30, 40)));
//		};
//	}

//	@Bean
//	public CommandLineRunner testUserRepository(UserRepository repository) {
//		return (args) -> {
////			 save a few users
//			repository.save(new UserImpl("Yevhenii", "Yevhenii@email.com", new UserAccountImpl(10.2d)));
//			repository.save(new UserImpl("Sergei", "Sergei@email.com", new UserAccountImpl(11.2d)));
//			repository.save(new UserImpl("Alexey", "Alexey@email.com", new UserAccountImpl(100.2d)));
//		};
//	}

//	@Bean
//	public CommandLineRunner testCustomerRepository(CustomerRepository repository) {
//		return (args) -> {
//			// save a few customers
//			repository.save(new Customer("Jack", "Bauer"));
//			repository.save(new Customer("Chloe", "O'Brian"));
//			repository.save(new Customer("Kim", "Bauer"));
//			repository.save(new Customer("David", "Palmer"));
//			repository.save(new Customer("Michelle", "Dessler"));
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Customer customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			Customer customer = repository.findById(1L);
//			log.info("Customer found with findById(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//			log.info("");
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByLastName("Bauer").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
//			 for (Customer bauer : repository.findByLastName("Bauer")) {
//			 	log.info(bauer.toString());
//			 }
//			log.info("");
//		};
//	}

}
