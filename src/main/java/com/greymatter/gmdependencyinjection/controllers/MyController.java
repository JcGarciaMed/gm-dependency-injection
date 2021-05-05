package com.greymatter.gmdependencyinjection.controllers;

import com.greymatter.gmdependencyinjection.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private final GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){
        System.out.println("Hello World!!!!");
        return greetingService.sayGreeting();
    }
}
