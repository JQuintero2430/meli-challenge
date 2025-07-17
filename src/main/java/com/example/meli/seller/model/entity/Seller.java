package com.example.meli.seller.model.entity;

import com.example.meli.seller.model.dto.AddressDto;

import java.time.LocalDateTime;

public class Seller {
  private Long id;
  private String nickname;
  private String email;
  private String phoneNumber;
  private AddressDto address;
  private Float reputationScore;
  private Integer totalReviews;
  private Integer totalProductsListed;
  private Integer totalProductsSold;
  private Integer totalPositiveFeedback;
  private Integer totalNegativeFeedback;
  private Integer totalNeutralFeedback;
  private Integer totalSales;
  private Integer totalReturns;
  private String imageUrl;
  private String status;
  private LocalDateTime registrationDateTime;
  private Boolean isVerified;
}
