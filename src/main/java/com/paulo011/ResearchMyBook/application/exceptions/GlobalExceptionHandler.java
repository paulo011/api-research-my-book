package com.paulo011.ResearchMyBook.application.exceptions;

import com.paulo011.ResearchMyBook.application.exceptions.DTO.ErrorDTO;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorDTO> incorrectIsbnException(FeignException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDTO(HttpStatus.BAD_REQUEST, "INCORRECT ISBN"));
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<ErrorDTO> isbnNotFoundException(IndexOutOfBoundsException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(HttpStatus.NOT_FOUND, "ISBN NOT FOUND"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> isbnValidationException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDTO(HttpStatus.BAD_REQUEST, e.getMessage()));
    }
}
