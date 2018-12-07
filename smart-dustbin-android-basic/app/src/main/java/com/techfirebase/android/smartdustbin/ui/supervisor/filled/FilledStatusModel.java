package com.techfirebase.android.smartdustbin.ui.supervisor.filled;

public class FilledStatusModel {
  private String dustbinId;
  private String area;
  private String workerName;
  private String workerMobileNo;
  private String time;

  public String getWorkerMobileNo() {
    return workerMobileNo;
  }

  public void setWorkerMobileNo(String workerMobileNo) {
    this.workerMobileNo = workerMobileNo;
  }

  public FilledStatusModel() {}

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getWorkerName() {
    return workerName;
  }

  public void setWorkerName(String workerName) {
    this.workerName = workerName;
  }

  public FilledStatusModel(String dustbinId, String area, String workerName, String workerMobileNo, String time) {
    this.dustbinId = dustbinId;
    this.area = area;
    this.workerName = workerName;
    this.workerMobileNo = workerMobileNo;
    this.time = time;
  }

  public String getDustbinId() {
    return dustbinId;
  }

  public void setDustbinId(String dustbinId) {
    this.dustbinId = dustbinId;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }
}
