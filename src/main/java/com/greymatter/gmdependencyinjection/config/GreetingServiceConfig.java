package com.greymatter.gmdependencyinjection.config;

import com.greymatter.gmdependencyinjection.services.ConstructorGreetingService;
import com.greymatter.gmdependencyinjection.services.PropertyInjectedGreetingService;
import com.greymatter.gmdependencyinjection.services.SetterInjectedService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingServiceConfig {

    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedService setterInjectedService(){
        return new SetterInjectedService();
    }
}
