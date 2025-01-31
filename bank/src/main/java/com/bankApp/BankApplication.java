package com.bankApp;

import com.bankApp.entities.Account;
import com.bankApp.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@AllArgsConstructor
public class BankApplication implements CommandLineRunner {

	private AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Account account1 = new Account("Shaurya", 100000);
		Account account2 = new Account("Abhi", 200000);

		accountRepository.save(account1);
		accountRepository.save(account2);

	}
}
