package com.paulo011.ResearchMyBook.domain.useCases.service;

import com.paulo011.ResearchMyBook.domain.entities.Author;
import com.paulo011.ResearchMyBook.domain.entities.Book;
import com.paulo011.ResearchMyBook.domain.entities.Subject;
import com.paulo011.ResearchMyBook.domain.useCases.DTO.BookDTO;
import com.paulo011.ResearchMyBook.domain.useCases.clientsInterface.IsbnClientInterface;
import com.paulo011.ResearchMyBook.domain.useCases.repositoriesInterface.BookRepositoryInterface;

import java.util.Optional;

public class BookService {
    private final IsbnClientInterface isbnClient;
    private final BookRepositoryInterface bookRepository;

    public BookService(IsbnClientInterface isbnClient, BookRepositoryInterface bookRepository) {
        this.isbnClient = isbnClient;
        this.bookRepository = bookRepository;
    }

    private static void isbnValidator(String isbn) throws Exception{
        isbn = isbn.replaceAll("[\\s-]+", "");
        if (isbn.length() != 10 && isbn.length() != 13)
            throw new Exception("ISBN with invalid size");
    }

    public BookDTO findBookByIsbn(String isbn) throws Exception{
        isbnValidator(isbn);
        Optional<Book> optionalBook = bookRepository.findByIsbn(isbn);

        if(optionalBook.isEmpty()){
            BookDTO bookDTO = isbnClient.findIsbn(isbn);
            var width = bookDTO.dimensions() == null ? " " : bookDTO.dimensions().width();
            var height = bookDTO.dimensions() == null ? " " : bookDTO.dimensions().height();
            var unit = bookDTO.dimensions() == null ? " " : bookDTO.dimensions().unit();
            bookRepository.save(new Book(
                    bookDTO.isbn(),
                    bookDTO.title(),
                    bookDTO.subtitle(),
                    bookDTO.authors().stream().map(Author::new).toList(),
                    bookDTO.publisher(),
                    bookDTO.synopsis(),
                    width,
                    height,
                    unit,
                    bookDTO.year(),
                    bookDTO.format(),
                    bookDTO.pageCount(),
                    bookDTO.subjects().stream().map(Subject::new).toList(),
                    bookDTO.location(),
                    bookDTO.retailPrice(),
                    bookDTO.coverUrl(),
                    bookDTO.provider()));
            return bookDTO;
        }
        return new BookDTO(optionalBook.get());
    }
}
