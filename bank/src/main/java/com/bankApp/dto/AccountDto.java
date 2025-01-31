package com.bankApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDto {
    private int id;
    private String name;
    private double balance;

    public AccountDto(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
}
