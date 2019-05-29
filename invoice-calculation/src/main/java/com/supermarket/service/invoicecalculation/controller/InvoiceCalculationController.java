package com.supermarket.service.invoicecalculation.controller;

import com.supermarket.service.invoicecalculation.beans.InvoiceCalculationRequest;
import com.supermarket.service.invoicecalculation.service.InvoiceCalculationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/invoice")
@Api(value = "invoice" ,tags = "invoiceCalculationRequest")
public class InvoiceCalculationController {

    @Autowired
    InvoiceCalculationService invoiceCalculationService;

    @RequestMapping(method =RequestMethod.POST)
    @ApiOperation(value = "calculate net amount", notes = "get user invoice and calculate final amount", nickname = "getInvoiceAndReturnFinalAmnt")
    public String getInvoiceAndReturnFinalAmnt(@RequestBody InvoiceCalculationRequest invoiceCalculationRequest){

        try {
            final double netAmount = invoiceCalculationService.calculateDiscountedAmount(invoiceCalculationRequest);
            System.out.println("Request Received "+invoiceCalculationRequest);
            return Double.toString(netAmount);
        }catch (Exception e){
            return "Error Occurred";
        }



    }

}
