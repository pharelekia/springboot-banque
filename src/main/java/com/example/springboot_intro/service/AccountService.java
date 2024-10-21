package com.example.springboot_intro.service;

import com.example.springboot_intro.entity.Account;
import com.example.springboot_intro.exception.AccountNotFoundException;
import com.example.springboot_intro.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account getAccount(Long id){
        return accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Account with "+id+" not found"));
    }

//    public Account getAccount(Long accountNumber){
//        if(accountNumber.)
//    }

    public Account saveAccount(Account accountInput){
        return accountRepository.save(accountInput);
    }

    public Account updateAccount(Long id, Account accountInput){
        Account account = getAccount(id);
        account.setAmout(account.getAmout());
        return accountRepository.save(account);
    }

    public String deleteAccount(Long id){
        Account account = getAccount(id);
        accountRepository.delete(account);
        return "Account delete";
    }
}
