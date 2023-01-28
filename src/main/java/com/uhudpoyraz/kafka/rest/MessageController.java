package com.uhudpoyraz.kafka.rest;

import com.uhudpoyraz.kafka.request.SendMessageRequest;
import com.uhudpoyraz.kafka.service.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {


    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(path = "send")
    public void SendMessage(@RequestBody SendMessageRequest sendMessageRequest) {
        messageService.sendMessage(sendMessageRequest);
    }
}
