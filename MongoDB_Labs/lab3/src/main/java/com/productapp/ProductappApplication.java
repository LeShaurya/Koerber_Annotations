package com.productapp;

import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner {

	private ProductRepo productRepo;

	@Autowired
	public ProductappApplication(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepo.save(new Product("laptop", 30, "XYZ", 5000.0));
		productRepo.save(new Product("mouse", 300, "ABC", 100.0));
		productRepo.save(new Product("Keyboard", 20, "DEF", 760.0));
	}

}
