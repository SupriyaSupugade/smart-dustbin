package com.techfirebase.android.smartdustbin.domain;

public class Worker {

  private int workerId;

  private String workerName;

  private String workerAddress;

  private String workerMobileNo;

  private String workerAdharNo;

  private String workerPassword;

  private int supervisorId;

  /*@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "workers")
  //  @JoinTable(
  //    name = "Area_Worker",
  //    joinColumns = {@JoinColumn(name = "Worker_Id", referencedColumnName = "worker_id")},
  //    inverseJoinColumns = {@JoinColumn(name = "Area_Id", referencedColumnName = "area_id")}
  //  )

      private Set<Area> areas = new HashSet<>(); add Set<Area> areas into constructor*/

  public Worker() {}

  public Worker(
      int workerId,
      String workerName,
      String workerAddress,
      String workerMobileNo,
      String workerAdharNo,
      String workerPassword,
      int supervisorId) {
    this.workerId = workerId;
    this.workerName = workerName;
    this.workerAddress = workerAddress;
    this.workerMobileNo = workerMobileNo;
    this.workerAdharNo = workerAdharNo;
    this.workerPassword = workerPassword;
    this.supervisorId = supervisorId;
    // this.areas = areas;
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

  public int getSupervisorId() {
    return supervisorId;
  }

  public void setSupervisorId(int supervisorId) {
    this.supervisorId = supervisorId;
  }

  /*public Set<Area> getAreas() {
      return areas;
  }

  public void setAreas(Set<Area> areas) {
      this.areas = areas;
  }*/
}
