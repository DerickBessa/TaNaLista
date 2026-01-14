package io.github.TaNaLista.tanalista.Model;

import io.github.TaNaLista.tanalista.Model.ENUM.GuestType;

import jakarta.persistence.*;

@Entity
@Table(name = "guests")
public class Guest {

    // =========================
    // ATRIBUTOS
    // =========================

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GuestType guestType;

    // =========================
    // CONSTRUTORES
    // =========================

    protected Guest() {
    }

    public Guest(GuestType guestType) {
        this.guestType = guestType;
    }

    // =========================
    // GETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public GuestType getGuestType() {
        return guestType;
    }

    // =========================
    // REGRAS DE NEGÓCIO
    // =========================

    public void solicitarEntrada() {
        // comportamento do domínio
    }
}
