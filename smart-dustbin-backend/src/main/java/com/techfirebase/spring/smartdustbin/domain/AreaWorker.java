package com.techfirebase.spring.smartdustbin.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "area_worker")
public class AreaWorker {
  @Id private int areaWorkerId;
  private int areaId;
  private String workerMobile;

  public AreaWorker() {}

  public AreaWorker(int areaWorkerId, int areaId, String workerMobile) {
    this.areaWorkerId = areaWorkerId;
    this.areaId = areaId;
    this.workerMobile = workerMobile;
  }

  public int getAreaWorkerId() {
    return areaWorkerId;
  }

  public void setAreaWorkerId(int areaWorkerId) {
    this.areaWorkerId = areaWorkerId;
  }

  public int getAreaId() {
    return areaId;
  }

  public void setAreaId(int areaId) {
    this.areaId = areaId;
  }

  public String getWorkerMobile() {
    return workerMobile;
  }

  public void setWorkerMobile(String workerId) {
    this.workerMobile = workerId;
  }
}
