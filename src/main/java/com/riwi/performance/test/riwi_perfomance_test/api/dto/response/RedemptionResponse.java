package com.riwi.performance.test.riwi_perfomance_test.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RedemptionResponse {
    private String id;
    private String product;
    private String coupon;
    private String user;
    private LocalDateTime redemptionDate;
    
}
