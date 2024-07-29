package com.riwi.performance.test.riwi_perfomance_test.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.RedemptionRequest;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.RedemptionResponse;
import com.riwi.performance.test.riwi_perfomance_test.domain.entities.Redemption;

@Mapper(componentModel = "spring")
public interface RedemptionMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "redemptionDate", ignore = true),
    })
    Redemption toRedemption(RedemptionRequest redemptionRequest);


    @Mappings({
        @Mapping(target = "id", source = "id"),
        @Mapping(target = "redemptionDate", source = "redemptionDate"),
        @Mapping(target = "user", source = "userId"),
        @Mapping(target = "product", source = "productId"),
        @Mapping(target = "coupon", source = "couponId"),
    })
    RedemptionResponse toRedemptionResponse(Redemption redemption);

}
