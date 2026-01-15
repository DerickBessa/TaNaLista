package io.github.TaNaLista.tanalista.DTO;

import io.github.TaNaLista.tanalista.Model.Companion;

import java.util.UUID;

public record CompanionDTO(
        UUID id,
        String companionName
) {
    // Construtor para criar DTO a partir da entidade
    public CompanionDTO(Companion companion) {
        this(
                companion.getId(),
                companion.getCompanionName()
        );
    }

    // Método para converter DTO em entidade
    public Companion toEntity() {
        return new Companion(this.companionName);
    }
}