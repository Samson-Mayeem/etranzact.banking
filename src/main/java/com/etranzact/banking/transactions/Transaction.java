package com.etranzact.banking.transactions;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "transaction")
@EnableJpaRepositories
public class Transaction {
    @jakarta.persistence.Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_sequence")
    private Long transactionId;
    private BigDecimal transactionAmount;
    private String TransactionType;
    private Date TimeStamp;
    private String Description;

    // Constructors
    public Transaction() {
    }

    public Transaction(Long id, BigDecimal amount,String transactiontype, Date timestamp, String description) {
        this.transactionId = id;
        this.transactionAmount = amount;
        this.TransactionType = transactiontype;
        this.TimeStamp = timestamp;
        this.Description = description;
    }
    public Transaction( BigDecimal amount, String transactiontype, Date timestamp, String description) {
        this.transactionAmount = amount;
        this.TransactionType = transactiontype;
        this.TimeStamp = timestamp;
        this.Description = description;
    }
}
