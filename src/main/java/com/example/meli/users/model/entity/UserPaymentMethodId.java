package com.example.meli.users.model.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class UserPaymentMethodId implements Serializable {
  private Long userId;
  private Long paymentMethodId;
}