package io.github.TaNaLista.tanalista.Model;

import io.github.TaNaLista.tanalista.Model.ENUM.UserType;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    // =========================
    // ATRIBUTOS
    // =========================

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Transient
    private List<Companion> companions;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;

    // =========================
    // CONSTRUTORES
    // =========================

    // Construtor vazio (OBRIGATÓRIO para JPA)
    protected User() {
    }

    // Construtor de domínio
    public User(String name, String cpf, String email, String phone, UserType typeUser) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.userType = userType;
    }

    // =========================
    // GETTERS (SETTERS só se precisar)
    // =========================

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public UserType getTypeUser() {
        return userType;
    }

    // =========================
    // REGRAS DE NEGÓCIO (se houver)
    // =========================

    public boolean isAdmin() {
        return this.userType == UserType.ADMIN;
    }

    public boolean isManager() {
        return this.userType == UserType.ORGANIZADOR;
    }

    public boolean isGuest() {
        return this.userType == UserType.CONVIDADO;
    }


}
