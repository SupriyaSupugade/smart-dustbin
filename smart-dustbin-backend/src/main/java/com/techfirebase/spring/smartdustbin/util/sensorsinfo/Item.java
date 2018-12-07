package com.techfirebase.spring.smartdustbin.util.sensorsinfo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    private String timestamp;

    @JsonProperty("envn_data")
    private EnvnData envnData;

    @JsonProperty("Device_ID")
    private String deviceId;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public EnvnData getEnvnData() {
        return envnData;
    }

    public void setEnvnData(EnvnData envnData) {
        this.envnData = envnData;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
