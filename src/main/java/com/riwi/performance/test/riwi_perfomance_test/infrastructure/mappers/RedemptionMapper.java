package com.riwi.performance.test.riwi_perfomance_test.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.RedemptionRequest;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.RedemptionResponse;
import com.riwi.performance.test.riwi_perfomance_test.domain.entities.Redemption;

@Mapper(componentModel = "spring", uses = { ProductMapper.class, UserMapper.class, CouponMapper.class })
public interface RedemptionMapper {

        @Mappings({
                        @Mapping(target = "id", ignore = true),
                        @Mapping(target = "redemptionDate", ignore = true),
                        @Mapping(target = "user.id", source = "userId"),
                        @Mapping(target = "product.id", source = "productId"),
                        @Mapping(target = "coupon.id", source = "couponId"),
        })
        Redemption toRedemption(RedemptionRequest redemptionRequest);

        @Mappings({
                        @Mapping(target = "id", source = "id"),
                        @Mapping(target = "redemptionDate", source = "redemptionDate"),
                        @Mapping(target = "user", source = "user"),
                        @Mapping(target = "product", source = "product"),
                        @Mapping(target = "coupon", source = "coupon"),
        })
        RedemptionResponse toRedemptionResponse(Redemption redemption);

}
