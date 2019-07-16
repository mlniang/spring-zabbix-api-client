package io.github.mlniang.zabbix.client.model.host;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
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
