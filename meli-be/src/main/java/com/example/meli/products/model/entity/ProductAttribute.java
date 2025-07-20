package com.example.meli.products.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_attributes")
@Getter
@Setter
public class ProductAttribute {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", nullable = false)
  private com.example.meli.products.model.entity.Product product;

  @Column(name = "attr_key", nullable = false)
  private String key;

  @Column(name = "attr_value")
  private String value;

}