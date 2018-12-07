package com.techfirebase.spring.smartdustbin.controller;

import com.techfirebase.spring.smartdustbin.domain.AreaWorker;
import com.techfirebase.spring.smartdustbin.repository.AreaWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("areaworker")
public class AreaWorkerController {
    private AreaWorkerRepository areaWorkerRepository;
    @Autowired
    public AreaWorkerController(AreaWorkerRepository areaWorkerRepository) {
        this.areaWorkerRepository = areaWorkerRepository;
    }

    @GetMapping
    public List<AreaWorker> getAllAreaWorkers() {
        return areaWorkerRepository.findAll();
    }

    @PostMapping
    public AreaWorker saveAreaWorker(@RequestBody AreaWorker areaWorker) {
        return areaWorkerRepository.save(areaWorker);
    }

    @PutMapping
    public AreaWorker updateAreaWorkers(@RequestBody AreaWorker areaWorker) {
        return areaWorkerRepository.save(areaWorker);
    }

    @DeleteMapping
    public void deleteAreaWorker(@RequestBody AreaWorker worker) {
        areaWorkerRepository.delete(worker);
    }

}
