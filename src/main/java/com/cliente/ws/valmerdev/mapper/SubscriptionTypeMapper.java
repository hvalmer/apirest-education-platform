package com.cliente.ws.valmerdev.mapper;

import com.cliente.ws.valmerdev.dto.SubscriptionTypeDto;
import com.cliente.ws.valmerdev.model.SubscriptionType;

public class SubscriptionTypeMapper {

    public static SubscriptionType fromDtoToEntity(SubscriptionTypeDto dto){
        return SubscriptionType.builder()
                .id(dto.getId())
                .name(dto.getName())
                .accessMonth(dto.getAccessMonth())
                .price(dto.getPrice())
                .productkey(dto.getProductkey())
                .build();
    }
}
