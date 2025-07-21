package com.example.meli.products.repository;

import com.example.meli.products.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query
      (value = "SELECT p.id AS id, p.title AS title, p.slug AS slug, " +
          "p.description AS description, p.price AS price, " +
          "p.stock AS stock, c.name AS category, " +
          "p.attributes AS attributes " +
          "FROM Product p JOIN Category c ON p.category.id = c.id " +
          "WHERE p.id = :id")
  ProductProjection findProjectionById(Long id);

}
