package com.jwinton.auth.presentation.controllers;

import com.jwinton.auth.application.services.UserService;
import com.jwinton.auth.infrastructure.entities.UserEntity;
import com.jwinton.auth.infrastructure.repositories.UserRepository;
import com.jwinton.auth.presentation.dto.request.UserCreationRequest;
import com.jwinton.auth.presentation.dto.request.UserUpdateRequest;
import com.jwinton.auth.presentation.dto.response.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.executable.ValidateOnExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ApiResponse<UserEntity> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<UserEntity> response = new ApiResponse<>();

        response.setMessage("User created");
        response.setResult(userService.createRequest(request));

        return response;
    }

    @GetMapping()
    public ApiResponse<List<UserEntity>> getUsers() {
        ApiResponse<List<UserEntity>> response = new ApiResponse<>();

        response.setMessage("Users retrieved");
        response.setResult(userService.getUsers());

        return response;
    }

    @GetMapping("/{userId}")
    public ApiResponse<UserEntity> getUser(@PathVariable String userId) {
        ApiResponse<UserEntity> response = new ApiResponse<>();

        response.setMessage("User retrieved");
        response.setResult(userService.getUser(userId));

        return response;
    }

    @PutMapping("/{userId}")
    public ApiResponse<UserEntity> updateUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request) {
        ApiResponse<UserEntity> response = new ApiResponse<>();

        response.setMessage("User updated");
        response.setResult(userService.updateUser(userId, request));

        return response;
    }

    @DeleteMapping("/{userId}")
    public ApiResponse<String> deleteUser(@PathVariable String userId) {
        ApiResponse<String> response = new ApiResponse<>();

        response.setMessage("User deleted");
        response.setResult(userService.deleteUser(userId));

        return response;
    }
}
