package com.example.meli.products.service.impl;

import com.example.meli.products.model.dto.ProductDto;
import com.example.meli.products.model.mapper.ProductMapper;
import com.example.meli.products.repository.ProductRepository;
import com.example.meli.products.service.ProductService;
import com.example.meli.utils.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;

  public ProductDto getProductById(Long productId) {
    return productRepository.findProjectionById(productId)
        .map(ProductMapper.INSTANCE::toDto)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
  }
}
