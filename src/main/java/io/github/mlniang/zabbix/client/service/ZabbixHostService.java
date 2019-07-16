package io.github.mlniang.zabbix.client.service;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.mlniang.zabbix.client.dto.ZabbixHostDTO;
import io.github.mlniang.zabbix.client.exception.ZabbixApiException;
import io.github.mlniang.zabbix.client.request.ZabbixGetHostParams;
import io.github.mlniang.zabbix.client.request.ZabbixRequest;
import io.github.mlniang.zabbix.client.response.ZabbixResponse;
import io.github.mlniang.zabbix.client.utils.ZabbixHostUtils;
import io.github.mlniang.zabbix.client.utils.ZabbixHostUtils.Method;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author Mamadou Lamine NIANG
 **/
@Service
@Slf4j
public class ZabbixHostService {

    private final ZabbixApiService apiService;

    public ZabbixHostService(ZabbixApiService zabbixApiService) {
        this.apiService = zabbixApiService;
    }

    public List<String> create(List<ZabbixHostDTO> dtos, String auth) throws ZabbixApiException {
        ZabbixRequest request = ZabbixHostUtils.buildRequest(Method.CREATE, dtos, auth);
        ZabbixResponse response = apiService.call(request);
        JsonNode node = response.getResult(JsonNode.class);
        return node.findValuesAsText("hostids");
    }

    public List<String> create(ZabbixHostDTO dto, String auth) throws ZabbixApiException {
        return create(Collections.singletonList(dto), auth);
    }

    public ZabbixHostDTO get(ZabbixGetHostParams params, String auth) throws ZabbixApiException {
        ZabbixRequest request = ZabbixHostUtils.buildRequest(params, auth);
        ZabbixResponse response = apiService.call(request);
        return response.getResult(ZabbixHostDTO.class);
    }
}
