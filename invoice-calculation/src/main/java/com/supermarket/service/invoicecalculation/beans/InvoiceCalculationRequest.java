package com.supermarket.service.invoicecalculation.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class InvoiceCalculationRequest {

    private String inVoiceId;
    private Customer customer;
    private List<Item> items;
}
