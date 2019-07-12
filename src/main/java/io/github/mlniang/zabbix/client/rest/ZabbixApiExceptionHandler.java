package io.github.mlniang.zabbix.client.rest;

import io.github.mlniang.zabbix.client.exception.ZabbixApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Mamadou Lamine NIANG
 **/
@RestControllerAdvice
@Slf4j
public class ZabbixApiExceptionHandler {

    @ExceptionHandler(ZabbixApiException.class)
    public final ResponseEntity<String> handleApiException(ZabbixApiException e) {
        log.error("Exception using Zabbix Api", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
