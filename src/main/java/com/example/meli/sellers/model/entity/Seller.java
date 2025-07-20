package com.example.meli.sellers.model.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity

public class Seller {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;
  private String nickname;
  private String email;
  private String phoneNumber;
  @Embedded
  private Address address;
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
