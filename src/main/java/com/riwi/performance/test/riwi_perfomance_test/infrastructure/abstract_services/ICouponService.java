package com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services;

import java.util.UUID;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.CouponRequest;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.CouponResponse;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.update.CouponUpdateRequest;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.CreateService;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.DeleteService;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.ReadAllService;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.ReadService;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.UpdateService;

public interface ICouponService extends
        CreateService<CouponRequest, CouponResponse>,
        ReadAllService<CouponResponse>,
        UpdateService<CouponUpdateRequest, CouponResponse, UUID>,
        DeleteService<UUID>,
        ReadService<CouponResponse, UUID> {

}
