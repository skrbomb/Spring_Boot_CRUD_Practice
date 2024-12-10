package com.example.demo.config;


import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    CommandLineRunner  commandLineRunner(
            CustomerRepository customerRepository
    ){
        return args -> {
            Customer amy = new Customer(
                    "Amy",
                    18,
                    "amy@gmail.com"
            );

            Customer bob = new Customer(
                    "Bob",
                    22,
                    "bob@gmail.com"
            );

            customerRepository.saveAll(List.of(amy,bob));


        };
    }
}
