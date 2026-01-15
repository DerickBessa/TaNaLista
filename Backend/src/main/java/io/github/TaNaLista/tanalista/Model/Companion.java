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

    @Column(name = "user_id", nullable = false)
    private UUID userId;


    // Construtor protegido vazio
    protected Companion() {
    }

    // Construtor de domínio
    public Companion(String companionName,  UUID userId) {
        this.companionName = companionName;
        this.userId = userId;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getCompanionName() {
        return companionName;
    }


}
