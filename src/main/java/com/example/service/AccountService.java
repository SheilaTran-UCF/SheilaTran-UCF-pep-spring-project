package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    public ResponseEntity<Account> register(Account account) {
        Account accountExits = accountRepository.findByUsername(account.getUsername());
        if (accountExits != null) {
            return ResponseEntity.status(409).body(null);
        }
        Account result = accountRepository.save(account);
        if (result == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<Object> login(Account account) {
        Account accountInDb = accountRepository.findByUsername(account.getUsername());
        if (accountInDb == null || !accountInDb.getPassword().equals(account.getPassword())) {
            return ResponseEntity.status(401).body("Password not valid");
        }

        return ResponseEntity.ok(accountInDb);
    }
}
