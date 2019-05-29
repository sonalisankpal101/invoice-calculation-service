package com.supermarket.service.invoicecalculation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.supermarket.service.invoicecalculation.InvoiceCalculationApplication;
import com.supermarket.service.invoicecalculation.beans.InvoiceCalculationRequest;
import com.supermarket.service.invoicecalculation.service.Helper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InvoiceCalculationApplication.class)
public class InvoiceCalculationcontrollerTest {

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    InvoiceCalculationController invoiceCalculationController;

    private MockMvc mockMvc;
    @Before
    public void init(){
        mockMvc = MockMvcBuilders
                .standaloneSetup(invoiceCalculationController)
                .build();
    }
    @Test
    public void getInvoiceAndReturnFinalAmntTest() throws Exception {

        String url = "http://localhost:8080" + "/invoice";
        Helper helper = new Helper();
       InvoiceCalculationRequest request= helper.getRequestForAffiliate();



        //... more
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(request );

       this.mockMvc.perform(post(url).contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }
}
