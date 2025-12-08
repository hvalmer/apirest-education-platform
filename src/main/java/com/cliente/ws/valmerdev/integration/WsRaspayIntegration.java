package com.cliente.ws.valmerdev.integration;

import com.cliente.ws.valmerdev.dto.wsraspay.CustomerDto;
import com.cliente.ws.valmerdev.dto.wsraspay.OrderDto;
import com.cliente.ws.valmerdev.dto.wsraspay.PaymentDto;

public interface WsRaspayIntegration {

    CustomerDto createCustomer(CustomerDto dto);

    OrderDto createOrder(OrderDto dto);

    Boolean processPayment(PaymentDto dto);
}
