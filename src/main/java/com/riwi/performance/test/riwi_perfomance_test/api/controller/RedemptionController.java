package com.riwi.performance.test.riwi_perfomance_test.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.RedemptionRequest;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.RedemptionResponse;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.IRedemptionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/redemptions")
@AllArgsConstructor
public class RedemptionController {

    @Autowired
    private IRedemptionService redemptionService;

    @Operation(summary = "creates a new Redemption", description = "create a new Redemption by entering the required data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping
    public ResponseEntity<RedemptionResponse> createRedemption(
            @Validated @RequestBody RedemptionRequest redemptionRequest) {

        return ResponseEntity.ok(redemptionService.create(redemptionRequest));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Page<RedemptionResponse>> getRedemptionsByUserId(
            @PathVariable UUID userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);

        return ResponseEntity.ok(redemptionService.findAllByUserId(pageable, userId));
    }

}
