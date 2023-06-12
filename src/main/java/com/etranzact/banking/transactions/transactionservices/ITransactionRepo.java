package com.etranzact.banking.transactions.transactionservices;

import com.etranzact.banking.transactions.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ITransactionRepo extends JpaRepository<Transaction, Long> {
   Optional<Transaction> findTransactionByTransactionAmount(BigDecimal transactionAmount);
}
