package com.example.springbootdemo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> all() {
        return animalRepository.findAll();
    }

    public Animal add(Animal animal) {
        var result = animalRepository.save(animal);
        return result;
    }
}
