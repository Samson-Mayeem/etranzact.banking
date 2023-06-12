package com.etranzact.banking.transactions;

import com.etranzact.banking.transactions.transactionservices.Impl.AccountNotFoundException;
import com.etranzact.banking.transactions.transactionservices.Impl.InsufficientFundsException;
import com.etranzact.banking.transactions.transactionservices.Impl.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
@RestController
@RequestMapping("api/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<String> performTransaction(@RequestBody Transaction request) {
        long transactionId = request.getTransactionId(); // Assuming transaction ID is the same as account ID
        BigDecimal amt = request.getTransactionAmount();

        try {
            transactionService.performTransaction(transactionId, amt);
            return ResponseEntity.ok("Transaction successful.");
        } catch (InsufficientFundsException e) {
            return ResponseEntity.badRequest().body("Insufficient funds. Transaction failed.");
        } catch (AccountNotFoundException e) {
            return ResponseEntity.badRequest().body("Account not found. Transaction failed.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during the transaction.");
        }
    }

}


