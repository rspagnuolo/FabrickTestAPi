package com.fabrick.webapp.exception.handler.controller;

import com.fabrick.webapp.exception.BindingException;
import com.fabrick.webapp.model.json.payment.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  private final Map<Class<?>, HttpStatus> map;
  {
    map = new HashMap<>();
    //map.put(MyExceptionClass.class, HttpStatus.FORBIDDEN);
    /* List Spring specific exceptions here as @bond-java-bond suggested */
    map.put(Exception.class, HttpStatus.INTERNAL_SERVER_ERROR);

    /* TODO */
  }


  @ExceptionHandler(BindingException.class)
  public ResponseEntity<ErrorResponse> exceptionBindingHandler(Exception ex) {
    ErrorResponse errore = new ErrorResponse();

    return new ResponseEntity<ErrorResponse>(errore, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }


  @ExceptionHandler(Exception.class)
  @ResponseStatus
  public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) throws IOException {

    HttpStatus status = map.get(ex.getClass());
    if (status == null) {
       status = map.get(Exception.class);// By default
    }

    return new ResponseEntity<ErrorResponse>(buildResponse(ex), new HttpHeaders(), status);
  }


  private ErrorResponse buildResponse(Throwable t) throws IOException {

    ObjectMapper mapper = new ObjectMapper();
    String jsonString = t.getCause().getMessage();
    jsonString = jsonString.replaceAll("(\\r|\\n|\\t)", "");
    ErrorResponse response = mapper.readValue(jsonString ,ErrorResponse.class);
    return response;
  }

  /* TODO */
}
