package com.jwinton.auth.presentation.controllers;

import com.jwinton.auth.application.services.UserService;
import com.jwinton.auth.infrastructure.entities.User;
import com.jwinton.auth.presentation.dto.request.UserCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public User createUser(@RequestBody UserCreationRequest request) {
        return userService.createRequest(request);
    }

    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
