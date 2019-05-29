package com.supermarket.service.invoicecalculation.service;

import com.supermarket.service.invoicecalculation.beans.InvoiceCalculationRequest;
import com.supermarket.service.invoicecalculation.beans.Item;
import com.supermarket.service.invoicecalculation.utils.InvoiceCalculationUtil;
import org.apache.commons.lang.StringUtils;
import com.supermarket.service.invoicecalculation.constants.InvoiceCalculationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class InvoiceCalculationServiceImpl implements InvoiceCalculationService {
    @Autowired
    InvoiceCalculationUtil invoiceCalculationUtil;

    @Override
    public double calculateDiscountedAmount(InvoiceCalculationRequest calculationRequest) throws Exception {
        String custType = calculationRequest.getCustomer().getCustomerType();
        if (StringUtils.isNotEmpty(custType)) {
            double discount = calculateDiscoutOnEmpType(calculationRequest);
            double calculatedAmount = calcuateAmountAfterDiscount(discount, calculationRequest.getItems());
            double netAmount = calculateNetAmount(calculatedAmount);
            return netAmount;
        }
        return 0;
    }

    @Override
    public double calculateNetAmount(double amount) {
        double discount = 0;
        if (amount >= InvoiceCalculationConstants.MIN_DISCOUNT_AMOUNT) {
            discount = amount * InvoiceCalculationConstants.CUSTOMER_DISCOUNT;
        }
        return amount - discount;
    }

    public double calculateDiscoutOnEmpType(InvoiceCalculationRequest request) throws Exception {
        switch (request.getCustomer().getCustomerType().toUpperCase()) {
            case InvoiceCalculationConstants.CUSTOMER_TYPE_EMPLOYEE: {
                return InvoiceCalculationConstants.EMPLOYEE_DISCOUNT;
            }
            case InvoiceCalculationConstants.CUSTOMER_TYPE_AFFILIATE: {
                return InvoiceCalculationConstants.AFFILIATE_DISCOUNT;
            }
            default: {
                String dateOfRegistration = request.getCustomer().getDateOfRegistration();
                if (StringUtils.isNotEmpty(dateOfRegistration) && isDate2YearsBefore(dateOfRegistration)) {
                    return InvoiceCalculationConstants.CUSTOMER_DISCOUNT;
                }
            }
        }
        return 1;
    }

    public double calcuateAmountAfterDiscount(double discount, List<Item> items) {
        double finalAmount;
        double calculatedAmount = 0;
        double groceryAmount = 0;

        for (Item i : items) {
            if (!(InvoiceCalculationConstants.ITEM_TYPE_GROCERY).equalsIgnoreCase(i.getItemType())) {
                calculatedAmount = calculatedAmount + (i.getItemPrice() * discount);
            } else {
                groceryAmount = i.getItemPrice();
            }
        }
        finalAmount = calculatedAmount + groceryAmount;


        return finalAmount;
    }

    public boolean isDate2YearsBefore(String stringDate) throws Exception {

        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.YEAR, -2);
        Date before2Year = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date registrationDate = formatter.parse(stringDate);

        if (registrationDate.before(before2Year)) {
            return true;
        }
        return false;
    }
}
