package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseModel {
    @Enumerated(EnumType.STRING)
    private RoleName name;
    public RoleName getName() {return name;}
    public void setName(RoleName name) {this.name = name;}
}
