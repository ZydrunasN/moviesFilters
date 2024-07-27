package com.example.moviesfilters.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FilterDto {
    private String title;
    private String runtimeOptions;
    private int runtime;
}
