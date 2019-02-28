package com.rest.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/**
 * Spring Boot main Application
 *
 */
@SpringBootApplication
@EnableAutoConfiguration (exclude = { DataSourceAutoConfiguration.class })
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        SpringApplication.run(App.class, args);
    }
    
    
}
