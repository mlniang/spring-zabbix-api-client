package io.github.mlniang.zabbix.client.service;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.mlniang.zabbix.client.dto.ZabbixHostDTO;
import io.github.mlniang.zabbix.client.dto.ZabbixMassAddHostDTO;
import io.github.mlniang.zabbix.client.dto.ZabbixMassRemoveHostDTO;
import io.github.mlniang.zabbix.client.dto.ZabbixMassUpdateHostDTO;
import io.github.mlniang.zabbix.client.exception.ZabbixApiException;
import io.github.mlniang.zabbix.client.model.host.HostMethod;
import io.github.mlniang.zabbix.client.request.JsonRPCRequest;
import io.github.mlniang.zabbix.client.request.ZabbixGetHostParams;
import io.github.mlniang.zabbix.client.response.JsonRPCResponse;
import io.github.mlniang.zabbix.client.utils.ZabbixApiUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * Service Wrapper of {@link ZabbixApiService} for host methods.
 *
 * @see ZabbixApiService
 * @author Mamadou Lamine NIANG
 **/
@Service
@Slf4j
public class ZabbixHostService {

    public static final String HOSTS_IDS_NODE = "hostids";

    private final ZabbixApiService apiService;

    public ZabbixHostService(ZabbixApiService zabbixApiService) {
        this.apiService = zabbixApiService;
    }

    /**
     * Extract hostids from response.
     * @param response  The response.
     * @return          A list of strings.
     */
    private List<String> getIdsFromResponse(JsonRPCResponse response) {
        JsonNode node = response.getResult(JsonNode.class);
        return node.findValuesAsText(HOSTS_IDS_NODE);
    }

    /**
     * Hosts creation request (<a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/create">host.create</a>).
     * @param dtos                  Hosts to create.
     * @param auth                  The auth token.
     * @return                      The list of created hosts ids.
     * @throws ZabbixApiException   When the response status is not 200 or the API returned an error.
     */
    public List<String> create(List<ZabbixHostDTO> dtos, String auth) throws ZabbixApiException {
        JsonRPCRequest request = ZabbixApiUtils.buildRequest(HostMethod.CREATE, dtos, auth);
        JsonRPCResponse response = apiService.call(request);
        return getIdsFromResponse(response);
    }

    /**
     * Single host creation request (<a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/create">host.create</a>).
     * @param dto                   Host to create.
     * @param auth                  The auth token.
     * @return                      The created host id.
     * @throws ZabbixApiException   When the response status is not 200 or the API returned an error or no host id was returned.
     */
    public String create(ZabbixHostDTO dto, String auth) throws ZabbixApiException {
        List<String> ids = create(Collections.singletonList(dto), auth);
        if(CollectionUtils.isEmpty(ids)) {
            throw new ZabbixApiException("Aucun id recu.");
        }
        return ids.get(0);
    }

    /**
     * Get hosts request (<a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/get">host.get</a>).
     * @param params                The request parameter.
     * @param auth                  The auth token.
     * @return                      A list of hostDTOs.
     * @throws ZabbixApiException   When the response status is not 200 or the API returned an error.
     */
    @SuppressWarnings("unchecked")
    public List<ZabbixHostDTO> get(ZabbixGetHostParams params, String auth) throws ZabbixApiException {
        JsonRPCRequest request = ZabbixApiUtils.buildRequest(HostMethod.GET, params, auth);
        JsonRPCResponse response = apiService.call(request);
        return (List<ZabbixHostDTO>) response.getResult();
    }

    /**
     * Delete hosts request (<a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/delete">host.delete</a>).
     * @param hostIds               IDs of hosts to delete.
     * @param auth                  The auth token.
     * @return                      The list of deleted hosts ids.
     * @throws ZabbixApiException   When the response status is not 200 or the API returned an error.
     */
    public List<String> delete(List<String> hostIds, String auth) throws ZabbixApiException {
        JsonRPCRequest request = ZabbixApiUtils.buildRequest(HostMethod.DELETE, hostIds, auth);
        JsonRPCResponse response = apiService.call(request);
        return getIdsFromResponse(response);
    }

    /**
     * Mass add hosts request (<a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/massadd">host.massadd</a>).
     * @param dto                   The request param.
     * @param auth                  The auth token.
     * @return                      The list of affected hosts ids.
     * @throws ZabbixApiException   When the response status is not 200 or the API returned an error.
     */
    public List<String> massAdd(ZabbixMassAddHostDTO dto, String auth) throws ZabbixApiException {
        JsonRPCRequest request = ZabbixApiUtils.buildRequest(HostMethod.MASS_ADD, dto, auth);
        JsonRPCResponse response = apiService.call(request);
        return getIdsFromResponse(response);
    }

    /**
     * Mass remove hosts request (<a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/massremove">host.massremove</a>).
     * @param dto                   The request param.
     * @param auth                  The auth token.
     * @return                      The list of affected hosts ids.
     * @throws ZabbixApiException   When the response status is not 200 or the API returned an error.
     */
    public List<String> massRemove(ZabbixMassRemoveHostDTO dto, String auth) throws ZabbixApiException {
        JsonRPCRequest request = ZabbixApiUtils.buildRequest(HostMethod.MASS_REMOVE, dto, auth);
        JsonRPCResponse response = apiService.call(request);
        return getIdsFromResponse(response);
    }

    /**
     * Mass update hosts request (<a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/massupdate">host.massupdate</a>).
     * @param dto                   The request param.
     * @param auth                  The auth token.
     * @return                      The list of affected hosts ids.
     * @throws ZabbixApiException   When the response status is not 200 or the API returned an error.
     */
    public List<String> massUpdate(ZabbixMassUpdateHostDTO dto, String auth) throws ZabbixApiException {
        JsonRPCRequest request = ZabbixApiUtils.buildRequest(HostMethod.MASS_UPDATE, dto, auth);
        JsonRPCResponse response = apiService.call(request);
        return getIdsFromResponse(response);
    }

    /**
     * Update hosts request (<a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/update">host.update</a>).
     * @param dto                   The request param.
     * @param auth                  The auth token.
     * @return                      The list of affected hosts ids.
     * @throws ZabbixApiException   When the response status is not 200 or the API returned an error.
     */
    public List<String> update(ZabbixHostDTO dto, String auth) throws ZabbixApiException {
        JsonRPCRequest request = ZabbixApiUtils.buildRequest(HostMethod.UPDATE, dto, auth);
        JsonRPCResponse response = apiService.call(request);
        return getIdsFromResponse(response);
    }
}
