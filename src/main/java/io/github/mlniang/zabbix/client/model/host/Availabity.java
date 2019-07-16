package io.github.mlniang.zabbix.client.model.host;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Mamadou Lamine NIANG
 **/
public enum Availabity {

    UNKNOWN(0),
    AVAILABLE(1),
    UNAVAILABLE(2);

    private int value;

    Availabity(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return this.value;
    }

    @JsonCreator
    public static Availabity fromValue(int value) {
        for(Availabity enumValue: values()) {
            if(enumValue.value == value) {
                return enumValue;
            }
        }
        return UNKNOWN;
    }
}
