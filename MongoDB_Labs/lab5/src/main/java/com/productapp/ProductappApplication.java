package com.productapp;

import com.productapp.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner {

	private MongoTemplate mongoTemplate;

	@Autowired
	public ProductappApplication(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mongoTemplate.save(new Product("laptop", 30, "XYZ", 5000.0));
		mongoTemplate.save(new Product("mouse", 300, "ABC", 100.0));
		mongoTemplate.save(new Product("Keyboard", 20, "DEF", 760.0));
		System.out.println("SERVER STARTED ON PORT 8080");
	}

}
