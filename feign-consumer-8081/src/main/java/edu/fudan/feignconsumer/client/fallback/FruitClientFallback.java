package edu.fudan.feignconsumer.client.fallback;

import edu.fudan.feigncommon.Fruit;
import edu.fudan.feignconsumer.client.FruitClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FruitClientFallback implements FruitClient {
    @Override
    public List<Fruit> getFruits() {
        return new ArrayList<>();
    }

    @Override
    public Fruit getFruit(Integer id) {
        return Fruit.builder().id(-1).name("default").color("default").origin("default").build();
    }

    @Override
    public void addFruit(Fruit fruit) {
        throw new RuntimeException("add fruit failed");
    }

    @Override
    public void updateFruit(Fruit fruit) {
        throw new RuntimeException("update fruit failed");
    }

    @Override
    public void deleteFruit(Integer id) {
        throw new RuntimeException("delete fruit failed");
    }
}
