package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/open")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Account> getAccountById(@PathVariable Integer id) {
//        Account account = accountService.getAccountById(id);
//        return account != null ? ResponseEntity.ok(account) : ResponseEntity.notFound().build();
//    }
//    
//
//    @GetMapping("/all")
//    public ResponseEntity<List<Account>> getAllAccounts() {
//        List<Account> accounts = accountService.getAllAccounts();
//        return ResponseEntity.ok(accounts);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Account> updateAccount(@PathVariable Integer id, @RequestBody Account account) {
//        Account updatedAccount = accountService.updateAccount(id, account);
//        return updatedAccount != null ? ResponseEntity.ok(updatedAccount) : ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteAccount(@PathVariable Integer id) {
//        accountService.deleteAccount(id);
//        return ResponseEntity.noContent().build();
//    }
//    
//    @GetMapping
//    public ResponseEntity<List<Account>> getAllDeposits() {
//        List<Account> deposits = accountService.getAllDeposits();
//        return ResponseEntity.ok(deposits);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Account> getDepositById(@PathVariable Integer id) {
//        Account deposit = accountService.getDepositById(id);
//        if (deposit != null) {
//            return ResponseEntity.ok(deposit);
//        }
//        return ResponseEntity.notFound().build();
//    }

//    @PutMapping("/deposit/update/{id}")
//    public ResponseEntity<Account> updateDeposit(@PathVariable Integer id, @RequestBody Account deposit) {
//        Account updatedDeposit = accountService.updateDeposit(id, deposit);
//        if (updatedDeposit != null) {
//            return ResponseEntity.ok(updatedDeposit);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteDeposit(@PathVariable Integer id) {
//    	accountService.deleteDeposit(id);
//        return ResponseEntity.noContent().build();
//    }

//withdraw form
@PostMapping
public ResponseEntity<Account> createWithdrawal(@RequestBody Account withdrawal) {
	Account createdWithdrawal = accountService.createWithdrawal(withdrawal);
    return ResponseEntity.ok(createdWithdrawal);
}

@GetMapping("/all")
public ResponseEntity<List<Account>> getAllWithdrawals() {
    List<Account> withdrawals = accountService.getAllWithdrawals();
    return ResponseEntity.ok(withdrawals);
}


//@PutMapping("/withdraw/{amount}/{id}")
//public ResponseEntity<Account> getWithdrawalById(@PathVariable Integer id) {
//	Account withdrawal = accountService.getWithdrawalById(id);
//    if (withdrawal != null) {
//        return ResponseEntity.ok(withdrawal);
//    }
//    return ResponseEntity.notFound().build();
//}
//
//@PutMapping("/{amount}/{id}")
//public ResponseEntity<Account> updateWithdrawal(@PathVariable Integer id, @RequestBody Account withdrawal) {
//	Account updatedWithdrawal = accountService.updateWithdrawal(id, withdrawal);
//    if (updatedWithdrawal != null) {
//        return ResponseEntity.ok(updatedWithdrawal);
//    }
//    return ResponseEntity.notFound().build();
//}
@PutMapping("/withdraw/{id}/{amount}")
public Account withdrawAccount( @PathVariable Integer id, @PathVariable Double amount) {
    Account account=accountService.withdrawAmount(id,amount);
    return account;
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteWithdrawal(@PathVariable Integer id) {
	accountService.deleteWithdrawal(id);
    return ResponseEntity.noContent().build();
}
}
