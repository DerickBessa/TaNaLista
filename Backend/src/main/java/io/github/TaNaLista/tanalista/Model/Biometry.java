package io.github.TaNaLista.tanalista.Model;

import io.github.TaNaLista.tanalista.Model.ENUM.BiometryType;

import jakarta.persistence.*;

@Entity
@Table(name = "biometries")
public class Biometry {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BiometryType biometryType;

    @Column(nullable = false)
    private String hash;

    // Construtor protegido vazio
    protected Biometry() {
    }

    // Construtor de domínio
    public Biometry(BiometryType biometryType, String hash) {
        this.biometryType = biometryType;
        this.hash = hash;
    }

    public boolean isFace() {
        return this.biometryType == BiometryType.FACE;
    }

    public boolean isDigital() {
        return this.biometryType == BiometryType.DIGITAL;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public BiometryType getBiometryType() {
        return biometryType;
    }

    public String getHash() {
        return hash;
    }

    // Regras de negócio
    public boolean validar() {

        return true;
    }


}
