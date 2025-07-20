package com.example.meli.paymentmethod.model.entity;

import com.example.meli.users.model.entity.User;
import com.example.meli.users.model.entity.UserPaymentMethodId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_payment_methods")
@Getter
@Setter
public class UserPaymentMethod {
  @EmbeddedId
  private UserPaymentMethodId id;

  @ManyToOne
  @MapsId("userId")
  private User user;

  @ManyToOne
  @MapsId("paymentMethodId")
  private PaymentMethod paymentMethod;

  private LocalDateTime addedAt;
  private LocalDateTime lastUsed;
  private boolean isPreferred;

  @PrePersist
  protected void onCreate() {
    addedAt = LocalDateTime.now();
  }
}
