package io.github.mlniang.zabbix.client.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * Common get method parameters.
 *
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference_commentary#common_get_method_parameters">Common "get" method parameters</a>
 * @author Mamadou Lamine NIANG
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonGetParams {

    protected Boolean countOutput;
    protected Boolean editable;
    protected Boolean excludeSearch;
    @Singular("addFilter")
    protected Map<String, Object> filter;
    protected int limit;
    protected Object output;
    @JsonProperty("preservekeys")
    protected Boolean preserveKeys;
    @Singular("addSearch")
    protected Map<String, Object> search;
    protected Boolean searchByAny;
    protected Boolean searchWildcardsEnabled;
    @JsonProperty("sortfield")
    @Singular
    protected List<String> sortFields;
    @JsonProperty("sortorder")
    @Singular("addSortOrder")
    protected List<String> sortOrder;
    protected Boolean startSearch;

}
