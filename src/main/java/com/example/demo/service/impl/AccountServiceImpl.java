package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Integer id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.orElse(null);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account updateAccount(Integer id, Account account) {
        if (accountRepository.existsById(id)) {
            account.setId(id);
            return accountRepository.save(account);
        }
        return null;
    }

    @Override
    public void deleteAccount(Integer id) {
        accountRepository.deleteById(id);
    }
    // can deposit money
    @Override
    public Account createDeposit(Account deposit) {
        return accountRepository.save(deposit);
    }

    @Override
    public List<Account> getAllDeposits() {
        return accountRepository.findAll();
    }

    @Override
    public Account getDepositById(Integer id) {
        Optional<Account> optionalDeposit = accountRepository.findById(id);
        return optionalDeposit.orElse(null);
    }

    @Override
    public Account updateDeposit(Integer id, Account deposit) {
        if (accountRepository.existsById(id)) {
            deposit.setId(id);
            return accountRepository.save(deposit);
        }
        return null;
    }

    @Override
    public void deleteDeposit(Integer id) {
    	accountRepository.deleteById(id);
    }
    // Withdraw money
    @Override
    public Account createWithdrawal(Account withdrawal) {
        return accountRepository.save(withdrawal);
    }

    @Override
    public List<Account> getAllWithdrawals() {
        return accountRepository.findAll();
    }

    @Override
    public Account getWithdrawalById(Integer id) {
        Optional<Account> optionalWithdrawal = accountRepository.findById(id);
        return optionalWithdrawal.orElse(null);
    }
    @Override
	public Account withdrawAmount(Integer id, Double amount) {
		 Optional<Account> account =  accountRepository.findById(id);
		  if(account.isEmpty()) {
			  throw new RuntimeException("Account is not present");
		  }
		  Account accountPresent=account.get();
		

	      Double accountalance= accountPresent.getAccountBalance()-amount;
	        accountRepository.save(accountPresent);
	        accountPresent.setAccountBalance(accountalance);
			
		accountRepository.save(accountPresent);
		return  accountPresent;
	}

    @Override
    public Account updateWithdrawal(Integer id, Account withdrawal) {
        if (accountRepository.existsById(id)) {
            withdrawal.setId(id);
            return accountRepository.save(withdrawal);
        }
        return null;
    }

    @Override
    public void deleteWithdrawal(Integer id) {
    	accountRepository.deleteById(id);
    }
    
}