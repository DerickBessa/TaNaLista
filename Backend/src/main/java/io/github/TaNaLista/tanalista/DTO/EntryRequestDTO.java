package io.github.TaNaLista.tanalista.DTO;

import io.github.TaNaLista.tanalista.Model.EntryRequest;
import io.github.TaNaLista.tanalista.Model.ENUM.RequestStatus;

import java.util.UUID;

public record EntryRequestDTO(
        UUID id,
        int totalGuestCompanions,
        RequestStatus requestStatus
) {
    // Construtor para criar DTO a partir da entidade
    public EntryRequestDTO(EntryRequest entryRequest) {
        this(
                entryRequest.getId(),
                entryRequest.getTotalGuestCompanions(),
                entryRequest.getRequestStatus()
        );
    }

    // Método para converter DTO em entidade
    public EntryRequest toEntity() {
        return new EntryRequest(this.totalGuestCompanions, this.requestStatus);
    }
}