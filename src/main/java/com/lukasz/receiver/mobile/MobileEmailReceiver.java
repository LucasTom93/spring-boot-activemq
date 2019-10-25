package com.lukasz.receiver.mobile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.lukasz.domain.ApplicationMessage;
import com.lukasz.domain.MessageInfo;

@Component
class MobileEmailReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(MobileEmailReceiver.class);

    @JmsListener(destination = MessageInfo.TOPIC_NAME, containerFactory = "topicListenerFactory")
    void receiveEmail(ApplicationMessage applicationMessage) {
        LOGGER.info("Received: {}", applicationMessage);
    }
}
