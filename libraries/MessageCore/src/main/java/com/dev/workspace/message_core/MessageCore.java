package com.dev.workspace.message_core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageCore {

    @Value("${core.message}")
    private String message;

    public String welcome() {
        return message;
    }

}
