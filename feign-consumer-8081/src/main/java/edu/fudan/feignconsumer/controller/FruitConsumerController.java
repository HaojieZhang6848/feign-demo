package edu.fudan.feignconsumer.controller;

import edu.fudan.feigncommon.FruitVo;
import edu.fudan.feignconsumer.client.FruitClient;
import edu.fudan.feignconsumer.entity.ConsumerLog;
import edu.fudan.feignconsumer.repository.ConsumerLogRepository;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitConsumerController {

    @Qualifier("edu.fudan.feignconsumer.client.FruitClient")
    @Autowired
    private FruitClient fruitClient;

    @Autowired
    private ConsumerLogRepository consumerLogRepository;

    @GetMapping
    public List<FruitVo> getFruits(HttpServletRequest request) {
        saveLog(request);
        return fruitClient.getFruits();
    }

    @GetMapping("/{id}")
    public FruitVo getFruit(@PathVariable Integer id, HttpServletRequest request) {
        saveLog(request);
        return fruitClient.getFruit(id);
    }

    @PostMapping
    @GlobalTransactional
    public void addFruit(@RequestBody FruitVo fruitVo, HttpServletRequest request) {
        saveLog(request);
        fruitClient.addFruit(fruitVo);
    }

    @PutMapping
    @GlobalTransactional
    public void updateFruit(@RequestBody FruitVo fruitVo, HttpServletRequest request) {
        saveLog(request);
        fruitClient.updateFruit(fruitVo);
    }

    @DeleteMapping("/{id}")
    @GlobalTransactional
    public void deleteFruit(@PathVariable Integer id, HttpServletRequest request) {
        saveLog(request);
        fruitClient.deleteFruit(id);
    }

    private void saveLog(HttpServletRequest request) {
        ConsumerLog cl = ConsumerLog.builder().path(request.getRequestURI()).method(request.getMethod()).datetime(new java.util.Date()).build();
        consumerLogRepository.save(cl);
    }
}
