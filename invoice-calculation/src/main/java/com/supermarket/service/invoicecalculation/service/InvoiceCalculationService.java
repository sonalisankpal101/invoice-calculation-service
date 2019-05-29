package com.supermarket.service.invoicecalculation.service;

import com.supermarket.service.invoicecalculation.beans.InvoiceCalculationRequest;
import com.supermarket.service.invoicecalculation.beans.Item;

import java.util.List;

public interface InvoiceCalculationService {

    double calculateDiscountedAmount(InvoiceCalculationRequest calculationRequest) throws Exception;
    double calculateNetAmount(double amount);
    double calculateDiscoutOnEmpType(InvoiceCalculationRequest request)throws Exception;
    double calcuateAmountAfterDiscount(double discount, List<Item> items);
    boolean isDate2YearsBefore(String stringDate) throws Exception;

}
