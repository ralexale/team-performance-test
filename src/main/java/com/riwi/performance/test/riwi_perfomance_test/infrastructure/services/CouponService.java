package com.riwi.performance.test.riwi_perfomance_test.infrastructure.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.CouponRequest;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.CouponResponse;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.update.CouponUpdateRequest;
import com.riwi.performance.test.riwi_perfomance_test.domain.entities.Coupon;
import com.riwi.performance.test.riwi_perfomance_test.domain.repositories.CouponRepository;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.ICouponService;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.mappers.CouponMapper;
import com.riwi.performance.test.riwi_perfomance_test.utils.enums.StatusCoupon;
import com.riwi.performance.test.riwi_perfomance_test.utils.exeptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CouponService implements ICouponService {

    @Autowired
    private final CouponMapper couponMapper;

    @Autowired
    private final CouponRepository couponRepository;

    @Override
    public CouponResponse create(CouponRequest request) {
        Coupon coupon = couponMapper.toCoupon(request);

        coupon.setStatus(StatusCoupon.ACTIVE);
        couponRepository.save(coupon);

        return couponMapper.toCouponToResponse(coupon);
    }

    @Override
    public Page<CouponResponse> getAll(Pageable pageable) {
        return couponRepository.findAll(pageable).map(couponMapper::toCouponToResponse);
    }

    @Override
    public CouponResponse update(UUID id, CouponUpdateRequest request) {
        Coupon coupon = this.find(id);

        couponMapper.updateFromCouponRequest(request, coupon);
    
        return couponMapper.toCouponToResponse(this.couponRepository.save(coupon));
    }

    @Override
    public void delete(UUID id) {
        Coupon coupon = this.find(id);
        couponRepository.delete(coupon);
        ;
    }

    @Override
    public Optional<CouponResponse> getById(UUID id) {
        Optional<Coupon> coupon = Optional.ofNullable(this.find(id));
        if (coupon.isEmpty())
            throw new IdNotFoundException("Coupon", id);
        return coupon.map(couponMapper::toCouponToResponse);
    }

    public Coupon find(UUID id) {
        return couponRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuppon not found"));
    }
}
