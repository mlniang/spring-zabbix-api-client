package io.github.mlniang.zabbix.client.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Optional;

/**
 * @author Mamadou Lamine NIANG
 **/
@ConfigurationProperties(prefix = "zabbix.api", ignoreUnknownFields = false)
public class ZabbixApiProperties {

    /**
     * URL of the Zabbix Server
     */
    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = Optional.ofNullable(url)
                .filter(str -> str.length() != 0)
                .map(str -> str.endsWith("/") ? str.substring(0, str.length() - 1) : str)
                .orElse(url);
    }

}
