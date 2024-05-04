package edu.fudan.feignprovider.controller;

import edu.fudan.feigncommon.Fruit;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitController {

    private final List<Fruit> fruit = new ArrayList<>();

    @PostConstruct
    public void init() {
        fruit.add(Fruit.builder().id(1).name("apple").color("red").origin("China").build());
        fruit.add(Fruit.builder().id(2).name("banana").color("yellow").origin("China").build());
        fruit.add(Fruit.builder().id(3).name("grape").color("purple").origin("China").build());
        fruit.add(Fruit.builder().id(4).name("orange").color("orange").origin("China").build());
    }

    @GetMapping
    public List<Fruit> getFruits() {
        return fruit;
    }

    @GetMapping("/{id}")
    public Fruit getFruit(@PathVariable Integer id) {
        return this.fruit.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public void addFruit(@RequestBody Fruit fruit) {
        this.fruit.add(fruit);
    }

    @PutMapping
    public void updateFruit(@RequestBody Fruit fruit) {
        this.fruit.stream()
                .filter(f -> f.getId().equals(fruit.getId()))
                .forEach(f -> {
                    f.setName(fruit.getName());
                    f.setColor(fruit.getColor());
                    f.setOrigin(fruit.getOrigin());
                });
    }

    @DeleteMapping("/{id}")
    public void deleteFruit(@PathVariable Integer id) {
        this.fruit.removeIf(f -> f.getId().equals(id));
    }
}
