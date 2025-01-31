package com.bankApp.controllers;

import com.bankApp.dto.AccountDto;
import com.bankApp.entities.Account;
import com.bankApp.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;

    @GetMapping("/getAccount/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(accountService.getAccount(id));
    }

    @PostMapping("/transfer/{from}/{to}/{amount}")
    public void transfer(@PathVariable int from,@PathVariable int to, @PathVariable double amount) {
        accountService.transfer(from, to, amount);
    }

    @PostMapping("/deposit/{id}/{amount}")
    public void deposit(@PathVariable int id, @PathVariable double amount) {
        accountService.deposit(id, amount);
    }

}
