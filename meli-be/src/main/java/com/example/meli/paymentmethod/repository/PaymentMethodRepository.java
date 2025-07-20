package com.example.meli.paymentmethod.repository;

import com.example.meli.paymentmethod.model.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

  @Query("SELECT pm FROM PaymentMethod pm " +
      "WHERE pm.countryCode = :countryCode " +
      "AND pm.isActive = true")
  List<PaymentMethod> findAvailableByCountry(@Param("countryCode") String countryCode);

  @Query("SELECT pm FROM PaymentMethod pm " +
      "JOIN UserPaymentMethod upm ON upm.paymentMethod = pm " +
      "WHERE upm.user.id = :userId " +
      "AND pm.countryCode = :countryCode " +
      "AND pm.isActive = true")
  List<PaymentMethod> findUserPaymentMethodsByCountry(
      @Param("userId") Long userId,
      @Param("countryCode") String countryCode
  );
}
