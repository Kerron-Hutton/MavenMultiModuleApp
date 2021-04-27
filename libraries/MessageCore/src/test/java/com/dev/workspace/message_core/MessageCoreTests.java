package com.dev.workspace.message_core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest("core.message=abcd")
class MessageCoreTests {

    @Value("${core.message}")
    private String message;

    @SpringBootApplication
    static class TestConfiguration {
    }

    @Test
    public void welcomeMessage() {
        assertThat(message).isNotNull();
        assertThat(message).isEqualTo("abcd");
    }

}
