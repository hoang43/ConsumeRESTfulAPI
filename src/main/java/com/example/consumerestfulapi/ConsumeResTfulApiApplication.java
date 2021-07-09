package com.example.consumerestfulapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class ConsumeResTfulApiApplication {
//Trinh ghi log
    private static final Logger log = LoggerFactory.getLogger(ConsumeResTfulApiApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(ConsumeResTfulApiApplication.class, args);
    }

    //Su dung thu vien Jackson de xu ly data den
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    @Bean

    public CommandLineRunner run (RestTemplate restTemplate)  {
        return args -> {
            Quote quote = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random",Quote.class);
            log.info(quote.toString());
        };
    }

}
