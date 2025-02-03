package com.example;

import com.example.entities.Book;
import com.example.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.math.BigDecimal;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		bookRepository.save(new Book("978-3-16-148410-0", "The Great Adventure", "John Doe", BigDecimal.valueOf(100)));
		bookRepository.save(new Book("978-1-86197-876-9", "Learning Java", "Jane Smith", BigDecimal.valueOf(55.5)));
	}
}
