package com.fightfoodwaste.userapigateway.env;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "secret")
@Data
public class EnvVariables {

    private String key;
}
