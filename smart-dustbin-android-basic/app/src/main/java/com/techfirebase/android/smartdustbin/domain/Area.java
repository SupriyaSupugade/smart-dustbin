package com.techfirebase.android.smartdustbin.domain;

public class Area {

  private int areaId;

  private String areaName;

  /* @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
          name = "Area_Worker",
          joinColumns = {@JoinColumn(name = "Area_Id", referencedColumnName = "area_id")},
          inverseJoinColumns = {@JoinColumn(name = "Worker_Id", referencedColumnName = "worker_id")}
  )*/
//  private List<Worker> workers = new ArrayList<>();

  public Area() {}

  public Area(int areaId, String areaName, String dustbinId) {
    this.areaId = areaId;
    this.areaName = areaName;
//    this.workers = workers;
  }

  public int getAreaId() {
    return areaId;
  }

  public void setAreaId(int areaId) {
    this.areaId = areaId;
  }

  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }

  /*public List<Worker> getWorkers() {
    return workers;
  }

  public void setWorkers(List<Worker> workers) {
    this.workers = workers;
  }
*/}
