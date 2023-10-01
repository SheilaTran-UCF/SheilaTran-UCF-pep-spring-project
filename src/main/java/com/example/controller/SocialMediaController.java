package com.example.controller;


import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private MessageService messageService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody Account account) {
        return accountService.register(account);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody Account account) {
        return accountService.login(account);
    }

    @PostMapping("/messages")
    public ResponseEntity<?> messages(@Valid @RequestBody Message message) {
        return messageService.createMessage(message);
    }

    @GetMapping("/messages")
    public ResponseEntity<?> messages() {
        return messageService.getAllMessage();
    }

    @GetMapping("/messages/{message_id}")
    public ResponseEntity<?> messages(@PathVariable("message_id") Integer messageId) {
        return messageService.getMessageById(messageId);
    }

    @GetMapping("/accounts/{account_id}/messages")
    public ResponseEntity<?> getMessageByUser(@PathVariable("account_id") Integer accountId) {
        return messageService.getMessageByUser(accountId);
    }

    @DeleteMapping("/messages/{message_id}")
    public ResponseEntity<?> deleteMessage(@PathVariable("message_id") Integer messageId) {
        return messageService.deleteMessage(messageId);
    }

    @PatchMapping("/messages/{message_id}")
    public ResponseEntity<?> updateMessage(@PathVariable("message_id") Integer messageId, @Valid @RequestBody Message message) {
        return messageService.updateMessage(messageId, message.getMessage_text());
    }
}
