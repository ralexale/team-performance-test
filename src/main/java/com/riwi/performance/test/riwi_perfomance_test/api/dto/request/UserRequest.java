package com.riwi.performance.test.riwi_perfomance_test.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "The name is required")
    @Size(min = 4, max = 50, message = "The name must be between 4 and 50 characters")
    private String name;

    @Email
    @NotBlank(message = "The email is required")
    private String email;
    
    @NotBlank(message = "The phone is requered")
    @Size(min = 10, max = 15, message = "The phone must be between 10 and 15 characters")
    private String phone;

    @NotBlank(message = "The password is requered")
    @Size(min = 5, max = 15, message = "The password must be between 10 and 15 characters")
    private String password;


}