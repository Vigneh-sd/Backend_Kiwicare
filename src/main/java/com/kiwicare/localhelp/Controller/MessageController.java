package com.kiwicare.localhelp.Controller;

import com.kiwicare.localhelp.DTO.MessageRequest;
import com.kiwicare.localhelp.Entity.MessageModel;
import com.kiwicare.localhelp.Service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    @PreAuthorize("hasAnyRole('USER', 'VOLUNTEER')")
    public ResponseEntity<MessageModel> sendMessage(@RequestBody MessageRequest request) {
        MessageModel message = messageService.sendMessage(request);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/sent/{userId}")
    @PreAuthorize("hasAnyRole('USER', 'VOLUNTEER')")
    public ResponseEntity<List<MessageModel>> getSentMessages(@PathVariable("userId") long userId) {
        return ResponseEntity.ok(messageService.getMessagesSentByUser(userId));
    }

    @GetMapping("/received/{volunteerId}")
    @PreAuthorize("hasAnyRole('USER', 'VOLUNTEER')")
    public ResponseEntity<List<MessageModel>> getReceivedMessages(@PathVariable("volunteerId") long volunteerId) {
        return ResponseEntity.ok(messageService.getMessagesReceivedByVolunteer(volunteerId));
    }
    

}
