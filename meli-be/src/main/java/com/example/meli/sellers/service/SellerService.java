package com.example.meli.sellers.service;

import com.example.meli.sellers.model.dto.SellerDto;

public interface SellerService {

  SellerDto getSellerDto(Long sellerId);
}
