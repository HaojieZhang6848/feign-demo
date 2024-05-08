package edu.fudan.feignconsumer.client.fallback;

import edu.fudan.feigncommon.FruitVo;
import edu.fudan.feignconsumer.client.FruitClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FruitClientFallback implements FruitClient {
    @Override
    public List<FruitVo> getFruits() {
        return new ArrayList<>();
    }

    @Override
    public FruitVo getFruit(Integer id) {
        return FruitVo.builder().id(-1).name("default").color("default").origin("default").build();
    }

    @Override
    public void addFruit(FruitVo fruitVo) {
        throw new RuntimeException("add fruit failed");
    }

    @Override
    public void updateFruit(FruitVo fruitVo) {
        throw new RuntimeException("update fruit failed");
    }

    @Override
    public void deleteFruit(Integer id) {
        throw new RuntimeException("delete fruit failed");
    }
}
