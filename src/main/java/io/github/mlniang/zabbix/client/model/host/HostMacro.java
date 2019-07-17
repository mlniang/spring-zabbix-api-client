package io.github.mlniang.zabbix.client.model.host;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Host Macro.
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/usermacro/object#host_macro">Host macro</a>
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
public class HostMacro {

    @JsonProperty("hostmacroid")
    private String id;
    @JsonProperty("hostid")
    private String hostId;
    private String macro;
    private String value;
}
