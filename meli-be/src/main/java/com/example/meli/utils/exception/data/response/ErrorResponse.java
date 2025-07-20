package com.example.meli.utils.exception.data.response;

import java.util.List;

public record ErrorResponse(
    Integer code,
    String reason,
    String source,
    List<String> errors,
    boolean hideModalError
) {
}