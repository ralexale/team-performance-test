package com.riwi.performance.test.riwi_perfomance_test.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.performance.test.riwi_perfomance_test.domain.entities.Cupon;

public interface CupponsRepository extends JpaRepository<Cupon,UUID>{
    
}
