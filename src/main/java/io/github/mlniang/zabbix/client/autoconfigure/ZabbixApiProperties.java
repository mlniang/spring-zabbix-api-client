package io.github.mlniang.zabbix.client.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;

/**
 * @author Mamadou Lamine NIANG
 **/
@ConfigurationProperties(prefix = "zabbix.api", ignoreUnknownFields = false)
public class ZabbixApiProperties {

    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        if(!StringUtils.hasText(url)) {
            this.url = url;
        }
        if(url.endsWith("/")){
           this.url = url.substring(0, url.length() - 2);
        } else {
            this.url = url;
        }
    }

}
