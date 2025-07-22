package com.example.meli.sellers.service.impl;

import com.example.meli.sellers.model.dto.SellerDto;
import com.example.meli.sellers.model.mapper.SellerMapper;
import com.example.meli.sellers.repository.SellerRepository;
import com.example.meli.sellers.repository.projections.SellerDetailsProjection;
import com.example.meli.utils.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SellerServiceImplTest {

  @Mock
  private SellerRepository sellerRepository;

  @InjectMocks
  private SellerServiceImpl sellerService;

  private SellerDto expectedSellerDto;


  @BeforeEach
  void setUp() {
    expectedSellerDto = new SellerDto(
        1L,
        "testSeller",
        4.5f,
        100,
        50,
        "http://example.com/image.jpg"
    );
  }

  @Test
  @DisplayName("Should return seller DTO when seller exists")
  void getSellerDto_WhenSellerExists_ReturnSellerDto() {
    Long sellerId = 1L;
    SellerDetailsProjection sellerProjection = mock(SellerDetailsProjection.class);

    when(sellerProjection.getId()).thenReturn(1L);
    when(sellerProjection.getNickname()).thenReturn("testSeller");
    when(sellerProjection.getReputationScore()).thenReturn(4.5f);
    when(sellerProjection.getTotalProductsListed()).thenReturn(100);
    when(sellerProjection.getTotalSales()).thenReturn(50);
    when(sellerProjection.getImageUrl()).thenReturn("http://example.com/image.jpg");

    when(sellerRepository.findSellerProjectionById(sellerId))
        .thenReturn(Optional.of(sellerProjection));

    SellerDto result = sellerService.getSellerDto(sellerId);

    assertNotNull(result);
    assertEquals(expectedSellerDto.id(), result.id());
    assertEquals(expectedSellerDto.nickname(), result.nickname());
    assertEquals(expectedSellerDto.reputationScore(), result.reputationScore());
    assertEquals(expectedSellerDto.totalProductsListed(), result.totalProductsListed());
    assertEquals(expectedSellerDto.totalSales(), result.totalSales());
    assertEquals(expectedSellerDto.imageUrl(), result.imageUrl());
  }


  @Test
  @DisplayName("Should throw ResourceNotFoundException when seller does not exist")
  void getSellerDto_WhenSellerNotExists_ThrowResourceNotFoundException() {
    Long sellerId = 999L;
    when(sellerRepository.findSellerProjectionById(sellerId))
        .thenReturn(Optional.empty());

    ResourceNotFoundException exception = assertThrows(
        ResourceNotFoundException.class,
        () -> sellerService.getSellerDto(sellerId)
    );

    assertEquals("Seller not found with id: " + sellerId, exception.getMessage());
  }
}
