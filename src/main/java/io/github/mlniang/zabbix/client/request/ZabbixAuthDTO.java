package io.github.mlniang.zabbix.client.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZabbixAuthDTO {

    private String user;
    private String password;
}
