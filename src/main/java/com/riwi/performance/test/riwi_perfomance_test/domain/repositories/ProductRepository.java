package com.riwi.performance.test.riwi_perfomance_test.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.performance.test.riwi_perfomance_test.domain.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

}
