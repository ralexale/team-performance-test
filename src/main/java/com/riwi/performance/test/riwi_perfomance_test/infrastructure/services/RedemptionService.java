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
import com.riwi.performance.test.riwi_perfomance_test.domain.entities.Product;
import com.riwi.performance.test.riwi_perfomance_test.domain.entities.Redemption;
import com.riwi.performance.test.riwi_perfomance_test.domain.entities.User;
import com.riwi.performance.test.riwi_perfomance_test.domain.repositories.CouponRepository;
import com.riwi.performance.test.riwi_perfomance_test.domain.repositories.ProductRepository;
import com.riwi.performance.test.riwi_perfomance_test.domain.repositories.RedemptionRepository;
import com.riwi.performance.test.riwi_perfomance_test.domain.repositories.UserRepository;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.IRedemptionService;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.mappers.RedemptionMapper;
import com.riwi.performance.test.riwi_perfomance_test.utils.enums.StatusCoupon;
import com.riwi.performance.test.riwi_perfomance_test.utils.exeptions.IdNotFoundException;

import jakarta.persistence.EntityNotFoundException;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public RedemptionResponse create(RedemptionRequest request) {

        Redemption redemption = redemptionMapper.toRedemption(request);

        Coupon coupon = couponRepository.findById(request.getCouponId())
                .orElseThrow(() -> new IdNotFoundException("COUPON", request.getCouponId()));

        User managedUser = userRepository.findById(redemption.getUser().getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Coupon managedCoupon = couponRepository.findById(redemption.getCoupon().getId())
                .orElseThrow(() -> new EntityNotFoundException("Coupon not found"));
        Product managedProduct = productRepository.findById(redemption.getProduct().getId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        redemption.setUser(managedUser);
        redemption.setCoupon(managedCoupon);
        redemption.setProduct(managedProduct);

        coupon.setStatus(StatusCoupon.EXPIRED);
        coupon.setExpiration_time(LocalDateTime.now());
        ;

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
