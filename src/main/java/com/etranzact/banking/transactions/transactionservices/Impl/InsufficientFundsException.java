package com.etranzact.banking.transactions.transactionservices.Impl;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
