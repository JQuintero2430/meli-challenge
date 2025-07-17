package com.example.meli.seller.controller;

import com.example.meli.seller.model.dto.SellerDto;
import com.example.meli.seller.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seller")
public class SellerController {

  private final SellerService sellerService;

  @GetMapping("{id}")
  public SellerDto getSellerDetailsDto(Long id) {
    return sellerService.getSellerDetailsDto(id);
  }
}
