package com.fabrick.webapp.model.json.authentication;

/**
 * @author Spagnuolo Roberto on 03/03/20
 */

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "authToken",
        "refreshToken"
})
public class RefreshTokenJson implements Serializable
{

    @JsonProperty("authToken")
    private String authToken;

    @JsonProperty("refreshToken")
    private String refreshToken;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    private final static long serialVersionUID = 297873455810521351L;

    @JsonProperty("authToken")
    public String getAuthToken() {
        return authToken;
    }

    @JsonProperty("authToken")
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @JsonProperty("refreshToken")
    public String getRefreshToken() {
        return refreshToken;
    }

    @JsonProperty("refreshToken")
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
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
