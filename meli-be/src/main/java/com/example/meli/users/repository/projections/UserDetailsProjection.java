package com.example.meli.users.repository.projections;

import com.example.meli.paymentmethod.model.entity.PaymentMethod;

import java.util.List;

public interface UserDetailsProjection {
  Long getId();
  String getUsername();
  String getProfileImageUrl();
  String getCountryCode();
  List<PaymentMethod> getPaymentMethods();
}