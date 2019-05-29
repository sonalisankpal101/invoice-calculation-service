package com.supermarket.service.invoicecalculation.service;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

@Component
public class InvoiceCalculationServiceImplTest {

    InvoiceCalculationServiceImpl invoiceCalculationService = null;
    Helper helper = null;

    @Before
    public void init() {
        invoiceCalculationService = new InvoiceCalculationServiceImpl();
        helper = new Helper();
    }

    @Test
    public void calculateNetAmountTest() {
        assertEquals(10.0, invoiceCalculationService.calculateNetAmount(10), 0.001);

    }

    @Test
    public void calculateNetAmountTest1() {
        assertEquals(190.0, invoiceCalculationService.calculateNetAmount(200), 0.001);
    }

    @Test
    public void calcuateAmountAfterDiscountTest() {
        assertEquals(8.0, invoiceCalculationService.calcuateAmountAfterDiscount(0.30, helper.getList()), 0.001);
    }

    @Test
    public void isDate2YearsBefore() {
        try {
            assertTrue(invoiceCalculationService.isDate2YearsBefore("25-04-2014"));
            assertFalse(invoiceCalculationService.isDate2YearsBefore("25-04-2018"));
        } catch (Exception e) {
            System.out.println(" Error Parsing date");
        }
    }

    // Test for Customer - Employee
    @Test
    public void calculateDiscoutOnEmpTypeTest() {
        try {
            assertEquals(0.30, invoiceCalculationService.calculateDiscoutOnEmpType(helper.getInvoiceCalculationRequest()), 0.001);
        } catch (Exception e) {
            System.out.println(" Error Parsing date");
        }
    }

    // Test for Customer - Affiliate
    @Test
    public void calculateDiscoutOnEmpTypeTest1() {
        try {
            assertEquals(0.10, invoiceCalculationService.calculateDiscoutOnEmpType(helper.getRequestForAffiliate()), 0.001);
        } catch (Exception e) {
            System.out.println(" Error Parsing date");
        }

    }

    // Test for Customer - normal
    @Test
    public void calculateDiscoutOnEmpTypeTest2() {
        try {
            assertEquals(0.05, invoiceCalculationService.calculateDiscoutOnEmpType(helper.getRequestForUserFrom2Years()), 0.001);
        } catch (Exception e) {
            System.out.println(" Error Parsing date");
        }

    }

    // No percentage discount
    @Test
    public void calculateDiscountedAmountTest() {
        try {
            assertEquals(96.00, invoiceCalculationService.calculateDiscountedAmount(helper.getInvoiceCalculationRequest()), 0.001);
        } catch (Exception e) {
            System.out.println(" Error Parsing date");
        }
    }

    // No discount
    @Test
    public void calculateDiscountedAmountTest1() {
        try {
            assertEquals(70.00, invoiceCalculationService.calculateDiscountedAmount(helper.getRequestForNoDiscount()), 0.001);
        } catch (Exception e) {
            System.out.println(" Error Parsing date");
        }
    }
}
