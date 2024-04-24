package com.paulo011.ResearchMyBook.cache.schemes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "AUTHOR")
public class AuthorScheme {
    @Id
    @JoinColumn(name = "NAME")
    private String name;
}
