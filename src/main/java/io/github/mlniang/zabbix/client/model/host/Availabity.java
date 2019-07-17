package io.github.mlniang.zabbix.client.model.host;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Availability of Zabbix agent (readonly).
 * Possible values are:
 * 0 - (default) unknown;
 * 1 - available;
 * 2 - unavailable.
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/object#host">Host object</a>
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
