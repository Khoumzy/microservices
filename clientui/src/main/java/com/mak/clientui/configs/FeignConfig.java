package com.mak.clientui.configs;

import com.mak.clientui.exceptions.CustomErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public CustomErrorDecoder decoder(){
        return new CustomErrorDecoder();
    }
}
