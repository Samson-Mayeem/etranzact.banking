package com.etranzact.banking.accounts.AccountServices.Impl;

import com.etranzact.banking.accounts.Account;
import com.etranzact.banking.accounts.AccountServices.IAccountRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AccountService {

    private final IAccountRepo _accountRepo;

    @Autowired
    public AccountService(IAccountRepo accountRepo) {
        _accountRepo = accountRepo;
    }

    public List<Account> getAccounts() {
        try {
            return _accountRepo.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Account addAccount(Account account) {
         _accountRepo.save(account);
        return account;
    }

    public void updateAccount(Long id, String accountType, Date dateCreated, String customerDetails, BigDecimal initialAmount) {
        Account account = _accountRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("Account with id " + id + " does not exist"));

        if (accountType != null && !accountType.isEmpty()) {
            account.setAccountType(accountType);
        }

        if (dateCreated != null) {
            account.setDateCreatedAt(dateCreated);
        }

        if (customerDetails != null && !customerDetails.isEmpty()) {
            account.setCustomerDetails(customerDetails);
        }

        if (initialAmount != null) {
            account.setInitialAmount(initialAmount);
        }

        _accountRepo.save(account);
    }

    public void deleteAccount(Long id) {
        try {
            var del = _accountRepo.findById(id);
            if (del.isPresent()){
                _accountRepo.deleteById(id);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Make a retry to delete with a different id.");
        }
    }
}

