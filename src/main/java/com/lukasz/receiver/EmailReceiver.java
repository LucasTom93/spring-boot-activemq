package com.lukasz.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.lukasz.domain.Email;

@Component
class EmailReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailReceiver.class);

    @JmsListener(destination = "mailbox", containerFactory = "listenerContainerFactory")
    void receiveEmail(Email email) {
        LOGGER.info("Received: {}", email);
    }
}
