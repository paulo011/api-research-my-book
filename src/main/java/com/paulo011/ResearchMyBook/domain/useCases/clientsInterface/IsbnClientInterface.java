package com.paulo011.ResearchMyBook.domain.useCases.clientsInterface;

import com.paulo011.ResearchMyBook.domain.useCases.DTO.BookDTO;

public interface IsbnClientInterface {
    BookDTO findIsbn(String isbn);
}
