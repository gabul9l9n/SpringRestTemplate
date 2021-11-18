package org.spring.controller;

import org.spring.model.dto.user.UserDto;
import org.spring.service.JsonPlaceholderUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class JsonPlaceholderUserController {
    private final JsonPlaceholderUserService userService;

    public JsonPlaceholderUserController(JsonPlaceholderUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void saveUsers() {
        userService.saveAll();
    }
}