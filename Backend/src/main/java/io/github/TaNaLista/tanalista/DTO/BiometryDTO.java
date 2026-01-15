package io.github.TaNaLista.tanalista.DTO;

import io.github.TaNaLista.tanalista.Model.ENUM.BiometryType;
import io.github.TaNaLista.tanalista.Model.Biometry;

public record BiometryDTO(
        Long id,
        BiometryType biometryType,
        String hash
) {
    // Construtor para criar DTO a partir da entidade
    public BiometryDTO(Biometry biometry) {
        this(
                biometry.getId(),
                biometry.getBiometryType(),
                biometry.getHash()
        );
    }

    // Método para converter DTO em entidade
    public Biometry toEntity() {
        return new Biometry(this.biometryType, this.hash);
    }
}