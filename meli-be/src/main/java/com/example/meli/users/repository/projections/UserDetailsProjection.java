package com.example.meli.users.repository.projections;

import com.example.meli.paymentmethod.model.entity.PaymentMethod;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface UserDetailsProjection {
  @Value("#{target.id}")
  Long getId();

  @Value("#{target.username}")
  String getUsername();

  @Value("#{target.profileImageUrl}")
  String getProfileImageUrl();

  @Value("#{target.countryCode}")
  String getCountryCode();

  @Value("#{target.paymentMethods}")
  List<PaymentMethod> getPaymentMethods();
}