package com.example.races.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "driver")
public class Driver implements Serializable {
    @MongoId(value = FieldType.STRING)
    private String id;
    private String picture;
    private Integer age;
    private String name;
    private String team;
    private List<Race> races;
}
