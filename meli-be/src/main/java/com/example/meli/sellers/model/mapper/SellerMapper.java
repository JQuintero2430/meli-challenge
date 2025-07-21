package com.example.meli.sellers.model.mapper;

import com.example.meli.sellers.model.dto.SellerDto;
import com.example.meli.sellers.repository.projections.SellerDetailsProjection;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(
    componentModel = "spring",
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SellerMapper {

  SellerMapper INSTANCE = Mappers.getMapper(SellerMapper.class);

  SellerDto toDto(SellerDetailsProjection sellerProjection);
}
