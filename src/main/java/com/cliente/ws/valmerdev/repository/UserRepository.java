package com.cliente.ws.valmerdev.repository;

import com.cliente.ws.valmerdev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
