package com.example.meli.users.model.dto;

import com.example.meli.paymentmethod.model.dto.PaymentMethodDto;

import java.util.List;

public record UserDetailsDto(
    Long id,
    String username,
    String profileImageUrl,
    List<PaymentMethodDto> paymentMethodsAvailable
    ) {
}
