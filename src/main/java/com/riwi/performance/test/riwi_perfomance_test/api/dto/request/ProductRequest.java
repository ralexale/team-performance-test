package com.riwi.performance.test.riwi_perfomance_test.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

  @NotBlank(message = "Name is required")
  @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
  @Schema(description = "Name of the product", required = true)
  private String name;

  @NotBlank(message = "Description is required")
  @Size(min = 1, max = 1000, message = "Description must be between 1 and 1000 characters")
  @Schema(description = "Description of the product", required = true)
  private String description;

  @Schema(description = "Price of the product", required = true)
  private double price;

}
