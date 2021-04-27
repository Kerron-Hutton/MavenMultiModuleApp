package com.dev.workspace.message_service.models;

import lombok.Value;

@Value
public class User {
    Long id;

    String name;

    String email;
}
