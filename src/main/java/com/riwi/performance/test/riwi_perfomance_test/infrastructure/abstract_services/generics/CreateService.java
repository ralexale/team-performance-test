package com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics;

public interface CreateService<Request, Response> {
    Response create(Request request);
}