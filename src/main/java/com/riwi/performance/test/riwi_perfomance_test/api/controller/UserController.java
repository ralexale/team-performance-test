package com.riwi.performance.test.riwi_perfomance_test.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.UserRequest;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.UserResponse;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@AllArgsConstructor
@Tag(name = "UserController", description = "User Controller")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final IUserService userService;

    @GetMapping
    @Operation(summary = "Get All users", description = "Get All users")
    public ResponseEntity<Page<UserResponse>> getAll(@RequestParam( defaultValue = "0")int page,
     @RequestParam( defaultValue = "10")int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (page!=0) pageable = PageRequest.of(page -1, size);
        return ResponseEntity.ok(this.userService.getAll(pageable));
        }
        

    @PostMapping
    @Operation(summary = "Create User", description = "Create User")
    public ResponseEntity<UserResponse> createUser(@Validated @RequestBody UserRequest request) {
        return ResponseEntity.ok(this.userService.create(request));
    }
    
}
