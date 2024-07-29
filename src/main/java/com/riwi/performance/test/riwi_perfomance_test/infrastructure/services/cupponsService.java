package com.riwi.performance.test.riwi_perfomance_test.infrastructure.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.CupponsReq;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.CupponsResp;
import com.riwi.performance.test.riwi_perfomance_test.domain.entities.Cupon;
import com.riwi.performance.test.riwi_perfomance_test.domain.repositories.CupponsRepository;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.mappers.CupponsMapper;
import com.riwi.performance.test.riwi_perfomance_test.utils.enums.statuCuppons;

import lombok.AllArgsConstructor;




@Service
@AllArgsConstructor
public class cupponsService implements IcupponsService{

    @Autowired
    private final CupponsMapper CupponsMapper;
    @Autowired
    private final CupponsRepository cupponsRepository;


    @Override
    public CupponsResp create(CupponsReq request) {
        Cupon cupon = CupponsMapper.toUserEntity(request);
        cupon.setStatus(statuCuppons.values()[0]);
        return CupponsMapper.toUserResponse((this.cupponsRepository.save(cupon)));
    }

    @Override
    public Page<CupponsResp> getAll(Pageable pageable) {
        return cupponsRepository.findAll(pageable).map(CupponsMapper::toUserResponse);
    }

    @Override
    public CupponsResp update(UUID id, CupponsReq request) {
        Cupon cupon = this.find(id);
        cupon = CupponsMapper.toUserEntity(request);
        cupon.setId(id);

        return CupponsMapper.toUserResponse(this.cupponsRepository.save(cupon));
    }

    @Override
    public void delete(UUID id) {
        Cupon cupon = this.find(id);
        cupponsRepository.delete(cupon);;
    }

    @Override
    public Optional<CupponsResp> getById(UUID id) {
        Optional<Cupon> question = Optional.ofNullable(this.find(id));
        return question.map(CupponsMapper::toUserResponse);
    }

    public Cupon find(UUID id){
        return cupponsRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuppon not found"));
    }
}
