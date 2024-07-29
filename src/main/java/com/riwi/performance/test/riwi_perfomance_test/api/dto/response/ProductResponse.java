package com.riwi.performance.test.riwi_perfomance_test.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
  private String id;

  private String name;

  private String description;

  private double price;

}
