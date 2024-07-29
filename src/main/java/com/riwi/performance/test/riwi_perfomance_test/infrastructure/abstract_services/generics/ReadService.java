package com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics;

import java.util.Optional;

public interface ReadService<Response, Id> {
    Optional<Response> getById(Id id);
}