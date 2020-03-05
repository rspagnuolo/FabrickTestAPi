package com.fabrick.webapp.config;

import com.fabrick.webapp.exception.handler.CustomResponseErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@Configuration
@Import({
  SwaggerConfig.class,
})
public class AppConfig {

  @Bean
  public RestTemplate restTemplate() {

    RestTemplate restTemplate = new RestTemplate();
    restTemplate.setErrorHandler(new CustomResponseErrorHandler());

    return restTemplate;
  }
}
