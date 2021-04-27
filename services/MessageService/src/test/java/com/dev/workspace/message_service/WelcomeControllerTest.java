package com.dev.workspace.message_service;

import com.dev.workspace.message_core.MessageCore;
import com.dev.workspace.message_service.controller.WelcomeController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class WelcomeControllerTest {

    @Value("${core.message}")
    private String message;

    @Autowired
    private MessageCore core;

    @Test
    void greatShouldReturnEnvMessage() {
        var controller = new WelcomeController(new MessageCore());

        assertThat(controller.greet()).isEqualTo(message);
    }

}
