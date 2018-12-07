package com.techfirebase.spring.smartdustbin.repository;

import com.techfirebase.spring.smartdustbin.domain.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author VIVEK KUMAR SINGH
 * @since (2018-04-09 14:02:34)
 */
@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {
  Worker findByWorkerMobileNo(String workerMobileNo);
}
