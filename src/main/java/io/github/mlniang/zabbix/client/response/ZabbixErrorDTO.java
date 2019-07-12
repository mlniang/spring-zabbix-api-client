package io.github.mlniang.zabbix.client.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
public class ZabbixErrorDTO {

    private int code;
    private String message;
    private String data;
}
