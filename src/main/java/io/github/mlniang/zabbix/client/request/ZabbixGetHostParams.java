package io.github.mlniang.zabbix.client.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author Mamadou Lamine NIANG
 **/
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZabbixGetHostParams extends CommonGetParams {

    @JsonProperty("groupids")
    private List<String> groupIds;
    @JsonProperty("applicationids")
    private List<String> applicationIds;
    @JsonProperty("dserviceids")
    private List<String> discoveredServiceIds;
    @JsonProperty("graphids")
    private List<String> graphIds;
    @JsonProperty("hostids")
    private List<String> hostIds;
    @JsonProperty("httptestids")
    private List<String> givenWebChecks;
    @JsonProperty("interfaceids")
    private List<String> interfaceIds;
    @JsonProperty("itemids")
    private List<String> itemIds;
    @JsonProperty("maintenanceids")
    private List<String> maintenanceIds;
    @JsonProperty("monitored_hosts")
    private Boolean onlyMonitoredHosts;
    @JsonProperty("proxy_hosts")
    private Boolean onlyProxies;
    @JsonProperty("proxyids")
    private List<String> proxyIds;
    @JsonProperty("templated_hosts")
    private Boolean withTemplated;
    @JsonProperty("templateids")
    private List<String> templateIds;
    @JsonProperty("triggerids")
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
    private Map<String, Object> searchInventory;
}
