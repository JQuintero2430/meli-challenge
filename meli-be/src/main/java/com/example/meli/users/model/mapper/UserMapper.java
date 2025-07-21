package com.example.meli.users.model.mapper;

import com.example.meli.paymentmethod.model.dto.PaymentMethodDto;
import com.example.meli.paymentmethod.model.entity.PaymentMethod;
import com.example.meli.users.model.dto.UserDetailsDto;
import com.example.meli.users.repository.projections.UserDetailsProjection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
    nullValueCheckStrategy = org.mapstruct.NullValueCheckStrategy.ALWAYS,
    nullValuePropertyMappingStrategy =org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mapping(target = "paymentMethodsAvailable", expression = "java(mapAvailablePaymentMethods(projection))")
  UserDetailsDto toDto(UserDetailsProjection projection);

  default List<PaymentMethodDto> mapAvailablePaymentMethods(UserDetailsProjection projection) {
    return projection.getPaymentMethods().stream()
        .filter(pm -> pm.getCountryCode().equals(projection.getCountryCode()))
        .filter(PaymentMethod::isActive)
        .map(pm -> new PaymentMethodDto(
            pm.getId(),
            pm.getType(),
            pm.getCountryCode()
        ))
        .collect(Collectors.toList());
  }
}
