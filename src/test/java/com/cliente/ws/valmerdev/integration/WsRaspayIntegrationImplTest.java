package com.cliente.ws.valmerdev.integration;

import com.cliente.ws.valmerdev.dto.wsraspay.CreditCardDto;
import com.cliente.ws.valmerdev.dto.wsraspay.CustomerDto;
import com.cliente.ws.valmerdev.dto.wsraspay.OrderDto;
import com.cliente.ws.valmerdev.dto.wsraspay.PaymentDto;
import com.cliente.ws.valmerdev.integration.impl.WsRaspayIntegrationImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class WsRaspayIntegrationImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WsRaspayIntegrationImpl wsRaspayIntegration;

    @Test
    void createCustomerWhenDtoOk() {
        CustomerDto dto = new CustomerDto(
                null,
                "01150170204",
                "teste@teste",
                "Harlan",
                "Goyana"
        );

        ResponseEntity<CustomerDto> response =
                ResponseEntity.ok(dto);

        Mockito.when(restTemplate.exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.POST),
                Mockito.any(HttpEntity.class),
                Mockito.eq(CustomerDto.class)
        )).thenReturn(response);

        CustomerDto result = wsRaspayIntegration.createCustomer(dto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("01150170204", result.getCpf());
    }

    @Test
    void createOrderWhenDtoOk() {
        // request (o que você envia pro gateway)
        OrderDto requestDto = new OrderDto(
                null,
                "6983bbc6bf7d75f246a010b7",   // customerId (ou o id real do customer)
                BigDecimal.ZERO,
                "PERPETUAL22"                  // productAcronym
        );

        // response (o que o gateway devolve: id gerado + 201)
        OrderDto responseDto = new OrderDto(
                "6983bbc6bf7d75f246a09999",   // <-- simula o ORDER ID gerado
                requestDto.getCustomerId(),
                requestDto.getDiscount(),
                requestDto.getProductAcronym()
        );

        ResponseEntity<OrderDto> response =
                ResponseEntity.status(HttpStatus.CREATED).body(responseDto);

        Mockito.when(restTemplate.exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.POST),
                Mockito.any(HttpEntity.class),
                Mockito.eq(OrderDto.class)
        )).thenReturn(response);

        OrderDto result = wsRaspayIntegration.createOrder(requestDto);

        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getId());
        Assertions.assertEquals("6983bbc6bf7d75f246a09999", result.getId());
        Assertions.assertEquals("6983bbc6bf7d75f246a010b7", result.getCustomerId());
        Assertions.assertEquals(0, BigDecimal.ZERO.compareTo(result.getDiscount()));
        Assertions.assertEquals("PERPETUAL22", result.getProductAcronym());
    }

    @Test
    void processPaymentWhenDtoOk() {
        CreditCardDto creditCardDto = new CreditCardDto(
                "123",
                "57544557200",
                1L,
                6,
                "1234567812345678",
                2030
        );
        PaymentDto paymentDto = new PaymentDto(
                creditCardDto,
                "6983bbc6bf7d75f246a010b7",
                "6983bbc6bf7d75f246a09999"
        );

        ResponseEntity<Boolean> response =
                ResponseEntity.ok(true);

        Mockito.when(restTemplate.exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.POST),
                Mockito.any(HttpEntity.class),
                Mockito.eq(Boolean.class)
        )).thenReturn(response);

        Boolean result = wsRaspayIntegration.processPayment(paymentDto);

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result);
    }

}
