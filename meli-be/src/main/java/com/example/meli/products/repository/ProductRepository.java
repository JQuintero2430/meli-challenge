package com.example.meli.products.repository;

import com.example.meli.products.model.entity.Product;
import com.example.meli.products.model.entity.ProductAttribute;
import com.example.meli.products.repository.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query("""
    SELECT p.id AS id, p.title AS title, p.slug AS slug,
    p.description AS description, p.price AS price,
    p.stock AS stock, c.name AS category,
    FROM Product p 
    JOIN Category c ON p.category.id = c.id
    WHERE p.id = :productId""")
  Optional<ProductProjection> findProjectionById(@Param("productId") Long productId);

  @Query("SELECT pa FROM ProductAttribute pa WHERE pa.product.id = :productId")
  List<ProductAttribute> findAttributesByProductId(@Param("productId") Long productId);


}
