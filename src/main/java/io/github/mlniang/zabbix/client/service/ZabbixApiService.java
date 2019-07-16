package io.github.mlniang.zabbix.client.service;

import io.github.mlniang.zabbix.client.Constants;
import io.github.mlniang.zabbix.client.autoconfigure.ZabbixApiProperties;
import io.github.mlniang.zabbix.client.dto.ZabbixAuthDTO;
import io.github.mlniang.zabbix.client.exception.ZabbixApiException;
import io.github.mlniang.zabbix.client.request.ZabbixRequest;
import io.github.mlniang.zabbix.client.response.ZabbixResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Collections;

/**
 * @author Mamadou Lamine NIANG
 **/
@Service
@Slf4j
public class ZabbixApiService {

    private final ZabbixApiProperties properties;
    private final RestTemplate restTemplate;
    private final HttpHeaders headers;

    public ZabbixApiService(ZabbixApiProperties zabbixApiProperties) {
        this.properties = zabbixApiProperties;
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public ZabbixResponse call(@Valid ZabbixRequest request) throws ZabbixApiException {
        HttpEntity<ZabbixRequest> httpEntity = new HttpEntity<>(request, headers);
        String apiUrl = properties.getUrl() + Constants.API_ENDPOINT;
        log.debug("Making request to {} with body: {}", apiUrl, request);
        ResponseEntity<ZabbixResponse> response = restTemplate.postForEntity(apiUrl, httpEntity, ZabbixResponse.class);
        if(response.getStatusCodeValue() != 200) {
            throw new ZabbixApiException(response.getStatusCodeValue());
        }
        if(!response.hasBody()) {
            throw new ZabbixApiException("Empty body received!");
        }
        ZabbixResponse body = response.getBody();
        if(body.isError()) {
            throw new ZabbixApiException(body.getError());
        }
        return body;
    }

    public String authenticate(String user, String password) throws ZabbixApiException {
        ZabbixRequest request = new ZabbixRequest();
        request.setMethod("user.login");
        request.setParams(new ZabbixAuthDTO(user, password));

        ZabbixResponse response = call(request);

        return response.getResult(String.class);
    }
}
