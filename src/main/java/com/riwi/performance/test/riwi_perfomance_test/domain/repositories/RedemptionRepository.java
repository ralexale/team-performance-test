package com.riwi.performance.test.riwi_perfomance_test.domain.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.performance.test.riwi_perfomance_test.domain.entities.Redemption;

@Repository
public interface RedemptionRepository extends JpaRepository<Redemption, UUID> {

    Page<Redemption> findAllByUserId(Pageable pagleable, UUID userId);
}
