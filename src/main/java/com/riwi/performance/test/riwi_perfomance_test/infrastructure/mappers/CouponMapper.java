package com.riwi.performance.test.riwi_perfomance_test.infrastructure.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.CouponRequest;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.CouponResponse;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.update.CouponUpdateRequest;
import com.riwi.performance.test.riwi_perfomance_test.domain.entities.Coupon;

import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CouponMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "status", ignore = true)
    })
    Coupon toCoupon(CouponRequest couponRequest);

    @InheritInverseConfiguration
    CouponRequest toCouponRequest(Coupon coupon);

    CouponResponse toCouponToResponse(Coupon coupon);

    @Mapping(target = "status", source = "statusCoupon")
    void updateFromCouponRequest(CouponUpdateRequest couponRequest, @MappingTarget Coupon coupon);

}
