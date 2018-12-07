package com.techfirebase.spring.smartdustbin.util.sensorsinfo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LastEvaluatedKey {
    private String timestamp;

    @JsonProperty("Device_ID")
    private String deviceId;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

}
