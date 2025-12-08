package com.cliente.ws.valmerdev.integration.impl;

import com.cliente.ws.valmerdev.dto.wsraspay.CustomerDto;
import com.cliente.ws.valmerdev.dto.wsraspay.OrderDto;
import com.cliente.ws.valmerdev.dto.wsraspay.PaymentDto;
import com.cliente.ws.valmerdev.integration.WsRaspayIntegration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WsRaspayIntegrationImpl implements WsRaspayIntegration {

    private final RestTemplate restTemplate;

    public WsRaspayIntegrationImpl(){
        this.restTemplate = new RestTemplate();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto dto) {
        try {
            HttpEntity<CustomerDto> request = new HttpEntity<>(dto, createHeaders());
            ResponseEntity<CustomerDto> response =
                    restTemplate.exchange("http://localhost:8081/ws-raspay/v1/customer",
                            HttpMethod.POST, request, CustomerDto.class);
            return response.getBody();
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public OrderDto createOrder(OrderDto dto) {
        return null;
    }

    @Override
    public Boolean processPayment(PaymentDto dto) {
        return null;
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("rasmooplus", "r@sm00"); // Spring codifica em Base64 internamente
        return headers;
    }
}
