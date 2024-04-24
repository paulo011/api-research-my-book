package com.paulo011.ResearchMyBook.cache.repositories;

import com.paulo011.ResearchMyBook.cache.schemes.BooksScheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BooksScheme, String> {
}
