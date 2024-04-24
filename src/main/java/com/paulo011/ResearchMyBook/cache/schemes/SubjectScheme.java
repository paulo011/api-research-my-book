package com.paulo011.ResearchMyBook.cache.schemes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "SUBJECT")
public class SubjectScheme {
    @Id
    @Column(name = "NAME")
    private String name;
}
