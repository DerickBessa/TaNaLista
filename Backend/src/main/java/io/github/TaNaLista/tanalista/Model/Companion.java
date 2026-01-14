package io.github.TaNaLista.tanalista.Model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "companions")
public class Companion {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String companionName;

    // Construtor protegido vazio
    protected Companion() {
    }

    // Construtor de domínio
    public Companion(String companionName) {
        this.companionName = companionName;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getCompanionName() {
        return companionName;
    }
}
