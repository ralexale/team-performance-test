package com.riwi.performance.test.riwi_perfomance_test.infrastructure.abstract_services.generics;

public interface DeleteService<Id> {
    void delete(Id id);
}