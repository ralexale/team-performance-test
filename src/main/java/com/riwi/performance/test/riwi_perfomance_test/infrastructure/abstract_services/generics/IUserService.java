package com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.request.UserRequest;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.response.UserResponse;

public interface IUserService extends CreateService<UserRequest,UserResponse>{

}
