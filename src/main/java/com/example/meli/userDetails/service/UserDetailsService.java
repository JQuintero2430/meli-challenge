package com.example.meli.userDetails.service;

import com.example.meli.userDetails.model.UserDetailsDto;

public interface UserDetailsService {
  UserDetailsDto getUserDetailsByUserId(Long userId);
}
