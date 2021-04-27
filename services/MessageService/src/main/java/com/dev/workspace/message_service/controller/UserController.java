package com.dev.workspace.message_service.controller;

import com.dev.workspace.message_service.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UserController {
    private final List<User> users;

    public UserController() {
        users = List.of(
                new User(1L, "Kerron Hutton", "kerron100@gmail.com"),
                new User(2L, "Barret Johnson", "b.john@gmail.com"),
                new User(3L, "Marry Grant", "keke@gmail.com"),
                new User(5L, "John Doe", "j.doe@gmail.com")
        );
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        log.info("Request was made to get all users found: {}", users.size());
        return users;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        try {
            var user = users.stream()
                    .filter(u -> u.getId().equals(Long.parseLong(id)))
                    .findAny().orElse(null);

            if (user == null) {
                log.info("User was found with id: {}", id);
                return null;
            }

            log.info("Valid user was found with id: {}", id);
            log.debug("Found user: {}", user);

            return ResponseEntity.ok(user);
        }catch (NumberFormatException ex){
            log.error("Id: {} is not a valid user id", id);
            return ResponseEntity.badRequest().build();
        }
    }
}
