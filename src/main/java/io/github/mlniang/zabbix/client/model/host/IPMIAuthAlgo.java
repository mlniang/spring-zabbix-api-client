package io.github.mlniang.zabbix.client.model.host;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * IPMI authentication algorithm.
 *
 * Possible values are:
 * -1 - (default) default;
 * 0 - none;
 * 1 - MD2;
 * 2 - MD5
 * 4 - straight;
 * 5 - OEM;
 * 6 - RMCP+.
 *
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/object#host">Host object</a>
 * @author Mamadou Lamine NIANG
 **/
public enum IPMIAuthAlgo {

    DEFAULT(-1),
    NONE(0),
    MD2(1),
    MD5(2),
    STRAIGHT(4),
    OEM(5),
    RMCP_PLUS(6);

    private int value;

    IPMIAuthAlgo(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return this.value;
    }

    @JsonCreator
    public static IPMIAuthAlgo fromValue(int value) {
        for(IPMIAuthAlgo enumValue: values()) {
            if(enumValue.value == value) {
                return enumValue;
            }
        }
        return DEFAULT;
    }
}
