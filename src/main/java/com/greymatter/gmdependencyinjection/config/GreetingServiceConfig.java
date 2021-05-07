package com.greymatter.gmdependencyinjection.config;

import com.greymatter.gmdependencyinjection.repositories.EnglishGreetingRepository;
import com.greymatter.gmdependencyinjection.repositories.EnglishGreetingRepositoryImpl;
import com.greymatter.gmdependencyinjection.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean("i18nService")
    I18nEnglishService i18nEnglishService(EnglishGreetingRepository englishGreetingRepository){ return new I18nEnglishService(englishGreetingRepository);
    }


    @Profile({"ES","default"})
    @Bean("i18nService")
    I18nSpanishService i18nSpanishService(){ return new I18nSpanishService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){ return new PrimaryGreetingService(); }

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
