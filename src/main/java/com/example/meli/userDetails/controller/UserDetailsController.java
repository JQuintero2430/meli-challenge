package com.example.meli.userDetails.controller;

import com.example.meli.userDetails.model.UserDetailsDto;
import com.example.meli.userDetails.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-details")
public class UserDetailsController {

  private final UserDetailsService userDetailsService;

  @GetMapping("/{userId}")
  public UserDetailsDto getUserDetailsByUserId(@PathVariable Long userId) {
    return userDetailsService.getUserDetailsByUserId(userId);
  }
}
