package com.lukasz.receiver.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.lukasz.domain.Email;
import com.lukasz.domain.MessageInfo;

@Component
class WebEmailReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebEmailReceiver.class);

    @JmsListener(destination = MessageInfo.TOPIC_NAME, containerFactory = "topicListenerFactory")
    void receiveEmail(Email email) {
        LOGGER.info("Received: {}", email);
    }
}
