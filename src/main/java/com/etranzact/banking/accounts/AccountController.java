package com.etranzact.banking.accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.etranzact.banking.accounts.AccountServices.Impl.AccountService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/accounts")
public class AccountController {
    private final AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts() {
        List<Account> accounts = accountService.getAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PostMapping("addAccount")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        Account newAccount = accountService.addAccount(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @PutMapping("updateAccount/{id}")
    public ResponseEntity<Void> updateAccount(
            @PathVariable("id") Long id,
            @RequestParam(value = "accountType", required = false) String accountType,
            @RequestParam(value = "customerDetails", required = false) String customerDetails,
            @RequestParam(value = "dateCreated", required = false) Date dateCreated,
            @RequestParam(value = "initialAmount", required = false) BigDecimal initialAmount) {

        accountService.updateAccount(id, accountType, dateCreated, customerDetails, initialAmount);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("deleteAccount/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
