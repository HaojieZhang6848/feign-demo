package edu.fudan.feignprovider.controller;

import edu.fudan.feigncommon.FruitVo;
import edu.fudan.feignprovider.entity.Fruit;
import edu.fudan.feignprovider.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private FruitRepository fruitRepository;

    @GetMapping
    public List<FruitVo> getFruits() {
        List<FruitVo> fruitVoList = new ArrayList<>();
        fruitRepository.findAll().forEach(fruit -> {
            fruitVoList.add(FruitVo.builder().id(fruit.getId().intValue()).name(fruit.getName()).color(fruit.getColor()).origin(fruit.getOrigin()).build());
        });
        return fruitVoList;
    }

    @GetMapping("/{id}")
    public FruitVo getFruit(@PathVariable Integer id) {
        Fruit fruit = fruitRepository.findOne(id.longValue());
        return FruitVo.builder().id(fruit.getId().intValue()).name(fruit.getName()).color(fruit.getColor()).origin(fruit.getOrigin()).build();
    }

    @PostMapping
    public void addFruit(@RequestBody FruitVo fruitVo) {
        float x = new SecureRandom().nextFloat();
        if (x < 0.5) {
            throw new RuntimeException("Random exception");
        }
        Fruit fruit = Fruit.builder().id(fruitVo.getId().longValue()).name(fruitVo.getName()).color(fruitVo.getColor()).origin(fruitVo.getOrigin()).build();
        fruitRepository.save(fruit);
    }

    @PutMapping
    public void updateFruit(@RequestBody FruitVo fruitVo) {
        Fruit fruit = Fruit.builder().id(fruitVo.getId().longValue()).name(fruitVo.getName()).color(fruitVo.getColor()).origin(fruitVo.getOrigin()).build();
        fruitRepository.save(fruit);
    }

    @DeleteMapping("/{id}")
    public void deleteFruit(@PathVariable Integer id) {
        fruitRepository.delete(id.longValue());
    }
}
