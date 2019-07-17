package io.github.mlniang.zabbix.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mlniang.zabbix.client.model.GlobalMacro;
import io.github.mlniang.zabbix.client.model.host.ZabbixHostGroup;
import io.github.mlniang.zabbix.client.model.host.ZabbixHostInterface;
import io.github.mlniang.zabbix.client.model.template.Template;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Zabbix Host DTO used as parameter in host.massadd.
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/massadd">method host.massadd</a>
 *
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
@Builder
public class ZabbixMassAddHostDTO {

    public List<ZabbixHostDTO> hosts;
    public List<ZabbixHostGroup> groups;
    public List<ZabbixHostInterface> interfaces;
    public List<GlobalMacro> macros;
    @JsonProperty("templates")
    public List<Template> templates;
}
