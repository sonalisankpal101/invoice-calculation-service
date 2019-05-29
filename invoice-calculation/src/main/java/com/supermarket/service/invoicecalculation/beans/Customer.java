package com.supermarket.service.invoicecalculation.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Customer {
    private String customerId;
    private String customerName;
    private String customerType;
    private String dateOfRegistration;
}
