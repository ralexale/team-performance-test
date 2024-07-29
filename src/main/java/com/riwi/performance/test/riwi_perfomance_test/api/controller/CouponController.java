package com.riwi.performance.test.riwi_perfomance_test.api.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.CouponRequest;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.CouponResponse;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.update.CouponUpdateRequest;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.ICouponService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/coupons")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class CouponController {

    private final ICouponService couponsService;

    @PostMapping
    @Operation(summary = "create new coupons", description = "Returns cuppon created.")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation. Returns the paginated list of suppliers."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur if the parameters are incorrect.")
    })
    public ResponseEntity<CouponResponse> create(
            @Validated @RequestBody CouponRequest request) {
        return ResponseEntity.ok(this.couponsService.create(request));
    }

    @GetMapping
    @Operation(summary = "List all coupons", description = "Returns a paginated list of all coupons.")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation. Returns the paginated list of suppliers."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur if the parameters are incorrect.")
    })
    public ResponseEntity<Page<CouponResponse>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(couponsService.getAll(pageable));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete coupons", description = "not content to return")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation. Returns the paginated list of suppliers."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur if the parameters are incorrect.")
    })
    public ResponseEntity<Void> deletecoupons(@PathVariable UUID id) {
        couponsService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update coupons", description = "Returns cuppon Update")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation. Returns the paginated list of suppliers."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur if the parameters are incorrect.")
    })
    public ResponseEntity<CouponResponse> updatecoupons(@PathVariable UUID id,
            @Validated @RequestBody CouponUpdateRequest cuponsReq) {
        return ResponseEntity.ok(couponsService.update(id, cuponsReq));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CouponResponse>> getCoupon(
            @PathVariable UUID id) {
        return ResponseEntity.ok(couponsService.getById(id));
    }

}
