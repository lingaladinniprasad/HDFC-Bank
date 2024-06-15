package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Account;

public interface AccountService {
	    Account createAccount(Account account);
	    Account getAccountById(Integer id);
	    List<Account> getAllAccounts();
	    Account updateAccount(Integer id, Account account);
	    void deleteAccount(Integer id);
	  //  Account depositAmount(Integer id, Double amount);
	    Account createDeposit(Account deposit);
	    List<Account> getAllDeposits();
	    Account getDepositById(Integer id);
	    Account updateDeposit(Integer id, Account deposit);
	    void deleteDeposit(Integer id);
	    //with draw money
	    Account createWithdrawal(Account withdrawal);
	    List<Account> getAllWithdrawals();
	    Account getWithdrawalById(Integer id);
	    Account updateWithdrawal(Integer id, Account withdrawal);
	    void deleteWithdrawal(Integer id);
	    public Account withdrawAmount(Integer id,Double amount);
	}

