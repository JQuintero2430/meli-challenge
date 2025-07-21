package com.example.meli.sellers.service.impl;

import com.example.meli.sellers.model.dto.SellerDto;
import com.example.meli.sellers.model.mapper.SellerMapper;
import com.example.meli.sellers.repository.SellerRepository;
import com.example.meli.sellers.service.SellerService;
import com.example.meli.utils.exception.AppException;
import com.example.meli.utils.exception.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

import static com.example.meli.utils.Constants.SELLER_FILE_PATH;

@Slf4j
@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

  private final SellerRepository sellerRepository;

  @Override
  public SellerDto getSellerDto(Long sellerId) {
    return sellerRepository.findSellerProjectionById(sellerId)
        .map(SellerMapper.INSTANCE::toDto)
        .orElseThrow(() -> new ResourceNotFoundException("Seller not found with id: " + sellerId));
  }
}
