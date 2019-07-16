package io.github.mlniang.zabbix.client.model.host;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
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
