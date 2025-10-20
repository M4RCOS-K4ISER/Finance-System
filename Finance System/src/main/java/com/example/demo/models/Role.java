package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Role extends BaseModel {
    @Enumerated(EnumType.STRING)
    private String name;
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
