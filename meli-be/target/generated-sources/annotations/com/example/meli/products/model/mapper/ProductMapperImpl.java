package com.example.meli.products.model.mapper;

import com.example.meli.products.model.dto.ProductDto;
import com.example.meli.products.repository.projections.ProductProjection;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-21T23:08:59-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Microsoft)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toDto(ProductProjection productProjection) {
        if ( productProjection == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String slug = null;
        String description = null;
        BigDecimal price = null;
        Integer stock = null;
        String category = null;
        Map<String, String> attributes = null;

        if ( productProjection.getId() != null ) {
            id = productProjection.getId();
        }
        if ( productProjection.getTitle() != null ) {
            title = productProjection.getTitle();
        }
        if ( productProjection.getSlug() != null ) {
            slug = productProjection.getSlug();
        }
        if ( productProjection.getDescription() != null ) {
            description = productProjection.getDescription();
        }
        if ( productProjection.getPrice() != null ) {
            price = productProjection.getPrice();
        }
        if ( productProjection.getStock() != null ) {
            stock = productProjection.getStock();
        }
        if ( productProjection.getCategory() != null ) {
            category = productProjection.getCategory();
        }
        Map<String, String> map = productProjection.getAttributes();
        if ( map != null ) {
            attributes = new LinkedHashMap<String, String>( map );
        }

        ProductDto productDto = new ProductDto( id, title, slug, description, price, stock, category, attributes );

        return productDto;
    }
}
