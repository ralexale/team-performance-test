package com.riwi.performance.test.riwi_perfomance_test.infrastructure.mappers;




public interface  GenericMapper <RequestDTO, ResponseDTO, Entity>{
    Entity toUserEntity(RequestDTO userRequest);
    ResponseDTO toUserResponse(Entity userEntity);
}
