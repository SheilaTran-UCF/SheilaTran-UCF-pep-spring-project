package com.example.repository;

import com.example.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    public Message save(Message message);

    @Modifying
    @Query(value = "select * from message where posted_by = :postedBy", nativeQuery = true)
    public List<Message> findByPosted_by(@Param("postedBy") Integer postedBy);

    @Transactional
    @Modifying
    @Query(value = "delete message where message_id = :messageId", nativeQuery = true)
    public Integer deleteByMessageId(@Param("messageId") Integer messageId);

    @Transactional
    @Modifying
    @Query(value = "update message set message_text = :messageText where message_id = :messageId", nativeQuery = true)
    public Integer updateMessage(@Param("messageId") int messageId, @Param("messageText") String messageText);
}
