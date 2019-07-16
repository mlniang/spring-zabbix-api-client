package io.github.mlniang.zabbix.client.model.host;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Mamadou Lamine NIANG
 **/
public enum OriginFlag {

    PLAIN(0),
    DISCOVERED(4);

    private int value;

    OriginFlag(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return this.value;
    }

    @JsonCreator
    public static OriginFlag fromValue(int value) {
        for(OriginFlag enumValue: values()) {
            if(enumValue.value == value) {
                return enumValue;
            }
        }
        return null;
    }
}
