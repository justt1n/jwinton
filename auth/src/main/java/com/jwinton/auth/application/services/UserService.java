package com.jwinton.auth.application.services;

import com.jwinton.auth.application.constants.ErrorCode;
import com.jwinton.auth.application.exceptions.AppException;
import com.jwinton.auth.infrastructure.entities.UserEntity;
import com.jwinton.auth.mapper.UserMapper;
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

    @Autowired
    private UserMapper userMapper;
    public UserEntity createRequest(UserCreationRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTS);
        }
        UserEntity newUserEntity = userMapper.toUserEntity(request);

        return userRepository.save(newUserEntity);
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
    }

    public UserEntity updateUser(String userId, UserUpdateRequest request) {
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

    public String deleteUser(String userId) {
        userRepository.deleteById(userId);
        return "User deleted";
    }
}
