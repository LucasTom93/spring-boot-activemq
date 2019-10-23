package com.lukasz.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.lukasz.domain.Email;

@Component
class SenderBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SenderBootstrap.class);

    private final JmsTemplate jmsTemplate;

    SenderBootstrap(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Email message = Email.of("test@gmail.com", "Test message");
        LOGGER.info("Sending message {}", message);
        jmsTemplate.convertAndSend("mailbox", message);
    }
}
