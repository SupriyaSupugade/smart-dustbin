package com.techfirebase.spring.smartdustbin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author VIVEK KUMAR SINGH
 * @since (2018-04-09 14:07:38)
 */
@Entity
public class DustbinDetail {
  @Id
  private int dustbinDetailId;

  private String dustbinId;

  private String sensorId;

  private String latitude;

  private String longitude;

  private int areaId;

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public int getAreaId() {
    return areaId;
  }

  public void setAreaId(int areaId) {
    this.areaId = areaId;
  }

  /*@Column(name = "timestamp")
  private long timestamp;

  @Column(name = "sync_pending")
  private boolean syncPending;*/

  public DustbinDetail() {}

  public DustbinDetail(
      int dustbinDetailId,
      String dustbinId,
      String sensorId,
      String latitude,
      String longitude,
      int areaid) {
    this.dustbinDetailId = dustbinDetailId;
    this.dustbinId = dustbinId;
    this.sensorId = sensorId;
    this.latitude = latitude;
    this.longitude = longitude;
    this.areaId = areaid;
  }

  public int getDustbinDetailId() {
    return dustbinDetailId;
  }

  public void setDustbinDetailId(int dustbinDetailId) {
    this.dustbinDetailId = dustbinDetailId;
  }

  public String getDustbinId() {
    return dustbinId;
  }

  public void setDustbinId(String dustbinId) {
    this.dustbinId = dustbinId;
  }

  public String getSensorId() {
    return sensorId;
  }

  public void setSensorId(String sensorId) {
    this.sensorId = sensorId;
  }
}
