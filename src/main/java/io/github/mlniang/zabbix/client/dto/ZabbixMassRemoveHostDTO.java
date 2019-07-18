package io.github.mlniang.zabbix.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mlniang.zabbix.client.model.GlobalMacro;
import io.github.mlniang.zabbix.client.model.host.ZabbixHostInterface;
import lombok.*;

import java.util.List;

/**
 * Zabbix Host DTO used as parameter in method host.massremove
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/massremove">method host.massremove</a>
 *
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ZabbixMassRemoveHostDTO {

    @JsonProperty("hostids")
    @Singular
    private List<String> ids;
    @JsonProperty("groupids")
    @Singular
    private List<String> groupIds;
    @Singular
    private List<ZabbixHostInterface> interfaces;
    @Singular
    private List<GlobalMacro> macros;
    @JsonProperty("templateids")
    @Singular
    private List<String> templateIds;
    @JsonProperty("templateids_clear")
    private List<String> templateToClearIds;
}
