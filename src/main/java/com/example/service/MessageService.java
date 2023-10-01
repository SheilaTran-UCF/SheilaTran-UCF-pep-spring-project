package com.example.service;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MessageService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private MessageRepository messageRepository;

    public ResponseEntity<Message> createMessage(Message message) {
        Optional<Account> account = accountRepository.findById(message.getPosted_by());
        if (account.isEmpty()) {
            return ResponseEntity.status(400).body(null);
        }
        Message result = messageRepository.save(message);
        System.out.println(result);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<List<Message>> getAllMessage() {
        List<Message> messages = messageRepository.findAll();
        return ResponseEntity.ok(messages);
    }

    public ResponseEntity<Message> getMessageById(Integer messageId) {
        Optional<Message> message = messageRepository.findById(messageId);
        if (message.isEmpty()) {
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(message.get());
    }

    public ResponseEntity<List<Message>> getMessageByUser(Integer postBy) {
        List<Message> messages = messageRepository.findByPosted_by(postBy);
        return ResponseEntity.ok(messages);
    }

    public ResponseEntity<Integer> deleteMessage(Integer messageId) {
        Optional<Message> message = messageRepository.findById(messageId);
        if (message.isEmpty()) {
            return ResponseEntity.ok().body(0);
        }
        Integer result = messageRepository.deleteByMessageId(messageId);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<Integer> updateMessage(int messageId, String messageText) {
        Optional<Message> message = messageRepository.findById(messageId);
        if (message.isEmpty()) {
            return ResponseEntity.status(400).build();
        }
        Integer result = messageRepository.updateMessage(messageId, messageText);
        if (result == null) {
            return ResponseEntity.status(400).build();
        }
        return ResponseEntity.ok(result);
    }
}
