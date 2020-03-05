package com.fabrick.webapp.model.json.authentication;

/**
 * @author Spagnuolo Roberto on 12/05/19
 */

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "authParams",
        "authToken",
        "refreshToken",
        "flowToken"
})
public class AuthTokenResponseJson implements Serializable
{

    @JsonProperty("status")
    private String status;
    @JsonProperty("authParams")
    private List<AuthParam> authParams = null;
    @JsonProperty("authToken")
    private Object authToken;
    @JsonProperty("refreshToken")
    private Object refreshToken;
    @JsonProperty("flowToken")
    private String flowToken;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1129266549430544615L;

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("authParams")
    public List<AuthParam> getAuthParams() {
        return authParams;
    }

    @JsonProperty("authParams")
    public void setAuthParams(List<AuthParam> authParams) {
        this.authParams = authParams;
    }

    @JsonProperty("authToken")
    public Object getAuthToken() {
        return authToken;
    }

    @JsonProperty("authToken")
    public void setAuthToken(Object authToken) {
        this.authToken = authToken;
    }

    @JsonProperty("refreshToken")
    public Object getRefreshToken() {
        return refreshToken;
    }

    @JsonProperty("refreshToken")
    public void setRefreshToken(Object refreshToken) {
        this.refreshToken = refreshToken;
    }

    @JsonProperty("flowToken")
    public String getFlowToken() {
        return flowToken;
    }

    @JsonProperty("flowToken")
    public void setFlowToken(String flowToken) {
        this.flowToken = flowToken;
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
