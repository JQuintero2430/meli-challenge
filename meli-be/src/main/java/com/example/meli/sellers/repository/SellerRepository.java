package com.example.meli.sellers.repository;

import com.example.meli.sellers.model.entity.Seller;
import com.example.meli.sellers.repository.projections.SellerDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Long> {

  @Query(
      value = "SELECT s.id AS id, s.nickname AS nickname, s.reputationScore AS reputationScore, " +
          "s.totalProductsListed AS totalProductsListed, s.totalSales AS totalSales, s.imageUrl AS imageUrl " +
          "FROM Seller s WHERE s.id = :sellerId")
  Optional<SellerDetailsProjection> findSellerProjectionById(Long sellerId);
}
