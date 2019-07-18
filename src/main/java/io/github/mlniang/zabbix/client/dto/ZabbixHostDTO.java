package io.github.mlniang.zabbix.client.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mlniang.zabbix.client.model.GlobalMacro;
import io.github.mlniang.zabbix.client.model.host.HostInventoryProperty;
import io.github.mlniang.zabbix.client.model.host.ZabbixHost;
import io.github.mlniang.zabbix.client.model.host.ZabbixHostGroup;
import io.github.mlniang.zabbix.client.model.host.ZabbixHostInterface;
import io.github.mlniang.zabbix.client.model.template.Template;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;

/**
 * Zabbix Host DTO used as parameter in method host.create and returned in host.get.
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/create">method host.create</a>
 *
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class ZabbixHostDTO extends ZabbixHost {

    @Singular
    private List<ZabbixHostGroup> groups;
    @Singular
    private List<ZabbixHostInterface> interfaces;
    @JsonProperty("templates")
    @JsonAlias("parentTemplates")
    @Singular
    private List<Template> templates;
    @Singular
    private List<GlobalMacro> macros;
    private Map<HostInventoryProperty, String> inventory;
    @JsonProperty("templates_clear")
    @Singular("templateToClear")
    private List<Template> templatesToClear;
}
