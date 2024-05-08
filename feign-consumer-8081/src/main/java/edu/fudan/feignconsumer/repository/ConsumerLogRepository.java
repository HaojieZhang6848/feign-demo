package edu.fudan.feignconsumer.repository;

import edu.fudan.feignconsumer.entity.ConsumerLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerLogRepository extends JpaRepository<ConsumerLog, Long> {
}
