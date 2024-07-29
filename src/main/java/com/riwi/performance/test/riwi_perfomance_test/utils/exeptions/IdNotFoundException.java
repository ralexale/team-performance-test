package com.riwi.performance.test.riwi_perfomance_test.utils.exeptions;

public class IdNotFoundException extends RuntimeException {
  private static final String ERROR_MESSAGE = "No records found in the entity [%s] with the specified id %s.";

  public IdNotFoundException(String entityName, Long id) {
    super(String.format(ERROR_MESSAGE, entityName, id));
  }
}
