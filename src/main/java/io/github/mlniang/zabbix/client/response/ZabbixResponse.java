package io.github.mlniang.zabbix.client.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

/**
 * @author Mamadou Lamine NIANG
 **/
@Data
public class ZabbixResponse {

    private final String jsonrpc = "2.0";
    private Object content;
    private String id;
    @JsonIgnore
    private boolean isError;

    @JsonGetter("result")
    public Object getResult() {
        return this.content;
    }

    @JsonSetter("result")
    public void setResult(Object result) {
        isError = false;
        this.content = result;
    }

    @JsonGetter("error")
    public ZabbixErrorDTO getError() {
        return (ZabbixErrorDTO) content;
    }

    @JsonSetter("error")
    public void setError(ZabbixErrorDTO error) {
        this.content = error;
        isError = true;
    }

    public boolean isError() {
        return this.isError;
    }

    public <T> T getResult(Class<T> clazz) {
        return clazz.cast(content);
    }

}
