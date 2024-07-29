package com.riwi.performance.test.riwi_perfomance_test.infrastructure.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.RedemptionRequest;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.RedemptionResponse;
import com.riwi.performance.test.riwi_perfomance_test.domain.entities.Coupon;
import com.riwi.performance.test.riwi_perfomance_test.domain.entities.Redemption;
import com.riwi.performance.test.riwi_perfomance_test.domain.repositories.CouponRepository;
import com.riwi.performance.test.riwi_perfomance_test.domain.repositories.RedemptionRepository;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.IRedemptionService;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.mappers.RedemptionMapper;
import com.riwi.performance.test.riwi_perfomance_test.utils.enums.StatusCoupon;
import com.riwi.performance.test.riwi_perfomance_test.utils.exeptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RedemptionService implements IRedemptionService {

    @Autowired
    private final RedemptionRepository redemptionRepository;

    @Autowired
    private final RedemptionMapper redemptionMapper;

    @Autowired
    private final CouponRepository couponRepository;

    @Override
    @Transactional
    public RedemptionResponse create(RedemptionRequest request) {

        Redemption redemption = redemptionMapper.toRedemption(request);

        Coupon coupon = couponRepository.findById(request.getCouponId())
                .orElseThrow(() -> new IdNotFoundException("survey", request.getCouponId()));

        coupon.setStatus(StatusCoupon.EXPIRED);

        redemption.setRedemptionDate(LocalDateTime.now());

        redemptionRepository.save(redemption);

        return redemptionMapper.toRedemptionResponse(redemption);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RedemptionResponse> getById(UUID id) {
        Optional<Redemption> redemption = redemptionRepository.findById(id);
        if (redemption.isEmpty())
            throw new IdNotFoundException("Redemption", id);

        return redemption.map(redemptionMapper::toRedemptionResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RedemptionResponse> getAll(Pageable pageable) {
        Page<Redemption> redemptions = redemptionRepository.findAll(pageable);

        return redemptions.map(redemptionMapper::toRedemptionResponse);
    }

    @Override
    public Page<RedemptionResponse> findAllByUserId(Pageable pageable, UUID id) {
        Page<Redemption> redemptions = redemptionRepository.findAllByUserId(null, id);

        return redemptions.map(redemptionMapper::toRedemptionResponse);
    }

}
