package com.paulo011.ResearchMyBook.application.gateways;

import com.paulo011.ResearchMyBook.cache.schemes.AuthorScheme;
import com.paulo011.ResearchMyBook.cache.schemes.BooksScheme;
import com.paulo011.ResearchMyBook.cache.schemes.SubjectScheme;
import com.paulo011.ResearchMyBook.domain.entities.Author;
import com.paulo011.ResearchMyBook.domain.entities.Book;
import com.paulo011.ResearchMyBook.domain.entities.Subject;
import org.springframework.stereotype.Component;

@Component
public class BookGateway {
    public Book bookSchemeForBook(BooksScheme booksScheme){
        return new Book(
                booksScheme.getIsbn(),
                booksScheme.getTitle(),
                booksScheme.getSubtitle(),
                booksScheme.getAuthors().stream()
                        .map(authorScheme -> new Author(authorScheme.getName())).toList(),
                booksScheme.getPublisher(),
                booksScheme.getSynopsis(),
                booksScheme.getDimensionWidth(),
                booksScheme.getDimensionHeight(),
                booksScheme.getDimensionUnit(),
                booksScheme.getPublicationYear(),
                booksScheme.getFormat(),
                booksScheme.getPageCount(),
                booksScheme.getSubjects().stream()
                        .map(subjectScheme -> new Subject(subjectScheme.getName())).toList(),
                booksScheme.getLocation(),
                booksScheme.getRetailPrice(),
                booksScheme.getCoverUrl(),
                booksScheme.getProvider()
                );
    }

    public BooksScheme bookForBookScheme(Book book){
        return new BooksScheme(
                book.isbn(),
                book.title(),
                book.subtitle(),
                book.authors().stream()
                        .map(author -> new AuthorScheme(author.name())).toList(),
                book.publisher(),
                book.synopsis(),
                book.dimensionWidth(),
                book.dimensionHeight(),
                book.dimensionUnit(),
                book.publicationYear(),
                book.format(),
                book.pageCount(),
                book.subjects().stream()
                        .map(subject -> new SubjectScheme(subject.name())).toList(),
                book.location(),
                book.retailPrice(),
                book.coverUrl(),
                book.provider()
        );
    }
}
