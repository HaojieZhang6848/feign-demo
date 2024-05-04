package edu.fudan.feignconsumer.controller;

import edu.fudan.feigncommon.Fruit;
import edu.fudan.feignconsumer.client.FruitClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitConsumerController {

    @Autowired
    private FruitClient fruitClient;

    @GetMapping
    public List<Fruit> getFruits() {
        return fruitClient.getFruits();
    }

    @GetMapping("/{id}")
    public Fruit getFruit(@PathVariable Integer id) {
        return fruitClient.getFruit(id);
    }

    @PostMapping
    public void addFruit(@RequestBody Fruit fruit) {
        fruitClient.addFruit(fruit);
    }

    @PutMapping
    public void updateFruit(@RequestBody Fruit fruit) {
        fruitClient.updateFruit(fruit);
    }

    @DeleteMapping("/{id}")
    public void deleteFruit(@PathVariable Integer id) {
        fruitClient.deleteFruit(id);
    }
}
