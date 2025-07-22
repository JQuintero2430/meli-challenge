package com.example.meli.products.service.impl;

import com.example.meli.products.model.dto.ProductDto;
import com.example.meli.products.model.entity.ProductAttribute;
import com.example.meli.products.model.mapper.ProductMapper;
import com.example.meli.products.repository.ProductRepository;
import com.example.meli.products.repository.projections.ProductProjection;
import com.example.meli.utils.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

  @Mock
  private ProductRepository productRepository;

  @InjectMocks
  private ProductServiceImpl productService;

  @Test
  void getProductById_shouldReturnProductDto_whenProductExists() {
    Long productId = 1L;

    ProductProjection projection = mock(ProductProjection.class);

    List<ProductAttribute> attributes = new ArrayList<>();

    ProductAttribute attr1 = new ProductAttribute();  attr1.setKey("color");
    attr1.setValue("red");
    attributes.add(attr1);

    ProductAttribute attr2 = new ProductAttribute();
    attr2.setKey("storage");
    attr2.setValue("128GB");
    attributes.add(attr2);

    try (MockedStatic<ProductMapper> mapperMockedStatic = mockStatic(ProductMapper.class)) {

      when(productRepository.findProjectionById(productId)).thenReturn(Optional.of(projection));
      when(productRepository.findAttributesByProductId(productId)).thenReturn(attributes);

      ProductDto result = productService.getProductById(productId);

      assertNotNull(result);

      verify(productRepository).findProjectionById(productId);
      verify(productRepository).findAttributesByProductId(productId);
    }
  }

  @Test
  void getProductById_shouldThrowException_whenProductNotFound() {
    Long productId = 99L;
    when(productRepository.findProjectionById(productId)).thenReturn(Optional.empty());

    ResourceNotFoundException exception = assertThrows(        ResourceNotFoundException.class,
        () -> productService.getProductById(productId)
    );

    assertEquals("Product not found with id: 99", exception.getMessage());
    verify(productRepository).findProjectionById(productId);   verify(productRepository, never()).findAttributesByProductId(any());

  }
}
