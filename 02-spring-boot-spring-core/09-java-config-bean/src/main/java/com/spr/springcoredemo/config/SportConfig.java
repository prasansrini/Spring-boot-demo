package com.spr.springcoredemo.config;

import com.spr.springcoredemo.common.Coach;
import com.spr.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("beanName")
    public Coach getSwimCoach() {
        return new SwimCoach();
    }
}
