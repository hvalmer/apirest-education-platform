package com.cliente.ws.valmerdev.service;

import com.cliente.ws.valmerdev.dto.SubscriptionTypeDto;
import com.cliente.ws.valmerdev.model.SubscriptionType;

import java.util.List;

public interface SubscriptionTypeService {

    List<SubscriptionType> findAll();

    SubscriptionType findById(Long id);

    SubscriptionType create(SubscriptionTypeDto dto);

    SubscriptionType update(Long id, SubscriptionTypeDto dto);

    void delete(Long id);
}
