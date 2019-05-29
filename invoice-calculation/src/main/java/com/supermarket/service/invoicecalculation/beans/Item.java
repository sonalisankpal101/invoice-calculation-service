package com.supermarket.service.invoicecalculation.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Item {
    private  String itemId;
    private String itemName;
    private String itemType;
    private double itemPrice;
   }
