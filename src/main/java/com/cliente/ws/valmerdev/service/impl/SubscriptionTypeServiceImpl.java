package com.cliente.ws.valmerdev.service.impl;

import com.cliente.ws.valmerdev.dto.SubscriptionTypeDto;
import com.cliente.ws.valmerdev.exception.NotFoundException;
import com.cliente.ws.valmerdev.model.SubscriptionType;
import com.cliente.ws.valmerdev.repository.SubscriptionTypeRepository;
import com.cliente.ws.valmerdev.service.SubscriptionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService {

    private final SubscriptionTypeRepository subscriptionTypeRepository;

    SubscriptionTypeServiceImpl(SubscriptionTypeRepository subscriptionTypeRepository){
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }

    @Override
    public List<SubscriptionType> findAll() {
        return subscriptionTypeRepository.findAll();
    }

    @Override
    public SubscriptionType findById(Long id) {
        Optional<SubscriptionType> optionalSubscriptionType
                = subscriptionTypeRepository.findById(id);
        if(optionalSubscriptionType.isEmpty()) {
            throw new NotFoundException("SubscriptionType not found!");
        }
        return optionalSubscriptionType.get();
    }


    @Override
    public SubscriptionType create(SubscriptionTypeDto dto) {
        return subscriptionTypeRepository.save(SubscriptionType.builder()
                        .id(dto.getId())
                        .name(dto.getName())
                        .accessMonth(dto.getAccessMonth())
                        .price(dto.getPrice())
                        .productkey(dto.getProductkey())
                .build());
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionType subscriptionType) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
