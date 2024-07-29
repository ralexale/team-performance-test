package com.riwi.performance.test.riwi_perfomance_test.api.controller;

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

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.CupponsReq;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.CupponsResp;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.services.cupponsService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/cuupons")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class cupponController {


    private final cupponsService cupponsService;
    

    @PostMapping
    @Operation(summary = "create new cuppons",
    description = "Returns cuppon created.")

    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Successful operation. Returns the paginated list of suppliers."),
    @ApiResponse(responseCode = "400", description = "Bad request. This may occur if the parameters are incorrect.")
})
    public ResponseEntity<CupponsResp> create(
       @Validated @RequestBody CupponsReq request) {
        return ResponseEntity.ok(this.cupponsService.create(request));
    }


    
    @GetMapping
     @Operation(summary = "List all cuppons",
                description = "Returns a paginated list of all cuppons.")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation. Returns the paginated list of suppliers."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur if the parameters are incorrect.")
    })
    public ResponseEntity<Page<CupponsResp>> findAll(  
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) 
            {
            Pageable pageable = PageRequest.of(page, size);
            if (page != 0) pageable = PageRequest.of(page - 1, size);
            return  ResponseEntity.ok(cupponsService.getAll(pageable));
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete cuppons",
    description = "not content to return")

    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Successful operation. Returns the paginated list of suppliers."),
    @ApiResponse(responseCode = "400", description = "Bad request. This may occur if the parameters are incorrect.")
})
    public ResponseEntity<Void> deleteCuppons(@PathVariable UUID id) {
        cupponsService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}/cuupons")
    @Operation(summary = "Update cuppons",
    description = "Returns cuppon Update")

    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Successful operation. Returns the paginated list of suppliers."),
    @ApiResponse(responseCode = "400", description = "Bad request. This may occur if the parameters are incorrect.")
})
    public ResponseEntity<CupponsResp> updateCuppons(@PathVariable UUID id, @Validated @RequestBody CupponsReq cuponsReq) {
        return ResponseEntity.ok(cupponsService.update(id, cuponsReq));
    }







}