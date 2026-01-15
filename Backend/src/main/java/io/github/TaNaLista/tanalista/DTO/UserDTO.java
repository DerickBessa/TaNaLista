package io.github.TaNaLista.tanalista.DTO;

import io.github.TaNaLista.tanalista.Model.User;
import io.github.TaNaLista.tanalista.Model.ENUM.UserType;

import java.util.UUID;

public record UserDTO(
        UUID id,
        String name,
        String cpf,
        String email,
        String phone,
        UserType userType
) {
    // Construtor para criar DTO a partir da entidade
    public UserDTO(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getCpf(),
                user.getEmail(),
                user.getPhone(),
                user.getTypeUser()
        );
    }

    // Método para converter DTO em entidade
    public User toEntity() {
        return new User(
                this.name,
                this.cpf,
                this.email,
                this.phone,
                this.userType
        );
    }
}