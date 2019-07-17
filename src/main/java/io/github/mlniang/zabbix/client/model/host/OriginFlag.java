package io.github.mlniang.zabbix.client.model.host;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Origin of the host (readonly).
 *
 * Possible values:
 * 0 - a plain host;
 * 4 - a discovered host.
 *
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/object#host">Host object</a>
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
