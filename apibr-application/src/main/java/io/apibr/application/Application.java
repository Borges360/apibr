package io.apibr.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"io.apibr.cep/*"})
@EnableJpaRepositories(basePackages = {"io.apibr.cep.adapters.repository"})
@EntityScan(basePackages = {"io.apibr.cep.adapters.data"})
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}