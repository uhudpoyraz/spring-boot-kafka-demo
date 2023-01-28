package com.uhudpoyraz.kafka.producer;

import com.uhudpoyraz.kafka.constrant.KafkaConstant;
import com.uhudpoyraz.kafka.request.SendMessageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Component
public class MessageProducer {


    private final KafkaTemplate<String, SendMessageRequest> kafkaTemplate;

    public MessageProducer(KafkaTemplate<String, SendMessageRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(SendMessageRequest sendMessageRequest) {

        ListenableFuture<SendResult<String, SendMessageRequest>> future = kafkaTemplate.send(KafkaConstant.MESSAGE, sendMessageRequest);

        future.addCallback(new ListenableFutureCallback<SendResult<String, SendMessageRequest>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + sendMessageRequest.getMessage() + "] due to : " + ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, SendMessageRequest> result) {
                System.out.println("Sent message=[" + sendMessageRequest.getMessage() +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
        });

    }
}
