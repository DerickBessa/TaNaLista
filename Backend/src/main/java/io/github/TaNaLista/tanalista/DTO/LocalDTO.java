package io.github.TaNaLista.tanalista.DTO;

import io.github.TaNaLista.tanalista.Model.Local;

public record LocalDTO(
        Long id,
        String address,
        double latitude,
        double longitude,
        String linkGoogleMaps
) {
    // Construtor para criar DTO a partir da entidade
    public LocalDTO(Local local) {
        this(
                local.getId(),
                local.getAddress(),
                local.getLatitude(),
                local.getLongitude(),
                local.getLinkGoogleMaps()
        );
    }

    // Método para converter DTO em entidade
    public Local toEntity() {
        return new Local(
                this.address,
                this.latitude,
                this.longitude,
                this.linkGoogleMaps
        );
    }
}