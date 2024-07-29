package com.riwi.performance.test.riwi_perfomance_test.infrastructure.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.CupponsReq;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.CupponsResp;

import com.riwi.performance.test.riwi_perfomance_test.domain.entities.Cupon;

import org.mapstruct.MappingConstants;



@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CupponsMapper extends GenericMapper<CupponsReq,CupponsResp,Cupon>{


        @Mappings({
        @Mapping(target = "id", ignore= true),
        @Mapping(target = "status", ignore= true)
    })
    Cupon toUserEntity(CupponsReq userRequest);

    @InheritInverseConfiguration
    CupponsReq toCupponRequest(Cupon cuppon);

    CupponsResp toCupponToResponse(Cupon cupon);
    
}
