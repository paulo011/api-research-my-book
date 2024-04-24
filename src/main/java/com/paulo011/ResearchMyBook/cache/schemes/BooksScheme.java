package com.paulo011.ResearchMyBook.cache.schemes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "BOOKS")
public class BooksScheme {
    @Id @Column(name = "ISBN", unique = true, updatable = false)
    String isbn;
    @Column(name = "TITLE")
    String title;
    @Column(name = "SUBTITLE")
    String subtitle;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "BOOKS_AUTHOR",
            joinColumns = @JoinColumn(name = "BOOK_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
    List<AuthorScheme> authors;
    @Column(name = "PUBLISHER")
    String publisher;
    @Column(name = "SYNOPSIS", length = 1000)
    String synopsis;
    @Column(name = "DIMENSION_WIDTH")
    String dimensionWidth;
    @Column(name = "DIMENSION_HEIGHT")
    String dimensionHeight;
    @Column(name = "DIMENSION_UNIT")
    String dimensionUnit;
    @Column(name = "PUBLICATION_YEAR")
    Integer publicationYear;
    @Column(name = "FORMAT")
    String format;
    @Column(name = "PAGE_COUNT")
    Integer pageCount;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "BOOKS_SUBJECT",
            joinColumns = @JoinColumn(name = "BOOK_ID"),
            inverseJoinColumns = @JoinColumn(name = "SUBJECT_ID"))
    List<SubjectScheme> subjects;
    @Column(name = "LOCATION")
    String location;
    @Column(name = "RETAIL_PRICE")
    String retailPrice;
    @Column(name = "COVER_URL")
    String coverUrl;
    @Column(name = "PROVIDER")
    String provider;
}
