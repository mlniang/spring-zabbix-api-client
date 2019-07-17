package io.github.mlniang.zabbix.client.model.host;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;

import static io.github.mlniang.zabbix.client.utils.CustomJsonSerializer.BooleanNumericDeserializer;
import static io.github.mlniang.zabbix.client.utils.CustomJsonSerializer.BooleanNumericSerializer;

/**
 * Zabbix host interface object.
 *
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/hostinterface/object#host_interface">Host interface</a>
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
public class ZabbixHostInterface {

    @JsonProperty("interfaceid")
    private String id;
    private String dns;
    @JsonProperty("hostid")
    private String hostId;
    private String ip;
    @JsonSerialize(using = BooleanNumericSerializer.class)
    @JsonDeserialize(using = BooleanNumericDeserializer.class)
    private boolean main;
    private String port;
    private InterfaceType type;
    @JsonProperty("useip")
    @JsonSerialize(using = BooleanNumericSerializer.class)
    @JsonDeserialize(using = BooleanNumericDeserializer.class)
    private boolean useIp;
    @JsonSerialize(using = BooleanNumericSerializer.class)
    @JsonDeserialize(using = BooleanNumericDeserializer.class)
    private boolean bulk = true;
}
