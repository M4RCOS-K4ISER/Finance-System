package com.example.demo.models;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Conta extends BaseModel{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id")
    private Usuario usuario_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "banco_id")
    private Banco banco_id;
    private int numero;
    private int agencia;
    private TipoConta tipo_conta;

    public Usuario getUsuario_id() {return usuario_id;}
    public void setUsuario_id(Usuario usuario_id) {this.usuario_id = usuario_id;}
    public Banco getBanco_id() {return banco_id;}
    public void setBanco_id(Banco banco_id) {this.banco_id = banco_id;}
    public int getNumero() {return numero;}
    public void setNumero(int numero) {this.numero = numero;}
    public int getAgencia() {return agencia;}
    public void setAgencia(int agencia) {this.agencia = agencia;}
    public TipoConta getTipo_conta() {return tipo_conta;}
    public void setTipo_conta(TipoConta tipo_conta) {this.tipo_conta = tipo_conta;}
}
