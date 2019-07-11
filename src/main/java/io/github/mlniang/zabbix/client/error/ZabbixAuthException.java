package io.github.mlniang.zabbix.client.error;

/**
 * @author Mamadou Lamine NIANG
 **/
public class ZabbixAuthException extends Exception {

    public ZabbixAuthException(String message) {
        super(message);
    }

    public ZabbixAuthException(int httpCode) {
        super(String.format("Auth failed with code %d.", httpCode));
    }
}
