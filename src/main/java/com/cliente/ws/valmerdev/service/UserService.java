package com.cliente.ws.valmerdev.service;

import com.cliente.ws.valmerdev.dto.UserDto;
import com.cliente.ws.valmerdev.model.User;

public interface UserService {

    User create(UserDto dto);
}
