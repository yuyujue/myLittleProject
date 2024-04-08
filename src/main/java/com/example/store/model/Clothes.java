package com.example.store.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Clothes {

    private String name;
    private String season;
    private String color;
    private Integer thickness;
}
