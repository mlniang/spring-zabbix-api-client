package io.github.mlniang.zabbix.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mlniang.zabbix.client.model.GlobalMacro;
import io.github.mlniang.zabbix.client.model.host.HostInventoryProperty;
import io.github.mlniang.zabbix.client.model.host.InventoryMode;
import io.github.mlniang.zabbix.client.model.host.ZabbixHostGroup;
import io.github.mlniang.zabbix.client.model.host.ZabbixHostInterface;
import io.github.mlniang.zabbix.client.model.template.Template;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Zabbix Host DTO used as parameter in host.massupdate.
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/massupdate">method host.massupdate</a>
 *
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
@Builder
public class ZabbixMassUpdateHostDTO {

    private List<ZabbixHostDTO> hosts;
    private List<ZabbixHostGroup> groups;
    private List<ZabbixHostInterface> interfaces;
    private Map<HostInventoryProperty, String> inventory;
    @JsonProperty("inventory_mode")
    private InventoryMode inventoryMode;
    private List<GlobalMacro> macros;
    @JsonProperty("templates")
    private List<Template> templates;
    @JsonProperty("templates_clear")
    private List<Template> templateToClear;
}
