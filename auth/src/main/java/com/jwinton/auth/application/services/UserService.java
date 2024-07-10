package com.jwinton.auth.application.services;

import com.jwinton.auth.infrastructure.entities.UserEntity;
import com.jwinton.auth.presentation.dto.request.UserCreationRequest;
import com.jwinton.auth.presentation.dto.request.UserUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jwinton.auth.infrastructure.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity createRequest(UserCreationRequest request) {
        UserEntity newUserEntity = new UserEntity();
        newUserEntity.setUsername(request.getUsername());
        newUserEntity.setPassword(request.getPassword());
        newUserEntity.setFirstName(request.getFirstName());
        newUserEntity.setLastName(request.getLastName());
        newUserEntity.setEmail(request.getEmail());
        newUserEntity.setDob(request.getDob());
        return userRepository.save(newUserEntity);
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUser(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public UserEntity updateUser(String userId ,UserUpdateRequest request) {
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        if (userEntity == null) {
            return null;
        }
        userEntity.setPassword(request.getPassword());
        userEntity.setFirstName(request.getFirstName());
        userEntity.setLastName(request.getLastName());
        userEntity.setEmail(request.getEmail());
        userEntity.setDob(request.getDob());
        return userRepository.save(userEntity);
    }
}
