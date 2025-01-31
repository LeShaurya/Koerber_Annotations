package com.bankApp.services;

import com.bankApp.dto.AccountDto;

public interface AccountService {
    public void transfer(int from, int to, double amount);
    public void deposit(int id, double amount);
    public AccountDto getAccount(int id);
}
