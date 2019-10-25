package com.lukasz.sender;

import com.lukasz.domain.ApplicationMessage;

interface MessageService {

    void send(ApplicationMessage applicationMessage);
}
