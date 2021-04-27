package com.dev.workspace.message_service.controller;

import com.dev.workspace.message_core.MessageCore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/")
@RequiredArgsConstructor
public class WelcomeController {
    private final MessageCore core;

    @GetMapping
    public String greet() {
        log.info("New user visited our api");
        return core.welcome();
    }
}
