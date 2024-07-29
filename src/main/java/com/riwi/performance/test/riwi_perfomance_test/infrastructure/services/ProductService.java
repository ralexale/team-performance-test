package com.riwi.performance.test.riwi_perfomance_test.infrastructure.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.ProductRequest;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.ProductResponse;
import com.riwi.performance.test.riwi_perfomance_test.domain.entities.Product;
import com.riwi.performance.test.riwi_perfomance_test.domain.repositories.ProductRepository;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.IProductService;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.mappers.ProductMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

  @Autowired
  private final ProductRepository productRepository;

  @Autowired
  private final ProductMapper productMapper;

  @Override
  public ProductResponse create(ProductRequest request) {
    Product product = productMapper.requestToEntity(request);
    return productMapper.entityToResponse(productRepository.save(product));
  }

  @Override
  public Optional<ProductResponse> getById(UUID id) {
    Optional<Product> product = productRepository.findById(id);

    return product.map(productMapper::entityToResponse);
  }

  @Override
  public Page<ProductResponse> getAll(Pageable pageable) {
    Page<Product> products = productRepository.findAll(pageable);

    return products.map(productMapper::entityToResponse);
  }

}
