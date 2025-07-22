
package com.example.meli.users.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import com.example.meli.paymentmethod.model.dto.PaymentMethodDto;
import com.example.meli.paymentmethod.model.entity.PaymentMethod;
import com.example.meli.paymentmethod.model.mapper.PaymentMethodMapper;
import com.example.meli.users.model.dto.UserDetailsDto;
import com.example.meli.users.model.mapper.UserMapper;
import com.example.meli.users.repository.UserRepository;
import com.example.meli.users.repository.projections.UserDetailsProjection;
import com.example.meli.utils.exception.ResourceNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserDetailsServiceImpl userDetailsService;

  @Test
  @DisplayName("Should throw ResourceNotFoundException when user not found")
  void getUserDetailsByUserId_WhenUserNotFound_ThrowException() {
    Long userId = 999L;
    when(userRepository.findUserDetailsById(userId))
        .thenReturn(Optional.empty());

    ResourceNotFoundException exception = assertThrows(
        ResourceNotFoundException.class,
        () -> userDetailsService.getUserDetailsByUserId(userId)
    );

    assertEquals("User not found with id: " + userId, exception.getMessage());
    verify(userRepository).findUserDetailsById(userId);
    verify(userRepository, never()).findPaymentMethodsByUserId(any());
  }

  private PaymentMethod createPaymentMethod() {
    PaymentMethod paymentMethod = new PaymentMethod();
    paymentMethod.setId(1L);
    paymentMethod.setProvider("Credit Card");
    paymentMethod.setType("CREDIT_CARD");
    paymentMethod.setCountryCode("US");
    paymentMethod.setImageUrl("http://example.com/credit-card.png");
    paymentMethod.setActive(true);
    return paymentMethod;
  }

  private PaymentMethodDto createPaymentMethodDto() {
    return new PaymentMethodDto(
        1L,
        "Credit Card",
        "US",
        "CREDIT_CARD",
        "http://example.com/credit-card.png"
    );
  }

  private UserDetailsDto createUserDetailsDto(PaymentMethodDto paymentMethodDto) {
    return new UserDetailsDto(
        1L,
        "testuser",
        "http://example.com/profile.jpg",
        List.of(paymentMethodDto)
    );
  }
}