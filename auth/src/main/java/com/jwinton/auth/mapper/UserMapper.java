package com.jwinton.auth.mapper;

import com.jwinton.auth.infrastructure.entities.UserEntity;
import com.jwinton.auth.presentation.dto.request.UserCreationRequest;
import com.jwinton.auth.presentation.dto.request.UserUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toUserEntity(UserCreationRequest request);

    UserEntity updateUserEntity(@MappingTarget UserEntity user , UserUpdateRequest request);
}
