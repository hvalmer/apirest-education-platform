package com.cliente.ws.valmerdev.service.impl;

import com.cliente.ws.valmerdev.dto.UserDto;
import com.cliente.ws.valmerdev.exception.BadRequestException;
import com.cliente.ws.valmerdev.exception.NotFoundException;
import com.cliente.ws.valmerdev.mapper.UserMapper;
import com.cliente.ws.valmerdev.model.User;
import com.cliente.ws.valmerdev.model.UserType;
import com.cliente.ws.valmerdev.repository.UserRepository;
import com.cliente.ws.valmerdev.repository.UserTypeRepository;
import com.cliente.ws.valmerdev.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    //chamando duas repositorys
     private final UserRepository userRepository;

     private final UserTypeRepository userTypeRepository;

     UserServiceImpl(UserRepository userRepository, UserTypeRepository userTypeRepository){
         this.userRepository = userRepository;
         this.userTypeRepository = userTypeRepository;
     }

    @Override
    public User create(UserDto dto) {

         if(Objects.nonNull(dto.getId())){
            throw new BadRequestException("Id must be null!");
         }

        var userTypeOpt = userTypeRepository.findById(dto.getUserTypeId());

         if(userTypeOpt.isEmpty()){
             throw new NotFoundException("userTypeId not found!");
         }

        UserType userType = userTypeOpt.get();
        User user = UserMapper.fromDtoToEntity(dto, userType, null);
        return userRepository.save(user);
    }
}
