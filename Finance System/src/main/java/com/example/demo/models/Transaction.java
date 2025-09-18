package com.example.demo.models;

import java.time.LocalDate;

public class Transaction extends BaseModel{
    private String nome;
    private float valor;
    private String descricao;
    private LocalDate data;
    private User user_id;
    private CreditCard cartaoCredito_id;
    private Account account_id;

}
