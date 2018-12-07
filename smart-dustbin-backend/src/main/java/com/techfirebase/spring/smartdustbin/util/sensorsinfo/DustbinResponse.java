package com.techfirebase.spring.smartdustbin.util.sensorsinfo;

import com.techfirebase.spring.smartdustbin.domain.Area;

public class DustbinResponse {
    private Area area;
    private String timestamp;

    public DustbinResponse(Area area, String timestamp) {
        this.area = area;
        this.timestamp = timestamp;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
