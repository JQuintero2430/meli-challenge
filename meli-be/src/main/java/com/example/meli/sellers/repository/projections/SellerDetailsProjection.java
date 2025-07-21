package com.example.meli.sellers.repository.projections;

public interface SellerDetailsProjection {
  Long getId();
  String getNickname();
  Float getReputationScore();
  Integer getTotalProductsListed();
  Integer getTotalSales();
  String getImageUrl();
}
