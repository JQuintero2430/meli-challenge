package com.example.meli.products.controller;

import com.example.meli.products.model.dto.ProductDto;
import com.example.meli.products.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

  @Mock
  private ProductService productService;

  @InjectMocks
  private ProductController productController;

  private ProductDto expectedProduct;

  @BeforeEach
  void setUp() {
    expectedProduct = new ProductDto(
        1L,
        "Test Product",
        "test-slug",
        "This is a test product description.",
        BigDecimal.valueOf(100.00),
        10,
        "ropa",
        Map.of("color", "red", "size", "M")
    );
  }

  @Test
  void getProductBySlugAndId_ShouldReturnProduct() {
    Long productId = 1L;
    String slug = "test-slug";
    when(productService.getProductById(productId)).thenReturn(expectedProduct);

    ProductDto result = productController.getProductBySlugAndId(slug, productId);

    assertThat(result).isNotNull();
    assertThat(result).isEqualTo(expectedProduct);
    verify(productService).getProductById(productId);
  }
}
