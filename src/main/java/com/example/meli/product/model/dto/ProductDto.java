package com.example.meli.product.model.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.Map;

@Builder
public record ProductDto(
    Long id,
    String title,
    String slug,
    String description,
    BigDecimal price,
    Integer stock,
    String category,
    Map<String, String> attributes
) {
}
