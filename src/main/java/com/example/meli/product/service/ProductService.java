package com.example.meli.product.service;

import com.example.meli.product.model.dto.ProductDto;

public interface ProductService {
  ProductDto getProductBySlugAndId(String slug, Long id);
}
