package com.example.springbootdemo.animal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfig {

    @Bean
    CommandLineRunner commandLineRunner(AnimalRepository repository) {
        return args -> {
            var a1 = new Animal(
                    "Oskar",
                    "cat"
            );

            repository.save(a1);
        };
    }
}
