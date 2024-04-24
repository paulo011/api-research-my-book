package com.paulo011.ResearchMyBook.domain.useCases.repositoriesInterface;

import com.paulo011.ResearchMyBook.domain.entities.Book;

import java.util.Optional;

public interface BookRepositoryInterface {
    void save(Book book);
    Optional<Book> findByIsbn(String isbn);
    void deleteByIsbn(String isbn);
}
