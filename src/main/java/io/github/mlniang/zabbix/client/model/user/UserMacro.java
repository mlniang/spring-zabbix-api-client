package io.github.mlniang.zabbix.client.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
public class UserMacro {

    @JsonProperty("globalmacroid")
    private String id;
    private String macro;
    private String value;
}
