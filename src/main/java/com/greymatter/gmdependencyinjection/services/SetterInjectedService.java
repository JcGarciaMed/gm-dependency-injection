package com.greymatter.gmdependencyinjection.services;

import org.springframework.stereotype.Service;

//@Service
public class SetterInjectedService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "hello world-Setter";
    }
}
