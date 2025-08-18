package com.cliente.ws.valmerdev.service.impl;

import com.cliente.ws.valmerdev.dto.SubscriptionTypeDto;
import com.cliente.ws.valmerdev.exception.BadRequestException;
import com.cliente.ws.valmerdev.exception.NotFoundException;
import com.cliente.ws.valmerdev.mapper.SubscriptionTypeMapper;
import com.cliente.ws.valmerdev.model.SubscriptionType;
import com.cliente.ws.valmerdev.repository.SubscriptionTypeRepository;
import com.cliente.ws.valmerdev.service.SubscriptionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
       return getSubscriptionType(id);
    }


    @Override
    public SubscriptionType create(SubscriptionTypeDto dto) {
        if(Objects.nonNull(dto.getId())){
            throw new BadRequestException("Id must be null!");
        }
        return subscriptionTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionTypeDto dto) {
        getSubscriptionType(id);
        dto.setId(id);
        return subscriptionTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Long id) {
        getSubscriptionType(id);
        subscriptionTypeRepository.deleteById(id);
    }

    private SubscriptionType getSubscriptionType(Long id) {
        Optional<SubscriptionType> optionalSubscriptionType
                = subscriptionTypeRepository.findById(id);
        if(optionalSubscriptionType.isEmpty()) {
            throw new NotFoundException("SubscriptionType not found!");
        }
        return optionalSubscriptionType.get();
    }
}
