package io.github.mlniang.zabbix.client.model.host;

import io.github.mlniang.zabbix.client.model.IZabbixMethod;

/**
 * Enum listing the different RPC methods available for Host.
 *
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host">host</a>
 * @author Mamadou Lamine NIANG
 **/
public enum HostMethod implements IZabbixMethod {

    CREATE("host.create"),
    DELETE("host.delete"),
    GET("host.get"),
    MASS_ADD("host.massadd"),
    MASS_REMOVE("host.massremove"),
    MASS_UPDATE("host.massupdate"),
    UPDATE("host.massupdate");

    private String value;

    HostMethod(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
