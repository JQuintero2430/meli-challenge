package com.example.meli.users.repository;

import com.example.meli.users.model.entity.User;
import com.example.meli.users.repository.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  @Query("""
        SELECT u.id as id,
               u.username as username,
               u.profileImageUrl as profileImageUrl,
               u.countryCode as countryCode,
               u.paymentMethods as paymentMethods
        FROM User u
        LEFT JOIN FETCH u.paymentMethods pm
        WHERE u.id = :userId AND u.isActive = true
    """)
  Optional<UserDetailsProjection> findUserDetailsById(@Param("userId") Long userId);
}
