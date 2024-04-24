package com.paulo011.ResearchMyBook.application.exceptions.DTO;

import org.springframework.http.HttpStatus;

public record ErrorDTO(HttpStatus type, String message) {
}
