package com.kiwicare.localhelp.Service;

import com.kiwicare.localhelp.DTO.MessageRequest;
import com.kiwicare.localhelp.Entity.MessageModel;

import java.util.List;

public interface MessageService {
    MessageModel sendMessage(MessageRequest request);

    List<MessageModel> getMessagesSentByUser(long userId);

    List<MessageModel> getMessagesReceivedByVolunteer(long volunteerId);
    
   

}
