package com.techfirebase.android.smartdustbin.ui.supervisor.half;

public class HalfStatusModel {
    private String dustbinId;
    private String area;
    private String time;

    public HalfStatusModel() {
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

    public HalfStatusModel(String dustbinId, String area ,String time) {
        this.dustbinId = dustbinId;
        this.area = area;
        this.time = time;
    }
}
