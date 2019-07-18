package io.github.mlniang.zabbix.client.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * Zabbix method host.get parameters.
 *
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/get#parameters">Method host.get parameters</a>
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "paramsBuilder", buildMethodName = "buildParams")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZabbixGetHostParams extends CommonGetParams {

    @JsonProperty("groupids")
    @Singular
    private List<String> groupIds;
    @JsonProperty("applicationids")
    @Singular
    private List<String> applicationIds;
    @JsonProperty("dserviceids")
    @Singular
    private List<String> discoveredServiceIds;
    @JsonProperty("graphids")
    @Singular
    private List<String> graphIds;
    @JsonProperty("hostids")
    @Singular
    private List<String> hostIds;
    @JsonProperty("httptestids")
    @Singular
    private List<String> givenWebChecks;
    @JsonProperty("interfaceids")
    @Singular
    private List<String> interfaceIds;
    @JsonProperty("itemids")
    @Singular
    private List<String> itemIds;
    @JsonProperty("maintenanceids")
    @Singular
    private List<String> maintenanceIds;
    @JsonProperty("monitored_hosts")
    private Boolean onlyMonitoredHosts;
    @JsonProperty("proxy_hosts")
    private Boolean onlyProxies;
    @JsonProperty("proxyids")
    @Singular
    private List<String> proxyIds;
    @JsonProperty("templated_hosts")
    private Boolean withTemplated;
    @JsonProperty("templateids")
    @Singular
    private List<String> templateIds;
    @JsonProperty("triggerids")
    @Singular
    private List<String> triggerIds;
    @JsonProperty("with_items")
    private Boolean withItems;
    @JsonProperty("with_applications")
    private Boolean withApplications;
    @JsonProperty("with_graphs")
    private Boolean withGraphs;
    @JsonProperty("with_httptests")
    private Boolean withHttpTests;
    @JsonProperty("with_monitored_httptests")
    private Boolean withMonitoredHttpTests;
    @JsonProperty("with_monitored_items")
    private Boolean withMonitoredItems;
    @JsonProperty("with_monitored_triggers")
    private Boolean withMonitoredTriggers;
    @JsonProperty("with_simple_graph_items")
    private Boolean withSimpleGraphItems;
    @JsonProperty("with_triggers")
    private Boolean withTriggers;
    @JsonProperty("withInventory")
    private Boolean withInventory;
    private Object selectGroups;
    private Object selectApplications;
    private Object selectDiscoveries;
    private Object selectDiscoveryRule;
    private Object selectGraphs;
    private Object selectHostDiscovery;
    private Object selectHttpTests;
    private Object selectInterfaces;
    private Object selectInventory;
    private Object selectItems;
    private Object selectMacros;
    private Object selectParentTemplates;
    private Object selectScreens;
    private Object selectTriggers;
    private int limitSelects;
    @Singular("addSearchInventory")
    private Map<String, Object> searchInventory;
}
