package com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.RedemptionRequest;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.RedemptionResponse;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.CreateService;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.ReadAllService;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.ReadService;

public interface IRedemptionService extends
                CreateService<RedemptionRequest, RedemptionResponse>,
                ReadService<RedemptionResponse, UUID>,
                ReadAllService<RedemptionResponse> {

        Page<RedemptionResponse> findAllByUserId(Pageable pageable,UUID id);

}
