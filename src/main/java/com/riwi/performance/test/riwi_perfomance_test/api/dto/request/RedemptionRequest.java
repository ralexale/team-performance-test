package com.riwi.performance.test.riwi_perfomance_test.api.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RedemptionRequest {

    @NotNull(message = "the user id is necessaryS")
    private UUID userId;

    @NotNull(message = "the coupon is required")
    private UUID couponId;

    @NotNull(message = "the product id is required")
    private UUID productId;

}
