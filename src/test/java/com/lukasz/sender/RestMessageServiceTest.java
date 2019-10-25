package com.lukasz.sender;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import javax.jms.Destination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jms.core.JmsTemplate;

import com.lukasz.domain.ApplicationMessage;

@ExtendWith(MockitoExtension.class)
class RestMessageServiceTest {

    @Mock
    private JmsTemplate jmsTemplate;

    private RestMessageService restMessageService;

    @BeforeEach
    void setUp() {
        restMessageService = new RestMessageService(jmsTemplate);
    }

    @Test
    void thatSendWorksWithGivenMessage() {
        //given
        var recipient = "test@gmail.com";
        var messageContent = "Test message";
        var applicationMessage = ApplicationMessage.of(recipient, messageContent);

        //when
        restMessageService.send(applicationMessage);

        //then
        verify(jmsTemplate).convertAndSend(any(Destination.class), eq(applicationMessage));
    }
}