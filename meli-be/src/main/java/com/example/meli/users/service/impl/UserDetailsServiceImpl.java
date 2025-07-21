package com.example.meli.users.service.impl;

import com.example.meli.paymentmethod.model.dto.PaymentMethodDto;
import com.example.meli.paymentmethod.model.entity.PaymentMethod;
import com.example.meli.paymentmethod.model.mapper.PaymentMethodMapper;
import com.example.meli.users.model.dto.UserDetailsDto;
import com.example.meli.users.model.mapper.UserMapper;
import com.example.meli.users.repository.UserRepository;
import com.example.meli.users.repository.projections.UserDetailsProjection;
import com.example.meli.users.service.UserDetailsService;
import com.example.meli.utils.exception.AppException;
import com.example.meli.utils.exception.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.example.meli.utils.Constants.USER_DETAILS_FILE_PATH;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserRepository userRepository;

  public UserDetailsDto getUserDetailsByUserId(Long userId) {
    UserDetailsProjection userDetails = userRepository.findUserDetailsById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

    List<PaymentMethodDto> paymentMethods = userRepository.findPaymentMethodsByUserId(userId)
        .stream()
        .map(PaymentMethodMapper.INSTANCE::toDto)
        .toList();

    return UserMapper.INSTANCE.toDtoWithPaymentMethods(userDetails, paymentMethods);
  }
}
