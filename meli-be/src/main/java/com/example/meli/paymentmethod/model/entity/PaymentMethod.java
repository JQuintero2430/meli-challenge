package com.example.meli.paymentmethod.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payment_methods")
@Getter
@Setter
public class PaymentMethod {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, unique = true)
  private Long id;

  @Column(nullable = false)
  private String type;

  @Column(nullable = false)
  private String provider;

  private boolean isActive;

  @Column(nullable = false, length = 2)
  private String countryCode;

  @Column(nullable = false)
  String imageUrl;
}
