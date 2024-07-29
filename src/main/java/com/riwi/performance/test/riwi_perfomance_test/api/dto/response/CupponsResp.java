package com.riwi.performance.test.riwi_perfomance_test.api.dto.response;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

import com.riwi.performance.test.riwi_perfomance_test.utils.enums.statuCuppons;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CupponsResp {
    private UUID id;
    private String code;
    private float percentage;
    private LocalDateTime expiration_time;
    private statuCuppons status;
}
