package com.paulo011.ResearchMyBook.cache.DAO;

import com.paulo011.ResearchMyBook.application.gateways.BookGateway;
import com.paulo011.ResearchMyBook.cache.repositories.BookRepository;
import com.paulo011.ResearchMyBook.cache.schemes.BooksScheme;
import com.paulo011.ResearchMyBook.domain.entities.Book;
import com.paulo011.ResearchMyBook.domain.useCases.repositoriesInterface.BookRepositoryInterface;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookDAO implements BookRepositoryInterface {
    private final BookRepository bookRepository;
    private final BookGateway bookGateway;
    public BookDAO(BookRepository bookRepository, BookGateway bookGateway){
        this.bookRepository = bookRepository;
        this.bookGateway = bookGateway;
    }

    @Override
    public void save(Book book) {
        BooksScheme booksScheme = bookGateway.bookForBookScheme(book);
        bookRepository.save(booksScheme);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        Optional<BooksScheme> booksSchemeOptional = bookRepository.findById(isbn);
        if(booksSchemeOptional.isPresent()) {
            Book book = bookGateway.bookSchemeForBook(booksSchemeOptional.get());
            return Optional.of(book);
        }else{
            return Optional.empty();
        }
    }

    @Override
    public void deleteByIsbn(String isbn) {
        Optional<BooksScheme> bookschemeOptional = bookRepository.findById(isbn);
        if(bookschemeOptional.isPresent())
            bookRepository.delete(bookschemeOptional.get());
        else
            throw new RuntimeException("Book not found");
    }
}
