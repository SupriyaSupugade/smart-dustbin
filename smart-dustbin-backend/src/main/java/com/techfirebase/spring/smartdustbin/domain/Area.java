package com.techfirebase.spring.smartdustbin.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author VIVEK KUMAR SINGH
 * @since (2018-04-09 16:03:00)
 */
@Entity
public class Area implements Serializable {
  @Id
  private int areaId;

  private String areaName;

  /*@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
    name = "area_worker",
    joinColumns = {@JoinColumn(referencedColumnName = "areaId")},
    inverseJoinColumns = {@JoinColumn(referencedColumnName = "mobileNo")}
  )*/
//  private List<Worker> workers = new ArrayList<>();

  public Area() {}

  public Area(int areaId, String areaName, List<Worker> workers) {
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
  }*/
}
