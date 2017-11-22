package com.ems.controller;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ems")
public class Application{
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        BasicConfigurator.configure();
    }

}
