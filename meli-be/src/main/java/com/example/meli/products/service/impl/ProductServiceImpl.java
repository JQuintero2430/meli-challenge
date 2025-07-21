package com.example.meli.products.service.impl;

import com.example.meli.products.model.dto.ProductDto;
import com.example.meli.products.model.entity.ProductAttribute;
import com.example.meli.products.model.mapper.ProductMapper;
import com.example.meli.products.repository.ProductRepository;
import com.example.meli.products.service.ProductService;
import com.example.meli.utils.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;

  public ProductDto getProductById(Long productId) {
    return productRepository.findProjectionById(productId)
        .map(projection -> {
          ProductDto productDto = ProductMapper.INSTANCE.toDto(projection);
          Map<String, String> attributes = productRepository.findAttributesByProductId(productId)
              .stream()
              .collect(Collectors.toMap(
                  ProductAttribute::getKey,
                  ProductAttribute::getValue
              ));
          return productDto.withAttributes(attributes);
        })
        .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
  }
}
