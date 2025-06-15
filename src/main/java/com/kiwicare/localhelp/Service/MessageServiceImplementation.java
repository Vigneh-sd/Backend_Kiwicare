package com.kiwicare.localhelp.Service;

import com.kiwicare.localhelp.DTO.MessageRequest;
import com.kiwicare.localhelp.Entity.MessageModel;
import com.kiwicare.localhelp.Entity.UserModel;
import com.kiwicare.localhelp.Respository.MessageRepository;
import com.kiwicare.localhelp.Respository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImplementation implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public MessageModel sendMessage(MessageRequest request) {
        UserModel sender = userRepository.findById(request.getSenderId())
            .orElseThrow(() -> new RuntimeException("Sender not found"));

        UserModel receiver = userRepository.findById(request.getReceiverId())
            .orElseThrow(() -> new RuntimeException("Receiver not found"));

        MessageModel message = new MessageModel();
        message.setContent(request.getContent());
        message.setTimestamp(LocalDateTime.now());
        message.setSender(sender);
        message.setReceiver(receiver);

        return messageRepository.save(message);
    }

    @Override
    public List<MessageModel> getMessagesSentByUser(long userId) {
        return messageRepository.findBySenderId(userId);
    }

    @Override
    public List<MessageModel> getMessagesReceivedByVolunteer(long volunteerId) {
        return messageRepository.findByReceiverId(volunteerId);
    }
    

}
