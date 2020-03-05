package com.fabrick.webapp.exception;

import org.springframework.http.HttpStatus;

public class ResourceErrorException extends RuntimeException {

  private static final long serialVersionUID = -3087819590584072396L;

  private HttpStatus code;

  public ResourceErrorException() {}

  public ResourceErrorException(String message, HttpStatus code) {
    super(message);
    this.code = code;
  }

  public ResourceErrorException(
      String message,
      Throwable cause,
      boolean enableSuppression,
      boolean writableStackTrace,
      HttpStatus code) {
    super(message, cause, enableSuppression, writableStackTrace);
    this.code = code;
  }

  public ResourceErrorException(String message, Throwable cause, HttpStatus code) {
    super(message, cause);
    this.code = code;
  }

  public ResourceErrorException(Throwable cause, HttpStatus code) {
    super(cause);
    this.code = code;
  }

  public HttpStatus getStatus() {
    return this.code;
  }
}
