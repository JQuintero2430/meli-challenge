package com.example.meli.products.service;

import com.example.meli.products.model.dto.ProductDto;

public interface ProductService {
  ProductDto getProductBySlugAndId(String slug, Long id);
}
