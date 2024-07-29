package com.riwi.performance.test.riwi_perfomance_test.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.riwi.performance.test.riwi_perfomance_test.utils.enums.statuCuppons;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cupons")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cupon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 255,nullable = false)
    private String code;
    private float percentage;
    @Column(nullable = false)
    private LocalDateTime expiration_time;
    @Enumerated(EnumType.STRING)
    private statuCuppons status;




}
