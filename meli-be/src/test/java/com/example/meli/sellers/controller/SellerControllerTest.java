package com.example.meli.sellers.controller;

import com.example.meli.sellers.model.dto.SellerDto;
import com.example.meli.sellers.service.SellerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SellerControllerTest {

  @InjectMocks
  private SellerController sellerController;

  @Mock
  private SellerService sellerService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testGetSellerDto() {
    Long sellerId = 123L;

    SellerDto expectedSellerDto = new SellerDto(
        123L,
        "test_seller",
        4.5f,
        100,
        50,
        "http://example.com/image.jpg"
            );

    when(sellerService.getSellerDto(sellerId)).thenReturn(expectedSellerDto);

    SellerDto actualSellerDto = sellerController.getSellerDto(sellerId);

    assertEquals(expectedSellerDto, actualSellerDto);
    verify(sellerService, times(1)).getSellerDto(sellerId);
  }
}