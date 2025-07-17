package com.example.meli.util.exception;

import com.example.meli.util.exception.data.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(AppException.class)
  public ResponseEntity<ErrorResponse> handleAppException(AppException ex) {
    log.warn("AppException: {}", ex.toErrorResponse(), ex);
    return new ResponseEntity<>(ex.toErrorResponse(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
    log.warn("ResourceNotFoundException: {}", ex.toErrorResponse(), ex);
    return new ResponseEntity<>(ex.toErrorResponse(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
  log.error("Unhandled Exception: {}", ex.getMessage(), ex);
    ErrorResponse errorResponse = new ErrorResponse(
        HttpStatus.INTERNAL_SERVER_ERROR.value(), // esto se puede cambiar a un código personalizado
        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), // esto se puede cambiar por mensajes personalizados para devolver en el frontend
        "INTERNAL_SERVER_ERROR",
        List.of(ex.getMessage()),
        false
    );
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(IOException.class)
  public ResponseEntity<ErrorResponse> handleIOException(IOException ex) {
    log.error("An IOException occurred while processing a request: {}", ex.getMessage(), ex);
    ErrorResponse errorResponse = new ErrorResponse(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        "An internal server error occurred. Please try again later.",
        "I/O_ERROR",
        List.of(ex.getMessage()),
        false
    );

    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
    log.warn("Bad Request - IllegalArgumentException: {}", ex.getMessage(), ex);

    ErrorResponse errorResponse = new ErrorResponse(
        HttpStatus.BAD_REQUEST.value(),
        HttpStatus.BAD_REQUEST.getReasonPhrase(),
        "VALIDATION_ERROR",
        List.of(ex.getMessage()),
        false
    );

    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }
}
