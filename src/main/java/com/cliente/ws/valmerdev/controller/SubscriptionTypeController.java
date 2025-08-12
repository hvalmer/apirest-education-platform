package com.cliente.ws.valmerdev.controller;

import com.cliente.ws.valmerdev.dto.SubscriptionTypeDto;
import com.cliente.ws.valmerdev.model.SubscriptionType;
import com.cliente.ws.valmerdev.service.SubscriptionTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subscription-type")
public class SubscriptionTypeController {


    private final SubscriptionTypeService subscriptionTypeService;

    SubscriptionTypeController(SubscriptionTypeService subscriptionTypeService){
        this.subscriptionTypeService = subscriptionTypeService;
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionType>> findAll(){

        return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionType> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SubscriptionType> create(@RequestBody SubscriptionTypeDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionTypeService.create(dto));
    }

}
