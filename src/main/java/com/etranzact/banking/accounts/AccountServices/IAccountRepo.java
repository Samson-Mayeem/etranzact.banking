package com.etranzact.banking.accounts.AccountServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etranzact.banking.accounts.Account;

import java.util.Optional;

@Repository
public interface IAccountRepo extends  JpaRepository <Account, Long> {
    Optional<Account> findById(long Id);
}