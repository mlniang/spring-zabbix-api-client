package io.github.mlniang.zabbix.client.response;

import lombok.Data;

/**
 * Represents a response object as defined by the <a href="https://www.jsonrpc.org/specification#response_object">JSON-RPC 2.0 specification</a>.
 *
 * @author Mamadou Lamine NIANG
 **/
@Data
public class JsonRPCResponse {

    private final String jsonrpc;
    private Object result;
    private JsonRPCError error;
    private String id;

    public JsonRPCResponse() {
        this.jsonrpc = "2.0";
    }

    public boolean isError() {
        return this.error != null;
    }

    public <T> T getResult(Class<T> clazz) {
        return clazz.cast(result);
    }

}
