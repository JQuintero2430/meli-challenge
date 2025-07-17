package com.example.meli.userDetails.service.impl;

import com.example.meli.userDetails.model.UserDetailsDto;
import com.example.meli.userDetails.service.UserDetailsService;
import com.example.meli.util.exception.AppException;
import com.example.meli.util.exception.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

import static com.example.meli.util.Constants.USER_DETAILS_FILE_PATH;

@Slf4j
@Service
public class UserDetailsImpl implements UserDetailsService {
  private final ObjectMapper objectMapper;

  public UserDetailsImpl(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Override
  public UserDetailsDto getUserDetailsByUserId(Long userId) {
    String filePath = USER_DETAILS_FILE_PATH;

    if (Objects.isNull(userId)) {
      log.error("userId is null");
      throw new IllegalArgumentException("userId no puede ser null");
    }

    try (InputStream inputStream = getClass().getResourceAsStream(filePath)) {

      if (Objects.isNull(inputStream)) {
        log.warn("Archivo JSON no encontrado: {}", filePath);
        throw new ResourceNotFoundException("Archivo JSON no encontrado en " + filePath);
      }

      return objectMapper.readValue(inputStream, UserDetailsDto.class);

    } catch (IOException e) {
      log.error("Error al leer el archivo JSON: {}", e.getMessage(), e);
      throw new AppException(
          HttpStatus.INTERNAL_SERVER_ERROR.value(),
          "No se pudieron obtener los detalles del usuario.",
          "USER_SERVICE",
          List.of(e.getMessage()),
          false
      );
    }
  }
}
