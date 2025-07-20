package com.example.meli.sellers.model.dto;

public record SellerDto(
    Long id,
    String nickname,
    Float reputationScore,
    Integer totalProductsListed,
    Integer totalSales,
    String imageUrl
) {
}