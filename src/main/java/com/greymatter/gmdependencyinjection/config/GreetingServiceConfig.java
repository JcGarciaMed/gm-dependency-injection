package com.greymatter.gmdependencyinjection.config;

import com.greymatter.gmdependencyinjection.datasource.FakeDataSource;
import com.greymatter.gmdependencyinjection.repositories.EnglishGreetingRepository;
import com.greymatter.gmdependencyinjection.repositories.EnglishGreetingRepositoryImpl;
import com.greymatter.gmdependencyinjection.services.*;
import com.greymatter.pets.PetService;
import com.greymatter.pets.PetServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@EnableConfigurationProperties(GmConstructorConfig.class)
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(GmConstructorConfig gmConstructorConfig){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(gmConstructorConfig.getUsername());
        fakeDataSource.setPassword(gmConstructorConfig.getPassword());
        fakeDataSource.setJdbcUrl(gmConstructorConfig.getJdbcUrl());
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

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
