package io.github.TaNaLista.tanalista.DTO;

import io.github.TaNaLista.tanalista.Model.Guest;
import io.github.TaNaLista.tanalista.Model.ENUM.GuestType;

public record GuestDTO(
        Long id,
        GuestType guestType
) {
    // Construtor para criar DTO a partir da entidade
    public GuestDTO(Guest guest) {
        this(
                guest.getId(),
                guest.getGuestType()
        );
    }

    // Método para converter DTO em entidade
    public Guest toEntity() {
        return new Guest(this.guestType);
    }
}