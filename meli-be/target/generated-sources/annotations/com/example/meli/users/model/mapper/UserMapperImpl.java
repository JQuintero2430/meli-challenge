package com.example.meli.users.model.mapper;

import com.example.meli.paymentmethod.model.dto.PaymentMethodDto;
import com.example.meli.users.model.dto.UserDetailsDto;
import com.example.meli.users.repository.projections.UserDetailsProjection;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-21T23:08:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Microsoft)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDetailsDto toDto(UserDetailsProjection projection) {
        if ( projection == null ) {
            return null;
        }

        Long id = null;
        String username = null;
        String profileImageUrl = null;

        if ( projection.getId() != null ) {
            id = projection.getId();
        }
        if ( projection.getUsername() != null ) {
            username = projection.getUsername();
        }
        if ( projection.getProfileImageUrl() != null ) {
            profileImageUrl = projection.getProfileImageUrl();
        }

        List<PaymentMethodDto> paymentMethodsAvailable = mapAvailablePaymentMethods(projection);

        UserDetailsDto userDetailsDto = new UserDetailsDto( id, username, profileImageUrl, paymentMethodsAvailable );

        return userDetailsDto;
    }

    @Override
    public UserDetailsDto toDtoWithPaymentMethods(UserDetailsProjection projection, List<PaymentMethodDto> paymentMethodsAvailable) {
        if ( projection == null && paymentMethodsAvailable == null ) {
            return null;
        }

        Long id = null;
        String username = null;
        String profileImageUrl = null;
        if ( projection != null ) {
            if ( projection.getId() != null ) {
                id = projection.getId();
            }
            if ( projection.getUsername() != null ) {
                username = projection.getUsername();
            }
            if ( projection.getProfileImageUrl() != null ) {
                profileImageUrl = projection.getProfileImageUrl();
            }
        }
        List<PaymentMethodDto> paymentMethodsAvailable1 = null;
        List<PaymentMethodDto> list = paymentMethodsAvailable;
        if ( list != null ) {
            paymentMethodsAvailable1 = new ArrayList<PaymentMethodDto>( list );
        }

        UserDetailsDto userDetailsDto = new UserDetailsDto( id, username, profileImageUrl, paymentMethodsAvailable1 );

        return userDetailsDto;
    }
}
