package com.example.races.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RaceData {
    private String name;
    private String time;
    private Integer position;
}
