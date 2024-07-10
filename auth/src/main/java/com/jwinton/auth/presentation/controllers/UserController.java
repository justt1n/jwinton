package com.jwinton.auth.presentation.controllers;

import com.jwinton.auth.application.services.UserService;
import com.jwinton.auth.infrastructure.entities.UserEntity;
import com.jwinton.auth.presentation.dto.request.UserCreationRequest;
import com.jwinton.auth.presentation.dto.request.UserUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public UserEntity createUser(@RequestBody UserCreationRequest request) {
        return userService.createRequest(request);
    }

    @GetMapping()
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public UserEntity getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    public UserEntity updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }
}
