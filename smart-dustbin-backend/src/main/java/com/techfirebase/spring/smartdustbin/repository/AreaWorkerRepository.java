package com.techfirebase.spring.smartdustbin.repository;

import com.techfirebase.spring.smartdustbin.domain.AreaWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaWorkerRepository extends JpaRepository<AreaWorker, Integer> {
}
