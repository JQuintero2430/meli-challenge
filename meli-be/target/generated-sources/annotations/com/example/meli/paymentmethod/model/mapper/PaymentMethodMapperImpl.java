package com.example.meli.paymentmethod.model.mapper;

import com.example.meli.paymentmethod.model.dto.PaymentMethodDto;
import com.example.meli.paymentmethod.model.entity.PaymentMethod;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-21T23:08:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Microsoft)"
)
@Component
public class PaymentMethodMapperImpl implements PaymentMethodMapper {

    @Override
    public PaymentMethodDto toDto(PaymentMethod paymentMethod) {
        if ( paymentMethod == null ) {
            return null;
        }

        Long id = null;
        String provider = null;
        String countryCode = null;
        String type = null;
        String imageUrl = null;

        if ( paymentMethod.getId() != null ) {
            id = paymentMethod.getId();
        }
        if ( paymentMethod.getProvider() != null ) {
            provider = paymentMethod.getProvider();
        }
        if ( paymentMethod.getCountryCode() != null ) {
            countryCode = paymentMethod.getCountryCode();
        }
        if ( paymentMethod.getType() != null ) {
            type = paymentMethod.getType();
        }
        if ( paymentMethod.getImageUrl() != null ) {
            imageUrl = paymentMethod.getImageUrl();
        }

        PaymentMethodDto paymentMethodDto = new PaymentMethodDto( id, provider, countryCode, type, imageUrl );

        return paymentMethodDto;
    }
}
