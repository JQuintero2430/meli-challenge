package com.example.meli.products.model.dto;

import java.math.BigDecimal;
import java.util.Map;

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
