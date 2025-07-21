package com.example.meli.paymentmethod.model.mapper;

import com.example.meli.paymentmethod.model.dto.PaymentMethodDto;
import com.example.meli.paymentmethod.model.entity.PaymentMethod;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(
    componentModel = "spring",
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PaymentMethodMapper {

  PaymentMethodMapper INSTANCE = Mappers.getMapper(PaymentMethodMapper.class);

  PaymentMethodDto toDto(PaymentMethod paymentMethod);
}
