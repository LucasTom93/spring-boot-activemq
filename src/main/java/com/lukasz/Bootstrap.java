package com.lukasz;

import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.lukasz.domain.ApplicationMessage;
import com.lukasz.domain.MessageInfo;

@Component
class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class);

    private final JmsTemplate jmsTemplate;

    Bootstrap(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        var applicationMessage = ApplicationMessage.of("test@gmail.com", "Test message");
        LOGGER.info("Sending message {}", applicationMessage);

        var activeMqTopic = new ActiveMQTopic(MessageInfo.TOPIC_NAME);
        jmsTemplate.convertAndSend(activeMqTopic, applicationMessage);
    }
}
