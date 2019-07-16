package io.github.mlniang.zabbix.client.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mlniang.zabbix.client.model.host.HostInventoryProperty;
import io.github.mlniang.zabbix.client.model.host.ZabbixHost;
import io.github.mlniang.zabbix.client.model.host.ZabbixHostGroup;
import io.github.mlniang.zabbix.client.model.host.ZabbixHostInterface;
import io.github.mlniang.zabbix.client.model.template.Template;
import io.github.mlniang.zabbix.client.model.user.UserMacro;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class ZabbixHostDTO extends ZabbixHost {

    public List<ZabbixHostGroup> groups;
    public List<ZabbixHostInterface> interfaces;
    @JsonProperty("templates")
    @JsonAlias("parentTemplates")
    public List<Template> templates;
    public List<UserMacro> macros;
    public Map<HostInventoryProperty, String> inventory;
}
