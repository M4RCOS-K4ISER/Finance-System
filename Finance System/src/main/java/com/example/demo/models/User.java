package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class User extends BaseModel{
    @NotBlank
    @Column(nullable = false)
    private String nome;
    @NotBlank
    @Column(nullable = false)
    private String email;
    @NotBlank
    @Column(nullable = false)
    private String cpf;
    @NotBlank
    @Column(nullable = false)
    private String senha_hash;

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public String getSenha_hash() {return senha_hash;}
    public void setSenha_hash(String senha) {this.senha_hash = senha;}
}
