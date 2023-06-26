package com.hakaryzhang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableWorker
public class SpringbootAutoConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAutoConfigurationApplication.class, args);
    }

}
