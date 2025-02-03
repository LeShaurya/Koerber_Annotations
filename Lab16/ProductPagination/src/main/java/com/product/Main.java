package com.product;

import com.product.entities.Product;
import com.product.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
@AllArgsConstructor
public class Main implements CommandLineRunner {
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product("Banana", BigDecimal.valueOf(1000), LocalDate.of(2025, 1, 1)));
        productRepository.save(new Product("Apple", BigDecimal.valueOf(1500), LocalDate.of(2025, 1, 2)));
        productRepository.save(new Product("Orange", BigDecimal.valueOf(1200), LocalDate.of(2025, 1, 3)));
        productRepository.save(new Product("Mango", BigDecimal.valueOf(2000), LocalDate.of(2025, 1, 4)));
        productRepository.save(new Product("Grapes", BigDecimal.valueOf(1800), LocalDate.of(2025, 1, 5)));
        productRepository.save(new Product("Pineapple", BigDecimal.valueOf(2500), LocalDate.of(2025, 1, 6)));
        productRepository.save(new Product("Strawberry", BigDecimal.valueOf(3000), LocalDate.of(2025, 1, 7)));
        productRepository.save(new Product("Blueberry", BigDecimal.valueOf(3500), LocalDate.of(2025, 1, 8)));
        productRepository.save(new Product("Watermelon", BigDecimal.valueOf(2200), LocalDate.of(2025, 1, 9)));
        productRepository.save(new Product("Papaya", BigDecimal.valueOf(1700), LocalDate.of(2025, 1, 10)));
        productRepository.save(new Product("Kiwi", BigDecimal.valueOf(2800), LocalDate.of(2025, 1, 11)));
        productRepository.save(new Product("Peach", BigDecimal.valueOf(2700), LocalDate.of(2025, 1, 12)));
        productRepository.save(new Product("Pear", BigDecimal.valueOf(1600), LocalDate.of(2025, 1, 13)));
        productRepository.save(new Product("Plum", BigDecimal.valueOf(1900), LocalDate.of(2025, 1, 14)));
        productRepository.save(new Product("Cherry", BigDecimal.valueOf(4000), LocalDate.of(2025, 1, 15)));
        productRepository.save(new Product("Apricot", BigDecimal.valueOf(2100), LocalDate.of(2025, 1, 16)));
        productRepository.save(new Product("Fig", BigDecimal.valueOf(2300), LocalDate.of(2025, 1, 17)));
        productRepository.save(new Product("Pomegranate", BigDecimal.valueOf(2400), LocalDate.of(2025, 1, 18)));
        productRepository.save(new Product("Guava", BigDecimal.valueOf(1300), LocalDate.of(2025, 1, 19)));
        productRepository.save(new Product("Lychee", BigDecimal.valueOf(3200), LocalDate.of(2025, 1, 20)));
    }
}