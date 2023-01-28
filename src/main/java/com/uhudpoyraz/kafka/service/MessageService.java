package com.uhudpoyraz.kafka.service;

import com.uhudpoyraz.kafka.request.SendMessageRequest;


public interface MessageService {

    void sendMessage(SendMessageRequest sendMessageRequest);

}
