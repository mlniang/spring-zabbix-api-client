package io.github.mlniang.zabbix.client;

import io.github.mlniang.zabbix.client.error.ZabbixAuthException;
import io.github.mlniang.zabbix.client.request.ZabbixAuthDTO;
import io.github.mlniang.zabbix.client.request.ZabbixRequest;
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

    private final ZabbixApiClientProperties properties;
    private final RestTemplate restTemplate;
    private final HttpHeaders headers;

    public ZabbixApiService(ZabbixApiClientProperties zabbixApiClientProperties) {
        this.properties = zabbixApiClientProperties;
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public ResponseEntity<ZabbixResponse> call(@Valid ZabbixRequest request) {
        HttpEntity<ZabbixRequest> httpEntity = new HttpEntity<>(request, headers);
        String apiUrl = properties.getUrl() + Constants.API_ENDPOINT;
        log.debug("Making request to {} with body: {}", apiUrl, request);
        return restTemplate.postForEntity(apiUrl, httpEntity, ZabbixResponse.class);
    }

    public String authenticate(String user, String password) throws ZabbixAuthException {
        ZabbixRequest request = new ZabbixRequest();
        request.setMethod("user.login");
        request.setParams(new ZabbixAuthDTO(user, password));

        ResponseEntity<ZabbixResponse> response = call(request);
        if(response.getStatusCodeValue() != 200) {
            throw new ZabbixAuthException(response.getStatusCodeValue());
        }
        if(!response.hasBody()) {
            throw new ZabbixAuthException("Empty body received!");
        }
        return response.getBody().getResult(String.class);
    }
}
