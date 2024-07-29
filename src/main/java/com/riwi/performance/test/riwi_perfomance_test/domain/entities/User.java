package com.riwi.performance.test.riwi_perfomance_test.domain.entities;


import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;  
    @Column(length = 50,nullable = false)
    private String name;
    @Column(length = 100,nullable = false)
    private String email;
    @Column(length = 15,nullable = false)
    private String phone;
    @Column(length = 100,nullable = false)
    private String password;

}
