package com.techfirebase.spring.smartdustbin.controller;

import com.techfirebase.spring.smartdustbin.domain.DustbinDetail;
import com.techfirebase.spring.smartdustbin.repository.DustbinDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author VIVEK KUMAR SINGH
 * @since (2018-04-09 14:06:00)
 */
@RestController
@RequestMapping("dustbinDetail")
public class DustbinDetailController {
  private DustbinDetailRepository dustbinDetailRepository;

  @Autowired
  public DustbinDetailController(DustbinDetailRepository dustbinDetailRepository) {
    this.dustbinDetailRepository = dustbinDetailRepository;
  }

  @GetMapping
  public List<DustbinDetail> getAllDustbinDetails() {
    return dustbinDetailRepository.findAll();
  }

  @PostMapping
  public DustbinDetail saveDustbinDetail(@RequestBody DustbinDetail dustbinDetail) {
    return dustbinDetailRepository.save(dustbinDetail);
  }

  @PutMapping
  public DustbinDetail updateWorkers(@RequestBody DustbinDetail dustbinDetail) {
    return dustbinDetailRepository.save(dustbinDetail);
  }

  @DeleteMapping
  public void deleteWorker(@RequestBody DustbinDetail dustbinDetail) {
    dustbinDetailRepository.delete(dustbinDetail);
  }
}
