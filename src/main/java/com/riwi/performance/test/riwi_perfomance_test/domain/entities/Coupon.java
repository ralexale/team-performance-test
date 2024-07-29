package com.riwi.performance.test.riwi_perfomance_test.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.riwi.performance.test.riwi_perfomance_test.utils.enums.StatusCoupon;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 255, nullable = false)
    private String code;

    private float percentage;
    @Column(nullable = false)
    private LocalDateTime expiration_time;

    @Enumerated(EnumType.STRING)
    private StatusCoupon status;

}
