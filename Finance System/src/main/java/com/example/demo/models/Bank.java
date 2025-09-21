package com.example.demo.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Bank extends BaseModel {
    @NotBlank
    @Column(nullable = false)
    private String nome;

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
}
