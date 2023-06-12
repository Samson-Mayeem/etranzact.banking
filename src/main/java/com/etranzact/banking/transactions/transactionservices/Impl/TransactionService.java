package com.etranzact.banking.transactions.transactionservices.Impl;
import com.etranzact.banking.accounts.Account;
import com.etranzact.banking.accounts.AccountServices.IAccountRepo;
import com.etranzact.banking.transactions.Transaction;
import com.etranzact.banking.transactions.transactionservices.ITransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class TransactionService {
    private final ITransactionRepo iTransactionRepo;
    private final IAccountRepo iAccountRepo;
    @Autowired
    public TransactionService(ITransactionRepo iTransactionRepo, IAccountRepo iAccountRepo) {
        this.iTransactionRepo = iTransactionRepo;
        this.iAccountRepo = iAccountRepo;
    }

    public void performTransaction(long id, BigDecimal amt) {
        Optional<Account> accountOptional = iAccountRepo.findById(id);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            BigDecimal transactionAmt = amt;
            BigDecimal initialAmount = account.getInitialAmount();

            if (transactionAmt.compareTo(initialAmount) <= 0) {
                BigDecimal newInitialAmount = initialAmount.subtract(transactionAmt);
                account.setInitialAmount(newInitialAmount);
                // Save the updated account to the repository
                iAccountRepo.save(account);
                // Create and save the transaction in the repository
                Transaction transaction = new Transaction();
                transaction.setTransactionAmount(amt);
                iTransactionRepo.saveAndFlush(transaction);
                System.out.println("Transaction successful. Updated initial amount: " + newInitialAmount);
            } else {
                System.out.println("Insufficient funds. Transaction failed.");
            }
        } else {
            System.out.println("Account not found. Transaction failed.");
        }
    }
}


