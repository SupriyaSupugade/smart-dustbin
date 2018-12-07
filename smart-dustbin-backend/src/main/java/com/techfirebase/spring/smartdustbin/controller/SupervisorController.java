package com.techfirebase.spring.smartdustbin.controller;

import com.techfirebase.spring.smartdustbin.domain.Supervisor;
import com.techfirebase.spring.smartdustbin.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author VIVEK KUMAR SINGH
 * @since (2018-04-09 13:51:25)
 */
@RestController
@RequestMapping("supervisor")
public class SupervisorController {
  private SupervisorRepository supervisorRepository;

  @Autowired
  public SupervisorController(SupervisorRepository supervisorRepository) {
    this.supervisorRepository = supervisorRepository;
  }

  @GetMapping
  public List<Supervisor> getAllSupervisors() {
    return supervisorRepository.findAll();
  }

  @GetMapping("/{mobileNo}")
  public Supervisor getSupervisorByMobileNo(@PathVariable String mobileNo) {
    return supervisorRepository.findBySupervisorMobileNo(mobileNo);
  }

  @PostMapping
  public Supervisor saveSupervisor(@RequestBody Supervisor supervisor) {
    return supervisorRepository.save(supervisor);
  }

  @PutMapping
  public Supervisor updateSupervisor(@RequestBody Supervisor supervisor) {
    return supervisorRepository.save(supervisor);
  }

  @DeleteMapping
  public void deleteSupervisor(@RequestBody Supervisor supervisor) {
    supervisorRepository.delete(supervisor);
  }
}
