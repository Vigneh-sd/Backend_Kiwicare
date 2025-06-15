package com.kiwicare.localhelp.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiwicare.localhelp.Entity.MessageModel;

@Repository
public interface MessageRepository extends JpaRepository<MessageModel, Long> {

  
    List<MessageModel> findBySenderId(long senderId);

    
    List<MessageModel> findByReceiverId(long receiverId);
    
    
}
