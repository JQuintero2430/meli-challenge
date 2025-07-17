package com.example.meli.seller.model.dto;

public record AddressDto(
    String street,
    String city,
    String state,
    String country,
    String zipCode
) {
}
