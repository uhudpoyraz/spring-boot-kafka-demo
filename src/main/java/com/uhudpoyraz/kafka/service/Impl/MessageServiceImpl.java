package com.uhudpoyraz.kafka.service.Impl;

import com.uhudpoyraz.kafka.producer.MessageProducer;
import com.uhudpoyraz.kafka.request.SendMessageRequest;
import com.uhudpoyraz.kafka.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {


    private final MessageProducer messageProducer;

    public MessageServiceImpl(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @Override
    public void sendMessage(SendMessageRequest sendMessageRequest) {
        messageProducer.sendMessage(sendMessageRequest);
    }
}
