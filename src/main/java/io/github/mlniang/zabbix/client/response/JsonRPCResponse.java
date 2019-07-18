package io.github.mlniang.zabbix.client.response;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a response object as defined by the <a href="https://www.jsonrpc.org/specification#response_object">JSON-RPC 2.0 specification</a>.
 *
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
public class JsonRPCResponse {

    private final String jsonrpc = "2.0";
    private JsonNode result;
    private JsonRPCError error;
    private String id;

    public boolean isError() {
        return this.error != null;
    }
}
