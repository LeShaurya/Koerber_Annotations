package com.bankApp.utils;

import com.bankApp.dto.AccountDto;
import com.bankApp.entities.Account;

public class ConvertDto {
    public static AccountDto toDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setName(account.getName());
        accountDto.setBalance(account.getBalance());
        return accountDto;

    }

    public static Account toAccount(AccountDto accountDto) {
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setName(accountDto.getName());
        account.setBalance(accountDto.getBalance());
        return account;
    }
}
