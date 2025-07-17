package com.example.meli.userDetails.model;

import java.util.List;

public record UserDetailsDto(
    Long id,
    String username,
    String profileImageUrl,
    List<PaymentMethodDto> paymentMethodsAvailable
    ) {
}
