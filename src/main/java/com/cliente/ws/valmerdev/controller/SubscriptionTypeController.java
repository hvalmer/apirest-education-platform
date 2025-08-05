package com.cliente.ws.valmerdev.controller;

import com.cliente.ws.valmerdev.model.SubscriptionType;
import com.cliente.ws.valmerdev.repository.SubscriptionTypeRepository;
import com.cliente.ws.valmerdev.service.SubscriptionTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
