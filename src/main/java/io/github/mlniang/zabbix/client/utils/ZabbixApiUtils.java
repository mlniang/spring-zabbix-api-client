package io.github.mlniang.zabbix.client.utils;

import io.github.mlniang.zabbix.client.model.IZabbixMethod;
import io.github.mlniang.zabbix.client.request.JsonRPCRequest;

/**
 * @author Mamadou Lamine NIANG
 **/
public final class ZabbixApiUtils {

    public static final String API_ENDPOINT = "/api_jsonrpc.php";

    private ZabbixApiUtils() {}

    public static JsonRPCRequest buildRequest(IZabbixMethod method, Object params, String auth) {
        JsonRPCRequest request = new JsonRPCRequest();
        request.setMethod(method.getValue());
        request.setAuth(auth);
        request.setParams(params);
        return request;
    }
}
