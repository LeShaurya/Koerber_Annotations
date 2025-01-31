package com.bankApp.services;

import com.bankApp.dto.AccountDto;
import com.bankApp.entities.Account;
import com.bankApp.exception.AccountNotFoundException;
import com.bankApp.exception.InsufficientBalanceException;
import com.bankApp.exception.InvalidDepositException;
import com.bankApp.repositories.AccountRepository;
import com.bankApp.services.aspect.Loggable;
import com.bankApp.utils.ConvertDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImplementation implements AccountService{

    private AccountRepository accountRepository;

    @Loggable
    @Override
    public void transfer(int from, int to, double amount) {
        Account accountFrom = ConvertDto.toAccount(getAccount(from));
        Account accountTo = ConvertDto.toAccount(getAccount(to));

        if(accountFrom.getBalance() - amount < 0)
            throw new InsufficientBalanceException("insufficient funds.");
        accountRepository.updateBalance(from, accountFrom.getBalance() - amount);
        accountRepository.updateBalance(to, accountTo.getBalance() + amount);
    }

    @Loggable
    @Override
    public void deposit(int id, double amount) {
        if(amount < 0)
            throw new InvalidDepositException("invalid amount");
        Account account = ConvertDto.toAccount(getAccount(id));
        accountRepository.updateBalance(id, amount + account.getBalance());
    }

    @Loggable
    @Override
    public AccountDto getAccount(int id) {
        Account account = accountRepository.findById(id);
        if(account == null)
            throw new AccountNotFoundException("account not found with id: " + id);
        return ConvertDto.toDto(account);
    }

}
