package com.fabrick.webapp.utility;

import org.springframework.http.HttpHeaders;

/** @author Spagnuolo Roberto on 03/03/20 */
public class InitHeaders {

  public InitHeaders() {}

  public HttpHeaders invoke() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Auth-Schema", "S2S");
    headers.add("X-Time-Zone", "Europe/Rome");
    headers.add("Content-Type", "application/json");
    headers.add("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
//    headers.add("Accept", "application/json");
    return headers;
  }
}
