package io.github.mlniang.zabbix.client.service;

import io.github.mlniang.zabbix.client.autoconfigure.ZabbixApiProperties;
import io.github.mlniang.zabbix.client.dto.ZabbixAuthDTO;
import io.github.mlniang.zabbix.client.exception.ZabbixApiException;
import io.github.mlniang.zabbix.client.request.JsonRPCRequest;
import io.github.mlniang.zabbix.client.response.JsonRPCResponse;
import io.github.mlniang.zabbix.client.utils.JsonMapper;
import io.github.mlniang.zabbix.client.utils.ZabbixApiUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Objects;

/**
 * Main service making requests to Zabbix API.
 * @author Mamadou Lamine NIANG
 **/
@Service
@Slf4j
public class ZabbixApiService {

    private final ZabbixApiProperties properties;
    private final JsonMapper jsonMapper;
    private final RestTemplate restTemplate;
    private final HttpHeaders headers;

    public ZabbixApiService(ZabbixApiProperties zabbixApiProperties, JsonMapper jsonMapper) {
        this.properties = zabbixApiProperties;
        this.jsonMapper = jsonMapper;
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    /**
     * Makes a call to Zabbix API
     * @param request               The request object.
     * @return                      A JSON RPC 2.0 response object.
     * @throws ZabbixApiException   When the response status is not 200 or the API returned an error.
     */
    public JsonRPCResponse call(@Valid JsonRPCRequest request) throws ZabbixApiException {
        HttpEntity<JsonRPCRequest> httpEntity = new HttpEntity<>(request, headers);
        String apiUrl = properties.getUrl() + ZabbixApiUtils.API_ENDPOINT;
        log.debug("Making request to {} with body: {}", apiUrl, request);
        ResponseEntity<JsonRPCResponse> response = restTemplate.postForEntity(apiUrl, httpEntity, JsonRPCResponse.class);
        if(response.getStatusCodeValue() != 200) {
            throw new ZabbixApiException(response.getStatusCodeValue());
        }
        if(!response.hasBody()) {
            throw new ZabbixApiException("Empty body received!");
        }
        JsonRPCResponse body = response.getBody();
        if(Objects.requireNonNull(body).isError()) {
            throw new ZabbixApiException(body.getError());
        }
        return body;
    }

    /**
     * Gets an authentication token from Zabbix
     * @param user                  The Zabbix user
     * @param password              The password
     * @return                      The auth token
     * @throws ZabbixApiException   When the response status is not 200 or the API returned an error.
     */
    public String authenticate(String user, String password) throws ZabbixApiException {
        JsonRPCRequest request = new JsonRPCRequest();
        request.setMethod("user.login");
        request.setParams(new ZabbixAuthDTO(user, password));

        JsonRPCResponse response = call(request);

        return jsonMapper.getObject(response.getResult(), String.class);
    }
}
