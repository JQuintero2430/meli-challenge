package com.example.meli.users.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.meli.paymentmethod.model.dto.PaymentMethodDto;
import com.example.meli.users.model.dto.UserDetailsDto;
import com.example.meli.users.service.UserDetailsService;
import com.example.meli.utils.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserDetailsControllerTest {

  @Mock
  private UserDetailsService userDetailsService;

  @InjectMocks
  private UserDetailsController userDetailsController;

  private UserDetailsDto expectedUserDetails;

  @BeforeEach
  void setUp() {
    PaymentMethodDto paymentMethod = new PaymentMethodDto(
        1L,
        "Credit Card",
        "US",
        "CREDIT_CARD",
        "http://example.com/credit-card.png"
    );

    expectedUserDetails = new UserDetailsDto(
        1L,
        "testuser",
        "http://example.com/profile.jpg",
        List.of(paymentMethod)
    );
  }

  @Test
  @DisplayName("Should return user details when user exists")
  void getUserDetailsByUserId_WhenUserExists_ReturnUserDetails() {
    // Arrange
    Long userId = 1L;
    when(userDetailsService.getUserDetailsByUserId(userId))
        .thenReturn(expectedUserDetails);

    // Act
    UserDetailsDto result = userDetailsController.getUserDetailsByUserId(userId);

    // Assert
    assertEquals(expectedUserDetails, result);
    verify(userDetailsService).getUserDetailsByUserId(userId);
  }

  @Test
  @DisplayName("Should propagate exception when user not found")
  void getUserDetailsByUserId_WhenUserNotFound_ThrowException() {
    // Arrange
    Long userId = 999L;
    when(userDetailsService.getUserDetailsByUserId(userId))
        .thenThrow(new ResourceNotFoundException("User not found with id: " + userId));

    // Act & Assert
    ResourceNotFoundException exception = assertThrows(
        ResourceNotFoundException.class,
        () -> userDetailsController.getUserDetailsByUserId(userId)
    );

    assertEquals("User not found with id: " + userId, exception.getMessage());
    verify(userDetailsService).getUserDetailsByUserId(userId);
  }
}