package com.example.meli.product.controller;

import com.example.meli.product.model.dto.ProductDto;
import com.example.meli.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  @GetMapping("{slug}")
  public ProductDto getProductBySlugAndId(@PathVariable String slug, @RequestParam("productId") Long productId) {
    return productService.getProductBySlugAndId(slug, productId);
  }
}
