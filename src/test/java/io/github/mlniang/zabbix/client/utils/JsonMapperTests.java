package io.github.mlniang.zabbix.client.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mlniang.zabbix.client.dto.ZabbixAuthDTO;
import io.github.mlniang.zabbix.client.response.JsonRPCResponse;
import io.github.mlniang.zabbix.client.service.ZabbixHostService;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {@link JsonMapper}.
 *
 * @author Mamadou Lamine NIANG
 **/
public class JsonMapperTests {

    private ObjectMapper objectMapper = new ObjectMapper();

    private JsonMapper jsonMapper = new JsonMapper(objectMapper);

    private String[] strings = new String[]{"1", "2", "Something", "Dummy"};

    @Test
    void getObjectShouldExtractAuthDTO() throws Exception {
        JsonRPCResponse response = objectMapper.readValue(
                "{\"jsonrpc\":\"2.0\",\"result\":{\"user\":\"Admin\",\"password\":\"zabbix\"},\"id\":1}",
                JsonRPCResponse.class
        );
        ZabbixAuthDTO authDTO = jsonMapper.getObject(response.getResult(), ZabbixAuthDTO.class);
        assertThat(authDTO.getUser()).isEqualTo("Admin");
        assertThat(authDTO.getPassword()).isEqualTo("zabbix");
    }

    @Test
    void getObjectShouldExtractString() throws Exception {
        String value = RandomString.make();
        JsonRPCResponse response = objectMapper.readValue(
                "{\"jsonrpc\":\"2.0\",\"result\":\"" + value + "\",\"id\":1}",
                JsonRPCResponse.class
        );
        String result = jsonMapper.getObject(response.getResult(), String.class);
        assertThat(result).isEqualTo(value);
    }

    @Test
    void getListShouldExtractListOfAuthDTOs() throws Exception {
        String jsonString = "{\"jsonrpc\":\"2.0\",\"result\":[{\"user\":\"Admin\",\"password\":\"zabbix\"},{\"user\":\"Admin2\",\"password\":\"zabbix2\"}],\"id\":1}";
        JsonRPCResponse response = objectMapper.readValue(jsonString, JsonRPCResponse.class);
        List<ZabbixAuthDTO> authDTOs = jsonMapper.getList(response.getResult(), ZabbixAuthDTO.class);
        assertThat(authDTOs).hasSize(2);
        ZabbixAuthDTO authDTO = authDTOs.get(0);
        assertThat(authDTO.getUser()).isEqualTo("Admin");
        assertThat(authDTO.getPassword()).isEqualTo("zabbix");
        authDTO = authDTOs.get(1);
        assertThat(authDTO.getUser()).isEqualTo("Admin2");
        assertThat(authDTO.getPassword()).isEqualTo("zabbix2");
    }

    @Test
    void getListShouldExtractListOfStrings() throws Exception {
        String jsonString = "{\"jsonrpc\":\"2.0\",\"result\":[\"1\",\"2\",\"Something\",\"Dummy\"],\"id\":1}";
        JsonRPCResponse response = objectMapper.readValue(jsonString, JsonRPCResponse.class);
        List<String> results = jsonMapper.getList(response.getResult(), String.class);
        assertThat(results).containsExactly(strings);
    }

    @Test
    void getListShouldReturnEmptyList() throws Exception {
        String jsonString = "{\"jsonrpc\":\"2.0\",\"result\":[],\"id\":1}";
        JsonRPCResponse response = objectMapper.readValue(jsonString, JsonRPCResponse.class);
        List<ZabbixAuthDTO> authDTOs = jsonMapper.getList(response.getResult(), ZabbixAuthDTO.class);
        assertThat(authDTOs).isEmpty();
    }

    @Test
    void getListShouldExtractInnerListOfStrings() throws Exception {
        String jsonString = "{\"jsonrpc\":\"2.0\",\"result\":{\"hostids\":[\"1\",\"2\",\"Something\",\"Dummy\"]},\"id\":1}";
        JsonRPCResponse response = objectMapper.readValue(jsonString, JsonRPCResponse.class);
        List<String> results = jsonMapper.getList(response.getResult(), ZabbixHostService.HOSTS_IDS_NODE, String.class);
        assertThat(results).containsExactly(strings);

    }
}
