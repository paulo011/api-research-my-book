package com.paulo011.ResearchMyBook.domain.entities;

import java.util.List;

public record Book(String isbn,
                   String title,
                   String subtitle,
                   List<Author> authors,
                   String publisher,
                   String synopsis,
                   String dimensionWidth,
                   String dimensionHeight,
                   String dimensionUnit,
                   Integer publicationYear,
                   String format,
                   Integer pageCount,
                   List<Subject> subjects,
                   String location,
                   String retailPrice,
                   String coverUrl,
                   String provider) {
}
