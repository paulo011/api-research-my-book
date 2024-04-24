package com.paulo011.ResearchMyBook.application.controllers;

import com.paulo011.ResearchMyBook.domain.useCases.DTO.BookDTO;
import com.paulo011.ResearchMyBook.domain.useCases.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final BookService bookService;

    public Controller(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/{isbn}")
    public ResponseEntity<BookDTO> findBook(@Valid @PathVariable("isbn") String isbn) throws Exception {
        BookDTO book = bookService.findBookByIsbn(isbn);
        return ResponseEntity.status(HttpStatus.OK)
                .body(book);
    }
}
