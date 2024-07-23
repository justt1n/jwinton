package com.jwinton.auth.mapper;

import com.jwinton.auth.infrastructure.entities.UserEntity;
import com.jwinton.auth.presentation.dto.request.UserCreationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toUserEntity(UserCreationRequest request);
}
