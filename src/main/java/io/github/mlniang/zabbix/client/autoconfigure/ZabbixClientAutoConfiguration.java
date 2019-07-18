package io.github.mlniang.zabbix.client.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mlniang.zabbix.client.rest.ZabbixApiExceptionHandler;
import io.github.mlniang.zabbix.client.service.ZabbixApiService;
import io.github.mlniang.zabbix.client.service.ZabbixHostService;
import io.github.mlniang.zabbix.client.utils.JsonMapper;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mamadou Lamine NIANG
 **/
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@AutoConfigureAfter(JacksonAutoConfiguration.class)
@EnableConfigurationProperties({ZabbixApiProperties.class})
public class ZabbixClientAutoConfiguration {

    private final ZabbixApiProperties zabbixApiProperties;

    public ZabbixClientAutoConfiguration(ZabbixApiProperties zabbixApiProperties){
        this.zabbixApiProperties = zabbixApiProperties;
    }

    @Bean
    @ConditionalOnBean(ObjectMapper.class)
    public JsonMapper jsonMapper(ObjectMapper objectMapper) {
        return new JsonMapper(objectMapper);
    }

    @Bean
    public ZabbixApiService zabbixApiService(JsonMapper jsonMapper) {
        return new ZabbixApiService(zabbixApiProperties, jsonMapper);
    }

    @Bean
    public ZabbixHostService zabbixHostService(JsonMapper jsonMapper, ZabbixApiService zabbixApiService) {
        return new ZabbixHostService(jsonMapper, zabbixApiService);
    }

    @Bean
    public ZabbixApiExceptionHandler zabbixApiExceptionHandler() {
        return new ZabbixApiExceptionHandler();
    }

}
