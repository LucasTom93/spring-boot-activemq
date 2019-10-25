package com.lukasz.sender;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukasz.domain.ApplicationMessage;

@RestController
@RequestMapping("/message")
class MessageController {

    private final MessageService messageService;

    MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    void create(@RequestBody ApplicationMessage applicationMessage) {
        messageService.send(applicationMessage);
    }
}
