package com.jad.datamanagement;

import com.jad.sensordata.ISensor;
import com.jad.sensordata.SensorData;
import com.jad.sensordata.SensorType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DataCollector {
    private final ISensor sensor;
    private final List<SensorData> collectedData = new ArrayList<>();

    public DataCollector(final ISensor sensor) {
        this.sensor = sensor;
    }

    public final SensorType getSensorType() {
        return this.sensor.getSensorType();
    }

    public final void collectData() {
        this.collectedData.add(this.sensor.getSensorData());
    }

    public final List<SensorData> getAllCollectedData() {
        return Collections.unmodifiableList(this.collectedData);
    }

    public final void clearCollectedData() {
        this.collectedData.clear();
    }
}
