package com.fabrick.webapp.model.json.authentication;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Spagnuolo Roberto on 12/05/19
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "flowToken",
        "data"
})
public class AuthTokenJson implements Serializable
{

    @JsonProperty("flowToken")
    private String flowToken;

    @JsonProperty("data")
    private List<Datum> data = null;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    private final static long serialVersionUID = -8033569559573539370L;

    @JsonProperty("flowToken")
    public String getFlowToken() {
        return flowToken;
    }

    @JsonProperty("flowToken")
    public void setFlowToken(String flowToken) {
        this.flowToken = flowToken;
    }

    @JsonProperty("data")
    public List<Datum> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Datum> data) {
        this.data = data;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
