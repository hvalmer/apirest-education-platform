package com.cliente.ws.valmerdev.dto.wsraspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardDto {

    private String cvv;

    private String documentNumber;

    private Long installments;

    private Integer month;

    private String number;

    private Integer year;

}
