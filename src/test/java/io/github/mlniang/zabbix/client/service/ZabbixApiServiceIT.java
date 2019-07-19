package io.github.mlniang.zabbix.client.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mlniang.zabbix.client.autoconfigure.ZabbixClientAutoConfiguration;
import io.github.mlniang.zabbix.client.dto.ZabbixAuthDTO;
import io.github.mlniang.zabbix.client.exception.ZabbixApiException;
import io.github.mlniang.zabbix.client.request.JsonRPCRequest;
import io.github.mlniang.zabbix.client.response.JsonRPCResponse;
import io.github.mlniang.zabbix.client.utils.JsonMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Mamadou Lamine NIANG
 **/
@SpringBootTest(classes = {ZabbixClientAutoConfiguration.class})
@EnableAutoConfiguration
public class ZabbixApiServiceIT {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private JsonMapper jsonMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ZabbixApiService zabbixApiService;
    private MockRestServiceServer mockServer;

    @BeforeEach
    void init() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    void callShouldReturnAResult() throws Exception {
        JsonRPCRequest request = new JsonRPCRequest();
        request.setMethod("some.method");
        request.setParams(new ZabbixAuthDTO("Admin", "zabbix"));
        String mockJsonResponse = "{\"jsonrpc\":\"2.0\",\"result\":\"A Result\",\"id\":1}";
        mockServer.expect(ExpectedCount.once(), requestTo("https://github.com/mlniang/spring-zabbix-api-client/api_jsonrpc.php"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().json(objectMapper.writeValueAsString(request)))
                .andRespond(withSuccess(mockJsonResponse, MediaType.APPLICATION_JSON));
        JsonRPCResponse response = zabbixApiService.call(request);
        mockServer.verify();
        String authToken = jsonMapper.getObject(response.getResult(), String.class);
        assertThat(authToken).isEqualTo("A Result");
    }

    @Test
    void callShouldThrowZabbixExceptionIfResponseStatusNotOk() {
        org.junit.jupiter.api.Assertions.assertThrows(ZabbixApiException.class, () -> {
            JsonRPCRequest request = new JsonRPCRequest();
            request.setMethod("user.login");
            request.setParams(new ZabbixAuthDTO("Admin", "zabbix"));
            mockServer.expect(ExpectedCount.once(), requestTo("https://github.com/mlniang/spring-zabbix-api-client/api_jsonrpc.php"))
                    .andExpect(method(HttpMethod.POST))
                    .andExpect(content().json(objectMapper.writeValueAsString(request)))
                    .andRespond(withBadRequest());
            zabbixApiService.call(request);
            mockServer.verify();
        });
    }

    @Test
    void callShouldThrowZabbixExceptionIfResponseBodyContainsError() {
        org.junit.jupiter.api.Assertions.assertThrows(ZabbixApiException.class, () -> {
            String requestString = "{\"jsonrpc\":\"2.0\",\"method\":\"host.create\",\"params\":{\"host\":\"Linux server\",\"interfaces\":[{\"type\":1,\"main\":1,\"useip\":1,\"ip\":\"192.168.3.1\",\"dns\":\"\",\"port\":\"10050\"}]},\"id\":\"7\",\"auth\":\"0424bd59b807674191e7d77572075f33\"}";
            JsonRPCRequest request = objectMapper.readValue(requestString, JsonRPCRequest.class);
            String mockJsonResponse = "{\"jsonrpc\":\"2.0\",\"error\":{\"code\":-32602,\"message\":\"Invalid params.\",\"data\":\"No groups for host \\\"Linux server\\\".\"},\"id\":\"7\"}";
            mockServer.expect(ExpectedCount.once(), requestTo("https://github.com/mlniang/spring-zabbix-api-client/api_jsonrpc.php"))
                    .andExpect(method(HttpMethod.POST))
                    .andExpect(content().json(requestString))
                    .andRespond(withSuccess(mockJsonResponse, MediaType.APPLICATION_JSON));
            zabbixApiService.call(request);
            mockServer.verify();
        });
    }

    @Test
    void authenticateShouldReturnAnAuthToken() throws Exception {
        String mockJsonResponse = "{\"jsonrpc\":\"2.0\",\"result\":\"0424bd59b807674191e7d77572075f33\",\"id\":1}";
        mockServer.expect(ExpectedCount.once(), requestTo("https://github.com/mlniang/spring-zabbix-api-client/api_jsonrpc.php"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withSuccess(mockJsonResponse, MediaType.APPLICATION_JSON));
        String authToken = zabbixApiService.authenticate("Admin", "zabbix");
        mockServer.verify();
        assertThat(authToken).isEqualTo("0424bd59b807674191e7d77572075f33");
    }
}
