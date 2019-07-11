package io.github.mlniang.zabbix.client;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
public class ZabbixResponse {

    private final String jsonrpc = "2.0";
    private Object result;
    private String id;

    public <T> T getResult(Class<T> clazz) {
        return clazz.cast(result);
    }
}
