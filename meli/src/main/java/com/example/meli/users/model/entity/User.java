package com.example.meli.users.model.entity;

import com.example.meli.paymentmethod.model.entity.PaymentMethod;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String username;

  private String profileImageUrl;

  @ManyToMany
  @JoinTable(
      name = "user_payment_methods",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "payment_method_id")
  )
  @SQLRestriction("is_active = true")
  private List<PaymentMethod> paymentMethods = new ArrayList<>();

  @Column(nullable = false)
  private String email;

  private String password;

  private LocalDateTime createdAt;

  private LocalDateTime lastLogin;

  private boolean isActive;

  @Column(nullable = false, length = 2)
  private String countryCode;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
  }

  // Método helper para obtener métodos de pago disponibles por país
  public List<PaymentMethod> getAvailablePaymentMethods() {
    return paymentMethods.stream()
        .filter(pm -> pm.getCountryCode().equals(this.countryCode))
        .filter(PaymentMethod::isActive)
        .collect(Collectors.toList());
  }
}
