package com.techfirebase.spring.smartdustbin.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author VIVEK KUMAR SINGH
 * @since (2018-04-09 14:00:59)
 */
@Entity
public class Worker implements Serializable {
  @Id
  @Column(name = "workerId")
  private int workerId;

  @Column(name = "workerName")
  private String workerName;

  @Column(name = "address")
  private String workerAddress;

  @Column(name = "mobileNo")
  private String workerMobileNo;

  @Column(name = "adharNo")
  private String workerAdharNo;

  @Column(name = "password")
  private String workerPassword;

  @Column(name = "supervisorId")
  private int supervisorId;

  /*@Column(name = "timestamp")
  private long timestamp;

  @Column(name = "sync_pending")
  private boolean syncPending;*/

  //  @ManyToMany(
  //      cascade = {CascadeType.PERSIST, CascadeType.MERGE},
  //      mappedBy = "workers")
  //  @JoinTable(
  //    name = "Area_Worker",
  //    joinColumns = {@JoinColumn(name = "Worker_Id", referencedColumnName = "worker_id")},
  //    inverseJoinColumns = {@JoinColumn(name = "Area_Id", referencedColumnName = "area_id")}
  //  )
  //  @JsonBackReference
  //  private Set<Area> areas = new HashSet<>();

  public Worker() {}

  public int getSupervisorId() {
    return supervisorId;
  }

  public void setSupervisorId(int supervisorId) {
    this.supervisorId = supervisorId;
  }

  public Worker(
      int workerId,
      String workerName,
      String workerAddress,
      String workerMobileNo,
      String workerAdharNo,
      String workerPassword,
      int supervisorId /*,
      Set<Area> areas*/) {
    this.workerId = workerId;
    this.workerName = workerName;
    this.workerAddress = workerAddress;
    this.workerMobileNo = workerMobileNo;
    this.workerAdharNo = workerAdharNo;
    this.workerPassword = workerPassword;
    this.supervisorId = supervisorId;
  }

  public int getWorkerId() {
    return workerId;
  }

  public void setWorkerId(int workerId) {
    this.workerId = workerId;
  }

  public String getWorkerName() {
    return workerName;
  }

  public void setWorkerName(String workerName) {
    this.workerName = workerName;
  }

  public String getWorkerAddress() {
    return workerAddress;
  }

  public void setWorkerAddress(String workerAddress) {
    this.workerAddress = workerAddress;
  }

  public String getWorkerMobileNo() {
    return workerMobileNo;
  }

  public void setWorkerMobileNo(String workerMobileNo) {
    this.workerMobileNo = workerMobileNo;
  }

  public String getWorkerAdharNo() {
    return workerAdharNo;
  }

  public void setWorkerAdharNo(String workerAdharNo) {
    this.workerAdharNo = workerAdharNo;
  }

  public String getWorkerPassword() {
    return workerPassword;
  }

  public void setWorkerPassword(String workerPassword) {
    this.workerPassword = workerPassword;
  }

  /*public Set<Area> getAreas() {
      return areas;
    }

    public void setAreas(Set<Area> areas) {
      this.areas = areas;
    }
  */ }
