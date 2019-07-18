package io.github.mlniang.zabbix.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mlniang.zabbix.client.model.GlobalMacro;
import io.github.mlniang.zabbix.client.model.host.ZabbixHostGroup;
import io.github.mlniang.zabbix.client.model.host.ZabbixHostInterface;
import io.github.mlniang.zabbix.client.model.template.Template;
import lombok.*;

import java.util.List;

/**
 * Zabbix Host DTO used as parameter in host.massadd.
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/massadd">method host.massadd</a>
 *
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ZabbixMassAddHostDTO {

    @Singular
    private List<ZabbixHostDTO> hosts;
    @Singular
    private List<ZabbixHostGroup> groups;
    @Singular
    private List<ZabbixHostInterface> interfaces;
    @Singular
    private List<GlobalMacro> macros;
    @JsonProperty("templates")
    @Singular
    private List<Template> templates;
}
