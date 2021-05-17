package com.greymatter.gmdependencyinjection;

import com.greymatter.gmdependencyinjection.config.GmConfiguration;
import com.greymatter.gmdependencyinjection.config.GmConstructorConfig;
import com.greymatter.gmdependencyinjection.controllers.*;
import com.greymatter.gmdependencyinjection.datasource.FakeDataSource;
import com.greymatter.gmdependencyinjection.services.PrototypeBean;
import com.greymatter.gmdependencyinjection.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/*@ComponentScan(basePackages = {"com.greymatter.gmdependencyinjection", "com.greymatter.pets"})*/
@SpringBootApplication
public class GmDependencyInjectionApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(GmDependencyInjectionApplication.class, args);


        PetController petController = ctx.getBean("petController", PetController.class);
        System.out.println("--- The Best Pet is ---");
        System.out.println(petController.whichPetIsTheBest());


        MyController myController = (MyController) ctx.getBean("myController");
        System.out.println("----Primary");
        String greeting = myController.sayHello();
        System.out.println(greeting);

        I18nController i18nController = (I18nController)  ctx.getBean("i18nController");
        System.out.println("----i18N");
        System.out.println(i18nController.sayGreeting());


        System.out.println( );

        System.out.println("----Property");

        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("----Setter");

        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

        System.out.println(setterInjectedController.getGreeting());

        System.out.println("----Constructor");

        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

        System.out.println(constructorInjectedController.getGreeting());


        System.out.println("-----BEAN SCOPES----------");
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getMyScope());
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean2.getMyScope());

        PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getMyScope());

        PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.getMyScope());


        System.out.println("--------------Fake data source!!!-----");

        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUsername());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getJdbcUrl());


        System.out.println("-----------config props bean");
        GmConfiguration gmConfiguration = ctx.getBean(GmConfiguration.class);
        System.out.println(gmConfiguration.getUsername());
        System.out.println(gmConfiguration.getPassword());
        System.out.println(gmConfiguration.getJdbcUrl());

        System.out.println("-----------Constructor Binding");
        GmConstructorConfig gmConstructorConfig = ctx.getBean(GmConstructorConfig.class);
        System.out.println(gmConstructorConfig.getUsername());
        System.out.println(gmConstructorConfig.getPassword());
        System.out.println(gmConstructorConfig.getJdbcUrl());


    }

}
