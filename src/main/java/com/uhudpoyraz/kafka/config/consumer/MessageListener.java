package com.uhudpoyraz.kafka.config.consumer;

import com.uhudpoyraz.kafka.constrant.KafkaConstant;
import com.uhudpoyraz.kafka.request.SendMessageRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @KafkaListener(topics = KafkaConstant.MESSAGE, groupId = KafkaConstant.GROUP)
    public void listenGroupMessage(SendMessageRequest message) {
        System.out.println("Received Message in group " + KafkaConstant.GROUP + ": " + message);
    }
}
