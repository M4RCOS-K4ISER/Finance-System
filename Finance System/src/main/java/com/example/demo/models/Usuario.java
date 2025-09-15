package com.example.demo.models;

public class Usuario extends BaseModel{
    private String nome;
    private String email;
    private String cpf;
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
