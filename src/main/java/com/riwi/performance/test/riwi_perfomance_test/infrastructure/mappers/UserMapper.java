package com.riwi.performance.test.riwi_perfomance_test.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.UserRequest;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.UserResponse;
import com.riwi.performance.test.riwi_perfomance_test.domain.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    
    User requestToEntity(UserRequest request);

    UserResponse entityToResponse(User entity);
}

