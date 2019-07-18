package io.github.mlniang.zabbix.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents an Zabbix authentication DTO.
 *
 * @author Mamadou Lamine NIANG
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ZabbixAuthDTO {

    private String user;
    private String password;
}
