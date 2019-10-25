package com.lukasz.sender;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.lukasz.domain.ApplicationMessage;

@ExtendWith(MockitoExtension.class)
class MessageControllerTest {

    @Mock
    private MessageService messageService;

    private MessageController messageController;

    @BeforeEach
    void setUp() {
        messageController = new MessageController(messageService);
    }

    @Test
    void thatCreateUsesMessageService() {
        //given
        var messageApplication = mock(ApplicationMessage.class);

        //when
        messageController.create(messageApplication);

        //then
        verify(messageService).send(messageApplication);
    }

    @Test
    void thatCreateHasProperMapping() throws Exception {
        //given
        var mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();
        var jsonRequestBody = "{\"recipientEmail\" : \"john@gmail.com\",\n\"message\" : \"Hi John!\"}";
        var postRequestBuilder = post("/message").contentType(MediaType.APPLICATION_JSON).content(jsonRequestBody);

        //when //then
        mockMvc.perform(postRequestBuilder).andExpect(status().isOk());
    }
}