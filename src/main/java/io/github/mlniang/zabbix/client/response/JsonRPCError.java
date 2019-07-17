package io.github.mlniang.zabbix.client.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an response error object as defined by the <a href="https://www.jsonrpc.org/specification#error_object">JSON-RPC 2.0 specification</a>.
 *
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
public class JsonRPCError {

    private int code;
    private String message;
    private String data;
}
