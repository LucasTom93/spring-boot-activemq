package com.lukasz.sender;

import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.lukasz.domain.ApplicationMessage;
import com.lukasz.domain.MessageInfo;

@Service
class RestMessageService implements MessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestMessageService.class);

    private final JmsTemplate jmsTemplate;

    RestMessageService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void send(ApplicationMessage applicationMessage) {
        LOGGER.info("Sending message {}", applicationMessage);
        var activeMqTopic = new ActiveMQTopic(MessageInfo.TOPIC_NAME);
        jmsTemplate.convertAndSend(activeMqTopic, applicationMessage);
    }
}
