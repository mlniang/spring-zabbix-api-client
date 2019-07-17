package io.github.mlniang.zabbix.client.model.host;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * IPMI privilege level.
 *
 * Possible values are:
 * 1 - callback;
 * 2 - (default) user;
 * 3 - operator;
 * 4 - admin;
 * 5 - OEM.
 *
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/object#host">Host object</a>
 * @author Mamadou Lamine NIANG
 **/
public enum IPMIPrivilege {

    CALLBACK(1),
    USER(2),
    OPERATOR(3),
    ADMIN(4),
    OEM(5);

    private int value;

    IPMIPrivilege(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return this.value;
    }

    @JsonCreator
    public static IPMIPrivilege fromValue(int value) {
        for(IPMIPrivilege enumValue: values()) {
            if(enumValue.value == value) {
                return enumValue;
            }
        }
        return USER;
    }
}
