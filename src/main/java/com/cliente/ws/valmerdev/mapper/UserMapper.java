package com.cliente.ws.valmerdev.mapper;

import com.cliente.ws.valmerdev.dto.UserDto;
import com.cliente.ws.valmerdev.model.SubscriptionType;
import com.cliente.ws.valmerdev.model.User;
import com.cliente.ws.valmerdev.model.UserType;

public class UserMapper {

    public static User fromDtoToEntity(UserDto dto, UserType userType, SubscriptionType subscriptionType){

        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .cpf(dto.getCpf())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .dtSubscription(dto.getDtSubscription())
                .dtExpiration(dto.getDtExpiration())
                .userType(userType)
                .subscriptionType(subscriptionType)
                .build();
    }

}
