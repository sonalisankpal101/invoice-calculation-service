package com.supermarket.service.invoicecalculation.service;

import com.supermarket.service.invoicecalculation.beans.Customer;
import com.supermarket.service.invoicecalculation.beans.InvoiceCalculationRequest;
import com.supermarket.service.invoicecalculation.beans.Item;
import com.supermarket.service.invoicecalculation.constants.InvoiceCalculationConstants;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Helper {

    List getList(){
        Item item = new Item();
        item.setItemId("1");
        item.setItemName("Extra Vergin Oil");
        item.setItemType("NonGrocerry");
        item.setItemPrice(20);
        Item item1 = new Item();
        item1.setItemId("2");
        item1.setItemName("Green Leaves");
        item1.setItemType(InvoiceCalculationConstants.ITEM_TYPE_GROCERY);
        item1.setItemPrice(30);
        Item item2 = new Item();
        item2.setItemId("3");
        item2.setItemName("Green Leaves 2");
        item2.setItemType(InvoiceCalculationConstants.ITEM_TYPE_GROCERY);
        item2.setItemPrice(2);
        List<Item> items = new ArrayList<>();
        items.add(item);
        items.add(item1);
        items.add(item2);
        return items;
    }

    InvoiceCalculationRequest getInvoiceCalculationRequest(){
        Item item = new Item();
        item.setItemId("1");
        item.setItemName("Extra Vergin Oil");
        item.setItemType("NonGrocerry");
        item.setItemPrice(200);
        Item item1 = new Item();
        item1.setItemId("2");
        item1.setItemName("Green Leaves");
        item1.setItemType("Grocery");
        item1.setItemPrice(30);
        Item item2 = new Item();
        item2.setItemId("3");
        item2.setItemName("Green Leaves 2");
        item2.setItemType("NonGrocery");
        item2.setItemPrice(20);

        List<Item> items = new ArrayList<>();
        items.add(item);
        items.add(item1);
        items.add(item2);

        Customer cust = new Customer();
        cust.setCustomerId("1");
        cust.setCustomerName("Soanli");
        cust.setCustomerType(InvoiceCalculationConstants.CUSTOMER_TYPE_EMPLOYEE);
        cust.setDateOfRegistration("28-08-2017");

        InvoiceCalculationRequest invoiceCalculationRequest = new InvoiceCalculationRequest();
        invoiceCalculationRequest.setCustomer(cust);
        invoiceCalculationRequest.setInVoiceId("123");
        invoiceCalculationRequest.setItems(items);

        return invoiceCalculationRequest;
    }

   public InvoiceCalculationRequest getRequestForAffiliate(){
        Item item = new Item();
        item.setItemId("1");
        item.setItemName("Extra Vergin Oil");
        item.setItemType("NonGrocerry");
        item.setItemPrice(20);
        List<Item> items = new ArrayList<>();
        items.add(item);

        Customer cust = new Customer();
        cust.setCustomerId("1");
        cust.setCustomerName("Soanli");
        cust.setCustomerType(InvoiceCalculationConstants.CUSTOMER_TYPE_AFFILIATE);
        cust.setDateOfRegistration("28-08-2017");

        InvoiceCalculationRequest invoiceCalculationRequest = new InvoiceCalculationRequest();
        invoiceCalculationRequest.setCustomer(cust);
        invoiceCalculationRequest.setInVoiceId("123");
        invoiceCalculationRequest.setItems(items);

        return invoiceCalculationRequest;
    }

    InvoiceCalculationRequest getRequestForUserFrom2Years(){
        Item item = new Item();
        item.setItemId("1");
        item.setItemName("Extra Vergin Oil");
        item.setItemType("NonGrocerry");
        item.setItemPrice(20);
        List<Item> items = new ArrayList<>();
        items.add(item);

        Customer cust = new Customer();
        cust.setCustomerId("1");
        cust.setCustomerName("Soanli");
        cust.setCustomerType("Normal");
        cust.setDateOfRegistration("28-08-2014");

        InvoiceCalculationRequest invoiceCalculationRequest = new InvoiceCalculationRequest();
        invoiceCalculationRequest.setCustomer(cust);
        invoiceCalculationRequest.setInVoiceId("123");
        invoiceCalculationRequest.setItems(items);

        return invoiceCalculationRequest;
    }

    InvoiceCalculationRequest getRequestForNormalUser(){
        Item item = new Item();
        item.setItemId("1");
        item.setItemName("Extra Vergin Oil");
        item.setItemType("NonGrocerry");
        item.setItemPrice(100);
        List<Item> items = new ArrayList<>();
        items.add(item);

        Customer cust = new Customer();
        cust.setCustomerId("1");
        cust.setCustomerName("Soanli");
        cust.setCustomerType("Normal");
        cust.setDateOfRegistration("28-08-2018");

        InvoiceCalculationRequest invoiceCalculationRequest = new InvoiceCalculationRequest();
        invoiceCalculationRequest.setCustomer(cust);
        invoiceCalculationRequest.setInVoiceId("123");
        invoiceCalculationRequest.setItems(items);

        return invoiceCalculationRequest;
    }

    InvoiceCalculationRequest getRequestForNoDiscount(){
        Item item = new Item();
        item.setItemId("1");
        item.setItemName("Extra Vergin Oil");
        item.setItemType("NonGrocerry");
        item.setItemPrice(50);

        Item item2 = new Item();
        item2.setItemId("3");
        item2.setItemName("Green Leaves 2");
        item2.setItemType("NonGrocery");
        item2.setItemPrice(20);
        List<Item> items = new ArrayList<>();
        items.add(item);
        items.add(item2);

        Customer cust = new Customer();
        cust.setCustomerId("1");
        cust.setCustomerName("Soanli");
        cust.setCustomerType("Normal");
        cust.setDateOfRegistration("28-08-2018");

        InvoiceCalculationRequest invoiceCalculationRequest = new InvoiceCalculationRequest();
        invoiceCalculationRequest.setCustomer(cust);
        invoiceCalculationRequest.setInVoiceId("123");
        invoiceCalculationRequest.setItems(items);

        return invoiceCalculationRequest;
    }


}
