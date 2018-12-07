package com.techfirebase.spring.smartdustbin.repository;

import com.techfirebase.spring.smartdustbin.domain.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author VIVEK KUMAR SINGH
 * @since (2018-04-09 13:56:21)
 */
@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {
  Supervisor findBySupervisorMobileNo(String supervisorMobileNo);
}
