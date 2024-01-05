package com.example.springbootdemo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/animals")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/all")
    public List<Animal> all() {
        return animalService.all();
    }

    @PostMapping("/add")
    public Animal add(@RequestBody Animal animal) {
//        animalService.add(animal);
        return animalService.add(animal);
    }
}
