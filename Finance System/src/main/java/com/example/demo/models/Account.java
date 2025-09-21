package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Account extends BaseModel{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id", nullable=false)
    @NotNull
    private User user_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "banco_id", nullable = false)
    @NotNull
    private Bank bank_id;
    @NotNull
    @Column(nullable = false)
    private int numero;
    @NotNull
    @Column(nullable = false)
    private int agencia;
    @NotNull
    @Column(nullable = false)
    private TypeAccount tipo_conta;

    public User getUsuario_id() {return user_id;}
    public void setUsuario_id(User user_id) {this.user_id = user_id;}
    public Bank getBanco_id() {return bank_id;}
    public void setBanco_id(Bank bank_id) {this.bank_id = bank_id;}
    public int getNumero() {return numero;}
    public void setNumero(int numero) {this.numero = numero;}
    public int getAgencia() {return agencia;}
    public void setAgencia(int agencia) {this.agencia = agencia;}
    public TypeAccount getTipo_conta() {return tipo_conta;}
    public void setTipo_conta(TypeAccount tipo_conta) {this.tipo_conta = tipo_conta;}
}
