package edu.fudan.feignprovider.repository;

import edu.fudan.feignprovider.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
}
