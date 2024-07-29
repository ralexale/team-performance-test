package com.riwi.performance.test.riwi_perfomance_test.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.UserRequest;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.UserResponse;
import com.riwi.performance.test.riwi_perfomance_test.domain.repositories.UserRepository;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.IUserService;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.mappers.UserMapper;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class UserService implements IUserService {


    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    @Override
    public UserResponse create(UserRequest request) {
        return this.userMapper.entityToResponse(this.userRepository.save(this.userMapper.requestToEntity(request)));
    }

    @Override
    public Page<UserResponse> getAll(Pageable pageable) {
        return this.userRepository.findAll(pageable).map(this.userMapper::entityToResponse);
    }
    
}
