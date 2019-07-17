package io.github.mlniang.zabbix.client.model.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Zabbix template object.
 *
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/template/object#template">Template</a>
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
public class Template {

    @JsonProperty("templateid")
    private String id;
    private String host;
    private String description;
    private String name;
}
