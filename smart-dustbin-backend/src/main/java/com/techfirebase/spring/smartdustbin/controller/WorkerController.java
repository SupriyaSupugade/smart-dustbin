package com.techfirebase.spring.smartdustbin.controller;

import com.techfirebase.spring.smartdustbin.domain.Worker;
import com.techfirebase.spring.smartdustbin.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author VIVEK KUMAR SINGH
 * @since (2018-04-09 13:59:18)
 */
@RestController
@RequestMapping("worker")
public class WorkerController {
  private WorkerRepository workerRepository;

  @Autowired
  public WorkerController(WorkerRepository workerRepository) {
    this.workerRepository = workerRepository;
  }

  @GetMapping
  public List<Worker> getAllWorkers() {
    return workerRepository.findAll();
  }

  @GetMapping("/{mobileNo}")
  public Worker getWorkerByMobileNo(@PathVariable String mobileNo) {
    return workerRepository.findByWorkerMobileNo(mobileNo);
  }

  @PostMapping
  public Worker saveWorker(@RequestBody Worker worker) {
    return workerRepository.save(worker);
  }

  @PutMapping
  public Worker updateWorkers(@RequestBody Worker worker) {
    return workerRepository.save(worker);
  }

  @DeleteMapping
  public void deleteWorker(@RequestBody Worker worker) {
    workerRepository.delete(worker);
  }
}
