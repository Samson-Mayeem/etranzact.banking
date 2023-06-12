package com.etranzact.banking.transactions.transactionservices.Impl;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}