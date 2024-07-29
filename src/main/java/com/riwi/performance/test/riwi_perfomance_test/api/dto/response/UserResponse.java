package com.riwi.performance.test.riwi_perfomance_test.api.dto.response;


import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;  
    private String name;
    private String email;
    private String phone;

}
