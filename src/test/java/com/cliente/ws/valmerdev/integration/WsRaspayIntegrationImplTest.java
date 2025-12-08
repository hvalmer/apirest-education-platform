package com.cliente.ws.valmerdev.integration;

import com.cliente.ws.valmerdev.dto.wsraspay.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WsRaspayIntegrationImplTest {

    @Autowired
    private WsRaspayIntegration wsRaspayIntegration;

    @Test
    void createCustomerWhenDtoOk(){
        CustomerDto dto = new CustomerDto(null, "01150170204", "teste@teste", "Harlan", "Goyana");
        wsRaspayIntegration.createCustomer(dto);
    }
}
