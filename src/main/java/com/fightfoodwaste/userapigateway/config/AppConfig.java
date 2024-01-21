package com.fightfoodwaste.userapigateway.config;


import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class AppConfig {

    @Bean
    public RestTemplateAutoConfiguration restTemplateAutoConfiguration(){return new RestTemplateAutoConfiguration();}

    @Bean
    public RestTemplate restTemplate(){return new RestTemplate();}
}
