package com.paulo011.ResearchMyBook.domain.useCases.DTO;

public record DimensionsDTO(String width,
                            String height,
                            String unit) {
    public DimensionsDTO(){
        this(
                "not specified",
                "not specified",
                "not specified"
        );
    }
}
