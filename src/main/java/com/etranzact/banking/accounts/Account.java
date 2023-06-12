package com.etranzact.banking.accounts;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "account")
public class Account {
    @jakarta.persistence.Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence")
    private long Id;
    private String AccountType;
    private Date DateCreatedAt;
    private String CustomerDetails;
    private BigDecimal InitialAmount;
    public Account(long id, String accountType, Date dateCreatedAt, String customerDetails, BigDecimal initialAmount) {
        Id = id;
        AccountType = accountType;
        DateCreatedAt = dateCreatedAt;
        CustomerDetails = customerDetails;
        InitialAmount = initialAmount;
    }
    public Account( String accountType, Date dateCreatedAt, String customerDetails, BigDecimal initialAmount) {
        AccountType = accountType;
        DateCreatedAt = dateCreatedAt;
        CustomerDetails = customerDetails;
        InitialAmount = initialAmount;
    }
    public Account() {
    }
}
