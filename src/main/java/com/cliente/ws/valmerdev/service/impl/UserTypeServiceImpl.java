package com.cliente.ws.valmerdev.service.impl;

import com.cliente.ws.valmerdev.model.UserType;
import com.cliente.ws.valmerdev.repository.UserTypeRepository;
import com.cliente.ws.valmerdev.service.UserTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    private final UserTypeRepository userTypeRepository;

    UserTypeServiceImpl(UserTypeRepository userTypeRepository){
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public List<UserType> findAll() {
        return userTypeRepository.findAll();
    }
}
