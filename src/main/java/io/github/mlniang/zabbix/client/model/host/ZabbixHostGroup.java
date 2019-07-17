package io.github.mlniang.zabbix.client.model.host;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;

import static io.github.mlniang.zabbix.client.utils.CustomJsonSerializer.BooleanNumericDeserializer;
import static io.github.mlniang.zabbix.client.utils.CustomJsonSerializer.BooleanNumericSerializer;

/**
 * Zabbix Host group object.
 *
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/hostgroup/object#host_group">Host group</a>
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
public class ZabbixHostGroup {

    @JsonProperty("groupid")
    private String id;
    private String name;
    private OriginFlag flags;
    @JsonSerialize(using = BooleanNumericSerializer.class)
    @JsonDeserialize(using = BooleanNumericDeserializer.class)
    private boolean internal;
}
