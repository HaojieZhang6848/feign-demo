package edu.fudan.feignconsumer.client;

import edu.fudan.feigncommon.Fruit;
import edu.fudan.feignconsumer.client.fallback.FruitClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "feign-provider", url = "http://localhost:8080/fruits", fallback = FruitClientFallback.class)
public interface FruitClient {

    @GetMapping
    List<Fruit> getFruits();

    @GetMapping("/{id}")
    Fruit getFruit(@PathVariable(value = "id") Integer id);

    @PostMapping
    void addFruit(@RequestBody Fruit fruit);

    @PutMapping
    public void updateFruit(@RequestBody Fruit fruit);

    @DeleteMapping("/{id}")
    public void deleteFruit(@PathVariable(value = "id") Integer id);
}
