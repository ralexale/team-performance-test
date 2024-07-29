package com.riwi.performance.test.riwi_perfomance_test.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.UserRequest;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.UserResponse;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@AllArgsConstructor
@Tag(name = "UserController", description = "User Controller")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final IUserService userService;

    @PostMapping
    @Operation(summary = "Create User", description = "Create User")
    public ResponseEntity<UserResponse> createUser(@Validated @RequestBody UserRequest request) {
        return ResponseEntity.ok(this.userService.create(request));
    }
    
}
