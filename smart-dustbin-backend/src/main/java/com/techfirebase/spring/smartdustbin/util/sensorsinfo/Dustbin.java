package com.techfirebase.spring.smartdustbin.util.sensorsinfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Dustbin {
    @JsonProperty("Items")
    private List<Item> items;

    @JsonProperty("Count")
    private int count;

    @JsonProperty("ScannedCount")
    private int scannedCount;

    @JsonProperty("LastEvaluatedKey")
    private LastEvaluatedKey lastEvaluatedKey;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getScannedCount() {
        return scannedCount;
    }

    public void setScannedCount(int scannedCount) {
        this.scannedCount = scannedCount;
    }

    public LastEvaluatedKey getLastEvaluatedKey() {
        return lastEvaluatedKey;
    }

    public void setLastEvaluatedKey(LastEvaluatedKey lastEvaluatedKey) {
        this.lastEvaluatedKey = lastEvaluatedKey;
    }
}
