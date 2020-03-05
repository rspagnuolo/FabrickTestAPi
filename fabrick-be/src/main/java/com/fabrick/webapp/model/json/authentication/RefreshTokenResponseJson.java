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
        "authToken"
})
public class RefreshTokenResponseJson implements Serializable
{

    @JsonProperty("authToken")
    private String authToken;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5418806776966286887L;

    @JsonProperty("authToken")
    public String getAuthToken() {
        return authToken;
    }

    @JsonProperty("authToken")
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
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
