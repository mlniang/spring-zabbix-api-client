package io.github.mlniang.zabbix.client.model.host;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Mamadou Lamine NIANG
 **/
public enum InventoryMode {

    DISABLED(-1),
    MANUAL(0),
    AUTOMATIC(1);

    private int value;

    InventoryMode(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return this.value;
    }

    @JsonCreator
    public static InventoryMode fromValue(int value) {
        for(InventoryMode enumValue: values()) {
            if(enumValue.value == value) {
                return enumValue;
            }
        }
        return MANUAL;
    }
}
