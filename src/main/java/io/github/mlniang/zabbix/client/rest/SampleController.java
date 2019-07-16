package io.github.mlniang.zabbix.client.rest;

import io.github.mlniang.zabbix.client.dto.ZabbixAuthDTO;
import io.github.mlniang.zabbix.client.exception.ZabbixApiException;
import io.github.mlniang.zabbix.client.service.ZabbixApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Mamadou Lamine NIANG
 **/
@RestController
@RequestMapping("/api")
public class SampleController {

    private final ZabbixApiService service;

    public SampleController(ZabbixApiService zabbixApiService) {
        this.service = zabbixApiService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody @Valid ZabbixAuthDTO dto) throws ZabbixApiException {
        return ResponseEntity.ok(service.authenticate(dto.getUser(), dto.getPassword()));
    }
}
