package com.example.meli.paymentmethod.model.dto;

public record PaymentMethodDto(
    Long id,
    String provider,
    String countryCode,
    String type,
    String imageUrl
) {
}
