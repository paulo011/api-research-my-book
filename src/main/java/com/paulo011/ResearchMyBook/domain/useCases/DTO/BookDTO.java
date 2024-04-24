package com.paulo011.ResearchMyBook.domain.useCases.DTO;

import com.paulo011.ResearchMyBook.domain.entities.Author;
import com.paulo011.ResearchMyBook.domain.entities.Book;
import com.paulo011.ResearchMyBook.domain.entities.Subject;

import java.util.List;

public record BookDTO(String isbn,
                      String title,
                      String subtitle,
                      List<String> authors,
                      String publisher,
                      String synopsis,
                      DimensionsDTO dimensions,
                      Integer year,
                      String format,
                      Integer pageCount,
                      List<String> subjects,
                      String location,
                      String retailPrice,
                      String coverUrl,
                      String provider) {
    public BookDTO(Book book){
        this(
                book.isbn(),
                book.title(),
                book.subtitle(),
                book.authors().stream().map(Author::name).toList(),
                book.publisher(),
                book.synopsis(),
                new DimensionsDTO(book.dimensionWidth(), book.dimensionHeight(), book.dimensionUnit()),
                book.publicationYear(),
                book.format(),
                book.pageCount(),
                book.subjects().stream().map(Subject::name).toList(),
                book.location(),
                book.retailPrice(),
                book.coverUrl(),
                book.provider()
        );
    }
}
