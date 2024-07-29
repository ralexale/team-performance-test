package com.riwi.performance.test.riwi_perfomance_test.api.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.riwi.performance.test.riwi_perfomance_test.utils.enums.StatusCoupon;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CouponResponse {
    private UUID id;
    private String code;
    private float percentage;
    private LocalDateTime expiration_time;
    private StatusCoupon status;
}
