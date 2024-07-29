package com.riwi.performance.test.riwi_perfomance_test.api.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RedemptionRequest {

    @NotBlank(message = "the user id is necessaryS")
    private UUID userId;

    @NotBlank(message = "the coupon is required")
    private UUID couponId;

    @NotBlank(message = "the product id is required")
    private UUID productId;

}
