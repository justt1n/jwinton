package com.jwinton.auth.application.services;

import com.jwinton.auth.infrastructure.entities.User;
import com.jwinton.auth.presentation.dto.request.UserCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jwinton.auth.infrastructure.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createRequest(UserCreationRequest request) {
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(request.getPassword());
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setEmail(request.getEmail());
        newUser.setDob(request.getDob());
        return userRepository.save(newUser);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
