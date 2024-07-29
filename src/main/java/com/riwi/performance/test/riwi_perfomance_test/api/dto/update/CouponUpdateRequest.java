package com.riwi.performance.test.riwi_perfomance_test.api.dto.update;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.riwi.performance.test.riwi_perfomance_test.utils.enums.StatusCoupon;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CouponUpdateRequest {

    @NotBlank(message = "Code is required")
    @Size(min = 1, max = 255, message = "The code must be between 1 and 255 characters long.")
    private String code;
    @NotNull(message = "percent is required")
    private float percentage;
    @NotNull(message = "expiration time is required")
    @JsonProperty("expiration_time")
    private LocalDateTime expiration_time;

    private StatusCoupon statusCoupon;
}
