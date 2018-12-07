package com.techfirebase.android.smartdustbin.ui.supervisor.abovehalf;

public class AboveHalfStatusModel {
    private String dustbinId;
    private String area;
    private String time;

    public AboveHalfStatusModel() {
    }

   public String getTime() {
        return time;
    }

    public void setTime(String time) {
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

    public AboveHalfStatusModel(String dustbinId, String area, String time) {
        this.dustbinId = dustbinId;
        this.area = area;
        this.time = time;
    }
}
