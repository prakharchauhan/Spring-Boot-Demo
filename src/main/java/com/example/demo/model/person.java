package com.example.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class person {
    private final UUID id;
    @NotBlank
    private final String name;

    public person(@JsonProperty("id")UUID id, 
                  @JsonProperty("name") String name){
        this.id = id;
        this.name = name;
    }

    public UUID getID(){
        return id;
    }

    public String getName(){
        return name;
    }

}
