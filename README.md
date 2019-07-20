# spring-zabbix-api-client
Helper Library for using Zabbix API from a Spring Boot application based on the [Zabbix API version 4.0](https://www.zabbix.com/documentation/4.0/manual/api).

[![Build Status](https://travis-ci.org/mlniang/spring-zabbix-api-client.svg?branch=master)](https://travis-ci.org/mlniang/spring-zabbix-api-client)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.mlniang/spring-zabbix-api-client/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.mlniang/spring-zabbix-api-client)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
<!---[![Dependency Status](https://www.versioneye.com/user/projects/57cafb94939fc6004abe4b21/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/57cafb94939fc6004abe4b21)--->

## Usage
Set the property `zabbix.api.url` in your properties file as the URL of the Zabbix Server (without `/api_jsonrpc.php`).

The `ZabbixApiService` offers a general method you can use to make calls to the API. Example:


 ```java
import io.github.mlniang.zabbix.client.exception.ZabbixApiException;
import io.github.mlniang.zabbix.client.request.CommonGetParams;
import io.github.mlniang.zabbix.client.response.JsonRPCResponse;
import io.github.mlniang.zabbix.client.service.ZabbixApiService;
import org.springframework.stereotype.Component;

@Component
public class TestClass {

    private final ZabbixApiService zabbixApiService;

    public TestClass(ZabbixApiService zabbixApiService) {
        this.zabbixApiService = zabbixApiService;
    }

    public JsonRPCResponse testCall() throws ZabbixApiException {
        CommonGetParams params = CommonGetParams.builder()
                .output("extended")
                .build();
        return zabbixApiService.call("host.get", params, "0424bd59b807674191e7d77572075f33");
    }
}
```

It contains also a shortcut method for authentication (`zabbixApiService.authenticate("user", "password")`).

The `ZabbixHostService` is just a helper class built for Zabbix Host method.

## Next Steps
* Build more helpers.
* Propose caching user auth tokens ?
