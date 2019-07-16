package io.github.mlniang.zabbix.client.utils;

import io.github.mlniang.zabbix.client.dto.ZabbixHostDTO;
import io.github.mlniang.zabbix.client.request.ZabbixGetHostParams;
import io.github.mlniang.zabbix.client.request.ZabbixRequest;

import java.util.List;

/**
 * @author Mamadou Lamine NIANG
 **/
public class ZabbixHostUtils {

    private ZabbixHostUtils() {}

    public static enum Method {

        CREATE("host.create"),
        DELETE("host.delete"),
        GET("host.get"),
        MASS_ADD("host.massadd"),
        MASS_REMOVE("host.massremove"),
        MASS_UPDATE("host.massupdate"),
        UPDATE("host.massupdate");

        private String value;

        Method(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public static ZabbixRequest buildRequest(Method method, List<ZabbixHostDTO> dtos, String auth) {
        ZabbixRequest request = new ZabbixRequest();
        request.setMethod(method.getValue());
        request.setAuth(auth);
        request.setParams(dtos);
        return request;
    }

    public static ZabbixRequest buildRequest(ZabbixGetHostParams params, String auth) {
        ZabbixRequest request = new ZabbixRequest();
        request.setMethod(Method.GET.getValue());
        request.setAuth(auth);
        request.setParams(params);
        return request;
    }
}
