package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreditCard extends BaseModel {
    @NotBlank
    @Column(nullable = false)
    private String nome;
    @OneToMany(mappedBy = "cartao_credito", cascade = CascadeType.ALL, orphanRemoval = true)
    @NotNull
    @Column(nullable = false)
    private Bank bank_id;
    @NotNull
    @Column(nullable = false)
    private float limite;
    @ManyToOne(fetch = FetchType.LAZY)//Os dados dos usuários só serão carregados se você requisitar
    @JoinColumn(name = "usuario_id")//Identifica qual a coluna da FK no BD
    @NotNull
    @Column(nullable = false)
    private User user_id;

    public  String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public Bank getBanco_id() {return bank_id;}
    public void setBanco_id(Bank bank_id) {this.bank_id = bank_id;}
    public float getLimite() {return limite;}
    public void setLimite(float limite) {this.limite = limite;}
    public User getUsuario_id() {return user_id;}
    public void setUsuario_id(User user_id) {this.user_id = user_id;}
}
