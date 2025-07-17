package com.example.meli.util.exception;


import com.example.meli.util.exception.data.response.ErrorResponse;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AppException extends RuntimeException {
  private final Integer code;
  private final String reason;
  private final String source;
  private final List<String> errors;
  private final boolean hideModalError;

  public ErrorResponse toErrorResponse() {
    return new ErrorResponse(code, reason, source, errors, hideModalError);
  }
}

