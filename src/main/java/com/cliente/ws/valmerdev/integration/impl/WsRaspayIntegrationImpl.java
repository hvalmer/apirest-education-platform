package com.cliente.ws.valmerdev.integration.impl;

import com.cliente.ws.valmerdev.dto.wsraspay.CustomerDto;
import com.cliente.ws.valmerdev.dto.wsraspay.OrderDto;
import com.cliente.ws.valmerdev.dto.wsraspay.PaymentDto;
import com.cliente.ws.valmerdev.integration.WsRaspayIntegration;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WsRaspayIntegrationImpl implements WsRaspayIntegration {

    private final RestTemplate restTemplate;

    private final HttpHeaders headers;

    public WsRaspayIntegrationImpl(RestTemplate restTemplate){

        this.restTemplate = restTemplate;
        headers = getHttpHeaders();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto dto) {
        try {
            HttpEntity<CustomerDto> request = new HttpEntity<>(dto, this.headers);
            ResponseEntity<CustomerDto> response =
                    restTemplate.exchange("http://localhost:8081/ws-raspay/v1/customer",
                            HttpMethod.POST,
                            request,
                            CustomerDto.class
                    );
            return response.getBody();
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public OrderDto createOrder(OrderDto dto) {
        try {
            HttpEntity<OrderDto> request = new HttpEntity<>(dto, this.headers);
            ResponseEntity<OrderDto> response =
                    restTemplate.exchange("http://localhost:8081/ws-raspay/v1/order",
                            HttpMethod.POST,
                            request,
                            OrderDto.class
                    );
            return response.getBody();
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public Boolean processPayment(PaymentDto dto) {
        try {
            HttpEntity<PaymentDto> request = new HttpEntity<>(dto, this.headers);
            ResponseEntity<Boolean> response =
                    restTemplate.exchange("http://localhost:8081/ws-raspay/v1/payment/credit-card",
                            HttpMethod.POST,
                            request,
                            Boolean.class
                    );
            return response.getBody();
        } catch (Exception e){
            throw e;
        }

    }

    private static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        String credential = "rasmooplus:r@sm00";
        String base64 = Base64.getEncoder()
                .encodeToString(credential.getBytes(StandardCharsets.UTF_8));
        headers.add(HttpHeaders.AUTHORIZATION, "Basic " + base64);
        return headers;
    }
}
