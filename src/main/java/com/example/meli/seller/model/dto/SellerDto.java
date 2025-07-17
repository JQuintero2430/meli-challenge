package com.example.meli.seller.model.dto;

import lombok.Builder;

@Builder
public record SellerDto(
    Long id,
    String nickname,
    Float reputationScore,
    Integer totalProductsListed,
    Integer totalSales,
    String imageUrl
) {
}