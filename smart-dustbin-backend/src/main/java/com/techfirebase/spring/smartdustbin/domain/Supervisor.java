package com.techfirebase.spring.smartdustbin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author VIVEK KUMAR SINGH
 * @since (2018-04-09 13:52:58)
 */
@Entity
public class Supervisor implements Serializable {
  @Id
  @Column(name = "supervisorId")
  private int supervisorId;

  @Column(name = "supervisorName")
  private String supervisorName;

  @Column(name = "emailId")
  private String supervisorEmail;

  @Column(name = "mobileNo")
  private String supervisorMobileNo;

  @Column(name = "password")
  private String supervisorPassword;

  @Column(name = "adharNo")
  private String supervisorAdharNo;

  /*@Column(name = "timestamp")
  private long timestamp;

  @Column(name = "sync_pending")
  private boolean syncPending;*/

  public Supervisor() {}

  public Supervisor(
      int supervisorId,
      String supervisorName,
      String supervisorEmail,
      String supervisorMobileNo,
      String supervisorPassword,
      String supervisorAdharNo) {
    this.supervisorId = supervisorId;
    this.supervisorName = supervisorName;
    this.supervisorEmail = supervisorEmail;
    this.supervisorMobileNo = supervisorMobileNo;
    this.supervisorPassword = supervisorPassword;
    this.supervisorAdharNo = supervisorAdharNo;
  }

  public int getSupervisorId() {
    return supervisorId;
  }

  public void setSupervisorId(int supervisorId) {
    this.supervisorId = supervisorId;
  }

  public String getSupervisorName() {
    return supervisorName;
  }

  public void setSupervisorName(String supervisorName) {
    this.supervisorName = supervisorName;
  }

  public String getSupervisorEmail() {
    return supervisorEmail;
  }

  public void setSupervisorEmail(String supervisorEmail) {
    this.supervisorEmail = supervisorEmail;
  }

  public String getSupervisorMobileNo() {
    return supervisorMobileNo;
  }

  public void setSupervisorMobileNo(String supervisorMobileNo) {
    this.supervisorMobileNo = supervisorMobileNo;
  }

  public String getSupervisorPassword() {
    return supervisorPassword;
  }

  public void setSupervisorPassword(String supervisorPassword) {
    this.supervisorPassword = supervisorPassword;
  }

  public String getSupervisorAdharNo() {
    return supervisorAdharNo;
  }

  public void setSupervisorAdharNo(String supervisorAdharNo) {
    this.supervisorAdharNo = supervisorAdharNo;
  }
}
