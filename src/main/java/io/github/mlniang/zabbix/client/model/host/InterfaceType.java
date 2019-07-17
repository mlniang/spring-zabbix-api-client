package io.github.mlniang.zabbix.client.model.host;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Type of a host interface.
 * Possible values are:
 * 1 - agent;
 * 2 - SNMP;
 * 3 - IPMI;
 * 4 - JMX.
 *
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/hostinterface/object#host_interface">Host interface</a>
 * @author Mamadou Lamine NIANG
 **/
public enum InterfaceType {

    AGENT(1),
    SNMP(2),
    IPMI(3),
    JMX(4);

    private int value;

    InterfaceType(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return this.value;
    }

    @JsonCreator
    public static InterfaceType fromValue(int value) {
        for(InterfaceType interfaceType: values()) {
            if(interfaceType.value == value) {
                return interfaceType;
            }
        }
        return null;
    }
}
