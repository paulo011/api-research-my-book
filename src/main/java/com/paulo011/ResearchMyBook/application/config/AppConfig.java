package com.paulo011.ResearchMyBook.application.config;

import com.paulo011.ResearchMyBook.application.externalApi.IsbnClient;
import com.paulo011.ResearchMyBook.cache.DAO.BookDAO;
import com.paulo011.ResearchMyBook.domain.useCases.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BookService bookService(IsbnClient isbnClient,
                                   BookDAO bookRepository) {
        return new BookService(isbnClient, bookRepository);
    }
}
