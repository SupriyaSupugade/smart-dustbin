package com.techfirebase.android.smartdustbin.domain;

public class Supervisor {

  private int supervisorId;

  private String supervisorName;

  private String supervisorEmail;

  private String supervisorMobileNo;

  private String supervisorPassword;

  private String supervisorAdharNo;

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
