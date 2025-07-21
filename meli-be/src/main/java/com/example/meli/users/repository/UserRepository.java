package com.example.meli.users.repository;

import com.example.meli.paymentmethod.model.entity.PaymentMethod;
import com.example.meli.users.model.entity.User;
import com.example.meli.users.repository.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Query("""
        SELECT u.id as id,
               u.username as username,
               u.profileImageUrl as profileImageUrl,
               u.countryCode as countryCode
        FROM User u
        WHERE u.id = :userId AND u.isActive = true
        """)
  Optional<UserDetailsProjection> findUserDetailsById(@Param("userId") Long userId);

  @Query("""
        SELECT pm FROM User u
        JOIN u.paymentMethods pm
        WHERE u.id = :userId
        AND u.isActive = true
        AND pm.isActive = true
        AND pm.countryCode = u.countryCode
        """)
  List<PaymentMethod> findPaymentMethodsByUserId(@Param("userId") Long userId);
}