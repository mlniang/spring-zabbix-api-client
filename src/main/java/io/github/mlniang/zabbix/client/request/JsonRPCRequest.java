package io.github.mlniang.zabbix.client.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Represents a request object as defined by the <a href="https://www.jsonrpc.org/specification#request_object">JSON-RPC 2.0 specification</a>.
 *
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
public class JsonRPCRequest {

    private final String jsonrpc = "2.0";
    @NotBlank(message = "Please provide the method.")
    private String method;
    @NotNull(message = "Please provide the parameters of the request.")
    private Object params;
    private String id = UUID.randomUUID().toString();
    private String auth;
}
