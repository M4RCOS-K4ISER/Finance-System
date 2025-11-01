package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel{
    @NotBlank
    @Column(nullable = false)
    private String name;
    @NotBlank
    @Column(nullable = false)
    private String email;
    @NotBlank
    @Column(nullable = false)
    private String cpf;
    @NotBlank
    @Column(nullable = false)
    private String pass_hash;
    @NotBlank
    @Column(nullable = false)
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name="users_roles",
        joinColumns = @JoinColumn(name="user_id"),
        inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public String getPass_hash() {return pass_hash;}
    public void setPass_hash(String senha) {this.pass_hash = senha;}
    public List<Role> getRoles() {return roles;}
    public void setRoles(@NotBlank List<Role> roles) {this.roles = roles;}
}
