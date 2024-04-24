package com.paulo011.ResearchMyBook.application.externalApi;

import com.paulo011.ResearchMyBook.domain.useCases.DTO.BookDTO;
import com.paulo011.ResearchMyBook.domain.useCases.clientsInterface.IsbnClientInterface;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "brasilapi", url = "https://brasilapi.com.br/api/isbn/v1")
public interface IsbnClient extends IsbnClientInterface {
    @GetMapping(value = "/{isbn}")
    BookDTO findIsbn(@PathVariable("isbn") String isbn);
}
