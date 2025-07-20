package com.example.meli.utils.exception;

import java.util.List;

import com.example.meli.utils.exception.data.response.ErrorResponse;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException {
  private final ErrorResponse errorResponse;

  public ResourceNotFoundException(String message) {
    super(message);
    this.errorResponse = new ErrorResponse(
        HttpStatus.NOT_FOUND.value(),
        "NOT_FOUND",
        "RESOURCE",
        List.of(message),
        false
    );
  }

  public ErrorResponse toErrorResponse() {
    return errorResponse;
  }
}

