package com.library;

import com.library.entity.Book;
import com.library.entity.User;
import com.library.repositories.BookRepository;
import com.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class BookApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bookRepo.save(new Book("123","book1","category1","author1", BigDecimal.valueOf(1000.00)));
		bookRepo.save(new Book("456","book2","category2","author2",BigDecimal.valueOf(2000.00)));
		userService.addUserEntity(new User("teacher",
				passwordEncoder.encode("teacher"), List.of("ROLE_TEACHER","ROLE_STUDENT")));

		userService.addUserEntity(new User("student",passwordEncoder.encode("student"),
				List.of("ROLE_STUDENT")));


	}
}
