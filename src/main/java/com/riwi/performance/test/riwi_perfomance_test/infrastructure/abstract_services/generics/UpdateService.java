package com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics;

public interface UpdateService<Request, Response, Id> {
    Response update(Id id, Request request);
}