package com.example.races.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DriverData {
    private String id;
    private String picture;
    private Integer age;
    private String name;
    private String team;
    private List<RaceData> races = null;
    private Float time;
    private Integer position;
}
