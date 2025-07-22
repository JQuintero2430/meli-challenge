package com.example.meli.sellers.model.mapper;

import com.example.meli.sellers.model.dto.SellerDto;
import com.example.meli.sellers.repository.projections.SellerDetailsProjection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-21T23:08:59-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Microsoft)"
)
@Component
public class SellerMapperImpl implements SellerMapper {

    @Override
    public SellerDto toDto(SellerDetailsProjection sellerProjection) {
        if ( sellerProjection == null ) {
            return null;
        }

        Long id = null;
        String nickname = null;
        Float reputationScore = null;
        Integer totalProductsListed = null;
        Integer totalSales = null;
        String imageUrl = null;

        if ( sellerProjection.getId() != null ) {
            id = sellerProjection.getId();
        }
        if ( sellerProjection.getNickname() != null ) {
            nickname = sellerProjection.getNickname();
        }
        if ( sellerProjection.getReputationScore() != null ) {
            reputationScore = sellerProjection.getReputationScore();
        }
        if ( sellerProjection.getTotalProductsListed() != null ) {
            totalProductsListed = sellerProjection.getTotalProductsListed();
        }
        if ( sellerProjection.getTotalSales() != null ) {
            totalSales = sellerProjection.getTotalSales();
        }
        if ( sellerProjection.getImageUrl() != null ) {
            imageUrl = sellerProjection.getImageUrl();
        }

        SellerDto sellerDto = new SellerDto( id, nickname, reputationScore, totalProductsListed, totalSales, imageUrl );

        return sellerDto;
    }
}
