package com.riwi.performance.test.riwi_perfomance_test.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.ProductRequest;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.ProductResponse;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.IProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private final IProductService productService;

  @Operation(summary = "Get all products")
  @GetMapping
  public ResponseEntity<Page<ProductResponse>> getAllProducts(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "5") int size) {
    Pageable pageable = PageRequest.of(page - 1, size);
    return ResponseEntity.ok(productService.getAll(pageable));
  }

  @Operation(summary = "Create a new product")
  @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
      @Content(mediaType = "application/json")
  })
  @PostMapping
  public ResponseEntity<ProductResponse> createProduct(@Validated @RequestBody ProductRequest rq) {
    return ResponseEntity.ok(productService.create(rq));
  }

}
