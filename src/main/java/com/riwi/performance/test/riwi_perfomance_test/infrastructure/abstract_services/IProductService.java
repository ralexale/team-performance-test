package com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services;

import java.util.UUID;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.ProductRequest;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.ProductResponse;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.CreateService;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.ReadAllService;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.ReadService;

public interface IProductService extends CreateService<ProductRequest, ProductResponse>,
    ReadService<ProductResponse, UUID>,
    ReadAllService<ProductResponse> {

}
