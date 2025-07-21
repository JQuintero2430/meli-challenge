package com.example.meli.products.model.entity;

import com.example.meli.categories.model.entity.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(unique = true, nullable = false)
  private String slug;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column(nullable = false, precision = 10, scale = 2)
  private BigDecimal price;

  @Column(nullable = false)
  private Integer stock;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id", nullable = false)
  private Category category;


  @OneToMany(
      mappedBy = "product",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private Set<ProductAttribute> attributes = new HashSet<>();

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
    updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = LocalDateTime.now();
  }

  // Método helper para manejar los atributos
  public void setAttributeValue(String key, String value) {
    ProductAttribute attribute = attributes.stream()
        .filter(attr -> attr.getKey().equals(key))
        .findFirst()
        .orElseGet(() -> {
          ProductAttribute newAttr = new ProductAttribute();
          newAttr.setProduct(this);
          newAttr.setKey(key);
          attributes.add(newAttr);
          return newAttr;
        });
    attribute.setValue(value);
  }

  // Método helper para obtener los atributos como Map
  public Map<String, String> getAttributesMap() {
    Map<String, String> attributesMap = new HashMap<>();
    attributes.forEach(attr -> attributesMap.put(attr.getKey(), attr.getValue()));
    return attributesMap;
  }
}