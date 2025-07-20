package com.example.meli.users.service;

import com.example.meli.users.model.dto.UserDetailsDto;

public interface UserDetailsService {
  UserDetailsDto getUserDetailsByUserId(Long userId);
}
