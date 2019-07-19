package io.github.mlniang.zabbix.client.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mlniang.zabbix.client.service.ZabbixApiService;
import io.github.mlniang.zabbix.client.service.ZabbixHostService;
import io.github.mlniang.zabbix.client.utils.JsonMapper;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Mamadou Lamine NIANG
 **/
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@AutoConfigureAfter({JacksonAutoConfiguration.class, RestTemplateAutoConfiguration.class})
@EnableConfigurationProperties({ZabbixApiProperties.class})
public class ZabbixClientAutoConfiguration {

    private final ZabbixApiProperties zabbixApiProperties;

    public ZabbixClientAutoConfiguration(ZabbixApiProperties zabbixApiProperties){
        this.zabbixApiProperties = zabbixApiProperties;
    }

    @Bean
    public JsonMapper jsonMapper(ObjectMapper objectMapper) {
        return new JsonMapper(objectMapper);
    }

    @Bean
    @ConditionalOnMissingBean(RestTemplate.class)
    public RestTemplate zabbixRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public ZabbixApiService zabbixApiService(JsonMapper jsonMapper, RestTemplate restTemplate) {
        return new ZabbixApiService(zabbixApiProperties, jsonMapper, restTemplate);
    }

    @Bean
    public ZabbixHostService zabbixHostService(JsonMapper jsonMapper, ZabbixApiService zabbixApiService) {
        return new ZabbixHostService(jsonMapper, zabbixApiService);
    }

}
