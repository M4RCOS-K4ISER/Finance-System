package com.example.demo.models;

import jakarta.persistence.*;

public class CartaoDeCredito extends BaseModel {
    private String nome;
    @OneToMany(mappedBy = "cartao_credito", cascade = CascadeType.ALL, orphanRemoval = true)
    private Banco banco_id;
    private float limite;
    @ManyToOne(fetch = FetchType.LAZY)//Os dados dos usuários só serão carregados se você requisitar
    @JoinColumn(name = "usuario_id")//Identifica qual a coluna da FK no BD
    private Usuario usuario_id;

    public  String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public Banco getBanco_id() {return banco_id;}
    public void setBanco_id(Banco banco_id) {this.banco_id = banco_id;}
    public float getLimite() {return limite;}
    public void setLimite(float limite) {this.limite = limite;}
    public Usuario getUsuario_id() {return usuario_id;}
    public void setUsuario_id(Usuario usuario_id) {this.usuario_id = usuario_id;}
}
