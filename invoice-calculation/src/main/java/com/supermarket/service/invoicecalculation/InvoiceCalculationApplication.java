package com.supermarket.service.invoicecalculation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class InvoiceCalculationApplication {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2.SWAGGER_2).groupName("invoicecalculation").select()
                .apis(RequestHandlerSelectors.basePackage("com.supermarket.service.invoicecalculation"))
                .paths(PathSelectors.any()).build().apiInfo(new ApiInfo("Invoice Calculation",
                        "A single API service to calculate final bill amount after discount", "1.0.0", null,
                        new Contact("Sonali", "", null),null, null));
    }

    public static void main(String[] args) {
        SpringApplication.run(InvoiceCalculationApplication.class, args);
    }

}
