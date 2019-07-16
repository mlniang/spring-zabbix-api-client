package io.github.mlniang.zabbix.client.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author Mamadou Lamine NIANG
 **/
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class CommonGetParams {

    protected Boolean countOutput;
    protected Boolean editable;
    protected Boolean excludeSearch;
    protected Map<String, Object> filter;
    protected int limit;
    protected Object output;
    @JsonProperty("preservekeys")
    protected Boolean preserveKeys;
    protected Map<String, Object> search;
    protected Boolean searchByAny;
    protected Boolean searchWildcardsEnabled;
    @JsonProperty("sortfield")
    protected List<String> sortFields;
    @JsonProperty("sortorder")
    protected List<String> sortOrder;
    protected Boolean startSearch;

}
