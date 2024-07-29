package com.riwi.performance.test.riwi_perfomance_test.infrastructure.services;

import java.util.UUID;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.CupponsReq;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.CupponsResp;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.CreateService;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.DeleteService;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.ReadAllService;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.ReadService;
import com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics.UpdateService;

public interface IcupponsService extends 
        CreateService<CupponsReq, CupponsResp>,
        ReadAllService<CupponsResp>,
        UpdateService<CupponsReq,CupponsResp,UUID>,
        DeleteService<UUID>,
        ReadService<CupponsResp,UUID>
        {    
        public final String FIELD_BY_SORT = "code";
}
