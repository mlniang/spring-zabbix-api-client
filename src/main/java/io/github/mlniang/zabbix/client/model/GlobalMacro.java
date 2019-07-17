package io.github.mlniang.zabbix.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Zabbix Global macro.
 *
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/usermacro/object#global_macro">Global macro</a>
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
public class GlobalMacro {

    @JsonProperty("globalmacroid")
    private String id;
    private String macro;
    private String value;
}
