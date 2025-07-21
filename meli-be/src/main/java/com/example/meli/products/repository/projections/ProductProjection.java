package com.example.meli.products.repository.projections;

import java.math.BigDecimal;
import java.util.Map;

public interface ProductProjection {
  Long getId();
  String getTitle();
  String getSlug();
  String getDescription();
  BigDecimal getPrice();
  Integer getStock();
  String getCategory();
  Map<String, String> getAttributes();
}
