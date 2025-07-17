package com.example.meli.seller.service.impl;

import com.example.meli.seller.model.dto.SellerDto;
import com.example.meli.seller.service.SellerService;
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

import static com.example.meli.util.Constants.SELLER_FILE_PATH;

@Slf4j
@Service
public class SellerServiceImpl implements SellerService {
  private final ObjectMapper objectMapper;

  public SellerServiceImpl(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Override
  public SellerDto getSellerDetailsDto(Long id) {
    String filePath = SELLER_FILE_PATH;

    if (Objects.isNull(id)) {
      log.error("Id is null");
      throw new IllegalArgumentException("Id no puede ser null");
    }

    try (InputStream inputStream = getClass().getResourceAsStream(filePath)) {

      if (Objects.isNull(inputStream)) {
        log.warn("Archivo JSON no encontrado: {}", filePath);
        throw new ResourceNotFoundException("Archivo JSON no encontrado en " + filePath);
      }

      return objectMapper.readValue(inputStream, SellerDto.class);

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
