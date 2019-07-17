package io.github.mlniang.zabbix.client.autoconfigure;

import io.github.mlniang.zabbix.client.rest.ZabbixApiExceptionHandler;
import io.github.mlniang.zabbix.client.service.ZabbixApiService;
import io.github.mlniang.zabbix.client.service.ZabbixHostService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mamadou Lamine NIANG
 **/
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@EnableConfigurationProperties({ZabbixApiProperties.class})
public class ZabbixClientAutoConfiguration {

    private final ZabbixApiProperties zabbixApiProperties;

    public ZabbixClientAutoConfiguration(ZabbixApiProperties zabbixApiProperties){
        this.zabbixApiProperties = zabbixApiProperties;
    }

    @Bean
    public ZabbixApiService zabbixApiService() {
        return new ZabbixApiService(zabbixApiProperties);
    }

    @Bean
    public ZabbixHostService zabbixHostService() {
        return new ZabbixHostService(zabbixApiService());
    }

    @Bean
    public ZabbixApiExceptionHandler zabbixApiExceptionHandler() {
        return new ZabbixApiExceptionHandler();
    }
}
