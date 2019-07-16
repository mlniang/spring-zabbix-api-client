package io.github.mlniang.zabbix.client.model.host;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Mamadou Lamine NIANG
 **/
public enum MaintenanceStatus {

    NO(0),
    IN_EFFECT(1);

    private int value;

    MaintenanceStatus(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return this.value;
    }

    @JsonCreator
    public static MaintenanceStatus fromValue(int value) {
        for(MaintenanceStatus enumValue: values()) {
            if(enumValue.value == value) {
                return enumValue;
            }
        }
        return NO;
    }
}
