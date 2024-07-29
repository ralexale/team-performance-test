package com.riwi.performance.test.riwi_perfomance_test.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.ProductRequest;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.ProductResponse;
import com.riwi.performance.test.riwi_perfomance_test.domain.entities.Product;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

  @Mapping(target = "id", ignore = true)
  Product requestToEntity(ProductRequest request);

  ProductResponse entityToResponse(Product product);

}
